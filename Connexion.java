package formulaireProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Connexion extends JFrame implements Serializable{

//police du pied de page
private Font police = new Font("Arial", Font.ITALIC,15);
private JLabel pied_page = new JLabel();
private JPanel pied_page_pane = new JPanel();
private JPanel connexionPane = new JPanel();
//dimesion des champs et label
private Dimension dimLabel = new Dimension(80,25);
private Dimension dimField = new Dimension(80,30);

	public Connexion() {
		this.setSize(350,250);
		this.setTitle("connexion");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		initComponent();
		footer();
		this.getContentPane().add(connexionPane, BorderLayout.CENTER);
		this.getContentPane().add(pied_page_pane, BorderLayout.SOUTH);
		this.setVisible(true);
	}
	
	
	
	private void initComponent() {
		connexionPane.setBackground(new Color( 244, 246, 246 ));
		//panel du pseudo
		JPanel pseudoPane = new JPanel();
			JLabel pseudoLabel = new JLabel("pseudo");
			JTextField pseudoField = new JTextField(16);
				   pseudoLabel.setPreferredSize(dimLabel);
				   pseudoField.setPreferredSize(dimField);
				   pseudoPane.add(pseudoLabel);
				   pseudoPane.add(pseudoField);
		
		//panel du mot de pass
		JPanel passwordPane = new JPanel();
			JLabel passwordLabel = new JLabel("password");
			JPasswordField passwordField = new JPasswordField(16);
					passwordLabel.setPreferredSize(dimLabel);
					passwordField.setPreferredSize(dimField);
					passwordPane.add(passwordLabel);
					passwordPane.add(passwordField);
				
		//le bouton envoie
		JButton connexionButton = new JButton("CONNECTER");
				connexionButton.setBorderPainted(false);
				connexionButton.setPreferredSize(new Dimension(250,40));
				connexionButton.setBackground(Color.GREEN);
				
				connexionButton.addActionListener(new ConnexionListener());
		//le lien vers la page inscription
		JLabel lienInscriptionLabel = new JLabel("S'inscire ");
		JLabel lienInscription  = new JLabel("cliquez ici");
			   lienInscription.setForeground(Color.BLUE);
			   lienInscriptionLabel.setPreferredSize(new Dimension(84,17));
			   lienInscriptionLabel.setVerticalAlignment(JLabel.CENTER);
			   lienInscriptionLabel.setHorizontalAlignment(JLabel.RIGHT);
		
	    //lien vers la page d'enregistrement
		lienInscription.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent arg0) {
					Inscription inscrire = new Inscription(null, "", true);
				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				   
			   });
		
		connexionPane.add(pseudoPane);
		connexionPane.add(passwordPane);
		connexionPane.add(connexionButton);
		connexionPane.add(lienInscriptionLabel);
		connexionPane.add(lienInscription);
	}
	
	private void footer() {
		pied_page_pane.setBackground(new Color(86, 101, 115));
		pied_page.setText("Patience Services Informatiques !");
		pied_page.setFont(police);
		pied_page.setForeground(Color.WHITE);
		pied_page.setVerticalAlignment(JLabel.CENTER);
		pied_page.setHorizontalAlignment(JLabel.CENTER);
		pied_page_pane.add(pied_page);
	}
	
	private class ConnexionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			new Fenetre();
		}
	}
}//end of class Connexion
