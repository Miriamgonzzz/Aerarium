package controlador;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import modelo.*;

/**
 * Servlet implementation class AltaUsuarios
 */
@WebServlet("/AltaJuegos")
@MultipartConfig
public class AltaJuegos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String pathFiles = "C:\\Users\\SirFr\\eclipse-workspace\\Aerarium\\src\\main\\webapp\\imagenesJuegos";
	private File uploads = new File(pathFiles);

    /**
     * Default constructor. 
     */
    public AltaJuegos() {
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
		
		String titulo = request.getParameter("titulo");
		String descripcion = request.getParameter("descripcion");
		String fecha = request.getParameter("fecha");
		String plataforma = request.getParameter("plataforma");
		Part part = request.getPart("imagen");
		
		Path path = Paths.get(part.getSubmittedFileName());
		String fileName = path.getFileName().toString();
		//preparo el buffer para el guardado
		InputStream input = part.getInputStream();
		String ruta ="";
		if(input != null) {
		    //creo el archivo
		    File file = new File(uploads, fileName);
		    //obtengo la ruta para la bd
		    ruta = file.getAbsolutePath();
		    System.out.println("La ruta de la foto es: " + ruta);
		    //Copio la foto
		    try {
		        Files.copy(input, file.toPath());
		    } catch (Exception e) {
		        // TODO: handle exception
		        PrintWriter respuesta = response.getWriter();
		        respuesta.print("Error al copiar la foto");
		        System.out.println("Error al copiar la foto");
		    }
		
		
		Juego juego = new Juego (titulo, descripcion, fecha, plataforma, fileName);
		
		try {
			
			juego.insertar();
			
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

}
