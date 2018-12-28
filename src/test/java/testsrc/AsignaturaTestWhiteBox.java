package testsrc;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import es.uva.inf.tds.entornoeducativo.Asignatura;
@Category({Unit.class,WhiteBox.class})
public class AsignaturaTestWhiteBox {
	private Asignatura asignaturaSetUp;
	private LocalDate dia1;
	private LocalDate fecha2;
	private LocalDate fecha3;
	private LocalDate fecha4;
	private String nombre1;
	private String descripcion1;

	@Before
	public void setUp() throws Exception {
		nombre1="Matematicas";
		descripcion1="Cálculo y algebra";
		
		dia1=LocalDate.now();
		fecha2=LocalDate.now().plusDays(10);
		fecha3=LocalDate.now().plusDays(20);
		fecha4=LocalDate.now().plusDays(30);
	
		asignaturaSetUp=new Asignatura(nombre1, descripcion1, 10, dia1, fecha4);
		asignaturaSetUp.añadePrueba(fecha2, "Examen3", "LOLOL", 0.0, 5);
	}
	
	@SuppressWarnings("unused")
	@Test (expected=IllegalArgumentException.class)
	public void testConstructorAsignaturaPeroLaFechaFinEsAntesDELaFechaDeInicio() {
		Asignatura asig = new Asignatura(nombre1, descripcion1, 10, fecha3, fecha2);
		
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testAñadePruebaPeroLaNotaMaximaDeLaAsignaturaEsMenorQue0() {
		asignaturaSetUp.añadePrueba(fecha3,nombre1, descripcion1, 0.1, -1);
		
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testGetPruebaPeroElNombreDelaPruebaEsNull() {
		String aux= null;
		asignaturaSetUp.getPrueba(aux);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testGetPruebaPeroLaAsignaturaNoTieneLaPrueba() {
		asignaturaSetUp.getPrueba(nombre1);
	}
	
	@Test 
	public void testGetPrueba() {
		assertNotNull(asignaturaSetUp.getPrueba("Examen3"));
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testCalificacionesFinalesPeroAlgunaPruebaNoEstaCompletamenteCalificada() {
		asignaturaSetUp.añadePrueba(fecha2, "Examen4", "LOLOL", 1, 5);
		asignaturaSetUp.calificacionesFinales();
	}
	
	@Test 
	public void testCalificacionesParciales() {
		asignaturaSetUp.getPrueba("Examen3").calificar(nombre1,3.0,fecha3);
		assertNotNull(asignaturaSetUp.calificacionesParciales());
	}
	
	
	
	
	
	
	
	
	
	
}
