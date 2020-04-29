package formulaireProject;

import java.io.Serializable;

import javax.swing.table.AbstractTableModel;

public class Tableau extends AbstractTableModel implements Serializable{
	Object[][]datas;
	String[] title;
	
	public Tableau(Object[][] datas, String[] title){
	
			this.datas = datas;
			this.title = title;
		
	}
		public int getColumnCount() {
			return this.title.length;
		}
		
		public int getRowCount() {
			return this.datas.length;					
		}
		
		public Object getValueAt(int row, int col) {
			return this.datas[row][col];
		}

		public String getColumnName(int x) {
			return this.title[x];
		}
		
		public boolean isCellEditable(int row, int col) {
			return true;
		}
		
		
} //end of class

