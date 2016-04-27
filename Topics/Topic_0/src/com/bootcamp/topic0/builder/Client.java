package com.bootcamp.topic0.builder;

import java.sql.Connection;

public class Client {	
	public void main (){
		ConexionBDBuilder builder = new MySQLConexionBuilder();
		ConexionBD con = builder.buildDbEngine().buildHost().buildDbname("RamiroBD")
		.buildUser("Ramiro").buildPass("Mypass").getConexionBD();
		Connection connection = con.getConexion();
		
		//That's the way you said in the meeting on Monday, Tomi?
		
	}

}
