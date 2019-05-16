import java.time.*;

import d_tablas.Tableable;

public class Movimientos implements Tableable {
	private double cantidad; // dinero
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

	@Override
	public Object[] getData() {
		Object[] data = { cantidad, fecha };
		return data;
	}

	@Override
	public String[] getHeader() {
		String[] header = { "CANTIDAD", "FECHA" };
		return header;
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
		mensaje += "\n\tCantidad: " + cantidad;
		mensaje += "\n\tFecha: " + fecha;
		return mensaje;
	}

}
