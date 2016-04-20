package Topic_0.Singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConexion {
	private String dbDriver="com.mysql.jdbc.Driver";
	private Connection conexion;
	private static String host="localhost";
	private static String user="Ramiro";
	private static String pass="ramiro";
	private static String dbname = "ramirobd";
	private static SingletonConexion singleton;
	
	private SingletonConexion() {
		try {
			Class.forName(dbDriver);
			conexion = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static SingletonConexion getInstancia(){
		if(singleton == null) singleton = new SingletonConexion();
		return singleton;
	}
	
	public Connection getConexion(){
		try {
			if(conexion == null || conexion.isClosed())
			conexion = DriverManager.getConnection("jdbc:mysql://"+host+"/"+dbname, user, pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conexion;
	}
	
	public void releaseConexion(){
		try {
			if(!conexion.isClosed()) conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
