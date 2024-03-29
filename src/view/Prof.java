package Console;

import javax.swing.JOptionPane;
/**
 * This class represent the teacher
 * @author he201575
 *
 */

public class Prof {
	private String nom;
	private String prenom;
	private String groupe;
	

	public Prof(){
		
		this.nom = JOptionPane.showInputDialog("Entrez le nom du prof");
		this.prenom = JOptionPane.showInputDialog("Entrez le prenom du prof");
		this.groupe  =JOptionPane.showInputDialog("Entrez le groupe du prof");
		
		
	}
	
	/**
	 * This constructor allows the user the create a teacher knowing his name, his forename, his group
	 * @param nom
	 * @param prenom
	 * @param groupe
	 */
	
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
		return ("Nom : "+this.nom+"\nPrenom : "+this.prenom+"\n specialite :"+this.groupe);
		
	}
	/**
	*this method check different equality between different teachers
	*/
	
	@Override
	public boolean equals(Object obj){
		if(this == obj) return true;
		if(obj == null) return false;
		if(this.getClass() != obj.getClass()) return false;
		Prof other = (Prof) obj;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		}
		
		return true;
}
	
	
}