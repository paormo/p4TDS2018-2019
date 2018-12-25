package es.uva.inf.tds.entornoeducativo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Hashtable;
	/**
	 * Asignatura de una materia. Almacena pruebas. Permite obtener calificaciones de las pruebas que contiene. 
	 * Posee un nombre, una descripcion, una calificacion máxima y una fecha de inicio y fin de la asignatura.
	 * @author paborte
	 *
	 */
public class Asignatura {
	/**
	 * Inicialza una asignatura
	 * @param nombre Nombre de la asignatura
	 * @param descripcion Una breve descripción de la asignatura
	 * @param calificacionMaxima Máxima nota que podrán tener los alumnos de la asignatura
	 * @param diaInicio Fecha en la que comenzó el periodo lectivo de la asignatura
	 * @param diaFin Fecha en la que acaba el perido lectivo de una asignatura
	 */
	public Asignatura (String nombre, String descripcion, int calificacionMaxima, LocalDate diaInicio, LocalDate diaFin) {
		// TODO 
	}
	/**
	 * Permite añadir una prueba a una asignatura
	 * @param prueba Prueba a añadir a la asignatura
	 * @param pesoEnLaAsignatura Porcentaje que cuenta esa prueba en la asignatura
	 * @throws IllegalArgumentException Si la prueba es null
	 * @throws IllegalArgumentException Si el peso en la asignatura es null, menor a 1 o mayor a 1
	 * @throws IllegalStateException Si al añadir esta prueba a la asignatura el peso total pasa de 1
	 */
	public void añadePrueba(Prueba prueba, double pesoEnLaAsignatura) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Permite obtener laas pruebas que se han hecho en una signatura
	 * @return Arraylist con las pruebas de la asignatura
	 * @throws IllegalStateException Si la asignatura no tiene pruebas
	 */
	public ArrayList<Prueba> getPruebas() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Permite obtener los pares <idAlumno,notaFinal> de la asignatura.
	 * @throws IllegalStateException Si la suma total de pesos de las pruebas no es 1
	 * @return Tabla conteniendo a los alumnos y sus calificaciones finales
	 */
	public Hashtable<String, Integer> calificacionesFinales() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Permite obtener los pares <idAlumno,notaParcial> de la asignatura.
	 * @throws IllegalStateException Si no hay pruebas en la asignatura
	 * @throws IllegalStateException 
	 * @return
	 */
	public Hashtable<String, Integer> calificacionesParciales() {
		// TODO Auto-generated method stub
		return null;
	}

}
