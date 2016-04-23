import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FileTest {
	File f;
	
	@Before
	public void setUp() throws Exception {
		f = new File();
		f.setName("File-T");
	}

	@Test
	public void WhenIsClosedTest() {
		f.close();
		assertTrue(f.isOpen() == false);
	}
	
	@Test
	public void WhenIsOpenTest(){
		f.open();
		assertTrue(f.isOpen() == true);
	}
	
	@Test
	public void getNameTest(){
		assertEquals("File-T", f.getName());
	}

}
