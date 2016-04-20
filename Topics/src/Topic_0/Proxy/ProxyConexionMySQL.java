package Topic_0.Proxy;

import java.sql.Connection;

public class ProxyConexionMySQL {
	ConexionMySQL instancia;
	
	public Connection getConexion(){
		if(instancia==null) instancia = new ConexionMySQL();;
		return instancia.getConexion();
	}
	
	public void releaseConexion(){
		if(instancia==null) instancia = new ConexionMySQL();
		instancia.releaseConexion();
	}
}