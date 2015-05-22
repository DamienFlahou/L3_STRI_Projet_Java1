import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;


public class AjouterSalle {

	private JFrame frmAjouterSalle;
	private JTextField textField_Nom;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjouterSalle window = new AjouterSalle();
					window.frmAjouterSalle.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AjouterSalle() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAjouterSalle = new JFrame();
		frmAjouterSalle.setTitle("Ajouter salle");
		frmAjouterSalle.setBounds(100, 100, 423, 279);
		frmAjouterSalle.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAjouterSalle.getContentPane().setLayout(null);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setHorizontalAlignment(SwingConstants.CENTER);
		lblNom.setBounds(33, 29, 78, 31);
		frmAjouterSalle.getContentPane().add(lblNom);
		
		JLabel lblLocal = new JLabel("Local");
		lblLocal.setHorizontalAlignment(SwingConstants.CENTER);
		lblLocal.setBounds(33, 71, 78, 31);
		frmAjouterSalle.getContentPane().add(lblLocal);
		
		JLabel lblRouteur = new JLabel("Routeur");
		lblRouteur.setHorizontalAlignment(SwingConstants.CENTER);
		lblRouteur.setBounds(33, 113, 78, 31);
		frmAjouterSalle.getContentPane().add(lblRouteur);
		
		JLabel lblSwitch = new JLabel("Switch");
		lblSwitch.setHorizontalAlignment(SwingConstants.CENTER);
		lblSwitch.setBounds(33, 155, 78, 31);
		frmAjouterSalle.getContentPane().add(lblSwitch);
		
		textField_Nom = new JTextField();
		textField_Nom.setBounds(151, 34, 221, 20);
		frmAjouterSalle.getContentPane().add(textField_Nom);
		textField_Nom.setColumns(10);
		
		JComboBox comboBox_Local = new JComboBox();
		comboBox_Local.setBounds(151, 76, 221, 20);
		frmAjouterSalle.getContentPane().add(comboBox_Local);
		
		JComboBox comboBox_Routeur = new JComboBox();
		comboBox_Routeur.setBounds(151, 118, 221, 20);
		frmAjouterSalle.getContentPane().add(comboBox_Routeur);
		
		JComboBox comboBox_Switch = new JComboBox();
		comboBox_Switch.setBounds(151, 160, 221, 20);
		frmAjouterSalle.getContentPane().add(comboBox_Switch);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(302, 207, 89, 23);
		frmAjouterSalle.getContentPane().add(btnValider);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(184, 207, 89, 23);
		frmAjouterSalle.getContentPane().add(btnAnnuler);
	}

}
