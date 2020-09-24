<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Exemplo JSP</title>
</head>
<body>

<% String msg1 = "uma mensagem"; %>
<h1><% out.println(msg1); %></h1>
<br />
<%= msg1 %>
<% System.out.println("Aparece só no console"); %>

</body>
</html>