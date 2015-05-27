package Controleur;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.border.Border;
import javax.swing.text.BadLocationException;

import Model.Local;
import Model.Routeur;
import Model.Salle;
import Model.Switch;
import Vue.AjouterSalle;

public class ControleurAjouterSalle implements MouseListener{
	
	AjouterSalle fenetre;
	int numeroBouton;
	
	private static final int BValider = 1;
	private static final int BAnnuler = 2;
	
	public ControleurAjouterSalle(AjouterSalle _listeSalle, int _numeroBouton) {
		fenetre = _listeSalle;
		numeroBouton = _numeroBouton;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		boolean salleexist = false;
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
				
				DefaultListModel listeSalle = fenetre.getApplicationPrincipale().getListeSalles();
				for(i = 0; i < listeSalle.size(); i++){
					if(texte.equals(listeSalle.getElementAt(i).toString())){
						salleexist = true;
					}
				}
				if(salleexist){
					fenetre.getTextField_nom().setBorder(border);
				}
				else{
					ArrayList<Local> listeLocal = fenetre.getApplicationPrincipale().getReseauPhysique();
					for(i = 0; i < listeLocal.size(); i++){
						if(listeLocal.get(i).getNomLocal().equals(fenetre.getComboBox_Local().getSelectedItem().toString())){
							listeLocal.get(i).AjouterSalle(new Salle(fenetre.getComboBox_Local().getSelectedItem().toString(), true));
						}
					}
					i--;
					ArrayList<Routeur> listeRouteur = listeLocal.get(i).getListeRouteur();
					if(fenetre.getComboBox_Routeur().getSelectedIndex() != 0){
						for(int j = 0; j < listeRouteur.size(); j++){
							if(listeRouteur.get(j).getNomRouteur().equals(fenetre.getComboBox_Routeur().toString())){
								listeRouteur.get(j).AjouterSalle(fenetre.getComboBox_Local().getSelectedItem().toString());
							}
						}
					}
					
					ArrayList<Switch> listeSwitch = listeLocal.get(i).getListeSwitch();
					if(fenetre.getComboBox_Switch().getSelectedIndex() != 0){
						for(int j = 0; j < listeRouteur.size(); j++){
							if(listeSwitch.get(j).getNomSwitch().equals(fenetre.getComboBox_Switch().toString())){
								listeSwitch.get(j).AjouterSalle(fenetre.getComboBox_Local().getSelectedItem().toString());
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
