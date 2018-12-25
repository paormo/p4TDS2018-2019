package testsrc;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import es.uva.inf.tds.entornoeducativo.Asignatura;

public class AsignaturaTestNoValidos {

	@Test (expected=IllegalArgumentException.class)
	public void testNombreEnConstructorNull() {
		LocalDate aux= LocalDate.now();
		LocalDate aux2 = LocalDate.now().plusDays(2);
		Asignatura asignatura = new Asignatura(null, "descripcion", 10, aux, aux2 );
		
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testDescripcionEnConstructorNull() {
		LocalDate aux= LocalDate.now();
		LocalDate aux2 = LocalDate.now().plusDays(2);
		Asignatura asignatura = new Asignatura("Nombre", null, 10, aux, aux2 );
	}
	@Test (expected=IllegalArgumentException.class)
	public void testNotaMaximaAsignaturanEnConstructorMenorQue0() {
		LocalDate aux= LocalDate.now();
		LocalDate aux2 = LocalDate.now().plusDays(2);
		Asignatura asignatura = new Asignatura("Nombre","Descripcion", -1, aux, aux2 );
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testAsignaturaAlgunaFechanEnConstructorNull1() {
		LocalDate aux= null;
		LocalDate aux2 = LocalDate.now().plusDays(2);
		Asignatura asignatura = new Asignatura("Nombre","Descripcion", 10, aux, aux2 );
	}
	@Test (expected=IllegalArgumentException.class)
	public void testAsignaturaAlgunaFechanEnConstructorNull2() {
		LocalDate aux=LocalDate.now();
		LocalDate aux2 = null;
		Asignatura asignatura = new Asignatura("Nombre","Descripcion", 10, aux, aux2 );
	}
	
	
	@Before
	public void setUp() throws Exception {
	}

}
