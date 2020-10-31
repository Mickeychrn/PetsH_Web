package usyd.elec5619.petsh.domain;

import junit.framework.TestCase;

public class PetTest extends TestCase {
	
	private Pet pet;
	
	protected void setUp() throws Exception {
        pet = new Pet();
    }
	
	public void testSetAndGetPetId() {		
        assertNull(pet.getPetId());        
        Long testPetId = (long) 12321;
        pet.setPetId(testPetId);
        assertEquals(testPetId, pet.getPetId());
    }
	
	
	public void testSetAndGetPetName() {		
        assertNull(pet.getPetName());        
        String testPetName = "aaa";
        pet.setPetName(testPetName);
        assertEquals(testPetName, pet.getPetName());
    }
	
	
	public void testSetAndGetPetColor() {		
        assertNull(pet.getPetColor());        
        String testPetColor = "aaa";
        pet.setPetColor(testPetColor);
        assertEquals(testPetColor, pet.getPetColor());
    }

	
	public void testSetAndGetPetAge() {		
        assertNull(pet.getPetAge());        
        Double testPetAge = (double) 12321;
        pet.setPetAge(testPetAge);
        assertEquals(testPetAge, pet.getPetAge());
    }
	
	
	public void testSetAndGetPetGender() {		
        assertNull(pet.getPetGender());        
        String testPetGender = "aaa";
        pet.setPetGender(testPetGender);
        assertEquals(testPetGender, pet.getPetGender());
    }
	
	
	public void testSetAndGetPetCategory() {		
        assertNull(pet.getPetCategory());        
        String testPetCategory = "aaa";
        pet.setPetCategory(testPetCategory);
        assertEquals(testPetCategory, pet.getPetCategory());
    }
	
	
	public void testSetAndGetPetURL() {		
        assertNull(pet.getPetURL());        
        String testPetURL = "aaa";
        pet.setPetURL(testPetURL);
        assertEquals(testPetURL, pet.getPetURL());
    }
	
	
	public void testSetAndGetAdoptPersonId() {		
        assertNull(pet.getAdoptPersonId());        
        Long testAdoptPersonId = (long) 12321;
        pet.setAdoptPersonId(testAdoptPersonId);
        assertEquals(testAdoptPersonId, pet.getAdoptPersonId());
    }

	
	public void testSetAndGetAdoptTime() {		
        assertNull(pet.getAdoptTime());        
        String testAdoptTime = "aaa";
        pet.setAdoptTime(testAdoptTime);
        assertEquals(testAdoptTime, pet.getAdoptTime());
    }
}
