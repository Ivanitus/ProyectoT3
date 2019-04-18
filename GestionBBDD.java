
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class GestionBBDD {

	/*
	 * Metodo para insertar habitaciones en la base de datos
	 */
	protected void insertarHabitaciones(Habitaciones habitacionAnadir) {
		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;
		// Deconstruyo el objeto en sus distintos atributos para posteriormente
		// insertarlos en la base de datos
		String superficie = habitacionAnadir.getSuperficie();
		String tipo = habitacionAnadir.getTipo();
		int numero_banos = habitacionAnadir.getNumero_banos();
		int camas = habitacionAnadir.getCamas();
		int numero_habitacion = habitacionAnadir.getNumero_habitacion();
		double precio_habitaciones = habitacionAnadir.getPrecio_habitaciones();
		boolean jacuzzi = habitacionAnadir.isJacuzzi();
		boolean matrimonio = habitacionAnadir.isMatrimonio();
		boolean terraza = habitacionAnadir.isTerraza();
		// Sentencia SQL
		String sql = "insert into habitaciones (numero_baños,jacuzzi,matrimonio,tipo,terraza,camas,precio_habitaciones,superficie,numero_habitacion) values ("
				+ numero_banos + "," + jacuzzi + "," + matrimonio + ",'" + tipo + "'," + terraza + "," + camas + ","
				+ precio_habitaciones + ",'" + superficie + "'," + numero_habitacion + ")";
		try {
			st = con.createStatement();
			st.executeUpdate(sql);
			// Cierro el statement y la conexion
			st.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Fallo en la sentencia SQL");
		}
	}

	/*
	 * Metodo que a través del numero de la habitacion hace una consulta a la base
	 * de datos y devuelve un boolean. En caso de encontrar la habitacion, el
	 * boolean será true
	 */
	protected boolean buscarHabitacion(int numHabitacion) {
		boolean habitacionEncontrada = false;
		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;
		ResultSet rs;
		// Sentencia SQL
		String sql = "select id_habitaciones from habitaciones where numero_habitacion=" + numHabitacion;
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				System.out.println("Habitacion encontrada");
				habitacionEncontrada = true;
			} else {
				System.out.println("Habitacion no encontrada");
			}
			// Cierro el statement y la conexion
			st.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Fallo en la sentencia SQL");
		}
		return habitacionEncontrada;
	}

	/*
	 * Metodo que elimina una habitacion a traves del numero de la habitacion
	 */
	protected void eliminarHabitaciones(int numHabitacion) {
		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;
		// Sentencia SQL
		String sql = "delete from habitaciones where numero_habitacion=" + numHabitacion;
		try {
			st = con.createStatement();
			st.executeUpdate(sql);
			System.out.println("Habitacion eliminada correctamente");
			// Cierro el statement y la conexion
			st.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Fallo en la sentencia SQL");
		}
	}

	/*
	 * Metodo para modificar los atributos de las habitaciones
	 */
	protected void modificarHabitaciones(int numHabitacion, String datoNuevo, String datoModificar) {
		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;
		int datoNuevoInt = 0;
		double datoNuevoDouble = 0;
		boolean datoNuevoBoolean = false;
		boolean ejecutarSentenciaSQL = true;
		// Sentencia SQL
		String sql = "update habitaciones set ";
		if (datoModificar.equalsIgnoreCase("superficie")) {
			sql += datoModificar + "='" + datoNuevo + "' ";
		} else if (datoModificar.equalsIgnoreCase("tipo")) {
			if (datoNuevo.trim().equalsIgnoreCase("individual")) {
				sql += datoModificar + "='individual'";
			} else if (datoNuevo.trim().equalsIgnoreCase("matrimonio")) {
				sql += datoModificar + "='matrimonio'";
			} else if (datoNuevo.trim().equalsIgnoreCase("suite")) {
				sql += datoModificar + "='suite'";
			}
		} else if (datoModificar.equalsIgnoreCase("numero de baños")) {
			datoNuevoInt = Integer.parseInt(datoNuevo);
			sql += "numero_baños=" + datoNuevoInt;
		} else if (datoModificar.equalsIgnoreCase("numero de camas")) {
			datoNuevoInt = Integer.parseInt(datoNuevo);
			sql += "camas=" + datoNuevoInt;
		} else if (datoModificar.equalsIgnoreCase("numero de la habitacion")) {
			datoNuevoInt = Integer.parseInt(datoNuevo);
			sql += "numero_habitacion=" + datoNuevoInt;
		} else if (datoModificar.equalsIgnoreCase("precio de la habitacion")) {
			datoNuevoDouble = Double.parseDouble(datoNuevo);
			sql += "precio_habitaciones=" + datoNuevoDouble;
		} else if (datoModificar.equalsIgnoreCase("jacuzzi")) {
			if (datoNuevo.equalsIgnoreCase("si")) {
				datoNuevoBoolean = true;
				sql += "jacuzzi=" + datoNuevoBoolean;
			} else if (datoNuevo.equalsIgnoreCase("no")) {
				sql += "jacuzzi=" + datoNuevoBoolean;
			}
		} else if (datoModificar.equalsIgnoreCase("matrimonio")) {
			if (datoNuevo.equalsIgnoreCase("si")) {
				datoNuevoBoolean = true;
				sql += "matrimonio=" + datoNuevoBoolean;
			} else if (datoNuevo.equalsIgnoreCase("no")) {
				sql += "matrimonio=" + datoNuevoBoolean;
			}
		} else if (datoModificar.equalsIgnoreCase("terraza")) {
			if (datoNuevo.equalsIgnoreCase("si")) {
				datoNuevoBoolean = true;
				sql += "terraza=" + datoNuevoBoolean;
			} else if (datoNuevo.equalsIgnoreCase("no")) {
				sql += "terraza=" + datoNuevoBoolean;
			}
		} else {
			System.out.println("El atributo que has introducido para modificar no es válido");
			ejecutarSentenciaSQL = false;
		}
		sql += "where numero_habitacion=" + numHabitacion;
		try {
			if (ejecutarSentenciaSQL) {
				st = con.createStatement();
				st.executeUpdate(sql);
				// Cierro el statement
				st.close();
			}
			// Cierro la conexion
			con.close();
		} catch (SQLException e) {
			System.out.println("Fallo en la sentencia SQL");
		}
	}

	protected void reservarHabitaciones() { // pendiente de implementacion

	}

	protected void mostrarHabitacionesDisponibles() { // pendiente de implementacion

	}

	protected void mostrarHabitaciones() { // Metodo para mostrar todos los datos de todas las habitaciones
		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;
		ResultSet rs;
		int numBanios, camas, numHabitacion;
		double precioHabitaciones;
		boolean jacuzzi, matrimonio, terraza;
		String tipo, superficie;
		// Sentencia SQL
		String sql = "select * from habitaciones";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				/*
				 * obtengo la información de cada registro, y la almaceno en variables para
				 * posteriormente crear un objeto
				 */
				numBanios = rs.getInt(2);
				jacuzzi = rs.getBoolean(3);
				matrimonio = rs.getBoolean(4);
				tipo = rs.getString(5);
				terraza = rs.getBoolean(6);
				camas = rs.getInt(7);
				precioHabitaciones = rs.getDouble(8);
				superficie = rs.getString(9);
				numHabitacion = rs.getInt(10);
				/*
				 * construyo un nuevo objeto del tipo Habitaciones para posteriormente mostrar
				 * su información con el metodo toString
				 */
				Habitaciones h = new Habitaciones(superficie, tipo, numBanios, camas, numHabitacion, precioHabitaciones,
						jacuzzi, matrimonio, terraza);
				System.out.println(h.toString());
			}
		} catch (SQLException e) {
			System.out.println("Fallo en la consulta SQL");
		}
	}

	/*
	 * Metodo para buscar una persona a traves de su DNI y que devuele el id de esa
	 * persona en la base de datos
	 */
	protected int buscarPersona(String dni) {
		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;
		ResultSet rs;
		int id = 0;
		// Sentencia SQL
		String sql = "select id_personas from personas where dni='" + dni + "'";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				id = rs.getInt("id_personas");
			} else {
				System.out.println("Persona no encontrada");
			}
		} catch (SQLException e) {
			System.out.println("Fallo en la consulta SQL");
		}
		return id;
	}

	/*
	 * metodo para insertar una persona en la base de datos, independientemente de
	 * si es cliente o empleado
	 */
	protected void insertarPersonas(Personas personaNueva) {
		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;
		String nombre, apellidos, dni, clave, email, tipoEmpleado, interesCliente;
		int telefono, edad, antiguedadEmpleado, id_personas_aux;
		double salarioEmpleado;
		nombre = personaNueva.getNombre();
		apellidos = personaNueva.getApellidos();
		dni = personaNueva.getDni();
		telefono = personaNueva.getTelefono();
		clave = personaNueva.getClave();
		edad = personaNueva.getEdad();
		email = personaNueva.getEmail();
		// Sentencia SQL
		String sql1 = "insert into personas (nombre,apellidos,dni,telefono,clave,edad,email) values ('" + nombre + "','"
				+ apellidos + "','" + dni + "'," + telefono + ",'" + clave + "'," + edad + ",'" + email + "')";
		try {
			st = con.createStatement();
			st.executeUpdate(sql1);
			// Cierro el statement y la conexion
			st.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Fallo en la sentencia SQL");
		}
		id_personas_aux = buscarPersona(dni);
		/*
		 * Sentencia SQL para completar la informacion de la persona dependiendo si es
		 * cliente o empleado en la base de datos
		 */
		String sql2 = "insert into ";
		if (personaNueva instanceof Empleados) {
			salarioEmpleado = ((Empleados) personaNueva).getSalario();
			antiguedadEmpleado = ((Empleados) personaNueva).getAntiguedad();
			tipoEmpleado = ((Empleados) personaNueva).getTipo();
			sql2 += "empleados (antiguedad,salario,tipo,id_personas_aux) values (" + antiguedadEmpleado + ","
					+ salarioEmpleado + ",'" + tipoEmpleado + "',";
		} else if (personaNueva instanceof Clientes) {
			interesCliente = ((Clientes) personaNueva).getInteres();
			sql2 += "clientes (interes,id_personas_aux) values ('" + interesCliente + "',";
		}
		sql2 += id_personas_aux + ")";
		// Ejecuto la segunda actualizacion de la base de datos
		try {
			st = con.createStatement();
			st.executeUpdate(sql2);
			// Cierro el statement y la conexion
			st.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Fallo en la sentencia SQL");
		}
	}

	protected void eliminarEmpleados(String dni) { // Metodo para eliminar empleados de la base de datos
		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;
		int id = 0;
		id = buscarPersona(dni);
		// Sentencia SQL
		String sql = "delete from empleados where id_personas_aux=" + id;
		try {
			st = con.createStatement();
			st.executeUpdate(sql);
			// Cierro el statement y la conexion
			st.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Fallo en la sentencia SQL");
		}
	}

	protected void eliminarClientes(String dni) { // Metodo para eliminar clientes de la base de datos
		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;
		int id = 0;
		id = buscarPersona(dni);
		// Sentencia SQL
		String sql = "delete from clientes where id_personas_aux=" + id;
		try {
			st = con.createStatement();
			st.executeUpdate(sql);
			// Cierro el statement y la conexion
			st.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Fallo en la sentencia SQL");
		}
	}

	/*
	 * Metodo para eliminar personas de la base de datos. Debe ser usado junto con
	 * eliminarEmpleados o eliminarClientes
	 */
	protected void eliminarPersonas(String dni) {
		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;
		// Sentencia SQL
		String sql = "delete from personas where dni='" + dni + "'";
		try {
			st = con.createStatement();
			st.executeUpdate(sql);
			// Cierro el statement y la conexion
			st.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Fallo en la consulta SQL");
		}
	}

	protected void consultarMovimientos() { // Metodo para mostrar los registros de la tabla movimientos de la BBDD
		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;
		ResultSet rs;
		double cantidad = 0;
		Date fechaSQL = null;
		LocalDate fechaJava = null;
		// Sentencia SQL
		String sql = "select * from movimientos";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				cantidad = rs.getDouble(2);
				fechaSQL = rs.getDate(3);
				// Transformo la fecha del registro de la base de datos a LocalDate
				fechaJava = fechaSQL.toLocalDate();
				Movimientos m = new Movimientos(cantidad, fechaJava);
				System.out.println(m.toString());
			}
		} catch (SQLException e) {
			System.out.println("Fallo en la consulta SQL");
		}
	}
}
