package com.bootcamp.topic0.proxy;

import java.sql.Connection;

public class Client {
	
	public void main(){
		ProxyConexionMySQL proxy = new ProxyConexionMySQL();
		Connection con = proxy.getConexion();
	}
}
