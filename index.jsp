<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Ticket</title>
</head>
<body>
<%
String warning ="";
warning = (String)request.getAttribute("warning"); 
if(warning!=null){
	out.println(warning); 
}
%>
<h1>Let's Book</h1>
<form method="post" action="book">
<label>From:</label>
<select name="from">
	<option value="Hydrabad">Hydrabad</option>
	<option value="Banglore">Banglore</option>
	<option value="Tenali">Tenali</option>
</select>
<label>To:</label>
<select name="to">
	<option value="Hydrabad">Hydrabad</option>
	<option value="Banglore">Banglore</option>
	<option value="Tenali">Tenali</option>
</select>
<label>Date:</label>
<input type="text" name="date" />
<hr>
<h1>Personal Details</h1>
<label>Name:</label>
<input type="text" name="name" />
<label>Mobile Number:</label>
<input type="text" name="phn" />
<label>Email:</label>
<input type="text" name="email" />
<br><br>
<input type="submit" />
</form>
</body>
</html>