import d_tablas.Tableable;

public class MostrarReservaHabitacionCliente implements Tableable {

	private Habitaciones habitacion;
	private Clientes cliente;

	/**
	 * @param habitacion
	 * @param cliente
	 */
	protected MostrarReservaHabitacionCliente(Habitaciones habitacion, Clientes cliente) {
		super();
		this.habitacion = habitacion;
		this.cliente = cliente;
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

	@Override
	public Object[] getData() {
		Object[] data = { cliente.getNombre(), cliente.getApellidos(), cliente.getDni(), habitacion.getTipo(),
				habitacion.getNumero_habitacion() };
		return data;
	}

	@Override
	public String[] getHeader() {
		String[] header = { "NOMBRE", "APELLIDOS", "DNI", "TIPO", "NUMERO HABITACION" };
		return header;
	}
}
