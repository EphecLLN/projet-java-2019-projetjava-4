import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class EtudiantTest {
	
	Etudiant etu1, etu2, etu3;
	
	@Before
	public void setUp(){
		etu1 = new Etudiant("Nom1", "Prenom1", "bla", "12", "B+", "10", "1");
		etu2 = new Etudiant("Nom2", "Prenom2", "lln", "14", "A-", "14", "2");
		etu3 = new Etudiant("Nom3", "Prenom3", "bxl", "19", "O+", "18", "3");
		
			
	@Test
	public void equals() {
		assertTrue(etu1.equals(etu2));
	}
	
	
		public void testEqualsObject(){
		assertFalse(etu1.equals(null));
		assertFalse(etu2.equals(null));
		assertFalse(etu3.equals(null));
		assertFalse(etu1.equals(etu2));
		assertFalse(etu2.equals(etu3));
		assertFalse(etu1.equals(etu3));
		assertTrue(etu1.equals(etu1));
		assertTrue(etu2.equals(etu2));
		assertTrue(etu3.equals(etu3)); 
		
	}

	

}
