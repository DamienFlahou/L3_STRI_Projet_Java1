package Controleur;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Model.CarteReseau;
import Model.Local;
import Model.Ordinateur;
import Model.Routeur;
import Model.Salle;
import Model.Switch;
import Vue.ApplicationWindows;


public class ControleurSelectionListe implements MouseListener{
	public static final int SLocal = 1;
	public static final int SSalle = 2;
	public static final int SOrdinateurPhysique = 3;
	public static final int SCarteReseauPhysique = 4;
	public static final int SRouteur = 5;
	public static final int SSwitch = 6;
	public static final int SOrdinateurLogique = 7;
	public static final int SCarteReseauLogique = 8;
	
	ApplicationWindows fenetre;
	int numeroListe;
	
	int selectionPrecedente = -1;  //Permet d'éviter les multiples triggers
	
	ArrayList<Salle> listeSalles = null;
	ArrayList<Ordinateur> listeOrdinateurs = null;
	
	ArrayList<Switch> listeSwitchs = null;
	ArrayList<Ordinateur> listeOrdinateurs2 = null;
	
	public ControleurSelectionListe(ApplicationWindows _fenetre, int numListe){
		fenetre = _fenetre;
		numeroListe = numListe;
	}

	private void changerBoutonsPhysique(String type){
		fenetre.getBtnAjouter().setText("<html><center>Ajouter<br/>" + type + "</center></html>");
		fenetre.getBtnModifier().setText("<html><center>Modifier<br/>" + type + "</center></html>");
		fenetre.getBtnSupprimer().setText("<html><center>Supprimer<br/>" + type + "</center></html>");
		fenetre.getBtnMiseJour().setText("<html><center>Mise à jour<br/>" + type + "</center></html>");
		fenetre.getBtnActiver().setText("<html><center>Activer<br/>" + type + "</center></html>");
		fenetre.getBtnDsactiver().setText("<html><center>Désactiver<br/>" + type + "</center></html>");
	}
	
	private void changerBoutonsLogique(String type){
		fenetre.getBtnAjouter_1().setText("<html><center>Ajouter<br/>" + type + "</center></html>");
		fenetre.getBtnModifier_1().setText("<html><center>Modifier<br/>" + type + "</center></html>");
		fenetre.getBtnSupprimer_1().setText("<html><center>Supprimer<br/>" + type + "</center></html>");
		fenetre.getBtnMiseJour_1().setText("<html><center>Mise à jour<br/>" + type + "</center></html>");
		fenetre.getBtnActiver_1().setText("<html><center>Activer<br/>" + type + "</center></html>");
		fenetre.getBtnDsactiver_1().setText("<html><center>Désactiver<br/>" + type + "</center></html>");
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {

		fenetre.setFocusList(numeroListe);
		
		switch(numeroListe){
		case SLocal :
				changerBoutonsPhysique("Local");
				
				//remplit les autres listes en fonction de l'élément
				Local local = (Local) fenetre.getListeLocaux().get(fenetre.getList_locaux().getSelectedIndex());
				listeSalles = local.getListeSalle();
				fenetre.getListeSalles().clear();
				fenetre.getListeOrdinateurs().clear();
				fenetre.getListeCarteReseaux().clear();
				
				for(Salle salle : listeSalles){
					fenetre.getListeSalles().addElement(salle);
					
					for(Ordinateur ordinateur : salle.getListeOrdinateur()){
						fenetre.getListeOrdinateurs().addElement(ordinateur);
						
						for(CarteReseau carte : ordinateur.getListeCarteReseau()){
							fenetre.getListeCarteReseaux().addElement(carte);
						}
					}
					
				}
				
				//Gère les boutons activer et désactiver
				if(local.isActive()){
					fenetre.getBtnActiver().setEnabled(false);
					fenetre.getBtnDsactiver().setEnabled(true);
				}
				else{
					fenetre.getBtnActiver().setEnabled(true);
					fenetre.getBtnDsactiver().setEnabled(false);
				}
			break;
		case SSalle :
				
				changerBoutonsPhysique("Salle");
				
				//remplit les autres listes en fonction de l'élément
				Salle salle = (Salle) fenetre.getListeSalles().get(fenetre.getList_salles().getSelectedIndex());
				
				fenetre.getListeOrdinateurs().clear();
				fenetre.getListeCarteReseaux().clear();
				
				for(Ordinateur ordinateur : salle.getListeOrdinateur()){
					fenetre.getListeOrdinateurs().addElement(ordinateur);
					
					for(CarteReseau carte : ordinateur.getListeCarteReseau()){
						fenetre.getListeCarteReseaux().addElement(carte);
					}
				}
				
				if(salle.isActive()){
					fenetre.getBtnActiver().setEnabled(false);
					fenetre.getBtnDsactiver().setEnabled(true);
				}
				else{
					fenetre.getBtnActiver().setEnabled(true);
					fenetre.getBtnDsactiver().setEnabled(false);
				}
				
			break;
		case SOrdinateurPhysique :
					
				changerBoutonsPhysique("Ordinateur");
					
				//remplit les autres listes en fonction de l'élément
				Ordinateur ordinateur = (Ordinateur) fenetre.getListeOrdinateurs().get(fenetre.getList_ordinateurs_physique().getSelectedIndex());
				
				fenetre.getListeCarteReseaux().clear();
				
				for(CarteReseau carte : ordinateur.getListeCarteReseau()){
					fenetre.getListeCarteReseaux().addElement(carte);
				}
			
				if(ordinateur.isActive()){
					fenetre.getBtnActiver().setEnabled(false);
					fenetre.getBtnDsactiver().setEnabled(true);
				}
				else{
					fenetre.getBtnActiver().setEnabled(true);
					fenetre.getBtnDsactiver().setEnabled(false);
				}
				
			break;
		case SCarteReseauPhysique :
			changerBoutonsPhysique("Carte Res");
			
			CarteReseau carte = (CarteReseau) fenetre.getListeCarteReseaux().get(fenetre.getList_cartes_reseaux().getSelectedIndex());
			
			if(carte.isActive()){
				fenetre.getBtnActiver().setEnabled(false);
				fenetre.getBtnDsactiver().setEnabled(true);
			}
			else{
				fenetre.getBtnActiver().setEnabled(true);
				fenetre.getBtnDsactiver().setEnabled(false);
			}
			
			break;
		case SRouteur :
				changerBoutonsLogique("Routeur");
				
				//remplit les autres listes en fonction de l'élément
				Routeur routeur = (Routeur) fenetre.getListeRouteurs().get(fenetre.getList_routeurs().getSelectedIndex());
				listeSwitchs = routeur.getListeSwitch();
				fenetre.getListeSwitchs().clear();
				fenetre.getListeOrdinateurs2().clear();
				fenetre.getListeCarteReseaux2().clear();
				
				for(Switch switchR : listeSwitchs){
					fenetre.getListeSwitchs().addElement(switchR);
					
					for(Ordinateur ordinateur0 : switchR.getListeOrdinateur()){
						fenetre.getListeOrdinateurs2().addElement(ordinateur0);
						
						for(CarteReseau carteR : ordinateur0.getListeCarteReseau()){
							fenetre.getListeCarteReseaux2().addElement(carteR);
						}
					}
					
				}
				
				if(routeur.isActive()){
					fenetre.getBtnActiver_1().setEnabled(false);
					fenetre.getBtnDsactiver_1().setEnabled(true);
				}
				else{
					fenetre.getBtnActiver_1().setEnabled(true);
					fenetre.getBtnDsactiver_1().setEnabled(false);
				}
			
			break;
		case SSwitch :
				changerBoutonsLogique("Switch");
				
				//remplit les autres listes en fonction de l'élément
				Switch switchR = (Switch) fenetre.getListeSwitchs().get(fenetre.getList_switchs().getSelectedIndex());
				listeOrdinateurs = switchR.getListeOrdinateur();
				fenetre.getListeOrdinateurs2().clear();
				fenetre.getListeCarteReseaux2().clear();
				
				for(Ordinateur ordinateur1 : switchR.getListeOrdinateur()){
					fenetre.getListeOrdinateurs2().addElement(ordinateur1);
					
					for(CarteReseau carte1 : ordinateur1.getListeCarteReseau()){
						fenetre.getListeCarteReseaux2().addElement(carte1);
					}
				}
				
				if(switchR.isActive()){
					fenetre.getBtnActiver_1().setEnabled(false);
					fenetre.getBtnDsactiver_1().setEnabled(true);
				}
				else{
					fenetre.getBtnActiver_1().setEnabled(true);
					fenetre.getBtnDsactiver_1().setEnabled(false);
				}
			
			break;
		case SOrdinateurLogique :
				changerBoutonsLogique("Ordinateur");
				
				//remplit les autres listes en fonction de l'élément
				Ordinateur ordinateur2 = (Ordinateur) fenetre.getListeOrdinateurs2().get(fenetre.getList_ordinateurs_logique().getSelectedIndex());
				
				fenetre.getListeCarteReseaux2().clear();
				
				for(CarteReseau carte2 : ordinateur2.getListeCarteReseau()){
					fenetre.getListeCarteReseaux2().addElement(carte2);
				}
				
				if(ordinateur2.isActive()){
					fenetre.getBtnActiver_1().setEnabled(false);
					fenetre.getBtnDsactiver_1().setEnabled(true);
				}
				else{
					fenetre.getBtnActiver_1().setEnabled(true);
					fenetre.getBtnDsactiver_1().setEnabled(false);
				}
			
			break;
		case SCarteReseauLogique :
			changerBoutonsLogique("Carte Res");
			
			CarteReseau carte3 = (CarteReseau) fenetre.getListeCarteReseaux2().get(fenetre.getList_cartes_reseaux_logique().getSelectedIndex());
			
			if(carte3.isActive()){
				fenetre.getBtnActiver_1().setEnabled(false);
				fenetre.getBtnDsactiver_1().setEnabled(true);
			}
			else{
				fenetre.getBtnActiver_1().setEnabled(true);
				fenetre.getBtnDsactiver_1().setEnabled(false);
			}
			
			break;
			
		}
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
	
}
