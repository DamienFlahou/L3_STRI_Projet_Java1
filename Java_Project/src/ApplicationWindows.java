import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Color;

import javax.swing.SwingConstants;

import java.awt.Font;
import java.util.ArrayList;


public class ApplicationWindows extends JFrame implements ListSelectionListener, MouseListener{
	
	public static final int SLocal = 1;
	public static final int SSalle = 2;
	public static final int SOrdinateurPhysique = 3;
	public static final int SCarteReseauPhysique = 4;
	public static final int SRouteur = 5;
	public static final int SSwitch = 6;
	public static final int SOrdinateurLogique = 7;
	public static final int SCarteReseauLogique = 8;
	
	public static final int SBoutonAjouter = 1;
	public static final int SBoutonModifier = 2;
	public static final int SBoutonSupprimer = 3;
	public static final int SBoutonMiseJour = 4;
	public static final int SBoutonActiver = 5;
	public static final int SBoutonDsActiver = 6;
	
	public static final int SBoutonAjouter_1 = 7;
	public static final int SBoutonModifier_1 = 8;
	public static final int SBoutonSupprimer_1 = 9;
	public static final int SBoutonMiseJour_1 = 10;
	public static final int SBoutonActiver_1 = 11;
	public static final int SBoutonDsActiver_1 = 12;
	
	// Sert à savoir quelle liste est focus pour pouvoir adapter le comportement des boutons
	private int focusList = 1;
	
	public int getFocusList() {
		return focusList;
	}

	public void setFocusList(int focusList) {
		this.focusList = focusList;
	}

	ArrayList<Local> listeLocaux = new ArrayList<Local>();
	ArrayList<Salle> listeSalles = new ArrayList<Salle>();
	ArrayList<Ordinateur> listeOrdinateurs = new ArrayList<Ordinateur>();
	ArrayList<CarteReseau> listeCarteReseaux = new ArrayList<CarteReseau>();
	
	ArrayList<Routeur> listeRouteurs = new ArrayList<Routeur>();
	ArrayList<Switch> listeSwitchs = new ArrayList<Switch>();
	ArrayList<Ordinateur> listeOrdinateurs2 = new ArrayList<Ordinateur>();
	ArrayList<CarteReseau> listeCarteReseaux2 = new ArrayList<CarteReseau>();
	
	private JList list_locaux;
	private JList list_salles;
	private JList list_ordinateurs_physique;
	private JList list_cartes_reseaux;
	private JList list_routeurs;
	private JList list_switchs;
	private JList list_ordinateurs_logique;
	private JList list_cartes_reseaux_logique;
	
	private JButton btnAjouter;
	private JButton btnSupprimer;
	private JButton btnModifier;
	private JButton btnMiseJour;
	private JButton btnActiver;
	private JButton btnDsactiver;
	
	private JButton btnAjouter_1;
	private JButton btnSupprimer_1;
	private JButton btnModifier_1;
	private JButton btnMiseJour_1;
	private JButton btnActiver_1;
	private JButton btnDsactiver_1;
	
	
	
	public JButton getBtnSupprimer() {
		return btnSupprimer;
	}

	public JButton getBtnModifier() {
		return btnModifier;
	}

	public JButton getBtnMiseJour() {
		return btnMiseJour;
	}

	public JButton getBtnActiver() {
		return btnActiver;
	}

	public JButton getBtnDsactiver() {
		return btnDsactiver;
	}

	public JButton getBtnAjouter_1() {
		return btnAjouter_1;
	}

	public JButton getBtnSupprimer_1() {
		return btnSupprimer_1;
	}

	public JButton getBtnModifier_1() {
		return btnModifier_1;
	}

	public JButton getBtnMiseJour_1() {
		return btnMiseJour_1;
	}

	public JButton getBtnActiver_1() {
		return btnActiver_1;
	}

	public JButton getBtnDsactiver_1() {
		return btnDsactiver_1;
	}

	public JButton getBtnAjouter() {
		return btnAjouter;
	}

	public JList getList_locaux() {
		return list_locaux;
	}

	public JList getList_salles() {
		return list_salles;
	}

	public JList getList_ordinateurs_physique() {
		return list_ordinateurs_physique;
	}

	public JList getList_cartes_reseaux() {
		return list_cartes_reseaux;
	}

	public JList getList_routeurs() {
		return list_routeurs;
	}

	public JList getList_switchs() {
		return list_switchs;
	}

	public JList getList_ordinateurs_logique() {
		return list_ordinateurs_logique;
	}

	public JList getList_cartes_reseaux_logique() {
		return list_cartes_reseaux_logique;
	}

	public ApplicationWindows() {

		listeLocaux.add(new Local("local 1"));
		listeLocaux.add(new Local("local 2"));
		
		listeSalles.add(new Salle("salle 1"));
		listeSalles.add(new Salle("salle 2"));
		
		listeOrdinateurs.add(new Ordinateur("ordinateur 1"));
		listeOrdinateurs.add(new Ordinateur("ordinateur 2"));
		
		listeCarteReseaux.add(new CarteReseau("00:00:00:00:00"));
		listeCarteReseaux.add(new CarteReseau("11:11:11:11:11"));
		
		listeRouteurs.add(new Routeur("routeur 1"));
		listeRouteurs.add(new Routeur("routeur 2"));
		
		listeSwitchs.add(new Switch("switch 1"));
		listeSwitchs.add(new Switch("switch 2"));
		
		listeOrdinateurs2.add(new Ordinateur("ordinateur 3"));
		listeOrdinateurs2.add(new Ordinateur("ordinateur 4"));
		
		listeCarteReseaux2.add(new CarteReseau("22:22:22:22:22"));
		listeCarteReseaux2.add(new CarteReseau("33:33:33:33:33"));
		
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setBounds(100, 100, 663, 336);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		this.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel Reseau_physique = new JPanel();
		tabbedPane.addTab("R\u00E9seau physique", null, Reseau_physique, null);
		Reseau_physique.setLayout(null);
		
		JLabel lblCartesReseauxP = new JLabel("Cartes r\u00E9seaux");
		lblCartesReseauxP.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblCartesReseauxP.setForeground(Color.BLACK);
		lblCartesReseauxP.setHorizontalAlignment(SwingConstants.CENTER);
		lblCartesReseauxP.setBounds(450, 33, 135, 23);
		Reseau_physique.add(lblCartesReseauxP);
		
		JLabel lblOrdinateursP = new JLabel("Ordinateurs");
		lblOrdinateursP.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblOrdinateursP.setForeground(Color.BLACK);
		lblOrdinateursP.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrdinateursP.setBounds(316, 33, 135, 23);
		Reseau_physique.add(lblOrdinateursP);
		
		JLabel lblSalles = new JLabel("Salles");
		lblSalles.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblSalles.setForeground(Color.BLACK);
		lblSalles.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalles.setBounds(182, 33, 135, 23);
		Reseau_physique.add(lblSalles);
		
		JLabel lblLocaux = new JLabel("Locaux");
		lblLocaux.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblLocaux.setForeground(Color.BLACK);
		lblLocaux.setBackground(Color.WHITE);
		lblLocaux.setHorizontalAlignment(SwingConstants.CENTER);
		lblLocaux.setBounds(48, 33, 135, 23);
		Reseau_physique.add(lblLocaux);
		
		list_locaux = new JList(listeLocaux.toArray());
		list_locaux.setBorder(new LineBorder(new Color(0, 0, 0)));
		list_locaux.setToolTipText("");
		list_locaux.setBounds(48, 54, 135, 157);
		Reseau_physique.add(list_locaux);
		
		
		list_salles = new JList(listeSalles.toArray());
		list_salles.setBorder(new LineBorder(new Color(0, 0, 0)));
		list_salles.setBounds(182, 54, 135, 157);
		Reseau_physique.add(list_salles);
		
		list_ordinateurs_physique = new JList(listeOrdinateurs.toArray());
		list_ordinateurs_physique.setBorder(new LineBorder(new Color(0, 0, 0)));
		list_ordinateurs_physique.setBounds(316, 54, 135, 157);
		Reseau_physique.add(list_ordinateurs_physique);
		
		list_cartes_reseaux = new JList(listeCarteReseaux.toArray());
		list_cartes_reseaux.setBorder(new LineBorder(new Color(0, 0, 0)));
		list_cartes_reseaux.setBounds(450, 54, 135, 157);
		Reseau_physique.add(list_cartes_reseaux);

		
		//Ajoute List Selection listener sur les listes pour savoir quel type d'ajout ou de modification il faudra faire
		list_locaux.addListSelectionListener(new ControleurSelectionListe(this, SLocal));
		list_salles.addListSelectionListener(new ControleurSelectionListe(this, SSalle));
		list_ordinateurs_physique.addListSelectionListener(new ControleurSelectionListe(this, SOrdinateurPhysique));
		list_cartes_reseaux.addListSelectionListener(new ControleurSelectionListe(this, SCarteReseauPhysique));
		
		btnAjouter = new JButton("Ajouter");
		btnAjouter.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnAjouter.setBounds(30, 222, 89, 35);
		Reseau_physique.add(btnAjouter);
		
		btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnSupprimer.setBounds(228, 223, 89, 34);
		Reseau_physique.add(btnSupprimer);
		
		btnMiseJour = new JButton("Mise \u00E0 jour");
		btnMiseJour.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnMiseJour.setBounds(327, 222, 89, 35);
		Reseau_physique.add(btnMiseJour);
		
		btnActiver = new JButton("Activer");
		btnActiver.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnActiver.setBounds(426, 222, 89, 35);
		Reseau_physique.add(btnActiver);
		
		btnDsactiver = new JButton("D\u00E9sactiver");
		btnDsactiver.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnDsactiver.setBounds(525, 222, 89, 35);
		Reseau_physique.add(btnDsactiver);
		
		btnModifier = new JButton("Modifier");
		btnModifier.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnModifier.setBounds(129, 222, 89, 35);
		Reseau_physique.add(btnModifier);
		
		//Ajout du mouse listener pour savoir quand le bouton est cliqué
		
		btnAjouter.addMouseListener(new ControleurBouton(this, SBoutonAjouter));
		btnActiver.addMouseListener(new ControleurBouton(this, SBoutonActiver));
		btnDsactiver.addMouseListener(new ControleurBouton(this, SBoutonDsActiver));
		btnMiseJour.addMouseListener(new ControleurBouton(this, SBoutonMiseJour));
		btnModifier.addMouseListener(new ControleurBouton(this, SBoutonModifier));
		btnSupprimer.addMouseListener(new ControleurBouton(this, SBoutonSupprimer));
		
		JPanel Reseau_logique = new JPanel();
		tabbedPane.addTab("R\u00E9seau logique", null, Reseau_logique, null);
		Reseau_logique.setLayout(null);
		
		JLabel lblCartesReseauxL = new JLabel("Cartes r\u00E9seaux");
		lblCartesReseauxL.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblCartesReseauxL.setForeground(Color.BLACK);
		lblCartesReseauxL.setHorizontalAlignment(SwingConstants.CENTER);
		lblCartesReseauxL.setBounds(450, 33, 135, 23);
		Reseau_logique.add(lblCartesReseauxL);
		
		JLabel lblOrdinateursL = new JLabel("Ordinateurs");
		lblOrdinateursL.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblOrdinateursL.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrdinateursL.setForeground(Color.BLACK);
		lblOrdinateursL.setBounds(316, 33, 135, 23);
		Reseau_logique.add(lblOrdinateursL);
		
		JLabel lblNewLabel = new JLabel("Switchs");
		lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(182, 33, 135, 23);
		Reseau_logique.add(lblNewLabel);
		
		JLabel lblRouteurs = new JLabel("Routeurs");
		lblRouteurs.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblRouteurs.setForeground(Color.BLACK);
		lblRouteurs.setHorizontalAlignment(SwingConstants.CENTER);
		lblRouteurs.setBounds(48, 33, 135, 23);
		Reseau_logique.add(lblRouteurs);
		
		list_routeurs = new JList(listeRouteurs.toArray());
		list_routeurs.setBorder(new LineBorder(new Color(0, 0, 0)));
		list_routeurs.setBounds(48, 54, 135, 157);
		Reseau_logique.add(list_routeurs);
		
		list_switchs = new JList(listeSwitchs.toArray());
		list_switchs.setBorder(new LineBorder(new Color(0, 0, 0)));
		list_switchs.setBounds(182, 54, 135, 157);
		Reseau_logique.add(list_switchs);
		
		list_ordinateurs_logique = new JList(listeOrdinateurs2.toArray());
		list_ordinateurs_logique.setBorder(new LineBorder(new Color(0, 0, 0)));
		list_ordinateurs_logique.setBounds(316, 54, 135, 157);
		Reseau_logique.add(list_ordinateurs_logique);
		
		list_cartes_reseaux_logique = new JList(listeCarteReseaux2.toArray());
		list_cartes_reseaux_logique.setBorder(new LineBorder(new Color(0, 0, 0)));
		list_cartes_reseaux_logique.setBounds(450, 54, 135, 157);
		Reseau_logique.add(list_cartes_reseaux_logique);
		
		//Ajoute List Selection listener sur les listes pour savoir quel type d'ajout ou de modification il faudra faire
		list_routeurs.addListSelectionListener(new ControleurSelectionListe(this, SRouteur));
		list_switchs.addListSelectionListener(new ControleurSelectionListe(this, SSwitch));
		list_ordinateurs_logique.addListSelectionListener(new ControleurSelectionListe(this, SOrdinateurLogique));
		list_cartes_reseaux_logique.addListSelectionListener(new ControleurSelectionListe(this, SCarteReseauLogique));
		
		btnAjouter_1 = new JButton("Ajouter");
		btnAjouter_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnAjouter_1.setBounds(30, 222, 89, 35);
		Reseau_logique.add(btnAjouter_1);
		
		btnModifier_1 = new JButton("Modifier");
		btnModifier_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnModifier_1.setBounds(129, 222, 89, 35);
		Reseau_logique.add(btnModifier_1);
		
		btnSupprimer_1 = new JButton("Supprimer");
		btnSupprimer_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnSupprimer_1.setBounds(228, 222, 89, 35);
		Reseau_logique.add(btnSupprimer_1);
		
		btnMiseJour_1 = new JButton("Mise \u00E0 jour");
		btnMiseJour_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnMiseJour_1.setBounds(327, 222, 89, 35);
		Reseau_logique.add(btnMiseJour_1);
		
		btnActiver_1 = new JButton("Activer");
		btnActiver_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnActiver_1.setBounds(426, 222, 89, 35);
		Reseau_logique.add(btnActiver_1);
		
		btnDsactiver_1 = new JButton("D\u00E9sactiver");
		btnDsactiver_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnDsactiver_1.setBounds(525, 222, 89, 35);
		Reseau_logique.add(btnDsactiver_1);
		
		//Ajout du mouse listener pour savoir quand le bouton est cliqué et afficher la fenetre correspondnte
		
		btnAjouter_1.addMouseListener(new ControleurBouton(this, SBoutonAjouter_1));
		btnActiver_1.addMouseListener(new ControleurBouton(this, SBoutonActiver_1));
		btnDsactiver_1.addMouseListener(new ControleurBouton(this, SBoutonDsActiver_1));
		btnMiseJour_1.addMouseListener(new ControleurBouton(this, SBoutonMiseJour_1));
		btnModifier_1.addMouseListener(new ControleurBouton(this, SBoutonModifier_1));
		btnSupprimer_1.addMouseListener(new ControleurBouton(this, SBoutonSupprimer_1));		
	}

	public static int getScartereseauphysique() {
		return SCarteReseauPhysique;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		JList lsm = (JList)e.getSource();
			System.out.println(lsm.getName());
		
	}
	
	
}
