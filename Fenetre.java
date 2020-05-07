package formulaireProject;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

//la fenetre principale
public class Fenetre extends JFrame implements Serializable{
	/**
	 * 
	 */
	protected  File fichier = new File("/home/nabirni/eclipse-workspace/formulaireProject/src/formulaireProject/files/data");
	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar = new JMenuBar();
	private JToolBar toolbar = new JToolBar();
	private JPopupMenu popupMenu = new JPopupMenu();
	private JPanel centerContainer = new JPanel();
	private JTable tableau;
	
	private String[] titres = {"id","nom","prenom","pays","adress","email","phone","suppression"};
	private Object[][] donnees = {
			{1,"Moussa", "Ismael","Soudan","Kharthoum","ismael@gmail.com",118322681,"delete"},
			{2,"Ali", "Ismael","Soudan","Kharthoum","ismael@gmail.com",118322681,"delete"},
			{3,"Moussa", "Ismael","Soudan","Kharthoum","ismael@gmail.com",118322681,"delete"},
			{4,"Moussa", "Ismael","Soudan","Kharthoum","ismael@gmail.com",118322681,"delete"},
			{5,"Moussa", "Ismael","Soudan","Kharthoum","ismael@gmail.com",118322681,"delete"},
			{6,"Moussa", "Ismael","Soudan","Kharthoum","ismael@gmail.com",118322681,"delete"},
			};

	private JSplitPane splitPane;
	private JTabbedPane onglets;
	private Donnees lesDonnees;
	private JButton btnAjouterLigne = new JButton("ajouter une ligne");
	
//START OF CONSTRUCTOR
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
			this.tableau.getColumn("suppression").setCellEditor(new SuppButtonEditor(new JCheckBox()));
	//		tableau.setBackground(new Color(231, 233, 242));
			
	
			onglet();
			
			splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new Arbre(), onglets);
			splitPane.setOneTouchExpandable(false);
			splitPane.setDividerSize(5);
			splitPane.setDividerLocation(175);
			
			btnAjouterLigne.addActionListener(new AjouterLigne());
		this.setJMenuBar(menuBar);
		this.getContentPane().add(toolbar, BorderLayout.NORTH);
		this.getContentPane().add(splitPane, BorderLayout.CENTER);
		this.getContentPane().add(btnAjouterLigne, BorderLayout.SOUTH);
}
//========================END OF CONSTRUCTOR
	
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
	
	private void onglet() {
		
		onglets = new JTabbedPane();
		
		onglets.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent event) {
				try(FileInputStream fis = new FileInputStream(Inscription.fichier);
						BufferedInputStream bis = new BufferedInputStream (fis);
						 ObjectInputStream ois = new ObjectInputStream(bis)){
							UserInfos infos = (UserInfos)ois.readObject();
							lesDonnees = new Donnees(infos.toString());
						ois.close();
				} catch (FileNotFoundException e) {
					System.err.println("fichier introuvable");
					e.printStackTrace();
				} catch (IOException e) {
					System.err.println("probleme de lecture du fichier");
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					System.err.println("aucune sauvegarde trouvee");
					e.printStackTrace();
				}
			}
		});
		
		onglets.add("Tableau", new JScrollPane(tableau));
		onglets.add("donnees", lesDonnees);
		
	}

//listener pour ajouter une nouvelle ligne de donnees
private class AjouterLigne implements ActionListener{
		public void actionPerformed(ActionEvent event ) {
		Object[] donnee =
			{7,"NouvelleLigne", "Ismael","Soudan","Kharthoum","ismael@gmail.com",118322681,"delete"};
		((Tableau)tableau.getModel()).addRow(donnee);
	}
}
}
