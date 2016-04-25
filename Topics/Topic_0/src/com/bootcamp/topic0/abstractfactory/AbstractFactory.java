package com.bootcamp.topic0.abstractfactory;

public abstract class AbstractFactory {
	public abstract SQL getSQL(String nombre);
	public abstract NoSQL getNoSQL (String nombre);
}
