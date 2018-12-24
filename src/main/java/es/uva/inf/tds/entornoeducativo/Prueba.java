package es.uva.inf.tds.entornoeducativo;

import java.time.LocalDate;
import java.util.Hashtable;

/**
 * Prueba de una asignatura. Puede calificarse. 
 * Tiene tanto un nombre, una breve descripción, como una fecha de realización.
 * @author anonymous
 */
public class Prueba {
	
	/**
	 * Inicializa una prueba.
	 * @param fecha Fecha de realización de la prueba
	 * @param nombre Identificador de la prueba
	 * @param descripcion Breve información acerca de la prueba
	 * @param notaMax nota máxima que puede obtenerse en la prueba
	 */
	public Prueba(LocalDate fecha, String nombre, String descripcion, double notaMax){
		// TODO 
	}
	
	/**
	 * Informa si la prueba ha sido marcada como completamente calificada o no.
	 * @return true si está completamente calificada, false en otro caso
	 */
	public boolean isCompletamenteCalificada(){
		// TODO cambiar, implementación falsa
		return false;
	}
	
	/**
	 * Devuelve todas las calificaciones de la prueba.
	 * @return tabla hash con pares <identificador de alumno,nota>
	 */
	public Hashtable<String, Double> getCalificaciones(){
		// TODO cambiar, implementación falsa
		return null;
	}
	
	/**
	 * Marca una prueba como que ha sido completamente calificada. Esto no puede revertirse.
	 * @param fechaActual
	 * @throws IllegalStateException si la fecha en la que se marca como calificada es anterior a la fecha de realización de la prueba
	 * @throws IllegalStateException si no hay ninguna calificación
	 */
	public void marcarCalificada(LocalDate fechaActual){
		// TODO
	}
	
	/**
	 * Añade una calificación a una prueba. La nota no podrá ser mayor que la nota máxima y debe añadirse después
	 * de la celebración de la prueba. No debe existir ya una calificación para dicho alumno.
	 * @param id es el identificador del alumno.
	 * @param nota es la nota obtenida en la prueba.
	 * @param fechaActual es la fecha en que se añade la calificación
	 * @throws IllegalStateException si la fecha en la que se califica es anterior a la celebración de la prueba
	 * @throws IllegalStateException si la prueba ya está completamente calificada
	 * @throws IllegalArgumentException si el alumno ya tiene una calificación en la prueba
	 * @throws IllegalArgumentException si la nota supera la nota máxima de la prueba
	 */
	public void calificar(String id, double nota, LocalDate fechaActual){
		// TODO
	}
	
	/**
	 * Añade una lista de calificaciones a una prueba. Las notas no podrán ser mayores que la nota máxima y debe añadirse después
	 * de la celebración de la prueba. No deben existir ya notas para ninguno de sus alumnos.
	 * @param calificaciones tabla hash con pares identificador de alumno, nota
	 * @param fechaActual es la fecha en la que se califica
	 * @throws IllegalStateException si la fecha en la que se califica es anterior a la celebración de la prueba
	 * @throws IllegalStateException si la prueba ya está completamente calificada
	 * @throws IllegalArgumentException si algún alumno ya tiene una calificación en la prueba
	 * @throws IllegalArgumentException si alguna nota supera la nota máxima de la prueba	 
	 */
	public void calificar(Hashtable<String, Double> calificaciones, LocalDate fechaActual){
		// TODO
	}
	
	/**
	 * Modifica la nota de una calificación ya existente.
	 * @param id identificador del alumno al que deseamos modificar la nota
	 * @param nota nueva nota
	 * @throws IllegalArgumentException si el alumno no tiene una nota aún
	 * @throws IllegalArgumentException si la nota supera la nota máxima de la prueba
	 */
	public void modificar(String id, double nota){
		// TODO
	}
	
	/**
	 * Nombre de la prueba
	 * @return retorna siempre una cadena no vacía
	 */
	public String getNombre() {
		// TODO cambiar, implementación falsa
		return "";
	}

	/**
	 * Breve descripción de la prueba.
	 * @return retorna siempre una cadena no vacía
	 */
	public String getDescripcion() {
		// TODO cambiar, implementación falsa
		return "";
	}

	/**
	 * Nota máxima de la prueba.
	 * @return retorna siempre un número mayor que 0
	 */
	public double getNotaMax() {
		// TODO cambiar, implementación falsa
		return 0;
	}
	
	/**
	 * Fecha de celebración de la prueba
	 * @return fecha conectada (no null).
	 */
	public LocalDate getFecha() {
		// TODO cambiar, implementación falsa
		return LocalDate.now();
	}	

	
	/**
	 * Devuelve la nota de un alumno.
	 * @param alumno es el identificador del alumno
	 * @return la nota del alumno en la prueba
	 * @throws IllegalArgumentException si no existe ese alumno en el listado de calificaciones de la prueba
	 */
	public double getNota(String alumno){
		// TODO cambiar, implementación falsa
		return 0;
	}
}
