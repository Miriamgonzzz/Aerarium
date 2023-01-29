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
    <link rel="stylesheet" href="styles/registroLogin.css">
    <link rel="stylesheet" href="styles/header.css">
    <link rel="stylesheet" href="styles/footer.css">
    <script type="text/javascript" src="javascript/index.js"></script>
    
    <title>Document</title>
</head>
<body>

<%@include file="includes/header.jsp"%>
<%@include file="includes/navbar.jsp"%>

<div class= "contenedor" id="contenedor">

	<div id="sectionIndex">

        <div id="registro">

        <h2><img id="nav_Registrate" src="images/registro.png" alt="nav_registrate" title="Nav Registrate" width=180px></h2>
        <form method="post" name="AltaUsuario" action="AltaUsuarios" enctype="application/x-www-form-urlencoded">
             <ul>
                <li><label>Nombre</label><input type="text" name="nombre"></li>
                <li><label>Apellidos</label><input type="text" name="apellidos"></li>
                <li><label>Correo</label><input type="email" name="correo"></li>
                <li><label>Contraseña</label><input type="password" id="password" name="password"></li>
                <li><label>Confirmar contraseña</label><input type="password" id="password2" name="password2"><br></li>
                <li><button value="Enviar" type="button" onclick="compararPassword()" name="Registro">Registro</button></li>
            </ul>
        </form>

        </div>

        <div id="login">

            <h2><img id="nav_Sesion" src="images/sesion.png" alt="nav_sesion" title="Nav Sesion" width=120px></h2>
            <form method="post" action="LoginUsuarios" enctype="application/x-www-form-urlencoded">
                <ul>
                    <li><label>Correo</label><input type="email" name="correo"></li>
                    <li><label>Contraseña</label><input type="password" name="password"><br></li>
                    <li><button value="Enviar" type="submit" name="login">Login</button></li>
                </ul>
            </form>

        </div>


</div>

</div>

<%@include file="includes/footer.jsp"%>

</body>
</html>
