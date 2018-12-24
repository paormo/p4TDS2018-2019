package testsrc;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

public class AsignaturaTests {
	
	@Test 
	public void testConstructorActividad() {
		LocalDate aux = LocalDate.now();
		LocalDate aux2= LocalDate.now().plusDays(50);
		Asignatura asignatura = new Asignatura("Mates", "Calculo y Algebra", 10,aux,aux2);
		assertNotNull(asignatura);
	}

	@Before
	public void setUp() throws Exception {
	}


}
