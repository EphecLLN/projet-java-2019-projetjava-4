package pack_classe;

import java.sql.ResultSet;
import donnees.Bdd;



public class Matiere{
	
private Bdd connexion;
	
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

public ResultSet listerMatieres(){				
		
connexion = new Bdd();	
connexion.etablirConnexion();
ResultSet jeuEnregistrements = connexion.lire("SELECT * FROM matieres");

return jeuEnregistrements;

}

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

public void ajouterMatiere(String nom,String credit){

	Bdd connexion = new Bdd();
connexion.etablirConnexion();
String requete = "INSERT INTO matieres(nom,credit) VALUES('"
		         +nom+"','"
		         +credit
		         +"')";	
connexion.mettreAJour(requete);
connexion.fermerConnexion();
		
}

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

public void modifierMatiere(String nom,String credit,String id){

	Bdd connexion = new Bdd();
connexion.etablirConnexion();
String requete = "UPDATE matieres SET "
			     +"nom='"+nom+"',"
			     +"credit='"+credit+"' "
			     +"WHERE ID_matiere='"+id+"'";	
connexion.mettreAJour(requete);
connexion.fermerConnexion();	
		
}

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

public void supprimerMatiere(String id){
	
	Bdd connexion = new Bdd();	
connexion.etablirConnexion();
String requete = "DELETE FROM matieres WHERE ID_matiere='"+id+"'";
connexion.mettreAJour(requete);
connexion.fermerConnexion();
		
}

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

public Bdd getConnexion(){
	
return connexion;	
	
}

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

}

