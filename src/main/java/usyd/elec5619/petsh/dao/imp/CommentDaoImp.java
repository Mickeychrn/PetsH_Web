package usyd.elec5619.petsh.dao.imp;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import usyd.elec5619.petsh.dao.CommentDao;
import usyd.elec5619.petsh.domain.Comment;


@Repository("CommentDao")
public class CommentDaoImp implements CommentDao {
	

	@Resource
	private SessionFactory sessionFactory;

	@Override
	public void addCommnet(Comment comment) {
		this.sessionFactory.getCurrentSession().save(comment);
		
	}

	@Override
	public List<Comment> getCommentById(Long id) {
		String sql="select * FROM Comment where forumId=?";
		SQLQuery query =this.sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setParameter(0, id);
		query.addEntity(Comment.class);
		List<Comment> commentList = query.list();
		
		return commentList;
	}

}
