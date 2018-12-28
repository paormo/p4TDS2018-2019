package es.uva.inf.tds.entornoeducativo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Asignatura de una materia. Almacena pruebas. Permite obtener calificaciones
 * de las pruebas que contiene. Posee un nombre, una descripcion, una
 * calificacion máxima y una fecha de inicio y fin de la asignatura.
 * 
 * @author paborte
 *
 */
public class Asignatura {
	private String nombre;
	private String descripcion;
	private double calificacionMaxima;
	private LocalDate diainicio;
	private LocalDate diaFin;
	private ArrayList<Prueba> pruebasAsignatura;
	private HashMap<String, Double> pesosPruebas;
	private double pesoTotalActual;

	/**
	 * 
	 * Inicialza una asignatura
	 * 
	 * @param nombre             Nombre de la asignatura
	 * @param descripcion        Una breve descripción de la asignatura
	 * @param calificacionMaxima Máxima nota que podrán tener los alumnos de la
	 *                           asignatura
	 * @param diaInicio          Fecha en la que comenzó el periodo lectivo de la
	 *                           asignatura
	 * @param diaFin             Fecha en la que acaba el perido lectivo de una
	 *                           asignatura
	 */
	public Asignatura(String nombre, String descripcion, double calificacionMaxima, LocalDate diaInicio,
			LocalDate diaFin) {
		if (nombre == null)
			throw new IllegalArgumentException("El nombre no puede ser nulo");
		if (descripcion == null)
			throw new IllegalArgumentException("La descripcion no puede ser nula");
		if (calificacionMaxima < 0)
			throw new IllegalArgumentException("La califacion maxima debe ser mayor a 0");
		if (diaInicio == null)
			throw new IllegalArgumentException("La fecha de inicio no puede ser nula");
		if (diaFin == null)
			throw new IllegalArgumentException("La fecha de finalizacion no puede ser nula");
		if (diaFin.isBefore(diaInicio))
			throw new IllegalArgumentException("La fecha de finalizacion debe ser igual o posterior a la de inicio");
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.calificacionMaxima = calificacionMaxima;
		this.diainicio = diaInicio;
		this.diaFin = diaFin;
		pruebasAsignatura = new ArrayList<>();
		pesosPruebas = new HashMap<>();
		pesoTotalActual = 0.0;

	}

	/**
	 * Permite añadir una prueba a una asignatura
	 * 
	 * @param fechaPrueba        Fecha en la que se va a realizar la prueba
	 * @param nombre             Nombre de la Prueba a añadir a la asignatura
	 * @param descripcion        Descripcion de la Prueba a añadir a la asignatura
	 * @param pesoEnLaAsignatura Porcentaje que cuenta esa prueba en la asignatura
	 * @throws IllegalArgumentException Si la fechaPrueba es null
	 * @throws IllegalArgumentException Si la fechaprueba es anterior a la fecha de
	 *                                  inicio de la asignatura
	 * @throws IllegalArgumentException Si la fecha de la prueba es posterior a la
	 *                                  finalizacion de la asignatura
	 * @throws IllegalArgumentException Si el nombre es null
	 * @throws IllegalArgumentException Si existe una prueba en la asignatura con
	 *                                  ese nombre
	 * @throws IllegalArgumentException Si la descripcion es null
	 * @throws IllegalArgumentException Si la notaMaxima es menor a 0
	 * @throws IllegalArgumentException Si el peso en la asignatura es null, menor a
	 *                                  0 o mayor a 1
	 * @throws IllegalStateException    Si al añadir esta prueba a la asignatura el
	 *                                  peso total pasa de 1
	 */
	public void nuevaPrueba(LocalDate fechaPrueba, String nombre, String descripcion, double pesoEnLaAsignatura,
			double notaMax) {
		if (fechaPrueba == null)
			throw new IllegalArgumentException("La fecha de la prueba no puede ser nula");
		if (nombre == null)
			throw new IllegalArgumentException("El nombre no puede ser nulo");
		if (notaMax < 0)
			throw new IllegalArgumentException("La nota maxima debe ser mayor a 0");
		if (fechaPrueba.isBefore(diainicio))
			throw new IllegalArgumentException(
					"La fecha de la prueba no puede ser anterio a la fecha de inicio de la asignatura");
		if (fechaPrueba.isAfter(diaFin))
			throw new IllegalArgumentException(
					"La fecha de la prueba no puede ser posterio a la fecha de finalizacion de la asignatura");
		if (pesoEnLaAsignatura < 0)
			throw new IllegalArgumentException("El peso en la asignatura de una Prueba debe ser mayor a 0");
		if (pesoEnLaAsignatura > 1)
			throw new IllegalArgumentException("El peso en la asignatura de una Prueba no debe ser mayor a 1");
		if (pesoEnLaAsignatura + pesoTotalActual > 1)
			throw new IllegalStateException("El peso al añadir esta prueba sobrepasa 1, no se puede sobrepasar");
		if (pesosPruebas.containsKey(nombre))
			throw new IllegalArgumentException("Ya existe una prueba en esta asignatura con este nombre");
		Prueba temp = new Prueba(fechaPrueba, nombre, descripcion, notaMax);
		pruebasAsignatura.add(temp);
		pesosPruebas.put(nombre, pesoEnLaAsignatura);
		pesoTotalActual = pesoTotalActual + pesoEnLaAsignatura;
	}

	/**
	 * Permite obtener laas pruebas que se han hecho en una signatura
	 * 
	 * @return Arraylist con las pruebas de la asignatura
	 * @throws IllegalStateException Si la asignatura no tiene pruebas
	 */
	public List<Prueba> getPruebas() {
		if (pruebasAsignatura.isEmpty())
			throw new IllegalArgumentException("La asignatura no tiene ninguna prueba aun");
		return pruebasAsignatura;
	}

	/**
	 * Permite obtener una prueba dando el nombre de esta
	 * 
	 * @throws IllegalArgumentException Si el nombre es null
	 * @throws IllegalArgumentException Si la prueba no esta en esta asignatura
	 * 
	 * @return
	 */
	public Prueba getPrueba(String nombrePrueba) {
		if (nombrePrueba == null)
			throw new IllegalArgumentException("El nombre que se pasa como argumento no puede ser nulo");
		if (!pesosPruebas.containsKey(nombrePrueba)) {
			throw new IllegalArgumentException("La prueba no esta en esta asignatura");
		}
			for (Prueba p : pruebasAsignatura) {
				if (p.getNombre().equals(nombrePrueba))
					return p;
		}
			return null;
		
	}

	/**
	 * Permite obtener los pares <idAlumno,notaFinal> de la asignatura.
	 * 
	 * @throws IllegalStateException Si la suma total de pesos de las pruebas no es
	 *                               1
	 * @throws IllegalStateException Si alguna prueba no está completamente
	 *                               calificada
	 * @return Tabla conteniendo a los alumnos y sus calificaciones finales
	 */
	public Map<String, Double> calificacionesFinales() {
		if (pesoTotalActual != 1)
			throw new IllegalStateException("La suma de pesos de la asignatura no es 1");
		for (Prueba p : pruebasAsignatura) {
			if (!p.isCompletamenteCalificada())
				throw new IllegalArgumentException(
						"La Prueba '" + p.getNombre() + "' no está completamente calificada");
		}
		HashMap<String, Double> calificacionesFinales = new HashMap<>();
		for (Prueba pr : pruebasAsignatura) {// recorremos todas las pruebas de la asignatura
			for(String id : pr.getCalificaciones().keySet()) {
				if (!calificacionesFinales.containsKey(id))
					calificacionesFinales.put(id, 0.0);
				
				calificacionesFinales.put(id, calificacionesFinales.get(id)
						+ (pr.getCalificaciones().get(id) * pesosPruebas.get(pr.getNombre())));
			}
									
		}
		return calificacionesFinales;
	}

	/**
	 * Permite obtener los pares <idAlumno,notaParcial> de la asignatura.
	 * 
	 * @throws IllegalStateException Si no hay pruebas en la asignatura
	 * @return Tabla conteniendo los pares alumno-nota parcial de la asignatura
	 */
	public Map<String, Double> calificacionesParciales() {
		if(pruebasAsignatura.isEmpty())throw new IllegalStateException("La asignatura no posee ninguna prueba todavía");
		Map<String, Double> calificacionesParciales = new HashMap<>();
		for (Prueba pr : pruebasAsignatura) {// recorremos todas las pruebas de la asignatura
			for(String id : pr.getCalificaciones().keySet()) {
				if (!calificacionesParciales.containsKey(id))
					calificacionesParciales.put(id, 0.0);
				calificacionesParciales.put(id, calificacionesParciales.get(id)
						+ (pr.getCalificaciones().get(id) * pesosPruebas.get(pr.getNombre())));
			}
			}
		return calificacionesParciales;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {

		return descripcion;
	}

	public double getCalificacionMaxima() {
		return calificacionMaxima;
	}

	public LocalDate getFechaInicio() {
		return diainicio;
	}

	public LocalDate getFechaFinalizacion() {
		return diaFin;
	}

}
