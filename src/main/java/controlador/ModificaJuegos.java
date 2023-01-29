package controlador;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.*;
/**
 * Servlet implementation class LoginUsuarios
 */
@WebServlet("/ModificaJuegos")
public class ModificaJuegos extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ModificaJuegos() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**M�todo para recoger el t�tulo del juego y ver si coincide con alg�n registro de la 
	 * base de datos
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//recogemos los datos del formulario, en este caso t�tulo
		
		String tituloAntiguo = request.getParameter("tituloAntiguo");
		String titulo = request.getParameter("titulo");
		String descripcion = request.getParameter("descripcion");
		String fecha = request.getParameter("fecha");
		String plataforma = request.getParameter("plataforma");
		String imagen = request.getParameter("imagen");
		
		//creamos con ese dato un nuevo objeto Juego...
		
		Juego juego = new Juego (tituloAntiguo, titulo, descripcion, fecha, plataforma, imagen);
		
		try {
			
			juego.modificar();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//aqui pondr�amos que te dirija a una p�gina de "juego insertado, enhorabuena" y a los pocos 
		//segundos te vuelva a dirigir a la p�gina del formulario de juegos
		RequestDispatcher rd;
		
		rd = request.getRequestDispatcher("/gestionAdministrador.jsp");
		rd.forward(request, response);
	}

}
