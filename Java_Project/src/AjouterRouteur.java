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


public class AjouterRouteur extends JFrame{

	private JTextField textField;


	/**
	 * Create the application.
	 */
	public AjouterRouteur() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	
		this.setBounds(100, 100, 467, 300);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
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
		
		JLabel lblSalle = new JLabel("Salle");
		lblSalle.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblSalle.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalle.setBounds(22, 85, 70, 14);
		this.getContentPane().add(lblSalle);
		
		textField = new JTextField();
		textField.setBounds(102, 33, 229, 17);
		this.getContentPane().add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(102, 57, 229, 20);
		this.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(102, 82, 229, 20);
		this.getContentPane().add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(102, 107, 229, 20);
		this.getContentPane().add(comboBox_2);
		
		JList list = new JList();
		list.setBounds(99, 147, 229, 68);
		this.getContentPane().add(list);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnValider.setBounds(352, 227, 89, 23);
		this.getContentPane().add(btnValider);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAnnuler.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnAnnuler.setBounds(260, 227, 89, 23);
		this.getContentPane().add(btnAnnuler);
		
	}
}
