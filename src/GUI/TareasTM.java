package GUI;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import javax.swing.table.AbstractTableModel;

import tareas.Tarea;



public class TareasTM extends AbstractTableModel{
	
	private List<tareas.Tarea> aTareas;

	public TareasTM(TreeSet<Tarea> lista) {
		aTareas = new ArrayList<>(lista);
	}

	@Override
	public int getColumnCount() {
		return 6;
	}

	@Override
	public int getRowCount() {
		return aTareas.size();
	}
	
	public void setaTareas(TreeSet<Tarea> aTareas) {
		this.aTareas = new ArrayList<>(aTareas);
	}

	@Override
	public Object getValueAt(int row, int column) throws ArrayIndexOutOfBoundsException {
		Tarea tar = aTareas.get(row);
		Object ob = null;
		switch (column) {
		case 0:
			ob = tar.getId();
			break;
		case 1:
			ob = tar.getNombre();
			break;
		case 2:
			ob = tar.getDescripcion();
			break;
		case 3:
			ob = tar.getEstado();
			break;
		case 4:
			ob = tar.getComplejidad();
			break;
		case 5:
			ob = tar.getfFin();
		}
		return ob;
	}

}
