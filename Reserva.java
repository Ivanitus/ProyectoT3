import java.time.*;

public class Reserva {
	private LocalDate fecha_entrada;
	private LocalDate fecha_salida;
	/**
	 * 
	 */
	protected Reserva() {
	}
	/**
	 * @param fecha_entrada
	 * @param fecha_salida
	 */
	protected Reserva(LocalDate fecha_entrada, LocalDate fecha_salida) {
		this.fecha_entrada = fecha_entrada;
		this.fecha_salida = fecha_salida;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String mensaje;
		mensaje = "Datos de la reserva: ";
		mensaje += "\t\nFecha de entrada: " + fecha_entrada;
		mensaje += "\t\nFecha de salida: " + fecha_salida;
		return mensaje;
	}
	
}
