import java.util.ArrayList;

public class Ordinateur {

	private String nomOrdinateur;
	private ArrayList<CarteReseau> listeCarteReseau = new ArrayList<CarteReseau>(); 
	
	public Ordinateur(String nomOrdinateur) {
		super();
		this.nomOrdinateur = nomOrdinateur;
	}
	
	public void AjouterCarteReseau(String adresseMac) {
		this.listeCarteReseau.add(new CarteReseau(adresseMac));
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
	
}
