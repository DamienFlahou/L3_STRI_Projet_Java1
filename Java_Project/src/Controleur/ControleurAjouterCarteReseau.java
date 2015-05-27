package Controleur;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.border.Border;
import javax.swing.text.BadLocationException;

import Model.CarteReseau;
import Model.Ordinateur;
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
				break;
			}
			try{
				fenetre.getTextField_mac2().getText(1, 1);
			} catch (BadLocationException e1) {
				Border border1 = BorderFactory.createLineBorder(Color.green);
				fenetre.getTextField_mac2().setBorder(border1);
				break;
			}
			try{
				fenetre.getTextField_mac3().getText(1, 1);
			} catch (BadLocationException e1) {
				Border border1 = BorderFactory.createLineBorder(Color.green);
				fenetre.getTextField_mac3().setBorder(border1);
				break;
			}
			try{
				fenetre.getTextField_mac4().getText(1, 1);
			} catch (BadLocationException e1) {
				Border border1 = BorderFactory.createLineBorder(Color.green);
				fenetre.getTextField_mac4().setBorder(border1);
				break;
			}
			try{
				fenetre.getTextField_mac5().getText(1, 1);
			} catch (BadLocationException e1) {
				Border border1 = BorderFactory.createLineBorder(Color.green);
				fenetre.getTextField_mac5().setBorder(border1);
				break;
			}
			try{
				fenetre.getTextField_mac6().getText(1, 1);
			} catch (BadLocationException e1) {
				Border border1 = BorderFactory.createLineBorder(Color.green);
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
				
				//fenetre.getApplicationPrincipale().getReseauPhysique().get(fenetre.getComboBox().getSelectedIndex()).getListeSalle().get(fenetre.getComboBox_1().getSelectedIndex()).AjouterOrdinateur(texte);
				
				//Ajout réseau logique
				try{
				//fenetre.getApplicationPrincipale().getReseauPhysique().get(fenetre.getComboBox().getSelectedIndex()).getListeSwitch().get(fenetre.getComboBox_2().getSelectedIndex()).AjouterOrdinateur(texte);
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
