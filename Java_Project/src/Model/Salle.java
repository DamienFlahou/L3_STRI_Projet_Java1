package Model;
import java.util.ArrayList;


public class Salle {

	private String nomSalle;
	private ArrayList<Routeur> listeRouteur = new ArrayList<Routeur>();
	private ArrayList<Switch> listeSwitch = new ArrayList<Switch>();
	private ArrayList<Ordinateur> listeOrdinateur = new ArrayList<Ordinateur>();
	private boolean isActive;
	
	public Salle(String nomSalle, boolean _isActive) {
		super();
		this.nomSalle = nomSalle;
		this.isActive = _isActive;
	}
	
	public void AjouterRouteur(String nomRouteur) {
		this.listeRouteur.add(new Routeur(nomRouteur, true));
	}

	public void AjouterSwitch(String nomSwitch) {
		this.listeSwitch.add(new Switch(nomSwitch, true));
	}
	
	public void AjouterRouteur(Routeur routeur) {
		this.listeRouteur.add(routeur);
	}

	public void AjouterSwitch(Switch switchR) {
		this.listeSwitch.add(switchR);
	}
	
	public void AjouterOrdinateur(String nomOrdinateur) {
		this.listeOrdinateur.add(new Ordinateur(nomOrdinateur, true));
	}
	
	public void AjouterOrdinateur(Ordinateur ordinateur) {
		this.listeOrdinateur.add(ordinateur);
	}

	public String getNomSalle() {
		return nomSalle;
	}

	public void setNomSalle(String nomSalle) {
		this.nomSalle = nomSalle;
	}

	public ArrayList<Routeur> getListeRouteur() {
		return listeRouteur;
	}

	public void setListeRouteur(ArrayList<Routeur> listeRouteur) {
		this.listeRouteur = listeRouteur;
	}

	public ArrayList<Switch> getListeSwitch() {
		return listeSwitch;
	}

	public void setListeSwitch(ArrayList<Switch> listeSwitch) {
		this.listeSwitch = listeSwitch;
	}

	public ArrayList<Ordinateur> getListeOrdinateur() {
		return listeOrdinateur;
	}

	public void setListeOrdinateur(ArrayList<Ordinateur> listeOrdinateur) {
		this.listeOrdinateur = listeOrdinateur;
	}
	
	public String toString(){
		return nomSalle;
	}
	
	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	public void Desactiver(){
		for(Ordinateur o : listeOrdinateur){
			o.Desactiver();
		}
		for(Switch s : listeSwitch){
			s.Desactiver();
		}
		this.setActive(false);
	}
	
	public void Activer(){
		for(Ordinateur o : listeOrdinateur){
			o.Activer();
		}
		for(Switch s : listeSwitch){
			s.Activer();
		}
		this.setActive(true);
	}
	
}
