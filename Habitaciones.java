public class Habitaciones {

	private String superficie;
	private String tipo;
	private int numero_banos;
	private int camas;
	private int numero_habitacion;
	private double precio_habitaciones;
	private boolean jacuzzi;
	private boolean matrimonio;
	private boolean terraza;

	/**
	 * 
	 */
	protected Habitaciones() {
	}

	/**
	 * @param superficie
	 * @param numero_banos
	 * @param camas
	 * @param numero_habitacion
	 * @param precio_habitaciones
	 * @param jacuzzi
	 * @param matrimonio
	 * @param terraza
	 */
	protected Habitaciones(String superficie, String tipo, int numero_banos, int camas, int numero_habitacion,
			double precio_habitaciones, boolean jacuzzi, boolean matrimonio, boolean terraza) {
		this.superficie = superficie;
		this.tipo = tipo;
		this.numero_banos = numero_banos;
		this.camas = camas;
		this.numero_habitacion = numero_habitacion;
		this.precio_habitaciones = precio_habitaciones;
		this.jacuzzi = jacuzzi;
		this.matrimonio = matrimonio;
		this.terraza = terraza;
	}

	/**
	 * @return the superficie
	 */
	protected String getSuperficie() {
		return superficie;
	}

	/**
	 * @param superficie the superficie to set
	 */
	protected void setSuperficie(String superficie) {
		this.superficie = superficie;
	}

	/**
	 * @return the tipo
	 */
	protected String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	protected void setTipo(String tipo) {
		this.tipo = tipo;
	}
  
	/**
	 * @return the numero_banos
	 */
	protected int getNumero_banos() {
		return numero_banos;
	}

	/**
	 * @param numero_banos the numero_banos to set
	 */
	protected void setNumero_banos(int numero_banos) {
		this.numero_banos = numero_banos;
	}

	/**
	 * @return the camas
	 */
	protected int getCamas() {
		return camas;
	}

	/**
	 * @param camas the camas to set
	 */
	protected void setCamas(int camas) {
		this.camas = camas;
	}

	/**
	 * @return the numero_habitacion
	 */
	protected int getNumero_habitacion() {
		return numero_habitacion;
	}

	/**
	 * @param numero_habitacion the numero_habitacion to set
	 */
	protected void setNumero_habitacion(int numero_habitacion) {
		this.numero_habitacion = numero_habitacion;
	}

	/**
	 * @return the precio_habitaciones
	 */
	protected double getPrecio_habitaciones() {
		return precio_habitaciones;
	}

	/**
	 * @param precio_habitaciones the precio_habitaciones to set
	 */
	protected void setPrecio_habitaciones(double precio_habitaciones) {
		this.precio_habitaciones = precio_habitaciones;
	}

	/**
	 * @return the jacuzzi
	 */
	protected boolean isJacuzzi() {
		return jacuzzi;
	}

	/**
	 * @param jacuzzi the jacuzzi to set
	 */
	protected void setJacuzzi(boolean jacuzzi) {
		this.jacuzzi = jacuzzi;
	}

	/**
	 * @return the matrimonio
	 */
	protected boolean isMatrimonio() {
		return matrimonio;
	}

	/**
	 * @param matrimonio the matrimonio to set
	 */
	protected void setMatrimonio(boolean matrimonio) {
		this.matrimonio = matrimonio;
	}

	/**
	 * @return the terraza
	 */
	protected boolean isTerraza() {
		return terraza;
	}

	/**
	 * @param terraza the terraza to set
	 */
	protected void setTerraza(boolean terraza) {
		this.terraza = terraza;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String mensaje;
		mensaje = "Datos de la habitacion: ";
		mensaje += "\n\tNumero de la habitacion: " + numero_habitacion;
		mensaje += "\n\tSuperficie: " + superficie;
		mensaje += "\n\tTipo: " + tipo;
		mensaje += "\n\tNumero de baños: " + numero_banos;
		mensaje += "\n\tNumero de camas: " + camas;
		mensaje += "\n\tPrecio de la habitación por día: " + precio_habitaciones;
		if (jacuzzi) {
			mensaje += "\n\tJacuzzi: SI";
		} else {
			mensaje += "\n\tJacuzzi: NO";
		}
		if (matrimonio) {
			mensaje += "\n\tCama de matrimonio: SI";
		} else {
			mensaje += "\n\tCama de matrimonio: NO";
		}
		if (terraza) {
			mensaje += "\n\tTerraza: SI";
		} else {
			mensaje += "\n\tTerraza: NO";
		}
		return mensaje;
	}

}
