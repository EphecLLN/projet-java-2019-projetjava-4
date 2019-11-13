package Login;

import javax.swing.JOptionPane;

public class Etu {
		 private String nom;
		 private String prenom;
		 private int matricule;
		 
		 
		 public Etu() {
			 this.nom = JOptionPane.showInputDialog("Entrez le prenom de l'élève");
			 this.prenom = JOptionPane.showInputDialog("Entrez le prénom de l'élève");
			 this.matricule = Integer.parseInt((JOptionPane.showInputDialog("Entrez le matricule")));
		 }
		 
		 public Etu(String nom, String prenom, int matricule) {
			 this.nom = nom;
			 this.prenom = prenom;
			 this.matricule = matricule;
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
		
		public int getMatricule() {
			return matricule;
		}
		
		public void setMatricule(int matricule) {
			this.matricule = matricule;
		}
		public String toString(){
			
			return ("Nom:"+ this.nom+"\n Prénom : "+this.prenom+"\n Matricule : "+ this.matricule);
			
		}
 
}
