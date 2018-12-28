package testsrc;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import es.uva.inf.tds.entornoeducativo.Prueba;
/**
 * Test de CAja Blanca para la clase Prueba 
 * 
 * @author paborte
 *
 */

@Category({Unit.class, WhiteBox.class})
public class PruebaTestWhiteBox {
	private LocalDate fecha1;
	private LocalDate fecha2;
	private LocalDate fecha3;
	private String nombre1;
	private String descripcion1;
	private Prueba prueba1;
	private HashMap<String, Double> calificacionesAux;
	private String paco;
	private String nacho;
	private double notaPaco;
	private double notaNacho;

	@Before
	public void setUp() throws Exception {
		nombre1 = "Examen1";
		paco="paquito";
		nacho="Nachito";
		descripcion1="Descripcion1";
		fecha1 = LocalDate.now();
		fecha2 = LocalDate.now().plusDays(10);
		fecha3 = LocalDate.now().plusDays(20);
		prueba1 = new Prueba(fecha2, "Examen1", "Tipo Test", 10.0);
		prueba1.calificar("PepeElTramas", 5, fecha3);
		calificacionesAux = new HashMap<String, Double>();
		calificacionesAux.put(paco, notaPaco);
		calificacionesAux.put(nacho, notaNacho);
	}
	
	@Test 
	public void testConstructorCompleto() {
		Prueba p = new Prueba(fecha1,nombre1,descripcion1,10.0);
		assertEquals(fecha1,p.getFecha());
		assertEquals(nombre1,p.getNombre());
		assertEquals(descripcion1,p.getDescripcion());
		assertEquals(10.0,p.getNotaMax(),0.0);
	}
	
	
	
	@Test (expected=IllegalArgumentException.class)
	public void testCalificarPeroElIdDelAlumnoEsNull() {
		String aux= null;
		prueba1.calificar(aux, 5, fecha3);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testCalificarPeroLaNotaEsMenorA0() {
		prueba1.calificar(nombre1, -15, fecha3);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testCalificarPeroLafechaActualEsNull() {
		LocalDate aux = null;
		prueba1.calificar(nombre1, 5,aux);
	}
	
	@Test (expected=IllegalStateException.class)
	public void testCalificarPeroLaFechaDeCalificarEsAnteriorALaFechaDeLaPrueba() {
		prueba1.calificar(nombre1, 5,fecha1);
	}
	
	@Test (expected=IllegalStateException.class)
	public void testCalificarPeroLaPruebaEstaCoompletamenteCalificada() {
		prueba1.marcarCalificada(fecha3);
		prueba1.calificar(nombre1, 5,fecha3);
	}
	
	
	@Test (expected=IllegalArgumentException.class)
	public void testCalificarPeroLafechaActualEsNullVariasCalificaciones() {
		LocalDate aux = null;
		prueba1.calificar(calificacionesAux,aux);
	}
	
	@Test (expected=IllegalStateException.class)
	public void testCalificarPeroEstaCompletamenteCalificadaVariasCalificaciones() {
		prueba1.marcarCalificada(fecha3);
		prueba1.calificar(calificacionesAux,fecha3);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testModificarPeroElIdDelAlumnoEsNull() {
		String aux= null;
		prueba1.modificar(aux, 5);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testModificarPeroLanotaEsMenorA0() {
		prueba1.modificar("PepeElTramas", -55);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testGetNotaPeroElIdDelAlumnoEsNull() {
		String aux= null;
		prueba1.getNota(aux);
	}
	
	@Test
	public void testCalificarVariosALaVez() {
		prueba1.calificar(calificacionesAux,fecha3);
		assertEquals(notaNacho,prueba1.getNota(nacho),0.0);
		assertEquals(notaPaco,prueba1.getNota(paco),0.0);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testModificarPeroElAlumnoNoTieneUnaCalificacionAun() {
		prueba1.modificar("Pepe", 5);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testGetNotaPeroElAlumnoNoTieneNota() {
		prueba1.getNota("Pepe");
	}
	
	@Test
	public void testPonerVariasCalificacionesALaVez() {
		prueba1.calificar(calificacionesAux, fecha3);
		assertEquals(notaPaco,prueba1.getNota(paco),0.0);
		assertEquals(notaNacho,prueba1.getNota(nacho),0.0);
	}
	
}
