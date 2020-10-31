package usyd.elec5619.petsh.dao;

import java.util.List;

import usyd.elec5619.petsh.domain.Pet;

public interface PetDao {
	public List<Pet> allPets();
	
	public List<Pet> unAdoptedPets();
	
	public Pet getPetById(Long id);
	
	public List<Pet> getPetsByUserId(long userid);
	
	public void addPet(Pet pet);
	
	public List<Pet> searchByColor(String color);
	
	public void updatePet(Pet pet);
	
	public void deletePet(long id);

}
