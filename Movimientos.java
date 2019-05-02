import java.time.*;

public class Movimientos {
	private double cantidad; //dinero
	private LocalDate fecha;

	/**
	 * 
	 */
	protected Movimientos() {
	}

	/**
	 * @param cantidad
	 * @param fecha
	 */
	protected Movimientos(double cantidad, LocalDate fecha) {
		this.cantidad = cantidad;
		this.fecha = fecha;
	}

	/**
	 * @return the cantidad
	 */
	protected double getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad the cantidad to set
	 */
	protected void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * @return the fecha
	 */
	protected LocalDate getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	protected void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String mensaje;
		mensaje = "Datos del movimiento: ";
		mensaje += "Cantidad: " + cantidad;
		mensaje += "Fecha: " + fecha;
		return mensaje;
	}

}
