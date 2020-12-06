package visual;

import java.io.IOException;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class ImageColumnTest2 {
	private String[] COL_NAMES = {"  ","Código", "Nombre", "Manager","Juegos","Ganados","Perdidos"};

	public ImageColumnTest2() throws IOException {
	      DefaultTableModel model = new DefaultTableModel(COL_NAMES , 0) {
	         @Override
	         public Class<?> getColumnClass(int column) {
	            if (getRowCount() > 0) {
	               Object value = getValueAt(0, column);
	               if (value != null) {
	                  return getValueAt(0, column).getClass();
	               }
	            }

	            return super.getColumnClass(column);
	         }
	      };
}
}
