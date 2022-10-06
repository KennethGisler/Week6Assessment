<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Car Database</title>
</head>
<body>
 <form action= "addItemServlet" method="post"> 
 Car Make: <input type="text" name="make"> 
 Car Model: <input type="text" name="model">
 Car Year: <input type="text" name="year">
 <input type="submit" value="Add Car">
 </form> <br />
 <a href="viewAllListsServlet" >View the complete list</a> <br />
	<a href="addItemsForListServelet"> Create a new list!</a>
</body>
</html>