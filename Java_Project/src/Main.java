import java.util.ArrayList;

import Model.Gestion_base_de_donnee;
import Vue.ApplicationWindows;


public class Main {

	public static void main(String[] args) throws Exception {
		
		Gestion_base_de_donnee bdd;
		
		try{
		 bdd = new Gestion_base_de_donnee();
		bdd.populateApplication();
		}
		catch(Exception e){
			throw e;
		}
		
		ApplicationWindows window = new ApplicationWindows(bdd);
		window.setVisible(true);
		
	}

}
