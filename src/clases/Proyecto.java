/**
 * 
 */
package clases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
//import java.util.Date;
import java.util.Iterator;
import java.util.TreeSet;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.plaf.OptionPaneUI;
import javax.swing.table.DefaultTableModel;

import GUI.AdminSprints;
import backLogs.Backlog;
import estadosTareas.Estado;
import tareas.Tarea;

import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
/**
 * @author jose_
 *
 */
public final class Proyecto {
	private Backlog blog = new Backlog();
	private TreeSet<Sprint> LSprints = new TreeSet<Sprint>();
	
	private static Proyecto instance = null;
	
	/**
	 * Retorna la unica instancia de Proyecto existente
	 * @return un Proyecto
	 */
	public static Proyecto getInstance(){
		
		if (instance == null)
			instance = new Proyecto(); 
		
		return instance; 	
	}
	
	/**
	 * Retorna un Backlog
	 * @return Backlog
	 */
	public Backlog getBlog() {
		return blog;
	}
	
	/**
	 * Genera una alta de un nuevo Sprint
	 * @param clave Se le asignara la clave al nuevo Sprint
	 * @param descripcion Se le asignara la descripcion al nuevo Sprint
	 */
	public void altaSprint(String clave , String descripcion) {
		LSprints.add(new Sprint(clave, descripcion));
	}
	
	/**
	 * Retorna la lista de Sprints del Proyecto
	 * @return Lista de Sprints
	 */
	public TreeSet<Sprint> getLSprints() {
		return LSprints;
	}
	
	/**
	 * Retorna las tareas de complejidad 0 (Subtareas).
	 * @return Lista de Subtareas del Backlog.
	 */
	public TreeSet<Tarea> getSubTareas(){
		TreeSet<Tarea> LSubTareas = blog.getLTareasP();
		TreeSet<Tarea> lista = new TreeSet<Tarea>();
		for (Tarea tar : LSubTareas){
			if(tar.getComplejidad() == 0)
				lista.add(tar);
		}
		return lista;
		
	}
	
	/**
	 * Da de baja un Sprint de la lista con la clave indicada
	 * @param clave Clave del Sprint a buscar para dar de baja
	 * @throws SprintNoValido cuando el Sprint es ENCURSO o FINALIZADO, los cuales no pueden ser dados de baja
	 */
	public void bajaSprint(String clave) throws SprintNoValido{
		Sprint sp = getSprint(clave);
		if(sp.getEstado()==EstadoSprint.PLANIFICADO){
			for(Tarea tar:sp.getListaT())
				blog.agregarTarea(tar);
			LSprints.remove(sp);
		}
	}
	
	/**
	 * Permite actualizar el Sprint pasado como parametro
	 * @param clave Clave del Sprint a modificar
	 * @param descricion Descripcion que se desea actualizar
	 */
	public void modificacionSprint(String clave ,String descricion){
		for(Sprint c:LSprints){
			if(c.getClave().equals(clave)){
				c.actualizar(clave, descricion);
			}
		}
	}
	
	/**
	 * Para ver lista de Sprints
	 * Despues borrar
	 */
	public void corrersp(){
		for(Sprint lt : LSprints) {
			System.out.println(lt.getClave());
			lt.muestraTareasSprint();
		}
	}
	
	/**
	 * Agrega una Tarea a un Sprint
	 * @param idS Sprint al cual se le agregara una Tarea
	 * @param idT Tarea que sera agregada al Sprint
	 */
	public void agregarTareasSprint(String idS,String idT){
		Iterator<Sprint>its=LSprints.iterator();
		Iterator<Tarea>itt;
		Sprint sp=null;
		Tarea tar=null;
		boolean bandera=true;
		while(its.hasNext() && bandera){
			sp=its.next();
			if(sp.getClave().equals(idS)){
				//sp.aSprintTarea(tar);
				bandera=false;
			}
		}
		itt=blog.getLTareasP().iterator();
		bandera=true;
		while(itt.hasNext() && bandera){
			tar=itt.next();
			if(tar.getId().equals(idT)){
				sp.aSprintTarea(tar);
				//blog.bajaTarea(tar.getId());
				itt.remove();
				bandera=false;
			}
			
		}
	}
	
	/**
	 * Imprime por pantalla la lista de tareas
	 */
	public void mostrarTareas(){
		blog.muestraTareas();
	}
	
	/**
	 * Agrega una Tarea como dependencia de otra Tarea.
	 * @param idT Id de Tarea a la que agregarle una dependencia.
	 * @param idDep Id de la Tarea que sera agregada como dependencia.
	 */
	public void agregarDependencias(String idT,String idDep) throws TareaNoValida{
		blog.agregaDependencia(idT, idDep);
	}
	
	/**
	 * Elimina una Dependencia de una Tarea.
	 * @param idT Id de la Tarea a la que eliminarle la Dependencia.
	 * @param idDep Id de la Dependencia a ser eliminada de la Tarea.
	 */
	public void eliminarDependencia(String idT,String idDep){
		blog.bajaDependencia(idT, idDep);
	}
	
	/**
	 * Agrega un FlujoPaso a una Tarea.
	 * @param idT Id de la Tarea a la que agregarle un FlujoPaso.
	 * @param descripcion del FlujoPaso.
	 * @param pasos del FlujoPaso.
	 */
	public void agregarFlujoPaso(String idT, String descripcion, int pasos){
		blog.agregaFP(idT, descripcion, pasos);
	}
	
	/**
	 * Retorna todos los Sprints que se encuentren ENCURSO
	 * @return Springs en Curso
	 */
	public TreeSet<Tarea> getTareasSprintEnCurso() {
		Sprint sp = null;
		boolean bandera = true;
		Iterator<Sprint> it = LSprints.iterator();
		while(it.hasNext() && bandera)
			sp = it.next();
			if(sp.getEstado() == EstadoSprint.ENCURSO)
				bandera = false;
		if (bandera)
			return null;
		else
			return sp.getListaT();
	}
	
	
	/**
	 * Devuelve los datos del Sprint que se encuentra ENCURSO
	 * 
	 */
	public void setAdmSprintEnCurso(String clave, String descripcion, String estado, String avance, String duracion) {
		Sprint sp = null;
		boolean bandera = true;
		Iterator<Sprint> it = LSprints.iterator();
		while(it.hasNext() && bandera)
			sp = it.next();
			if(sp.getEstado() == EstadoSprint.ENCURSO)
				bandera = false;
		if (bandera) {
			clave = "ID Sprint";
			descripcion = "Nombre Sprint";
			estado = "Estado Actual";
			avance = "0";
			duracion = "0";
		}
		else {
			clave = sp.getClave();
			descripcion = sp.getDescripcion();
			estado = "EN CURSO";
			avance.valueOf(sp.getAvance());
			duracion = "0";
		}
	}
	
	
	/**
	 * Calcula la estimacion del Sprint indicado
	 * @param idSprint Id del Sprint
	 * @return la estimacion del Sprint
	 */
	public int calcularEstimacionSprint(String idSprint){
		Sprint sp=null;
		boolean bandera=true;
		Iterator<Sprint> it = LSprints.iterator();
		int estimacion=0;
		while(it.hasNext() && bandera){
			sp=it.next();
			if(sp.getClave().equals(idSprint)){
				estimacion=sp.estimacionSprint();
				bandera=false;
			}
		}
		return estimacion;
	}
	
	/**
	 * Calcula la estimacion de la Historia indicada
	 * @param idSprint Id del Sprint que contiene la Historia
	 * @return la estimacion de la Historia
	 */
	public int calcularEstimacionHistoriaSprint(String idSprint){
		Sprint sp=null;
		boolean bandera=true;
		Iterator<Sprint> it = LSprints.iterator();
		int estimacion=0;
		while(it.hasNext() && bandera){
			sp=it.next();
			if(sp.getClave().equals(idSprint)){
				estimacion=sp.estimacionHistoriaSprint();
				bandera=false;
			}
		}
		return estimacion;
	}
	
	/**
	 * Da de baja una Tarea de un Sprint.
	 * @param idSprint Id del Sprint al que se le dara de baja la Tarea.
	 * @param idTarea Id de la Tarea que sera dada de baja.
	 */
	public void bajaTareaSprint(String idSprint,String idTarea){
		Sprint sp=getSprint(idSprint);
		if(sp.getEstado()!=EstadoSprint.FINALIZADO){
			Tarea tar=sp.getTarea(idTarea);
			blog.agregarTarea(tar);
			sp.bajaTarea(idTarea);
		}
		else
			JOptionPane.showMessageDialog(null, "No se pueden eliminar tareas de un sprint finalizado");
	}
	
	/**
	 * Agrega las Tareas del Sprint en curso al Backlog.
	 */
	public void pasaTareasaBacklog(){
		Sprint sp = getSprintEnCurso();
		for(Tarea tar : sp.tareasNoCompletadas()){
			blog.agregarTarea(tar);
		}		
	}
	
	/**
	 * 
	 * @return lista de todas las tareas que se encuentran en Sprints y BackLog
	 */
	
	public TreeSet<Tarea> tareasBacklogYSprints(){
		TreeSet<Tarea> lista = new TreeSet<Tarea>();
		for(Sprint sp : LSprints){
			if(sp.getEstado()!=EstadoSprint.FINALIZADO)
				for (Tarea tar : sp.getListaT()){
					lista.add(tar);
				}
		}
		for (Tarea tar : blog.getLTareasP()){
			lista.add(tar);
		}
		/*TreeSet<Tarea> lista1 =blog.getTarea(id).getLdependencias();
		for(Tarea tar:lista1)
			lista.remove(tar);*/
		return lista;
		
	}
	
	public TreeSet<Tarea> tareasBacklogYSprintsSinDependencias(String id){
		TreeSet<Tarea> lista = new TreeSet<Tarea>();
		for(Sprint sp : LSprints){
			if(sp.getEstado()!=EstadoSprint.FINALIZADO)
				for (Tarea tar : sp.getListaT()){
					lista.add(tar);
				}
		}
		for (Tarea tar : blog.getLTareasP()){
			lista.add(tar);
		}
		TreeSet<Tarea> lista1 = getTareaBacklogYSprints(id).getLdependencias();
		for(Tarea tar:lista1)
			lista.remove(tar);
		return lista;
		
	}
	
	public TreeSet<Tarea> tareasBacklogYSprintsSinSubTareas(String id){
		TreeSet<Tarea> lista = new TreeSet<Tarea>();
		for(Sprint sp : LSprints){
			if(sp.getEstado()!=EstadoSprint.FINALIZADO)
				for (Tarea tar : sp.getListaT()){
					if(tar.getComplejidad()==0)
						lista.add(tar);
				}
		}
		for (Tarea tar : blog.getLTareasP()){
			if(tar.getComplejidad()==0)
				lista.add(tar);
		}
		TreeSet<Tarea> lista1 =getTareaBacklogYSprints(id).getListaSubtareas();
		for(Tarea tar:lista1)
			lista.remove(tar);
		return lista;
		
	}
	
	/**
	 * Da de baja una tarea del Backlog.
	 * @param idTarea Id de la Tarea a dar de baja del Backlog.
	 */
	public void bajaTareaBackLog(String idTarea){
		blog.bajaTarea(idTarea);
	}
	/**
	 * Agregar Tarea como Subtarea de otra Tarea.
	 * @param idT Id Tarea a la que se le agregara la Subtarea.
	 * @param idSubT Id Tarea a agregar como Subtarea.
	 */
	public void agregaSubT(String idT,String idSubT) throws TareaNoValida{
		blog.agregaSubTarea(idT, idSubT);
	}
	
	/**
	 * Eliminar Subtarea de una Tarea.
	 * @param idT Id Tarea a la que se le eliminara la Subtarea.
	 * @param idSubT Id Tarea a eliminar como Subtarea.
	 */
	public void eliminarSubT(String idT,String idSubT){
		blog.bajaSubTarea(idT, idSubT);
	}
	
	/**
	 * Cambia el estado de un Sprint por el pasado como parametro.
	 * @param idSprint Id del Sprint a cambiarle el estado.
	 * @param estado Estado al que se le desea cambiar el Sprint.
	 */
	public void cambiarEstadoSprint(String idSprint,String estado) throws SprintNoValido{
		
		Iterator<Sprint>it=LSprints.iterator();
		Sprint sp=null;
		boolean bandera=true;
		while(it.hasNext() && bandera){
			sp=it.next();
			if(sp.getEstado().toString().equals("ENCURSO"))
				bandera=false;
		}
		Sprint s=getSprint(idSprint);
		if(bandera)
			s.cambiarEstado(estado);
		else
			throw new SprintNoValido();
	}
	
	/**
	 * Busca un Sprint y lo retorna.
	 * @param idSprint Id del Sprint a buscar
	 * @return Sprint buscado.
	 */
	public Sprint getSprint(String idSprint){
		Iterator<Sprint>it=LSprints.iterator();
		Sprint sp=null;
		boolean bandera=false;
		while(it.hasNext() && !bandera){
			sp=it.next();
			if(sp.getClave().equals(idSprint))
				bandera=true;
		}
		return sp;
	}
	
	/**
	 * Pone en curso un Sprint, asignandole Fecha de inicio y de fin.
	 * @param idSprint Id del Sprint a poner en curso.
	 * @param fi Fecha de inicio a asignar.
	 * @param ff Fecha de fin a asignar.
	 */
	public void sprintEnCurso(String idSprint, LocalDate fi,LocalDate ff){
		Sprint s=getSprint(idSprint);
		s.comenzar(fi, ff);
	}
	
	
	/**
	 * Genera un avance en dias al Sprint indicado.
	 * @param idSprint Sprint en el cual se generara el avance.
	 */
	public void avance(String idSprint){
		Sprint s=getSprint(idSprint);
		LocalDate fecha;
		int avance;
		//LocalDate fecha=s.getfInicio().plusDays(1);
		if(s.getEstado().toString().equals("ENCURSO")){
			fecha = s.getfAvance().plusDays(1);
			avance = (int)s.getfInicio().until(fecha, ChronoUnit.DAYS);
			s.setAvance();
			s.setfAvance(fecha);
			/*System.out.println(s.getfAvance());
			if(fecha.equals(s.getFechaFin())){
				s.cambiarEstado("finalizado");
				System.out.println(s.estimacionSprint());
				System.out.println(s.estimacionHistoriaSprint());
			}*/
		}
		else
			System.out.println("El sprint ya esta finalizado");
	}
	
	public boolean finalizaSprint(String idSprint){
		Sprint s=getSprint(idSprint);
		if(s.getfAvance().equals(s.getFechaFin())){
			//s.setEstadoSprint(EstadoSprint.FINALIZADO);
			return true;
		}
		else
			return false;
	}
	/**
	 * Devuelve la cantidad de dias que va avanzando el sprint
	 * @param id ID del sprint
	 * @return cantidad de dias que va avanzando el sprint
	 */
	public int cantAvance(String id){
		Sprint s=getSprint(id);
		return s.getAvance();
	}
	/**
	 * Calcula la duracion de un sprint
	 * @param idSprint ID del sprint al cual se le va a calcular la duracion, fechaFin-fechaInicio
	 * @return cantidad de dias que dura el sprint
	 */
	public int calcularDuracion(String idSprint){
		Sprint s=getSprint(idSprint);
		return s.duracion();
	}
	
	/**
	 * Cambia el estado de una tarea en un Sprint
	 * @param idSprint ID del sprint al cual se le va a modificar el estado de una tarea
	 * @param idT ID de la tarea a la cual se le va a cambiar el estado
	 * @param est Estado que se le va a asignar a la tarea
	 */
	public void cambiarEstadoTarea(String idSprint,String idT,String est){
		Sprint s=getSprint(idSprint);
		s.cambiarEstadoTarea(idT, est);
	}
	/**
	 * Obtiene la fecha en la que se encuentra el Sprint
	 * @param idSprint ID del sprint 
	 * @return fechaAvance
	 */
	public LocalDate getFechaAvanceSprint(String idSprint){
		LocalDate fecha;
		Sprint s=getSprint(idSprint);
		fecha=s.getfAvance();
		return fecha;
	}
	/**
	 * Muestra el historial de un sprint
	 * @param idSprint
	 */
	public void historial(String idSprint){
		Sprint s=getSprint(idSprint);
		s.muestraHistorial();
	}
	
	/**
	 * Ranking de los sprints respecto a cantidad de puntos estimacion completados(estado Done) en tareas de tipo Historia, ordenado de mayor a menor
	 * @return lista de ranking ordenada de mayor a menor
	 */
	public ArrayList<Sprint> RankingEstimacion(){
		ArrayList<Sprint>listaEsti = new ArrayList<Sprint>() ; 
		for(Sprint s:LSprints){
			if (s.getEstado()== EstadoSprint.FINALIZADO)
				listaEsti.add(s);
		}
		Collections.sort(listaEsti,new Comparator<Sprint>(){
			public int compare(Sprint s1, Sprint s2) {
				int est1=s1.estimacionHistoriaSprint();
				int est2=s2.estimacionHistoriaSprint();
				if(est1==est2)
					return 0;
				else
					if(est1<est2)
						return 1;
					else
						return -1;
			}
		});
		return listaEsti;	
	}
	
	/**
	 * Listado de Sprint de tareas completadas y no completadas, con estimacion total para cada lista
	 */
	public void reporteListado(){
		for(Sprint s:LSprints){
			System.out.println(s.getClave());
			System.out.println("Completadas:");
			
			int est=0;
			for(Tarea t:s.tareasCompletadas()){
				est+=t.estimacion();
			}
			System.out.println(s.tareasCompletadas().toString()+" "+est);
			System.out.println("No completadas:");
			est=0;
			for(Tarea t:s.tareasNoCompletadas())
				est+=t.estimacion();
			System.out.println(s.tareasNoCompletadas().toString()+" "+est);
		}
	}
	
	/**
	 * Busca si hay algun Sprint en curso
	 * @return sprint en curso
	 */
	public Sprint getSprintEnCurso(){
		Iterator<Sprint>it=LSprints.iterator();
		boolean bandera=false;
		Sprint s=null;
		while(it.hasNext()&& !bandera){
			s=it.next();
			if(s.getEstado().toString().equals("ENCURSO"))
				bandera=true;
		}
		if(bandera)
			return s;
		else
			return null;
	}
	/*public boolean existeSprintEncurso(){
		Iterator<Sprint>it=LSprints.iterator();
		boolean bandera=false;
		Sprint s;
		while(it.hasNext()&& !bandera){
			s=it.next();
			if(s.getEstado().equals("ENCURSO"))
				bandera=true;
		}
		if(bandera)
			return true;
		else
			return false;
	}*/
	
	/**
	 * Devuelve la lista de tareas que se encuentren en un estado. Se utiliza para cargar las tablas en la administracion del Sprint en curso
	 * @param idSprint id del sprint
	 * @param estado Estado en el que se encuentren las tareas
	 * @return lista de tareas 
	 */
	public TreeSet<Tarea>getListaEstados(String idSprint,String estado){
		Sprint s=getSprint(idSprint);
		return s.getListaEstado(estado);
	}
	
	public TreeSet<Sprint> getSprintsFinalizados(){
		TreeSet<Sprint> lista = new TreeSet<Sprint>();
		for (Sprint sp : LSprints)
			if(sp.getEstado() == EstadoSprint.FINALIZADO)
				lista.add(sp);
		return lista;
	}
	
	/**
	 * Serializa
	 * @param obj Object a serializar
	 * @param output Path y nombre del archivo a serializar
	 * @throws IOException si ocurre un error al abrir el archivo
	 */
	public void Escribir(Object obj, String output) throws IOException{
		File fich;
		fich = new File(output);
		FileOutputStream fos = new FileOutputStream(fich);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(obj);
		oos.close();
	}
	
	/**
	 * Desserializa
	 * @param output Path y nombre del archivo a desserializar
	 * @return Object con lo obtenido del archivo
	 * @throws IOException si ocurre un error al abrir el archivo
	 * @throws ClassNotFoundException si no encuentra el archivo buscado
	 */
	public Object Leer(String output) throws IOException, ClassNotFoundException{
		File fich;
		fich = new File(output);
		FileInputStream fis = new FileInputStream(fich);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Object obj = ois.readObject();
		ois.close();
		
		return obj;
	}

	public void cargaListas() {
		try {
			LSprints = (TreeSet<Sprint>) Leer("LSprints.ser");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		blog.setListaTareas();
	}

	/**
	 * 
	 * @param id ID de la Tarea.
	 * @return
	 */
	public Tarea getTareaBacklogYSprints(String id) {
		Tarea tar = blog.getTarea(id);
		Iterator<Sprint> its = LSprints.iterator();
		Sprint sp;
		boolean bandera = false;
		if(tar == null){
			while(its.hasNext() && !bandera){
				sp = its.next();
				if(sp.getEstado() != EstadoSprint.FINALIZADO)
					tar = sp.getTarea(id);
				if(tar!=null)
					bandera = true;
			}
		}
		if(bandera)
			return tar;
		else
			return null;
	}
	
	public Sprint getTareaEnSprint(String id){
		Iterator<Sprint> it = LSprints.iterator();
		boolean bandera = false;
		Tarea tar = null;
		Sprint sp=null;
		while(it.hasNext() && !bandera){
			sp = it.next();
			if(sp.getEstado()!=EstadoSprint.FINALIZADO){
				tar = sp.getTarea(id);
				if(tar != null)
					bandera = true;
			}
		}
		if(bandera)
			return sp;
		else
			return null;
	}
	
	
}