package Vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;


public class AjouterSwitch extends JFrame{

	private JTextField textField_Nom;


	/**
	 * Create the application.
	 */
	public AjouterSwitch() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setTitle("Ajouter Switch");
		this.setBounds(100, 100, 423, 279);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setResizable(false);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setHorizontalAlignment(SwingConstants.CENTER);
		lblNom.setBounds(33, 29, 78, 31);
		this.getContentPane().add(lblNom);
		
		
		JLabel lblRouteur = new JLabel("Routeur");
		lblRouteur.setHorizontalAlignment(SwingConstants.CENTER);
		lblRouteur.setBounds(33, 71, 78, 31);
		this.getContentPane().add(lblRouteur);
		
		JLabel lblSalle = new JLabel("Salle");
		lblSalle.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalle.setBounds(33, 113, 78, 31);
		this.getContentPane().add(lblSalle);
		
		JLabel lblLocal = new JLabel("Local");
		lblLocal.setHorizontalAlignment(SwingConstants.CENTER);
		lblLocal.setBounds(33, 155, 78, 31);
		this.getContentPane().add(lblLocal);
		
		textField_Nom = new JTextField();
		textField_Nom.setBounds(151, 34, 221, 20);
		this.getContentPane().add(textField_Nom);
		textField_Nom.setColumns(10);
		
		JComboBox comboBox_Routeur = new JComboBox();
		comboBox_Routeur.setBounds(151, 76, 221, 20);
		this.getContentPane().add(comboBox_Routeur);
		
		JComboBox comboBox_Salle = new JComboBox();
		comboBox_Salle.setBounds(151, 118, 221, 20);
		this.getContentPane().add(comboBox_Salle);
		
		JComboBox comboBox_Local = new JComboBox();
		comboBox_Local.setBounds(151, 160, 221, 20);
		this.getContentPane().add(comboBox_Local);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(302, 207, 89, 23);
		this.getContentPane().add(btnValider);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(184, 207, 89, 23);
		this.getContentPane().add(btnAnnuler);
	}

}
