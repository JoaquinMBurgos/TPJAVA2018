package tareas;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import clases.TareaNoValida;

import java.util.Map.Entry;

import estadosTareas.Estado;
import estadosTareas.ToDo;
import historial.Historial;

public class Tarea implements Comparable<Tarea>, Serializable {

	private String id, nombre, descripcion;
	private LocalDate fFin;
	private EstadoTarea estado;
	private ArrayList<Historial> Lhist;
	private int complejidad;
	private TreeSet<Tarea> LSTareas;
	private int estimacion;
	private TreeSet<Tarea> Ldependencias;
	private TreeSet<Tarea> LSubtareas;
	
	public Tarea(String id, String nombre, String descripcion,int complejidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		//this.fFin = finalizacion;
		estado = EstadoTarea.TODO;
		this.complejidad = complejidad;
		Lhist =new ArrayList<Historial>();
		Ldependencias=new TreeSet<Tarea>();
		LSubtareas=new TreeSet<Tarea>();
	}
	
	/**
	 * @return lista de subtareas . 
	 */
	public TreeSet<Tarea> getListaSubtareas() {
		return LSubtareas;
	}
	/**
	 * 
	 * @param tare tarea que se va agregar a un backlog
	 */
	public void aBacklogTarea(Tarea tare) {
		LSTareas.add(tare);
	}
	/**
	 * 
	 * @return retorna lista de dependencias 
	 */
	public TreeSet<Tarea> getLdependencias() {
		return Ldependencias;
	}
	/**
	 * 
	 * @param ldependencias modifica la lista de dependecias
	 */
	public void setLdependencias(TreeSet<Tarea> ldependencias) {
		Ldependencias = ldependencias;
	}
	/**
	 * 
	 * @param clave clave de la tarea a modificar
	 * @param tare	tarea introducida en un backlog que se va a modificar 
	 * Modifica el valor de la clave del backlog.
	 * FALTA EL ESTADO :o !!! 
	 */
	public void mBacklogTarea(String clave , Tarea tare) {
		for(Tarea c:LSTareas ){
			if(c.getId().equals(clave)){
				//if(c.getEstado() != "finalizado" )
					//c.modTarea(tare.getNombre(),tare.getDescripcion() ,tare.getfFin(), tare.getEstado(), tare.getComplejidad());
			c.getDescripcion();
			}
		}
	}
<<<<<<< HEAD
	
=======
	/**
	 * 
	 * @param clave no hace nada -fijar
	 * tare lista de tareas 
	 * elimina un nodo del treeset que concida con la clave enviada 
	 */
	public void bSprintTarea(String clave , Tarea tare) {
		for(Tarea c:LSTareas ){
				LSTareas.remove(c); 
		}
	}
	
	/**
	 * 
	 * @param nombre nombre de la tarea que se va a modificar
	 * @param descripcion descripcion de la tarea que se va a modificar
	 * @param finalizacion fecha de finalizacion de la tarea que se va a modificar
	 * @param estado estado de la tarea que se va a modificar
	 * @param complejidad complejidad de la tarea que se va a modificar
	 */
>>>>>>> 0bed7b656b89fd514bd1adafd6393efc37d7df54
	public void modTarea( String nombre, String descripcion, LocalDate finalizacion, EstadoTarea estado,int complejidad) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fFin = finalizacion;
		this.estado = estado;
		this.complejidad = complejidad;
		Lhist = new ArrayList<>();
	}
	
	
	public String getNombre() {
		return nombre;
	}


	 
	public String getDescripcion() {
		return descripcion;
	} 
	public LocalDate getfFin() {
		return fFin;
	} 
	public String getEstado() {
		return estado.toString();
	}
 
	public ArrayList<Historial> getLhist() {
		return Lhist;
	}

 
	public int getEstimacion() {
		return estimacion;
	}
	/**
	 * 
	 * @param nombre nombre de la tarea que se va a modificar
	 * @param descripcion descripcion de la tarea que se va a modificar
	 * @param finalizacion fecha de finalizacion de la tarea que se va a modificar
	 * @param estado estado de la tarea que se va a modificar
	 * @param complejidad complejidad de la tarea que se va a modificar
	 */
	public void TareaMOD(String nombre, String descripcion, LocalDate finalizacion, EstadoTarea estado,int complejidad) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fFin = finalizacion;
		this.estado = estado;
		this.complejidad = complejidad;
	}
	/**
	 * Retorna el id de la Tarea.
	 * @return id
	 */

	public String getId() {
		return id;
	}
	
	/**
	 * Modifica el id de la Tarea.
	 * @param id identificador de la tarea 
	 */

	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Retorna complejidad de la Tarea.
	 * @return complejidad
	 */
	
	public int getComplejidad() {
		return complejidad;
	}
	
	/**
	 * Compara dos Tareas.
	 * Retorna True si son iguales.
	 * Retorna False si son diferentes.
	 * @param obj
	 * @return true || false
	 */

	public boolean equals(Tarea obj) {
		if (id.equals(obj.getId()))
			return true;
		else
			return false;
	}
	
	/**
	 * Muestra los datos de los pasos que realizó la tarea
	 * hasta el punto actual.
	 */
	
	public void muestraHistorico(){
		Iterator<Historial> it = Lhist.iterator();
		Historial h;
		while (it.hasNext()){
			h=it.next();
			System.out.println(h.getFecha()+" "+h.getEstado());
		}		
	}
	
	/**
	 * 
	 * @param tar nodo de la tarea 
	 * @throws TareaNoValida - una exepcion
	 */
	public void agregarSubT(Tarea tar) throws TareaNoValida{
		if(tar.getId().substring(0, 3).equals("TAR") && tar.getComplejidad()==0)
			LSubtareas.add(tar);
		else
			throw new TareaNoValida();
	}
	/**
	 * 
	 * @param idSubT dentificar de la sub tarea a eliminar . 
	 */
	public void bajaSubT(String idSubT){
		Iterator<Tarea>it=LSubtareas.iterator();
		Tarea t=null;
		boolean bandera=true;
		while(it.hasNext() && bandera){
			t=it.next();
			if(t.getId().equals(idSubT)){
				it.remove();
				bandera=false;
			}
		}
		//LSubtareas.remove(tar);
	}
	/**
	 * 
	 * @param tar  nodo de una tarea 
	 * @throws TareaNoValida -exepcion
	 */
	public void agregarDep(Tarea tar) throws TareaNoValida{
		Ldependencias.add(tar);
	}
	/**
	 * 
	 * @param idDep ide de la dependecia  a eliminar 
	 */
	public void bajaDependencia(String idDep){
		Iterator<Tarea>it=Ldependencias.iterator();
		Tarea t=null;
		boolean bandera=true;
		while(it.hasNext() && bandera){
			t=it.next();
			if(t.getId().equals(idDep)){
				it.remove();
				bandera=false;
			}
		}
	}
	
	public int estimacion(){
		return complejidad;
	}

	/**
	 * Permite la comparación entre una Tarea y 
	 * la Tarea actual.
	 * param @arg0 	
	 */
	@Override
	public int compareTo(Tarea arg0) {
		return this.id.compareTo(arg0.getId());
	}

	public void muestraDependencias(){
		Iterator<Tarea>it=Ldependencias.iterator();
		Tarea t=null;
		if(!Ldependencias.isEmpty()){
			System.out.println("Dependencias:");
			while(it.hasNext()){
				t=it.next();
				System.out.println(t.getId());
			}
		}
	}
	
	public void muestraSubTareas(){
		Iterator<Tarea>it=LSubtareas.iterator();
		Tarea t=null;
		if(!LSubtareas.isEmpty()){
			System.out.println("Subtareas:");
			while(it.hasNext()){
				t=it.next();
				System.out.println(t.getId());
			}
		}
	}
	

	
	public void setfFin(LocalDate fFin) {
		this.fFin = fFin;
	}
	public HashMap<String, Integer> getFlujoPasos() {
		return null;
	}	
	/*public void agregarSubTarea(Tarea tar){
		if(tar.getId().substring(0, 3).equals("TAR") && tar.getComplejidad()!=0)
			LSubtareas.add(tar);
		else
			System.out.println("Las subtareas solo pueden ser de tipo tarea");
	}*/
	public void muestra(){
		System.out.println(id);
	}
	
	public void agregarEstadoHistorial(String est, LocalDate fecha){
		EstadoTarea e=null;
		e=EstadoTarea.valueOf(est);//e.devuelveEstado(est);
		Lhist.add(new Historial(fecha,e));
	}
	
	/**
	 * 
	 * @param est est . es el estado a modificar
	 */
	public void setEstado(String est ){
		EstadoTarea e=null;
		//estado=e.devuelveEstado(est);
		estado=EstadoTarea.valueOf(est);
	}
	
	 public String toString(){
		 return id;
	 }
	 
	 public ArrayList<Entry<String,Integer>>getHashMap(){
		 return null;
	 }

	public void agregaFlujoPaso(String desc, int pasos) {
		// TODO Auto-generated method stub
		
	}
	

	/*
	 * @Override public int compare(Object o1, Object o2) { // TODO
	 * Auto-generated method stub return 0; }
	 */

}
