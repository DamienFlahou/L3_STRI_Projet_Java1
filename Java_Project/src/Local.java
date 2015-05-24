import java.util.ArrayList;

public class Local {
	private String nomLocal;
	private ArrayList<Routeur> listeRouteur = new ArrayList<Routeur>();
	private ArrayList<Switch> listeSwitch = new ArrayList<Switch>();
	private ArrayList<Salle> listeSalle = new ArrayList<Salle>();
	
	public Local(String nomLocal) {
		super();
		this.nomLocal = nomLocal;
	}

	public void AjouterRouteur(String nomRouteur) {
		this.listeRouteur.add(new Routeur(nomRouteur));
	}
	
	public void AjouterSalle(String nomSalle) {
		this.listeSalle.add(new Salle(nomSalle));
	}

	public void AjouterSwitch(String nomSwitch) {
		this.listeSwitch.add(new Switch(nomSwitch));
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
	
}
