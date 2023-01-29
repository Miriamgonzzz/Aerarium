/**
función para filtrar la lista de juegos por título o plataforma
 */
function buscaTitulo(){  

	
	var mydata = document.getElementById("tituloAntiguo").value;

    var request = new XMLHttpRequest();
    request.open("post", "BuscaJuegos", true);
    request.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded; charset=UTF-8');

    
    
    request.onreadystatechange = function() {
    	
      if (this.readyState == XMLHttpRequest.DONE && this.status == 200) {
        
		console.log(this.responseText);
        let datos = JSON.parse(this.responseText);
        console.log(datos);
		
		let tabla = "<table border = 1>";
    	tabla += "<tr>";
	    tabla += "<th>" + "<b>TITULO</b>" +"</th>";
	    tabla += "<th>" + "<b>DESCRIPCION</b>" +"</th>";
	    tabla += "<th>" + "<b>FECHA</b>" +"</th>";
	    tabla += "<th>" + "<b>PLATAFORMA</b>" +"</th>";
	    tabla += "<th>" + "<b>IMAGEN</b>" +"</th>";
	    tabla += "</tr>";
		let longitud = datos.length;
    	for(let i=0;i<longitud;i++){
				
	       let imagenJuego = "imagenesJuegos\\" + datos[i].imagen;
 
	            tabla += "<tr>";
	            tabla += "<td>" + datos[i].titulo + "</td>";
	            tabla += "<td>" + datos[i].descripcion + "</td>";
	            tabla += "<td>" + datos[i].fecha + "</td>";
	            tabla += "<td>" + datos[i].plataforma + "</td>";
	            tabla += "<td>" + "<img src = " + imagenJuego + ">" + "</td>";
	            tabla += "</tr>";
	        
    }
	
	tabla += "</table>";
    console.log(tabla);
    document.getElementById("lista").innerHTML =tabla;
}
        
 }

request.send("tituloAntiguo=" + mydata);
}
    