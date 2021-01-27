package usyd.elec5619.petsh.service;

import java.util.List;

import usyd.elec5619.petsh.domain.Forum;

public interface ForumService {
	
	public List<Forum>  allForums();
	
	public Forum getForumById(Long id);

	public void addForum(Forum forum);
	public List<Forum> searchForumsByTitle(String title);
	public List<Forum> forumCreateByUserId(long userid);
	public void deleteForum(long id);
	public void updateFroum(Forum forum);
	public List<Forum> searchMyForumsByTitle(String title,Long userId);
}
