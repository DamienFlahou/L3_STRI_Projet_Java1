package Controleur;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.border.Border;
import javax.swing.text.BadLocationException;

import Model.CarteReseau;
import Model.Ordinateur;
import Model.Routeur;
import Model.Salle;
import Model.Switch;
import Vue.AjouterCarteReseau;
import Vue.AjouterOrdinateur;

public class ControleurAjouterCarteReseau implements MouseListener{

	AjouterCarteReseau fenetre;
	int numeroBouton;
	
	private static final int BValider = 1;
	private static final int BAnnuler = 2;
	
	public ControleurAjouterCarteReseau(AjouterCarteReseau _fenetre, int _numeroBouton){
			fenetre = _fenetre;
			numeroBouton = _numeroBouton;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		boolean OrdinateurExist = false;
		Border border = BorderFactory.createLineBorder(Color.red);
		int i;
		
		switch(numeroBouton){
		case BAnnuler:
			fenetre.setVisible(false);
			fenetre.dispose();
			break;

		case BValider:

			try{
				fenetre.getTextField_mac1().getText(1, 1);
			} catch (BadLocationException e1) {
				Border border1 = BorderFactory.createLineBorder(Color.green);
				fenetre.getTextField_mac1().setBorder(border1);
				fenetre.getTextField_mac2().setBorder(border1);
				fenetre.getTextField_mac3().setBorder(border1);
				fenetre.getTextField_mac4().setBorder(border1);
				fenetre.getTextField_mac5().setBorder(border1);
				fenetre.getTextField_mac6().setBorder(border1);
				break;
			}
			try{
				fenetre.getTextField_mac2().getText(1, 1);
			} catch (BadLocationException e1) {
				Border border1 = BorderFactory.createLineBorder(Color.green);
				fenetre.getTextField_mac1().setBorder(border1);
				fenetre.getTextField_mac2().setBorder(border1);
				fenetre.getTextField_mac3().setBorder(border1);
				fenetre.getTextField_mac4().setBorder(border1);
				fenetre.getTextField_mac5().setBorder(border1);
				fenetre.getTextField_mac6().setBorder(border1);
				break;
			}
			try{
				fenetre.getTextField_mac3().getText(1, 1);
			} catch (BadLocationException e1) {
				Border border1 = BorderFactory.createLineBorder(Color.green);
				fenetre.getTextField_mac1().setBorder(border1);
				fenetre.getTextField_mac2().setBorder(border1);
				fenetre.getTextField_mac3().setBorder(border1);
				fenetre.getTextField_mac4().setBorder(border1);
				fenetre.getTextField_mac5().setBorder(border1);
				fenetre.getTextField_mac6().setBorder(border1);
				break;
			}
			try{
				fenetre.getTextField_mac4().getText(1, 1);
			} catch (BadLocationException e1) {
				Border border1 = BorderFactory.createLineBorder(Color.green);
				fenetre.getTextField_mac1().setBorder(border1);
				fenetre.getTextField_mac2().setBorder(border1);
				fenetre.getTextField_mac3().setBorder(border1);
				fenetre.getTextField_mac4().setBorder(border1);
				fenetre.getTextField_mac5().setBorder(border1);
				fenetre.getTextField_mac6().setBorder(border1);
				break;
			}
			try{
				fenetre.getTextField_mac5().getText(1, 1);
			} catch (BadLocationException e1) {
				Border border1 = BorderFactory.createLineBorder(Color.green);
				fenetre.getTextField_mac1().setBorder(border1);
				fenetre.getTextField_mac2().setBorder(border1);
				fenetre.getTextField_mac3().setBorder(border1);
				fenetre.getTextField_mac4().setBorder(border1);
				fenetre.getTextField_mac5().setBorder(border1);
				fenetre.getTextField_mac6().setBorder(border1);
				break;
			}
			try{
				fenetre.getTextField_mac6().getText(1, 1);
			} catch (BadLocationException e1) {
				Border border1 = BorderFactory.createLineBorder(Color.green);
				fenetre.getTextField_mac1().setBorder(border1);
				fenetre.getTextField_mac2().setBorder(border1);
				fenetre.getTextField_mac3().setBorder(border1);
				fenetre.getTextField_mac4().setBorder(border1);
				fenetre.getTextField_mac5().setBorder(border1);
				fenetre.getTextField_mac6().setBorder(border1);
				break;
			}
			String texte = fenetre.getTextField_mac1().getText() + ":" + fenetre.getTextField_mac2().getText() + ":" + fenetre.getTextField_mac3().getText() + ":" + fenetre.getTextField_mac4().getText() + ":" + fenetre.getTextField_mac5().getText() + ":" + fenetre.getTextField_mac6().getText();
			
			DefaultListModel<CarteReseau> listeCarteReseau = fenetre.getApplicationPrincipale().getListeCarteReseaux();
			for(i = 0; i < listeCarteReseau.size(); i++){
				if(listeCarteReseau.get(i).getAdresseMac().equals(texte)){
					OrdinateurExist = true;
				}
			}
			
			if(OrdinateurExist){
				fenetre.getTextField_mac1().setBorder(border);
				fenetre.getTextField_mac2().setBorder(border);
				fenetre.getTextField_mac3().setBorder(border);
				fenetre.getTextField_mac4().setBorder(border);
				fenetre.getTextField_mac5().setBorder(border);
				fenetre.getTextField_mac6().setBorder(border);
			}
			else{
				
				if(fenetre.getComboBox_Ordinateur().getSelectedIndex() == 0){
					for(i =0; i < fenetre.getApplicationPrincipale().getReseauPhysique().size(); i++){
						ArrayList<Routeur> listeRouteur = fenetre.getApplicationPrincipale().getReseauPhysique().get(i).getListeRouteur();
						for(int j = 0; j < listeRouteur.size();j++){
							Routeur routeur = (Routeur) fenetre.getApplicationPrincipale().getListeRouteurs().get(fenetre.getComboBox_Routeur().getSelectedIndex());
							if(listeRouteur.get(j).getNomRouteur().equals(routeur.getNomRouteur())){
								fenetre.getApplicationPrincipale().getReseauPhysique().get(i).getListeRouteur().get(j).AjouterCarteReseau(texte);
							}
						}
					}
				}
				else{
					//Par le réseau physique
					
					DebutBoucle:
						for(i = 0; i < fenetre.getApplicationPrincipale().getReseauPhysique().size(); i++){
							ArrayList<Salle> listeSalle = fenetre.getApplicationPrincipale().getReseauPhysique().get(i).getListeSalle();
							for(int j = 0; j < listeSalle.size(); j++){
								ArrayList<Ordinateur> listeOrdinateurs = listeSalle.get(j).getListeOrdinateur();
								for(int k = 0; k < listeOrdinateurs.size(); k++){
									Ordinateur ordinateur = listeOrdinateurs.get(k);
									Ordinateur ordinateur2 = (Ordinateur) fenetre.getApplicationPrincipale().getListeOrdinateurs().get(fenetre.getComboBox_Ordinateur().getSelectedIndex());
									if(ordinateur.getNomOrdinateur().equals(ordinateur2.getNomOrdinateur())){
										fenetre.getApplicationPrincipale().getReseauPhysique().get(i).getListeSalle().get(j).getListeOrdinateur().get(k).AjouterCarteReseau(texte);
										break DebutBoucle;
									}
								}
							}
						}
				
				//Pour le réseau logique
				DebutBoucle:
					for(i = 0; i < fenetre.getApplicationPrincipale().getReseauPhysique().size(); i++){
						ArrayList<Routeur> listeRouteur = fenetre.getApplicationPrincipale().getReseauPhysique().get(i).getListeRouteur();
						for(int j = 0; j < listeRouteur.size(); j++){
							ArrayList<Switch> listeSwitch = listeRouteur.get(j).getListeSwitch();
							for(int k = 0; k < listeSwitch.size(); k++){
								ArrayList<Ordinateur> listeOrdinateur = listeSwitch.get(k).getListeOrdinateur();
								for(int l = 0; l < listeOrdinateur.size(); l++){
									Ordinateur ordinateur = listeOrdinateur.get(l);
									Ordinateur ordinateur2 = (Ordinateur) fenetre.getApplicationPrincipale().getListeOrdinateurs().get(fenetre.getComboBox_Ordinateur().getSelectedIndex());
									if(ordinateur.getNomOrdinateur().equals(ordinateur2.getNomOrdinateur())){
										fenetre.getApplicationPrincipale().getReseauPhysique().get(i).getListeRouteur().get(j).getListeSwitch().get(k).getListeOrdinateur().get(l).AjouterCarteReseau(texte);
										break DebutBoucle;
									}
								}
								
							}
						}
					}
				}
				
				fenetre.getApplicationPrincipale().miseAJourListes();
				fenetre.setVisible(false);
				fenetre.dispose();
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
