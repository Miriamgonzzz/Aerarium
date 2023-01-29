/**
función para comparar que las contraseñas introducidas durante el registro sean iguales
 */

function compararPassword(){
	
    let password = document.getElementById("password").value;
    let password2 = document.getElementById("password2").value;

    if( password != password2){
	alert("Los password deben ser iguales")
        return false;
    } 

document.AltaUsuario.submit();
        
}

