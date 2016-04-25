package com.bootcamp.topic0.abstractfactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySQL extends SQL {
	private static String host="localhost";
	private static String user="Ramiro";
	private static String pass="ramiro";
	private static String dbname = "mysqlBD";
	private String dbDriver="com.mysql.jdbc.Driver";
	private Connection conexion;
	private static ConexionMySQL instancia;

	private ConexionMySQL(){
		try {
			Class.forName(dbDriver);
			conexion = null;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ConexionMySQL getInstancia() {
		if(instancia==null) instancia = new ConexionMySQL();
		return instancia;
	}
	
	@Override
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
