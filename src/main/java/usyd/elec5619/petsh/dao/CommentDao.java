package usyd.elec5619.petsh.dao;

import java.util.List;

import usyd.elec5619.petsh.domain.Comment;



public interface CommentDao {

	public void addCommnet(Comment comment);

	public List<Comment> getCommentById(Long id);
}
