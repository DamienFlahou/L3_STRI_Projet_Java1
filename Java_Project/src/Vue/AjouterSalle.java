package Vue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import Controleur.ControleurAjouterSalle;
import Model.Local;
import Model.Routeur;
import Model.Switch;


public class AjouterSalle extends JFrame{

	private JTextField textField_Nom;
	
	private static final int BValider = 1;
	private static final int BAnnuler = 2;
	
	private ApplicationWindows applicationPrincipale;
	
	private DefaultListModel<Local> DlisteLocaux;
	private DefaultListModel<Routeur> DlisteRouteurs;
	private DefaultListModel<Switch> DlisteSwitch;
	
	private ArrayList<Local> listeLocaux = new ArrayList<Local>();
	private ArrayList<Routeur> listeRouteurs = new ArrayList<Routeur>();
	private ArrayList<Switch> listeSwitch = new ArrayList<Switch>();
	
	private JComboBox comboBox_Local;
	private JComboBox comboBox_Routeur;
	private JComboBox comboBox_Switch;
	
	/**
	 * Create the application.
	 */
	public AjouterSalle(ApplicationWindows _fenetre) {
		applicationPrincipale = _fenetre;
		DlisteLocaux = applicationPrincipale.getListeLocaux();
		DlisteRouteurs = applicationPrincipale.getListeRouteurs();
		DlisteSwitch = applicationPrincipale.getListeSwitchs();
		
		listeRouteurs.add(new Routeur("", true));
		listeSwitch.add(new Switch("", true));
		
		for(int i = 0; i < DlisteLocaux.size(); i++){
			listeLocaux.add(DlisteLocaux.get(i));
		}
		
		for(int i = 0; i < DlisteRouteurs.size(); i++){
			listeRouteurs.add(DlisteRouteurs.get(i));
		}
		
		for(int i = 0; i < DlisteSwitch.size(); i++){
			listeSwitch.add(DlisteSwitch.get(i));
		}
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setTitle("Ajouter salle");
		this.setBounds(100, 100, 423, 279);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setLocationRelativeTo(applicationPrincipale);
		this.setResizable(false);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setHorizontalAlignment(SwingConstants.CENTER);
		lblNom.setBounds(33, 29, 78, 31);
		this.getContentPane().add(lblNom);
		
		JLabel lblLocal = new JLabel("Local");
		lblLocal.setHorizontalAlignment(SwingConstants.CENTER);
		lblLocal.setBounds(33, 71, 78, 31);
		this.getContentPane().add(lblLocal);
		
		JLabel lblRouteur = new JLabel("Routeur");
		lblRouteur.setHorizontalAlignment(SwingConstants.CENTER);
		lblRouteur.setBounds(33, 113, 78, 31);
		this.getContentPane().add(lblRouteur);
		
		JLabel lblSwitch = new JLabel("Switch");
		lblSwitch.setHorizontalAlignment(SwingConstants.CENTER);
		lblSwitch.setBounds(33, 155, 78, 31);
		this.getContentPane().add(lblSwitch);
		
		textField_Nom = new JTextField();
		textField_Nom.setBounds(151, 34, 221, 20);
		this.getContentPane().add(textField_Nom);
		textField_Nom.setColumns(10);
		
		comboBox_Local = new JComboBox(listeLocaux.toArray());
		comboBox_Local.setBounds(151, 76, 221, 20);
		this.getContentPane().add(comboBox_Local);
		
		comboBox_Routeur = new JComboBox(listeRouteurs.toArray());
		comboBox_Routeur.setBounds(151, 118, 221, 20);
		this.getContentPane().add(comboBox_Routeur);
		
		comboBox_Switch = new JComboBox(listeSwitch.toArray());
		comboBox_Switch.setBounds(151, 160, 221, 20);
		this.getContentPane().add(comboBox_Switch);
		
		comboBox_Routeur.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
		        if(comboBox_Routeur.getSelectedIndex() > 0){
		        	comboBox_Switch.setSelectedIndex(0);
		        }
		    }
		});
		
		comboBox_Switch.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
		        if(comboBox_Switch.getSelectedIndex() > 0){
		        	comboBox_Routeur.setSelectedIndex(0);
		        }
		    }
		});
		
		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(302, 207, 89, 23);
		this.getContentPane().add(btnValider);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(184, 207, 89, 23);
		this.getContentPane().add(btnAnnuler);
		
		btnValider.addMouseListener(new ControleurAjouterSalle(this, BValider));
		btnAnnuler.addMouseListener(new ControleurAjouterSalle(this, BAnnuler));
		
	}
	
	public ApplicationWindows getApplicationPrincipale() {
		return applicationPrincipale;
	}
	
	public JTextField getTextField_nom() {
		return textField_Nom;
	}

	public JComboBox getComboBox_Local() {
		return comboBox_Local;
	}

	public JComboBox getComboBox_Routeur() {
		return comboBox_Routeur;
	}

	public JComboBox getComboBox_Switch() {
		return comboBox_Switch;
	}
	
}
