package Console;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class ProfTest {
	
	Prof prof1, prof2, prof3;
	
	@Before
	public void setUp(){
		prof1 = new Prof("NomProf1", "PrenomProf1", "it");
		prof2 = new Prof("NomProf1", "PrenomProf1", "it");
		prof3 = new Prof("NomProf3", "PrenomProf3", "C");
		
		
		
	}
	@Test
	public void testToString() {
		Prof prof1 = new Prof("NomProf1", "PrenomProf1", "it");
		assertEquals("Nom : NomProf1\nPrenom : PrenomProf1\n specialite :it", prof1.toString());
		
	}
	
	@Test
	public void equals() {
		assertTrue(prof1.equals(prof2));
	}
	
	
		public void testEqualsObject(){
		assertFalse(prof1.equals(null));
		assertFalse(prof2.equals(null));
		assertFalse(prof3.equals(null));
		assertFalse(prof1.equals(prof2));
		assertFalse(prof2.equals(prof3));
		assertFalse(prof1.equals(prof3));
		assertTrue(prof1.equals(prof1));
		assertTrue(prof2.equals(prof2));
		assertTrue(prof3.equals(prof3)); 
		
	}

	

}
