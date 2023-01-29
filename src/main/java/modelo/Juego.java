package modelo;

import java.sql.SQLException;
import java.util.ArrayList;

public class Juego {

	private int id_videojuego;
	private String tituloAntiguo;
	private String titulo;
	private String descripcion;
	private String fecha;
	private String plataforma;
	private String imagen;
	
	public Juego() {
	}
	
	//constructor para buscar el juego en la base de datos por su título o plataforma
	
	public Juego(String titulo) {
		this.titulo = titulo;
		this.plataforma = titulo;
	}
	
	//constructor para recuperar desde la base de datos el objeto Juego completo
	
	public Juego(int id_videojuego, String titulo, String descripcion, String fecha, String plataforma, String imagen) {
		this.id_videojuego = id_videojuego;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.plataforma = plataforma;
		this.imagen = imagen;
	}
	
	//constructor para enviar a la base de datos desde el formulario el Juego
	
	public Juego(String titulo, String descripcion, String fecha, String plataforma, String imagen) {
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.plataforma = plataforma;
		this.imagen = imagen;
	}
	
	//constructor para modificar desde el formulario el juego por otros datos nuevos

	public Juego(String tituloAntiguo, String titulo, String descripcion, String fecha, String plataforma,
			String imagen) {
		this.tituloAntiguo = tituloAntiguo;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.plataforma = plataforma;
		this.imagen = imagen;
	}

	public int getId_videojuego() {
		return id_videojuego;
	}

	public void setId_videojuego(int id_videojuego) {
		this.id_videojuego = id_videojuego;
	}

	public String getTituloAntiguo() {
		return tituloAntiguo;
	}

	public void setTituloAntiguo(String tituloAntiguo) {
		this.tituloAntiguo = tituloAntiguo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	public void insertar() throws SQLException{
		
		DAOJuego.getInstance().insertar(this);
	}
	
	public ArrayList<Juego> buscar() throws SQLException{
		
		return DAOJuego.getInstance().buscar(this);
		
	}
	
	public void modificar() throws SQLException{
		
		DAOJuego.getInstance().modificar(this);
		
	}
	
	
	
}
