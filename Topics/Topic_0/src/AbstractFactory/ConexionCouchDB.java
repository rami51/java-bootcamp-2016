package Topic_0.AbstractFactory;

public class ConexionCouchDB extends NoSQL {
	public String getConexion() {
		return "Conexion CouchDB establecida.";
	}
	public String releaseConexion() {
		return "Conexion CouchDB cerrada.";
	}
}
