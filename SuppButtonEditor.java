package formulaireProject;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class SuppButtonEditor extends DefaultCellEditor {
	private JButton button;
	private SuppButtonListener blistener = new SuppButtonListener();
	public SuppButtonEditor(JCheckBox checkBox) {
		super(checkBox);
		button = new JButton();
		button.setOpaque(true);
		button.addActionListener(blistener);
	}

	
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isEditable, int row, int col){
		blistener.setRow(row);
		blistener.setTable(table);
		
		button.setText((value == null) ? "" : value.toString());
		
		return button;
	}
	
	
	
	private class SuppButtonListener implements ActionListener{
		private int row;
		private JTable table;
		
		public void setRow(int row) {
			this.row = row;
		}
		
		public void setTable(JTable table) {
			this.table = table;
		}
		
		public void actionPerformed(ActionEvent event) {
			if(table.getRowCount() > 0)
				((Tableau)table.getModel()).deleteRow(this.row);
		}
		
		
	}
}
