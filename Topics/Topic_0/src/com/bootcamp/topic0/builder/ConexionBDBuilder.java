package com.bootcamp.topic0.builder;

public interface ConexionBDBuilder {
	public ConexionBDBuilder buildHost();
	public ConexionBDBuilder buildUser(String string);
	public ConexionBDBuilder buildPass(String string);
	public ConexionBDBuilder buildDbEngine();
	public ConexionBDBuilder buildDbname(String string);
	public ConexionBD getConexionBD();
}
