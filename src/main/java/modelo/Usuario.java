package modelo;

import java.sql.SQLException;

public class Usuario {
	
	private int id_usuario;
	private String nombre;
	private String apellidos;
	private String correo;
	private String password;
	private boolean permiso;
	
	public Usuario() {
	}
	
	/**
	 * Constructor para crear un objeto Usuario con los datos del usuario que nos traemos desde la base
	 * de datos, id incluído, para trabajar posteriormente con ello (para el login, por ejemplo)
	 * 
	 * @param id_usuario
	 * @param nombre
	 * @param apellidos
	 * @param correo
	 * @param password
	 * @param permiso
	 */
	public Usuario(int id_usuario, String nombre, String apellidos, String correo, boolean permiso) {
		this.id_usuario = id_usuario;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.correo = correo;
		this.permiso = permiso;
	}
	
	/**
	 * Constructor para crear un objeto de tipo Usuario que vamos a usar para insertarlo en la base
	 * de datos una vez rellenemos los datos del formulario de registro 
	 * 
	 * @param nombre
	 * @param apellidos
	 * @param correo
	 * @param password
	 * @param permiso
	 */

	public Usuario(String nombre, String apellidos, String correo, String password, boolean permiso) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.correo = correo;
		this.password = password;
		this.permiso = permiso;
	}
	
	public Usuario(String correo, String password) {
		this.correo = correo;
		this.password = password;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getPermiso() {
		return permiso;
	}

	public void setPermiso(boolean permiso) {
		this.permiso = permiso;
	}
	
	public void insertar() throws SQLException{
		
		DAOUsuario.getInstance().insertar(this);
	}
	
	public Usuario validar() throws SQLException{
		
		return DAOUsuario.getInstance().validar(this);
		
	}
	
	

}
