<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, br.edu.insper.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
DAO dao = new DAO();
List<Pessoa> pessoas = dao.getLista();
%>
<table border ='1'>

<% for (Pessoa pessoa : pessoas){ %>
<tr>
<td><%= pessoa.getNome() %></td>
<td><%= pessoa.getIdade() %></td>
</tr>
<% } %>

</table>
</body>
</html>