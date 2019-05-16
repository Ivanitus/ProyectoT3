import d_tablas.Tableable;

public class MovimientosHabitacionesClientes implements Tableable {
	private Movimientos movimiento;
	private Clientes cliente;
	private Habitaciones habitacion;

	/**
	 * @param movimiento
	 * @param cliente
	 * @param habitacion
	 */
	protected MovimientosHabitacionesClientes(Movimientos movimiento, Clientes cliente, Habitaciones habitacion) {
		this.movimiento = movimiento;
		this.cliente = cliente;
		this.habitacion = habitacion;
	}

	/**
	 * @return the movimiento
	 */
	protected Movimientos getMovimiento() {
		return movimiento;
	}

	/**
	 * @param movimiento the movimiento to set
	 */
	protected void setMovimiento(Movimientos movimiento) {
		this.movimiento = movimiento;
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
		Object[] data = { movimiento.getFecha(), movimiento.getCantidad(), cliente.getNombre(), cliente.getApellidos(),
				cliente.getDni(), habitacion.getNumero_habitacion(), habitacion.getTipo() };
		return data;
	}

	@Override
	public String[] getHeader() {
		String[] header = { "FECHA MOVIMIENTO", "CANTIDAD", "NOMBRE", "APELLIDOS", "DNI", "NUM. HABITACION", "TIPO" };
		return header;
	}
}
