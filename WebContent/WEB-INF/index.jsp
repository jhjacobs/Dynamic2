<%@page import="com.vogella.web.filecounter.servlet.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page autoFlush = "true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dyna 2</title>
</head>
<body>
<p> Hey how r ya <p/>
<%-- <p>Count=<%= new FileCounter() %> </p> <--%>
<form action="FileCounter" method="post">
	<input type="submit" value="Get Click Count">
</form>
<br></br>
<button onclick="document.write('<h2>Java script is functioning</h2>')">Clickery</button>
</body>
</html>