package ru.korenev;

import java.util.List;

/**
 * Created by k1per on 15.02.2016.
 */
public interface Dao {
    User getUserById(int id);
    User getUserByName(String name);
    List<User> getAllUsers(int pagination);
    void deleteUserById(int id);
    void updateUser(User user);
    void addUser(User user);
}
