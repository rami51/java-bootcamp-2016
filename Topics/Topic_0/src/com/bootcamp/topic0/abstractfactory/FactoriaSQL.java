package com.bootcamp.topic0.abstractfactory;

public class FactoriaSQL extends AbstractFactory {

	public SQL getSQL(String nombre) {
		if(nombre.equalsIgnoreCase("mysql")) return ConexionMySQL.getInstancia();
		if(nombre.equalsIgnoreCase("oracle")) return ConexionOracle.getInstancia();
		return null;
	}
	public NoSQL getNoSQL(String nombre) {
		return null;
	}
	
}
