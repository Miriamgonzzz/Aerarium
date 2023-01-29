<script src="javascript/navbar.js"></script>

<nav>

    <div id="navMenu">
    
	<%
	//comprobamos si el usuario ha iniciado sesion. Si la ha iniciado (el nombre no es null) y
	//el permiso es false (0) y, por tanto, usuario normal, le ponemos el siguiente navbar
	
	if(session.getAttribute("nombre") != null && (boolean)session.getAttribute("permiso") == false){
	%>
		<!-- PARTE PRIVADA DE LA WEB -->
		
   		<a class="opcionMenu" href="indexRegistrado.jsp"><img id="nav_Inicio" src="images/0.png" alt="nav_inicio" title="Nav Inicio" width=130px></a>
        <a class="opcionMenu" href="calendario.jsp"><img id="nav_Calendario" src="images/2.png" alt="nav_calendario" title="Nav Calendario" width=200px></a>
        <a class="opcionMenu" href="coleccion.jsp"><img id="nav_Coleccion" src="images/3.png" alt="nav_coleccion" title="Nav Coleccion" width=200px></a>
        <a class="opcionMenu" href="biblioteca.jsp"><img id="nav_Biblioteca" src="images/4.png" alt="nav_biblioteca" title="Nav Biblioteca" width=200px></a>
        <a class="opcionMenu" href="deseados.jsp"><img id="nav_Deseados" src="images/5.png" alt="nav_deseados" title="Nav Deseados" width=180px></a>
        <a class="opcionMenu" href="#" ><form name="logout" method="post" action="LogOut" enctype="application/x-www-form-urlencoded">
        <div onclick="logOut()">
          <img id="nav_Logout" src="images/6.png" alt="nav_logout" title="Nav Logout" width=160px>
       	</div>
   		</form></a>
    <%
    
  	//comprobamos si el usuario ha iniciado sesion. Si la ha iniciado (el nombre no es null) y
  	//el permiso es true (1) y, por tanto, usuario administrador, le ponemos el siguiente navbar
	
	}else if(session.getAttribute("nombre") != null && (boolean)session.getAttribute("permiso") == true){
	%>
	 
	  	<a class="opcionMenu" href="gestionAdministrador.jsp"><img id="nav_Deseados" src="images/1.png" alt="nav_deseados" title="Nav Deseados" width=200px></a>
        <a class="opcionMenu" href="calendario.jsp"><img id="nav_Calendario" src="images/2.png" alt="nav_calendario" title="Nav Calendario" width=200px></a>
        <a class="opcionMenu" href="coleccion.jsp"><img id="nav_Coleccion" src="images/3.png" alt="nav_coleccion" title="Nav Coleccion" width=200px></a>
        <a class="opcionMenu" href="biblioteca.jsp"><img id="nav_Biblioteca" src="images/4.png" alt="nav_biblioteca" title="Nav Biblioteca" width=200px></a>
        <a class="opcionMenu" href="deseados.jsp"><img id="nav_Deseados" src="images/5.png" alt="nav_deseados" title="Nav Deseados" width=180px></a>
        <a class="opcionMenu" href="#" ><form name="logout" method="post" action="LogOut" enctype="application/x-www-form-urlencoded">
        <div onclick="logOut()">
          <img id="nav_Logout" src="images/6.png" alt="nav_logout" title="Nav Logout" width=160px>
       	</div>
   		</form></a>
	
     <%
	}else{
		
	%>
		
        <!-- PARTE PUBLICA DE LA WEB -->
        <a class="opcionMenu" href="index.jsp"><img id="nav_Login_Registro" src="images/7.png" alt="nav_loginRegistro" title="Nav Login/Registro" width=260px></a>
        <a class="opcionMenu" href="calendario.jsp"><img id="nav_Calendario" src="images/2.png" alt="nav_calendario" title="Nav Calendario" width=200px></a>
		<a class="opcionMenu" href="usuarioNoRegistrado.jsp"><img id="nav_Coleccion" src="images/3.png" alt="nav_coleccion" title="Nav Coleccion" width=200px></a>
        <a class="opcionMenu" href="usuarioNoRegistrado.jsp"><img id="nav_Biblioteca" src="images/4.png" alt="nav_biblioteca" title="Nav Biblioteca" width=200px></a>
        <a class="opcionMenu" href="usuarioNoRegistrado.jsp"><img id="nav_Deseados" src="images/5.png" alt="nav_deseados" title="Nav Deseados" width=180px></a>
     <%
	}
	%>
	
    </div>
    
</nav>