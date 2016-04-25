package com.bootcamp.topic0.abstractfactory;

public class ConexionMongoDB extends NoSQL {

	public String getConexion() {
		return "Conexion MongoDB establecida.";
	}
	public String releaseConexion() {
		return "Conexion MongoDB cerrada.";
	}
}
