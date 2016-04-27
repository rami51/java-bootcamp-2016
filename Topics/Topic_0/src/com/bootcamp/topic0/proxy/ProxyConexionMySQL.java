package com.bootcamp.topic0.proxy;

import java.sql.Connection;

public class ProxyConexionMySQL implements ConexionInterface {
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
