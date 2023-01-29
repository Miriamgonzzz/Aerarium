<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="styles/style.css">
    <link rel="stylesheet" href="styles/header.css">
    <link rel="stylesheet" href="styles/footer.css">
    <title>Document</title>
</head>
<body>

<%@include file="includes/header.jsp"%>
<%@include file="includes/navbar.jsp"%>

<h1>ESTA ES TU COLECCIÓN PERSONAL DE JUEGOS</h1>
<h1>Bienvenido/a <% out.print(session.getAttribute("nombre"));%></h1>

<%@include file="includes/footer.jsp"%>

</body>
</html>