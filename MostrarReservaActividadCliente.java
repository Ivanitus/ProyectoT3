import d_tablas.Tableable;

public class MostrarReservaActividadCliente implements Tableable {

	private Actividades actividad;
	private Clientes cliente;

	protected MostrarReservaActividadCliente(Clientes cliente, Actividades actividad) {
		super();
		this.cliente = cliente;
		this.actividad = actividad;

	}

	/**
	 * @return the actividad
	 */
	protected Actividades getActividad() {
		return actividad;
	}

	/**
	 * @param actividad the actividad to set
	 */
	protected void setActividad(Actividades actividad) {
		this.actividad = actividad;
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
		Object[] data = { cliente.getNombre(), cliente.getApellidos(), cliente.getDni(), actividad.getDescripcion(),
				actividad.getCodigo(), actividad.getTipo(), actividad.getLocalizacion() };
		return data;
	}

	@Override
	public String[] getHeader() {
		String[] header = { "NOMBRE", "APELLIDOS", "DNI", "DESCRIPCION", "CODIGO", "TIPO ACTIVIDAD", "LOCALIZACION" };
		return header;
	}
}
