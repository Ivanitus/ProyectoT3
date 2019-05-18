import d_tablas.Tableable;

public class MostrarReservaHabitacionCliente implements Tableable {

	private Habitaciones habitacion;
	private Clientes cliente;
	private Reserva reserva;

	/**
	 * @param habitacion
	 * @param cliente
	 * @param reserva
	 */
	protected MostrarReservaHabitacionCliente(Habitaciones habitacion, Clientes cliente, Reserva reserva) {
		super();
		this.habitacion = habitacion;
		this.cliente = cliente;
		this.reserva=reserva;
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
	 * @return the reserva
	 */
	protected Reserva getReserva() {
		return reserva;
	}

	/**
	 * @param reserva the reserva to set
	 */
	protected void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	@Override
	public Object[] getData() {
		Object[] data = { cliente.getNombre(), cliente.getApellidos(), cliente.getDni(), habitacion.getTipo(),
				habitacion.getNumero_habitacion(), reserva.getFecha_entrada(), reserva.getFecha_salida() };
		return data;
	}

	@Override
	public String[] getHeader() {
		String[] header = { "NOMBRE", "APELLIDOS", "DNI", "TIPO", "NUMERO HABITACION", "FECHA ENTRADA", "FECHA SALIDA" };
		return header;
	}
}
