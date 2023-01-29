package controlador;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import modelo.*;
/**
 * Servlet implementation class LoginUsuarios
 */
@WebServlet("/LoginUsuarios")
public class LoginUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginUsuarios() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**M�todo para recoger los datos del formulario del Login y ver si coinciden con alg�n registro de la 
	 * base de datos
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//recogemos los datos del formulario, en este caso correo y password
		String correo = request.getParameter("correo");
		String password = request.getParameter("password");
		password = getMD5(password);
		
		
		//creamos con esos datos un nuevo objeto Usuario...
		Usuario usuario = new Usuario (correo, password);
		
		try {
			//...y le lanzamos el m�todo validar() situado en el DAOUsuario
			usuario = usuario.validar();
			
			//si el resultado que no devuelve es nulo (no est� en la base de datos) lo redirigimos
			//a la p�gina de error
			
			if (usuario == null) {
				
				RequestDispatcher rd;
				
				rd = request.getRequestDispatcher("/paginasDeError/usuarioNoRegistrado.jsp");
				rd.forward(request, response);
				
			}else {
				
				//si el usuario est� en la base de datos, iniciamos un objeto de tipo HttpSession
				//donde guardar esos datos del usuario (la sesi�n iniciada) para poder luego trabajar 
				//con ellos y redirimos al usuario a la p�gina colecci�n.jsp
			
				HttpSession session = request.getSession();
				session.setAttribute("id_usuario", usuario.getId_usuario());
				session.setAttribute("nombre", usuario.getNombre());
				session.setAttribute("apellidos", usuario.getApellidos());
				session.setAttribute("correo", usuario.getCorreo());
				session.setAttribute("permiso", usuario.getPermiso());
				
				RequestDispatcher rd;
				
				rd = request.getRequestDispatcher("/coleccion.jsp");
				rd.forward(request, response);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String getMD5(String input) {
		
		 try {
			 
			 MessageDigest md = MessageDigest.getInstance("MD5");
			 byte[] messageDigest = md.digest(input.getBytes());
			 BigInteger number = new BigInteger(1, messageDigest);
			 String hashtext = number.toString(16);

		 while (hashtext.length() < 32) {
			 
			 hashtext = "0" + hashtext;
		 }
		 
		 return hashtext;
		 }
		 
		 catch (NoSuchAlgorithmException e) {
			 
			 throw new RuntimeException(e);
		 }
	}

}
