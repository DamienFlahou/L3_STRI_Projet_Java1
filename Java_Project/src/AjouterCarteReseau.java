import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class AjouterCarteReseau extends JFrame{

	private JTextField textField_mac1;
	private JTextField textField_mac2;
	private JTextField textField_mac3;
	private JTextField textField_mac4;
	private JTextField textField_mac5;

	private JLabel lblDeuxPoints1;
	private JLabel lblDeuxPoints2;
	private JLabel lblDeuxPoints3;
	private JLabel lblDeuxPoints4;

	/**
	 * Create the application.
	 */
	public AjouterCarteReseau() {
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
		textField_mac3.setColumns(10);
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
		

		
		JComboBox comboBox_Ordinateur = new JComboBox();
		comboBox_Ordinateur.setBounds(151, 76, 221, 20);
		this.getContentPane().add(comboBox_Ordinateur);
		
		JComboBox comboBox_Routeur = new JComboBox();
		comboBox_Routeur.setBounds(151, 118, 221, 20);
		this.getContentPane().add(comboBox_Routeur);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(302, 207, 89, 23);
		this.getContentPane().add(btnValider);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(184, 207, 89, 23);
		this.getContentPane().add(btnAnnuler);
	}
	
}