package Vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JButton;

import Controleur.ControleurAjouterOrdinateur;
import Controleur.ControleurAjouterSalle;
import Model.Local;
import Model.Routeur;
import Model.Salle;
import Model.Switch;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;


public class AjouterOrdinateur extends JFrame{

	private JTextField textField_nom;
	ApplicationWindows applicationPrincipale;
	
	private static final int BValider = 1;
	private static final int BAnnuler = 2;
	
	private ArrayList<Local> listeLocaux = new ArrayList<Local>();
	private ArrayList<Salle> listeSalle = new ArrayList<Salle>();
	private ArrayList<Switch> listeSwitch = new ArrayList<Switch>();
	
	JComboBox comboBox;
	JComboBox comboBox_1;
	JComboBox comboBox_2;

	/**
	 * Create the application.
	 **/
	
	public AjouterOrdinateur(ApplicationWindows fenetre) {
		this.applicationPrincipale = fenetre;
		
		listeLocaux = fenetre.getReseauPhysique();
		
		for(int i = 0; i < fenetre.getReseauPhysique().size(); i++){
			ArrayList<Routeur> listeRouteur= fenetre.getReseauPhysique().get(i).getListeRouteur();
			for(int j = 0; j < listeRouteur.size(); j++){
				listeSwitch.addAll(listeRouteur.get(j).getListeSwitch());
			}
			listeSalle = fenetre.getReseauPhysique().get(i).getListeSalle();

		}
		
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
		this.setLocationRelativeTo(applicationPrincipale);
		
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
		
		JLabel lblSwitch = new JLabel("Switch");
		lblSwitch.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblSwitch.setHorizontalAlignment(SwingConstants.CENTER);
		lblSwitch.setBounds(22, 110, 70, 14);
		this.getContentPane().add(lblSwitch);
		
		JLabel lblCarteRseau = new JLabel("Carte r\u00E9seau");
		lblCarteRseau.setHorizontalAlignment(SwingConstants.CENTER);
		lblCarteRseau.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblCarteRseau.setBounds(22, 157, 70, 14);
		this.getContentPane().add(lblCarteRseau);
		
		textField_nom = new JTextField();
		textField_nom.setBounds(102, 33, 229, 17);
		this.getContentPane().add(textField_nom);
		textField_nom.setColumns(10);
		
		comboBox = new JComboBox(listeLocaux.toArray());
		comboBox.setBounds(102, 57, 229, 20);
		this.getContentPane().add(comboBox);
		
		comboBox_1 = new JComboBox(listeSwitch.toArray());
		comboBox_1.setBounds(102, 82, 229, 20);
		this.getContentPane().add(comboBox_1);
		
		comboBox_2 = new JComboBox(listeSalle.toArray());
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
		
		JButton btnAjouterCarteRseau = new JButton("Ajouter carte r\u00E9seau");
		btnAjouterCarteRseau.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnAjouterCarteRseau.setBounds(133, 227, 127, 23);
		this.getContentPane().add(btnAjouterCarteRseau);
		
		JButton btnRetirerCarteRseau = new JButton("Retirer carte r\u00E9seau");
		btnRetirerCarteRseau.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnRetirerCarteRseau.setBounds(10, 227, 121, 23);
		this.getContentPane().add(btnRetirerCarteRseau);
		

		btnValider.addMouseListener(new ControleurAjouterOrdinateur(this, BValider));
		btnAnnuler.addMouseListener(new ControleurAjouterOrdinateur(this, BAnnuler));
		
	}

	public JComboBox getComboBox() {
		return comboBox;
	}

	public JComboBox getComboBox_1() {
		return comboBox_1;
	}

	public JComboBox getComboBox_2() {
		return comboBox_2;
	}

	public JTextField getTextField_nom() {
		return textField_nom;
	}

	public ApplicationWindows getApplicationPrincipale() {
		return applicationPrincipale;
	}
}
