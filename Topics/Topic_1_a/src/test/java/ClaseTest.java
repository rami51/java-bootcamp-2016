<<<<<<< HEAD
import junit.framework.TestCase;

public class ClaseTest extends TestCase {
	private Clase objeto;
	
	public void setUp(){
		objeto = new Clase(3,3);
	}
	
	public void testSuma(){
		int resultado = objeto.suma();
		assertEquals(6, resultado);
		assertNotSame(7, resultado);
	}

	public void testResta(){
		int resultado = objeto.resta();
		assertEquals(0, resultado);
	}
	
	public void testMultiplicacion(){
		int resultado = objeto.multiplicacion();
		assertEquals(9, resultado);
	}

}
=======
import junit.framework.TestCase;

public class ClaseTest extends TestCase {
	private Clase objeto;
	
	public void setUp(){
		objeto = new Clase(3,3);
	}
	
	public void testSuma(){
		int resultado = objeto.suma();
		assertEquals(6, resultado);
		assertNotSame(7, resultado);
	}

	public void testResta(){
		int resultado = objeto.resta();
		assertEquals(0, resultado);
	}
	
	public void testMultiplicacion(){
		int resultado = objeto.multiplicacion();
		assertEquals(9, resultado);
	}

}
>>>>>>> Topic0
