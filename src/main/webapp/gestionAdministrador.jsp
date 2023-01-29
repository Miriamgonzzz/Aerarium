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
    <link rel="stylesheet" href="styles/gestionAdministrador.css">
    <script type="text/javascript" src="javascript/gestionAdministrador.js"></script>
    <title>gestionAdministrador</title>
    
    
</head>
<body>

<%@include file="includes/header.jsp"%>
<%@include file="includes/navbar.jsp"%>

<div id="sectionAdministrador">

        <div id="registroJuego">

        <h2><img id="anadir_Juego" src="images/añadir.png" alt="anadir_juego" title="Añadir Juego" width=180px></h2>
        
        <form method="post" action="AltaJuegos" enctype="multipart/form-data">
             <ul>
                <li><label>Titulo</label><input type="text" name="titulo"></li>
                <li><label>Descripción</label><textarea name="descripcion"></textarea></li>
                <li><label>Fecha</label><input type="date" name="fecha"></li>
                <li><label>Plataforma</label><select name="plataforma">
                <option value="0">...</option>
                <option value="PS4">PS4</option>
                <option value="NSW">NSW</option></select></li>
                <li><label>Imagen</label><input type="file" name="imagen"><br></li>
                <li><button value="Enviar" type="submit" name="Registro">Añadir</button></li>
            </ul>
        </form>

        </div>
        
         <div id="registroJuego">

        <h2><img id="editar_Juego" src="images/editar.png" alt="editar_juego" title="Editar Juego" width=180px></h2>
        
        <form method="post" action="BuscaJuegos" id="BuscaJuegos" name="BuscaJuegos" enctype="application/x-www-form-urlencoded">
        	 <ul>
             	<li><label>Título del juego a buscar</label><input type="text" id="tituloAntiguo" name="tituloAntiguo"></li>
        		<li><button value="Enviar" onclick="llamaJuegos()" type="button" id="Registro" name="Registro">Buscar</button></li>
            </ul>
        </form>
        
        <form method="post" action="ModificaJuegos" id="res" enctype="application/x-www-form-urlencoded">
             <ul>
             	<li><label>Titulo del juego a editar</label><input type="text" name="tituloAntiguo"></li>
                <li><label>Titulo</label><input type="text" name="titulo"></li>
                <li><label>Descripción</label><textarea name="descripcion"></textarea></li>
                <li><label>Fecha</label><input type="date" name="fecha"></li>
                <li><label>Plataforma</label><select name="plataforma">
                <option value="0">...</option>
                <option value="PS4">PS4</option>
                <option value="NSW">NSW</option></select></li>
                <li><label>Imagen</label><input type="file" name="imagen"><br></li>
                <li><button value="Enviar" type="submit" name="Registro">Modificar</button></li>
            </ul>
        </form>
        
        </div>
        
        <div id="lista">
        </div>

</div>

<%@include file="includes/footer.jsp"%>

</body>
</html>