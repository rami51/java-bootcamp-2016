package Topic_0.AbstractFactory;

public abstract class AbstractFactory {
	public abstract SQL getSQL(String nombre);
	public abstract NoSQL getNoSQL (String nombre);
}
