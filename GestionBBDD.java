import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.*;

public class GestionBBDD {

	/*
	 * Metodo para insertar habitaciones en la base de datos
	 */
	protected void insertarHabitaciones(Habitaciones habitacionAnadir, String dni) {
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
		int idEmpleado = buscarEmpleado(dni);
		// Sentencia SQL
		String sql = "insert into habitaciones (numero_baï¿½os,jacuzzi,matrimonio,tipo,terraza,camas,precio_habitaciones,superficie,numero_habitacion,id_empleados_aux) values ("
				+ numero_banos + "," + jacuzzi + "," + matrimonio + ",'" + tipo + "'," + terraza + "," + camas + ","
				+ precio_habitaciones + ",'" + superficie + "'," + numero_habitacion + "," + idEmpleado + ")";
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
	 * Metodo que a travï¿½s del numero de la habitacion hace una consulta a la base
	 * de datos y devuelve un boolean. En caso de encontrar la habitacion, el
	 * boolean serï¿½ true
	 */
	protected boolean habitacionExiste(int numHabitacion) {
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

	protected int buscarHabitacion(int numHabitacion) {
		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;
		ResultSet rs;
		int idHabitacion = 0;
		String sql = "select id_habitaciones from habitaciones where numero_habitacion=" + numHabitacion;
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				idHabitacion = rs.getInt("id_habitaciones");
			} else {
				System.out.println("Habitacion no encontrada");
			}
			// Cierro el statement y la conexion
			st.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Fallo en la sentencia SQL");
		}
		return idHabitacion;
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
		ResultSet rs;
		int datoNuevoInt = 0;
		double datoNuevoDouble = 0;
		boolean datoNuevoBoolean = false;
		boolean ejecutarSentenciaSQL = true;
		int idHabitacion = buscarHabitacion(numHabitacion);
		// Variables habitaciones
		String superficie, tipo;
		int numero_banos;
		int camas;
		int numero_habitacion;
		double precio_habitaciones;
		boolean jacuzzi;
		boolean matrimonio;
		boolean terraza;
		// Sentencia SQL 1
		String sql1 = "select * from habitaciones where id_habitaciones=" + idHabitacion;
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql1);
			if (rs.next()) {
				superficie = rs.getString(2);
				tipo = rs.getString(3);
				numero_banos = rs.getInt(4);
				camas = rs.getInt(5);
				numero_habitacion = rs.getInt(6);
				precio_habitaciones = rs.getDouble(7);
				jacuzzi = rs.getBoolean(8);
				matrimonio = rs.getBoolean(9);
				terraza = rs.getBoolean(10);
				Habitaciones habitacion = new Habitaciones(superficie, tipo, numero_banos, camas, numero_habitacion,
						precio_habitaciones, jacuzzi, matrimonio, terraza);
				// Sentencia SQL 2
				String sql = "update habitaciones set ";
				if (datoModificar.equalsIgnoreCase("superficie")) {
					habitacion.setSuperficie(datoNuevo);
					sql += "superficie='" + habitacion.getSuperficie() + "' ";
				} else if (datoModificar.equalsIgnoreCase("tipo")) {
					if (datoNuevo.trim().equalsIgnoreCase("individual")) {
						habitacion.setTipo("individual");
						sql += "tipo='" + habitacion.getTipo() + "'";
					} else if (datoNuevo.trim().equalsIgnoreCase("matrimonio")) {
						habitacion.setTipo("matrimonio");
						sql += "tipo='" + habitacion.getTipo() + "'";
					} else if (datoNuevo.trim().equalsIgnoreCase("suite")) {
						habitacion.setTipo("suite");
						sql += "tipo='" + habitacion.getTipo() + "'";
					}
				} else if (datoModificar.equalsIgnoreCase("numero de baï¿½os")) {
					datoNuevoInt = Integer.parseInt(datoNuevo);
					habitacion.setNumero_banos(datoNuevoInt);
					sql += "numero_baï¿½os=" + habitacion.getNumero_banos();
				} else if (datoModificar.equalsIgnoreCase("numero de camas")) {
					datoNuevoInt = Integer.parseInt(datoNuevo);
					habitacion.setCamas(datoNuevoInt);
					sql += "camas=" + habitacion.getCamas();
				} else if (datoModificar.equalsIgnoreCase("numero de la habitacion")) {
					datoNuevoInt = Integer.parseInt(datoNuevo);
					habitacion.setNumero_habitacion(datoNuevoInt);
					sql += "numero_habitacion=" + habitacion.getNumero_habitacion();
				} else if (datoModificar.equalsIgnoreCase("precio de la habitacion")) {
					datoNuevoDouble = Double.parseDouble(datoNuevo);
					habitacion.setPrecio_habitaciones(datoNuevoDouble);
					sql += "precio_habitaciones=" + habitacion.getPrecio_habitaciones();
				} else if (datoModificar.equalsIgnoreCase("jacuzzi")) {
					if (datoNuevo.equalsIgnoreCase("si")) {
						datoNuevoBoolean = true;
						habitacion.setJacuzzi(datoNuevoBoolean);
						sql += "jacuzzi=" + habitacion.isJacuzzi();
					} else if (datoNuevo.equalsIgnoreCase("no")) {
						datoNuevoBoolean = false;
						habitacion.setJacuzzi(datoNuevoBoolean);
						sql += "jacuzzi=" + habitacion.isJacuzzi();
					}
				} else if (datoModificar.equalsIgnoreCase("matrimonio")) {
					if (datoNuevo.equalsIgnoreCase("si")) {
						datoNuevoBoolean = true;
						habitacion.setMatrimonio(datoNuevoBoolean);
						sql += "matrimonio=" + habitacion.isMatrimonio();
					} else if (datoNuevo.equalsIgnoreCase("no")) {
						datoNuevoBoolean = false;
						habitacion.setMatrimonio(datoNuevoBoolean);
						sql += "matrimonio=" + habitacion.isMatrimonio();
					}
				} else if (datoModificar.equalsIgnoreCase("terraza")) {
					if (datoNuevo.equalsIgnoreCase("si")) {
						datoNuevoBoolean = true;
						habitacion.setTerraza(datoNuevoBoolean);
						sql += "terraza=" + habitacion.isTerraza();
					} else if (datoNuevo.equalsIgnoreCase("no")) {
						datoNuevoBoolean = false;
						habitacion.setTerraza(datoNuevoBoolean);
						sql += "terraza=" + habitacion.isTerraza();
					}
				} else {
					System.out.println("El atributo que has introducido para modificar no es vï¿½lido");
					ejecutarSentenciaSQL = false;
				}
				sql += "where id_habitaciones=" + idHabitacion;
				try {
					st = con.createStatement();
					if (ejecutarSentenciaSQL) {
						st.executeUpdate(sql);
					}
					// Cierro el statement y la conexion
					st.close();
					con.close();
				} catch (SQLException e) {
					System.out.println("Fallo en la sentencia SQL");
				}
			}
		} catch (SQLException e) {
			System.out.println("Error en la sentencia SQL");
		}
	}

	/*
	 * Metodo que comprueba la disponibilidad de una habitacion entre fechas
	 * Devuelve un booleano, y se usarï¿½ a la hora de realizar una reserva
	 */
	protected boolean comprobarDisponibilidadHabitaciones(int numHabitacion, Reserva reservaNueva) {

		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;
		ResultSet rs;
		boolean disponible = true;
		int idHabitacion = buscarHabitacion(numHabitacion);
		LocalDate fechaEntradaReservaNueva = reservaNueva.getFecha_entrada();
		LocalDate fechaSalidaReservaNueva = reservaNueva.getFecha_salida();
		Date fechaEntradaSQL;
		Date fechaSalidaSQL;
		LocalDate fechaEntradaConsulta;
		LocalDate fechaSalidaConsulta;
		String sql1 = "select fecha_entrada,fecha_salida from reserva where id_habitaciones_aux=" + idHabitacion;
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql1);
			while (rs.next()) {
				fechaEntradaSQL = rs.getDate("fecha_entrada");
				fechaSalidaSQL = rs.getDate("fecha_salida");
				fechaEntradaConsulta = fechaEntradaSQL.toLocalDate(); // paso a localdate
				fechaSalidaConsulta = fechaSalidaSQL.toLocalDate(); // paso a localdate
				if (fechaEntradaReservaNueva.isEqual(fechaEntradaConsulta)) {
					disponible = false;
				} else if (fechaEntradaReservaNueva.isAfter(fechaEntradaConsulta)) {
					if (fechaEntradaReservaNueva.isBefore(fechaSalidaConsulta)) {
						disponible = false;
					} else if (fechaEntradaReservaNueva.isAfter(fechaSalidaConsulta)
							|| fechaEntradaReservaNueva.isEqual(fechaSalidaConsulta)) {
						disponible = true;
					}
				} else if (fechaEntradaReservaNueva.isBefore(fechaEntradaConsulta)) {
					if (fechaSalidaReservaNueva.isAfter(fechaEntradaConsulta)) {
						disponible = false;
					} else if (fechaSalidaReservaNueva.isBefore(fechaEntradaConsulta)
							|| fechaSalidaReservaNueva.isEqual(fechaEntradaConsulta)) {
						disponible = true;
					}
				}
			}
		} catch (SQLException e) {
			System.out.println("Fallo en la consulta SQL");
			e.printStackTrace();
		}
		return disponible;
	}

	protected void insertarActividades(Actividades act) {

		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;

		String descripcion = act.getDescripcion();
		String tipo = act.getTipo(); // controlar que introduzca externa/interna
		String mediotransporte = act.getMedio_transporte();
		String localizacion = act.getLocalizacion();
		String codigo = act.getCodigo();
		LocalDate hora = act.getHora();
		LocalDate fecha = act.getFecha();
		int aforo = act.getAforo();
		int duracion = act.getDuracion();

		String sql = "insert into actividades (descripcion, tipo, mediotransporte, localizacion, codigo, hora, fecha,"
				+ " aforo, duracion) values ('" + descripcion + "','" + tipo + "','" + mediotransporte + "','"
				+ localizacion + "','" + codigo + "','" + hora + "','" + fecha + "','" + aforo + "','" + duracion
				+ "')";

		try {

			st = con.createStatement();
			st.executeUpdate(sql);
			st.close();
			con.close();
			System.out.println("Insertado con exito");

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	protected void eliminarActividades(String codigo) {

		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;

		String sql = " delete from actividades where codigo=" + codigo + "";

		try {

			st = con.createStatement();
			int confirmar = st.executeUpdate(sql);
			if (confirmar == 1) {

				System.out.println("Registro eliminado con exito");

			} else {

				System.out.println("Ha sido imposible eliminar el registro");

			}

			st.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void modificarActividadesIndividual(String codigo, String opcion, String datonuevo) {

		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;

		int datonuevoInt = 0;
		// Transformar el local date
		boolean ejecutarSentenciaSql = true;
		Date fechaSql = null;

		String sql = "update actividades set";
		if (opcion.equalsIgnoreCase("descripcion")) {

			sql += opcion + "=" + datonuevo + "";

		} else if (opcion.equalsIgnoreCase("tipo")) {

			sql += opcion + "=" + datonuevo + "";

		} else if (opcion.equalsIgnoreCase("medio de transporte")) {

			sql += opcion + "=" + datonuevo + "";

		} else if (opcion.equalsIgnoreCase("localizacion")) {

			sql += opcion + "=" + datonuevo + "";

		} else if (opcion.equalsIgnoreCase("codigo")) {

			sql += opcion + "=" + datonuevo + "";

		} else if (opcion.equalsIgnoreCase("hora")) {

			fechaSql = Date.valueOf(datonuevo);// Comprobar que es asi la conversion de String a Date

			sql += opcion + "=" + fechaSql + "";// Transformacion LocalDate????

		} else if (opcion.equalsIgnoreCase("fecha")) {

			fechaSql = Date.valueOf(datonuevo);

			sql += opcion + "=" + fechaSql + "";// Transformacion LocalDate????

		} else if (opcion.equalsIgnoreCase("aforo")) {

			datonuevoInt = Integer.parseInt(datonuevo);

			sql += opcion + "=" + datonuevoInt + "";

		} else if (opcion.equalsIgnoreCase("duracion")) {

			datonuevoInt = Integer.parseInt(datonuevo);

			sql += opcion + "=" + datonuevoInt + "";

		} else {

			System.out.println("El dato a modificar no es valido");
			ejecutarSentenciaSql = false;
		}

		sql += "where codigo=" + codigo;

		try {

			if (ejecutarSentenciaSql) {

				st = con.createStatement();
				st.executeUpdate(sql);
				st.close();

			}

			con.close();

		} catch (SQLException e) {

			System.out.println("Fallo en la conexion");

		}
	}

	protected void reservarActividades(String DNI, String codigo) {// Reservar actividades

		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;

		int id_clientes_aux = buscarCliente(DNI);
		int id_actividades_aux = buscarActividad(codigo);

		String sql = "insert into apunta (id_clientes_aux,id_actividades_aux) values ('" + id_clientes_aux + "','"
				+ id_actividades_aux + "')";

		try {

			st = con.createStatement();
			st.executeQuery(sql);
			st.close();
			con.close();

		} catch (SQLException e) {

			System.out.println("Fallo en la conexion");

		}

	}

	protected void mostrarActividadesDisponibles(String codigo) {
		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;
		ResultSet rs;
		int id = buscarActividad(codigo);
		int id_clientes = 0;
		int aforo = 0;
		int disponibilidad = 0;

		String sql = "select count(*) id_clientes from apunta where=" + id;

		try {

			st = con.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {

				id_clientes = rs.getInt(1);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		String sql2 = "select aforo from actividades where=" + id + "";

		try {

			st = con.createStatement();
			rs = st.executeQuery(sql2);

			while (rs.next()) {

				aforo = rs.getInt(8);
			}
		} catch (SQLException e) {
			System.out.println("");
		}

		if (aforo >= 0) {

			disponibilidad = id_clientes - aforo;
			System.out.println(disponibilidad);

		} else {

			System.out.println("No hay disponibilidad");
		}
	}

	/*
	 * Metodo para calcular el precio total de la reserva
	 */
	private Reserva calcularPrecioReserva(int numHabitacion, Reserva reservaNueva) { // pendiente de implementacion
		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;
		ResultSet rs;
		int idHabitacion = buscarHabitacion(numHabitacion);
		double precioHabitacion = 0;
		LocalDate fechaEntrada = reservaNueva.getFecha_entrada();
		LocalDate fechaSalida = reservaNueva.getFecha_salida();
		double diasReserva = (double) Period.between(fechaEntrada, fechaSalida).getDays();
		double resultadoPrecioReserva;
		String sql = "select precio_habitaciones from habitaciones where id_habitaciones=" + idHabitacion;
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				precioHabitacion = rs.getDouble("precio_habitaciones");
			} else {
				System.out.println("Habitación no disponible");
			}
			// Cierro el resultset, el statement y la conexion
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Fallo en la consulta SQL");
		}
		resultadoPrecioReserva = precioHabitacion * diasReserva;
		reservaNueva.setPrecioReserva(resultadoPrecioReserva);
		return reservaNueva;
	}

	/*
	 * Metodo que permite al usuario reservar una habitacion de hotel, y que el pago
	 * se guarde en movimientos
	 */
	protected void reservarHabitaciones(int numHabitacion, String dniCliente, Reserva reservaNueva) {
		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;
		reservaNueva = calcularPrecioReserva(numHabitacion, reservaNueva);
		LocalDate fecha_entrada = reservaNueva.getFecha_entrada();
		LocalDate fecha_salida = reservaNueva.getFecha_salida();
		double precioReserva = reservaNueva.getPrecioReserva();
		int numPersonas = reservaNueva.getNumPersonas();
		String fechaEntradaSQL = fecha_entrada.toString();
		String fechaSalidaSQL = fecha_salida.toString();
		LocalDate fechaMovimiento = LocalDate.now();
		Movimientos mov = new Movimientos(precioReserva, fechaMovimiento);
		Double precioMovimiento = mov.getCantidad();
		LocalDate fechaMovimientoSQL = mov.getFecha();
		String fechaMovimientoSQLString = fechaMovimientoSQL.toString();
		final int idEmpleadoResponsableMovimientos = 1;
		int idCliente = buscarCliente(dniCliente);
		int idHabitacion = buscarHabitacion(numHabitacion);
		reservaNueva = calcularPrecioReserva(numHabitacion, reservaNueva);
		// Sentencia SQL 1
		String sql1 = "insert into movimientos (cantidad,fecha,id_empleados_aux) values (" + precioMovimiento
				+ ",STR_TO_DATE('" + fechaMovimientoSQLString + "','%Y-%m-%d')," + idEmpleadoResponsableMovimientos
				+ ")";
		try {
			st = con.createStatement();
			st.executeUpdate(sql1);
		} catch (SQLException e) {
			System.out.println("Fallo en la sentencia SQL");
		}
		int idMovimientos = buscarMovimiento(mov);
		// Sentencia SQL 2
		String sql2 = "insert into reserva (id_clientes_aux,id_habitaciones_aux,id_movimientos_aux,fecha_entrada,fecha_salida,numPersonas,precioReserva) values ("
				+ idCliente + "," + idHabitacion + "," + idMovimientos + ",STR_TO_DATE('" + fechaEntradaSQL
				+ "','%Y-%m-%d'),STR_TO_DATE('" + fechaSalidaSQL + "','%Y-%m-%d')," + numPersonas + "," + precioReserva
				+ ")";
		try {
			st = con.createStatement();
			st.executeUpdate(sql2);
			System.out.println("Reserva de la habitacion realizada correctamente");
			// Cierro el statement y la conexion
			st.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Fallo en la sentencia SQL");
			e.printStackTrace();
		}
	}

	protected int buscarMovimiento(Movimientos mov) {
		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;
		ResultSet rs;
		int idMovimientos = 0;
		LocalDate fechaMovimiento = mov.getFecha();
		double dineroMovimiento = mov.getCantidad();
		String sql = "select id_movimientos from movimientos where fecha=STR_TO_DATE('" + fechaMovimiento
				+ "','%Y-%m-%d') and cantidad=" + dineroMovimiento;
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				idMovimientos = rs.getInt("id_movimientos");
			} else {
				System.out.println("Movimiento no encontrado");
			}
			// Cierro el resultset, el statement y la conexion
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Fallo en la consulta SQL");
		}
		return idMovimientos;
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
				 * obtengo la informaciï¿½n de cada registro, y la almaceno en variables para
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
				 * su informaciï¿½n con el metodo toString
				 */
				Habitaciones h = new Habitaciones(superficie, tipo, numBanios, camas, numHabitacion, precioHabitaciones,
						jacuzzi, matrimonio, terraza);
				System.out.println(h.toString());
			}
		} catch (SQLException e) {
			System.out.println("Fallo en la consulta SQL");
		}
	}

	protected int buscarActividad(String codigo) {
		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;
		ResultSet rs;
		int id = 0;

		String sql = "select id_actividades from actividades where=" + codigo + "";

		try {

			st = con.createStatement();
			rs = st.executeQuery(sql);

			if (rs.next()) {

				id = rs.getInt("id_actividades");

			} else {

				System.out.println("La actividad que busca no existe");
			}
		} catch (SQLException e) {

			e.printStackTrace();

			System.out.println("Ha fallado la consulta");
		}
		return id;
	}

	/*
	 * Metodo para buscar una persona a traves de su DNI y que devuele el id de esa
	 * persona en la base de datos
	 */
	protected int buscarPersonas(String DNI) {
		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;
		ResultSet rs;
		int id = 0;
		// Sentencia SQL
		String sql = "select id_personas from personas where dni='" + DNI + "'";
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
		id_personas_aux = buscarPersonas(dni);
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
		id = buscarPersonas(dni);
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
		id = buscarPersonas(dni);
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

	/*
	 * Metodo que mediante el dni del empleado busca en la base de datos el id de la
	 * persona, y mosteriormente el id del empleado, devolviendo como int
	 */
	protected int buscarEmpleado(String DNI) {

		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;
		ResultSet rs;

		int id = 0;

		String sql = "select id_empleados from empleados where=" + DNI + "";

		try {

			st = con.createStatement();
			rs = st.executeQuery(sql);

			if (rs.next()) {

				id = rs.getInt("id_empleados");

			} else {

				System.out.println("El empleado que busca no existe");
			}

		} catch (SQLException e) {

			System.out.println("Fallo en la conexion");
		}

		return id;

	}

	protected int buscarCliente(String DNI) {

		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;
		ResultSet rs;
		int idPersonaAux = buscarPersonas(DNI);
		int idCliente = 0;
		// Sentencia SQL
		String sql = "select id_clientes from clientes where id_personas_aux=" + idPersonaAux;
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				idCliente = rs.getInt("id_clientes");
			}
			// Cierro el statement y la conexion
			st.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Fallo en la consulta SQL");
		}
		return idCliente;
	}

	protected void modificarPersonas(String DNI, String opcion, String datonuevo, String tipo) {
		// tipo es una constante que definimos en el logueo dependiendo de que tipo de
		// persona sea
		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;

		int datonuevoInt = 0;
		double datonuevoDouble = 0;
		boolean ejecutarSentenciaSql = true;
		int id_personas_aux = buscarPersonas(DNI);

		if (tipo.equalsIgnoreCase("Empleado")) {

			String sql = "update personas set ";
			String sql2 = "update empleados set ";

			if (opcion.equalsIgnoreCase("nombre")) {

				sql += opcion + "=" + datonuevo + "";

			} else if (opcion.equalsIgnoreCase("apellidos")) {

				sql += opcion + "=" + datonuevo + "";

			} else if (opcion.equalsIgnoreCase("dni")) {

				sql += opcion + "=" + datonuevo + "";

			} else if (opcion.equalsIgnoreCase("telefono")) {

				datonuevoInt = Integer.parseInt(datonuevo);

				sql += opcion + "=" + datonuevoInt + "";

			} else if (opcion.equalsIgnoreCase("clave")) {

				sql += opcion + "=" + datonuevo + "";

			} else if (opcion.equalsIgnoreCase("edad")) {

				datonuevoInt = Integer.parseInt(datonuevo);

				sql += opcion + "=" + datonuevoInt + "";

			} else if (opcion.equalsIgnoreCase("email")) {

				sql += opcion + "=" + datonuevo + "";

			} else if (opcion.equalsIgnoreCase("salario")) {

				datonuevoDouble = Double.parseDouble(datonuevo);

				sql2 += opcion + "=" + datonuevoDouble + "";

			} else if (opcion.equalsIgnoreCase("antiguedad")) {

				datonuevoInt = Integer.parseInt(datonuevo);

				sql2 += opcion + "=" + datonuevoInt + "";

			} else if (opcion.equalsIgnoreCase("tipo")) {

				sql2 += opcion + "=" + datonuevo + "";

			} else {

				System.out.println("El dato a modificar no es valido");
				ejecutarSentenciaSql = false;
			}

			sql += "where DNI=" + DNI;
			sql2 += "where id_personas_aux=" + id_personas_aux + "";

			try {

				if (ejecutarSentenciaSql) {

					st = con.createStatement();
					st.executeUpdate(sql);
					st.close();
				}

				con.close();

			} catch (SQLException e) {

				System.out.println("Fallo en la conexion");
			}

		} else if (tipo.equalsIgnoreCase("Cliente")) {

			String sql = "update personas set ";
			String sql3 = "update clientes set ";

			if (opcion.equalsIgnoreCase("nombre")) {

				sql += opcion + "=" + datonuevo + "";

			} else if (opcion.equalsIgnoreCase("apellidos")) {

				sql += opcion + "=" + datonuevo + "";

			} else if (opcion.equalsIgnoreCase("dni")) {

				sql += opcion + "=" + datonuevo + "";

			} else if (opcion.equalsIgnoreCase("telefono")) {

				datonuevoInt = Integer.parseInt(datonuevo);

				sql += opcion + "=" + datonuevoInt + "";

			} else if (opcion.equalsIgnoreCase("clave")) {

				sql += opcion + "=" + datonuevo + "";

			} else if (opcion.equalsIgnoreCase("edad")) {

				datonuevoInt = Integer.parseInt(datonuevo);

				sql += opcion + "=" + datonuevoInt + "";

			} else if (opcion.equalsIgnoreCase("email")) {

				sql += opcion + "=" + datonuevo + "";

			} else if (opcion.equalsIgnoreCase("interes")) {

				sql3 += opcion + "=" + datonuevoDouble + "";

			} else {

				System.out.println("El dato a modificar no es valido");
				ejecutarSentenciaSql = false;
			}

			sql += "where DNI=" + DNI;
			sql3 += "where id_personas_aux=" + id_personas_aux + "";

			try {

				if (ejecutarSentenciaSql) {

					st = con.createStatement();
					st.executeUpdate(sql);
					st.close();
				}

				con.close();

			} catch (SQLException e) {

				System.out.println("Fallo en la conexion");
			}

		} else {
			System.out.println("Tienes que elegir entre Empleados y Clientes");
		}

	}

	protected void mostrarPersonas() {// Necesario ???? Personas clase abstracta no se pueden crear objetos persona

		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;
		ResultSet rs;

		String sql = "select * from personas";

		try {

			st = con.createStatement();
			rs = st.executeQuery(sql);

			if (rs.next()) {

				System.out.println("Nombre: " + rs.getInt(2));
				System.out.println("Apellidos: " + rs.getInt(3));
				System.out.println("DNI: " + rs.getInt(4));
				System.out.println("Telefono: " + rs.getInt(5));
				// System.out.println("Clave: " + rs.getInt(6)); //La clave es personal por lo
				// tanto no mostrar
				System.out.println("Edad: " + rs.getInt(7));
				System.out.println("Email: " + rs.getInt(8));
			}
		} catch (SQLException e) {
			System.out.println("Fallo en la consulta");

		}
	}
}
