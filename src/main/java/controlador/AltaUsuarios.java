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
 * Servlet implementation class AltaUsuarios
 */
@WebServlet("/AltaUsuarios")
public class AltaUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AltaUsuarios() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String correo = request.getParameter("correo");
		String password = request.getParameter("password");
		password = getMD5(password);
		boolean permiso = false;
		
		
		
		Usuario usuario = new Usuario (nombre, apellidos, correo, password, permiso);
		
		try {
			usuario.insertar();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
	
	/**
	 * m�todo para encriptar la contrase�a con MD5 antes de enviarla a la base de datos
	 * @param input
	 * @return
	 */
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
