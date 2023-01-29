package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConexion {
	
public static final String JBDC_URL = "jdbc:mysql://localhost:3360/aerarium";
	
	public static Connection instance = null;
	
	private DBConexion() {
		
	}
	
	public static Connection getConnection() throws SQLException {
		
		if (instance == null) {
			
			Properties props = new Properties();
			props.put("user", "root");
			props.put("password", "1234");
			
			instance = DriverManager.getConnection(JBDC_URL, props);
		}
		
		return instance;
	}
	

}
