package formulaireProject;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class Arbre extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTree arbre;
	private DefaultMutableTreeNode racine = new DefaultMutableTreeNode();
	
	public Arbre() {
		this.setLayout(new BorderLayout());
		for(int i=0; i<=6; i++) {
			DefaultMutableTreeNode dossier = new DefaultMutableTreeNode("dossier "+(i+1));
			for(int j=0; j<=9; j++) {
				DefaultMutableTreeNode sous_element = new DefaultMutableTreeNode("sous dossier "+(j+1));
				if((j%2 == 0)){
					for (int k = 1; k<=4; k++) {
						DefaultMutableTreeNode fichier = new DefaultMutableTreeNode("fihier "+k);
						sous_element.add(fichier);
					}
						
				}
				dossier.add(sous_element);
			}
			racine.add(dossier);					
		}//end of for
		 arbre = new JTree(racine);
		 this.add(new JScrollPane(arbre)); 
	}

}
