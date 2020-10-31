package usyd.elec5619.petsh.dao.imp;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Repository;

import usyd.elec5619.petsh.dao.PetDao;
import usyd.elec5619.petsh.domain.Pet;

@Repository("PetDao")
public class PetDaoImp implements PetDao{
	
	@Resource
	private SessionFactory sessionFactory;
	
	@Override
	public List<Pet> allPets() {
		List<Pet> list = this.sessionFactory.getCurrentSession().createQuery("FROM Pet").list();
		return list;
	}

	@Override
	public Pet getPetById(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Pet pet = (Pet) session.get(Pet.class, id);
		return pet;
	}

	@Override
	public void addPet(Pet pet) {
		this.sessionFactory.getCurrentSession().save(pet);
		
	}

	@Override
	public List<Pet> searchByColor(String color) {
		
		
		String sql="select * from petsh.Pet where petColor =? and isAdopted =false";
		SQLQuery query =this.sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setParameter(0, color);
		query.addEntity(Pet.class);
		List<Pet> pets = query.list();
		
		return pets;
	}

	@Override
	public void updatePet(Pet pet) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		currentSession.merge(pet);
		
	}

	@Override
	public List<Pet> unAdoptedPets() {
		String sql="select * from petsh.Pet where isAdopted =0";
		SQLQuery query =this.sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.addEntity(Pet.class);
		List<Pet> pets = query.list();
		return pets;
	}

	@Override
	public List<Pet> getPetsByUserId(long userid) {
		String sql="select * from petsh.Pet where adoptPersonId =?";
		SQLQuery query =this.sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setParameter(0, userid);
		query.addEntity(Pet.class);
		List<Pet> pets = query.list();
		return pets;
	}

	@Override
	public void deletePet(long id) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		Pet pet = (Pet) currentSession.get(Pet.class, id);
		currentSession.delete(pet);
		
	}

}
