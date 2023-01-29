package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOJuego {
	
	private Connection con = null;
	public static DAOJuego instance = null;
	
	public DAOJuego() throws SQLException{
		
		con = DBConexion.getConnection();
	}
	
	//Este es el Singleton, método que se "vomita" a si
	//mismo para acceder a todos sus atributos y métodos
	
	public static DAOJuego getInstance() throws SQLException {
		
		if (instance == null) {
			
			instance = new DAOJuego();
		}
		
		return instance;
	}
	
	/**
	 * método para insertar el juego que registremos en el formulario de alta en nuestra base de datos
	 * @param u
	 * @throws SQLException
	 */
	public void insertar(Juego j) throws SQLException {
		
		PreparedStatement ps = con.prepareStatement("INSERT INTO juego (titulo_juego, descripcion_juego, fecha_juego, plataforma_juego, imagen_juego) VALUES (?,?,?,?,?)");
		
		ps.setString(1, j.getTitulo());
		ps.setString(2, j.getDescripcion());
		ps.setString(3, j.getFecha());
		ps.setString(4, j.getPlataforma());
		ps.setString(5, j.getImagen());
		
		ps.executeUpdate();
		
		ps.close();
		
	}
	
	/**
	 * Método para buscar un juego en la base de datos dándole parte del titulo
	 * @param j
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Juego> buscar(Juego j) throws SQLException {
		
		//preparamos la query para lanzarla a la base de datos y el resultado inicializándolo en null
		String sql = "SELECT * FROM juego WHERE titulo_juego LIKE ? OR plataforma_juego LIKE ? ORDER BY titulo_juego ASC";
		Juego resultado = null;
		ArrayList<Juego> listaJuegos = new ArrayList<Juego>();
		
		try {
			//enlazamos la query con la conexión a la base de datos (con)
			PreparedStatement ps = con.prepareStatement(sql);
			
			//añadimos los datos a la query. Al ser una query con LIKE, vamos a poder buscar el
			//título del juego con una palabra o letras del título
			
			ps.setString(1, "%"+ j.getTitulo() + "%");
			ps.setString(2, "%"+ j.getPlataforma() + "%");
			
			//guardamos en el objeto ResultSet (objeto nativo de Java) el resultado de la query 
			ResultSet rs = ps.executeQuery();
			
			//si hay resultado (next() es un booleano seteado en true) guarda los datos obtenidos
			//en la variable resultado y devuelve dicho resultado para seguir trabajando con él
			
			while (rs.next()) {
				
				resultado = new Juego (rs.getInt("id_juego"), rs.getString("titulo_juego"), rs.getString("descripcion_juego"), rs.getString("fecha_juego"), rs.getString("plataforma_juego"), rs.getString("imagen_juego"));
				
				listaJuegos.add(resultado);
			}
			
			return listaJuegos;
			
		} catch (Exception e) {
			
			/* aqui habría que poner un error o una página de error de el usuario no se encuentra
			 * en la base de datos*/
			
			return listaJuegos;
			
		}
		
	}
	
	/**
	 * Método para buscar un juego en la base de datos dándole parte del titulo
	 * @param j
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Juego> buscarPlataforma(Juego j) throws SQLException {
		
		//preparamos la query para lanzarla a la base de datos y el resultado inicializándolo en null
		String sql = "SELECT * FROM juego WHERE plataforma_juego LIKE ? OR titulo_juego LIKE ? ORDER BY titulo_juego ASC";
		Juego resultado = null;
		ArrayList<Juego> listaJuegos = new ArrayList<Juego>();
		
		try {
			//enlazamos la query con la conexión a la base de datos (con)
			PreparedStatement ps = con.prepareStatement(sql);
			
			//añadimos los datos a la query. Al ser una query con LIKE, vamos a poder buscar el
			//título del juego con una palabra o letras del título
			
			ps.setString(1, "%"+ j.getPlataforma() + "%");
			ps.setString(1, "%"+ j.getTitulo() + "%");
			
			//guardamos en el objeto ResultSet (objeto nativo de Java) el resultado de la query 
			ResultSet rs = ps.executeQuery();
			
			//si hay resultado (next() es un booleano seteado en true) guarda los datos obtenidos
			//en la variable resultado y devuelve dicho resultado para seguir trabajando con él
			
			while (rs.next()) {
				
				resultado = new Juego (rs.getInt("id_juego"), rs.getString("titulo_juego"), rs.getString("descripcion_juego"), rs.getString("fecha_juego"), rs.getString("plataforma_juego"), rs.getString("imagen_juego"));
				
				listaJuegos.add(resultado);
			}
			
			return listaJuegos;
			
		} catch (Exception e) {
			
			/* aqui habría que poner un error o una página de error de el usuario no se encuentra
			 * en la base de datos*/
			
			return listaJuegos;
			
		}
		
	}
	
	/**
	 * método para modificar el juego en la base de datos
	 * @param u
	 * @return
	 * @throws SQLException
	 */
	
	public void modificar(Juego j) throws SQLException {
		
		//preparamos la query para lanzarla a la base de datos
		String sql = "UPDATE juego SET titulo_juego = ?, descripcion_juego = ?, fecha_juego = ?, plataforma_juego = ?, imagen_juego = ? WHERE titulo_juego = ?";
		
		//enlazamos la query con la conexión a la base de datos (con)
		PreparedStatement ps = con.prepareStatement(sql);
		
		//añadimos los datos requeridos a la query, que hasta ahora eran ?, tomándolos de los
		//datos introducidos en el formulario que hemos pasado en la declaración del método
		//(Juego j)
		
		ps.setString(1, j.getTitulo());
		ps.setString(2, j.getDescripcion());
		ps.setString(3, j.getFecha());
		ps.setString(4, j.getPlataforma());
		ps.setString(5, j.getImagen());
		ps.setString(6, j.getTituloAntiguo());
		
		//ejecutamos la actualización (Update) del registro en la BD
		ps.executeUpdate();
		ps.close();
			
			
		
	}
	
	public void update (Juego j) {
		
	}

}
