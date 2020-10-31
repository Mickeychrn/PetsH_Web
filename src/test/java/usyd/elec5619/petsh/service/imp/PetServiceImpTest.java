package usyd.elec5619.petsh.service.imp;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import usyd.elec5619.petsh.domain.Pet;

public class PetServiceImpTest extends TestCase{
	private PetServiceImp psi;
	private List<Pet> pets;
    private Pet pet;
	public static Long pet_Id = (long) 1;
    public static String name = "aname";
    public static String color = "acolor";
    public static double age = 1;
    public static String gender = "agender";
    public static String category = "acategory";
    public static String des = "ades";
    public static String url = "aurl";
	public static int count = 1;
	
	
	protected void setUp() throws Exception{
	     psi = new PetServiceImp ();  
	     pets = new ArrayList<Pet>();
	       
	     Pet pet = new Pet();
	     pet.setPetId(pet_Id);
	     pet.setPetAge(age);
	     pet.setPetColor(color);
	     pet.setPetDescription(des);
	     pet.setPetGender(gender);
	     pet.setPetName(name);
	     pet.setPetURL(url);

	     pets.add(pet);
	     //csi.addCommnet(Pet);
	     }
		
	public void testfindByUseId() {
		//List<Pet> Pets = this.PetService.getPetById(petId);
		//csi = new PetServiceImp();
	    //assertEquals(1,csi.getPetById(Pet.getPetId()).size());
	     	 	 
	}
	
	

}
