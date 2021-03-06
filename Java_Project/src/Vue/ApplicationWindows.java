package Vue;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.SwingConstants;

import Controleur.ControleurBouton;
import Controleur.ControleurSelectionListe;
import Model.CarteReseau;
import Model.Gestion_base_de_donnee;
import Model.Local;
import Model.Ordinateur;
import Model.Routeur;
import Model.Salle;
import Model.Switch;

import java.awt.Font;
import java.util.ArrayList;


public class ApplicationWindows extends JFrame implements MouseListener{
	
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
	
	private Gestion_base_de_donnee bdd;
	private ArrayList<Local> reseauPhysique;
	
	DefaultListModel listeLocaux = new DefaultListModel();
	DefaultListModel listeSalles = new DefaultListModel();
	DefaultListModel listeOrdinateurs = new DefaultListModel();
	DefaultListModel listeCarteReseaux = new DefaultListModel();
	
	DefaultListModel listeRouteurs = new DefaultListModel();
	DefaultListModel listeSwitchs = new DefaultListModel();
	DefaultListModel listeOrdinateurs2 = new DefaultListModel();
	DefaultListModel listeCarteReseaux2 = new DefaultListModel();
	
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
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private JScrollPane scrollPane_3;
	private JScrollPane scrollPane_4;
	private JScrollPane scrollPane_5;
	private JScrollPane scrollPane_6;
	private JScrollPane scrollPane_7;

	public ApplicationWindows(Gestion_base_de_donnee _bdd) {
		
		bdd = _bdd;
		
		//Tout a été mis dans le réseau physique
		reseauPhysique = bdd.getReseauPhysique();
		
		initialize();
		
		this.miseAJourListes();
		
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
		lblCartesReseauxP.setBounds(450, 33, 149, 23);
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(450, 53, 149, 157);
		Reseau_physique.add(scrollPane);
		
		list_cartes_reseaux = new JList(listeCarteReseaux);
		scrollPane.setViewportView(list_cartes_reseaux);
		list_cartes_reseaux.setBorder(new LineBorder(new Color(0, 0, 0)));
		list_cartes_reseaux.addMouseListener(new ControleurSelectionListe(this, SCarteReseauPhysique));
		list_cartes_reseaux.setCellRenderer(new ListCellActive(this, SCarteReseauPhysique));
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(316, 54, 135, 157);
		Reseau_physique.add(scrollPane_1);
		
		list_ordinateurs_physique = new JList(listeOrdinateurs);
		scrollPane_1.setViewportView(list_ordinateurs_physique);
		list_ordinateurs_physique.setBorder(new LineBorder(new Color(0, 0, 0)));
		list_ordinateurs_physique.addMouseListener(new ControleurSelectionListe(this, SOrdinateurPhysique));
		list_ordinateurs_physique.setCellRenderer(new ListCellActive(this, SOrdinateurPhysique));
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(182, 54, 135, 157);
		Reseau_physique.add(scrollPane_2);
		
		
		list_salles = new JList(listeSalles);
		scrollPane_2.setViewportView(list_salles);
		list_salles.setBorder(new LineBorder(new Color(0, 0, 0)));
		list_salles.addMouseListener(new ControleurSelectionListe(this, SSalle));
		list_salles.setCellRenderer(new ListCellActive(this, SSalle));
		
		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(48, 53, 135, 157);
		Reseau_physique.add(scrollPane_3);
		
		list_locaux = new JList(listeLocaux);
		scrollPane_3.setViewportView(list_locaux);
		list_locaux.setBorder(new LineBorder(new Color(0, 0, 0)));
		list_locaux.setToolTipText("");
		
				
				//Ajoute List Selection listener sur les listes pour savoir quel type d'ajout ou de modification il faudra faire
				list_locaux.addMouseListener(new ControleurSelectionListe(this, SLocal));
				
				//Ajoute La couleur sur les cellules
				list_locaux.setCellRenderer(new ListCellActive(this, SLocal));
				
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
		lblCartesReseauxL.setBounds(450, 33, 152, 23);
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
		
		scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(48, 54, 135, 157);
		Reseau_logique.add(scrollPane_4);
		
		list_routeurs = new JList(listeRouteurs);
		scrollPane_4.setViewportView(list_routeurs);
		list_routeurs.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		//Ajoute List Selection listener sur les listes pour savoir quel type d'ajout ou de modification il faudra faire
		list_routeurs.addMouseListener(new ControleurSelectionListe(this, SRouteur));
		
		//Ajoute La couleur sur les cellules
		list_routeurs.setCellRenderer(new ListCellActive(this, SRouteur));
		
		scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(182, 54, 135, 157);
		Reseau_logique.add(scrollPane_5);
		
		list_switchs = new JList(listeSwitchs);
		scrollPane_5.setViewportView(list_switchs);
		list_switchs.setBorder(new LineBorder(new Color(0, 0, 0)));
		list_switchs.addMouseListener(new ControleurSelectionListe(this, SSwitch));
		list_switchs.setCellRenderer(new ListCellActive(this, SSwitch));
		
		scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(316, 54, 135, 157);
		Reseau_logique.add(scrollPane_6);
		
		list_ordinateurs_logique = new JList(listeOrdinateurs2);
		scrollPane_6.setViewportView(list_ordinateurs_logique);
		list_ordinateurs_logique.setBorder(new LineBorder(new Color(0, 0, 0)));
		list_ordinateurs_logique.addMouseListener(new ControleurSelectionListe(this, SOrdinateurLogique));
		list_ordinateurs_logique.setCellRenderer(new ListCellActive(this, SOrdinateurLogique));
		
		scrollPane_7 = new JScrollPane();
		scrollPane_7.setBounds(449, 54, 153, 156);
		Reseau_logique.add(scrollPane_7);
		
		list_cartes_reseaux_logique = new JList(listeCarteReseaux2);
		scrollPane_7.setViewportView(list_cartes_reseaux_logique);
		list_cartes_reseaux_logique.setBorder(new LineBorder(new Color(0, 0, 0)));
		list_cartes_reseaux_logique.addMouseListener(new ControleurSelectionListe(this, SCarteReseauLogique));
		list_cartes_reseaux_logique.setCellRenderer(new ListCellActive(this, SCarteReseauLogique));
		
		//Ajout du mouse listener pour savoir quand le bouton est cliqué et afficher la fenetre correspondnte
		
		btnAjouter_1.addMouseListener(new ControleurBouton(this, SBoutonAjouter_1));
		btnActiver_1.addMouseListener(new ControleurBouton(this, SBoutonActiver_1));
		btnDsactiver_1.addMouseListener(new ControleurBouton(this, SBoutonDsActiver_1));
		btnMiseJour_1.addMouseListener(new ControleurBouton(this, SBoutonMiseJour_1));
		btnModifier_1.addMouseListener(new ControleurBouton(this, SBoutonModifier_1));
		btnSupprimer_1.addMouseListener(new ControleurBouton(this, SBoutonSupprimer_1));
	}
	
	public void miseAJourListes(){
		
		// Vide les listes pour les re-remplir après
		listeLocaux.removeAllElements();
		listeSalles.removeAllElements();
		listeOrdinateurs.removeAllElements();;
		listeCarteReseaux.removeAllElements();
		
		listeRouteurs.removeAllElements();
		listeSwitchs.removeAllElements();
		listeOrdinateurs2.removeAllElements();
		listeCarteReseaux2.removeAllElements();
		
		//Remplissage réseau logique
		for(Local local : reseauPhysique){
			listeLocaux.addElement(local);
			
			for(Routeur routeur : local.getListeRouteur()){
				listeRouteurs.addElement(routeur);
				
				for(Switch switchRemplisseur : routeur.getListeSwitch()){
					listeSwitchs.addElement(switchRemplisseur);
					
					for(Ordinateur ordinateur : switchRemplisseur.getListeOrdinateur()){
						listeOrdinateurs2.addElement(ordinateur);
						
						for(CarteReseau carte : ordinateur.getListeCarteReseau()){
							listeCarteReseaux2.addElement(carte);
						}
					}
				}
			}
			
			//réseau physique
			for(Salle salle : local.getListeSalle()){
				listeSalles.addElement(salle);
				
				for(Ordinateur ordinateur : salle.getListeOrdinateur()){
					listeOrdinateurs.addElement(ordinateur);
					
					for(CarteReseau carte : ordinateur.getListeCarteReseau()){
						listeCarteReseaux.addElement(carte);
					}
				}
			}
		}
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
	
	public int getFocusList() {
		return focusList;
	}

	public void setFocusList(int focusList) {
		this.focusList = focusList;
	}
	
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

	public DefaultListModel getListeLocaux() {
		return listeLocaux;
	}

	public DefaultListModel getListeSalles() {
		return listeSalles;
	}

	public DefaultListModel getListeOrdinateurs() {
		return listeOrdinateurs;
	}

	public DefaultListModel getListeCarteReseaux() {
		return listeCarteReseaux;
	}

	public DefaultListModel getListeRouteurs() {
		return listeRouteurs;
	}

	public DefaultListModel getListeSwitchs() {
		return listeSwitchs;
	}

	public DefaultListModel getListeOrdinateurs2() {
		return listeOrdinateurs2;
	}

	public DefaultListModel getListeCarteReseaux2() {
		return listeCarteReseaux2;
	}

	public ArrayList<Local> getReseauPhysique() {
		return reseauPhysique;
	}
}
