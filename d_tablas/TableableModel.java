package d_tablas;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.table.DefaultTableModel;

public class TableableModel extends DefaultTableModel {

	// Este override evita que las celdas de la tabla sean modificables
	@Override
	public boolean isCellEditable(int row, int column) {
		// TODO Auto-generated method stub
		return false;
	}

	// Rellena la tabla con el ArrayList recibido, si le pasamos true tambien
	// borrara los datos previos
	public void rellenarTabla(ArrayList<? extends Tableable> lista, boolean vaciar) {

		if (vaciar) {
			vaciarTabla();
		}

		Iterator<? extends Tableable> it = lista.iterator();
		while (it.hasNext()) {
			Tableable t = it.next();
			// Obetenemos la cabecera del modelo que implemento tableable y se lo
			// establecemos como titulos de las columnas
			setColumnIdentifiers(t.getHeader());
			// Obtenemos los datos del modelo y añadimos una nueva fila a la tabla
			addRow(t.getData());

		}
	}

	public void vaciarTabla() {
		setRowCount(0);
		setColumnCount(0);
	}

}
