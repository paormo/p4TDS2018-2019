package testsrc;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.easymock.Mock;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import es.uva.inf.tds.entornoeducativo.Asignatura;
import es.uva.inf.tds.entornoeducativo.Prueba;

/**
 * Test de Caja Blanca para Asignatura
 * 
 * @author paborte
 *
 */

@Category(Isolation.class)
public class AsignaturaAislamientoTests {

  LocalDate auxFechaCalificacion;
  String alumno1 = "id1";
  double nota1 = 10.0;
  double nota2 = 5.0;
  double errorAdmisible = 0.001;

  private Asignatura auxAsignatura;

  @Mock
  private Prueba auxPrueba1;
  private Prueba auxPrueba2;

  @Before
  public void setUp() {
    auxPrueba1 = createMock(Prueba.class);
    auxPrueba2 = createMock(Prueba.class);
    LocalDate auxFechaInicio = LocalDate.now();
    auxFechaInicio = auxFechaInicio.plus(5, ChronoUnit.DAYS);
    auxFechaCalificacion = auxFechaInicio.plus(5, ChronoUnit.DAYS);
    LocalDate auxFechaFin = auxFechaInicio.plus(10, ChronoUnit.DAYS);
    String auxNombreAsignatura = "Nombre de la asignatura";
    String auxDescripcionAsignatura = "Descripcion de la asignatura";
    double auxNotaMaxAsignatura = 10;
    auxAsignatura = new Asignatura(auxNombreAsignatura, auxDescripcionAsignatura, auxNotaMaxAsignatura, auxFechaInicio, auxFechaFin) {
      @Override
      public ArrayList<Prueba> getPruebas() {
        ArrayList<Prueba> mocks = new ArrayList<Prueba>();
        mocks.add(auxPrueba1);
        mocks.add(auxPrueba2);
        return mocks;
      }

      @Override
      public void añadePrueba(LocalDate fecha, String nombre, String descripcion, 
          double pesoEnLaAsignatura,double notaMax) {
        // TODO Auto-generated method stub
      }

      @Override
      public Hashtable<String, Double> calificacionesFinales() {
        Hashtable<String, Double> resultado = new Hashtable<String, Double>();
        resultado.put(alumno1, auxPrueba1.getNota(alumno1) * 0.5 + auxPrueba2.getNota(alumno1) * 0.5);
        return resultado;
      }
      
      @Override
      public Hashtable<String, Double> calificacionesParciales() {
        Hashtable<String, Double> resultado = new Hashtable<String, Double>();
        resultado.put(alumno1, auxPrueba1.getNota(alumno1) * 0.5);
        return resultado;
      }
    };
  }

  @Test
  public void test() {
    expect(auxPrueba1.getNota(alumno1)).andReturn(nota1).times(2);
    expect(auxPrueba2.getNota(alumno1)).andReturn(nota2).once();
    replay(auxPrueba1);
    replay(auxPrueba2);

    auxAsignatura.añadePrueba(auxFechaCalificacion, "Prueba 1", "Descripcion 1", 10.0, 0.5);
    auxAsignatura.añadePrueba(auxFechaCalificacion, "Prueba 2", "Descripcion 2", 5.0, 0.5);

    assertEquals(7.5, auxAsignatura.calificacionesFinales().get(alumno1), errorAdmisible);
    assertEquals(5.0, auxAsignatura.calificacionesParciales().get(alumno1), errorAdmisible);

    verify(auxPrueba1);
    verify(auxPrueba2);
  }

}