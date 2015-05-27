package Vue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import Controleur.ControleurAjouterRouteur;

import java.awt.Font;


public class AjouterRouteur extends JFrame{

	private JTextField textField;
	private ApplicationWindows fenetre;
	
	private DefaultListModel listeRouteur = new DefaultListModel();
	
	private static final int BValider = 1;
	private static final int BAnnuler = 2;
	
	private JComboBox comboBox;

	/**
	 * Create the application.
	 */
	public AjouterRouteur(ApplicationWindows fenetre) {
		this.fenetre = fenetre;
		listeRouteur = fenetre.getListeLocaux();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	
		this.setBounds(100, 100, 459, 179);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setLocationRelativeTo(fenetre);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNom.setHorizontalAlignment(SwingConstants.CENTER);
		lblNom.setBounds(22, 35, 70, 14);
		this.getContentPane().add(lblNom);
		this.setResizable(false);
		
		JLabel lblLocal = new JLabel("Local");
		lblLocal.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblLocal.setHorizontalAlignment(SwingConstants.CENTER);
		lblLocal.setBounds(22, 60, 70, 14);
		this.getContentPane().add(lblLocal);
		
		textField = new JTextField();
		textField.setBounds(102, 33, 229, 17);
		this.getContentPane().add(textField);
		textField.setColumns(10);
		
		comboBox = new JComboBox(listeRouteur.toArray());
		comboBox.setBounds(102, 57, 229, 20);
		this.getContentPane().add(comboBox);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnValider.setBounds(343, 102, 89, 23);
		this.getContentPane().add(btnValider);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnAnnuler.setBounds(251, 102, 89, 23);
		this.getContentPane().add(btnAnnuler);
		
		btnValider.addMouseListener(new ControleurAjouterRouteur(this, BValider));
		btnAnnuler.addMouseListener(new ControleurAjouterRouteur(this, BAnnuler));
	}

	public JTextField getTextField() {
		return textField;
	}

	public ApplicationWindows getFenetre() {
		return fenetre;
	}

	public JComboBox getComboBox() {
		return comboBox;
	}
}
