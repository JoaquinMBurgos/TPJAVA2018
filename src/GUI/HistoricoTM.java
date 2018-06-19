/**
 * 
 */
package GUI;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import historial.Historial;

/**
 * @author 
 *
 */
public class HistoricoTM extends AbstractTableModel {

	private List<Historial> aHistoria;

	public HistoricoTM(ArrayList<Historial> lista) {
		aHistoria = new ArrayList<Historial>(lista);
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public int getRowCount() {
		return aHistoria.size();
	}
	
	public void setaTareas(ArrayList<Historial> lista) {
		this.aHistoria = new ArrayList<>(lista);
	}

	@Override
	public Object getValueAt(int row, int column) throws ArrayIndexOutOfBoundsException {
		Historial his = aHistoria.get(row);
		Object ob = null;
		switch (column) {
		case 0:
			ob = his.getFecha();
			break;
		case 1:
			ob = his.getEstado();
		}
		return ob;
	}

}
