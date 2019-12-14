package pack_classe;

import java.sql.ResultSet;
import donnees.Bdd;



public class Note{
	
private Bdd connexion;

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

public ResultSet listerNotes(String idEtudiant){				
		
connexion = new Bdd();	
connexion.etablirConnexion();
String requete = "SELECT nom,valeur FROM matieres,notes WHERE ID_etudiant='"
	             +idEtudiant+"' "
	             +"AND matieres.ID_matiere=notes.ID_matiere ORDER BY nom";
ResultSet jeuEnregistrements = connexion.lire(requete);

return jeuEnregistrements;

}

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

public ResultSet calculerMoyennesMatieres(String idEtudiant){				
		
connexion = new Bdd();	
connexion.etablirConnexion();
String requete = "SELECT nom,AVG(valeur),credit,AVG(valeur)*credit "
	             +"FROM matieres,notes WHERE ID_etudiant='"
	             +idEtudiant+"' "
	             +"AND matieres.ID_matiere=notes.ID_matiere "
	             +"GROUP BY nom";
ResultSet jeuEnregistrements = connexion.lire(requete);

return jeuEnregistrements;

}

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

public ResultSet calculerMoyenneGenerale(String idEtudiant){				
		
connexion = new Bdd();	
connexion.etablirConnexion();
String requete = "SELECT AVG(valeur)*credit,credit "
		             +"FROM matieres,notes WHERE ID_etudiant='"
		             +idEtudiant+"' "
		             +"AND matieres.ID_matiere=notes.ID_matiere "
		             +"GROUP BY nom";
ResultSet jeuEnregistrements = connexion.lire(requete);

return jeuEnregistrements;

}

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

public void ajouterNote(String idEtudiant,String idMatiere,String valeur){

	Bdd connexion = new Bdd();
connexion.etablirConnexion();
String requete = "INSERT INTO notes(ID_etudiant,ID_matiere,valeur) VALUES('"
		         +idEtudiant+"','"
		         +idMatiere+"','"
		         +valeur
		         +"')";	
connexion.mettreAJour(requete);
connexion.fermerConnexion();
		
}

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

public void supprimerNote(String idEtudiant,String idMatiere,String valeur){
	
	Bdd connexion = new Bdd();	
connexion.etablirConnexion();
String requete = "DELETE FROM notes WHERE ID_etudiant='"+idEtudiant+"' "
                 +"AND ID_matiere='"+idMatiere+"' "
                 +"AND valeur='"+valeur+"'";
connexion.mettreAJour(requete);
connexion.fermerConnexion();
		
}

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

public Bdd getConnexion(){
	
return connexion;	
	
}

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

}
