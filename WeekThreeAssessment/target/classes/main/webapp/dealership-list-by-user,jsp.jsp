<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dealership List</title>
</head>
<body>
	<form method = "post" action = "listNavigationServlet">
		<table>
			<c:forEach items ="${requestScope.allLists}" var = "currentlist">
			<tr>
				<td><input type="radio" name="id" value = "${currentlist.id}"></td>
				<td><h2> ${currentlist.listName}</h2></td>
			</tr>
			<tr><td colspan="3"> Date Added: ${currentlist.dateAdded}</td></tr>
			<tr><td colspan="3"> DealerShip: ${currentlist.dealership.name}</td></tr>
				<c:forEach var = "listVal" items = "${currentlist.itemList}">
					<tr><td></td><td colspan="3" > ${listVal.carMake}, ${listVal.carModel}, ${listVal.yearMade} </td></tr>
				</c:forEach>
			</c:forEach>
		</table>
		<input type="submit" value = "edit" name="doThisToList">
		<input type="submit" value = "delete" name="doThisToList">
		<input type="submit" value = "add" name="doThisToList">
	</form>
	<a href="addItemsForListServelet"> Create a new List </a> <br/>
	<a href="startpage.jsp"> Insert a new Item </a>
</body>
</html>