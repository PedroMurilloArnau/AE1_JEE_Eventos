package modelo.beans;

import java.io.Serializable;

public class Evento implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int idevento;
	private String nombre;
	private String descripcion;
	private String fechainicio;
	private int duracion;
	private String direccion;
	private String estado;
	private String destacado;
	private int aforomaximo;
	private int minimoasistencia;
	private double precio;
	private int idtipo;
	
	//Creamos el objeto sin atributos.
	public Evento() {
		super();
	}
	//Cremos el objeto con todos los atributos. 
	public Evento(int idevento, String nombre, String descripcion, String fechainicio, int duracion, String direccion,
			String estado, String destacado, int aforomaximo, int minimoasistencia, double precio, int idtipo) {
		super();
		this.idevento = idevento;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechainicio = fechainicio;
		this.duracion = duracion;
		this.direccion = direccion;
		this.estado = estado;
		this.destacado = destacado;
		this.aforomaximo = aforomaximo;
		this.minimoasistencia = minimoasistencia;
		this.precio = precio;
		this.idtipo = idtipo;
	}
	//Creamos nuestro metodos "getter and setter" de todos los atributos de nuestro metodo.
	public int getIdevento() {
		return idevento;
	}

	public void setIdevento(int idevento) {
		this.idevento = idevento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFechainicio() {
		return fechainicio;
	}

	public void setFechainicio(String fechainicio) {
		this.fechainicio = fechainicio;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDestacado() {
		return destacado;
	}

	public void setDestacado(String destacado) {
		this.destacado = destacado;
	}

	public int getAforomaximo() {
		return aforomaximo;
	}

	public void setAforomaximo(int aforomaximo) {
		this.aforomaximo = aforomaximo;
	}

	public int getMinimoasistencia() {
		return minimoasistencia;
	}

	public void setMinimoasistencia(int minimoasistencia) {
		this.minimoasistencia = minimoasistencia;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getIdtipo() {
		return idtipo;
	}

	public void setIdtipo(int idtipo) {
		this.idtipo = idtipo;
	}
	//Creamos el método "equals y hasCode para identificar que nuestro objeto es unívoco por su id.
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idevento;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Evento))
			return false;
		Evento other = (Evento) obj;
		if (idevento != other.idevento)
			return false;
		return true;
	}
	//Creamos un metodo toString que recoja todas las propiedades de nuestro evento.
	@Override
	public String toString() {
		return "Evento [idevento=" + idevento + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fechainicio="
				+ fechainicio + ", duracion=" + duracion + ", direccion=" + direccion + ", estado=" + estado
				+ ", destacado=" + destacado + ", aforomaximo=" + aforomaximo + ", minimoasistencia=" + minimoasistencia
				+ ", precio=" + precio + ", idtipo=" + idtipo + "]";
	}
	
}
