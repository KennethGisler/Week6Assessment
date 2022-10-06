<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Make a new list</title>
</head>
<body>
	<form action = "createNewListServlet" method="post">
		ListName: <input type="text" name = "listName"><br/>
		Date Added <input type = "text" name = "month" placeholder="mm" size ="4">
		<input type = "text" name = "day" placeholder="dd" size ="4">,
		<input type = "text" name = "year" placeholder="yyyy" size ="4">
		Dealership Name: <input type="text" name= "dealershipName"><br/>
		Dealership Address: <input tpye=text name= "dealershipAddress"><br/>
		
		Available Items: <br/>
		<select name=allItemsToAdd multiple size="6">
			<c:forEach items="${requestScope.allItems}" var="currentitem">
				<option value= "${currentitem.id}"> ${currentitem.carMake} | ${currentitem.carModel} | ${currentitem.yearMade} </option>
			</c:forEach>
		</select>
		<br/>
		<input type ="submit" value = "Create List and Add Items">
	</form>
	<a href = "startpage.jsp"> Go add new items instead! </a>
</body>
</html>