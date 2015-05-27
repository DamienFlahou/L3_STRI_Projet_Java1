package Vue;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import Model.CarteReseau;
import Model.Local;
import Model.Ordinateur;
import Model.Routeur;
import Model.Salle;
import Model.Switch;

public class ListCellActive extends JLabel implements ListCellRenderer {
	
	private ApplicationWindows fenetre;
	private int numeroListe;
	
	public static final int SLocal = 1;
	public static final int SSalle = 2;
	public static final int SOrdinateurPhysique = 3;
	public static final int SCarteReseauPhysique = 4;
	public static final int SRouteur = 5;
	public static final int SSwitch = 6;
	public static final int SOrdinateurLogique = 7;
	public static final int SCarteReseauLogique = 8;
	
    public ListCellActive(ApplicationWindows fenetre, int numeroListe) {
    	this.fenetre = fenetre;
    	this.numeroListe = numeroListe;
        setOpaque(true);
    }
    
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        setText(value.toString());
        
        switch(numeroListe){
        case SLocal:
        	Local local = (Local) fenetre.getListeLocaux().get(index);
        	if(local.isActive()){
        		setBackground(Color.GREEN);
        	}
        	else{
        		setBackground(Color.RED);
        	}
        	break;
        case SSalle:
        	Salle salle = (Salle) fenetre.getListeSalles().get(index);
        	if(salle.isActive()){
        		setBackground(Color.GREEN);
        	}
        	else{
        		setBackground(Color.RED);
        	}
        	break;
    	case SOrdinateurPhysique:
    		Ordinateur ordinateur = (Ordinateur) fenetre.getListeOrdinateurs().get(index);
        	if(ordinateur.isActive()){
        		setBackground(Color.GREEN);
        	}
        	else{
        		setBackground(Color.RED);
        	}
        	break;
    	case SCarteReseauPhysique:
    		CarteReseau carte = (CarteReseau) fenetre.getListeCarteReseaux().get(index);
        	if(carte.isActive()){
        		setBackground(Color.GREEN);
        	}
        	else{
        		setBackground(Color.RED);
        	}
        	break;
    	case SRouteur:
    		Routeur routeur = (Routeur) fenetre.getListeRouteurs().get(index);
        	if(routeur.isActive()){
        		setBackground(Color.GREEN);
        	}
        	else{
        		setBackground(Color.RED);
        	}
        	break;
    	case SSwitch:
    		Switch switchR = (Switch) fenetre.getListeSwitchs().get(index);
        	if(switchR.isActive()){
        		setBackground(Color.GREEN);
        	}
        	else{
        		setBackground(Color.RED);
        	}
        	break;
    	case SOrdinateurLogique:
    		Ordinateur ordinateur2 = (Ordinateur) fenetre.getListeOrdinateurs2().get(index);
        	if(ordinateur2.isActive()){
        		setBackground(Color.GREEN);
        	}
        	else{
        		setBackground(Color.RED);
        	}
        	break;
    	case SCarteReseauLogique:
    		CarteReseau carte2 = (CarteReseau) fenetre.getListeCarteReseaux2().get(index);
        	if(carte2.isActive()){
        		setBackground(Color.GREEN);
        	}
        	else{
        		setBackground(Color.RED);
        	}
        	break;
        }

        return this;
    }
}
