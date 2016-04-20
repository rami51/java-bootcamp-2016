package Topic_0.Builder;

public class OracleConexionBuilder implements ConexionBDBuilder{
	private ConexionBD con;
	
	public OracleConexionBuilder(){
		con = new ConexionBD();
	}
	
	@Override
	public void buildHost() {
		con.setHost("localhost");		
	}

	@Override
	public void buildUser() {
		con.setUser("Ramiro");
	}

	@Override
	public void buildPass() {
		con.setPass("ramiro");
	}

	@Override
	public void buildDbmotor() {
		con.setDbmotor("oracle");		
	}

	@Override
	public void buildDbname() {
		con.setDbname("oracleBD");		
	}

	@Override
	public ConexionBD getConexionBD() {
		return con;
	}

}
