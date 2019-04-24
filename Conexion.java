

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	private final String servidor="jdbc:mysql://localhost/hotel";
	private final String user="root";
	private final String pass="";
	private final String driver="com.mysql.jdbc.Driver";
	private Connection conexion;
	
	public Conexion() {
		
		try {
			Class.forName(driver);
			conexion=DriverManager.getConnection(servidor,user,pass);
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Conexion fallida");
		}
	}
	
	public Connection getConnection(){
		return conexion;
	}
}
