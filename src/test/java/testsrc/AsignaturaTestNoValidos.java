package testsrc;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import es.uva.inf.tds.entornoeducativo.Asignatura;
import es.uva.inf.tds.entornoeducativo.Prueba;


@Category({Unit.class,BlackBoxTestFirst.class})
public class AsignaturaTestNoValidos {
	private Asignatura asignaturaSetUp;
	private LocalDate fecha1;
	private LocalDate fecha2;
	private LocalDate fecha3;
	private LocalDate fecha4;
	private String nombre1;
	private String nombre2;
	private String descripcion1;
	private String descripcion2; 
	private Prueba prueba1;
	private Prueba prueba2;
	

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
		nombre1="Matematicas";
		nombre2="Lengua Castellana";
		descripcion1="Cálculo y algebra";
		descripcion2="Literatura y análisis sintáctico";
		fecha1=LocalDate.now();
		fecha2=LocalDate.now().plusDays(10);
		fecha3=LocalDate.now().plusDays(20);
		fecha4=LocalDate.now().plusDays(30);
		prueba1=new Prueba(fecha2,"Examen1", "Tipo Test", 10.0);
		prueba2=new Prueba(fecha3,"Examen2", "Tipo Desarrollar", 5.0);
		asignaturaSetUp=new Asignatura(nombre1, descripcion1, 10, fecha1, fecha4);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAñadirUnaPruebaPruebaEsNull() {
		asignaturaSetUp.añadePrueba(null, 0.2);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testAñadirUnaPruebaPeroElPesoEnLaNotaEsMenorA0(){
		asignaturaSetUp.añadePrueba(prueba1, -1);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testAñadirUnaPruebaPeroElPesoEnLaNotaEsMayora1(){
		asignaturaSetUp.añadePrueba(prueba1, 1.1);
	}
	@Test (expected=IllegalStateException.class)
	public void testAñadirUnaPruebaPeroElPesoEnLaNotaTotalDeLaAsignaturaPasaDe1(){
		asignaturaSetUp.añadePrueba(prueba1, 0.9);
		asignaturaSetUp.añadePrueba(prueba2, 0.2);
	}

}
