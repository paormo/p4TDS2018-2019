package testsrc;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import es.uva.inf.tds.entornoeducativo.Asignatura;
import es.uva.inf.tds.entornoeducativo.Prueba;

public class AsignaturaTestsTDD {
	private Asignatura asignaturaSetUp;
	LocalDate dia;
	LocalDate dia2;
	Prueba pruebaAux;
	@Test 
	public void testConstructorActividad() {
		LocalDate aux = LocalDate.now();
		LocalDate aux2= LocalDate.now().plusDays(50);
		Asignatura asignatura = new Asignatura("Mates", "Calculo y Algebra", 10.0,aux,aux2);
		assertNotNull(asignatura);
	}

	@Before
	public void setUp() throws Exception {
		dia = LocalDate.now();
		dia2= LocalDate.now().plusDays(50);
		asignaturaSetUp = new Asignatura("Lengua", "Literatura y Análisis sintáctico", 10,dia,dia2);
		pruebaAux=new Prueba(LocalDate.now().plusDays(2), "Examen 1", "Prueba referente a los temas 1 y 2", 10.0);
	}
	
	@Test 
	public void testAñadirPruebaEnAsignatura() {
		asignaturaSetUp.añadePrueba(dia2,"Nombre Prueba","Prueba de Prueba",10.0);
		
	}
	
	@Test
	public void testObtenerCalificacionesFinalesDeLaAsignatura() {
		assertNotNull(asignaturaSetUp.calificacionesFinales());
	}
	
	@Test 
	public void testObtenerCalificacionesParcialesDeLaAsignatura() {
		assertNotNull(asignaturaSetUp.calificacionesParciales());
	}

}
