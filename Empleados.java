import d_tablas.Tableable;

public class Empleados extends Personas implements Tableable {
	private double salario;
	private int antiguedad;
	private String tipo;
	
	/**
	 * @param nombre
	 * @param apellidos
	 * @param dni
	 * @param telefono
	 * @param edad
	 * @param email
	 * @param salario
	 * @param antiguedad
	 * @param tipo
	 */
	protected Empleados(String nombre, String apellidos, String dni, int telefono, int edad, String email,
			double salario, int antiguedad, String tipo) {
		super(nombre, apellidos, dni, telefono, edad, email);
		this.salario = salario;
		this.antiguedad = antiguedad;
		this.tipo = tipo;
	}

	/**
	 * @param nombre
	 * @param apellidos
	 * @param dni
	 * @param telefono
	 * @param clave
	 * @param edad
	 * @param email
	 * @param salario
	 * @param antiguedad
	 * @param tipo
	 */
	protected Empleados(String nombre, String apellidos, String dni, int telefono, String clave, int edad, String email,
			double salario, int antiguedad, String tipo) {
		super(nombre, apellidos, dni, telefono, clave, edad, email);
		this.salario = salario;
		this.antiguedad = antiguedad;
		this.tipo = tipo;
	}

	/**
	 * @return the salario
	 */
	protected double getSalario() {
		return salario;
	}

	/**
	 * @param salario the salario to set
	 */
	protected void setSalario(double salario) {
		this.salario = salario;
	}

	/**
	 * @return the antiguedad
	 */
	protected int getAntiguedad() {
		return antiguedad;
	}

	/**
	 * @param antiguedad the antiguedad to set
	 */
	protected void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
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

	@Override
	public Object[] getData() {
		Object[] data = { nombre, apellidos, dni, telefono, edad, email, salario, antiguedad, tipo };
		return data;
	}

	@Override
	public String[] getHeader() {
		String[] header = { "NOMBRE", "APELLIDOS", "DNI", "TELEFONO", "EDAD", "E-MAIL", "SALARIO", "ANTIGÜEDAD", "TIPO" };
		return header;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see Personas#toString()
	 */
	@Override
	public String toString() {
		String mensaje;
		mensaje = "\n\tSalario: " + salario;
		mensaje += "\n\tAntigüedad: " + antiguedad;
		mensaje += "\n\tTipo: " + tipo;
		return super.toString() + mensaje;
	}

}
