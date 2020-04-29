package formulaireProject;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class Inscription extends JDialog implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel buttonPane = new JPanel();
	private JPanel container = new JPanel();
	private JPanel pan1 = new JPanel();
	private JPanel pan2 = new JPanel();
	private JLabel titre;
	private Dimension dimLabel = new Dimension(100,25);
	private Dimension dimField = new Dimension(170,30);
	private JLabel timeLabel = new JLabel();
	private JTextField firstNameField = new JTextField();
	private JTextField lastNameField = new JTextField();
	private JFormattedTextField ageField = new JFormattedTextField(NumberFormat.getIntegerInstance());
	private JRadioButton masculin = new JRadioButton("Masculin");
	private JRadioButton feminin = new JRadioButton("Feminin");
	private JTextArea adressField = new JTextArea();
	private	JCheckBox sport = new JCheckBox("sport");
	private	JCheckBox musique = new JCheckBox("musique");
	private	JCheckBox lecture = new JCheckBox("lecture");
	private	JCheckBox danse = new JCheckBox("danse");
	private	JFormattedTextField phoneField = new JFormattedTextField();
	private	JTextField emailField = new JTextField();
	private String pays[] = {"Niger", "Soudan", "Burkina", "Mali", "Cote D'ivoire"};
	private	JComboBox<String> paysBox = new JComboBox<String>(pays);
	private UserInfos infos = new UserInfos();
	private Donnees donnees = new Donnees();
	protected static File fichier = new File("/home/nabirni/eclipse-workspace/formulaireProject/src/formulaireProject/files/datas.txt");
 	// le constructeur 
	public Inscription(JFrame parent, String title, Boolean modal) {
			super(parent, title, modal);
			this.setSize(700,450);
			this.setLocationRelativeTo(null);
			this.setResizable(false);
			title();
			initComponent();
			controlButtons();	

			Thread t = new Thread(new Runnable() {
				public void run() {
					temps();
				}
			});
			t.start();
			
			this.getContentPane().add(titre, BorderLayout.NORTH);
			this.getContentPane().add(container, BorderLayout.CENTER);
			this.getContentPane().add(buttonPane, BorderLayout.SOUTH);
			this.setVisible(true);
		}

	private void title() {
		titre = new JLabel("INSCRIPTION");
			   titre.setHorizontalAlignment(JLabel.CENTER);
	}
	
	private void initComponent() {
	//le nom
		JPanel firstNamePane = new JPanel();
		JLabel firstNameLabel = new JLabel("first Name: ");
		firstNamePane.add(firstNameLabel);
		firstNamePane.add(firstNameField);
		firstNameLabel.setPreferredSize(dimLabel);
		firstNameField.setPreferredSize(dimField);
		
	//le prenom 
		JPanel lastNamePane = new JPanel();
		JLabel lastNameLabel = new JLabel("last Name: ");
		lastNamePane.add(lastNameLabel);
		lastNamePane.add(lastNameField);
		lastNameLabel.setPreferredSize(dimLabel);
		lastNameField.setPreferredSize(dimField);
		
	//l'age
		JPanel agePane = new JPanel();
		JLabel ageLabel = new JLabel("Age: ");
		agePane.add(ageLabel);
		agePane.add(ageField);
		ageLabel.setPreferredSize(dimLabel);
		ageField.setPreferredSize(dimField);
		ageField.setValue(18);
		
	//le sexe
		String[] sexe = {"Feminin","Masculin","Imbecile"};
		JPanel sexePane = new JPanel();
		JPanel sexeChoice = new JPanel();
		JLabel sexeLabel = new JLabel("Sexe: ");
		
		ButtonGroup sexeGroup = new ButtonGroup();
		
				sexeLabel.setPreferredSize(new Dimension(80,25));
							
				sexeGroup.add(masculin);
				sexeGroup.add(feminin);
				sexeChoice.add(masculin);
				sexeChoice.add(feminin);
		
		sexePane.add(sexeLabel);
		sexePane.add(sexeChoice);
		
		
	//l'adresse
		JPanel addressPane = new JPanel();
		JLabel addressLabel = new JLabel("adress: ");
		addressPane.add(addressLabel);
		addressPane.setPreferredSize(new Dimension(285,70));
		addressPane.add(new JScrollPane(adressField));
		addressLabel.setPreferredSize(dimLabel);
		addressLabel.setVerticalAlignment(JLabel.NORTH);
		adressField.setPreferredSize(new Dimension(170, 65));
		
		
	//Loisirs	pan1.setBorder(BorderFactory.createLineBorder(Color.black));
		JPanel loisirPane = new JPanel();
		JPanel choicePane = new JPanel();
		JLabel loisirLabel = new JLabel("Hobbies :");
		
	
			
		choicePane.setPreferredSize(new Dimension(170,70));
		choicePane.add(sport);
		choicePane.add(musique);
		choicePane.add(danse);
		choicePane.add(lecture);
		
		loisirPane.add(loisirLabel);
		loisirPane.add(choicePane);
		
		loisirLabel.setPreferredSize(dimLabel);
		
	//phone 
		JPanel phonePane = new JPanel();
		JLabel phoneLabel = new JLabel("Phone: ");
		MaskFormatter phoneFormat;
		try {
			
			 phoneFormat = new MaskFormatter("+249-##-##-##-##-##");
			 phoneField = new JFormattedTextField(phoneFormat);
			 phonePane.add(phoneLabel);
			 phonePane.add(phoneField);
			 phoneLabel.setPreferredSize(dimLabel);
			 phoneField.setPreferredSize(dimField);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
	//L'email 
		JPanel emailPane = new JPanel();
		JLabel emailLabel = new JLabel("Email: ");
		emailPane.add(emailLabel);
		emailPane.add(emailField);
		emailLabel.setPreferredSize(dimLabel);
		emailField.setPreferredSize(dimField);
		
	//le pays

		JPanel nationPane = new JPanel();
		JLabel paysLabel = new JLabel("Nation");
		paysBox.setSelectedIndex(1);
		nationPane.add(paysLabel);
		nationPane.add(paysBox);
		paysLabel.setPreferredSize(dimLabel);
		paysBox.setPreferredSize(dimField);
		
		pan1.setPreferredSize(new Dimension(295,300));
		pan2.setPreferredSize(new Dimension(295,300));
		pan1.setBorder(BorderFactory.createLineBorder(Color.black));
		pan2.setBorder(BorderFactory.createLineBorder(Color.black));
		
		pan1.add(firstNamePane);
		pan1.add(agePane);
		pan1.add(addressPane);
		pan1.add(loisirPane);
		
		pan2.add(lastNamePane);
		pan2.add(sexePane);
		pan2.add(phonePane);
		pan2.add(emailPane);
		pan2.add(nationPane);
		
		//appel de la methode affichant le temps
		
		container.add(pan1);
		container.add(pan2);
		container.add(timeLabel);
	}//end of initComponent();
	
	//methode du panel des boutons de control
	private void controlButtons() {
		JButton submit = new JButton("submit");
	//action du bouton submit
		submit.addActionListener(new SubmitListener());
		
		JButton cancel = new JButton("cancel");
	//		action du bouton cancel
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		buttonPane.add(submit);
		buttonPane.add(cancel); 
	}
	
	//affichage du temps actuel juste en dessous du formulaire
	private void temps() {
		DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("dd-MM-YYYY HH:mm:ss");
		while(true) {
			LocalDateTime currentTime = LocalDateTime.now();
			timeLabel.setText("temps: "+timeFormat.format(currentTime));
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
//	methode pour sauvegarder les donnees dans un fichier
	private void saveOnFile() {
		
	}
//ecouteur du bouton submit
	JOptionPane messageOption;
	private class SubmitListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			List<String> hobbies = new ArrayList<String>();
			String fname = firstNameField.getText();
			String lname = lastNameField.getText();
			String age = ageField.getText();
		
			String sexe = masculin.isSelected() ? masculin.getText() :
					   feminin.isSelected() ? feminin.getText():
					   masculin.getText(); 
		
			String adress = adressField.getText();
			String phone = phoneField.getText();
			String email = emailField.getText();
			String nation = paysBox.getSelectedItem().toString();
			
			if(sport.isSelected()) hobbies.add(sport.getText());
			if(musique.isSelected()) hobbies.add(musique.getText());
			if(lecture.isSelected()) hobbies.add(lecture.getText());
			if(danse.isSelected()) hobbies.add(danse.getText());

			infos = new UserInfos(fname, lname, age, sexe, adress, phone, email, nation, hobbies);
			JOptionPane.showMessageDialog(null,infos.toString(), "information utilisateur",JOptionPane.INFORMATION_MESSAGE);

//ecrire les donnees dans un fichier
			try(FileOutputStream fos = new FileOutputStream(fichier);
					BufferedOutputStream bos = new BufferedOutputStream(fos);
					 ObjectOutputStream oos  = new ObjectOutputStream(bos)){
						oos.writeObject(infos);
						oos.close();
			}catch(FileNotFoundException fnfe) {
				System.err.println("fichier introuvable");
			}catch(IOException ioe) {
				System.err.println("probleme d'ecriture dans le fichier");
			}
		}
	}
}