package Model;
import java.util.ArrayList;

public class Ordinateur {

	private String nomOrdinateur;
	private ArrayList<CarteReseau> listeCarteReseau = new ArrayList<CarteReseau>(); 
	private boolean isActive;
	
	public Ordinateur(String nomOrdinateur, boolean _isActive) {
		super();
		this.nomOrdinateur = nomOrdinateur;
		this.isActive = _isActive;
	}
	
	public void AjouterCarteReseau(String adresseMac) {
		this.listeCarteReseau.add(new CarteReseau(adresseMac, true));
	}
	
	public void AjouterCarteReseau(CarteReseau carteReseau) {
		this.listeCarteReseau.add(carteReseau);
	}

	public String getNomOrdinateur() {
		return nomOrdinateur;
	}

	public void setNomOrdinateur(String nomOrdinateur) {
		this.nomOrdinateur = nomOrdinateur;
	}

	public ArrayList<CarteReseau> getListeCarteReseau() {
		return listeCarteReseau;
	}

	public void setListeCarteReseau(ArrayList<CarteReseau> listeCarteReseau) {
		this.listeCarteReseau = listeCarteReseau;
	}
	
	public String toString(){
		return nomOrdinateur;
	}
	
	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	public void Desactiver(){
		for(CarteReseau carte : listeCarteReseau){
			carte.setActive(false);
		}
		this.setActive(false);
	}
	
	public void Activer(){
		for(CarteReseau carte : listeCarteReseau){
			carte.setActive(true);
		}
		this.setActive(true);
	}
}
