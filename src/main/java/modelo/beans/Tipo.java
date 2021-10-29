package modelo.beans;

import java.io.Serializable;

public class Tipo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int idtipo;
	private String nombre;
	private String descripcion;
	
	public Tipo() {
		super();
	}

	public Tipo(int idtipo, String nombre, String descripcion) {
		super();
		this.idtipo = idtipo;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public int getIdtipo() {
		return idtipo;
	}

	public void setIdtipo(int idtipo) {
		this.idtipo = idtipo;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idtipo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Tipo))
			return false;
		Tipo other = (Tipo) obj;
		if (idtipo != other.idtipo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tipo [idtipo=" + idtipo + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}
	
	
}
