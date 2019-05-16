import d_tablas.Tableable;

public abstract class Personas implements Tableable {

	protected String nombre;
	protected String apellidos;
	protected String dni;
	protected int telefono;
	protected String clave;
	protected int edad;
	protected String email;

	/**
	 * 
	 */
	protected Personas() {

	}

	/**
	 * @param nombre
	 * @param apellidos
	 * @param dni
	 * @param telefono
	 * @param edad
	 * @param email
	 */
	protected Personas(String nombre, String apellidos, String dni, int telefono, int edad, String email) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.telefono = telefono;
		this.edad = edad;
		this.email = email;
	}

	/**
	 * @param nombre
	 * @param apellidos
	 * @param dni
	 */
	protected Personas(String nombre, String apellidos, String dni) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
	}

	/**
	 * @param nombre
	 * @param apellidos
	 * @param dni
	 * @param telefono
	 * @param clave
	 * @param edad
	 * @param email
	 */
	protected Personas(String nombre, String apellidos, String dni, int telefono, String clave, int edad,
			String email) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.telefono = telefono;
		this.clave = clave;
		this.edad = edad;
		this.email = email;
	}

	/**
	 * @return the nombre
	 */
	protected String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellidos
	 */
	protected String getApellidos() {
		return apellidos;
	}

	/**
	 * @param apellidos the apellidos to set
	 */
	protected void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * @return the dni
	 */
	protected String getDni() {
		return dni;
	}

	/**
	 * @param dni the dni to set
	 */
	protected void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * @return the telefono
	 */
	protected int getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	protected void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the clave
	 */
	protected String getClave() {
		return clave;
	}

	/**
	 * @param clave the clave to set
	 */
	protected void setClave(String clave) {
		this.clave = clave;
	}

	/**
	 * @return the edad
	 */
	protected int getEdad() {
		return edad;
	}

	/**
	 * @param edad the edad to set
	 */
	protected void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * @return the email
	 */
	protected String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	protected void setEmail(String email) {
		this.email = email;
	}

	@Override
	public Object[] getData() {
		return null;
	}

	@Override
	public String[] getHeader() {
		return null;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String mensaje;
		mensaje = "Datos de la persona:";
		mensaje += "\n\tNombre: " + nombre;
		mensaje += "\n\tApellidos: " + apellidos;
		mensaje += "\n\tDNI: " + dni;
		mensaje += "\n\tTelefono: " + telefono;
		mensaje += "\n\tClave: " + clave;
		mensaje += "\n\tEdad: " + edad;
		mensaje += "\n\tE-mail: " + email;
		return mensaje;
	}

}
