package Topic_0.AbstractFactory;

import java.sql.Connection;

public abstract class SQL {
	public abstract Connection getConexion();
	public abstract void releaseConexion();
}
