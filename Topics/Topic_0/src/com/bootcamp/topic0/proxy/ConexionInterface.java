package com.bootcamp.topic0.proxy;

import java.sql.Connection;

public interface ConexionInterface {
	public Connection getConexion();
	public void releaseConexion();

}
