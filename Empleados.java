
public class Empleados extends Personas implements Trabajadores {
	private double salario;
	private int antiguedad;
	private String tipo;

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see Personas#toString()
	 */
	@Override
	public String toString() {
		String mensaje;
		mensaje = "\n\tSalario: " + salario;
		mensaje += "\n\tAntig�edad: " + antiguedad;
		mensaje += "\n\tTipo: " + tipo;
		return super.toString() + mensaje;
	}

}