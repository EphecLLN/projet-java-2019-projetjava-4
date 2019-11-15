public class Cours extends Prof {
		
		private String intitule;
		private String local;
		
		/**
		 * construit un cours compos� d'un professeur, un intitul� et un local
		 * @param intitule l'intitul� du cours
		 * @param local le local ou se d�roule le cours
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
			return "Professeur : " + super.getNom() + " " + super.getPrenom() + ", Intitul� : " + this.intitule + ", Local : " + this.local;
		}
		
}
