/**
 * 
 */
package tareas;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JOptionPane;

import estadosTareas.Estado;

/**
 * @author tomi_
 *
 */
public class Historia extends Tarea implements Serializable{
	private HashMap<String, Integer> flujoPasos = new HashMap<String, Integer>();
	
	public Historia(String id, String nombre, String descripcion,int complejidad) {
		super(id, nombre, descripcion,complejidad);
	}
	
	public int estimacionPromedioDependencias(){
		TreeSet<Tarea>dependencias=new TreeSet<Tarea>();
		dependencias=getLdependencias();
		int est=0;
		int cont=0;
		Tarea t=null;
		if(!dependencias.isEmpty()){
			Iterator<Tarea>it=getLdependencias().iterator();
			while(it.hasNext()){
				t=it.next();
				est+=t.estimacion();
				cont++;
			}
		}
		if(cont!=0 && est!=0)
			return (int)est/cont;
		else
			return 0;
	}
	public double estimacionPromedioPasos(){
		int e=0;
		int cont=0;
		Iterator<Map.Entry<String, Integer>> map = flujoPasos.entrySet().iterator();
		while(map.hasNext()){
			Map.Entry<String, Integer> entry = map.next();
			e+=entry.getValue();
			cont++;
		}
		if(e!=0 && cont!=0)
			return 0.1*(e/cont);
		else
			return 0;
	}
	public int estimacion(){
		return (int)Math.ceil(getComplejidad()+estimacionPromedioDependencias()+estimacionPromedioPasos());
	}
	public void agregarDep(Tarea tar){
		String subString=tar.getId().substring(0, 3);
		if(subString.equals("TAR") || subString.equals("HIS"))
			getLdependencias().add(tar);
		else
			JOptionPane.showMessageDialog(null, "Las dependencias de historia pueden ser tareas o historias");
	}
	
	public void agregaFlujoPaso(String descripcion,int pasos){
		flujoPasos.put(descripcion, pasos);
	}
	
	@Deprecated
	public void muestra(){
		super.muestra();
		if(!flujoPasos.isEmpty()){
			System.out.println("Flujo pasos:");
			Iterator<Map.Entry<String, Integer>> map = flujoPasos.entrySet().iterator();
			while (map.hasNext()) {
				Map.Entry<String, Integer> entry = map.next();
				System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
			}
		}
	}
	
	/**
	 * Convertir hashmap a arraylist
	 */
	public ArrayList<Entry<String,Integer>>getHashMap(){
		//Getting the Set of entries
		Set<Entry<String, Integer>> entrySet = flujoPasos.entrySet();
		         
		//Creating an ArrayList Of Entry objects
		ArrayList<Entry<String, Integer>> listOfEntry = new ArrayList<Entry<String,Integer>>(entrySet);
		return listOfEntry;
	}
	

}
