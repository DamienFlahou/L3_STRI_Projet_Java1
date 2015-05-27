package Controleur;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Model.CarteReseau;
import Model.Local;
import Model.Ordinateur;
import Model.Routeur;
import Model.Salle;
import Model.Switch;
import Vue.AjouterCarteReseau;
import Vue.AjouterLocal;
import Vue.AjouterOrdinateur;
import Vue.AjouterSalle;
import Vue.ApplicationWindows;


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
		int position;
		
		switch(numeroBouton){
		case SBoutonAjouter:
			switch(fenetre.getFocusList()){
			case SLocal:
				AjouterLocal localWindow = new AjouterLocal(fenetre);
				localWindow.setVisible(true);
				break;
			case SSalle:
				AjouterSalle salleWindow = new AjouterSalle(fenetre);
				salleWindow.setVisible(true);
				break;
			case SOrdinateurPhysique:
				AjouterOrdinateur ordinateurWindow = new AjouterOrdinateur(fenetre);
				ordinateurWindow.setVisible(true);
				break;
			case SCarteReseauPhysique:
				AjouterCarteReseau carteWindow = new AjouterCarteReseau(fenetre);
				carteWindow.setVisible(true);
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
				int dialogResult = JOptionPane.showConfirmDialog (null, "Voulez-vous vraiment supprimer Le " + fenetre.getListeLocaux().get(fenetre.getList_locaux().getSelectedIndex()).toString(), "Confirmation", JOptionPane.YES_NO_OPTION);
				if(dialogResult == JOptionPane.YES_OPTION){
					fenetre.getReseauPhysique().remove(fenetre.getListeLocaux().get(fenetre.getList_locaux().getSelectedIndex()));
					fenetre.miseAJourListes();
				}
				break;
			case SSalle:
				position = fenetre.getList_salles().getSelectedIndex();
				dialogResult = JOptionPane.showConfirmDialog (null, "Voulez-vous vraiment supprimer La " + fenetre.getListeSalles().get(fenetre.getList_salles().getSelectedIndex()).toString(), "Confirmation", JOptionPane.YES_NO_OPTION);
				if(dialogResult == JOptionPane.YES_OPTION){
					//Supprime dans le réseau physique
					for(int i = 0; i < fenetre.getReseauPhysique().size(); i++){
						ArrayList<Salle> listeSalle = fenetre.getReseauPhysique().get(i).getListeSalle();
						if(listeSalle.contains(fenetre.getListeSalles().get(fenetre.getList_salles().getSelectedIndex()))){
							fenetre.getReseauPhysique().get(i).getListeSalle().remove(fenetre.getListeSalles().getElementAt(fenetre.getList_salles().getSelectedIndex()));
							break;
						}
					}
					DebutBoucle:
						//Supprime dans le réseau logique avec recherche dans les routeurs
						for(int i = 0; i < fenetre.getReseauPhysique().size(); i++){
							ArrayList<Routeur> listeRouteur = fenetre.getReseauPhysique().get(i).getListeRouteur();
							for(int j = 0; j < listeRouteur.size(); j++){
								if(listeRouteur.get(j).getListeSalle().contains(fenetre.getListeSalles().get(position))){
									fenetre.getReseauPhysique().get(i).getListeRouteur().get(j).getListeSalle().remove(fenetre.getListeSalles().get(fenetre.getList_salles().getSelectedIndex()));
									break DebutBoucle;
								}
							}
						}
					
					DebutBoucle2:
						//Supprime dans le réseau logique avec recherche dans les switchs
						for(int i = 0; i < fenetre.getReseauPhysique().size(); i++){
							ArrayList<Switch> listeSwitchs = fenetre.getReseauPhysique().get(i).getListeSwitch();
							for(int j = 0; j < listeSwitchs.size(); j++){
								if(listeSwitchs.get(j).getListeSalle().contains(fenetre.getListeSalles().get(fenetre.getList_salles().getSelectedIndex()))){
									fenetre.getReseauPhysique().get(i).getListeRouteur().get(j).getListeSalle().remove(fenetre.getListeSalles().getElementAt(fenetre.getList_salles().getSelectedIndex()));
									break DebutBoucle2;
								}
							}
						}
						fenetre.miseAJourListes();
				}
				break;
			case SOrdinateurPhysique:
				position = fenetre.getList_ordinateurs_physique().getSelectedIndex();
				dialogResult = JOptionPane.showConfirmDialog (null, "Voulez-vous vraiment supprimer L'" + fenetre.getListeOrdinateurs().get(fenetre.getList_ordinateurs_physique().getSelectedIndex()).toString(), "Confirmation", JOptionPane.YES_NO_OPTION);
				if(dialogResult == JOptionPane.YES_OPTION){
					
					//Supprime dans le réseau physique
					for(int i = 0; i < fenetre.getReseauPhysique().size(); i++){
						ArrayList<Salle> listeSalle = fenetre.getReseauPhysique().get(i).getListeSalle();
						position = fenetre.getList_ordinateurs_physique().getSelectedIndex();						for(int j = 0; j < listeSalle.size(); j++){
							if(listeSalle.get(j).getListeOrdinateur().contains(fenetre.getListeOrdinateurs().get(position))){
								fenetre.getReseauPhysique().get(i).getListeSalle().get(j).getListeOrdinateur().remove(fenetre.getListeOrdinateurs().getElementAt(position));
								break;
							}
						}
					}
					
					//Suppression dans les routeurs des locaux (par leurs switchs)
					DebutBoucle:
					for(int i = 0; i < fenetre.getReseauPhysique().size(); i++){
						ArrayList<Routeur> listeRouteur = fenetre.getReseauPhysique().get(i).getListeRouteur();
						for(int j = 0; j < listeRouteur.size(); j++){
							ArrayList<Switch> listeSwitch = listeRouteur.get(j).getListeSwitch();
							for(int k = 0; k < listeSwitch.size(); k++){
								ArrayList<Ordinateur> listeOrdinateur = listeSwitch.get(j).getListeOrdinateur();
								for(int l = 0; l < listeOrdinateur.size(); l++){
									if(listeOrdinateur.get(l).getNomOrdinateur().equals(fenetre.getListeOrdinateurs().get(position).toString())){
										fenetre.getReseauPhysique().get(i).getListeRouteur().get(j).getListeSwitch().get(k).getListeOrdinateur().remove(l);
										break DebutBoucle;
									}
								}
							}
						}
					}
					
					fenetre.miseAJourListes();
				}
				break;
			case SCarteReseauPhysique:
				position = fenetre.getList_cartes_reseaux().getSelectedIndex();
				dialogResult = JOptionPane.showConfirmDialog (null, "Voulez-vous vraiment supprimer La " + fenetre.getListeCarteReseaux().get(fenetre.getList_cartes_reseaux().getSelectedIndex()).toString(), "Confirmation", JOptionPane.YES_NO_OPTION);
				if(dialogResult == JOptionPane.YES_OPTION){
					//Par le réseau physique
					DebutBoucle:
					for(int i = 0; i < fenetre.getReseauPhysique().size(); i++){
						ArrayList<Salle> listeSalle = fenetre.getReseauPhysique().get(i).getListeSalle();
						for(int j = 0; j < listeSalle.size(); j++){
							ArrayList<Ordinateur> listeOrdinateurs = listeSalle.get(j).getListeOrdinateur();
							for(int k = 0; k < listeOrdinateurs.size(); k++){
								ArrayList<CarteReseau> listeCarte = listeOrdinateurs.get(k).getListeCarteReseau();
								if(listeCarte.contains(fenetre.getListeCarteReseaux().get(position))){
									fenetre.getReseauPhysique().get(i).getListeSalle().get(j).getListeOrdinateur().get(k).getListeCarteReseau().remove(fenetre.getListeCarteReseaux().get(position));
									break DebutBoucle;
								}
							}
						}
					}
				
				
				//Suppression dans les routeurs des cartes réseaux (par leurs switchs puis leurs ordinateurs)
				DebutBoucle3:
				for(int i = 0; i < fenetre.getReseauPhysique().size(); i++){
					ArrayList<Routeur> listeRouteur = fenetre.getReseauPhysique().get(i).getListeRouteur();
					for(int j = 0; j < listeRouteur.size(); j++){
						ArrayList<Switch> listeSwitch = listeRouteur.get(j).getListeSwitch();
						for(int k = 0; k < listeSwitch.size(); k++){
							ArrayList<Ordinateur> listeOrdinateurs = listeSwitch.get(k).getListeOrdinateur();
							for(int l = 0; l < listeOrdinateurs.size(); l++){
								ArrayList<CarteReseau> listeCarte = listeOrdinateurs.get(k).getListeCarteReseau();
								for(int m = 0; m < listeCarte.size(); m++){
									if(listeCarte.get(m).getAdresseMac().equals(fenetre.getListeCarteReseaux2().get(position).toString())){
										fenetre.getReseauPhysique().get(i).getListeRouteur().get(j).getListeSwitch().get(k).getListeOrdinateur().get(l).getListeCarteReseau().remove(m);
										break DebutBoucle3;
									}
								}
							}
						}
					}
				}
					fenetre.miseAJourListes();
				}
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
				Local local = (Local) fenetre.getListeLocaux().get(fenetre.getList_locaux().getSelectedIndex());
				local.Activer();
				break;
			case SSalle:
				Salle salle = (Salle) fenetre.getListeSalles().get(fenetre.getList_salles().getSelectedIndex());
				salle.Activer();
				break;
			case SOrdinateurPhysique:
				Ordinateur ordinateur = (Ordinateur) fenetre.getListeOrdinateurs().get(fenetre.getList_ordinateurs_physique().getSelectedIndex());
				ordinateur.Activer();
				break;
			case SCarteReseauPhysique:
				CarteReseau carte = (CarteReseau) fenetre.getListeCarteReseaux().get(fenetre.getList_cartes_reseaux().getSelectedIndex());
				carte.setActive(true);
				break;
			case SRouteur:
				Routeur routeur = (Routeur) fenetre.getListeRouteurs().get(fenetre.getList_routeurs().getSelectedIndex());
				routeur.setActive(true);
				break;
			case SSwitch:
				Switch switchR = (Switch) fenetre.getListeSwitchs().get(fenetre.getList_switchs().getSelectedIndex());
				switchR.setActive(true);
				break;
			case SOrdinateurLogique:
				Ordinateur ordinateur2 = (Ordinateur) fenetre.getListeOrdinateurs2().get(fenetre.getList_ordinateurs_logique().getSelectedIndex());
				ordinateur2.setActive(true);
				break;
			case SCarteReseauLogique:
				CarteReseau carte3 = (CarteReseau) fenetre.getListeCarteReseaux2().get(fenetre.getList_cartes_reseaux_logique().getSelectedIndex());
				carte3.setActive(true);
				break;
			}
			
			break;
			
		case SBoutonDsActiver:
			switch(fenetre.getFocusList()){
			case SLocal:
				Local local = (Local) fenetre.getListeLocaux().get(fenetre.getList_locaux().getSelectedIndex());
				local.Desactiver();
				break;
			case SSalle:
				Salle salle = (Salle) fenetre.getListeSalles().get(fenetre.getList_salles().getSelectedIndex());
				salle.Desactiver();
				break;
			case SOrdinateurPhysique:
				Ordinateur ordinateur = (Ordinateur) fenetre.getListeOrdinateurs().get(fenetre.getList_ordinateurs_physique().getSelectedIndex());
				ordinateur.Desactiver();
				break;
			case SCarteReseauPhysique:
				CarteReseau carte = (CarteReseau) fenetre.getListeCarteReseaux().get(fenetre.getList_cartes_reseaux().getSelectedIndex());
				carte.setActive(false);
				break;
			}
			fenetre.miseAJourListes();
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
			int dialogResult;
			switch(fenetre.getFocusList()){
			
			case SRouteur:
				dialogResult = JOptionPane.showConfirmDialog (null, "Voulez-vous vraiment supprimer Le " + fenetre.getListeRouteurs().get(fenetre.getList_routeurs().getSelectedIndex()).toString(), "Confirmation", JOptionPane.YES_NO_OPTION);
				if(dialogResult == JOptionPane.YES_OPTION){
					
					//Suppression réseau logique
					for(int i = 0; i < fenetre.getReseauPhysique().size(); i++){
						ArrayList<Routeur> listeRouteur = fenetre.getReseauPhysique().get(i).getListeRouteur();
						for(int j = 0; j < listeRouteur.size(); j++){
							if(listeRouteur.get(j).getNomRouteur().equals(fenetre.getListeRouteurs().get(fenetre.getList_routeurs().getSelectedIndex()).toString())){
								
								/** Enlève les ordinateurs dans les salles **/
								ArrayList<Switch> listeSwitch = listeRouteur.get(j).getListeSwitch();
								for(int k = 0; k < listeSwitch.size(); k++){
									ArrayList<Ordinateur> listeOrdinateur = listeSwitch.get(k).getListeOrdinateur();
									
									
									//supprime les salles touchées par le routeur
									CodeRetour:
										for(int m = 0; m < fenetre.getReseauPhysique().size(); m++){
											ArrayList<Salle> listeSallePh = fenetre.getReseauPhysique().get(m).getListeSalle();
											for(int n = 0; n < listeSallePh.size(); n++){
												ArrayList<Ordinateur> listeOrdinateurPh = listeSallePh.get(n).getListeOrdinateur();
												for(int o = 0; o < listeOrdinateurPh.size(); o++){
													Ordinateur ordinateur = listeOrdinateurPh.get(o);
													for(int p = 0; p < listeOrdinateur.size(); p++){
														if(ordinateur.getNomOrdinateur().equals(listeOrdinateur.get(p).getNomOrdinateur())){
															fenetre.getReseauPhysique().get(m).getListeSalle().remove(n);
														}
													}
												}
											}
									}
								}
								//Retire le routeur
								fenetre.getReseauPhysique().get(i).getListeRouteur().remove(j);
							}
						}							
					}
					fenetre.miseAJourListes();
				}
				break;
			case SSwitch:
				dialogResult = JOptionPane.showConfirmDialog (null, "Voulez-vous vraiment supprimer Le " + fenetre.getListeSwitchs().get(fenetre.getList_switchs().getSelectedIndex()).toString(), "Confirmation", JOptionPane.YES_NO_OPTION);
				if(dialogResult == JOptionPane.YES_OPTION){
					
					//Suppression réseau logique
					for(int i = 0; i < fenetre.getReseauPhysique().size(); i++){
						ArrayList<Routeur> listeRouteur = fenetre.getReseauPhysique().get(i).getListeRouteur();
						for(int j = 0; j < listeRouteur.size(); j++){
							ArrayList<Switch> listeSwitch = listeRouteur.get(j).getListeSwitch();
							for(int k = 0; k < listeSwitch.size(); k++){
								if(listeSwitch.get(k).getNomSwitch().equals(fenetre.getListeSwitchs().get(fenetre.getList_switchs().getSelectedIndex()).toString())){
									ArrayList<Ordinateur> listeOrdinateur = listeSwitch.get(k).getListeOrdinateur();
									
									//supprime les salles touchées par le switch
									for(int m = 0; m < fenetre.getReseauPhysique().size(); m++){
										ArrayList<Salle> listeSallePh = fenetre.getReseauPhysique().get(m).getListeSalle();
										for(int n = 0; n < listeSallePh.size(); n++){
											ArrayList<Ordinateur> listeOrdinateurPh = listeSallePh.get(n).getListeOrdinateur();
											for(int o = 0; o < listeOrdinateurPh.size(); o++){
												Ordinateur ordinateur = listeOrdinateurPh.get(o);
												for(int p = 0; p < listeOrdinateur.size(); p++){
													if(ordinateur.getNomOrdinateur().equals(listeOrdinateur.get(p).getNomOrdinateur())){
														fenetre.getReseauPhysique().get(m).getListeSalle().remove(n);
													}
												}
											}
										}
									}
									fenetre.getReseauPhysique().get(i).getListeRouteur().get(j).getListeSwitch().remove(k);
								}
							}
						}					
					}
					fenetre.miseAJourListes();
				}
				break;
			case SOrdinateurLogique:
				
				position = fenetre.getList_ordinateurs_logique().getSelectedIndex();
				dialogResult = JOptionPane.showConfirmDialog (null, "Voulez-vous vraiment supprimer L'" + fenetre.getListeOrdinateurs2().get(fenetre.getList_ordinateurs_logique().getSelectedIndex()).toString(), "Confirmation", JOptionPane.YES_NO_OPTION);
				if(dialogResult == JOptionPane.YES_OPTION){
					
					DebutBoucle0:
					//Supprime dans le réseau physique
					for(int i = 0; i < fenetre.getReseauPhysique().size(); i++){
						ArrayList<Salle> listeSalle = fenetre.getReseauPhysique().get(i).getListeSalle();
						for(int j = 0; j < listeSalle.size(); j++){
							ArrayList<Ordinateur> listeOrdinateur = listeSalle.get(j).getListeOrdinateur();
							for(int k = 0; k < listeOrdinateur.size(); k++){
								if(listeOrdinateur.get(k).getNomOrdinateur().equals(fenetre.getListeOrdinateurs2().get(position).toString())){
									fenetre.getReseauPhysique().get(i).getListeSalle().get(j).getListeOrdinateur().remove(k);
									break DebutBoucle0;
								}
							}
						}
					}
					
					//Suppression dans les routeurs des locaux (par leurs switchs)
					DebutBoucle:
					for(int i = 0; i < fenetre.getReseauPhysique().size(); i++){
						ArrayList<Routeur> listeRouteur = fenetre.getReseauPhysique().get(i).getListeRouteur();
						for(int j = 0; j < listeRouteur.size(); j++){
							ArrayList<Switch> listeSwitch = listeRouteur.get(j).getListeSwitch();
							for(int k = 0; k < listeSwitch.size(); k++){
								ArrayList<Ordinateur> listeOrdinateur = listeSwitch.get(j).getListeOrdinateur();
								for(int l = 0; l < listeOrdinateur.size(); l++){
									if(listeOrdinateur.get(l).getNomOrdinateur().equals(fenetre.getListeOrdinateurs2().get(position).toString())){
										fenetre.getReseauPhysique().get(i).getListeRouteur().get(j).getListeSwitch().get(k).getListeOrdinateur().remove(l);
										break DebutBoucle;
									}
								}
							}
						}
					}
					
					fenetre.miseAJourListes();
				}
				break;
			case SCarteReseauLogique:
				position = fenetre.getList_cartes_reseaux_logique().getSelectedIndex();
				dialogResult = JOptionPane.showConfirmDialog (null, "Voulez-vous vraiment supprimer La " + fenetre.getListeCarteReseaux2().get(fenetre.getList_cartes_reseaux_logique().getSelectedIndex()).toString(), "Confirmation", JOptionPane.YES_NO_OPTION);
				if(dialogResult == JOptionPane.YES_OPTION){
					//Par le réseau physique
					DebutBoucle:
					for(int i = 0; i < fenetre.getReseauPhysique().size(); i++){
						ArrayList<Salle> listeSalle = fenetre.getReseauPhysique().get(i).getListeSalle();
						for(int j = 0; j < listeSalle.size(); j++){
							ArrayList<Ordinateur> listeOrdinateurs = listeSalle.get(j).getListeOrdinateur();
							for(int k = 0; k < listeOrdinateurs.size(); k++){
								ArrayList<CarteReseau> listeCarte = listeOrdinateurs.get(k).getListeCarteReseau();
								if(listeCarte.contains(fenetre.getListeCarteReseaux().get(position))){
									fenetre.getReseauPhysique().get(i).getListeSalle().get(j).getListeOrdinateur().get(k).getListeCarteReseau().remove(fenetre.getListeCarteReseaux().get(position));
									break DebutBoucle;
								}
							}
						}
					}
				
				
				//Suppression dans les routeurs des cartes réseaux (par leurs switchs puis leurs ordinateurs)
				DebutBoucle3:
				for(int i = 0; i < fenetre.getReseauPhysique().size(); i++){
					ArrayList<Routeur> listeRouteur = fenetre.getReseauPhysique().get(i).getListeRouteur();
					for(int j = 0; j < listeRouteur.size(); j++){
						ArrayList<Switch> listeSwitch = listeRouteur.get(j).getListeSwitch();
						for(int k = 0; k < listeSwitch.size(); k++){
							ArrayList<Ordinateur> listeOrdinateurs = listeSwitch.get(k).getListeOrdinateur();
							for(int l = 0; l < listeOrdinateurs.size(); l++){
								ArrayList<CarteReseau> listeCarte = listeOrdinateurs.get(k).getListeCarteReseau();
								for(int m = 0; m < listeCarte.size(); m++){
									if(listeCarte.get(m).getAdresseMac().equals(fenetre.getListeCarteReseaux2().get(position).toString())){
										fenetre.getReseauPhysique().get(i).getListeRouteur().get(j).getListeSwitch().get(k).getListeOrdinateur().get(l).getListeCarteReseau().remove(m);
										break DebutBoucle3;
									}
								}
							}
						}
					}
				}
					fenetre.miseAJourListes();
				}
				break;
			}
			
			break;
			
		case SBoutonMiseJour_1:
			switch(fenetre.getFocusList()){
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
			case SRouteur:
				Routeur routeur = (Routeur) fenetre.getListeRouteurs().get(fenetre.getList_routeurs().getSelectedIndex());
				
				for(int i = 0; i < fenetre.getReseauPhysique().size(); i++){
					ArrayList<Routeur> listeRouteur = fenetre.getReseauPhysique().get(i).getListeRouteur();
					for(int j = 0; j < listeRouteur.size(); j++){
						String nomRouteur = listeRouteur.get(j).getNomRouteur();
						if(nomRouteur.equals(routeur.getNomRouteur())){
							fenetre.getReseauPhysique().get(i).getListeRouteur().get(j).Activer();
						}
					}
				}
				break;
			case SSwitch:
				for(int i = 0; i < fenetre.getReseauPhysique().size(); i++){
					ArrayList<Routeur> listeRouteur = fenetre.getReseauPhysique().get(i).getListeRouteur();
					for(int j = 0; j < listeRouteur.size(); j++){
						ArrayList<Switch> listeSwitch = listeRouteur.get(j).getListeSwitch();
						for(int k = 0; k < listeSwitch.size(); k++){
							if(listeSwitch.get(k).getNomSwitch().equals(fenetre.getListeSwitchs().get(fenetre.getList_switchs().getSelectedIndex()).toString())){
								fenetre.getReseauPhysique().get(i).getListeRouteur().get(j).getListeSwitch().get(k).Activer();
							}
						}
					}
				}
				break;
			case SOrdinateurLogique:
				DebutBoucle:
					for(int i = 0; i < fenetre.getReseauPhysique().size(); i++){
						ArrayList<Routeur> listeRouteur = fenetre.getReseauPhysique().get(i).getListeRouteur();
						for(int j = 0; j < listeRouteur.size(); j++){
							ArrayList<Switch> listeSwitch = listeRouteur.get(j).getListeSwitch();
							for(int k = 0; k < listeSwitch.size(); k++){
								ArrayList<Ordinateur> listeOrdinateur = listeSwitch.get(j).getListeOrdinateur();
								for(int l = 0; l < listeOrdinateur.size(); l++){
									if(listeOrdinateur.get(l).getNomOrdinateur().equals(fenetre.getListeOrdinateurs2().get(fenetre.getList_ordinateurs_logique().getSelectedIndex()).toString())){
										fenetre.getReseauPhysique().get(i).getListeRouteur().get(j).getListeSwitch().get(k).getListeOrdinateur().get(l).Activer();
										break DebutBoucle;
									}
								}
							}
						}
					}
				break;
			case SCarteReseauLogique:
				position = fenetre.getList_cartes_reseaux_logique().getSelectedIndex();
				dialogResult = JOptionPane.showConfirmDialog (null, "Voulez-vous vraiment supprimer La " + fenetre.getListeCarteReseaux2().get(fenetre.getList_cartes_reseaux_logique().getSelectedIndex()).toString(), "Confirmation", JOptionPane.YES_NO_OPTION);
				if(dialogResult == JOptionPane.YES_OPTION){
					//Par le réseau physique
					DebutBoucle:
					for(int i = 0; i < fenetre.getReseauPhysique().size(); i++){
						ArrayList<Salle> listeSalle = fenetre.getReseauPhysique().get(i).getListeSalle();
						for(int j = 0; j < listeSalle.size(); j++){
							ArrayList<Ordinateur> listeOrdinateurs = listeSalle.get(j).getListeOrdinateur();
							for(int k = 0; k < listeOrdinateurs.size(); k++){
								ArrayList<CarteReseau> listeCarte = listeOrdinateurs.get(k).getListeCarteReseau();
								if(listeCarte.contains(fenetre.getListeCarteReseaux().get(position))){
									fenetre.getReseauPhysique().get(i).getListeSalle().get(j).getListeOrdinateur().get(k).getListeCarteReseau().remove(fenetre.getListeCarteReseaux().get(position));
									break DebutBoucle;
								}
							}
						}
					}
				
				
				//Suppression dans les routeurs des cartes réseaux (par leurs switchs puis leurs ordinateurs)
				DebutBoucle3:
				for(int i = 0; i < fenetre.getReseauPhysique().size(); i++){
					ArrayList<Routeur> listeRouteur = fenetre.getReseauPhysique().get(i).getListeRouteur();
					for(int j = 0; j < listeRouteur.size(); j++){
						ArrayList<Switch> listeSwitch = listeRouteur.get(j).getListeSwitch();
						for(int k = 0; k < listeSwitch.size(); k++){
							ArrayList<Ordinateur> listeOrdinateurs = listeSwitch.get(k).getListeOrdinateur();
							for(int l = 0; l < listeOrdinateurs.size(); l++){
								ArrayList<CarteReseau> listeCarte = listeOrdinateurs.get(k).getListeCarteReseau();
								for(int m = 0; m < listeCarte.size(); m++){
									if(listeCarte.get(m).getAdresseMac().equals(fenetre.getListeCarteReseaux2().get(position).toString())){
										fenetre.getReseauPhysique().get(i).getListeRouteur().get(j).getListeSwitch().get(k).getListeOrdinateur().get(l).getListeCarteReseau().remove(m);
										break DebutBoucle3;
									}
								}
							}
						}
					}
				}
				}
				break;
			}
			fenetre.miseAJourListes();
			break;
			
		case SBoutonDsActiver_1:
			switch(fenetre.getFocusList()){
			case SRouteur:
				Routeur routeur1 = (Routeur) fenetre.getListeRouteurs().get(fenetre.getList_routeurs().getSelectedIndex());
				
				for(int i = 0; i < fenetre.getReseauPhysique().size(); i++){
					ArrayList<Routeur> listeRouteur = fenetre.getReseauPhysique().get(i).getListeRouteur();
					for(int j = 0; j < listeRouteur.size(); j++){
						String nomRouteur = listeRouteur.get(j).getNomRouteur();
						if(nomRouteur.equals(routeur1.getNomRouteur())){
							fenetre.getReseauPhysique().get(i).getListeRouteur().get(j).Desactiver();
						}
					}
				}
				break;
			case SSwitch:
				for(int i = 0; i < fenetre.getReseauPhysique().size(); i++){
					ArrayList<Routeur> listeRouteur = fenetre.getReseauPhysique().get(i).getListeRouteur();
					for(int j = 0; j < listeRouteur.size(); j++){
						ArrayList<Switch> listeSwitch = listeRouteur.get(j).getListeSwitch();
						for(int k = 0; k < listeSwitch.size(); k++){
							if(listeSwitch.get(k).getNomSwitch().equals(fenetre.getListeSwitchs().get(fenetre.getList_switchs().getSelectedIndex()).toString())){
								fenetre.getReseauPhysique().get(i).getListeRouteur().get(j).getListeSwitch().get(k).Desactiver();
							}
						}
					}
				}
				break;
			case SOrdinateurLogique:
				DebutBoucle:
					for(int i = 0; i < fenetre.getReseauPhysique().size(); i++){
						ArrayList<Routeur> listeRouteur = fenetre.getReseauPhysique().get(i).getListeRouteur();
						for(int j = 0; j < listeRouteur.size(); j++){
							ArrayList<Switch> listeSwitch = listeRouteur.get(j).getListeSwitch();
							for(int k = 0; k < listeSwitch.size(); k++){
								ArrayList<Ordinateur> listeOrdinateur = listeSwitch.get(j).getListeOrdinateur();
								for(int l = 0; l < listeOrdinateur.size(); l++){
									if(listeOrdinateur.get(l).getNomOrdinateur().equals(fenetre.getListeOrdinateurs2().get(fenetre.getList_ordinateurs_logique().getSelectedIndex()).toString())){
										fenetre.getReseauPhysique().get(i).getListeRouteur().get(j).getListeSwitch().get(k).getListeOrdinateur().get(l).Desactiver();
										break DebutBoucle;
									}
								}
							}
						}
					}
				break;
			case SCarteReseauLogique:
				position = fenetre.getList_cartes_reseaux_logique().getSelectedIndex();

				//Suppression dans les routeurs des cartes réseaux (par leurs switchs puis leurs ordinateurs)
				DebutBoucle3:
				for(int i = 0; i < fenetre.getReseauPhysique().size(); i++){
					ArrayList<Routeur> listeRouteur = fenetre.getReseauPhysique().get(i).getListeRouteur();
					for(int j = 0; j < listeRouteur.size(); j++){
						ArrayList<Switch> listeSwitch = listeRouteur.get(j).getListeSwitch();
						for(int k = 0; k < listeSwitch.size(); k++){
							ArrayList<Ordinateur> listeOrdinateurs = listeSwitch.get(k).getListeOrdinateur();
							for(int l = 0; l < listeOrdinateurs.size(); l++){
								ArrayList<CarteReseau> listeCarte = listeOrdinateurs.get(k).getListeCarteReseau();
								for(int m = 0; m < listeCarte.size(); m++){
									CarteReseau carteTest = (CarteReseau) fenetre.getListeCarteReseaux2().get(position);
									if(listeCarte.get(m).getAdresseMac().equals(carteTest.getAdresseMac())){
										fenetre.getReseauPhysique().get(i).getListeRouteur().get(j).getListeSwitch().get(k).getListeOrdinateur().get(l).getListeCarteReseau().get(m).setActive(false);
										break DebutBoucle3;
									}
								}
							}
						}
					}
				}
				break;
			}
			fenetre.miseAJourListes();
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
