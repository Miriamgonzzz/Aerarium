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
    <link rel="stylesheet" href="styles/biblioteca.css">
    <script type="text/javascript" src="javascript/biblioteca.js"></script>
    <title>Document</title>
</head>

<body onload="buscaTitulo()">

<%@include file="includes/header.jsp"%>
<%@include file="includes/navbar.jsp"%>

 <div id="buscadorBiblioteca">
 
        <h2><img id="buscaJuegos" src="images/buscajuego.png" alt="busca_juego" title="Busca Juego" width=260px></h2>
        <form method="post" action="BuscaJuegos" id="BuscaJuegos" name="BuscaJuegos" enctype="application/x-www-form-urlencoded">
        	 <ul>
             	<li><label><strong>Título o plataforma</strong></label><input type="text" id="tituloAntiguo" name="tituloAntiguo"></li>
        		<li><button value="Enviar" onclick="buscaTitulo()" type="button" id="Registro" name="Registro">Buscar</button></li>
            </ul>
        </form>
        
 </div>
 
 <div id="lista">
 
 </div>
 
<%@include file="includes/footer.jsp"%>

</body>

</html>