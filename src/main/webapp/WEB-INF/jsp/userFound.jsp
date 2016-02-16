<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3> We have found ${user.name} </h3>
    <p>Id: ${user.id}</p>
    <p>Age: ${user.age}</p>
    <p>Admin?: ${user.admin}</p>
    <p>Creation time: ${user.date}</p>

    <c:url var="mainUrl" value="/" />
    <p>Return to <a href="${mainUrl}">Main List</a></p>
</body>
</html>
