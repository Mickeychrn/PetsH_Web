package usyd.elec5619.petsh.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import usyd.elec5619.petsh.dao.PetDao;
import usyd.elec5619.petsh.domain.Pet;
import usyd.elec5619.petsh.service.PetService;

@Service("PetService")
@Transactional
public class PetServiceImp implements PetService{

	@Resource
	PetDao petDao;
	
	@Override
	public List<Pet> allPets() {
		return petDao.allPets();
	}

	@Override
	public Pet getPetById(Long id) {
		// TODO Auto-generated method stub
		return petDao.getPetById(id);
	}

	@Override
	public void addPet(Pet pet) {
		petDao.addPet(pet);
		
	}

	@Override
	public List<Pet> searchByColor(String color) {
		return petDao.searchByColor(color);
	}

	@Override
	public void updatePet(Pet pet) {
		petDao.updatePet(pet);
		
	}

	@Override
	public List<Pet> unAdoptedPets() {
		return petDao.unAdoptedPets();
	}

	@Override
	public List<Pet> getPetsByUserId(long userid) {
		return petDao.getPetsByUserId(userid);
	}

	@Override
	public void deletePet(long id) {
		petDao.deletePet(id);
		
	}

}
