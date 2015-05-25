import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ControleurBouton implements MouseListener{
	
	ApplicationWindows fenetre;
	int numeroBouton;
	
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
	
	
	public ControleurBouton(ApplicationWindows _fenetre, int _numeroBouton){
		fenetre = _fenetre;
		numeroBouton = _numeroBouton;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		switch(numeroBouton){
		case SBoutonAjouter:
			switch(fenetre.getFocusList()){
			case SLocal:
				AjouterLocal localWindow = new AjouterLocal(fenetre);
				localWindow.setVisible(true);
				break;
			case SSalle:
				
				break;
			case SOrdinateurPhysique:
				
				break;
			case SCarteReseauPhysique:
				
				break;
			case SRouteur:
				
				break;
			case SSwitch:
				
				break;
			case SOrdinateurLogique:
				
				break;
			case SCarteReseauLogique:
				
				break;
			}
			
			break;
		case SBoutonModifier:
			switch(fenetre.getFocusList()){
			case SLocal:
				
				break;
			case SSalle:
				
				break;
			case SOrdinateurPhysique:
				
				break;
			case SCarteReseauPhysique:
				
				break;
			case SRouteur:
				
				break;
			case SSwitch:
				
				break;
			case SOrdinateurLogique:
				
				break;
			case SCarteReseauLogique:
				
				break;
			}
			
			break;
			
		case SBoutonSupprimer:
			switch(fenetre.getFocusList()){
			case SLocal:
				
				break;
			case SSalle:
				
				break;
			case SOrdinateurPhysique:
				
				break;
			case SCarteReseauPhysique:
				
				break;
			case SRouteur:
				
				break;
			case SSwitch:
				
				break;
			case SOrdinateurLogique:
				
				break;
			case SCarteReseauLogique:
				
				break;
			}
			
			break;
			
		case SBoutonMiseJour:
			switch(fenetre.getFocusList()){
			case SLocal:
				
				break;
			case SSalle:
				
				break;
			case SOrdinateurPhysique:
				
				break;
			case SCarteReseauPhysique:
				
				break;
			case SRouteur:
				
				break;
			case SSwitch:
				
				break;
			case SOrdinateurLogique:
				
				break;
			case SCarteReseauLogique:
				
				break;
			}
			
			break;
			
		case SBoutonActiver:
			switch(fenetre.getFocusList()){
			case SLocal:
				
				break;
			case SSalle:
				
				break;
			case SOrdinateurPhysique:
				
				break;
			case SCarteReseauPhysique:
				
				break;
			case SRouteur:
				
				break;
			case SSwitch:
				
				break;
			case SOrdinateurLogique:
				
				break;
			case SCarteReseauLogique:
				
				break;
			}
			
			break;
			
		case SBoutonDsActiver:
			switch(fenetre.getFocusList()){
			case SLocal:
				
				break;
			case SSalle:
				
				break;
			case SOrdinateurPhysique:
				
				break;
			case SCarteReseauPhysique:
				
				break;
			case SRouteur:
				
				break;
			case SSwitch:
				
				break;
			case SOrdinateurLogique:
				
				break;
			case SCarteReseauLogique:
				
				break;
			}
			
			break;
		case SBoutonAjouter_1:
			switch(fenetre.getFocusList()){
			case SLocal:
				
				break;
			case SSalle:
				
				break;
			case SOrdinateurPhysique:
				
				break;
			case SCarteReseauPhysique:
				
				break;
			case SRouteur:
				
				break;
			case SSwitch:
				
				break;
			case SOrdinateurLogique:
				
				break;
			case SCarteReseauLogique:
				
				break;
			}
			
			break;
			
		case SBoutonModifier_1:
			switch(fenetre.getFocusList()){
			case SLocal:
				
				break;
			case SSalle:
				
				break;
			case SOrdinateurPhysique:
				
				break;
			case SCarteReseauPhysique:
				
				break;
			case SRouteur:
				
				break;
			case SSwitch:
				
				break;
			case SOrdinateurLogique:
				
				break;
			case SCarteReseauLogique:
				
				break;
			}
			
			break;
			
		case SBoutonSupprimer_1:
			switch(fenetre.getFocusList()){
			case SLocal:
				
				break;
			case SSalle:
				
				break;
			case SOrdinateurPhysique:
				
				break;
			case SCarteReseauPhysique:
				
				break;
			case SRouteur:
				
				break;
			case SSwitch:
				
				break;
			case SOrdinateurLogique:
				
				break;
			case SCarteReseauLogique:
				
				break;
			}
			
			break;
			
		case SBoutonMiseJour_1:
			switch(fenetre.getFocusList()){
			case SLocal:
				
				break;
			case SSalle:
				
				break;
			case SOrdinateurPhysique:
				
				break;
			case SCarteReseauPhysique:
				
				break;
			case SRouteur:
				
				break;
			case SSwitch:
				
				break;
			case SOrdinateurLogique:
				
				break;
			case SCarteReseauLogique:
				
				break;
			}
			
			break;
			
		case SBoutonActiver_1:
			switch(fenetre.getFocusList()){
			case SLocal:
				
				break;
			case SSalle:
				
				break;
			case SOrdinateurPhysique:
				
				break;
			case SCarteReseauPhysique:
				
				break;
			case SRouteur:
				
				break;
			case SSwitch:
				
				break;
			case SOrdinateurLogique:
				
				break;
			case SCarteReseauLogique:
				
				break;
			}
			
			break;
			
		case SBoutonDsActiver_1:
			switch(fenetre.getFocusList()){
			case SLocal:
				
				break;
			case SSalle:
				
				break;
			case SOrdinateurPhysique:
				
				break;
			case SCarteReseauPhysique:
				
				break;
			case SRouteur:
				
				break;
			case SSwitch:
				
				break;
			case SOrdinateurLogique:
				
				break;
			case SCarteReseauLogique:
				
				break;
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
