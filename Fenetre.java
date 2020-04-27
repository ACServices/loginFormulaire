package formulaireProject;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JToolBar;

//la fenetre principale
public class Fenetre extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar = new JMenuBar();
	private JToolBar toolbar = new JToolBar();
	private JPopupMenu popupMenu = new JPopupMenu();
	private JPanel centerContainer = new JPanel();
	private JTable tableau;
	private String[] titres = {"id","nom","prenom","pays","adress","email","phone"};
	private Object[][] donnees = {
			{1,"Moussa", "Ismael","Soudan","Kharthoum","ismael@gmail.com",118322681},
			{2,"Ali", "Ismael","Soudan","Kharthoum","ismael@gmail.com",118322681},
			{3,"Moussa", "Ismael","Soudan","Kharthoum","ismael@gmail.com",118322681},
			{4,"Moussa", "Ismael","Soudan","Kharthoum","ismael@gmail.com",118322681},
			{5,"Moussa", "Ismael","Soudan","Kharthoum","ismael@gmail.com",118322681},
			{6,"Moussa", "Ismael","Soudan","Kharthoum","ismael@gmail.com",118322681},
			};

	private JSplitPane splitPane;
	
	public Fenetre() {
		this.setTitle("liste des abonnes");
		this.setSize(1000, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		menu();
		toolbar();
		popupMenu();
		
		tableau = new JTable(new Tableau(donnees, titres));
		tableau.setRowHeight(35);
		this.setJMenuBar(menuBar);
//		tableau.setBackground(new Color(231, 233, 242));
		
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new Arbre(), tableau);
		splitPane.setOneTouchExpandable(false);
		splitPane.setDividerSize(5);
		splitPane.setDividerLocation(175);
		this.getContentPane().add(toolbar, BorderLayout.NORTH);
		this.getContentPane().add(splitPane, BorderLayout.CENTER);
	}

	private void menu() {
		JMenu file = new JMenu("fichier");
		JMenu edition = new JMenu("Edition");
		JMenu options = new JMenu("Options");
		JMenu help = new JMenu("Aide");
			JMenuItem nouveau = new JMenuItem("noveau");
			JMenuItem ouvrir = new JMenuItem("ouvrir");
			JMenuItem fermer = new JMenuItem("fermer");
		file.add(nouveau);
		file.add(ouvrir);
		file.add(fermer);
		fermer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		menuBar.add(file);
		menuBar.add(edition);
		menuBar.add(options);
		menuBar.add(help);
		
	}
	
	private void toolbar() {
	//	JButton ajouterCellule = new JButton(new ImageIcon("/home/nabirni/eclipse-workspace/formulaireInscription/src/formulaireInscription/img/ajout.png"));
		JButton homeCellule = new JButton(new ImageIcon("/home/nabirni/eclipse-workspace/formulaireProject/img/home.png"));
		JButton playCellule = new JButton(new ImageIcon("/home/nabirni/eclipse-workspace/formulaireProject/img/play.png"));
		JButton squareCellule = new JButton(new ImageIcon("/home/nabirni/eclipse-workspace/formulaireProject/img/square.png"));
		
		toolbar.add(homeCellule);
	//	toolbar.add(ajouterCellule);
		toolbar.add(playCellule);
		toolbar.add(squareCellule);
	}//end of method toolbar()
	
	private void popupMenu() {
		JMenu popupOuvrir= new JMenu("fichier");
		JMenu popupEdition = new JMenu("Edition");
		JMenu popupFermer = new JMenu("Options");
		
//		this.addMouseListener(new MouseAdapter() {
//			public void mouseReleased(MouseEvent e) {
//				if(e.getButton() == MouseEvent.BUTTON3) {
//					popupMenu.add(popupOuvrir);
//					popupMenu.add(popupEdition);
//					popupMenu.add(popupFermer);
//					popupMenu.show(centerContainer, e.getX(), e.getY());
//				}
//			}
//		});
		
	}
}
