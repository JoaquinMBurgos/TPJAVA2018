package GUI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeSet;

import javax.swing.table.AbstractTableModel;

import tareas.Tarea;

public class FlujoPasoTM extends AbstractTableModel {

	//private HashMap<String, Integer> map;
	private Map<String, Integer> map = new HashMap<String, Integer>();

	public FlujoPasoTM(HashMap<String, Integer> map) {
		map = new HashMap<String, Integer>(map);
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public int getRowCount() {
		return map.size();
	}
	
	public void setaTareas(HashMap<String, Integer> map) {
		this.map = new HashMap<String, Integer>(map);
	}

	@Override
	public Object getValueAt(int row, int column) throws ArrayIndexOutOfBoundsException {
		int cont = 0;	
		int desc = 0;
		String key = null;
		Map.Entry<String, Integer>entry=null;
		if(!map.isEmpty()){
			Iterator<Map.Entry<String, Integer>> imap = map.entrySet().iterator();
			while (imap.hasNext() && cont<row) {
				entry = imap.next();
				
				cont++;
			}
			desc = entry.getValue();
			key = entry.getKey();
		}
		Object ob = null;
		switch (column) {
		case 0:
			ob = key;
			System.out.println("xkjbbecw");
			break;
		case 1:
			ob = desc;
			break;
		}
		return ob;
	}

}
