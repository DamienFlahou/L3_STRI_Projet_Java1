import java.util.ArrayList;


public class Salle {

	private String nomSalle;
	private ArrayList<Routeur> listeRouteur = new ArrayList<Routeur>();
	private ArrayList<Switch> listeSwitch = new ArrayList<Switch>();
	private ArrayList<Ordinateur> listeOrdinateur = new ArrayList<Ordinateur>();
	
	public Salle(String nomSalle) {
		super();
		this.nomSalle = nomSalle;
	}
	
	public void AjouterRouteur(String nomRouteur) {
		this.listeRouteur.add(new Routeur(nomRouteur));
	}

	public void AjouterSwitch(String nomSwitch) {
		this.listeSwitch.add(new Switch(nomSwitch));
	}
	
	public void AjouterOrdinateur(String nomOrdinateur) {
		this.listeOrdinateur.add(new Ordinateur(nomOrdinateur));
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
	
	
}
