package com.bootcamp.topic0.builder;

public class MySQLConexionBuilder implements ConexionBDBuilder {
	private ConexionBD con;
	
	public MySQLConexionBuilder() {
		con = new ConexionBD();
	}

	@Override
	public void buildHost() {
		con.setHost("localhost");
	}

	@Override
	public void buildUser() {
		con.setUser("Ramiro");
	}

	@Override
	public void buildPass() {
		con.setPass("ramiro");		
	}

	@Override
	public void buildDbmotor() {
		con.setDbmotor("mysql");		
	}

	@Override
	public void buildDbname() {
		con.setDbname("mysqlBD");		
	}

	@Override
	public ConexionBD getConexionBD() {
		return con;
		
	}
	

}
