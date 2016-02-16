package ru.korenev;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * Created by k1per on 15.02.2016.
 */
@Controller
public class MainController {

    @Resource(name = "userDao")
    private UserDao dao;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String mainPage(@RequestParam(value = "page", required = false) Long page,Model model){
        if(page == null) page = 0L;
        if(page == -1) page = 0L;

       List<User> users = dao.getAllUsers(page.intValue());
        if(users.size() == 0) {
            return mainPage(page-1,model);
        }
        else {
            model.addAttribute("userAttribute", new User());
            model.addAttribute("pageNubmer", page.intValue());
            model.addAttribute("users", users);
            return "personspage";
        }
    }


    @RequestMapping(value = "/users/add", method = RequestMethod.GET)
    public String getAdd(Model model) {

        model.addAttribute("userAttribute", new User());

        // This will resolve to /WEB-INF/jsp/addpage.jsp
        return "addpage";
    }

    /**
     * Adds a new person by delegating the processing to PersonService.
     * Displays a confirmation JSP page
     *
     * @return  the name of the JSP page
     */
    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("userAttribute") User user) {

        user.setDate(new Timestamp(new Date().getTime()));
        dao.addUser(user);

        // This will resolve to /WEB-INF/jsp/addedpage.jsp
        return "addedpage";
    }

    /**
     * Deletes an existing person by delegating the processing to PersonService.
     * Displays a confirmation JSP page
     *
     * @return  the name of the JSP page
     */
    @RequestMapping(value = "/users/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value="id", required=true) Integer id,
                         Model model) {


        dao.deleteUserById(id);

        // Add id reference to Model
        model.addAttribute("id", id);

        // This will resolve to /WEB-INF/jsp/deletedpage.jsp
        return "deletedpage";
    }

    /**
     * Retrieves the edit page
     *
     * @return the name of the JSP page
     */
    @RequestMapping(value = "/users/edit", method = RequestMethod.GET)
    public String getEdit(@RequestParam(value="id", required=true) Integer id,
                          Model model) {



        model.addAttribute("userAttribute", dao.getUserById(id));

        // This will resolve to /WEB-INF/jsp/editpage.jsp
        return "editpage";
    }

    /**
     * Edits an existing person by delegating the processing to PersonService.
     * Displays a confirmation JSP page
     *
     * @return  the name of the JSP page
     */
    @RequestMapping(value = "/users/edit", method = RequestMethod.POST)
    public String saveEdit(@ModelAttribute("userAttribute") User user,
                           @RequestParam(value="id", required=true) Integer id,
                           Model model) {


        user.setId(id);

        // Delegate to PersonService for editing
        user.setDate(new Timestamp(new Date().getTime()));
        dao.updateUser(user);

        // Add id reference to Model
        model.addAttribute("id", id);

        // This will resolve to /WEB-INF/jsp/editedpage.jsp
        return "editedpage";
    }

    @RequestMapping(value = "/users/findUser", method = RequestMethod.GET)
    public String findUserByName(@RequestParam(value = "name", required = false) String string,
                         Model model) {
        if(string == null) return "personspage";

        User foundUser = dao.getUserByName(string);
        if(foundUser == null) {
            return "userNotFound";
        }

        model.addAttribute("user", foundUser);
        return "userFound";
    }
}
