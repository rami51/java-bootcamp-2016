package Topic_0.Builder;

public interface ConexionBDBuilder {
	public void buildHost();
	public void buildUser();
	public void buildPass();
	public void buildDbmotor();
	public void buildDbname();
	public ConexionBD getConexionBD();
}
