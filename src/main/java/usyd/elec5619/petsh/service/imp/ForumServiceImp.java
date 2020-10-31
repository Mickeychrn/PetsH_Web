package usyd.elec5619.petsh.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import usyd.elec5619.petsh.dao.ForumDao;
import usyd.elec5619.petsh.domain.Forum;
import usyd.elec5619.petsh.service.ForumService;


@Service("ForumService")
@Transactional
public class ForumServiceImp implements ForumService{

	@Resource
	ForumDao forumDao;
	
	@Override
	public List<Forum> allForums() {
		return forumDao.allForums();
	}

	@Override
	public Forum getForumById(Long id) {
		return forumDao.getForumById(id);
	}

	@Override
	public void addForum(Forum forum) {
		forumDao.addForum(forum);
		
	}

	@Override
	public List<Forum> searchForumsByTitle(String title) {
		return forumDao.searchForumsByTitle(title);
	}

	@Override
	public List<Forum> forumCreateByUserId(long userid) {
		return forumDao.forumCreateByUserId(userid);
	}

	@Override
	public void deleteForum(long id) {
		forumDao.deleteForum(id);
		
	}

}
