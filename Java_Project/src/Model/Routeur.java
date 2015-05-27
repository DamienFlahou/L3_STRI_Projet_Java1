package Model;
import java.util.ArrayList;

public class Routeur {
	private String nomRouteur;
	private ArrayList<Switch> listeSwitch = new ArrayList<Switch>();
	private ArrayList<Salle> listeSalle = new ArrayList<Salle>();
	private ArrayList<CarteReseau> listeCarteReseau = new ArrayList<CarteReseau>();
	private boolean isActive;
	
	public Routeur(String nomRouteur, boolean _isActive) {
		super();
		this.nomRouteur = nomRouteur;
		this.isActive = _isActive;
	}

	public void AjouterSwitch(String nomSwitch) {
		this.listeSwitch.add(new Switch(nomSwitch, true));
	}
	
	public void AjouterSwitch(Switch _switch) {
		this.listeSwitch.add(_switch);
	}
	
	public void AjouterSalle(String nomSalle) {
		this.listeSalle.add(new Salle(nomSalle, true));
	}
	
	public void AjouterCarteReseau(String nomCarteReseau) {
		this.listeCarteReseau.add(new CarteReseau(nomCarteReseau, true));
	}
	
	public void AjouterCarteReseau(CarteReseau carteReseau) {
		this.listeCarteReseau.add(carteReseau);
	}

	public String getNomRouteur() {
		return nomRouteur;
	}

	public void setNomRouteur(String nomRouteur) {
		this.nomRouteur = nomRouteur;
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

	public ArrayList<CarteReseau> getListeCarteReseau() {
		return listeCarteReseau;
	}

	public void setListeCarteReseau(ArrayList<CarteReseau> listeCarteReseau) {
		this.listeCarteReseau = listeCarteReseau;
	}
	
	public String toString(){
		return nomRouteur;
	}
	
	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	public void Desactiver(){
		for(Switch s : listeSwitch){
			s.Desactiver();
		}
		for(Salle s2 : listeSalle){
			s2.Desactiver();
		}
		for(CarteReseau c : listeCarteReseau){
			c.setActive(false);
		}
		this.setActive(false);
	}
	
	public void Activer(){
		for(Switch s : listeSwitch){
			s.Activer();
		}
		for(Salle s2 : listeSalle){
			s2.Activer();
		}
		for(CarteReseau c : listeCarteReseau){
			c.setActive(true);
		}
		this.setActive(true);
	}
}
