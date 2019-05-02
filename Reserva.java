import java.time.*;

public class Reserva {
	private LocalDate fecha_entrada;
	private LocalDate fecha_salida;
	private double precioReserva;
	private int numPersonas;

	/**
	 * 
	 */
	protected Reserva() {
	}

	/**
	 * @param fecha_entrada
	 * @param fecha_salida
	 * @param numPersonas
	 */
	protected Reserva(LocalDate fecha_entrada, LocalDate fecha_salida, int numPersonas) {
		this.fecha_entrada=fecha_entrada;
		this.fecha_salida=fecha_salida;
		this.numPersonas=numPersonas;
	}
  
	/**
	 * @param fecha_entrada
	 * @param fecha_salida
	 * @param precioReserva
	 * @param numPersonas
	 */
	protected Reserva(LocalDate fecha_entrada, LocalDate fecha_salida, double precioReserva, int numPersonas) {
		this.fecha_entrada = fecha_entrada;
		this.fecha_salida = fecha_salida;
		this.precioReserva = precioReserva;
		this.numPersonas = numPersonas;
	}

	/**
	 * @return the fecha_entrada
	 */
	protected LocalDate getFecha_entrada() {
		return fecha_entrada;
	}

	/**
	 * @param fecha_entrada the fecha_entrada to set
	 */
	protected void setFecha_entrada(LocalDate fecha_entrada) {
		this.fecha_entrada = fecha_entrada;
	}

	/**
	 * @return the fecha_salida
	 */
	protected LocalDate getFecha_salida() {
		return fecha_salida;
	}

	/**
	 * @param fecha_salida the fecha_salida to set
	 */
	protected void setFecha_salida(LocalDate fecha_salida) {
		this.fecha_salida = fecha_salida;
	}

	/**
	 * @return the precioReserva
	 */
	protected double getPrecioReserva() {
		return precioReserva;
	}

	/**
	 * @param precioReserva the precioReserva to set
	 */
	protected void setPrecioReserva(double precioReserva) {
		this.precioReserva = precioReserva;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String mensaje;
		mensaje = "Datos de la reserva: ";
		mensaje += "\t\nFecha de entrada: " + fecha_entrada;
		mensaje += "\t\nFecha de salida: " + fecha_salida;
		mensaje += "\t\nPrecio de la reserva: " + precioReserva;
		mensaje += "\t\nNumero de las personas: " + numPersonas;
		return mensaje;
	}

}
