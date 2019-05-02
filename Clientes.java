
public class Clientes extends Personas {
	private String interes;

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
