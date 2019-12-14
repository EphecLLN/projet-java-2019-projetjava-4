package pack_classe;

import java.sql.ResultSet;
import donnees.Bdd;



public class Etudiant{
	
private Bdd connexion;
	
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

public ResultSet listerEtudiants(){				
		
connexion = new Bdd();	
connexion.etablirConnexion();
ResultSet jeuEnregistrements = connexion.lire("SELECT * FROM etudiants");

return jeuEnregistrements;

}

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

public void ajouterEtudiant(String nom,String prenom,String dateNaissance){

	Bdd connexion = new Bdd();
connexion.etablirConnexion();
String requete = "INSERT INTO etudiants(nom,prenom,date_naissance) VALUES('"
		         +nom+"','"
		         +prenom+"','"
		         +dateNaissance
		         +"')";	
connexion.mettreAJour(requete);
connexion.fermerConnexion();
		
}

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

public void modifierEtudiant(String nom,String prenom,String dateNaissance,String id){

	Bdd connexion = new Bdd();
connexion.etablirConnexion();
String requete = "UPDATE etudiants SET "
			     +"nom='"+nom+"',"
			     +"prenom='"+prenom+"',"
			     +"date_naissance='"+dateNaissance+"' "
			     +"WHERE ID_etudiant='"+id+"'";	
connexion.mettreAJour(requete);
connexion.fermerConnexion();	
		
}

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

public void supprimerEtudiant(String id){
	
	Bdd connexion = new Bdd();	
connexion.etablirConnexion();
String requete = "DELETE FROM etudiants WHERE ID_etudiant='"+id+"'";
connexion.mettreAJour(requete);
connexion.fermerConnexion();
		
}

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

public ResultSet rechercherEtudiant(String nom){
	
connexion = new Bdd();
connexion.etablirConnexion();
String requete = "SELECT * FROM etudiants WHERE nom LIKE '%"+nom+"%'";
ResultSet jeuEnregistrements = connexion.lire(requete);

return jeuEnregistrements;
		
}

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

public Bdd getConnexion(){
	
return connexion;	
	
}

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

}

