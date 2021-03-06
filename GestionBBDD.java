import java.math.BigInteger;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class GestionBBDD {

	/*
	 * Metodo para insertar habitaciones en la base de datos
	 */
	protected boolean insertarHabitaciones(Habitaciones habitacionAnadir, String dni, JPanel panel) {
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
		boolean insertar = false;
		int idEmpleado = buscarEmpleado(dni, panel);
		// Sentencia SQL
		String sql = "insert into habitaciones (numero_ba�os,jacuzzi,matrimonio,tipo,terraza,camas,precio_habitaciones,superficie,numero_habitacion,id_empleados_aux) values ("
				+ numero_banos + "," + jacuzzi + "," + matrimonio + ",'" + tipo + "'," + terraza + "," + camas + ","
				+ precio_habitaciones + ",'" + superficie + "'," + numero_habitacion + "," + idEmpleado + ")";
		try {
			st = con.createStatement();
			st.executeUpdate(sql);
			insertar = true;
			// Cierro el statement y la conexion
			st.close();
			con.close();
		} catch (MySQLIntegrityConstraintViolationException excepcion) {
			JOptionPane.showMessageDialog(panel, "Ya hay una habitaci�n con ese n�mero");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(panel, "Fallo en la sentencia SQL");
		}
		return insertar;
	}

	/*
	 * Metodo que a trav�s del numero de la habitacion hace una consulta a la base
	 * de datos y devuelve un boolean. En caso de encontrar la habitacion, el
	 * boolean ser� true
	 */
	protected boolean habitacionExiste(int numHabitacion, JPanel panel) {
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
				habitacionEncontrada = true;
			} else {
				JOptionPane.showMessageDialog(panel, "La habitaci�n introducida no existe");
			}
			// Cierro el statement y la conexion
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(panel, "Fallo en la sentencia SQL");
		}
		return habitacionEncontrada;
	}

	protected int buscarHabitacion(int numHabitacion, JPanel panel) {
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
				JOptionPane.showMessageDialog(panel, "Habitacion no encontrada");
			}
			// Cierro el statement y la conexion
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(panel, "Fallo en la sentencia SQL");
		}
		return idHabitacion;
	}

	/*
	 * Metodo que elimina una habitacion a traves del numero de la habitacion
	 */
	protected void eliminarHabitaciones(int numHabitacion, JPanel panel) {
		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;
		// Sentencia SQL
		String sql = "delete from habitaciones where numero_habitacion=" + numHabitacion;
		try {
			st = con.createStatement();
			st.executeUpdate(sql);
			JOptionPane.showMessageDialog(panel, "Habitaci�n eliminada correctamente");
			// Cierro el statement y la conexion
			st.close();
			con.close();
		} catch (MySQLIntegrityConstraintViolationException excepcion) {
			JOptionPane.showMessageDialog(panel, "No puedes eliminar una habitacion que tenga reservas realizadas");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(panel, "Fallo en la sentencia SQL");
		}
	}

	/*
	 * Metodo para modificar los atributos de las habitaciones
	 */
	protected boolean modificarHabitaciones(int numHabitacion, String datoNuevo, String datoModificar, JPanel panel) {
		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;
		ResultSet rs;
		int datoNuevoInt = 0;
		double datoNuevoDouble = 0;
		boolean datoNuevoBoolean = false;
		boolean ejecutarSentenciaSQL = true;
		int idHabitacion = buscarHabitacion(numHabitacion, panel);
		// Variables habitaciones
		String superficie, tipo;
		int numero_banos;
		int camas;
		int numero_habitacion;
		double precio_habitaciones;
		boolean jacuzzi;
		boolean matrimonio;
		boolean terraza;
		boolean modificar = false;
		// Sentencia SQL 1
		String sql1 = "select * from habitaciones where id_habitaciones=" + idHabitacion;
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql1);
			if (rs.next()) {
				superficie = rs.getString("superficie");
				tipo = rs.getString("tipo");
				numero_banos = rs.getInt("numero_ba�os");
				camas = rs.getInt("camas");
				numero_habitacion = rs.getInt("numero_habitacion");
				precio_habitaciones = rs.getDouble("precio_habitaciones");
				jacuzzi = rs.getBoolean("jacuzzi");
				matrimonio = rs.getBoolean("matrimonio");
				terraza = rs.getBoolean("terraza");
				Habitaciones habitacion = new Habitaciones(superficie, tipo, numero_banos, camas, numero_habitacion,
						precio_habitaciones, jacuzzi, matrimonio, terraza);
				// Sentencia SQL 2
				String sql = "update habitaciones set ";
				if (datoModificar.equalsIgnoreCase("superficie")) {
					habitacion.setSuperficie(datoNuevo);
					sql += "superficie='" + habitacion.getSuperficie() + "' ";
				} else if (datoModificar.equalsIgnoreCase("tipo")) {
					if (datoNuevo.trim().equalsIgnoreCase("individual")) {
						habitacion.setTipo("Individual");
						sql += "tipo='" + habitacion.getTipo() + "'";
					} else if (datoNuevo.trim().equalsIgnoreCase("matrimonio")) {
						habitacion.setTipo("Matrimonio");
						sql += "tipo='" + habitacion.getTipo() + "'";
					} else if (datoNuevo.trim().equalsIgnoreCase("suite")) {
						habitacion.setTipo("Suite");
						sql += "tipo='" + habitacion.getTipo() + "'";
					}
				} else if (datoModificar.equalsIgnoreCase("numero de ba�os")) {
					datoNuevoInt = Integer.parseInt(datoNuevo);
					habitacion.setNumero_banos(datoNuevoInt);
					sql += "numero_ba�os=" + habitacion.getNumero_banos();
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
					JOptionPane.showMessageDialog(panel, "El atributo que has introducido para modificar no es valido");
					ejecutarSentenciaSQL = false;
				}
				sql += " where id_habitaciones=" + idHabitacion;
				try {
					st = con.createStatement();
					if (ejecutarSentenciaSQL) {
						st.executeUpdate(sql);
						modificar = true;
					}
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(panel, "Fallo en la sentencia SQL");
				}
			}

			// Cierro el statement y la conexion
			st.close();
			con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(panel, "Error en la sentencia SQL");
		}
		return modificar;
	}

	/*
	 * Metodo que comprueba la disponibilidad de una habitacion entre fechas
	 * Devuelve un booleano, y se usara a la hora de realizar una reserva
	 */
	protected boolean comprobarDisponibilidadHabitaciones(int numHabitacion, Reserva reservaNueva, JPanel panel) {

		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;
		ResultSet rs;
		boolean disponible = true;
		int idHabitacion = buscarHabitacion(numHabitacion, panel);
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
				} else if (fechaSalidaReservaNueva.isEqual(fechaSalidaConsulta)) {
					disponible = false;
				}
			}
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(panel, "Fallo en la sentencia SQL");
		}
		return disponible;
	}

	protected boolean insertarActividades(Actividades act, String dni, JPanel panel) {

		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;

		String descripcion = act.getDescripcion();
		String tipo = act.getTipo(); // controlar que introduzca externa/interna
		String mediotransporte = act.getMedio_transporte();
		String localizacion = act.getLocalizacion();
		String codigo = act.getCodigo();
		LocalTime hora = act.getHora();
		LocalDate fecha = act.getFecha();
		int aforo = act.getAforo();
		String duracion = act.getDuracion();
		int idEmpleado = buscarEmpleado(dni, panel);
		boolean insertar = false;
		// Sentencia SQL
		String sql = "insert into actividades (descripcion, tipo_actividad, medio_transporte, localizacion, codigo, hora, fecha,"
				+ " aforo, duracion, id_empleados_aux) values ('" + descripcion + "','" + tipo + "','" + mediotransporte
				+ "','" + localizacion + "','" + codigo + "','" + hora + "','" + fecha + "','" + aforo + "','"
				+ duracion + "'," + idEmpleado + ")";

		try {

			st = con.createStatement();
			st.executeUpdate(sql);
			insertar = true;
			st.close();
			con.close();
		} catch (MySQLIntegrityConstraintViolationException excepcion) {
			JOptionPane.showMessageDialog(panel, "Ya hay una actividad insertada con ese c�digo");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(panel, "Fallo en la sentencia SQL");
		}
		return insertar;
	}

	protected boolean actividadExiste(String codigo, JPanel panel) {
		boolean existe = false;
		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;
		ResultSet rs;
		String sql = "select id_actividades from actividades where codigo='" + codigo + "'";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				existe = true;
			} else {
				JOptionPane.showMessageDialog(panel, "La actividad introducida no existe");
			}
			// Cierro el statement y la conexion
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(panel, "Fallo en la sentencia SQL");
		}
		return existe;
	}

	protected void eliminarActividades(String codigo, JPanel panel) {

		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;

		String sql = "delete from actividades where codigo='" + codigo + "'";

		try {
			st = con.createStatement();
			st.executeUpdate(sql);
			st.close();
			con.close();
		} catch (MySQLIntegrityConstraintViolationException excepcion) {
			JOptionPane.showMessageDialog(panel,
					"No puedes eliminar una actividad que tenga gente apuntada o que ya se haya realizado");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(panel, "Fallo en la sentencia SQL");
		}
	}

	protected boolean modificarActividadesIndividual(String codigo, String opcion, String datonuevo, JPanel panel) {

		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;
		boolean modificar = false;
		int datonuevoInt = 0;
		double datoNuevoDouble = 0;
		// Transformar el local date
		boolean ejecutarSentenciaSql = true;
		Date fechaSql = null;

		String sql = "update actividades set ";
		try {
			if (opcion.equalsIgnoreCase("descripcion")) {

				sql += "descripcion='" + datonuevo + "'";

			} else if (opcion.equalsIgnoreCase("tipo")) {

				sql += "tipo_actividad='" + datonuevo + "'";

			} else if (opcion.equalsIgnoreCase("medio de transporte")) {

				sql += "medio_transporte='" + datonuevo + "'";

			} else if (opcion.equalsIgnoreCase("localizacion")) {

				sql += "localizacion='" + datonuevo + "'";

			} else if (opcion.equalsIgnoreCase("codigo")) {

				sql += "codigo='" + datonuevo + "'";

			} else if (opcion.equalsIgnoreCase("hora")) {

				sql += "hora='" + datonuevo + "'";

			} else if (opcion.equalsIgnoreCase("fecha")) {

				fechaSql = Date.valueOf(datonuevo);

				sql += "fecha='" + fechaSql + "'";

			} else if (opcion.equalsIgnoreCase("aforo")) {

				datonuevoInt = Integer.parseInt(datonuevo);

				sql += "aforo=" + datonuevoInt + "";

			} else if (opcion.equalsIgnoreCase("duracion")) {

				sql += "duracion='" + datonuevo + "'";

			} else {

				JOptionPane.showMessageDialog(panel, "El dato a modificar no es valido");
				ejecutarSentenciaSql = false;
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(panel, "El dato introducido no es v�lido");
		} catch (Exception excepcionGenerica) {
			JOptionPane.showMessageDialog(panel, "El dato introducido no es v�lido");
		}

		sql += " where codigo='" + codigo + "'";

		try {
			st = con.createStatement();

			if (ejecutarSentenciaSql) {

				st.executeUpdate(sql);
				modificar = true;

			}

			st.close();
			con.close();

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(panel, "Fallo en la sentencia SQL");

		}
		return modificar;
	}

	protected boolean reservarActividades(String DNI, String codigo, Apunta apun, JPanel panel) {// Reservar actividades

		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;

		int id_clientes_aux = buscarCliente(DNI, panel);
		int id_actividades_aux = buscarActividad(codigo, panel);
		int numeroPersonas = apun.getNumPersonas();
		boolean insertar = false;

		String sql2 = "insert into apunta (id_clientes_aux,id_actividades_aux,numeroPersonas) values ('"
				+ id_clientes_aux + "','" + id_actividades_aux + "','" + numeroPersonas + "')";

		try {

			st = con.createStatement();
			st.executeUpdate(sql2);
			insertar = true;
			st.close();
			con.close();

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(panel, "Fallo en la sentencia SQL");

		}

		return insertar;

	}

	protected ArrayList<Actividades> mostrarActividades(JPanel panel) {
		ArrayList<Actividades> listaActividades = new ArrayList<>();
		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;
		ResultSet rs;
		String descripcion = "";
		String tipo = "";
		String medio_transporte = "";
		String localizacion = "";
		String codigo = "";
		LocalTime hora;
		LocalDate fecha;
		int aforo = 0;
		String duracion = "";
		// Sentencia SQL
		String sql = "select * from actividades";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				descripcion = rs.getString("descripcion");
				hora = rs.getTime("hora").toLocalTime();
				tipo = rs.getString("tipo_actividad");
				medio_transporte = rs.getString("medio_transporte");
				localizacion = rs.getString("localizacion");
				fecha = rs.getDate("fecha").toLocalDate();
				aforo = rs.getInt("aforo");
				codigo = rs.getString("codigo");
				duracion = rs.getString("duracion");
				Actividades a = new Actividades(descripcion, tipo, medio_transporte, localizacion, codigo, hora, fecha,
						aforo, duracion);
				listaActividades.add(a);
			}
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(panel, "Fallo en la sentencia SQL");
		}
		return listaActividades;
	}

	protected int calcularActividadesDisponibles(String codigo, JPanel panel) {
		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;
		ResultSet rs;
		int id_actividad = buscarActividad(codigo, panel);
		int numper = 0;
		int aforo = 0;
		int disponibilidad = 0;
		int numeroTotalPersonas = 0;

		String sql = "select numeroPersonas from apunta where id_actividades_aux=" + id_actividad;

		try {

			st = con.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {

				numper = rs.getInt("numeroPersonas");
				numeroTotalPersonas += numper;
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(panel, "Fallo en la sentencia SQL");
		}

		String sql2 = "select aforo from actividades where id_actividades=" + id_actividad;

		try {

			st = con.createStatement();
			rs = st.executeQuery(sql2);

			while (rs.next()) {

				aforo = rs.getInt("aforo");
			}
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(panel, "Fallo en la conexion");
		}

		if (aforo > 0) {

			disponibilidad = aforo - numeroTotalPersonas;

		} else {

			JOptionPane.showMessageDialog(panel, "Lo siento no hay disponibilidad en la actividad selecionada");
		}
		return disponibilidad;
	}

	/*
	 * Metodo para calcular el precio total de la reserva
	 */
	private Reserva calcularPrecioReserva(int numHabitacion, Reserva reservaNueva, JPanel panel) {
		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;
		ResultSet rs;
		int idHabitacion = buscarHabitacion(numHabitacion, panel);
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
				JOptionPane.showMessageDialog(panel, "Habitaci�n no disponible");
			}
			// Cierro el resultset, el statement y la conexion
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(panel, "Fallo en la sentencia SQL");
		}
		resultadoPrecioReserva = precioHabitacion * diasReserva;
		reservaNueva.setPrecioReserva(resultadoPrecioReserva);
		return reservaNueva;
	}

	/*
	 * Metodo que permite al usuario reservar una habitacion de hotel, y que el pago
	 * se guarde en movimientos
	 */
	protected void reservarHabitaciones(int numHabitacion, String dniCliente, Reserva reservaNueva, JPanel panel) {
		Conexion conexion = new Conexion();// paso numero,dni,fecha entrada,salida
		Connection con = conexion.getConnection();
		Statement st;
		reservaNueva = calcularPrecioReserva(numHabitacion, reservaNueva, panel);
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
		int idCliente = buscarCliente(dniCliente, panel);
		int idHabitacion = buscarHabitacion(numHabitacion, panel);
		// Sentencia SQL 1
		String sql1 = "insert into movimientos (cantidad,fecha,id_empleados_aux) values (" + precioMovimiento
				+ ",STR_TO_DATE('" + fechaMovimientoSQLString + "','%Y-%m-%d')," + idEmpleadoResponsableMovimientos
				+ ")";
		try {
			st = con.createStatement();
			st.executeUpdate(sql1);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(panel, "Fallo en la sentencia SQL");
		}
		int idMovimientos = buscarMovimiento(mov, panel);
		// Sentencia SQL 2
		String sql2 = "insert into reserva (id_clientes_aux,id_habitaciones_aux,id_movimientos_aux,fecha_entrada,fecha_salida,numPersonas,precioReserva) values ("
				+ idCliente + "," + idHabitacion + "," + idMovimientos + ",STR_TO_DATE('" + fechaEntradaSQL
				+ "','%Y-%m-%d'),STR_TO_DATE('" + fechaSalidaSQL + "','%Y-%m-%d')," + numPersonas + "," + precioReserva
				+ ")";
		try {
			st = con.createStatement();
			st.executeUpdate(sql2);
			JOptionPane.showMessageDialog(panel, "Reserva de la habitacion realizada correctamente");
			// Cierro el statement y la conexion
			st.close();
			con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(panel, "Fallo en la sentencia SQL");
		}
	}

	protected int buscarMovimiento(Movimientos mov, JPanel panel) {
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
				JOptionPane.showMessageDialog(panel, "Movimiento no encontrado");
			}
			// Cierro el resultset, el statement y la conexion
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(panel, "Fallo en la consulta SQL");
		}
		return idMovimientos;
	}

	protected ArrayList<Habitaciones> mostrarHabitaciones(JPanel panel) { // Metodo para mostrar todos los datos de
																			// todas las
		// habitaciones
		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;
		ResultSet rs;
		int numBanios, camas, numHabitacion;
		double precioHabitaciones;
		boolean jacuzzi, matrimonio, terraza;
		String tipo, superficie;
		ArrayList<Habitaciones> listaHabitaciones = new ArrayList<>();
		// Sentencia SQL
		String sql = "select * from habitaciones";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				/*
				 * obtengo la informaci�n de cada registro, y la almaceno en variables para
				 * posteriormente crear un objeto
				 */
				numBanios = rs.getInt("numero_ba�os");
				jacuzzi = rs.getBoolean("jacuzzi");
				matrimonio = rs.getBoolean("matrimonio");
				tipo = rs.getString("tipo");
				terraza = rs.getBoolean("terraza");
				camas = rs.getInt("camas");
				precioHabitaciones = rs.getDouble("precio_habitaciones");
				superficie = rs.getString("superficie");
				numHabitacion = rs.getInt("numero_habitacion");
				/*
				 * construyo un nuevo objeto del tipo Habitaciones para posteriormente mostrar
				 * su informaci�n con el metodo toString
				 */
				Habitaciones h = new Habitaciones(superficie, tipo, numBanios, camas, numHabitacion, precioHabitaciones,
						jacuzzi, matrimonio, terraza);
				listaHabitaciones.add(h);
			}
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(panel, "Fallo en la sentencia SQL");
		}
		return listaHabitaciones;
	}

	protected int buscarActividad(String codigo, JPanel panel) {
		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;
		ResultSet rs;
		int id = 0;

		String sql = "select id_actividades from actividades where codigo='" + codigo + "'";

		try {

			st = con.createStatement();
			rs = st.executeQuery(sql);

			if (rs.next()) {

				id = rs.getInt("id_actividades");
			} else {
				JOptionPane.showMessageDialog(panel, "La actividad que busca no existe");
			}
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(panel, "Fallo en la consulta SQL");
		}
		return id;
	}

	/*
	 * Metodo para buscar una persona a traves de su DNI y que devuele el id de esa
	 * persona en la base de datos
	 */
	protected int buscarPersonas(String DNI, JPanel panel) {
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
				JOptionPane.showMessageDialog(panel, "Persona no encontrada");
			}
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(panel, "Fallo en la consulta SQL");
		}
		return id;
	}

	protected int buscarEmailRepetido(String email, JPanel panel) {
		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;
		ResultSet rs;
		int id = 0;
		// Sentencia SQL
		String sql = "select id_personas from personas where email='" + email + "'";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				id = rs.getInt("id_personas");
			}
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(panel, "Fallo en la consulta SQL");
		}
		return id;
	}

	/*
	 * metodo para insertar una persona en la base de datos, independientemente de
	 * si es cliente o empleado
	 */
	protected boolean insertarPersonas(Personas personaNueva, JPanel panel) {
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
		boolean insertar = false;
		// Sentencia SQL
		String sql1 = "insert into personas (nombre,apellidos,dni,telefono,clave,edad,email) values ('" + nombre + "','"
				+ apellidos + "','" + dni + "'," + telefono + ",'" + clave + "'," + edad + ",'" + email + "')";
		try {
			st = con.createStatement();
			st.executeUpdate(sql1);
			insertar = true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(panel, "Fallo en la sentencia SQL");
		}
		id_personas_aux = buscarPersonas(dni, panel);
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
			insertar = true;
			// Cierro el statement y la conexion
			st.close();
			con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(panel, "Fallo en la sentencia SQL");
		}
		return insertar;
	}

	protected void eliminarEmpleados(String dni, JPanel panel) { // Metodo para eliminar empleados de la base de datos
		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;
		int id = 0;
		id = buscarPersonas(dni, panel);
		// Sentencia SQL
		String sql = "delete from empleados where id_personas_aux=" + id;
		try {
			st = con.createStatement();
			st.executeUpdate(sql);
			JOptionPane.showMessageDialog(panel, "Empleado eliminado correctamente");
			// Cierro el statement y la conexion
			st.close();
			con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(panel, "Fallo en la sentencia SQL");
		}
	}

	protected void eliminarClientes(String dni, JPanel panel) { // Metodo para eliminar clientes de la base de datos
		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;
		int id = 0;
		id = buscarPersonas(dni, panel);
		// Sentencia SQL
		String sql = "delete from clientes where id_personas_aux=" + id;
		try {
			st = con.createStatement();
			st.executeUpdate(sql);
			// Cierro el statement y la conexion
			st.close();
			con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(panel, "Fallo en la sentencia SQL");
		}
	}

	/*
	 * Metodo para mostrar los registros de la tabla movimientos de la BBDD
	 */
	protected ArrayList<MovimientosHabitacionesClientes> consultarMovimientos(JPanel panel) {
		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;
		ResultSet rs;
		double cantidad = 0;
		Date fechaSQL;
		LocalDate fechaJava;
		String nombre = "";
		String apellidos = "";
		String dni = "";
		int numHabitacion = 0;
		String tipo = "";
		ArrayList<MovimientosHabitacionesClientes> listaMovimientos = new ArrayList<>();
		// Sentencia SQL
		String sql = "select movimientos.fecha,movimientos.cantidad,personas.nombre,personas.apellidos,personas.dni,habitaciones.numero_habitacion,habitaciones.tipo from "
				+ "((((movimientos inner join reserva on(movimientos.id_movimientos=reserva.id_movimientos_aux)) "
				+ "inner join habitaciones on(reserva.id_habitaciones_aux=habitaciones.id_habitaciones)) "
				+ "inner join clientes on(reserva.id_clientes_aux=clientes.id_clientes)) "
				+ "inner join personas on(clientes.id_personas_aux=personas.id_personas))";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				cantidad = rs.getDouble("cantidad");
				fechaSQL = rs.getDate("fecha");
				nombre = rs.getString("nombre");
				apellidos = rs.getString("apellidos");
				dni = rs.getString("dni");
				numHabitacion = rs.getInt("numero_habitacion");
				tipo = rs.getString("tipo");
				// Transformo la fecha del registro de la base de datos a LocalDate
				fechaJava = fechaSQL.toLocalDate();
				Movimientos movimiento = new Movimientos(cantidad, fechaJava);
				Clientes cliente = new Clientes(nombre, apellidos, dni);
				Habitaciones habitacion = new Habitaciones(tipo, numHabitacion);
				MovimientosHabitacionesClientes m = new MovimientosHabitacionesClientes(movimiento, cliente,
						habitacion);
				listaMovimientos.add(m);
			}
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(panel, "Fallo en la consulta SQL");
		}
		return listaMovimientos;
	}

	/*
	 * Metodo para eliminar personas de la base de datos. Debe ser usado junto con
	 * eliminarEmpleados o eliminarClientes
	 */
	protected void eliminarPersonas(String dni, JPanel panel) {
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
			JOptionPane.showMessageDialog(panel, "Fallo en la sentencia SQL");
		}
	}

	/*
	 * Metodo que mediante el dni del empleado busca en la base de datos el id de la
	 * persona, y mosteriormente el id del empleado, devolviendo como int
	 */
	protected int buscarEmpleado(String DNI, JPanel panel) {

		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;
		ResultSet rs;

		int idEmpleado = 0;
		int idPersona = buscarPersonas(DNI, panel);

		String sql = "select id_empleados from empleados where id_personas_aux=" + idPersona;

		try {

			st = con.createStatement();
			rs = st.executeQuery(sql);

			if (rs.next()) {

				idEmpleado = rs.getInt("id_empleados");

			} else {

				JOptionPane.showMessageDialog(panel, "El empleado que busca no existe");
			}

			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {

			JOptionPane.showMessageDialog(panel, "Fallo en la consulta SQL");
		}

		return idEmpleado;

	}

	protected int buscarCliente(String DNI, JPanel panel) {

		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;
		ResultSet rs;
		int idPersonaAux = buscarPersonas(DNI, panel);
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
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(panel, "Fallo en la consulta SQL");
		}
		return idCliente;
	}

	protected boolean modificarPersonas(String DNI, String opcion, String datoNuevo, String tipo, JPanel panel) {
		// tipo es una constante que definimos en el logueo dependiendo de que tipo de
		// persona sea
		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;

		int datoNuevoInt = 0;
		double datoNuevoDouble = 0;
		boolean ejecutarSentenciaSql = true;
		int id_personas_aux = buscarPersonas(DNI, panel);
		boolean modificar = false;
		String sqlPersonas = "update personas set ";
		String sqlClientes = "update clientes set ";
		String sqlEmpleados = "update empleados set ";
		if (tipo.equalsIgnoreCase("persona")) {
			if (opcion.equalsIgnoreCase("nombre")) {
				sqlPersonas += "nombre='" + datoNuevo + "'";
			} else if (opcion.equalsIgnoreCase("apellidos")) {
				sqlPersonas += "apellidos='" + datoNuevo + "'";
			} else if (opcion.equalsIgnoreCase("telefono")) {
				datoNuevoInt = Integer.parseInt(datoNuevo);
				sqlPersonas += "telefono=" + datoNuevoInt;
			} else if (opcion.equalsIgnoreCase("clave")) {
				sqlPersonas += "clave='" + datoNuevo + "'";
			} else if (opcion.equalsIgnoreCase("edad")) {
				datoNuevoInt = Integer.parseInt(datoNuevo);
				sqlPersonas += "edad=" + datoNuevoInt;
			} else if (opcion.equalsIgnoreCase("email")) {
				sqlPersonas += "email='" + datoNuevo + "'";
			} else {
				ejecutarSentenciaSql = false;
			}
			sqlPersonas += " where dni='" + DNI + "'";
			try {
				st = con.createStatement();
				if (ejecutarSentenciaSql) {
					st.executeUpdate(sqlPersonas);
					modificar = true;
					st.close();
				}
				con.close();
			} catch (NumberFormatException excepcion) {
				JOptionPane.showMessageDialog(panel, "El dato introducido no es valido");
			} catch (NullPointerException exception) {
				JOptionPane.showMessageDialog(panel, "El dato introducido no es valido");
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(panel, "Fallo en la sentencia SQL");
			} catch (Exception excepcionGenerica) {
				JOptionPane.showMessageDialog(panel, "El dato introducido no es valido");
			}
		} else if (tipo.equalsIgnoreCase("cliente")) {
			if (opcion.equalsIgnoreCase("interes")) {
				sqlClientes += "interes='" + datoNuevo + "'";
			} else {
				ejecutarSentenciaSql = false;
			}
			sqlClientes += " where id_personas_aux=" + id_personas_aux;
			try {
				st = con.createStatement();
				if (ejecutarSentenciaSql) {
					st.executeUpdate(sqlClientes);
					modificar = true;
					st.close();
				}
				con.close();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(panel, "Fallo en la sentencia SQL");
			}
		} else if (tipo.equalsIgnoreCase("empleado")) {
			if (opcion.equalsIgnoreCase("antiguedad")) {
				datoNuevoInt = Integer.parseInt(datoNuevo);
				sqlEmpleados += "antiguedad=" + datoNuevoInt;
			} else if (opcion.equalsIgnoreCase("salario")) {
				datoNuevoDouble = Double.parseDouble(datoNuevo);
				sqlEmpleados += "salario=" + datoNuevoDouble;
			} else if (opcion.equalsIgnoreCase("tipo")) {
				sqlEmpleados += "tipo='" + datoNuevo + "'";
			} else {
				ejecutarSentenciaSql = false;
			}
			sqlEmpleados += " where id_personas_aux=" + id_personas_aux;
			try {
				st = con.createStatement();
				if (ejecutarSentenciaSql) {
					st.executeUpdate(sqlEmpleados);
					modificar = true;
					st.close();
				}
				con.close();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(panel, "Fallo en la sentencia SQL");
			}
		}
		return modificar;
	}

	protected boolean inicioSesion(String correo, String clave, JPanel panel) {
		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;
		ResultSet rs;
		boolean empleado = false;
		int idPersonas = 0;
		int idEmpleados = 0;
		int idClientes = 0;
		String sql = "select id_personas from personas where email= BINARY '" + correo + "' and clave= BINARY '" + clave
				+ "'";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				idPersonas = rs.getInt("id_personas");
			}
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(panel, "Fallo en la consulta SQL");
		}
		idEmpleados = esEmpleadoInicioSesion(idPersonas, panel);
		idClientes = esClienteInicioSesion(idPersonas, panel);
		if (idEmpleados > 0) {
			empleado = true;
		} else if (idClientes > 0) {
			empleado = false;
		}
		return empleado;
	}

	private int esEmpleadoInicioSesion(int idPersonas, JPanel panel) {
		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;
		ResultSet rs;
		int idEmpleado = 0;
		String sql = "select id_empleados from empleados where id_personas_aux=" + idPersonas;
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				idEmpleado = rs.getInt("id_empleados");
			}
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(panel, "Fallo en la consulta SQL");
		}
		return idEmpleado;
	}

	private int esClienteInicioSesion(int idPersonas, JPanel panel) {
		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;
		ResultSet rs;
		int idCliente = 0;
		String sql = "select id_clientes from clientes where id_personas_aux=" + idPersonas;
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				idCliente = rs.getInt("id_clientes");
			}
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(panel, "Fallo en la consulta SQL");
		}
		return idCliente;
	}

	private String buscarDni(String correo, String clave, JPanel panel) {
		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;
		ResultSet rs;
		String dni = "";
		String sql = "select dni from personas where email= BINARY '" + correo + "' and clave= BINARY '" + clave + "'";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				dni = rs.getString("dni");
			}
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(panel, "Fallo en la consulta SQL");
		}
		return dni;
	}

	protected int inicioSesionCliente(String correo, String clave, JPanel panel) {
		String dni = "";
		dni = buscarDni(correo, clave, panel);
		int idPersona = 0;
		idPersona = buscarCliente(dni, panel);
		return idPersona;
	}

	protected Empleados buscarUnEmpleado(String correo, String clave, JPanel panel) {
		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;
		ResultSet rs;
		int id_personas = 0;
		String nombre = "";
		String apellidos = "";
		String dni = "";
		int telefono = 0;
		String claveSQL = "";
		int edad = 0;
		String emailSQL = "";
		int antiguedad = 0;
		double salario = 0;
		String tipo = "";
		String sql1 = "select * from personas where email= BINARY '" + correo + "' and clave= BINARY '" + clave + "'";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql1);
			if (rs.next()) {
				id_personas = rs.getInt(1);
				nombre = rs.getString(2);
				apellidos = rs.getString(3);
				dni = rs.getString(4);
				telefono = rs.getInt(5);
				clave = rs.getString(6);
				edad = rs.getInt(7);
				emailSQL = rs.getString(8);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(panel, "Fallo en la consulta SQL");
		}
		String sql2 = "select * from empleados where id_personas_aux=" + id_personas;
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql2);
			if (rs.next()) {
				antiguedad = rs.getInt(2);
				salario = rs.getDouble(3);
				tipo = rs.getString(4);
			}
			// Cierro el resultset, el statement y la conexion
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(panel, "Fallo en la consulta SQL");
		}
		Empleados empleado = new Empleados(nombre, apellidos, dni, telefono, claveSQL, edad, emailSQL, salario,
				antiguedad, tipo);
		return empleado;
	}

	protected ArrayList<ReservaHabitacionesClientes> mostrarReservasHabitacionesEmpleados(JPanel panel) {
		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;
		ResultSet rs;
		LocalDate fecha_entrada;
		LocalDate fecha_salida;
		double precioReserva;
		int numPersonas;
		String nombre;
		String apellidos;
		String dni;
		int numHabitacion;
		String tipo;
		ArrayList<ReservaHabitacionesClientes> listaReservasHabitaciones = new ArrayList<>();
		// Sentencia SQL
		String sql = "select habitaciones.numero_habitacion,habitaciones.tipo,reserva.fecha_entrada,reserva.fecha_salida,reserva.precioReserva,reserva.numPersonas,personas.nombre,personas.apellidos,personas.dni from "
				+ "(((habitaciones inner join reserva on(habitaciones.id_habitaciones=reserva.id_habitaciones_aux)) inner join clientes "
				+ "on(reserva.id_clientes_aux=clientes.id_clientes)) inner join personas on(clientes.id_personas_aux=personas.id_personas))";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				numHabitacion = rs.getInt("numero_habitacion");
				tipo = rs.getString("tipo");
				fecha_entrada = rs.getDate("fecha_entrada").toLocalDate();
				fecha_salida = rs.getDate("fecha_salida").toLocalDate();
				precioReserva = rs.getDouble("precioReserva");
				numPersonas = rs.getInt("numPersonas");
				nombre = rs.getString("nombre");
				apellidos = rs.getString("apellidos");
				dni = rs.getString("dni");
				Habitaciones habitacion = new Habitaciones(tipo, numHabitacion);
				Reserva reservaCliente = new Reserva(fecha_entrada, fecha_salida, precioReserva, numPersonas);
				Clientes cliente = new Clientes(nombre, apellidos, dni);
				ReservaHabitacionesClientes r = new ReservaHabitacionesClientes(cliente, reservaCliente, habitacion);
				listaReservasHabitaciones.add(r);
			}
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(panel, "Fallo en la sentencia SQL");
		}
		return listaReservasHabitaciones;
	}

	protected ArrayList<ReservaActividadesClientes> mostrarReservasActividades(JPanel panel) {
		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;
		ResultSet rs;
		ArrayList<ReservaActividadesClientes> listaReservaActividades = new ArrayList<>();
		String codigo = "";
		String tipo = "";
		String localizacion = "";
		int aforo = 0;
		int aforoRestante = 0;
		String nombre = "";
		String apellidos = "";
		String dni = "";
		int numPersonas = 0;
		String sql = "select actividades.codigo,actividades.tipo_actividad, actividades.localizacion,actividades.aforo,personas.nombre,personas.apellidos,personas.dni,apunta.numeroPersonas from "
				+ "(((actividades inner join apunta on(actividades.id_actividades=apunta.id_actividades_aux)) "
				+ "inner join clientes on(apunta.id_clientes_aux=clientes.id_clientes)) inner join "
				+ "personas on(clientes.id_personas_aux=personas.id_personas))";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				codigo = rs.getString("codigo");
				tipo = rs.getString("tipo_actividad");
				localizacion = rs.getString("localizacion");
				aforo = rs.getInt("aforo");
				aforoRestante = aforo;
				nombre = rs.getString("nombre");
				apellidos = rs.getString("apellidos");
				dni = rs.getString("dni");
				numPersonas = rs.getInt("numeroPersonas");
				aforoRestante -= numPersonas;
				Actividades actividad = new Actividades(tipo, localizacion, codigo, aforo, aforoRestante);
				Clientes cliente = new Clientes(nombre, apellidos, dni);
				Apunta apuntaActividades = new Apunta(numPersonas);
				ReservaActividadesClientes r = new ReservaActividadesClientes(actividad, cliente, apuntaActividades);
				listaReservaActividades.add(r);
			}
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(panel, "Fallo en la sentencia SQL");
		}
		return listaReservaActividades;
	}

	protected ArrayList<Personas> mostrarPersonas(String tipo, JPanel panel) {
		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;
		ResultSet rs;

		String nombre = "";
		String apellidos = "";
		String dni = "";
		int telefono = 0;
		int edad = 0;
		String email = "";

		ArrayList<Personas> listaPersonas = new ArrayList<>();

		String sqlClientes = "select * from (personas inner join clientes on(personas.id_personas=clientes.id_personas_aux))";
		String sqlEmpleados = "select * from (personas inner join empleados on(personas.id_personas=empleados.id_personas_aux))";

		if (tipo.equalsIgnoreCase("empleados")) {
			double salario = 0;
			int antiguedad = 0;
			String tipoEmpleado = "";
			try {
				st = con.createStatement();
				rs = st.executeQuery(sqlEmpleados);
				while (rs.next()) {
					nombre = rs.getString("nombre");
					apellidos = rs.getString("apellidos");
					dni = rs.getString("dni");
					telefono = rs.getInt("telefono");
					edad = rs.getInt("edad");
					email = rs.getString("email");
					antiguedad = rs.getInt("antiguedad");
					salario = rs.getDouble("salario");
					tipoEmpleado = rs.getString("tipo");
					Empleados e = new Empleados(nombre, apellidos, dni, telefono, edad, email, salario, antiguedad,
							tipoEmpleado);
					listaPersonas.add(e);
				}
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(panel, "Fallo en la sentencia SQL");
			}
		} else if (tipo.equalsIgnoreCase("clientes")) {
			String interes = "";
			try {
				st = con.createStatement();
				rs = st.executeQuery(sqlClientes);
				while (rs.next()) {
					nombre = rs.getString("nombre");
					apellidos = rs.getString("apellidos");
					dni = rs.getString("dni");
					telefono = rs.getInt("telefono");
					edad = rs.getInt("edad");
					email = rs.getString("email");
					interes = rs.getString("interes");
					Clientes c = new Clientes(nombre, apellidos, dni, telefono, edad, email, interes);
					listaPersonas.add(c);
				}
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(panel, "Fallo en la sentencia SQL");
			}
		}
		return listaPersonas;
	}

	protected boolean darseBajaCliente(String DNI, JPanel panel) {

		boolean realizado = false;
		SecureRandom random = new SecureRandom();
		String text = new BigInteger(130, random).toString(32);
		String contrasenaGenerada = text.substring(0, 19);

		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;

		String sql = "update personas set clave='" + contrasenaGenerada + "' where dni='" + DNI + "'";

		try {
			st = con.createStatement();
			st.executeUpdate(sql);
			realizado = true;
			st.close();
			con.close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(panel, "No se ha podido dar de baja el usuario");
		}
		return true;
	}

	protected boolean reservaHabitaciones(int numHabitacion, String dniCliente, Reserva reservaNueva, JPanel panel) {
		Conexion conexion = new Conexion();// paso numero,dni,fecha entrada,salida
		Connection con = conexion.getConnection();
		Statement st;
		reservaNueva = calcularPrecioReserva(numHabitacion, reservaNueva, panel);
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
		int idCliente = buscarCliente(dniCliente, panel);
		int idHabitacion = buscarHabitacion(numHabitacion, panel);
		boolean insertar = false;
		// Sentencia SQL 1
		String sql1 = "insert into movimientos (cantidad,fecha,id_empleados_aux) values (" + precioMovimiento
				+ ",STR_TO_DATE('" + fechaMovimientoSQLString + "','%Y-%m-%d')," + idEmpleadoResponsableMovimientos
				+ ")";
		try {
			st = con.createStatement();
			st.executeUpdate(sql1);
			insertar = true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(panel, "Fallo en la sentencia SQL");
		}
		int idMovimientos = buscarMovimiento(mov, panel);
		// Sentencia SQL 2
		String sql2 = "insert into reserva (id_clientes_aux,id_habitaciones_aux,id_movimientos_aux,fecha_entrada,fecha_salida,numPersonas,precioReserva) values ("
				+ idCliente + "," + idHabitacion + "," + idMovimientos + ",STR_TO_DATE('" + fechaEntradaSQL
				+ "','%Y-%m-%d'),STR_TO_DATE('" + fechaSalidaSQL + "','%Y-%m-%d')," + numPersonas + "," + precioReserva
				+ ")";
		try {
			st = con.createStatement();
			st.executeUpdate(sql2);
			insertar = true;
			JOptionPane.showMessageDialog(panel, "Reserva de la habitacion realizada correctamente");
			// Cierro el statement y la conexion
			st.close();
			con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(panel, "Fallo en la sentencia SQL");
		}

		return insertar;
	}

	protected Clientes buscarUnCliente(String correo, String clave, JPanel panel) {
		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;
		ResultSet rs;
		int id_personas = 0;
		String nombre = "";
		String apellidos = "";
		String dni = "";
		int telefono = 0;
		String claveEn = "";
		int edad = 0;
		String emailEn = "";
		String interes = "";
		String sql1 = "select * from personas where email= BINARY '" + correo + "' and clave= BINARY '" + clave + "'";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql1);
			if (rs.next()) {
				id_personas = rs.getInt("id_personas");
				nombre = rs.getString("nombre");
				apellidos = rs.getString("apellidos");
				dni = rs.getString("dni");
				telefono = rs.getInt("telefono");
				clave = rs.getString("clave");
				edad = rs.getInt("edad");
				emailEn = rs.getString("email");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(panel, "Fallo en la consulta SQL");
		}
		String sql2 = "select * from clientes where id_personas_aux=" + id_personas;
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql2);
			if (rs.next()) {
				interes = rs.getString("interes");
			}
			// Cierro el resultset, el statement y la conexion
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(panel, "Fallo en la consulta SQL");
		}
		Clientes cliente = new Clientes(nombre, apellidos, dni, telefono, claveEn, edad, emailEn, interes);
		return cliente;
	}

	protected boolean cancelarReservaHabitacion(int numHabitacion, LocalDate entrada, JPanel panel) {
		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;
		boolean cancelar = false;
		int id_habitacion = buscarHabitacion(numHabitacion, panel);

		// Sentencia SQL //fecha entrada
		String sql = "delete from reserva where id_habitaciones_aux=" + id_habitacion
				+ " and fecha_entrada=STR_TO_DATE('" + entrada + "','%Y-%m-%d')";
		try {
			st = con.createStatement();
			st.executeUpdate(sql);
			cancelar = true;
			st.close();
			con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(panel, "Fallo en la sentencia SQL");
		}
		return cancelar;

	}

	protected boolean cancelarReservaActividad(String codigo, String DNI, JPanel panel) {
		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;
		boolean cancelar = false;
		int id_actividad = buscarActividad(codigo, panel);
		int id_cliente = buscarCliente(DNI, panel);
		// Sentencia SQL
		String sql = "delete from apunta where id_clientes_aux=" + id_cliente + " and id_actividades_aux="
				+ id_actividad;
		try {
			st = con.createStatement();
			st.executeUpdate(sql);
			cancelar = true;
			JOptionPane.showMessageDialog(panel, "Reserva cancelada con exito");
			// Cierro el statement y la conexion
			st.close();
			con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(panel, "Fallo en la sentencia SQL");
		}
		return cancelar;
	}

	protected boolean buscarReservaHabitacion(int numeroHabitacion, LocalDate entrada, JPanel panel) {
		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;
		ResultSet rs;
		boolean buscar = false;
		int id_habitacion = buscarHabitacion(numeroHabitacion, panel);

		String sql = "select * from reserva where id_habitaciones_aux=" + id_habitacion + " and"
				+ " fecha_entrada=STR_TO_DATE('" + entrada + "','%Y-%m-%d')";

		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				buscar = true;
			}
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(panel, "Fallo en la sentencia SQL");
		}
		return buscar;
	}

	protected boolean buscarReservaActividad(String DNI, String codigo, JPanel panel) {
		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;
		ResultSet rs;
		boolean buscar = false;
		int id_cliente_aux = buscarCliente(DNI, panel);
		int id_actividades_aux = buscarActividad(codigo, panel);

		String sql = "select * from apunta where id_clientes_aux=" + id_cliente_aux + " and id_actividades_aux="
				+ id_actividades_aux;

		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				buscar = true;
			}
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(panel, "Fallo en la sentencia SQL");
		}
		return buscar;
	}

	protected ArrayList<MostrarReservaActividadCliente> mostrarReservaActividad(JPanel panel, String DNI) {
		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;
		ResultSet rs;
		ArrayList<MostrarReservaActividadCliente> listaMostrarReservaActividadCliente = new ArrayList<>();
		String nombre = "";
		String apellidos = "";
		String dni = "";
		String descripcion = "";
		String codigo = "";
		String tipo_actividad = "";
		String localizacion = "";

		String sql = "select personas.nombre,personas.apellidos,personas.dni,actividades.descripcion,actividades.codigo,actividades.tipo_actividad, actividades.localizacion"
				+ " from (((actividades inner join apunta on(actividades.id_actividades=apunta.id_actividades_aux)) inner join clientes on(apunta.id_clientes_aux=clientes.id_clientes))"
				+ " inner join personas on(clientes.id_personas_aux=personas.id_personas)) where dni='" + DNI + "'";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				nombre = rs.getString("nombre");
				apellidos = rs.getString("apellidos");
				dni = rs.getString("dni");
				descripcion = rs.getString("descripcion");
				codigo = rs.getString("codigo");
				tipo_actividad = rs.getString("tipo_actividad");
				localizacion = rs.getString("localizacion");

				Clientes cliente = new Clientes(nombre, apellidos, dni);
				Actividades actividad = new Actividades(descripcion, tipo_actividad, localizacion, codigo);

				MostrarReservaActividadCliente mostrar = new MostrarReservaActividadCliente(cliente, actividad);
				listaMostrarReservaActividadCliente.add(mostrar);
			}
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(panel, "Fallo en la sentencia SQL");
		}
		return listaMostrarReservaActividadCliente;
	}

	protected ArrayList<MostrarReservaHabitacionCliente> mostrarReservaHabitacion(JPanel panel, String DNI) {
		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;
		ResultSet rs;
		ArrayList<MostrarReservaHabitacionCliente> listaMostrarReservaHabitacionCliente = new ArrayList<>();
		String nombre = "";
		String apellidos = "";
		String dni = "";
		String tipo = "";
		int numero_habitacion = 0;
		Date fechaEntradaConsulta;
		Date fechaSalidaConsulta;
		LocalDate fechaEntradaLocalDate;
		LocalDate fechaSalidaLocalDate;

		String sql = "select personas.nombre,personas.apellidos,personas.dni,habitaciones.tipo,habitaciones.numero_habitacion,reserva.fecha_entrada,reserva.fecha_salida"
				+ " from (((habitaciones inner join reserva on(habitaciones.id_habitaciones=reserva.id_habitaciones_aux))"
				+ " inner join clientes on(reserva.id_clientes_aux=clientes.id_clientes)) inner join personas"
				+ " on(clientes.id_personas_aux=personas.id_personas)) where dni='" + DNI + "'";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				nombre = rs.getString("nombre");
				apellidos = rs.getString("apellidos");
				dni = rs.getString("dni");
				tipo = rs.getString("tipo");
				numero_habitacion = rs.getInt("numero_habitacion");
				fechaEntradaConsulta = rs.getDate("fecha_entrada");
				fechaSalidaConsulta = rs.getDate("fecha_salida");
				fechaEntradaLocalDate = fechaEntradaConsulta.toLocalDate();
				fechaSalidaLocalDate = fechaSalidaConsulta.toLocalDate();
				Reserva reserva = new Reserva(fechaEntradaLocalDate, fechaSalidaLocalDate);
				Clientes cliente = new Clientes(nombre, apellidos, dni);
				Habitaciones habitacion = new Habitaciones(tipo, numero_habitacion);

				MostrarReservaHabitacionCliente mostrar = new MostrarReservaHabitacionCliente(habitacion, cliente,
						reserva);
				listaMostrarReservaHabitacionCliente.add(mostrar);
			}
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(panel, "Fallo en la sentencia SQL");
		}
		return listaMostrarReservaHabitacionCliente;
	}

	protected ArrayList<Clientes> listaMostrarDatosClientes(JPanel panel, String DNI) {
		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;
		ResultSet rs;
		ArrayList<Clientes> listaMostrarDatosCliente = new ArrayList<>();
		String nombre = "";
		String apellidos = "";
		String dni = "";
		int telefono = 0;
		String clave = "";
		int edad = 0;
		String email = "";
		String interes = "";

		String sql = "select personas.nombre,personas.apellidos,personas.dni,personas.telefono,personas.edad,"
				+ "personas.email,clientes.interes from (personas inner join clientes on"
				+ "(personas.id_personas=clientes.id_personas_aux)) where dni='" + DNI + "'";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				nombre = rs.getString("nombre");
				apellidos = rs.getString("apellidos");
				dni = rs.getString("dni");
				telefono = rs.getInt("telefono");
				edad = rs.getInt("edad");
				email = rs.getString("email");
				interes = rs.getString("interes");

				Clientes cliente = new Clientes(nombre, apellidos, dni, telefono, clave, edad, email, interes);
				listaMostrarDatosCliente.add(cliente);
			}
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(panel, "Fallo en la sentencia SQL");
		}
		return listaMostrarDatosCliente;
	}

	protected int comprobarDisponibilidadHabitacionesInt(LocalDate fechaEntrada, LocalDate fechaSalida, JPanel panel,
			int id_habitaciones) {
		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;
		ResultSet rs;
		Date fechaEntradaSQL;
		Date fechaSalidaSQL;
		LocalDate fechaEntradaLocalDate;
		LocalDate fechaSalidaLocalDate;
		String fechaEntradaConsulta = fechaEntrada.toString();
		String fechaSalidaConsulta = fechaSalida.toString();
		boolean disponible = false;
		int id_habitaciones_aux = 0;
		// Sentencia SQL 2
		String sql = "select fecha_entrada,fecha_salida,id_habitaciones_aux from reserva where id_habitaciones_aux="
				+ id_habitaciones + " and fecha_entrada=STR_TO_DATE('" + fechaEntradaConsulta
				+ "','%Y-%m-%d') and fecha_salida=STR_TO_DATE('" + fechaSalidaConsulta + "','%Y-%m-%d')";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				fechaEntradaSQL = rs.getDate("fecha_entrada");
				fechaSalidaSQL = rs.getDate("fecha_salida");
				fechaEntradaLocalDate = fechaEntradaSQL.toLocalDate();
				fechaSalidaLocalDate = fechaSalidaSQL.toLocalDate();
				if (fechaEntrada.isEqual(fechaEntradaLocalDate)) {
					disponible = false;
				} else if (fechaEntrada.isAfter(fechaEntradaLocalDate)) {
					if (fechaEntrada.isBefore(fechaSalidaLocalDate)) {
						disponible = false;
					} else if (fechaEntrada.isAfter(fechaSalidaLocalDate)
							|| fechaEntrada.isEqual(fechaSalidaLocalDate)) {
						disponible = true;
					}
				} else if (fechaEntrada.isBefore(fechaEntradaLocalDate)) {
					if (fechaSalida.isAfter(fechaEntradaLocalDate)) {
						disponible = false;
					} else if (fechaSalida.isBefore(fechaEntradaLocalDate)
							|| fechaSalida.isEqual(fechaEntradaLocalDate)) {
						disponible = true;
					}
				} else if (fechaSalida.isEqual(fechaSalidaLocalDate)) {
					disponible = false;
				}
				if (!disponible) {
					id_habitaciones_aux = rs.getInt("id_habitaciones_aux");
				}
			}
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(panel, "Fallo en la consulta SQL");
		}
		return id_habitaciones_aux;
	}

	protected ArrayList<Habitaciones> mostrarHabitacionesDisponibles(LocalDate fechaEntrada, LocalDate fechaSalida,
			JPanel panel) {
		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st = null;
		ResultSet rs = null;
		ArrayList<Habitaciones> listaHabitacionesDisponibles = new ArrayList<>();
		int numBanios, camas, numHabitacion;
		double precioHabitaciones;
		boolean jacuzzi, matrimonio, terraza;
		String tipo, superficie;
		int id_habitaciones = 0;
		// Sentencia SQL 1
		String sql = "select * from habitaciones";
		boolean disponible = false;
		int id_habitaciones_aux = 0;
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				id_habitaciones = rs.getInt("id_habitaciones");
				id_habitaciones_aux = comprobarDisponibilidadHabitacionesInt(fechaEntrada, fechaSalida, panel,
						id_habitaciones);
				if (id_habitaciones_aux == 0) {
					numBanios = rs.getInt("numero_ba�os");
					jacuzzi = rs.getBoolean("jacuzzi");
					matrimonio = rs.getBoolean("matrimonio");
					tipo = rs.getString("tipo");
					terraza = rs.getBoolean("terraza");
					camas = rs.getInt("camas");
					precioHabitaciones = rs.getDouble("precio_habitaciones");
					superficie = rs.getString("superficie");
					numHabitacion = rs.getInt("numero_habitacion");
					Habitaciones habitacion = new Habitaciones(superficie, tipo, numBanios, camas, numHabitacion,
							precioHabitaciones, jacuzzi, matrimonio, terraza);
					listaHabitacionesDisponibles.add(habitacion);
				}
			}
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(panel, "Fallo en la consulta SQL");
		}
		return listaHabitacionesDisponibles;
	}
}
