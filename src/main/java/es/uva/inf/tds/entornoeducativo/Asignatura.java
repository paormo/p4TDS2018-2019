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
	public Asignatura (String nombre, String descripcion, double calificacionMaxima, LocalDate diaInicio, LocalDate diaFin) {
		// TODO 
	}
	/**
	 * Permite añadir una prueba a una asignatura
	 * @param fechaPrueba Fecha en la que se va a realizar la prueba
	 * @param nombre Nombre de la Prueba a añadir a la asignatura
	 * @param descripcion Descripcion de la Prueba a añadir a la asignatura
	 * @param pesoEnLaAsignatura Porcentaje que cuenta esa prueba en la asignatura
	 * @throws IllegalArgumentException Si la fechaPrueba es null
	 * @throws IllegalArgumentException Si la fechaprueba es anterior a la fecha de inicio de la asignatura
	 * @throws IllegalArgumentException Si la fecha de la prueba es posterior a la finalizacion de la asignatura
	 * @throws IllegalArgumentException Si el nombre es null
	 * @throws IllegalArgumentException Si existe una prueba en la asignatura con ese nombre
	 * @throws IllegalArgumentException Si la descripcion es null
	 * @throws IllegalArgumentException Si la notaMaxima es menor a 0
	 * @throws IllegalArgumentException Si el peso en la asignatura es null, menor a 0 o mayor a 1
	 * @throws IllegalStateException Si al añadir esta prueba a la asignatura el peso total pasa de 1
	 */
	public void añadePrueba(LocalDate fechaPrueba,String nombre, String descripcion,  double pesoEnLaAsignatura,double notaMax) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Permite obtener laas pruebas que se han hecho en una signatura
	 * @return Arraylist con las pruebas de la asignatura
	 * @throws IllegalStateException Si la asignatura no tiene pruebas
	 */
	public ArrayList<Prueba> getPruebas() {
		// TODO Auto-generated method stub
		return new ArrayList<Prueba>();
	}
	/**
	 * Permite obtener los pares <idAlumno,notaFinal> de la asignatura.
	 * @throws IllegalStateException Si la suma total de pesos de las pruebas no es 1
	 * @throws IllegalStateException Si alguna prueba no está completamente calificada
	 * @return Tabla conteniendo a los alumnos y sus calificaciones finales
	 */
	public Hashtable<String, Integer> calificacionesFinales() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Permite obtener los pares <idAlumno,notaParcial> de la asignatura.
	 * @throws IllegalStateException Si no hay pruebas en la asignatura 
	 * @return Tabla conteniendo los pares alumno-nota parcial de la asignatura 
	 */
	public Hashtable<String, Integer> calificacionesParciales() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getDescripcion() {
		// TODO Auto-generated method stub
		return null;
	}
	public double getCalificacionMaxima() {
		// TODO Auto-generated method stub
		return 0;
	}
	public LocalDate getFechaInicio() {
		// TODO Auto-generated method stub
		return null;
	}
	public LocalDate getFechaFinalizacion() {
		// TODO Auto-generated method stub
		return null;
	}

}
