package formulaireProject;

import java.awt.BorderLayout;
import java.awt.Font;
import java.io.Serializable;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Donnees extends JPanel implements Serializable{
private Font police = new Font("Arial", Font.CENTER_BASELINE, 14);
private JTextArea afficher = new JTextArea();
	public Donnees() {}
	public Donnees(String text) {
		afficher.setText(text);
		afficher.setEditable(false);
		afficher.setFont(police);
		this.setLayout(new BorderLayout());
		this.add(new JScrollPane(afficher));
	}
}
