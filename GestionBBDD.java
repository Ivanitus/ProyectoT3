import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.*;

public class GestionBBDD {

	protected void insertarActividades(Actividades act) {

		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;

		String descripcion = act.getDescripcion();
		String tipo = act.getTipo();// controlar que introduzca externa/interna
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

	protected void reservarActividades() {// Reservar actividades

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

	protected int buscarActividad(String codigo) {// Ver si valdria asi

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

	protected int buscarPersonas(String DNI) {

		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;
		ResultSet rs;

		int id = 0;

		String sql = "select id_personas from personas where=" + DNI + "";

		try {

			st = con.createStatement();
			rs = st.executeQuery(sql);

			if (rs.next()) {

				id = rs.getInt("id_personas");

			} else {

				System.out.println("La persona que busca no existe");
			}

		} catch (SQLException e) {

			System.out.println("Fallo en la conexion");
		}

		return id;
	}

	protected int buscarEmpleado(String DNI) {

		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;
		ResultSet rs;

		int id = 0;

		String sql = "select id_empleado from empleados where=" + DNI + "";

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

		int id = 0;

		String sql = "select id_clientes from clientes where=" + DNI + "";

		try {

			st = con.createStatement();
			rs = st.executeQuery(sql);

			if (rs.next()) {

				id = rs.getInt("id_clientes");

			} else {

				System.out.println("El cliente que busca no existe");
			}

		} catch (SQLException e) {

			System.out.println("Fallo en la conexion");
		}
		return id;
	}

	protected void modificarPersonas(String DNI, String opcion, String datonuevo) {

		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;

		int datonuevoInt = 0;
		double datonuevoDouble = 0;

		boolean ejecutarSentenciaSql = true;

		String sql = "update personas set ";

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

		} else {

			System.out.println("El dato a modificar no es valido");
			ejecutarSentenciaSql = false;
		}

		sql += "where DNI=" + DNI;

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

		int id_personas_aux = buscarPersonas(DNI);

		String sql2 = "update empleados set ";

		if (DNI.equalsIgnoreCase("dniEmpleado")) {// Como compararia para saber si es empleado??

			if (opcion.equalsIgnoreCase("salario")) {

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

			String sql3 = "update clientes set ";

			if (opcion.equalsIgnoreCase("interes")) {

				sql3 += opcion + "=" + datonuevo + "";

			} else {

				System.out.println("El dato a modificar no es valido");
				ejecutarSentenciaSql = false;
			}

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

			System.out.println("No se ha podido encontrar a la persona que busca");
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

	protected void calcularPrecioReserva() {

	}
}
