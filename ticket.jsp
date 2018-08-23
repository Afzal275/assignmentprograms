<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%String from = (String)request.getAttribute("from"); 
String to = (String)request.getAttribute("to");
String name = (String)request.getAttribute("name");
String phone_number = (String)request.getAttribute("phone_number");
String doj = (String)request.getAttribute("doj");
String mailid = (String)request.getAttribute("mailid");%>
<h2>Ticket Booked from <%= from%> - <%= to%></h2>
<h3> Details are name is  - <%= name%> ,  phone-number is  -  <%=phone_number %> </h3>
<h3> date of journey - <%=doj %>,  mail id is -  <%=mailid %></h3>
</body>
</html>