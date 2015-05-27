package Model;
import java.util.ArrayList;

public class Local {
	private String nomLocal;
	private ArrayList<Routeur> listeRouteur = new ArrayList<Routeur>();
	private ArrayList<Switch> listeSwitch = new ArrayList<Switch>();
	private ArrayList<Salle> listeSalle = new ArrayList<Salle>();
	private boolean isActive;
	
	public Local(String nomLocal, boolean _isActive) {
		super();
		this.nomLocal = nomLocal;
		this.isActive = _isActive;
	}

	public void AjouterRouteur(String nomRouteur) {
		this.listeRouteur.add(new Routeur(nomRouteur, true));
	}
	
	public void AjouterRouteur(Routeur routeur) {
		this.listeRouteur.add(routeur);
	}
	
	public void AjouterSalle(String nomSalle) {
		this.listeSalle.add(new Salle(nomSalle, true));
	}
	
	public void AjouterSalle(Salle salle) {
		this.listeSalle.add(salle);
	}

	public void AjouterSwitch(String nomSwitch) {
		this.listeSwitch.add(new Switch(nomSwitch, true));
	}
	
	public void AjouterSwitch(Switch switchR) {
		this.listeSwitch.add(switchR);
	}

	public String getNomLocal() {
		return nomLocal;
	}

	public void setNomLocal(String nomLocal) {
		this.nomLocal = nomLocal;
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

	public ArrayList<Salle> getListeSalle() {
		return listeSalle;
	}

	public void setListeSalle(ArrayList<Salle> listeSalle) {
		this.listeSalle = listeSalle;
	}
	
	public String toString(){
		return this.nomLocal;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	public void Desactiver(){
		for(Salle s : listeSalle){
			s.Desactiver();
		}
		for(Routeur r : listeRouteur){
			r.Desactiver();
		}
		for(Switch s2 : listeSwitch){
			s2.Desactiver();
		}
		this.setActive(false);
	}
	
	public void Activer(){
		for(Salle s : listeSalle){
			s.Activer();
		}
		for(Routeur r : listeRouteur){
			r.Activer();
		}
		for(Switch s2 : listeSwitch){
			s2.Activer();
		}
		this.setActive(true);
	}
	
}
