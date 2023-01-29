package controlador;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.*;
/**
 * Servlet implementation class LoginUsuarios
 */
@WebServlet("/BuscaJuegos")
public class BuscaJuegos extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public BuscaJuegos() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**M�todo para recoger los datos del formulario del Login y ver si coinciden con alg�n registro de la 
	 * base de datos
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//recogemos los datos del formulario, en este caso el titulo a buscar en la BD. Creamos tambi�n
		//un ArrayList de juegos donde vamos a meter todos los juegos de la BD que coincidan con nuestra
		//b�squeda, por si hay m�s de uno
		
		String titulo = request.getParameter("tituloAntiguo");
		ArrayList<Juego> listaJuegos = new ArrayList<Juego>();
		
		//creamos con esos datos un nuevo objeto Juego...
		Juego juego = new Juego (titulo);
		
		try {
			//...y le lanzamos el m�todo buscar() situado en el DAOUsuario que nos va a retornar el 
			//ArrayList
			listaJuegos = juego.buscar();
			
			
			//si el juego est� en la base de datos, nos va a devolver el ArrayList, por lo que
			//vamos a crear un objeto JsonObject para guardarlo y poder sacarlo por pantalla
			
			JsonObject json = new JsonObject();
			json.add("listaJuegos", new Gson().toJsonTree(listaJuegos));
			this.outputResponse(response, new Gson().toJsonTree(listaJuegos).toString(), 200);
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void outputResponse(HttpServletResponse response, String listaJuegos, int status){
		response.setHeader("Content-Type", "application/json");
	    try{
	        response.setStatus(status);
	        if (listaJuegos != null){
	            OutputStream outputStream = response.getOutputStream();
	            outputStream.write(listaJuegos.getBytes());
	            outputStream.flush();
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

}