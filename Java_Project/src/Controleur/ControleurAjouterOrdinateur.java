package Controleur;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.border.Border;
import javax.swing.text.BadLocationException;

import Model.Local;
import Model.Ordinateur;
import Model.Routeur;
import Model.Salle;
import Model.Switch;
import Vue.AjouterOrdinateur;
import Vue.AjouterSalle;

public class ControleurAjouterOrdinateur implements MouseListener{
	
	AjouterOrdinateur fenetre;
	int numeroBouton;
	
	private static final int BValider = 1;
	private static final int BAnnuler = 2;
	
	public ControleurAjouterOrdinateur(AjouterOrdinateur _fenetre, int _numeroBouton){
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
				fenetre.getTextField_nom().getText(1, 1);
			} catch (BadLocationException e1) {
				Border border1 = BorderFactory.createLineBorder(Color.green);
				fenetre.getTextField_nom().setBorder(border1);
				break;
			}
			String texte = fenetre.getTextField_nom().getText();
			
			DefaultListModel<Ordinateur> listeOrdinateur = fenetre.getApplicationPrincipale().getListeOrdinateurs();
			for(i = 0; i < listeOrdinateur.size(); i++){
				if(listeOrdinateur.get(i).getNomOrdinateur().equals(texte)){
					OrdinateurExist = true;
				}
			}
			
			if(OrdinateurExist){
				fenetre.getTextField_nom().setBorder(border);
			}
			else{
				
				fenetre.getApplicationPrincipale().getReseauPhysique().get(fenetre.getComboBox().getSelectedIndex()).getListeSalle().get(fenetre.getComboBox_1().getSelectedIndex()).AjouterOrdinateur(texte);
				
				//Ajout réseau logique
				try{
				fenetre.getApplicationPrincipale().getReseauPhysique().get(fenetre.getComboBox().getSelectedIndex()).getListeSwitch().get(fenetre.getComboBox_2().getSelectedIndex()).AjouterOrdinateur(texte);
				}
				catch(Exception ex){
					
				}
				
				try{
					fenetre.getApplicationPrincipale().getReseauPhysique().get(fenetre.getComboBox().getSelectedIndex()).getListeSalle().get(fenetre.getComboBox_1().getSelectedIndex()).getListeSwitch().get(fenetre.getComboBox_2().getSelectedIndex()).AjouterOrdinateur(texte);
					}
					catch(Exception ex){
						
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
