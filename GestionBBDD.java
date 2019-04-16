
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GestionBBDD {
	protected void insertarHabitaciones(Habitaciones habitacionAnadir) {
		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;
		String superficie = habitacionAnadir.getSuperficie();
		String tipo = habitacionAnadir.getTipo();
		int numero_banos = habitacionAnadir.getNumero_banos();
		int camas = habitacionAnadir.getCamas();
		int numero_habitacion = habitacionAnadir.getNumero_habitacion();
		double precio_habitaciones = habitacionAnadir.getPrecio_habitaciones();
		boolean jacuzzi = habitacionAnadir.isJacuzzi();
		boolean matrimonio = habitacionAnadir.isMatrimonio();
		boolean terraza = habitacionAnadir.isTerraza();
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
	protected boolean buscarHabitacion(int numHabitacion) {
		boolean habitacionEncontrada=false;
		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;
		ResultSet rs;
		String sql = "select id_habitaciones from habitaciones where numero_habitacion="+numHabitacion;
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				System.out.println("Habitacion encontrada");
				habitacionEncontrada=true;
				
			} else {
				System.out.println("Habitacion no encontrada");
			}
			//Cierro el statement y la conexion
			st.close();
			con.close();
		}catch(SQLException e) {
			System.out.println("Fallo en la sentencia SQL");
		}
		return habitacionEncontrada;
	}
	protected void eliminarHabitaciones(int numHabitacion) {
		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;
		String sql = "delete from habitaciones where numero_habitacion="+numHabitacion;
		try {
			st = con.createStatement();
			st.executeUpdate(sql);
			System.out.println("Habitacion eliminada correctamente");
			//Cierro el statement y la conexion
			st.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Fallo en la sentencia SQL");
		}
	}
	protected void modificarHabitaciones(int numHabitacion, String datoNuevo, String datoModificar) {
		Conexion conexion = new Conexion();
		Connection con = conexion.getConnection();
		Statement st;
		int datoNuevoInt=0;
		String sql="update habitaciones set ";
		if (datoModificar.equalsIgnoreCase("superficie")) {
			sql+=datoModificar+"='"+datoNuevo+"' ";
		} else if (datoModificar.equalsIgnoreCase("tipo")) {
			if (datoNuevo.trim().equalsIgnoreCase("individual")) {
				sql+=datoModificar+"='individual'";
			} else if (datoNuevo.trim().equalsIgnoreCase("matrimonio")) {
				sql+=datoModificar+"='matrimonio'";
			} else if (datoNuevo.trim().equalsIgnoreCase("suite")) {
				sql+=datoModificar+"='suite'";
			}
		} else if (datoModificar.equalsIgnoreCase("numero de baños")) {
			datoNuevoInt=Integer.parseInt(datoNuevo);
			sql+="numero_baños='"+datoNuevoInt+"' ";
		} else if (datoModificar.equalsIgnoreCase("numero de camas")) {
			datoNuevoInt=Integer.parseInt(datoNuevo);
			sql+="camas='"+datoNuevoInt+"' ";
		} else if (datoModificar.equalsIgnoreCase("numero de la habitacion")) {  //PENDIENTE DE FINALIZAR SU IMPLEMENTACION

		} else if (datoModificar.equalsIgnoreCase("precio de la habitacion")) {

		}
		sql+="where numero_habitacion="+numHabitacion;
	}
}
