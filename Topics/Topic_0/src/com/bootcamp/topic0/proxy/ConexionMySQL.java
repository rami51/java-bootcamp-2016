package com.bootcamp.topic0.proxy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySQL {
	private static String host="localhost";
	private static String user="Ramiro";
	private static String pass="ramiro";
	private static String dbname = "oracleBD";
	private String dbDriver="com.mysql.jdbc.Driver";
	private Connection conexion;

	public ConexionMySQL(){
		try {
			Class.forName(dbDriver);
			conexion = null;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConexion() {
		try {
			if(conexion==null || conexion.isClosed())
				conexion = DriverManager.getConnection("jdbc:mysql://" + host + "/" + dbname, user, pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conexion;
	}
	
	public void releaseConexion() {
		try {
			if(!conexion.isClosed()) conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
