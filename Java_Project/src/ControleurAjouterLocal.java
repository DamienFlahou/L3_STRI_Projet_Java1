import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.border.Border;
import javax.swing.text.BadLocationException;


public class ControleurAjouterLocal implements MouseListener{

	private AjouterLocal fenetre;
	private int numeroBouton;
	
	private static final int BValider = 2;
	private static final int BAnnuler = 3;
	
	public ControleurAjouterLocal(AjouterLocal _fenetre, int _numeroBouton) {
		fenetre = _fenetre;
		numeroBouton = _numeroBouton;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		boolean localexist = false;
		
		switch(numeroBouton){
		case BAnnuler:
			fenetre.setVisible(false);
			fenetre.dispose();
			break;
			
		case BValider:

				try{
					fenetre.getTextField_nom().getText(1, 1);
				} catch (BadLocationException e1) {
					Border border = BorderFactory.createLineBorder(Color.green);
					fenetre.getTextField_nom().setBorder(border);
					break;
				}
				String texte = fenetre.getTextField_nom().getText();
				
				DefaultListModel listeLocal = fenetre.getApplicationPrincipale().getListeLocaux();
				for(int i = 0; i < listeLocal.size(); i++){
					if(texte.equals(listeLocal.getElementAt(i).toString())){
						localexist = true;
					}
				}
				if(localexist){
					Border border = BorderFactory.createLineBorder(Color.red);
					fenetre.getTextField_nom().setBorder(border);
				}
				else{
					fenetre.getApplicationPrincipale().getListeLocaux().addElement(new Local(texte));
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
