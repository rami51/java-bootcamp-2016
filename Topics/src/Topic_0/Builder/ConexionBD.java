package Topic_0.Builder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
	private String host;
	private String user;
	private String pass;
	private String dbname;
	private String dbmotor;
	private Connection con;
	
	public Connection getConexion(){
		try {
			con = DriverManager.getConnection("jdbc:"+ dbmotor+"://" + host + "/" + dbname, user, pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public void releaseConexion(){
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getDbname() {
		return dbname;
	}

	public void setDbname(String dbname) {
		this.dbname = dbname;
	}

	public String getDbmotor() {
		return dbmotor;
	}

	public void setDbmotor(String dbmotor) {
		this.dbmotor = dbmotor;
	}

}
