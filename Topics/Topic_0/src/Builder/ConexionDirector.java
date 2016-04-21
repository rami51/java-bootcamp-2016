package Topic_0.Builder;

public class ConexionDirector {
	private ConexionBDBuilder builder = null;
	
	public ConexionDirector(ConexionBDBuilder builder){
		this.builder = builder;
	}
	
	public void constructConexionBD(){
		builder.buildHost();
		builder.buildUser();
		builder.buildPass();
		builder.buildDbmotor();
		builder.buildDbname();
	}
	
	public ConexionBD getConexionBD(){
		return builder.getConexionBD();		
	}
}