import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

class CoursTest {

	@Test
	void testToString() {
		Cours cours = new Cours("Gilles","Timothy","4","Mathematique","L10");
		assertEquals("Professeur : Gilles Timothy, Intitulé : Mathematique, Local : L10", cours.toString());		
	}
	
	@Test
	void testGetIntitule() {
		Cours cours = new Cours("Gilles","Timothy","4","Mathematique","L10");
		assertTrue(cours.getIntitule() == "Mathematique");
	}

}
