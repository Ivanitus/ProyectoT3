import d_tablas.Tableable;

public class Clientes extends Personas implements Tableable {
	private String interes;
	
	
	/**
	 * @param nombre
	 * @param apellidos
	 * @param dni
	 */
	protected Clientes(String nombre, String apellidos, String dni) {
		super(nombre, apellidos, dni);
	}

	/**
	 * @param nombre
	 * @param apellidos
	 * @param dni
	 * @param telefono
	 * @param edad
	 * @param email
	 * @param interes
	 */
	protected Clientes(String nombre, String apellidos, String dni, int telefono, int edad, String email,
			String interes) {
		super(nombre, apellidos, dni, telefono, edad, email);
		this.interes = interes;
	}

	/**
	 * @param nombre
	 * @param apellidos
	 * @param dni
	 * @param telefono
	 * @param clave
	 * @param edad
	 * @param email
	 * @param interes
	 */
	protected Clientes(String nombre, String apellidos, String dni, int telefono, String clave, int edad, String email,
			String interes) {
		super(nombre, apellidos, dni, telefono, clave, edad, email);
		this.interes = interes;
	}

	/**
	 * @return the interes
	 */
	protected String getInteres() {
		return interes;
	}

	/**
	 * @param interes the interes to set
	 */
	protected void setInteres(String interes) {
		this.interes = interes;
	}

	@Override
	public Object[] getData() {
		Object[] data = { nombre, apellidos, dni, telefono, edad, email, interes };
		return data;
	}

	@Override
	public String[] getHeader() {
		String[] header = { "NOMBRE", "APELLIDOS", "DNI", "TELEFONO", "EDAD", "E-MAIL", "INTERES" };
		return header;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see Personas#toString()
	 */
	@Override
	public String toString() {
		String mensaje;
		mensaje = "\n\tInteres: " + interes;
		return super.toString() + mensaje;
	}

}
