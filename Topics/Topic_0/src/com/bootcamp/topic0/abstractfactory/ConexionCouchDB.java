package com.bootcamp.topic0.abstractfactory;

public class ConexionCouchDB extends NoSQL {
	public String getConexion() {
		return "Conexion CouchDB establecida.";
	}
	public String releaseConexion() {
		return "Conexion CouchDB cerrada.";
	}
}
