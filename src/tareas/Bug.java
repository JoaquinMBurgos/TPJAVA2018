/**
 * 
 */
package tareas;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.swing.JOptionPane;

import com.sun.org.apache.bcel.internal.generic.LSUB;

import clases.TareaNoValida;
import estadosTareas.Estado;

/**
 * 
 * @author jose
 * 
 *
 */
public class Bug extends Tarea implements Serializable{
	
	public Bug(String id, String nombre, String descripcion,int complejidad) {
		super(id, nombre, descripcion,complejidad);
		
	}

	public void agregarDep(Tarea tar) throws TareaNoValida{
		if(getLdependencias().isEmpty() && !tar.getId().substring(0, 3).equals("BUG"))
			getLdependencias().add(tar);
		else{
			throw new TareaNoValida();
		}
	}
	public int estimacion(){
		double estimacion = 0;
		if(getLdependencias().first() != null)
			estimacion = getLdependencias().first().getComplejidad()*0.1;
		return (int)Math.ceil(getComplejidad() + estimacion);
	}
	
}
