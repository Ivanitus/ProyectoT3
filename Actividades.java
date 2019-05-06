import java.time.*;

import d_tablas.Tableable;

public class Actividades implements Tableable {

	private String descripcion;
	private String tipo;
	private String medio_transporte;
	private String localizacion;
	private String codigo;
	private LocalTime hora;
	private LocalDate fecha;
	private int aforo;
	private String duracion;
	private double precio;

	/**
	 * 
	 */
	protected Actividades() {
	}

	/**
	 * @param descripcion
	 * @param tipo
	 * @param medio_transporte
	 * @param localizacion
	 * @param codigo
	 * @param hora
	 * @param fecha
	 * @param aforo
	 * @param duracion
	 */
	protected Actividades(String descripcion, String tipo, String medio_transporte, String localizacion, String codigo,
			LocalTime hora, LocalDate fecha, int aforo, String duracion, double precio) {
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.medio_transporte = medio_transporte;
		this.localizacion = localizacion;
		this.codigo = codigo;
		this.hora = hora;
		this.fecha = fecha;
		this.aforo = aforo;
		this.duracion = duracion;
		this.precio = precio;
	}

	/**
	 * @return the descripcion
	 */
	protected String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	protected void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the tipo
	 */
	protected String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	protected void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the medio_transporte
	 */
	protected String getMedio_transporte() {
		return medio_transporte;
	}

	/**
	 * @param medio_transporte the medio_transporte to set
	 */
	protected void setMedio_transporte(String medio_transporte) {
		this.medio_transporte = medio_transporte;
	}

	/**
	 * @return the localizacion
	 */
	protected String getLocalizacion() {
		return localizacion;
	}

	/**
	 * @param localizacion the localizacion to set
	 */
	protected void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}

	/**
	 * @return the codigo
	 */
	protected String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	protected void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the hora
	 */
	protected LocalTime getHora() {
		return hora;
	}

	/**
	 * @param hora the hora to set
	 */
	protected void setHora(LocalTime hora) {
		this.hora = hora;
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

	/**
	 * @return the aforo
	 */
	protected int getAforo() {
		return aforo;
	}

	/**
	 * @param aforo the aforo to set
	 */
	protected void setAforo(int aforo) {
		this.aforo = aforo;
	}

	/**
	 * @return the duracion
	 */
	protected String getDuracion() {
		return duracion;
	}

	/**
	 * @param duracion the duracion to set
	 */
	protected void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	/**
	 * @return the precio
	 */
	protected double getPrecio() {
		return precio;
	}

	/**
	 * @param precio the precio to set
	 */
	protected void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public Object[] getData() {
		Object[] data = { codigo, tipo, localizacion, hora, fecha, duracion, descripcion, medio_transporte, aforo,
				precio };
		return data;
	}

	@Override
	public String[] getHeader() {
		String[] header = { "CODIGO", "TIPO", "LOCALIZACION", "HORA", "FECHA", "DURACION", "DESCRIPCION",
				"MEDIO TRANSPORTE", "AFORO", "PRECIO" };
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
		mensaje = "Datos de la actividad:";
		mensaje += "\n\tCódigo de la actividad: " + codigo;
		mensaje += "\n\tTipo: " + tipo;
		mensaje += "\n\tLocalizacion: " + localizacion;
		mensaje += "\n\tHora: " + hora;
		mensaje += "\n\tFecha: " + fecha;
		mensaje += "\n\tDuracion: " + duracion;
		mensaje += "\n\tDescripcion: " + descripcion;
		if (tipo.equalsIgnoreCase("externa")) {
			mensaje += "\n\tMedio de transporte: " + medio_transporte;
		}
		mensaje += "\n\tAforo máximo: " + aforo;
		mensaje += "\n\tPrecio: " + precio;
		return mensaje;
	}

}
