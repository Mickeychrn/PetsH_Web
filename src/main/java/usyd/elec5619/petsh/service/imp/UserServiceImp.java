package usyd.elec5619.petsh.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import usyd.elec5619.petsh.dao.UserDao;
import usyd.elec5619.petsh.domain.User;
import usyd.elec5619.petsh.service.UserService;


@Service("UserService")
@Transactional
public class UserServiceImp implements UserService {

	
	@Resource
	UserDao userDao;
	
	@Override
	public List<User> getUserByEmail(String email) {
		return userDao.getUserByEmail(email);
	}

	@Override
	public void addUser(User user) {
		userDao.addUser(user);
		
	}

	@Override
	public User getUserById(Long id) {
		return userDao.getUserById(id);
	}

	@Override
	public void deleteUser(long id) {
		userDao.deleteUser(id);
		
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
		
	}

	@Override
	public List<User> getUsers() {
		return userDao.getUsers();
	}
	
	
}
