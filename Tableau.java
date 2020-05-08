package formulaireProject;

import java.io.Serializable;

import javax.swing.JButton;
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
		
		public void setValueAt(Object value, int row, int col) {
			if(!this.getColumnName(col).equals("suppression"))
				this.datas[row][col] = value;
		}
		
		public Class getColumnClass(int col) {
			return this.datas[0][col].getClass();
		}
		
		public boolean isCellEditable(int row, int col) {
			if(this.getValueAt(0, col) instanceof JButton)
			return false;
			return true;
		}
		
//ajouter une nouvelle ligne de donnee
		public void addRow(Object[] donnee) {
			int oldRowCount = this.getRowCount();
			int oldColCount = this.getColumnCount();
			int index = 0;
			
			Object[][] temp = this.datas;
			this.datas = new Object[oldRowCount+1][oldColCount];
			
			for(Object[] value : temp)
				this.datas[index++] = value;
			
			this.datas[index] = donnee;
			temp = null;
			
			this.fireTableDataChanged();
		}
		
//supprimer une ligne de donnee
		public void deleteRow(int position) {
			int indexVerifiant = 0 ; int indexAjoutant = 0;
			int oldRowCount = this.getRowCount()-1;
			int oldColCount = this.getColumnCount();
			
			Object[][] temp = new Object[oldRowCount][oldColCount];
			
			for(Object[] value : this.datas) {
				if(indexVerifiant != position)
					temp[indexAjoutant++] = value;
				
				indexVerifiant++;
			}
			this.datas = temp;
			temp = null;
			
			this.fireTableDataChanged();
			
		}
		
		
} //end of class

