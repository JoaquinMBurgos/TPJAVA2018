package GUI;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import org.w3c.dom.views.AbstractView;

import clases.Sprint;

public class SprintsTM extends AbstractTableModel{

	private List<Sprint> aSprints;
	
	public SprintsTM(TreeSet<Sprint> lista) {
		aSprints = new ArrayList<>(lista);
	}
	
	@Override
	public int getColumnCount() {
		return 10;
	}

	@Override
	public int getRowCount() {
		return aSprints.size();
	}

	public void setaSprints(TreeSet<Sprint> aSprints) {
		this.aSprints = new ArrayList<>(aSprints);
	}

	@Override
	public Object getValueAt(int row, int column) throws ArrayIndexOutOfBoundsException {
		Sprint sp = aSprints.get(row);
		Object ob = null;
		switch (column) {
		case 0:
			ob = sp.getClave();
			break;
		case 1:
			ob = sp.getDescripcion();
			break;
		case 2:
			ob = sp.getEstado();
			break;
		case 3:
			ob=sp.getfInicio();
			break;
		case 4:
			ob=sp.getFechaFin();
			break;
		case 5:
			ob=sp.getDuracion();
			break;
		case 6:
			ob=sp.getAvance();
			break;
		case 7:
			ob=sp.getListaT();
			break;
		case 8:
			ob=sp.estimacionHistoriaSprint();
			break;
		case 9:
			ob=sp.estimacionSprint();
			break;
		}
		
		return ob;
	}
	
}