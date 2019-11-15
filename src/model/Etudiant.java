
import javax.swing.JOptionPane;
/**
 * This class represent a student
 * @author he201581
 *
 */

public class Etudiant {
	private String nom;
	private String prenom;
	private String adresse;
	private int numContact;
	private String groupeSanguin;
	private int matricule;
	private int anneeEtudes;
	private int joursAbsence;
	private int [] tableauNotes;
	

	public Etudiant(){
		
		this.nom = JOptionPane.showInputDialog("Entrez le nom de l'étudiant");
		this.prenom = JOptionPane.showInputDialog("Entrez le prénom de l'étudiant");
		this.adresse = JOptionPane.showInputDialog("Entrez son adresse");
		this.numContact = Integer.parseInt(JOptionPane.showInputDialog("Entrez son numero de téléphone de contact"));
		this.groupeSanguin = JOptionPane.showInputDialog("Entrez son groupe sanguin");
		this.matricule = Integer.parseInt(JOptionPane.showInputDialog("Entrez son matricule"));
		this.anneeEtudes = Integer.parseInt(JOptionPane.showInputDialog("Entrez son année d'études"));
		this.joursAbsence = Integer.parseInt(JOptionPane.showInputDialog("Entrez son nombre de jours d'absence"));
		
		
	}
	
	/**
	 * This constructor allows the user the create a teacher knowing his name, his forename, his adress, his telephone number, his sanguine group, his matricule and his year of studies
	 * @param nom
	 * @param prenom
	 * @param adresse
	 * @param numContact
	 * @param groupeSanguin
	 * @param matricule
	 * @param anneeEtudes
	 */
	
	public Prof(String nom, String prenom, String adresse, int numContact, String groupeSanguin, int matricule, int anneeEtudes){
		
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.numContact = numContact;
		this.groupeSanguin = groupeSanguin;
		this.matricule = matricule;
		this.anneeEtudes = anneeEtudes;
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

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public int getNumContact() {
		return numContact;
	}

	public void setNumContact(int numContact) {
		this.numContact = numContact;
	}
	
	public String getGroupeSanguin() {
		return getGroupeSanguin;
	}

	public void setGroupeSanguin(String groupeSanguin) {
		this.groupeSanguin = groupeSanguin;
	}
	
	public int getMatricule() {
		return matricule;
	}

	public void setMatricule(int matricule) {
		this.matricule = matricule;
	}
	
	public int getAnneeEtudes() {
		return anneeEtudes;
	}

	public void setAnneeEtudes(int anneeEtudes) {
		this.anneeEtudes = anneeEtudes;
	}
	/**
	 * this method give a textual representation of the student;
	 */
	public String toString(){
		return ("Nom : "+this.nom+"\nPrenom : "+this.prenom+"\n specialite :"+this.groupe);
		
	}
	/**
	*this method check different equality between different students
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