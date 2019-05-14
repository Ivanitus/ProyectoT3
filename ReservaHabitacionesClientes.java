import d_tablas.Tableable;

public class ReservaHabitacionesClientes implements Tableable {
	private Clientes cliente;
	private Reserva reservaCliente;
	private Habitaciones habitacion;

	/**
	 * @param cliente
	 * @param reservaCliente
	 * @param habitacion
	 */
	protected ReservaHabitacionesClientes(Clientes cliente, Reserva reservaCliente, Habitaciones habitacion) {
		this.cliente = cliente;
		this.reservaCliente = reservaCliente;
		this.habitacion = habitacion;
	}

	/**
	 * @return the cliente
	 */
	protected Clientes getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	protected void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return the reservaCliente
	 */
	protected Reserva getReservaCliente() {
		return reservaCliente;
	}

	/**
	 * @param reservaCliente the reservaCliente to set
	 */
	protected void setReservaCliente(Reserva reservaCliente) {
		this.reservaCliente = reservaCliente;
	}

	/**
	 * @return the habitacion
	 */
	protected Habitaciones getHabitacion() {
		return habitacion;
	}

	/**
	 * @param habitacion the habitacion to set
	 */
	protected void setHabitacion(Habitaciones habitacion) {
		this.habitacion = habitacion;
	}

	@Override
	public Object[] getData() {
		Object[] data = { reservaCliente.getFecha_entrada(), reservaCliente.getFecha_salida(),
				reservaCliente.getPrecioReserva(), reservaCliente.getNumPersonas(), cliente.getNombre(),
				cliente.getApellidos(), cliente.getDni(), habitacion.getNumero_habitacion(), habitacion.getTipo() };
		return data;
	}

	@Override
	public String[] getHeader() {
		String[] header = { "F. ENTRADA", "F. SALIDA", "PRECIO", "NUM. PERSONAS", "NOMBRE", "APELLIDOS", "DNI",
				"NUM. HABITACION", "TIPO HABITACION" };
		return header;
	}

}
