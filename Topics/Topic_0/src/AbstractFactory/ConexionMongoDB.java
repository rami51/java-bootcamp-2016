package Topic_0.AbstractFactory;

public class ConexionMongoDB extends NoSQL {

	public String getConexion() {
		return "Conexion MongoDB establecida.";
	}
	public String releaseConexion() {
		return "Conexion MongoDB cerrada.";
	}
}
