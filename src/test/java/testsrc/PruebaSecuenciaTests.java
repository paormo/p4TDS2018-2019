package testsrc;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.Hashtable;

import org.junit.Test;

import es.uva.inf.tds.entornoeducativo.Prueba;

public class PruebaSecuenciaTests {

	@SuppressWarnings("deprecation")
	@Test
	public void testSecuenciaTest1() {	
		LocalDate fecha = LocalDate.now();
		String nombre = "Examen";
		String descripcion = "Hola";
		double notaMax= 5.3;
		Hashtable<String, Double> calificaciones = new Hashtable<String, Double>();
		calificaciones.put("id1", 5.3);
		calificaciones.put("id2", 4.5);
		calificaciones.put("paco", 3.2);
		Prueba prueba = new Prueba(fecha, nombre, descripcion, notaMax);
		prueba.calificar("Pepo",2.1,LocalDate.now().plusDays(5));
		prueba.calificar(calificaciones, LocalDate.now().plusDays(5));
		prueba.modificar("id2", 4.0);
		assertEquals(2.1,prueba.getNota("Pepo"));
		assertEquals(5.3,prueba.getNota("id1"));
		assertEquals(4.0,prueba.getNota("id2"));
		prueba.marcarCalificada(LocalDate.now().plusDays(6));
	}

}