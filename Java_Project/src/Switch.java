import java.util.ArrayList;


public class Switch {
	private String nomSwitch;
	private ArrayList<Salle> listeSalle = new ArrayList<Salle>();
	private ArrayList<Ordinateur> listeOrdinateur = new ArrayList<Ordinateur>();
	
	public Switch(String nomSwitch) {
		super();
		this.nomSwitch = nomSwitch;
	}

	public void AjouterSalle(String nomSalle) {
		this.listeSalle.add(new Salle(nomSalle));
	}
	
	public void AjouterOrdinateur(String nomOrdinateur) {
		this.listeOrdinateur.add(new Ordinateur(nomOrdinateur));
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
	
}
