package testsrc;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import es.uva.inf.tds.entornoeducativo.Asignatura;
import es.uva.inf.tds.entornoeducativo.Prueba;
@Category(Sequence.class)
public class AsignaturaSecuenciaTests {

	@Test
	public void testSecuenciaAsignatura1() {
		Asignatura asignatura = new Asignatura("Matematicas", "Hola que tal", 3, LocalDate.now(), LocalDate.now().plusDays(10));
		asignatura.añadePrueba(LocalDate.now().plusDays(5), "Examen1", "Por los loles", 0.3);
		asignatura.añadePrueba(LocalDate.now().plusDays(2),"Examen 2", "Por esparta", 0.3);
		for (Prueba p : asignatura.getPruebas()) {
			p.calificar("Alumno1", 5, LocalDate.now().plusDays(6));
		}
		assertNotNull(asignatura.calificacionesParciales());
		for (Prueba p : asignatura.getPruebas()) {
			p.marcarCalificada(LocalDate.now().plusDays(5));
		}
		assertNotNull(asignatura.calificacionesFinales());
		
	}

}
