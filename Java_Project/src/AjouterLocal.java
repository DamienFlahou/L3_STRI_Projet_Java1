import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;


public class AjouterLocal {

	private JFrame frmAjouterLocal;
	private JTextField textField_nom;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjouterLocal window = new AjouterLocal();
					window.frmAjouterLocal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AjouterLocal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAjouterLocal = new JFrame();
		frmAjouterLocal.setTitle("Ajouter local");
		frmAjouterLocal.setBounds(100, 100, 383, 267);
		frmAjouterLocal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAjouterLocal.getContentPane().setLayout(null);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setHorizontalAlignment(SwingConstants.CENTER);
		lblNom.setBounds(35, 34, 73, 25);
		frmAjouterLocal.getContentPane().add(lblNom);
		
		textField_nom = new JTextField();
		textField_nom.setBounds(118, 36, 221, 19);
		frmAjouterLocal.getContentPane().add(textField_nom);
		textField_nom.setColumns(10);
		
		JButton btnAvanc = new JButton("Avanc\u00E9");
		btnAvanc.setBounds(35, 70, 89, 23);
		frmAjouterLocal.getContentPane().add(btnAvanc);
		
		JLabel lblRouteur = new JLabel("Routeur");
		lblRouteur.setHorizontalAlignment(SwingConstants.CENTER);
		lblRouteur.setBounds(35, 104, 73, 25);
		frmAjouterLocal.getContentPane().add(lblRouteur);
		
		JComboBox comboBox_routeur = new JComboBox();
		comboBox_routeur.setBounds(118, 104, 221, 19);
		frmAjouterLocal.getContentPane().add(comboBox_routeur);
		
		JLabel lblNewLabel = new JLabel("Switch");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(35, 140, 73, 25);
		frmAjouterLocal.getContentPane().add(lblNewLabel);
		
		JComboBox comboBox_switch = new JComboBox();
		comboBox_switch.setBounds(118, 144, 221, 19);
		frmAjouterLocal.getContentPane().add(comboBox_switch);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(265, 196, 89, 23);
		frmAjouterLocal.getContentPane().add(btnValider);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(141, 196, 89, 23);
		frmAjouterLocal.getContentPane().add(btnAnnuler);
	}
}
