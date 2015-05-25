import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class ControleurSelectionListe implements ListSelectionListener{
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
	
	public ControleurSelectionListe(ApplicationWindows _fenetre, int numListe){
		fenetre = _fenetre;
		numeroListe = numListe;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		
		if(fenetre.getFocusList() != numeroListe){
			switch(fenetre.getFocusList()){
			case SLocal :
				fenetre.getList_locaux().clearSelection();
				break;
			case SSalle :
				fenetre.getList_salles().clearSelection();
				break;
			case SOrdinateurPhysique :
				fenetre.getList_ordinateurs_physique().clearSelection();
				break;
			case SCarteReseauPhysique :
				fenetre.getList_cartes_reseaux().clearSelection();
				break;
			case SRouteur :
				fenetre.getList_routeurs().clearSelection();
				break;
			case SSwitch :
				fenetre.getList_switchs().clearSelection();
				break;
			case SOrdinateurLogique :
				fenetre.getList_ordinateurs_logique().clearSelection();
				break;
			case SCarteReseauLogique : 
				fenetre.getList_cartes_reseaux_logique().clearSelection();
				break;
			}
			
			fenetre.setFocusList(numeroListe);
			
			switch(numeroListe){
			case SLocal :
				changerBoutonsPhysique("Local");
				break;
			case SSalle :
				changerBoutonsPhysique("Salle");
				break;
			case SOrdinateurPhysique :
				changerBoutonsPhysique("Ordinateur");
				break;
			case SCarteReseauPhysique :
				changerBoutonsPhysique("Carte Res");
				break;
			case SRouteur :
				changerBoutonsLogique("Routeur");
				break;
			case SSwitch :
				changerBoutonsLogique("Switch");
				break;
			case SOrdinateurLogique :
				changerBoutonsLogique("Ordinateur");
				break;
			case SCarteReseauLogique :
				changerBoutonsLogique("Carte Res");
				break;
				
			}

		}
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
	
}
