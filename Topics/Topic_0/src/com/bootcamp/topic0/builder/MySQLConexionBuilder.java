package com.bootcamp.topic0.builder;

public class MySQLConexionBuilder implements ConexionBDBuilder {
	private ConexionBD con;
	
	public MySQLConexionBuilder() {
		con = new ConexionBD();
	}

	@Override
	public ConexionBDBuilder buildHost() {
		con.setHost("localhost");
		return this;
	}

	@Override
	public ConexionBDBuilder buildUser(String string) {
		con.setUser(string);
		return this;
	}

	@Override
	public ConexionBDBuilder buildPass(String string) {
		con.setPass(string);	
		return this;
	}

	@Override
	public ConexionBDBuilder buildDbEngine() {
		con.setDbmotor("mysql");
		return this;
	}

	@Override
	public ConexionBDBuilder buildDbname(String string) {
		con.setDbname(string);	
		return this;
	}

	@Override
	public ConexionBD getConexionBD() {
		return con;
		
	}
	

}
