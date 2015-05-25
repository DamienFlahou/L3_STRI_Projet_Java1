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
			
			fenetre.setFocusList(numeroListe);
			
			switch(numeroListe){
			case SLocal :
				changerBoutonsPhysique("Local");
				fenetre.getList_salles().clearSelection();
				fenetre.getList_ordinateurs_physique().clearSelection();
				fenetre.getList_cartes_reseaux().clearSelection();
				break;
			case SSalle :
				changerBoutonsPhysique("Salle");
				fenetre.getList_ordinateurs_physique().clearSelection();
				fenetre.getList_cartes_reseaux().clearSelection();
				break;
			case SOrdinateurPhysique :
				changerBoutonsPhysique("Ordinateur");
				fenetre.getList_cartes_reseaux().clearSelection();
				break;
			case SCarteReseauPhysique :
				changerBoutonsPhysique("Carte Res");
				break;
			case SRouteur :
				changerBoutonsLogique("Routeur");
				fenetre.getList_switchs().clearSelection();
				fenetre.getList_ordinateurs_logique().clearSelection();
				fenetre.getList_cartes_reseaux_logique().clearSelection();
				break;
			case SSwitch :
				changerBoutonsLogique("Switch");
				fenetre.getList_ordinateurs_logique().clearSelection();
				fenetre.getList_cartes_reseaux_logique().clearSelection();
				break;
			case SOrdinateurLogique :
				changerBoutonsLogique("Ordinateur");
				fenetre.getList_cartes_reseaux_logique().clearSelection();
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
