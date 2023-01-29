package modelo;

public class Coleccion {
	
	private int id_coleccion;
	private String titulo;
	private String descripcion;
	private String plataforma;
	private String imagen;
	private int unidades;
	
	public Coleccion() {
	}

	public Coleccion(String titulo, String descripcion, String plataforma, String imagen, int unidades) {
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.plataforma = plataforma;
		this.imagen = imagen;
		this.unidades = unidades;
	}

	public Coleccion(int id_coleccion, String titulo, String descripcion, String plataforma, String imagen, int unidades) {
		this.id_coleccion = id_coleccion;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.plataforma = plataforma;
		this.imagen = imagen;
		this.unidades = unidades;
	}

	public int getId_coleccion() {
		return id_coleccion;
	}

	public void setId_coleccion(int id_coleccion) {
		this.id_coleccion = id_coleccion;
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

	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
	
	
}
