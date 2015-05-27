package Vue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

import Controleur.ControleurAjouterLocal;


public class AjouterLocal extends JFrame implements MouseListener{

	private JTextField textField_nom;
	
	private JButton btnValider;
	private JButton btnAnnuler;
	
	private static final int BValider = 1;
	private static final int BAnnuler = 2;
	
	private ApplicationWindows applicationPrincipale;
	
	public JTextField getTextField_nom() {
		return textField_nom;
	}

	public ApplicationWindows getApplicationPrincipale() {
		return applicationPrincipale;
	}

	/**
	 * Create the application.
	 */
	public AjouterLocal(ApplicationWindows _fenetre) {
		applicationPrincipale = _fenetre;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		this.setTitle("Ajouter local");
		this.setBounds(60, 60, 372, 140);
		this.setLocationRelativeTo(applicationPrincipale);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setResizable(false);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setHorizontalAlignment(SwingConstants.CENTER);
		lblNom.setBounds(12, 12, 73, 25);
		this.getContentPane().add(lblNom);
		
		textField_nom = new JTextField();
		textField_nom.setBounds(103, 15, 221, 19);
		this.getContentPane().add(textField_nom);
		textField_nom.setColumns(10);
		
		btnValider = new JButton("Valider");
		btnValider.setBounds(124, 64, 89, 23);
		this.getContentPane().add(btnValider);
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(235, 64, 89, 23);
		this.getContentPane().add(btnAnnuler);
		
		btnValider.addMouseListener(new ControleurAjouterLocal(this, BValider));
		btnAnnuler.addMouseListener(new ControleurAjouterLocal(this, BAnnuler));
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
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
