import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class AjouterOrdinateur {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjouterOrdinateur window = new AjouterOrdinateur();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AjouterOrdinateur() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 467, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNom.setHorizontalAlignment(SwingConstants.CENTER);
		lblNom.setBounds(22, 35, 70, 14);
		frame.getContentPane().add(lblNom);
		
		JLabel lblLocal = new JLabel("Local");
		lblLocal.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblLocal.setHorizontalAlignment(SwingConstants.CENTER);
		lblLocal.setBounds(22, 60, 70, 14);
		frame.getContentPane().add(lblLocal);
		
		JLabel lblSalle = new JLabel("Salle");
		lblSalle.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblSalle.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalle.setBounds(22, 85, 70, 14);
		frame.getContentPane().add(lblSalle);
		
		JLabel lblSwitch = new JLabel("Switch");
		lblSwitch.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblSwitch.setHorizontalAlignment(SwingConstants.CENTER);
		lblSwitch.setBounds(22, 110, 70, 14);
		frame.getContentPane().add(lblSwitch);
		
		JLabel lblCarteRseau = new JLabel("Carte r\u00E9seau");
		lblCarteRseau.setHorizontalAlignment(SwingConstants.CENTER);
		lblCarteRseau.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblCarteRseau.setBounds(22, 157, 70, 14);
		frame.getContentPane().add(lblCarteRseau);
		
		textField = new JTextField();
		textField.setBounds(102, 33, 229, 17);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(102, 57, 229, 20);
		frame.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(102, 82, 229, 20);
		frame.getContentPane().add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(102, 107, 229, 20);
		frame.getContentPane().add(comboBox_2);
		
		JList list = new JList();
		list.setBounds(99, 147, 229, 68);
		frame.getContentPane().add(list);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnValider.setBounds(352, 227, 89, 23);
		frame.getContentPane().add(btnValider);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAnnuler.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnAnnuler.setBounds(260, 227, 89, 23);
		frame.getContentPane().add(btnAnnuler);
		
		JButton btnAjouterCarteRseau = new JButton("Ajouter carte r\u00E9seau");
		btnAjouterCarteRseau.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnAjouterCarteRseau.setBounds(133, 227, 127, 23);
		frame.getContentPane().add(btnAjouterCarteRseau);
		
		JButton btnRetirerCarteRseau = new JButton("Retirer carte r\u00E9seau");
		btnRetirerCarteRseau.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnRetirerCarteRseau.setBounds(10, 227, 121, 23);
		frame.getContentPane().add(btnRetirerCarteRseau);
	}
}