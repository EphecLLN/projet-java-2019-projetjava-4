public class Cours extends Prof {
		
		private String intitule;
		private String local;
		
		/**
		 * construit un cours composé d'un professeur, un intitulé et un local
		 * @param intitule l'intitulé du cours
		 * @param local le local ou se déroule le cours
		 */
		public Cours(String nom, String prenom, String groupe, String intitule, String local) {
			
			super(nom,prenom,groupe);
			this.intitule = intitule;
			this.local = local;
			
		}

		public String getIntitule() {
			return intitule;
		}

		public void setIntitule(String intitule) {
			this.intitule = intitule;
		}

		public String getLocal() {
			return local;
		}

		public void setLocal(String local) {
			this.local = local;
		}
		
		public String toString() {
			return "Professeur : " + super.getNom() + " " + super.getPrenom() + ", Intitulé : " + this.intitule + ", Local : " + this.local;
		}
		
}
