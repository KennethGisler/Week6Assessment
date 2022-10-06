<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Existing List</title>
</head>
<body>
	<form action="editListDetailsServlet" method="post">
		<input type="hidden" name ="id" value="${listToEdit.id}">
		List Name: <input type ="text" name = "listName" value="${listToEdit.listName}"><br />
		Date Added: <input type="text" name = "month" placeholder="mm" size="4" value="${month}">
		<input type="text" name = "day" placeholder="dd" size="4" value="${day}">
		<input type="text" name = "year" placeholder="yyyy" size="4" value="${year}"> <br/>
		
		Dealership Name: <input type="text" name="dealershipName" value="${listToEdit.dealership.name}"> <br/>
		Dealership Address: <input type="text" name="dealershipAddress" value="${listToEdit.dealership.address}"> <br/>
		Available Items: <br/>
		<select name=allItemsToAdd multiple size="6">
			<c:forEach items="${requestScope.allItems}" var="currentitem">
				<option value= "${currentitem.id}"> ${currentitem.carMake} | ${currentitem.carModel} | ${currentitem.yearMade} </option>
			</c:forEach>
		</select>
		<br/>
		<input type = "submit" value="Edit List and Add Items">
	</form>
	<a href = "startpage.jsp"> Go add new Items Instead!</a>
</body>
</html>