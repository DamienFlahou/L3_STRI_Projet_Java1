import java.util.ArrayList;

public class Routeur {
	private String nomRouteur;
	private ArrayList<Local> listeLocal = new ArrayList<Local>();
	private ArrayList<Switch> listeSwitch = new ArrayList<Switch>();
	private ArrayList<Salle> listeSalle = new ArrayList<Salle>();
	private ArrayList<CarteReseau> listeCarteReseau = new ArrayList<CarteReseau>();
	
	
	public Routeur(String nomRouteur) {
		super();
		this.nomRouteur = nomRouteur;
	}
	
	public void ajouterLocal(String nomLocal) {
		this.listeLocal.add(new Local(nomLocal));
	}

	public void AjouterSwitch(String nomSwitch) {
		this.listeSwitch.add(new Switch(nomSwitch));
	}
	
	public void AjouterSwitch(Switch _switch) {
		this.listeSwitch.add(_switch);
	}
	
	public void AjouterSalle(String nomSalle) {
		this.listeSalle.add(new Salle(nomSalle));
	}
	
	public void AjouterCarteReseau(String nomCarteReseau) {
		this.listeCarteReseau.add(new CarteReseau(nomCarteReseau));
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
	
}
