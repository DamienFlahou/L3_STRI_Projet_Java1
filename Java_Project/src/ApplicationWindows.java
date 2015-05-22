import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JSeparator;
import java.awt.Font;


public class ApplicationWindows {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationWindows window = new ApplicationWindows();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ApplicationWindows() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 663, 336);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel R�seau_physique = new JPanel();
		tabbedPane.addTab("R\u00E9seau physique", null, R�seau_physique, null);
		R�seau_physique.setLayout(null);
		
		JLabel lblCartesR�seauxP = new JLabel("Cartes r\u00E9seaux");
		lblCartesR�seauxP.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblCartesR�seauxP.setForeground(Color.BLACK);
		lblCartesR�seauxP.setHorizontalAlignment(SwingConstants.CENTER);
		lblCartesR�seauxP.setBounds(450, 33, 135, 23);
		R�seau_physique.add(lblCartesR�seauxP);
		
		JLabel lblOrdinateursP = new JLabel("Ordinateurs");
		lblOrdinateursP.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblOrdinateursP.setForeground(Color.BLACK);
		lblOrdinateursP.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrdinateursP.setBounds(316, 33, 135, 23);
		R�seau_physique.add(lblOrdinateursP);
		
		JLabel lblSalles = new JLabel("Salles");
		lblSalles.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblSalles.setForeground(Color.BLACK);
		lblSalles.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalles.setBounds(182, 33, 135, 23);
		R�seau_physique.add(lblSalles);
		
		JLabel lblLocaux = new JLabel("Locaux");
		lblLocaux.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblLocaux.setForeground(Color.BLACK);
		lblLocaux.setBackground(Color.WHITE);
		lblLocaux.setHorizontalAlignment(SwingConstants.CENTER);
		lblLocaux.setBounds(48, 33, 135, 23);
		R�seau_physique.add(lblLocaux);
		
		JList list_locaux = new JList();
		list_locaux.setBorder(new LineBorder(new Color(0, 0, 0)));
		list_locaux.setToolTipText("");
		list_locaux.setBounds(48, 54, 135, 157);
		R�seau_physique.add(list_locaux);
		
		JList list_salles = new JList();
		list_salles.setBorder(new LineBorder(new Color(0, 0, 0)));
		list_salles.setBounds(182, 54, 135, 157);
		R�seau_physique.add(list_salles);
		
		JList list_ordinateurs_physique = new JList();
		list_ordinateurs_physique.setBorder(new LineBorder(new Color(0, 0, 0)));
		list_ordinateurs_physique.setBounds(316, 54, 135, 157);
		R�seau_physique.add(list_ordinateurs_physique);
		
		JList list_cartes_r�seaux = new JList();
		list_cartes_r�seaux.setBorder(new LineBorder(new Color(0, 0, 0)));
		list_cartes_r�seaux.setBounds(450, 54, 135, 157);
		R�seau_physique.add(list_cartes_r�seaux);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAjouter.setBounds(30, 222, 89, 23);
		R�seau_physique.add(btnAjouter);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnSupprimer.setBounds(228, 222, 89, 23);
		R�seau_physique.add(btnSupprimer);
		
		JButton btnMiseJour = new JButton("Mise \u00E0 jour");
		btnMiseJour.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnMiseJour.setBounds(327, 222, 89, 23);
		R�seau_physique.add(btnMiseJour);
		
		JButton btnActiver = new JButton("Activer");
		btnActiver.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnActiver.setBounds(426, 222, 89, 23);
		R�seau_physique.add(btnActiver);
		
		JButton btnDsactiver = new JButton("D\u00E9sactiver");
		btnDsactiver.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnDsactiver.setBounds(525, 222, 89, 23);
		R�seau_physique.add(btnDsactiver);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnModifier.setBounds(129, 222, 89, 23);
		R�seau_physique.add(btnModifier);
		
		JPanel R�seau_logique = new JPanel();
		tabbedPane.addTab("R\u00E9seau logique", null, R�seau_logique, null);
		R�seau_logique.setLayout(null);
		
		JLabel lblCartesReseauxL = new JLabel("Cartes r\u00E9seaux");
		lblCartesReseauxL.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblCartesReseauxL.setForeground(Color.BLACK);
		lblCartesReseauxL.setHorizontalAlignment(SwingConstants.CENTER);
		lblCartesReseauxL.setBounds(450, 33, 135, 23);
		R�seau_logique.add(lblCartesReseauxL);
		
		JLabel lblOrdinateursL = new JLabel("Ordinateurs");
		lblOrdinateursL.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblOrdinateursL.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrdinateursL.setForeground(Color.BLACK);
		lblOrdinateursL.setBounds(316, 33, 135, 23);
		R�seau_logique.add(lblOrdinateursL);
		
		JLabel lblNewLabel = new JLabel("Switchs");
		lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(182, 33, 135, 23);
		R�seau_logique.add(lblNewLabel);
		
		JLabel lblRouteurs = new JLabel("Routeurs");
		lblRouteurs.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblRouteurs.setForeground(Color.BLACK);
		lblRouteurs.setHorizontalAlignment(SwingConstants.CENTER);
		lblRouteurs.setBounds(48, 33, 135, 23);
		R�seau_logique.add(lblRouteurs);
		
		JList list_routeurs = new JList();
		list_routeurs.setBorder(new LineBorder(new Color(0, 0, 0)));
		list_routeurs.setBounds(48, 54, 135, 157);
		R�seau_logique.add(list_routeurs);
		
		JList list_switchs = new JList();
		list_switchs.setBorder(new LineBorder(new Color(0, 0, 0)));
		list_switchs.setBounds(182, 54, 135, 157);
		R�seau_logique.add(list_switchs);
		
		JList list_ordinateurs_logique = new JList();
		list_ordinateurs_logique.setBorder(new LineBorder(new Color(0, 0, 0)));
		list_ordinateurs_logique.setBounds(316, 54, 135, 157);
		R�seau_logique.add(list_ordinateurs_logique);
		
		JList list_cartes_r�seaux_logique = new JList();
		list_cartes_r�seaux_logique.setBorder(new LineBorder(new Color(0, 0, 0)));
		list_cartes_r�seaux_logique.setBounds(450, 54, 135, 157);
		R�seau_logique.add(list_cartes_r�seaux_logique);
		
		JButton btnAjouter_1 = new JButton("Ajouter");
		btnAjouter_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnAjouter_1.setBounds(30, 222, 89, 23);
		R�seau_logique.add(btnAjouter_1);
		
		JButton btnModifier_1 = new JButton("Modifier");
		btnModifier_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnModifier_1.setBounds(129, 222, 89, 23);
		R�seau_logique.add(btnModifier_1);
		
		JButton btnSupprimer_1 = new JButton("Supprimer");
		btnSupprimer_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnSupprimer_1.setBounds(228, 222, 89, 23);
		R�seau_logique.add(btnSupprimer_1);
		
		JButton btnMiseJour_1 = new JButton("Mise \u00E0 jour");
		btnMiseJour_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnMiseJour_1.setBounds(327, 222, 89, 23);
		R�seau_logique.add(btnMiseJour_1);
		
		JButton btnActiver_1 = new JButton("Activer");
		btnActiver_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnActiver_1.setBounds(426, 222, 89, 23);
		R�seau_logique.add(btnActiver_1);
		
		JButton btnDsactiver_1 = new JButton("D\u00E9sactiver");
		btnDsactiver_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnDsactiver_1.setBounds(525, 222, 89, 23);
		R�seau_logique.add(btnDsactiver_1);
	}
}