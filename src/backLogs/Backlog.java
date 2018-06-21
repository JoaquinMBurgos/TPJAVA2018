package backLogs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

import clases.Proyecto;
import clases.TareaNoValida;
import sun.reflect.generics.tree.Tree;
import tareas.Bug;
import tareas.EstadoTarea;
import tareas.Historia;
import tareas.Mejora;
import tareas.Tarea;

public class Backlog {
	private TreeSet<Tarea> LTareasP = new TreeSet<Tarea>();

	

	/**
	 * Retorna la lista de Tareas pendientes.
	 * @return Lista de Tareas pendientes.
	 */
	public TreeSet<Tarea> getLTareasP() {
		return LTareasP;
	}

	/**
	 * Permite agregar tareas a LTareasP
	 * @param tipo 
	 * @param id  id es de tipo string que contentiene el identificador de una tarea 
	 * @param nombre nombre de una tarea a agregar .  
	 * @param desc descripcion de la tarea a agregar 
	 * @param finalizacion Fecha de finalizacion de la nueva tarea
	 * @param comp complejidad de la nueva tarea , esta definida como un numero entrero
	 * DEPENDE DE SU TIPO BUG , HISTORIA , ETC.
	 */
	public void altaTarea(String tipo, String id, String nombre, String desc,EstadoTarea est, LocalDate finalizacion, int comp){
		Tarea tar;
		switch (tipo){
			case "Bug":
				tar = new Bug(id,nombre,desc,comp);
				break;
			case "Historia":
				tar = new Historia(id,nombre,desc,comp);
				break;
			case "Mejora":
				tar = new Mejora(id,nombre,desc,comp);
				break;
			case "Tarea":
				tar = new Tarea(id,nombre,desc,comp);
				break;
			default:
				tar = null;
				break;	
		}
		LTareasP.add(tar);
	}
	
	/**
	 * Busca tarea con el id pasado como parametro y la retorna
	 * @param id id es de tipo string que contentiene el identificador de la tarea a buscar
	 * @return
	 */
	public Tarea buscaTarea(String id){
		Iterator<Tarea>it = LTareasP.iterator();
		Tarea tar = null;
		boolean bandera = false;
		while(it.hasNext() && !bandera){
			tar= it.next();
			if(tar.getId().equals(id))
				bandera = true;
		}
		return tar;
	}

	/**
	 * 
	 * @param clave clave es de tipo string que contentiene el identificador de una tarea dentro de un backlog
	 * @param tare
	 * Modifica el valor de la clave del backglog.
	 * esta funcion no se esta utilizando 
	 */
	
	public void mBacklogTarea(String clave , Tarea tare) {
		for(Tarea c:LTareasP ){
			if(c.getId().equals(clave)){
				if(c.getEstado() != "finalizado" )
					//c.modTarea(tare.getNombre(),tare.getDescripcion() ,tare.getfFin(), tare.getEstado(), tare.getComplejidad());
			c.getDescripcion();
			}
		}
	}
	
	
	/**
	 * Retorna la tarea con el id inicado por parametro
	 * @param id id es de tipo string que contentiene el identificador de la tarea a devolver 
	 * @return retorna una tarea que coincida con el id que pasamos por parametros
	 */
	public Tarea getTarea(String id){
		boolean bandera = false;
		Iterator<Tarea> it = LTareasP.iterator();
		Tarea tar = null;
		while (it.hasNext() && !bandera){
			tar = it.next();
			if(tar.getId().equals(id))
				bandera = true;
		}
		if (bandera)
			return tar;
		else
			return null;
	}
	
	/**
	 * Devuelve la lista de dependencias de una tarea
	 * @param id de la tarea para la cual se quiere obtener la lista de dependencias
	 * @return lista de dependencias de una tarea
	 */
	public TreeSet<Tarea> getLDependencias(String id){
		Tarea tar = getTarea(id);
		return tar.getLdependencias();
	}
	
	/**
	 * 
	 * @param clave clave es de tipo string que contentiene el identificador de la tarea a eliminar
	 * @return elimina un nodo del treeset que concida con la clave enviada 
	 */
	
	public void bajaTarea(String clave) {
		Iterator<Tarea>it=LTareasP.iterator();
		Tarea t=null;
		boolean bandera=true;
		while(it.hasNext() && bandera){
			t=it.next();
			if(t.getId().equals(clave)){
				it.remove();
				bandera=false;
			}
		}
	}
	
	public void muestraTareas(){
		for(Tarea t:LTareasP){
			t.muestra();
			t.muestraDependencias();
			t.muestraSubTareas();
		}
	}
	
	/**
	 * Devuelve una lista con las tareas menos las tareas que se encuentren en la lista de dependencias de una tarea
	 * @param id de la tarea 
	 * @return lista de tareas
	 */
	public TreeSet<Tarea> getDependencias(String id){
		TreeSet<Tarea>lista=new TreeSet<Tarea>(); 
		lista =LTareasP;
		
		Tarea t=getTarea(id);
		TreeSet<Tarea>listaD=t.getLdependencias();
		for(Tarea dep :listaD)
			lista.remove(dep);
		//lista.remove(t);
		return lista;
	}
	/**
	 * Retorna una lista con las tareas menos las tareas que se encuentren en la lista de dependencias de una tarea y las tareas de complejidad 0 (Subtareas).
	 * @param id ID de la tarea
	 * @return lista con todas las tareas excepto las que estan en la lista de subtareas de la tarea
	 */
	public TreeSet<Tarea> getSubTareas(String id){
		TreeSet<Tarea>lista=new TreeSet<Tarea>(); 
		//lista =LTareasP;
		TreeSet<Tarea> LSubTareas = LTareasP;
		//TreeSet<Tarea> lista1 = new TreeSet<Tarea>();
		for (Tarea tar : LSubTareas){
			if(tar.getComplejidad() == 0 && tar.getId().substring(0,3).equals("TAR"))
				lista.add(tar);
		}
		Tarea t=getTarea(id);
		TreeSet<Tarea>listaST=t.getListaSubtareas();
		for(Tarea sub :listaST)
			lista.remove(sub);
		//lista.remove(t);
		return lista;
	}
	
	/**
	 * Agrega una dependencia a una tarea
	 * @param idT id de la tarea a la que se le agrega la dependencia
	 * @param idDep id de la dependencia que se va a agregar 
	 */
	public void agregaDependencia(String idT,String idDep) throws TareaNoValida{
		Tarea t=getTarea(idT); //tarea a la que hay que agregarle la dependencia
		Tarea tDep=Proyecto.getInstance().getTareaBacklogYSprints(idDep);//dependencia que hay que agregar
		t.agregarDep(tDep);
	}
	/**
	 * Elimina una dependencia de una tarea
	 * @param idT id de la tarea a la que se le elimina la dependencia
	 * @param idDep id de la dependencia que sera eliminada
	 */
	public void bajaDependencia(String idT, String idDep){
		Iterator<Tarea>it=LTareasP.iterator();
		Tarea t=null; 
		Tarea dep=null;
		/*boolean bandera=true;
		while(it.hasNext() && bandera){
			t=it.next();
			if(t.getId().equals(idT)){
				bandera=false;
			}
		}*/
		t=getTarea(idT);
		//dep=getTarea(idDep);
		t.bajaDependencia(idDep);
	}
	
	
	/**
	 * 
	 * @param idT
	 * @param desc
	 * @param pasos
	 * agrega un flujo paso a la tarea 
	 */
	public void agregaFP(String idT,String desc,int pasos){
		Tarea t = getTarea(idT);
		t.agregaFlujoPaso(desc, pasos);
	}
	/**
	 * 
	 * @param idT
	 * @param idSubT
	 * agrega una tarea sobre otra como sub tarea 
	 */
	public void agregaSubTarea(String idT, String idSubT) throws TareaNoValida{
		Tarea t = getTarea(idT);
		Tarea subT = Proyecto.getInstance().getTareaBacklogYSprints(idSubT);
		t.agregarSubT(subT);
	}
	/**
	 * Da de baja una tarea que esta dentro de otra 
	 * @param idT
	 * @param idSubT
	 */
	public void bajaSubTarea(String idT, String idSubT){
		Iterator<Tarea>it=LTareasP.iterator();
		Tarea t=null; 
		Tarea subT=null;
		boolean bandera=true;
		while(it.hasNext() && bandera){
			t=it.next();
			if(t.getId().equals(idT)){
				t.bajaSubT(idSubT);
				bandera=false;
			}
		}
		/**
		 * @deprecate
		 */
		/*Iterator<Tarea>it2=LTareasP.iterator();
		bandera=true;
		while(it2.hasNext() && bandera){
			subT=it2.next();
			if(subT.getId().equals(idSubT)){
				t.bajaSubT(idSubT);
				bandera=false;
			}
		}*/
	}
	/**
	 * agrega una tarea as la lista de tarea pendientes
	 * @param tar
	 */
	public void agregarTarea(Tarea tar) {
		LTareasP.add(tar);
	}

	public void setListaTareas() {
		try{
			LTareasP = (TreeSet<Tarea>) Proyecto.getInstance().Leer("LTareas.ser");
		} catch(ClassNotFoundException | IOException e){
			e.printStackTrace();
		}
		
	}
	
}
