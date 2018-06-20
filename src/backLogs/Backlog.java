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
	 * DEPENDE DE SU TIPO BUG , HISTORIA , ETC 
	 */
	public void altaTarea(String tipo, String id, String nombre, String desc,EstadoTarea est, LocalDate finalizacion, int comp){
		Tarea tar;
		switch (tipo){
			case "Bug":
				tar = new Bug(id,nombre,desc,est,finalizacion,comp);
				break;
			case "Historia":
				tar = new Historia(id,nombre,desc,est,finalizacion,comp);
				break;
			case "Mejora":
				tar = new Mejora(id,nombre,desc,est,finalizacion,comp);
				break;
			case "Tarea":
				tar = new Tarea(id,nombre,desc,est,finalizacion,comp);
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
	/**
	 * CARGA LISTA DE TAREAS DESDE UN .TXT 
	 */
	public void cargaListaTareas(){
		Tarea t=null;
		File f=new File("Tareas.txt");
		String id,nombre,descripcion,dep,subT,fp;
		String e;
		LocalDate fechaFinalizacion;
		EstadoTarea est=null;
		int comp;
		DateTimeFormatter dateForm=DateTimeFormatter.ofPattern("dd/M/yyyy");
		
		try{
		Scanner s=new Scanner(f);
			while(s.hasNextLine()){
				String linea=s.nextLine();
				Scanner sl=new Scanner(linea);
				sl.useDelimiter("\\s*-\\s*");
				id=sl.next();
				nombre=sl.next();
				descripcion=sl.next();
				e=sl.next();
				switch(e){
				case"ToDo":
					est=EstadoTarea.TODO;
					break;
				case"InProgress":
					est=EstadoTarea.INPROGRESS;
					break;
				case"PendingToBuild":
					est=EstadoTarea.PENDINGTOBUILD;
					break;
				case"ReadyToTest":
					est=EstadoTarea.READYTOTEST;
					break;
				case"Testing":
					est=EstadoTarea.TESTING;
					break;
				case"Done":
					est=EstadoTarea.DONE;
				}
				comp=Integer.valueOf(sl.next());
				dep=sl.next();
				subT=sl.next();
				try{
					fechaFinalizacion=LocalDate.parse(sl.next(), dateForm);
				}catch(DateTimeParseException ex){
					fechaFinalizacion=null;
				}
				fp=sl.next();
				switch(id.substring(0,3)){
				case"TAR":{
					t=new Tarea(id,nombre,descripcion,est,fechaFinalizacion,comp);
					break;
				}
				case"HIS":{
					t=new Historia(id,nombre,descripcion,est,fechaFinalizacion,comp);
					//t.agregarFlujoPaso(fp);
					break;
				}
				case"MEJ":{
					t=new Mejora(id,nombre,descripcion,est,fechaFinalizacion,comp);
					break;
				}
				case "BUG":{
					t=new Bug(id,nombre,descripcion,est,fechaFinalizacion,comp);
					break;
				}
				}
				//t.agregarDependencia(dep);
				//t.agregarSubTarea(subT);
				LTareasP.add(t);
				//tareasAuxiliar.add(t);
				//serializa(listaTareas,"tareas.ser");
				//serializa(tareasAuxiliar,"tareasAux.ser");
				sl.close();
				
			}
			
			s.close();
			
		}catch(FileNotFoundException ex){
			ex.printStackTrace();
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
	public void agregaDependencia(String idT,String idDep){
		Iterator<Tarea>it=LTareasP.iterator();
		Tarea t=null; //tarea a la que hay que agregarle la dependencia
		Tarea tDep=null;//dependencia que hay que agregar
		boolean bandera=true;
		/*while(it.hasNext() && bandera){
			t=it.next();
			if(t.getId().equals(idT)){
				bandera=false;
			}
		}*/
		t=getTarea(idT);
		tDep=getTarea(idDep);
		t.agregarDep(tDep);
		/*Iterator<Tarea>it2=LTareasP.iterator();
		bandera=true;
		while(it2.hasNext() && bandera){
			tDep=it2.next();
			if(tDep.getId().equals(idDep)){
				t.agregarDep(tDep);
				bandera=false;
			}
		}*/
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
		//t.bajaDependencia(idDep);
		/*Iterator<Tarea>it2=LTareasP.iterator();
		boolean bandera=true;
		while(it2.hasNext() && bandera){
			subT=it2.next();
			if(subT.getId().equals(idDep)){
				t.bajaDependencia(idDep);
				bandera=false;
			}
		}*/
		//t.getLdependencias().remove(subT);
	}
	
	
	/**
	 * 
	 * @param idT
	 * @param desc
	 * @param pasos
	 * agrega un flujo paso a la tarea 
	 */
	public void agregaFP(String idT,String desc,int pasos){
		Iterator<Tarea>it=LTareasP.iterator();
		Tarea t=null; 
		boolean bandera=true;
		while(it.hasNext() && bandera){
			t=it.next();
			if(t.getId().equals(idT)){
				t.agregaFlujoPaso(desc, pasos);
				bandera=false;
			}
		}
	}
	/**
	 * 
	 * @param idT
	 * @param idSubT
	 * agrega una tarea sobre otra como sub tarea 
	 */
	public void agregaSubTarea(String idT, String idSubT){
		Iterator<Tarea>it=LTareasP.iterator();
		Tarea t=null; 
		Tarea subT=null;
		boolean bandera=true;
		/*while(it.hasNext() && bandera){
			t=it.next();
			if(t.getId().equals(idT)){
				bandera=false;
			}
		}*/
		t=getTarea(idT);
		subT=getTarea(idSubT);
		t.agregarSubT(subT);
		/*Iterator<Tarea>it2=LTareasP.iterator();
		bandera=true;
		while(it2.hasNext() && bandera){
			subT=it2.next();
			if(subT.getId().equals(idSubT)){
				t.agregarSubT(subT);
				bandera=false;
			}
		}*/
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
