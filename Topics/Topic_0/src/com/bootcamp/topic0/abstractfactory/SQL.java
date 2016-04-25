package com.bootcamp.topic0.abstractfactory;

import java.sql.Connection;

public abstract class SQL {
	public abstract Connection getConexion();
	public abstract void releaseConexion();
}
