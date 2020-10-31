package usyd.elec5619.petsh.dao.imp;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Repository;

import usyd.elec5619.petsh.dao.UserDao;
import usyd.elec5619.petsh.domain.User;

@Repository("UserDao")
public class UserDaoImp implements UserDao {
	
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public List<User> getUserByEmail(String email) {
		String sql="select * FROM User where email=?";
		SQLQuery query =this.sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setParameter(0, email);
		query.addEntity(User.class);
		List<User> users = query.list();
		return users;
	}

	@Override
	public void addUser(User user) {
		this.sessionFactory.getCurrentSession().save(user);
		
	}

	@Override
	public User getUserById(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		User user = (User) session.get(User.class, id);
		return user;
	}

	@Override
	public void deleteUser(long id) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		User user = (User) currentSession.get(User.class, id);
		currentSession.delete(user);

		
	}

	@Override
	public void updateUser(User user) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		currentSession.merge(user);

		
	}

	@Override
	public List<User> getUsers() {
		List<User> list = this.sessionFactory.getCurrentSession().createQuery("FROM User").list();
		return list;
	}

}
