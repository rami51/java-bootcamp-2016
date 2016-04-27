package com.bootcamp.topic0.abstractfactory;

public class FactoriaNoSQL extends AbstractFactory {

	@Override
	public SQL getSQL(String nombre) throws Exception {
		Exception e = new Exception("Class FactoriaNoSQL does not support this method of AbstractFactory.");
		throw e;
	}

	//Can I resolve the proposed problem with that? (Look above!)
	
	@Override
	public NoSQL getNoSQL(String nombre) {
		NoSQL con=null;
		if(nombre.equalsIgnoreCase("couchdb"))
			con =  new ConexionCouchDB();
		if(nombre.equalsIgnoreCase("oracle"))
			con =  new ConexionMongoDB();
		return con;
	}

}
