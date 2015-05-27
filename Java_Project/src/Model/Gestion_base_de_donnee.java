package Model;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


public class Gestion_base_de_donnee {
	
	private Connection connect = null;
	
	// Il faut un statement par requête sinon lors de sa fermeture, le programme va crasher
	private Statement statement1 = null;
	private Statement statement2 = null;
	private Statement statement3 = null;
	private Statement statement4 = null;
	private Statement statement5 = null;
	private Statement statement6 = null;
	private Statement statement7 = null;
	private Statement statement8 = null;
	
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
			connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root","projetWeb");
			statement1 = (Statement) connect.createStatement();
			statement2 = (Statement) connect.createStatement();
			statement3 = (Statement) connect.createStatement();
			statement4 = (Statement) connect.createStatement();
			statement5 = (Statement) connect.createStatement();
			statement6 = (Statement) connect.createStatement();
			statement7 = (Statement) connect.createStatement();
			statement8 = (Statement) connect.createStatement();
		}
		catch(Exception e){
			throw e;
		}
	}
	
	public void populateApplication() throws Exception{
		try{
		//ArrayList du réseau logique
		populateReseauLogique();
		
		//ferme les statements
		if (statement1 != null) { statement1.close(); }
		if (statement2 != null) { statement2.close(); }
		if (statement3 != null) { statement3.close(); }
		if (statement4 != null) { statement4.close(); }
		if (statement5 != null) { statement5.close(); }
		if (statement6 != null) { statement6.close(); }
		if (statement7 != null) { statement7.close(); }
		if (statement8 != null) { statement8.close(); }
		
		//Puis les rouvre
		statement1 = (Statement) connect.createStatement();
		statement2 = (Statement) connect.createStatement();
		statement3 = (Statement) connect.createStatement();
		statement4 = (Statement) connect.createStatement();
		statement5 = (Statement) connect.createStatement();
		statement6 = (Statement) connect.createStatement();
		statement7 = (Statement) connect.createStatement();
		statement8 = (Statement) connect.createStatement();
		
		//ArrayList du réseau logique
		populateReseauPhysique();
		}
		catch(Exception e){
			throw e;
		}
		finally{
			//On ferme toutes les connexions
			if (statement1 != null) { statement1.close(); }
			if (statement2 != null) { statement2.close(); }
			if (statement3 != null) { statement3.close(); }
			if (statement4 != null) { statement4.close(); }
			if (statement5 != null) { statement5.close(); }
			if (statement6 != null) { statement6.close(); }
			if (statement7 != null) { statement7.close(); }
			if (statement8 != null) { statement8.close(); }
		}
	}
	
	private void populateReseauLogique() throws Exception{
		try{
			int i, j, k, l;
			int nombreRouteurs, nombreSwitchs, nombreOrdinateurs, nombreCarteReseaux;
			int id; // permettra de stocker les identifiants
			ResultSet resultSetRouteur;
			ResultSet resultSetSwitch;
			ResultSet resultSetOrdinateur;
			ResultSet resultSetCarteReseau;
			
		    //Regarde le nombre de Routeurs pour ensuite faire des boucles imbriquées.
			//v2:  WHERE id_switch = 0
			resultSetRouteur = statement1.executeQuery("select COUNT(*) from Routeur");
			resultSetRouteur.next();
		    nombreRouteurs = resultSetRouteur.getInt(1);
		    
		    //Recherche tous les Routeurs
		    resultSetRouteur = statement1.executeQuery("select * from Routeur");
		    
		    for(i = 0; i < nombreRouteurs; i++){
		    	resultSetRouteur.next();
		    	
		    	Routeur routeurRemplisseur = new Routeur(resultSetRouteur.getString("nom_routeur"), resultSetRouteur.getBoolean("statut"));
		    	
		    	id = resultSetRouteur.getInt("id_routeur");
		    	
		    	//recherche le nombre de switchs connecté au routeur
		    	resultSetSwitch = statement2.executeQuery(new StringBuilder("select COUNT(*) from Switch WHERE id_routeur = ").append(id).toString());
			    resultSetSwitch.next();
			    nombreSwitchs = resultSetSwitch.getInt(1);
			    
			    resultSetSwitch = statement2.executeQuery(new StringBuilder("select * from Switch WHERE id_routeur = ").append(id).toString());
			    
			    for(j = 0; j < nombreSwitchs; j++){
			    	resultSetSwitch.next();
			    	
			    	Switch switchRemplisseur = new Switch(resultSetSwitch.getString("nom_switch"), resultSetSwitch.getBoolean("statut"));
			    	
			    	id = resultSetSwitch.getInt("id_switch");
			    	
			    	resultSetOrdinateur = statement3.executeQuery(new StringBuilder("select COUNT(*) from Ordinateur WHERE id_switch = ").append(id).toString());
			    	resultSetOrdinateur.next();
				    nombreOrdinateurs = resultSetOrdinateur.getInt(1);
				    
				    resultSetOrdinateur = statement3.executeQuery(new StringBuilder("select * from Ordinateur WHERE id_switch = ").append(id).toString());
				    
				    for(k = 0; k < nombreOrdinateurs; k++){
				    	resultSetOrdinateur.next();
				    	
				    	Ordinateur ordinateurRemplisseur = new Ordinateur(resultSetOrdinateur.getString("nom_ordinateur"), resultSetOrdinateur.getBoolean("statut"));
				    	
				    	id = resultSetOrdinateur.getInt("id_ordinateur");
				    	
				    	resultSetCarteReseau = statement4.executeQuery(new StringBuilder("select COUNT(*) from Carte_reseau WHERE id_ordinateur = ").append(id).toString());
				    	resultSetCarteReseau.next();
					    nombreCarteReseaux = resultSetCarteReseau.getInt(1);
					    
					    resultSetCarteReseau = statement4.executeQuery(new StringBuilder("select * from Carte_reseau WHERE id_ordinateur = ").append(id).toString());
					    
				    	for(l = 0; l < nombreCarteReseaux; l++){
				    		resultSetCarteReseau.next();
				    		
				    		//crée la carte réseau
				    		CarteReseau carteReseauRemplisseur = new CarteReseau(resultSetCarteReseau.getString("adresse_mac"), resultSetCarteReseau.getBoolean("statut"));
				    		//ajoute la carte réseau à l'ordinateur
				    		ordinateurRemplisseur.AjouterCarteReseau(carteReseauRemplisseur);
				    	}
				    	
				    	//ajoute l'ordinateur au switch
				    	switchRemplisseur.AjouterOrdinateur(ordinateurRemplisseur);
				    }
				    
				    //ajoute le switch au routeur
				    routeurRemplisseur.AjouterSwitch(switchRemplisseur);
			    }
			    
			    id = resultSetRouteur.getInt("id_routeur");
			    //ajoute les cartes réseaux du routeur
			    resultSetCarteReseau = statement5.executeQuery(new StringBuilder("select COUNT(*) from Carte_reseau WHERE id_routeur = ").append(id).toString());
			    resultSetCarteReseau.next();
			    nombreCarteReseaux = resultSetCarteReseau.getInt(1);
			    
			    resultSetCarteReseau = statement5.executeQuery(new StringBuilder("select * from Carte_reseau WHERE id_routeur = ").append(id).toString());
			    
		    	for(l = 0; l < nombreCarteReseaux; l++){
		    		resultSetCarteReseau.next();
		    		
		    		//crée la carte réseau
		    		CarteReseau carteReseauRemplisseur = new CarteReseau(resultSetCarteReseau.getString("adresse_mac"), resultSetCarteReseau.getBoolean("statut"));
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
		int id;
		ResultSet resultSetLocal;
		ResultSet resultSetSalle;
		ResultSet resultSetRouteur;
		ResultSet resultSetSwitch;
		ResultSet resultSetOrdinateur;
		ResultSet resultSetCarteReseau;
		
		try{
		//Regarde le nombre de locaux pour ensuite faire des boucles imbriquées.
		resultSetLocal = statement1.executeQuery("select COUNT(*) from Local");
		resultSetLocal.next();
		nombreLocaux = resultSetLocal.getInt(1);
	    
		    //Recherche tous les locaux
		    resultSetLocal = statement1.executeQuery("select * from Local");
		    
		    for(i = 0; i < nombreLocaux; i++){
		    	resultSetLocal.next();
			
		    	Local localRemplisseur = new Local(resultSetLocal.getString("nom_local"), resultSetLocal.getBoolean("statut"));
		    	
		    	/** Ajoute les Routeurs au Local **/
		    	
		    	id = resultSetLocal.getInt("id_local");
		    	
		    	// Regarde le nombre de routeurs que le local contient
				resultSetRouteur = statement2.executeQuery(new StringBuilder("select COUNT(*) from Routeur WHERE id_local = ").append(id).toString());
				resultSetRouteur.next();
				nombreRouteurs = resultSetRouteur.getInt(1);
			    
			    //Recherche tous les routeurs présents dans le local
				resultSetRouteur = statement2.executeQuery(new StringBuilder("select * from Routeur WHERE id_local = ").append(id).toString());
			    
			    for(j = 0; j < nombreRouteurs; j++){
			    	resultSetRouteur.next();
			    	
			    	/** Populate le réseau physique avec le réseau logique **/
			    	for(int a = 0; a < reseauLogique.size(); a++){
			    		if(reseauLogique.get(a).getNomRouteur().equals((resultSetRouteur).getString("nom_routeur"))){
			    			localRemplisseur.AjouterRouteur(reseauLogique.get(a));
			    		}
			    	}
			    }
			    
			    /**Ajoute les Switchs au Local **/
			    
			    id = resultSetLocal.getInt("id_local");
			    
			    //Regarde le nombre de routeurs que le local contient
				resultSetSwitch = statement3.executeQuery(new StringBuilder("select COUNT(*) from Switch WHERE id_local = ").append(id).toString());
				resultSetSwitch.next();
				nombreSwitchs = resultSetSwitch.getInt(1);
			    
			    //Recherche tous les routeurs présents dans le local
				resultSetSwitch = statement3.executeQuery(new StringBuilder("select * from Switch WHERE id_local = ").append(id).toString());
			    
				/** Ajoute les switchs précédemment crée dans le réseau logique **/
			    for(j = 0; j < nombreSwitchs; j++){
			    	resultSetSwitch.next();
			    	
			    	for(int a = 0; a < reseauLogique.size(); a++){
			    		for(Switch switchR : reseauLogique.get(a).getListeSwitch()){
			    			if(switchR.getNomSwitch().equals((resultSetSwitch).getString("nom_switch"))){
				    			localRemplisseur.AjouterSwitch(switchR);
				    		}
			    		}
			    	}
			    }
			    
			    /** Ajoute récursivement les Salles/Ordianteurs/Cartes réseaux et les Switchs potentiels**/
			    
			    id = resultSetLocal.getInt("id_local");
			    
			    //Regarde le nombre de salle que le local contient
				resultSetSalle = statement4.executeQuery(new StringBuilder("select COUNT(*) from Salle WHERE id_local = ").append(id).toString());
				resultSetSalle.next();
				nombreSalles = resultSetSalle.getInt(1);
			    
			    //Recherche toutes les salles présents dans le local
				resultSetSalle = statement4.executeQuery(new StringBuilder("select * from Salle WHERE id_local = ").append(id).toString());
			    
			    for(j = 0; j < nombreSalles; j++){
			    	resultSetSalle.next();
			    	
			    	Salle salleRemplisseur = new Salle(resultSetSalle.getString("nom_salle"), resultSetSalle.getBoolean("statut"));
			    	
			    	/** Ajoute les Routeurs à la salle **/
			    	
			    	id = resultSetSalle.getInt("id_salle");
			    	
			    	//Regarde le nombre de routeurs que la salle contient
					resultSetRouteur = statement5.executeQuery(new StringBuilder("select COUNT(*) from Routeur WHERE id_salle = ").append(id).toString());
					resultSetRouteur.next();
					nombreRouteurs = resultSetRouteur.getInt(1);
				    
				    //Recherche tous les routeurs présents dans le local
					resultSetRouteur = statement5.executeQuery(new StringBuilder("select * from Routeur WHERE id_salle = ").append(id).toString());
				    
				    for(k = 0; k < nombreRouteurs; k++){
				    	resultSetRouteur.next();
				    	
				    	/** Populate le réseau physique avec le réseau logique **/
				    	for(int a = 0; a < reseauLogique.size(); a++){
				    		if(reseauLogique.get(a).getNomRouteur().equals((resultSetRouteur).getString("nom_routeur"))){
				    			salleRemplisseur.AjouterRouteur(reseauLogique.get(a));
				    		}
				    	}
				    }
				    	
				    /**Ajoute les Switchs à la salle **/
				    
				    id = resultSetSalle.getInt("id_salle");
				    //Regarde le nombre de routeurs que le local contient
					resultSetSwitch = statement6.executeQuery(new StringBuilder("select COUNT(*) from Switch WHERE id_salle = ").append(id).toString());
					resultSetSwitch.next();
					nombreSwitchs = resultSetSwitch.getInt(1);
				    
				    //Recherche tous les routeurs présents dans le local
					resultSetSwitch = statement6.executeQuery(new StringBuilder("select * from Switch WHERE id_salle = ").append(id).toString());
				    
				    for(k = 0; k < nombreSwitchs; k++){
				    	resultSetSwitch.next();
				    	
						/** Ajoute les switchs précédemment crée dans le réseau logique **/
					    for(j = 0; j < nombreSwitchs; j++){
					    	resultSetSwitch.next();
					    	
					    	for(int a = 0; a < reseauLogique.size(); a++){
					    		for(Switch switchR : reseauLogique.get(a).getListeSwitch()){
					    			if(switchR.getNomSwitch().equals((resultSetSwitch).getString("nom_switch"))){
						    			salleRemplisseur.AjouterSwitch(switchR);
						    		}
					    		}
					    	}
					    }
				    }
			    	
				    /** Ajoute les Ordinateurs aux salles **/
				    
				    id = resultSetSalle.getInt("id_salle");
				    
				    resultSetOrdinateur = statement7.executeQuery(new StringBuilder("select COUNT(*) from Ordinateur WHERE id_salle = ").append(id).toString());
			    	resultSetOrdinateur.next();
				    nombreOrdinateurs = resultSetOrdinateur.getInt(1);
				    
				    resultSetOrdinateur = statement7.executeQuery(new StringBuilder("select * from Ordinateur WHERE id_salle = ").append(id).toString());
				    
				    for(l = 0; l < nombreOrdinateurs; l++){
				    	resultSetOrdinateur.next();
				    	
				    	Ordinateur ordinateurRemplisseur = new Ordinateur(resultSetOrdinateur.getString("nom_ordinateur"), resultSetOrdinateur.getBoolean("statut"));
				    	
				    	/** Ajoute les Cartes réseau à l'ordinateur **/
				    	
				    	id = resultSetOrdinateur.getInt("id_ordinateur");
				    	
				    	resultSetCarteReseau = statement8.executeQuery(new StringBuilder("select COUNT(*) from Carte_reseau WHERE id_ordinateur = ").append(id).toString());
				    	resultSetCarteReseau.next();
					    nombreCarteReseaux = resultSetCarteReseau.getInt(1);
					    
					    resultSetCarteReseau = statement8.executeQuery(new StringBuilder("select * from Carte_reseau WHERE id_ordinateur = ").append(id).toString());
					    
				    	for(m = 0; m < nombreCarteReseaux; m++){
				    		resultSetCarteReseau.next();
				    		
				    		//crée la carte réseau
				    		CarteReseau carteReseauRemplisseur = new CarteReseau(resultSetCarteReseau.getString("adresse_mac"), resultSetCarteReseau.getBoolean("statut"));
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
