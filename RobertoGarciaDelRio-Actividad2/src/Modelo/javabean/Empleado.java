package Modelo.javabean;

import java.util.Objects;

public class Empleado {
	
	private String dni;
	private String nombre;
	private String apellidos;
	private String email;
	private String genero; // H/M
	
		
	public Empleado(String dni, String nombre, String apellidos, String email, String genero) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.genero = genero;
	}
	

	public Empleado() {
		super();
	}


	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}


	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}


	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}


	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}


	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * @return the genero
	 */
	public String getGenero() {
		return genero;
	}


	/**
	 * @param genero the genero to set
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}

	
	

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Empleado))
			return false;
		Empleado other = (Empleado) obj;
		return Objects.equals(dni, other.dni);
	}
	

	@Override
	public String toString() {
		return "Empleado [dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email
				+ ", genero=" + genero + "]";
	}


	// Metodos propios
	public String nombreCompleto() {
		return nombre + " " + apellidos;
	}
	
	public String literalGenero() {
		switch (genero.toLowerCase()) {
			case "h":
				return "Hombre";
			case "m":
				return "Mujer";
			case "nb":
				return "No Binario";
			default:
				return "No definido";
		}
	}
}
