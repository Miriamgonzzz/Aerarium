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
	
	//Este es el Singleton, m�todo que se "vomita" a si
	//mismo para acceder a todos sus atributos y m�todos
	
	public static DAOJuego getInstance() throws SQLException {
		
		if (instance == null) {
			
			instance = new DAOJuego();
		}
		
		return instance;
	}
	
	/**
	 * m�todo para insertar el juego que registremos en el formulario de alta en nuestra base de datos
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
	 * M�todo para buscar un juego en la base de datos d�ndole parte del titulo
	 * @param j
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Juego> buscar(Juego j) throws SQLException {
		
		//preparamos la query para lanzarla a la base de datos y el resultado inicializ�ndolo en null
		String sql = "SELECT * FROM juego WHERE titulo_juego LIKE ? OR plataforma_juego LIKE ? ORDER BY titulo_juego ASC";
		Juego resultado = null;
		ArrayList<Juego> listaJuegos = new ArrayList<Juego>();
		
		try {
			//enlazamos la query con la conexi�n a la base de datos (con)
			PreparedStatement ps = con.prepareStatement(sql);
			
			//a�adimos los datos a la query. Al ser una query con LIKE, vamos a poder buscar el
			//t�tulo del juego con una palabra o letras del t�tulo
			
			ps.setString(1, "%"+ j.getTitulo() + "%");
			ps.setString(2, "%"+ j.getPlataforma() + "%");
			
			//guardamos en el objeto ResultSet (objeto nativo de Java) el resultado de la query 
			ResultSet rs = ps.executeQuery();
			
			//si hay resultado (next() es un booleano seteado en true) guarda los datos obtenidos
			//en la variable resultado y devuelve dicho resultado para seguir trabajando con �l
			
			while (rs.next()) {
				
				resultado = new Juego (rs.getInt("id_juego"), rs.getString("titulo_juego"), rs.getString("descripcion_juego"), rs.getString("fecha_juego"), rs.getString("plataforma_juego"), rs.getString("imagen_juego"));
				
				listaJuegos.add(resultado);
			}
			
			return listaJuegos;
			
		} catch (Exception e) {
			
			/* aqui habr�a que poner un error o una p�gina de error de el usuario no se encuentra
			 * en la base de datos*/
			
			return listaJuegos;
			
		}
		
	}
	
	/**
	 * M�todo para buscar un juego en la base de datos d�ndole parte del titulo
	 * @param j
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Juego> buscarPlataforma(Juego j) throws SQLException {
		
		//preparamos la query para lanzarla a la base de datos y el resultado inicializ�ndolo en null
		String sql = "SELECT * FROM juego WHERE plataforma_juego LIKE ? OR titulo_juego LIKE ? ORDER BY titulo_juego ASC";
		Juego resultado = null;
		ArrayList<Juego> listaJuegos = new ArrayList<Juego>();
		
		try {
			//enlazamos la query con la conexi�n a la base de datos (con)
			PreparedStatement ps = con.prepareStatement(sql);
			
			//a�adimos los datos a la query. Al ser una query con LIKE, vamos a poder buscar el
			//t�tulo del juego con una palabra o letras del t�tulo
			
			ps.setString(1, "%"+ j.getPlataforma() + "%");
			ps.setString(1, "%"+ j.getTitulo() + "%");
			
			//guardamos en el objeto ResultSet (objeto nativo de Java) el resultado de la query 
			ResultSet rs = ps.executeQuery();
			
			//si hay resultado (next() es un booleano seteado en true) guarda los datos obtenidos
			//en la variable resultado y devuelve dicho resultado para seguir trabajando con �l
			
			while (rs.next()) {
				
				resultado = new Juego (rs.getInt("id_juego"), rs.getString("titulo_juego"), rs.getString("descripcion_juego"), rs.getString("fecha_juego"), rs.getString("plataforma_juego"), rs.getString("imagen_juego"));
				
				listaJuegos.add(resultado);
			}
			
			return listaJuegos;
			
		} catch (Exception e) {
			
			/* aqui habr�a que poner un error o una p�gina de error de el usuario no se encuentra
			 * en la base de datos*/
			
			return listaJuegos;
			
		}
		
	}
	
	/**
	 * m�todo para modificar el juego en la base de datos
	 * @param u
	 * @return
	 * @throws SQLException
	 */
	
	public void modificar(Juego j) throws SQLException {
		
		//preparamos la query para lanzarla a la base de datos
		String sql = "UPDATE juego SET titulo_juego = ?, descripcion_juego = ?, fecha_juego = ?, plataforma_juego = ?, imagen_juego = ? WHERE titulo_juego = ?";
		
		//enlazamos la query con la conexi�n a la base de datos (con)
		PreparedStatement ps = con.prepareStatement(sql);
		
		//a�adimos los datos requeridos a la query, que hasta ahora eran ?, tom�ndolos de los
		//datos introducidos en el formulario que hemos pasado en la declaraci�n del m�todo
		//(Juego j)
		
		ps.setString(1, j.getTitulo());
		ps.setString(2, j.getDescripcion());
		ps.setString(3, j.getFecha());
		ps.setString(4, j.getPlataforma());
		ps.setString(5, j.getImagen());
		ps.setString(6, j.getTituloAntiguo());
		
		//ejecutamos la actualizaci�n (Update) del registro en la BD
		ps.executeUpdate();
		ps.close();
			
			
		
	}
	
	public void update (Juego j) {
		
	}

}
