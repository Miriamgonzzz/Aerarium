package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOUsuario {
	
	private Connection con = null;
	public static DAOUsuario instance = null;
	
	public DAOUsuario() throws SQLException{
		
		con = DBConexion.getConnection();
	}
	
	//Este es el Singleton, método que se "vomita" a si
	//mismo para acceder a todos sus atributos y métodos
	
	public static DAOUsuario getInstance() throws SQLException {
		
		if (instance == null) {
			
			instance = new DAOUsuario();
		}
		
		return instance;
	}
	
	/**
	 * método para insertar el usuario que registremos en el formulario de alta en nuestra base de datos
	 * @param u
	 * @throws SQLException
	 */
	public void insertar(Usuario u) throws SQLException {
		
		PreparedStatement ps = con.prepareStatement("INSERT INTO usuario (nombre_usuario, apellidos_usuario, correo_usuario, password_usuario, permiso_usuario) VALUES (?,?,?,?,?)");
		
		ps.setString(1, u.getNombre());
		ps.setString(2, u.getApellidos());
		ps.setString(3, u.getCorreo());
		ps.setString(4, u.getPassword());
		ps.setBoolean(5, u.getPermiso());
		
		ps.executeUpdate();
		
		ps.close();
		
	}
	
	/**
	 * método para validar si el usuario introducido en el login se encuentra en la base de datos
	 * @param u
	 * @return
	 * @throws SQLException
	 */
	
	public Usuario validar(Usuario u) throws SQLException {
		
		//preparamos la query para lanzarla a la base de datos y el resultado inicializándolo en null
		String sql = "SELECT * from usuario where correo_usuario = ? and password_usuario = ?";
		Usuario resultado = null;
		
		try {
			//enlazamos la query con la conexión a la base de datos (con)
			PreparedStatement ps = con.prepareStatement(sql);
			
			//añadimos los datos requeridos a la query, que hasta ahora eran ?, tomándolos de los
			//datos introducidos en el formulario que hemos pasado en la declaración del método
			//(Usuario u)
			
			ps.setString(1, u.getCorreo());
			ps.setString(2, u.getPassword());
			
			//guardamos en el objeto ResultSet (objeto nativo de Java) el resultado de la query 
			ResultSet rs = ps.executeQuery();
			
			//si hay resultado (next() es un booleano seteado en true) guarda los datos obtenidos
			//en la variable resultado y devuelve dicho resultado para seguir trabajando con él
			if (rs.next()) {
				
				resultado = new Usuario (rs.getInt("id_usuario"), rs.getString("nombre_usuario"), rs.getString("apellidos_usuario"), rs.getString("correo_usuario"), rs.getBoolean("permiso_usuario"));
				
				
			}
			
			return resultado;
			
		} catch (Exception e) {
			
			/* aqui habría que poner un error o una página de error de el usuario no se encuentra
			 * en la base de datos*/
			
			return resultado;
			
		}
		
	}
	
	public void update (Usuario u) {
		
	}

}

