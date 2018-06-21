/**
 * 
 */
package tareas;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.swing.JOptionPane;

import estadosTareas.Estado;

/**
 * @author tomi_
 *
 */
public class Mejora extends Tarea implements Serializable{
	
	public Mejora(String id, String nombre, String descripcion,EstadoTarea est, LocalDate finalizacion, int complejidad) {
		super(id, nombre, descripcion,est, finalizacion, complejidad);
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @return la estimacion para una tarea
	 */
	public double calculaEstimacion(){
		int estimacion= getEstimacion();
		int complejidad= getComplejidad();
		return estimacion * 0.5 + complejidad;
		
	}
	public void agregarDep(Tarea tar){
		if(getLdependencias().isEmpty())
			getLdependencias().add(tar);
		else
			JOptionPane.showMessageDialog(null, "Mejora puede tener una sola dependencia");
	}
	
	public int estimacion(){
		Tarea t=null;
		if(!getLdependencias().isEmpty()){
			t=getLdependencias().first();
			return getComplejidad()+(t.estimacion()/2);
		}
		else
			return 0;		
	}
	

}
