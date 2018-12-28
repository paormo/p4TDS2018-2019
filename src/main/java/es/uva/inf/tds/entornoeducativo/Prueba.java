package es.uva.inf.tds.entornoeducativo;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Prueba de una asignatura. Puede calificarse. Tiene tanto un nombre, una breve
 * descripción, como una fecha de realización.
 * 
 * @author anonymous
 */
public class Prueba {
	private String nombre;
	private String descripcion;
	private LocalDate fecha;
	private double notaMax;
	private HashMap<String, Double> calificaciones;
	private boolean completamenteCalificada;
	private String errorNullFecha = "La fecha actual no puede ser nula";
	private String errorFechaAnterior = "La fecha de calificacion no puede ser anterior a la de la prueba";
	private String errorCompletamenteCalificada = "La prueba esta completamente calificada, ya no es posible calificar mas";
	private String errorNotaIntroducidaMayorALaMaximaDeLaPrueba = "La nota no puede ser mayor a la nota maxima de la prueba";
	private String errorIdAlumno = "El id del alumno no puede ser nulo";
	private String errorNotaMenorQue0 = "La nota debe ser mayor que 0";
	private String errorElAlumnoNoTieneCalificacion;

	/**
	 * Inicializa una prueba.
	 * 
	 * @param fecha       Fecha de realización de la prueba
	 * @param nombre      Identificador de la prueba
	 * @param descripcion Breve información acerca de la prueba
	 * @param notaMax     nota máxima que puede obtenerse en la prueba
	 */
	public Prueba(LocalDate fecha, String nombre, String descripcion, double notaMax) {

		if (fecha == null)
			throw new IllegalArgumentException("La fecha no puede ser nula");
		if (nombre == null)
			throw new IllegalArgumentException("La descripcion no puede ser nula");
		if (descripcion == null)
			throw new IllegalArgumentException("La descripcion no puede ser nula");
		if (notaMax < 0)
			throw new IllegalArgumentException("La nota maxima debe ser positiva");
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.notaMax = notaMax;
		calificaciones = new HashMap<String, Double>();
		completamenteCalificada = false;
	}

	/**
	 * Informa si la prueba ha sido marcada como completamente calificada o no.
	 * 
	 * @return true si está completamente calificada, false en otro caso
	 */
	public boolean isCompletamenteCalificada() {
		return completamenteCalificada;
	}

	/**
	 * Devuelve todas las calificaciones de la prueba.
	 * 
	 * @return tabla hash con pares <identificador de alumno,nota>
	 */
	public Map<String, Double> getCalificaciones() {
		return calificaciones;
	}

	/**
	 * Marca una prueba como que ha sido completamente calificada. Esto no puede
	 * revertirse.
	 * 
	 * @param fechaActual
	 * @throws IllegalStateException si la fecha en la que se marca como calificada
	 *                               es anterior a la fecha de realización de la
	 *                               prueba
	 * @throws IllegalStateException si no hay ninguna calificación
	 */
	public void marcarCalificada(LocalDate fechaActual) {
		if (fechaActual.isBefore(fecha))
			throw new IllegalStateException(
					"La fechaActual no puede ser anterior a la fecha de realizacion de la prueba");
		if (calificaciones.size() == 0)
			throw new IllegalStateException("No hay calificaciones para esta prueba");
		completamenteCalificada = true;
	}

	/**
	 * Añade una calificación a una prueba. La nota no podrá ser mayor que la nota
	 * máxima y debe añadirse después de la celebración de la prueba. No debe
	 * existir ya una calificación para dicho alumno.
	 * 
	 * @param id          es el identificador del alumno.
	 * @param nota        es la nota obtenida en la prueba.
	 * @param fechaActual es la fecha en que se añade la calificación
	 * @throws IllegalStateException    si la fecha en la que se califica es
	 *                                  anterior a la celebración de la prueba
	 * @throws IllegalStateException    si la prueba ya está completamente
	 *                                  calificada
	 * @throws IllegalArgumentException si el alumno ya tiene una calificación en la
	 *                                  prueba
	 * @throws IllegalArgumentException si la nota supera la nota máxima de la
	 *                                  prueba
	 */
	public void calificar(String id, double nota, LocalDate fechaActual) {
		if (id == null)
			throw new IllegalArgumentException("El id del alumno no puede ser nulo");
		if (nota < 0)
			throw new IllegalArgumentException("La nota debe ser mayor que 0");
		if (fechaActual == null)
			throw new IllegalArgumentException(errorNullFecha);
		if (fechaActual.isBefore(fecha))
			throw new IllegalStateException(errorFechaAnterior);
		if (completamenteCalificada)
			throw new IllegalStateException(errorCompletamenteCalificada);
		if (calificaciones.containsKey(id))
			throw new IllegalArgumentException("El alumno '" + id + "' ya posee una calificacion en esta prueba");
		if (nota > notaMax)
			throw new IllegalArgumentException(errorNotaIntroducidaMayorALaMaximaDeLaPrueba);
		calificaciones.put(id, nota);
	}

	/**
	 * Añade una lista de calificaciones a una prueba. Las notas no podrán ser
	 * mayores que la nota máxima y debe añadirse después de la celebración de la
	 * prueba. No deben existir ya notas para ninguno de sus alumnos.
	 * 
	 * @param calificaciones tabla hash con pares identificador de alumno, nota
	 * @param fechaActual    es la fecha en la que se califica
	 * @throws IllegalStateException    si la fecha en la que se califica es
	 *                                  anterior a la celebración de la prueba
	 * @throws IllegalStateException    si la prueba ya está completamente
	 *                                  calificada
	 * @throws IllegalArgumentException si algún alumno ya tiene una calificación en
	 *                                  la prueba
	 * @throws IllegalArgumentException si alguna nota supera la nota máxima de la
	 *                                  prueba
	 */
	public void calificar(Map<String, Double> calificaciones, LocalDate fechaActual) {
		if (fechaActual == null)
			throw new IllegalArgumentException(errorNullFecha);
		if (fechaActual.isBefore(fecha))
			throw new IllegalStateException(errorFechaAnterior);
		if (completamenteCalificada)
			throw new IllegalStateException(errorCompletamenteCalificada);
		Set<String> ids = ((HashMap<String, Double>) calificaciones).keySet();
		for (String id : ids) {
			if (this.calificaciones.containsKey(id))
				throw new IllegalArgumentException("El alumno con id '" + id
						+ "' ya posee una calificacion en esta prueba. No se añaden las calificaciones.");
			if (calificaciones.get(id) > notaMax)
				throw new IllegalArgumentException(
						"La nota del alumno con id '" + id + "' sobrepasa la nota maxima de la asignatura.");
		}
		
		
		/*String aux;
		while (ids.hasMoreElements()) {
			aux = ids.nextElement();
			if (this.calificaciones.containsKey(aux))
				throw new IllegalArgumentException("El alumno con id '" + aux
						+ "' ya posee una calificacion en esta prueba. No se añaden las calificaciones.");
			if (calificaciones.get(aux) > notaMax)
				throw new IllegalArgumentException(
						"La nota del alumno con id '" + aux + "' sobrepasa la nota maxima de la asignatura.");
		}*/
		this.calificaciones.putAll(calificaciones);
	}

	/**
	 * Modifica la nota de una calificación ya existente.
	 * 
	 * @param id   identificador del alumno al que deseamos modificar la nota
	 * @param nota nueva nota
	 * @throws IllegalArgumentException si el alumno no tiene una nota aún
	 * @throws IllegalArgumentException si la nota supera la nota máxima de la
	 *                                  prueba
	 */
	public void modificar(String id, double nota) {
		if (id == null)
			throw new IllegalArgumentException(errorIdAlumno);
		if (nota < 0)
			throw new IllegalArgumentException(errorNotaMenorQue0);
		if (nota > notaMax)
			throw new IllegalArgumentException(errorNotaIntroducidaMayorALaMaximaDeLaPrueba);
		if (!calificaciones.containsKey(id))
			throw new IllegalArgumentException(errorElAlumnoNoTieneCalificacion);
		calificaciones.replace(id, nota);
	}

	/**
	 * Nombre de la prueba
	 * 
	 * @return retorna siempre una cadena no vacía
	 */
	public String getNombre() {

		return nombre;
	}

	/**
	 * Breve descripción de la prueba.
	 * 
	 * @return retorna siempre una cadena no vacía
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Nota máxima de la prueba.
	 * 
	 * @return retorna siempre un número mayor que 0
	 */
	public double getNotaMax() {
		return notaMax;
	}

	/**
	 * Fecha de celebración de la prueba
	 * 
	 * @return fecha conectada (no null).
	 */
	public LocalDate getFecha() {
		return fecha;
	}

	/**
	 * Devuelve la nota de un alumno.
	 * 
	 * @param alumno es el identificador del alumno
	 * @return la nota del alumno en la prueba
	 * @throws IllegalArgumentException si el alumno es null
	 * @thorws IllegalArgumentException si no existe ese alumno en el listado de
	 *         calificaciones de la prueba
	 */
	public double getNota(String alumno) {
		if (alumno == null)
			throw new IllegalArgumentException(errorIdAlumno);
		if (!calificaciones.containsKey(alumno))
			throw new IllegalArgumentException(errorElAlumnoNoTieneCalificacion);
		return calificaciones.get(alumno);
	}
}
