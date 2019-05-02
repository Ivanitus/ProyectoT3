
public class Apunta {

	private int numPersonas;

	/**
	 * 
	 */
	protected Apunta() {
		super();
	}

	/**
	 * @param numPersonas
	 */
	protected Apunta(int numPersonas) {
		super();
		this.numPersonas = numPersonas;
	}

	/**
	 * @return the numPersonas
	 */
	protected int getNumPersonas() {
		return numPersonas;
	}

	/**
	 * @param numPersonas the numPersonas to set
	 */
	protected void setNumPersonas(int numPersonas) {
		this.numPersonas = numPersonas;
	}

	public String toString() {
		String mensaje;
		mensaje = "Datos reserva de la actividad";
		mensaje += "\t\nNumero de Personas: " + numPersonas;
		return mensaje;
	}
}
