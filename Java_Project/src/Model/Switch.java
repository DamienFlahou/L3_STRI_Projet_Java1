package Model;
import java.util.ArrayList;


public class Switch {
	private String nomSwitch;
	private ArrayList<Salle> listeSalle = new ArrayList<Salle>();
	private ArrayList<Ordinateur> listeOrdinateur = new ArrayList<Ordinateur>();
	
	private boolean isActive;
	
	public Switch(String nomSwitch, boolean _isActive) {
		super();
		this.isActive = _isActive;
		this.nomSwitch = nomSwitch;
	}

	public void AjouterSalle(String nomSalle) {
		this.listeSalle.add(new Salle(nomSalle, true));
	}
	
	public void AjouterOrdinateur(String nomOrdinateur) {
		this.listeOrdinateur.add(new Ordinateur(nomOrdinateur, true));
	}
	
	public void AjouterOrdinateur(Ordinateur ordinateur) {
		this.listeOrdinateur.add(ordinateur);
	}

	public String getNomSwitch() {
		return nomSwitch;
	}

	public void setNomSwitch(String nomSwitch) {
		this.nomSwitch = nomSwitch;
	}

	public ArrayList<Salle> getListeSalle() {
		return listeSalle;
	}

	public void setListeSalle(ArrayList<Salle> listeSalle) {
		this.listeSalle = listeSalle;
	}

	public ArrayList<Ordinateur> getListeOrdinateur() {
		return listeOrdinateur;
	}

	public void setListeOrdinateur(ArrayList<Ordinateur> listeOrdinateur) {
		this.listeOrdinateur = listeOrdinateur;
	}
	
	public String toString(){
		return nomSwitch;
	}
	
	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	public void Desactiver(){
		for(Ordinateur ordinateur : listeOrdinateur){
			ordinateur.Desactiver();
		}
		for(Salle salle : listeSalle){
			salle.Desactiver();
		}
		this.setActive(false);
	}
	
	public void Activer(){
		for(Ordinateur ordinateur : listeOrdinateur){
			ordinateur.Activer();
		}
		for(Salle salle : listeSalle){
			salle.Activer();
		}
		this.setActive(true);
	}
}
