package Vue;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import Controleur.JTextFieldLimit;
import Model.Ordinateur;
import Model.Routeur;

public class AjouterCarteReseau extends JFrame{

	ApplicationWindows applicationPrincipale;
	
	DefaultListModel listeOrdinateur;
	DefaultListModel listeRouteur;
	
	private static final int BValider = 1;
	private static final int BAnnuler = 2;
	
	private static final int Texte1 = 1;
	private static final int Texte2 = 2;
	private static final int Texte3 = 3;
	private static final int Texte4 = 4;
	private static final int Texte5 = 5;
	
	private JTextField textField_mac1;
	private JTextField textField_mac2;
	private JTextField textField_mac3;
	private JTextField textField_mac4;
	private JTextField textField_mac5;
	private JTextField textField_mac6;
	
	JComboBox comboBox_Ordinateur;
	JComboBox comboBox_Routeur;

	private JLabel lblDeuxPoints1;
	private JLabel lblDeuxPoints2;
	private JLabel lblDeuxPoints3;
	private JLabel lblDeuxPoints4;
	private JLabel lblDeuxPoints5;

	/**
	 * Create the application.
	 */
	public AjouterCarteReseau(ApplicationWindows fenetre) {
		this.applicationPrincipale = fenetre;
		
		
		listeOrdinateur = this.applicationPrincipale.getListeOrdinateurs();
		listeRouteur = this.applicationPrincipale.getListeRouteurs();
		
		listeOrdinateur.add(0, new Ordinateur("", true));
		listeRouteur.add(0, new Routeur("", true));
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setTitle("Ajouter carte réseau");
		this.setBounds(100, 100, 423, 279);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setResizable(false);
		this.setLocationRelativeTo(applicationPrincipale);
		
		JLabel lblAdr = new JLabel("Adresse");
		lblAdr.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdr.setBounds(33, 29, 78, 31);
		this.getContentPane().add(lblAdr);
		
		JLabel lblOrdinateur = new JLabel("Ordinateur");
		lblOrdinateur.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrdinateur.setBounds(33, 71, 78, 31);
		this.getContentPane().add(lblOrdinateur);
		
		JLabel lblRouteur = new JLabel("Routeur");
		lblRouteur.setHorizontalAlignment(SwingConstants.CENTER);
		lblRouteur.setBounds(33, 113, 78, 31);
		this.getContentPane().add(lblRouteur);
		
		
		textField_mac1 = new JTextField();
		textField_mac1.setBounds(151, 34, 171, 20);
		this.getContentPane().add(textField_mac1);
		textField_mac1.setSize(20, 20);
		
		lblDeuxPoints1 = new JLabel(":");
		lblDeuxPoints1.setBounds(175, 34, 179, 20);
		this.getContentPane().add(lblDeuxPoints1);
		
		textField_mac2 = new JTextField();
		textField_mac2.setBounds(180, 34, 200, 20);
		this.getContentPane().add(textField_mac2);
		textField_mac2.setSize(20, 20);
		
		lblDeuxPoints2 = new JLabel(":");
		lblDeuxPoints2.setBounds(204, 34, 208, 20);
		this.getContentPane().add(lblDeuxPoints2);
		
		textField_mac3 = new JTextField();
		textField_mac3.setBounds(209, 34, 229, 20);
		this.getContentPane().add(textField_mac3);
		textField_mac3.setColumns(2);
		textField_mac3.setSize(20, 20);
		
		lblDeuxPoints3 = new JLabel(":");
		lblDeuxPoints3.setBounds(233, 34, 237, 20);
		this.getContentPane().add(lblDeuxPoints3);
		
		textField_mac4 = new JTextField();
		textField_mac4.setBounds(238, 34, 258, 20);
		this.getContentPane().add(textField_mac4);
		textField_mac4.setColumns(10);
		textField_mac4.setSize(20, 20);
		
		lblDeuxPoints4 = new JLabel(":");
		lblDeuxPoints4.setBounds(262, 34, 266, 20);
		this.getContentPane().add(lblDeuxPoints4);
		
		textField_mac5 = new JTextField();
		textField_mac5.setBounds(267, 34, 277, 20);
		this.getContentPane().add(textField_mac5);
		textField_mac5.setColumns(10);
		textField_mac5.setSize(20, 20);
		
		lblDeuxPoints5 = new JLabel(":");
		lblDeuxPoints5.setBounds(291, 34, 179, 20);
		this.getContentPane().add(lblDeuxPoints5);
		
		textField_mac6 = new JTextField();
		textField_mac6.setBounds(299, 35, 25, 19);
		this.getContentPane().add(textField_mac6);
		textField_mac6.setColumns(10);
		textField_mac6.setSize(20, 20);
		
		textField_mac1.getDocument().addDocumentListener(new JTextFieldLimit(this, Texte1));
		textField_mac2.getDocument().addDocumentListener(new JTextFieldLimit(this, Texte2));
		textField_mac3.getDocument().addDocumentListener(new JTextFieldLimit(this, Texte3));
		textField_mac4.getDocument().addDocumentListener(new JTextFieldLimit(this, Texte4));
		textField_mac5.getDocument().addDocumentListener(new JTextFieldLimit(this, Texte5));
		
		comboBox_Ordinateur = new JComboBox(listeOrdinateur.toArray());
		comboBox_Ordinateur.setBounds(151, 76, 221, 20);
		this.getContentPane().add(comboBox_Ordinateur);
		
		comboBox_Routeur = new JComboBox(listeRouteur.toArray());
		comboBox_Routeur.setBounds(151, 118, 221, 20);
		this.getContentPane().add(comboBox_Routeur);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(302, 207, 89, 23);
		this.getContentPane().add(btnValider);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(184, 207, 89, 23);
		this.getContentPane().add(btnAnnuler);
	}

	public JTextField getTextField_mac1() {
		return textField_mac1;
	}

	public JTextField getTextField_mac2() {
		return textField_mac2;
	}

	public JTextField getTextField_mac3() {
		return textField_mac3;
	}

	public JTextField getTextField_mac4() {
		return textField_mac4;
	}

	public JTextField getTextField_mac5() {
		return textField_mac5;
	}

	public ApplicationWindows getApplicationPrincipale() {
		return applicationPrincipale;
	}

	public JComboBox getComboBox_Ordinateur() {
		return comboBox_Ordinateur;
	}

	public JComboBox getComboBox_Routeur() {
		return comboBox_Routeur;
	}

	public JTextField getTextField_mac6() {
		return textField_mac6;
	}
	
}