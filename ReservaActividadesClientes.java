import d_tablas.Tableable;

public class ReservaActividadesClientes implements Tableable {
	private Actividades actividad;
	private Clientes cliente;
	private Apunta apuntaActividades;

	/**
	 * @param actividad
	 * @param cliente
	 * @param apuntaActividades
	 */
	protected ReservaActividadesClientes(Actividades actividad, Clientes cliente, Apunta apuntaActividades) {
		this.actividad = actividad;
		this.cliente = cliente;
		this.apuntaActividades = apuntaActividades;
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

	/**
	 * @return the apuntaActividades
	 */
	protected Apunta getApuntaActividades() {
		return apuntaActividades;
	}

	/**
	 * @param apuntaActividades the apuntaActividades to set
	 */
	protected void setApuntaActividades(Apunta apuntaActividades) {
		this.apuntaActividades = apuntaActividades;
	}

	@Override
	public Object[] getData() {
		Object[] data = { actividad.getCodigo(), actividad.getTipo(), actividad.getLocalizacion(), actividad.getAforo(),
				actividad.getAforoRestante(), cliente.getNombre(), cliente.getApellidos(), cliente.getDni(),
				apuntaActividades.getNumPersonas() };
		return data;
	}

	@Override
	public String[] getHeader() {
		String[] header = { "COD. ACTIVIDAD", "TIPO", "LOCALIZACION", "AFORO", "AFORO RESTANTE", "NOMBRE", "APELLIDOS", "DNI", "NUM. PERSONAS" };
		return header;
	}
}
