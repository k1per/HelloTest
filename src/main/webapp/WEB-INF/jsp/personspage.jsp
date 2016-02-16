<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Users page</title>
</head>
<body>
<h1>User list</h1>


<table style="border: 1px solid; width: 500px; text-align:center">
	<thead style="background:#fcf">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Age</th>
			<th>Admin</th>
			<th>Date</th>
			<th colspan="5"></th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${users}" var="user">
		<c:url var="editUrl" value="/users/edit?id=${user.id}" />
		<c:url var="deleteUrl" value="/users/delete?id=${user.id}" />
		<tr>
			<td><c:out value="${user.id}"/></td>
			<td><c:out value="${user.name}" /></td>
			<td><c:out value="${user.age}" /></td>
			<td><c:out value="${user.admin}" /></td>
			<td><c:out value="${user.date}"/></td>
			<td><a href="${editUrl}">Edit</a></td>
			<td><a href="${deleteUrl}">Delete</a></td>
		</tr>
	</c:forEach>
	</tbody>
</table>

<c:url var="findUrl" value="/users/findUser" />

<form action="/users/findUser">
	 Name to search:<br>
	<input type="text" name="name"><br>
	<input type="submit" value="search">
</form>



<c:url var="addUrl" value="/users/add" />
<td><a href="${addUrl}">Add User</a></td>
<c:url var="nextPage" value="/?page=${pageNubmer-1}"/>
<p><a href="${nextPage}">Previous page</a></p>
<c:url var="nextPage" value="/?page=${pageNubmer+1}"/>
<p><a href="${nextPage}">Next page</a></p>


</body>
</html>