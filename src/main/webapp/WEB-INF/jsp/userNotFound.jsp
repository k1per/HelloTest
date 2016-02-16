<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>Sorry, we have not found user. Try one more time or get back to main page</p>
<form action="/users/findUser">
    Name to search:<br>
    <input type="text" name="name"><br>
    <input type="submit" value="search">
</form>
<c:url var="mainUrl" value="/" />
<p>Return to <a href="${mainUrl}">Main List</a></p>
</body>
</html>
