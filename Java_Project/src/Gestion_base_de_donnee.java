import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


public class Gestion_base_de_donnee {
	
	private Connection connect = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	
	/*
	  On aura une liste de local et/ou de routeur à partir desquels découleront les autres classes
	  selon la hiérarhie de la base de donnée.
	*/
	private ArrayList<Routeur> reseauLogique = new ArrayList<Routeur>();
	private ArrayList<Local> reseauPhysique = new ArrayList<Local>();
	
	public ArrayList<Routeur> getReseauLogique() {
		return reseauLogique;
	}

	public void setReseauLogique(ArrayList<Routeur> reseauLogique) {
		this.reseauLogique = reseauLogique;
	}

	public ArrayList<Local> getReseauPhysique() {
		return reseauPhysique;
	}

	public void setReseauPhysique(ArrayList<Local> reseauPhysique) {
		this.reseauPhysique = reseauPhysique;
	}

	public Gestion_base_de_donnee() throws Exception{
		try{
	
			Class.forName("com.mysql.jdbc.Driver");
			// Lance connection
			connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost" + "user=root&password=projetWeb");
			statement = (Statement) connect.createStatement();
		}
		catch(Exception e){
			throw e;
		}
	}
	
	public void populateApplication() throws Exception{
		//ArrayList du réseau logique
		populateReseauLogique();
		
		//ArrayList du réseau logique
		populateReseauPhysique();
		
	}
	
	private void populateReseauLogique() throws Exception{
		try{
			int i, j, k, l;
			int nombreRouteurs, nombreSwitchs, nombreOrdinateurs, nombreCarteReseaux;
			ResultSet resultSetRouteur;
			ResultSet resultSetSwitch;
			ResultSet resultSetOrdinateur;
			ResultSet resultSetCarteReseau;
			
		    //Regarde le nombre de locaux pour ensuite faire des boucles imbriquées.
			resultSetRouteur = statement.executeQuery("select COUNT(*) from Routeur WHERE id_switch = 0");
			resultSetRouteur.next();
		    nombreRouteurs = resultSetRouteur.getInt(0);
		    
		    //Recherche tous les locaux
		    resultSetRouteur = statement.executeQuery("select * from Routeur WHERE id_switch = 0");
		    
		    for(i = 0; i < nombreRouteurs; i++){
		    	resultSetRouteur.next();
		    	
		    	Routeur routeurRemplisseur = new Routeur(resultSet.getString("nom_routeur"));
		    	
		    	//recherche le nombre de switchs connecté au routeur
		    	resultSetSwitch = statement.executeQuery(new StringBuilder("select COUNT(*) from Switch WHERE id_routeur = ").append(resultSet.getInt("id_routeur")).toString());
			    resultSetSwitch.next();
			    nombreSwitchs = resultSet.getInt(0);
			    
			    resultSetSwitch = statement.executeQuery(new StringBuilder("select * from Switch WHERE id_routeur = ").append(resultSet.getInt("id_routeur")).toString());
			    
			    for(j = 0; j < nombreSwitchs; j++){
			    	resultSetSwitch.next();
			    	
			    	Switch switchRemplisseur = new Switch(resultSetSwitch.getString("nom_switch"));
			    
			    	resultSetOrdinateur = statement.executeQuery(new StringBuilder("select COUNT(*) from Ordinateur WHERE id_switch = ").append(resultSetSwitch.getInt("id_switch")).toString());
			    	resultSetOrdinateur.next();
				    nombreOrdinateurs = resultSetOrdinateur.getInt(0);
				    
				    resultSetOrdinateur = statement.executeQuery(new StringBuilder("select * from Ordinateur WHERE id_switch = ").append(resultSetSwitch.getInt("id_switch")).toString());
				    
				    for(k = 0; k < nombreOrdinateurs; k++){
				    	resultSetOrdinateur.next();
				    	
				    	Ordinateur ordinateurRemplisseur = new Ordinateur(resultSetOrdinateur.getString("nom_ordinateur"));
				    
				    	resultSetCarteReseau = statement.executeQuery(new StringBuilder("select COUNT(*) from Carte_reseau WHERE id_ordinateur = ").append(resultSetSwitch.getInt("id_ordinateur")).toString());
				    	resultSetCarteReseau.next();
					    nombreCarteReseaux = resultSetCarteReseau.getInt(0);
					    
					    resultSetCarteReseau = statement.executeQuery(new StringBuilder("select * from Carte_reseau WHERE id_ordinateur = ").append(resultSetSwitch.getInt("id_ordinateur")).toString());
					    
				    	for(l = 0; l < nombreCarteReseaux; l++){
				    		resultSetCarteReseau.next();
				    		
				    		//crée la carte réseau
				    		CarteReseau carteReseauRemplisseur = new CarteReseau(resultSetCarteReseau.getString("adresse_mac"));
				    		//ajoute la carte réseau à l'ordinateur
				    		ordinateurRemplisseur.AjouterCarteReseau(carteReseauRemplisseur);
				    	}
				    	
				    	//ajoute l'ordinateur au switch
				    	switchRemplisseur.AjouterOrdinateur(ordinateurRemplisseur);
				    }
				    
				    //ajoute le switch au routeur
				    routeurRemplisseur.AjouterSwitch(switchRemplisseur);
			    }
			    
			    //ajoute les cartes réseaux du routeur
			    resultSetCarteReseau = statement.executeQuery(new StringBuilder("select COUNT(*) from Carte_reseau WHERE id_routeur = ").append(resultSetRouteur.getInt("id_routeur")).toString());
			    resultSetCarteReseau.next();
			    nombreCarteReseaux = resultSetCarteReseau.getInt(0);
			    
			    resultSetCarteReseau = statement.executeQuery(new StringBuilder("select * from Carte_reseau WHERE id_routeur = ").append(resultSetRouteur.getInt("id_routeur")).toString());
			    
		    	for(l = 0; l < nombreCarteReseaux; l++){
		    		resultSetCarteReseau.next();
		    		
		    		//crée la carte réseau
		    		CarteReseau carteReseauRemplisseur = new CarteReseau(resultSetCarteReseau.getString("adresse_mac"));
		    		//ajoute la carte réseau à l'ordinateur
		    		routeurRemplisseur.AjouterCarteReseau(carteReseauRemplisseur);
		    	}
		    	reseauLogique.add(routeurRemplisseur);
		    }
		    
		}
		catch(Exception e){
			throw e;
		}
	}
	
	private void populateReseauPhysique() throws Exception{
		int i, j, k, l, m;
		int nombreLocaux, nombreSalles, nombreRouteurs, nombreSwitchs, nombreOrdinateurs, nombreCarteReseaux;
		ResultSet resultSetLocal;
		ResultSet resultSetSalle;
		ResultSet resultSetRouteur;
		ResultSet resultSetSwitch;
		ResultSet resultSetOrdinateur;
		ResultSet resultSetCarteReseau;
		
		try{
		//Regarde le nombre de locaux pour ensuite faire des boucles imbriquées.
		resultSetLocal = statement.executeQuery("select COUNT(*) from Local");
		resultSetLocal.next();
		nombreLocaux = resultSetLocal.getInt(0);
	    
		    //Recherche tous les locaux
		    resultSetLocal = statement.executeQuery("select * from Local");
		    
		    for(i = 0; i < nombreLocaux; i++){
		    	resultSetLocal.next();
			
		    	Local localRemplisseur = new Local(resultSetLocal.getString("nom_local"));
		    	
		    	/** Ajoute les Routeurs au Local **/
		    	// Regarde le nombre de routeurs que le local contient
				resultSetRouteur = statement.executeQuery(new StringBuilder("select COUNT(*) from Routeur WHERE id_local = ").append(resultSetLocal.getInt("id_local")).toString());
				resultSetRouteur.next();
				nombreRouteurs = resultSetRouteur.getInt(0);
			    
			    //Recherche tous les routeurs présents dans le local
				resultSetRouteur = statement.executeQuery(new StringBuilder("select * from Routeur WHERE id_local = ").append(resultSetLocal.getInt("id_local")).toString());
			    
			    for(j = 0; j < nombreRouteurs; j++){
			    	resultSetRouteur.next();
			    	
			    	localRemplisseur.AjouterRouteur(resultSetRouteur.getString("nom_routeur"));
			    }
			    
			    /**Ajoute les Switchs au Local **/
			    //Regarde le nombre de routeurs que le local contient
				resultSetSwitch = statement.executeQuery(new StringBuilder("select COUNT(*) from Switch WHERE id_local = ").append(resultSetLocal.getInt("id_local")).toString());
				resultSetSwitch.next();
				nombreSwitchs = resultSetSwitch.getInt(0);
			    
			    //Recherche tous les routeurs présents dans le local
				resultSetSwitch = statement.executeQuery(new StringBuilder("select * from Switch WHERE id_local = ").append(resultSetLocal.getInt("id_local")).toString());
			    
			    for(j = 0; j < nombreSwitchs; j++){
			    	resultSetSwitch.next();
			    	
			    	localRemplisseur.AjouterSwitch(resultSetSwitch.getString("nom_switch"));
			    }
			    
			    /** Ajoute récursivement les Salles/Ordianteurs/Cartes réseaux et les Switchs potentiels**/
			    
			    //Regarde le nombre de salle que le local contient
				resultSetSalle = statement.executeQuery(new StringBuilder("select COUNT(*) from Salle WHERE id_local = ").append(resultSetLocal.getInt("id_local")).toString());
				resultSetSalle.next();
				nombreSalles = resultSetSalle.getInt(0);
			    
			    //Recherche toutes les salles présents dans le local
				resultSetSalle = statement.executeQuery(new StringBuilder("select * from Salle WHERE id_local = ").append(resultSetLocal.getInt("id_local")).toString());
			    
			    for(j = 0; j < nombreSalles; j++){
			    	resultSetSalle.next();
			    	
			    	Salle salleRemplisseur = new Salle(resultSetSalle.getString("nom_salle"));
			    	
			    	/** Ajoute les Routeurs à la salle **/
			    	//Regarde le nombre de routeurs que la salle contient
					resultSetRouteur = statement.executeQuery(new StringBuilder("select COUNT(*) from Routeur WHERE id_salle = ").append(resultSetSalle.getInt("id_salle")).toString());
					resultSetRouteur.next();
					nombreRouteurs = resultSetRouteur.getInt(0);
				    
				    //Recherche tous les routeurs présents dans le local
					resultSetRouteur = statement.executeQuery(new StringBuilder("select * from Routeur WHERE id_salle = ").append(resultSetSalle.getInt("id_salle")).toString());
				    
				    for(k = 0; k < nombreRouteurs; k++){
				    	resultSetRouteur.next();
				    	
				    	salleRemplisseur.AjouterRouteur(resultSetSwitch.getString("nom_routeur"));
				    }
				    	
				    /**Ajoute les Switchs à la salle **/
				    //Regarde le nombre de routeurs que le local contient
					resultSetSwitch = statement.executeQuery(new StringBuilder("select COUNT(*) from Switch WHERE id_salle = ").append(resultSetSalle.getInt("id_salle")).toString());
					resultSetSwitch.next();
					nombreSwitchs = resultSetSwitch.getInt(0);
				    
				    //Recherche tous les routeurs présents dans le local
					resultSetSwitch = statement.executeQuery(new StringBuilder("select * from Switch WHERE id_salle = ").append(resultSetSalle.getInt("id_salle")).toString());
				    
				    for(k = 0; k < nombreSwitchs; k++){
				    	resultSetSwitch.next();
				    	
				    	salleRemplisseur.AjouterSwitch(resultSetSwitch.getString("nom_switch"));
				    }
			    	
				    /** Ajoute les Ordinateurs aux salles **/
				    
				    resultSetOrdinateur = statement.executeQuery(new StringBuilder("select COUNT(*) from Ordinateur WHERE id_salle = ").append(resultSetSalle.getInt("id_salle")).toString());
			    	resultSetOrdinateur.next();
				    nombreOrdinateurs = resultSetOrdinateur.getInt(0);
				    
				    resultSetOrdinateur = statement.executeQuery(new StringBuilder("select * from Ordinateur WHERE id_salle = ").append(resultSetSalle.getInt("id_salle")).toString());
				    
				    for(l = 0; l < nombreOrdinateurs; l++){
				    	resultSetOrdinateur.next();
				    	
				    	Ordinateur ordinateurRemplisseur = new Ordinateur(resultSetOrdinateur.getString("nom_ordinateur"));
				    	
				    	/** Ajoute les Cartes réseau à l'ordinateur **/
				    	resultSetCarteReseau = statement.executeQuery(new StringBuilder("select COUNT(*) from Carte_reseau WHERE id_ordinateur = ").append(resultSetSwitch.getInt("id_ordinateur")).toString());
				    	resultSetCarteReseau.next();
					    nombreCarteReseaux = resultSetCarteReseau.getInt(0);
					    
					    resultSetCarteReseau = statement.executeQuery(new StringBuilder("select * from Carte_reseau WHERE id_ordinateur = ").append(resultSetSwitch.getInt("id_ordinateur")).toString());
					    
				    	for(m = 0; m < nombreCarteReseaux; m++){
				    		resultSetCarteReseau.next();
				    		
				    		//crée la carte réseau
				    		CarteReseau carteReseauRemplisseur = new CarteReseau(resultSetCarteReseau.getString("adresse_mac"));
				    		//ajoute la carte réseau à l'ordinateur
				    		ordinateurRemplisseur.AjouterCarteReseau(carteReseauRemplisseur);
				    	}
				    	
				    	salleRemplisseur.AjouterOrdinateur(ordinateurRemplisseur);
				    }
			    	
			    	localRemplisseur.AjouterSalle(salleRemplisseur);
			    }
			    
			    /** Ajoute le local au réseau physique **/
			    reseauPhysique.add(localRemplisseur);
		    }
	    
		}
		catch (Exception e){
			throw e;
		}
		
	}
	
}
