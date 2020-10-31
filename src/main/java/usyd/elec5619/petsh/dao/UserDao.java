package usyd.elec5619.petsh.dao;

import java.util.List;

import usyd.elec5619.petsh.domain.User;

public interface UserDao {
	public List<User> getUserByEmail(String email);
	
	public void addUser(User user) ; 
	
	public User getUserById(Long id);
	
	public void deleteUser(long id);
	public void updateUser(User user);
	public List<User> getUsers();
}
