package usyd.elec5619.petsh.service;

import java.util.List;

import usyd.elec5619.petsh.domain.Pet;

public interface PetService {
	public List<Pet>  allPets();
	public Pet getPetById(Long id);
	public void addPet(Pet pet);
	public List<Pet> searchByColor(String color);
	public void updatePet(Pet pet);
	public List<Pet> unAdoptedPets();
	public List<Pet> getPetsByUserId(long userid);
	public void deletePet(long id);
}
