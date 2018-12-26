package testsrc;

import java.time.LocalDate;
import java.util.Hashtable;

import org.junit.Before;
import org.junit.Test;

import es.uva.inf.tds.entornoeducativo.Prueba;


public class PruebaTestNoValidos {

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
	private LocalDate fechaVieja;
	private String idAlumno1;
	private Hashtable<String, Double >calificacionesAux;
	
	@SuppressWarnings("unused")
	@Test(expected=IllegalArgumentException.class)
	public void testConstructorPruebaPeroFechaEsNull () {
		LocalDate aux =null;
		Prueba prueba = new Prueba(aux,nombre1,descripcion1,10);
	}
	
	@SuppressWarnings("unused")
	@Test(expected=IllegalArgumentException.class)
	public void testConstructorPruebaPeroNombreEsNull () {
		String aux =null;
		Prueba prueba = new Prueba(fecha1,aux,descripcion1,10);
	}
	
	@SuppressWarnings("unused")
	@Test(expected=IllegalArgumentException.class)
	public void testConstructorPruebaPeroDescripcionEsNull () {
		String aux =null;
		Prueba prueba = new Prueba(fecha1,nombre1,aux,10);
	}
	
	@SuppressWarnings("unused")
	@Test(expected=IllegalArgumentException.class)
	public void testConstructorPruebaPeroNotaMaximaEsNegativa () {
		Prueba prueba = new Prueba(fecha1,nombre1,descripcion1,-1);
	}
	
	@SuppressWarnings("unused")
	@Test(expected=IllegalArgumentException.class)
	public void testConstructorPruebaPeroFechaEsAnteriorAlDiaActual () {
		Prueba prueba = new Prueba(fechaVieja,nombre1,descripcion1,-1);
	}
	
	@Before
	public void setUp() throws Exception {
		nombre1="Examen1";
		nombre2="Examen2";
		descripcion1="TEST";
		descripcion2="NORMAL";
		fecha1=LocalDate.now();
		fecha2=LocalDate.now().plusDays(10);
		fecha3=LocalDate.now().plusDays(20);
		fecha4=LocalDate.now().plusDays(30);
		prueba1=new Prueba(fecha2,"Examen1", "Tipo Test", 10.0);
		prueba1.calificar("PepeElTramas",5,fecha1);
		prueba2=new Prueba(fecha3,"Examen2", "Tipo Desarrollar", 5.0);
		idAlumno1="pepe";
		calificacionesAux = new Hashtable<String, Double>();
		calificacionesAux.put("Paquito",3.2);
		calificacionesAux.put("Nachito",3.3);
	}
	
	@Test(expected=IllegalStateException.class)
	public void testMarcarCalificadaPeroLaFechaEsAnteriorALaFechaDeRealizacionDeLaPrueba () {
		prueba2.marcarCalificada(fecha1);
	}
	
	@Test(expected=IllegalStateException.class)
	public void testMarcarCalificadaPeroNoHayNingunaCalificacion () {
		prueba2.marcarCalificada(fecha4);
	}
	
	@Test(expected=IllegalStateException.class)
	public void testCalificarPeroLaFechaEsAnteriorALaFechaDeLaPrueba () {
		prueba2.calificar(idAlumno1, 4.3, fecha2);
	}
	
	@Test(expected=IllegalStateException.class)
	public void testCalificarPeroLaPruebaEstaCompletamenteCalificadaa () {
		prueba2.marcarCalificada(fecha4);
		prueba2.calificar(idAlumno1, 4.3, fecha2);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCalificarPeroElAlumnoYaEstaCalificado () {
		prueba2.calificar(idAlumno1, 4.3, fecha4);
		prueba2.calificar(idAlumno1, 4.3, fecha4);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testCalificarPeroLaNotaMaximaEsMayorQueLaNotaMaximaDeLaPrueba () {
		prueba2.calificar(idAlumno1, 11, fecha4);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCalificarVariosPeroHayAlgunAlumnoConCalificacion () {
		prueba2.calificar("Paquito", 4.5, fecha4);
		prueba2.calificar(calificacionesAux, fecha4);
	}
	
	@Test(expected=IllegalStateException.class)
	public void testCalificarVariosPeroLaPruebaEstaCompletamenteCalificada () {
		prueba2.marcarCalificada(fecha4);
		prueba2.calificar(calificacionesAux, fecha4);
	}
	
	@Test(expected=IllegalStateException.class)
	public void testCalificarVariosPeroLaEnQueSeCalificaEsAnteriorALaDeLaPrueba () {
		prueba2.calificar(calificacionesAux, fecha2);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCalificarVariosPeroAlgunaNotaSuperaALaMaximaDelaPrueba() {
		calificacionesAux.put("PepeBiyuela", 5.4);
		prueba2.calificar(calificacionesAux, fecha4);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testModificarPeroElAlumnoNoTieneUnaNotaAun () {
		prueba1.modificar(idAlumno1, 4.5);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testModificarPeroLaNotaSobrepasaLaMaximaDeLaPrueba () {
		prueba1.modificar(idAlumno1, 10.5);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetNotaPeroNoExisteElAlumnoEnLaPrueba () {
		prueba1.getNota("RomeroElMadero");
	}
	
	
}
