public class Etudiant {
	/**
	 * The name of the student
	 */
	private String nom;
	/** 
	 * Forename of student
	 */
	private String prenom;
	/**
	 * Student ID
	 */
	private int matricule;
	Date naissance;
	
	/**
	 * Constructor that creates a student using the name, forename and ID.
	 * @param nom name of student
	 * @param prenom forename of student
	 * @param matricule ID of the student
	 */

	
	public Etudiant(String nom, String prenom, int matricule, Date naissance) {
		this.nom = nom;
		this.prenom = prenom;
		this.matricule = matricule;
		this.naissance = naissance;
	}