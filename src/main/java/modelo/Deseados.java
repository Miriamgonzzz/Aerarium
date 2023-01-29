package modelo;

public class Deseados {
	
	private int id_deseados;
	private String titulo;
	private String descripcion;
	private String plataforma;
	private String imagen;
	
	public Deseados() {
	}

	public Deseados(String titulo, String descripcion, String plataforma, String imagen) {
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.plataforma = plataforma;
		this.imagen = imagen;
	}

	public Deseados(int id_deseados, String titulo, String descripcion, String plataforma, String imagen) {
		this.id_deseados = id_deseados;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.plataforma = plataforma;
		this.imagen = imagen;
	}

	public int getId_deseados() {
		return id_deseados;
	}

	public void setId_deseados(int id_deseados) {
		this.id_deseados = id_deseados;
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
	
	

}
