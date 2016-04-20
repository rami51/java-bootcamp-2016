package Topic_0.AbstractFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionOracle extends SQL{
	private static String host="localhost";
	private static String user="Ramiro";
	private static String pass="ramiro";
	private static String dbname = "oracleBD";
	private String dbDriver="com.oracle.jdbc.Driver";
	private Connection conexion;
	private static ConexionOracle instancia;

	private ConexionOracle(){
		try {
			Class.forName(dbDriver);
			conexion = null;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ConexionOracle getInstancia() {
		if(instancia==null) instancia = new ConexionOracle();
		return instancia;
	}
	
	@Override
	public Connection getConexion() {
		try {
			if(conexion==null || conexion.isClosed())
				conexion = DriverManager.getConnection("jdbc:oracle://" + host + "/" + dbname, user, pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conexion;
	}
	
	@Override
	public void releaseConexion() {
		try {
			if(!conexion.isClosed()) conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
