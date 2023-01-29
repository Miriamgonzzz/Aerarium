
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="styles/style.css">
    <link rel="stylesheet" href="styles/calendario.css">
    <link rel="stylesheet" href="styles/header.css">
    <link rel="stylesheet" href="styles/footer.css">
    <script type="text/javascript" src="javascript/calendario.js"></script>
    <title>Document</title>
</head>
<body>

<%@include file="includes/header.jsp"%>
<%@include file="includes/navbar.jsp"%>

<section id="calendario">

    <h1><img id="bannerCalendario" src="images/calendario.png" alt="banner_calendario" title="Banner Calendario"></h1>

    <div id="contenedor">
        <form action="#" name="buscar">
            <select id="buscames">
                <option value="0">Enero</option>
                <option value="1">Febrero</option>
                <option value="2">Marzo</option>
                <option value="3">Abril</option>
                <option value="4">Mayo</option>
                <option value="5">Junio</option>
                <option value="6">Julio</option>
                <option value="7">Agosto</option>
                <option value="8">Septiembre</option>
                <option value="9">Octubre</option>
                <option value="10">Noviembre</option>
                <option value="11">Diciembre</option>
            </select>
            <input type="text" id="buscaanno" maxlength="4" size="4">
            <input type="button" value="BUSCAR" onclick="mifecha()">
        </form>

        <div id="cabezera">
            <div id="anterior" onclick="mesantes()"> < </div>
            <div><h2 id="titulos"></h2></div>
            <div id="posterior" onclick="mesdespues()"> > </div>
        </div>
        <table id="diasc">

            <tr id="fila0"><th></th><th></th><th></th><th></th><th></th><th></th><th></th></tr>
            <tr id="fila1"><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>
            <tr id="fila2"><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>
            <tr id="fila3"><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>
            <tr id="fila4"><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>
            <tr id="fila5"><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>
            <tr id="fila6"><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>


        </table>
        <div id="pie">
            <div id="fechaactual"><i onclick="actualizar()">HOY: </i></div>
            <div>Juegos</div>

        </div>

    </div>
    
</section>

<%@include file="includes/footer.jsp"%>
