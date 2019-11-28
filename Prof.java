package Login;

import javax.swing.JOptionPane;

public class Prof {
	private String nom;
	private String prenom;
	private String groupe;
	

	public Prof(){
		
		this.nom = JOptionPane.showInputDialog("Entrez le nom du prof");
		this.prenom = JOptionPane.showInputDialog("Entrez le prenom du prof");
		this.groupe  =JOptionPane.showInputDialog("Entrez le groupe du prof");
		
		
	}
	
	
	public Prof(String nom, String prenom, String groupe){
		
		this.nom = nom;
		this.prenom = prenom;
		this.groupe = groupe;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getSpecialite() {
		return groupe;
	}

	public void setSpecialite(String groupe) {
		this.groupe = groupe;
	}
	/**
	 * this method give a textual representation of the teacher;
	 */
	public String toString(){
		return ("nom : "+this.nom+"\nPrenom : "+this.prenom+"\n Groupe :"+this.groupe);
		
	}
	
	
}
