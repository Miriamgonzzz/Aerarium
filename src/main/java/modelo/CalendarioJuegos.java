package modelo;

public class CalendarioJuegos {
	
	private int id_calendario;
	private String titulo;
	private String descripcion;
	private String plataforma;
	private String imagen;
	private int fecha_lanzamiento;
	
	public CalendarioJuegos() {
	}

	public CalendarioJuegos(String titulo, String descripcion, String plataforma, String imagen,
			int fecha_lanzamiento) {
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.plataforma = plataforma;
		this.imagen = imagen;
		this.fecha_lanzamiento = fecha_lanzamiento;
	}

	public CalendarioJuegos(int id_calendario, String titulo, String descripcion, String plataforma, String imagen,
			int fecha_lanzamiento) {
		this.id_calendario = id_calendario;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.plataforma = plataforma;
		this.imagen = imagen;
		this.fecha_lanzamiento = fecha_lanzamiento;
	}

	public int getId_calendario() {
		return id_calendario;
	}

	public void setId_calendario(int id_calendario) {
		this.id_calendario = id_calendario;
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

	public int getFecha_lanzamiento() {
		return fecha_lanzamiento;
	}

	public void setFecha_lanzamiento(int fecha_lanzamiento) {
		this.fecha_lanzamiento = fecha_lanzamiento;
	}
	
	

}
