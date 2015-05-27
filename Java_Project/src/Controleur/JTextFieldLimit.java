package Controleur;

import javax.print.attribute.AttributeSet;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import Vue.AjouterCarteReseau;

public class JTextFieldLimit implements DocumentListener {
  private int limite = 2;
  private int numeroTexteField;
  private AjouterCarteReseau fenetre;
  
	private static final int Texte1 = 1;
	private static final int Texte2 = 2;
	private static final int Texte3 = 3;
	private static final int Texte4 = 4;
	private static final int Texte5 = 5;

  public JTextFieldLimit(AjouterCarteReseau fenetre, int numeroTexteField) {
	  super();
	  this. numeroTexteField = numeroTexteField;
	  this.fenetre = fenetre;
   }

@Override
public void insertUpdate(DocumentEvent e) {
	switch(numeroTexteField){
	case Texte1:
		if(fenetre.getTextField_mac1().getText().length() > 2){
			try {
				fenetre.getTextField_mac1().setText(fenetre.getTextField_mac1().getText(0, 2));
			} catch (BadLocationException e1) {
			}
		}
		break;
		
	case Texte2:
		if(fenetre.getTextField_mac2().getText().length() > 2){
			try {
				fenetre.getTextField_mac2().setText(fenetre.getTextField_mac2().getText(0, 2));
			} catch (BadLocationException e1) {
			}
		}
		break;
		
	case Texte3:
		if(fenetre.getTextField_mac3().getText().length() > 2){
			try {
				fenetre.getTextField_mac3().setText(fenetre.getTextField_mac3().getText(0, 2));
			} catch (BadLocationException e1) {
			}
		}
		break;
		
	case Texte4:
		if(fenetre.getTextField_mac4().getText().length() > 2){
			try {
				fenetre.getTextField_mac4().setText(fenetre.getTextField_mac4().getText(0, 2));
			} catch (BadLocationException e1) {
			}
		}
		break;
		
	case Texte5:
		if(fenetre.getTextField_mac5().getText().length() > 2){
			try {
				fenetre.getTextField_mac5().setText(fenetre.getTextField_mac5().getText(0, 2));
			} catch (BadLocationException e1) {
				break;
			}
		}
		break;
	}
	
}

@Override
public void removeUpdate(DocumentEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void changedUpdate(DocumentEvent e) {
	// TODO Auto-generated method stub
	
}
  
  
}