<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mohit Joshi</title>
</head>
<body>
	<form action="addAlien">
		<h1> Add Data </h1>
		<input type="text" name="aid">
		</br>
		<input type="text" name="aname">
		</br>
		<input type="text" name="tech">
		</br>
		<input type="submit">
		</br>
		</br>
		</br>
	</form>
	
	<form action="getAlien">
	<h1> Get Data </h1>
		<input type="text" name="aid">
		</br>
		<input type="submit">
		</br>
		</br>
		</br>
	</form>
	
	<form action="deleteAlien">
	<h1> Delete Data </h1>
		<input type="text" name="aid">
		</br>
		<input type="submit">
		</br>
		</br>
		</br>
	</form>
	
	<form action="displayCount">
	<h1> Get User Count </h1>
		<input type="submit">
		</br>
		</br>
		</br>
	</form>
	
	<form action="allAlien">
	<h1> All User Details </h1>
		<input type="submit">
		</br>
		</br>
		</br>
	</form>
	
	<form action="findByTech">
	<h1> Find By Tech </h1>
		<input type="text" name="tech">
		</br>
		<input type="submit">
		</br>
		</br>
		</br>
	</form>
</body>
</html>