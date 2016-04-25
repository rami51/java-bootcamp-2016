package com.bootcamp.topic0.builder;

public interface ConexionBDBuilder {
	public void buildHost();
	public void buildUser();
	public void buildPass();
	public void buildDbmotor();
	public void buildDbname();
	public ConexionBD getConexionBD();
}
