package usyd.elec5619.petsh.dao.imp;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Repository;

import usyd.elec5619.petsh.dao.ForumDao;
import usyd.elec5619.petsh.domain.Forum;

@Repository("ForumDao")
public class ForumDaoImp implements ForumDao{
	
	
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public List<Forum> allForums() {
		List<Forum> list = this.sessionFactory.getCurrentSession().createQuery("FROM Forum").list();
		return list;
	}

	@Override
	public Forum getForumById(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Forum forum = (Forum) session.get(Forum.class, id);
		return forum;
			
		}

	@Override
	public void addForum(Forum forum) {
		this.sessionFactory.getCurrentSession().save(forum);
		
	}

	@Override
	public List<Forum> searchForumsByTitle(String title) {
		String sql="select * from petsh.Forum where forumTitle like ?";
		SQLQuery query =this.sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setParameter(0, "%"+title+"%");
		query.addEntity(Forum.class);
		List<Forum> forums = query.list();
		return forums;
	}

	@Override
	public List<Forum> forumCreateByUserId(long userid) {
		String sql="select * from petsh.Forum where userId =?";
		SQLQuery query =this.sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setParameter(0, userid);
		query.addEntity(Forum.class);
		List<Forum> forums = query.list();
		return forums;
	}

	@Override
	public void deleteForum(long id) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		Forum forum = (Forum) currentSession.get(Forum.class, id);
		currentSession.delete(forum);
		
		
	}
	

}
