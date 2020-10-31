package usyd.elec5619.petsh.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import usyd.elec5619.petsh.dao.CommentDao;
import usyd.elec5619.petsh.domain.Comment;
import usyd.elec5619.petsh.service.CommentService;


@Service("CommentService")
@Transactional
public class CommentServiceImp implements CommentService {

	
	@Resource
	CommentDao commentDao;
	
	@Override
	public void addCommnet(Comment comment) {
		commentDao.addCommnet(comment);

	}

	@Override
	public List<Comment> getCommentById(Long id) {
		return commentDao.getCommentById(id);
	}

}
