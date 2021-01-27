package usyd.elec5619.petsh.web;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import usyd.elec5619.petsh.domain.Comment;
import usyd.elec5619.petsh.domain.Forum;
import usyd.elec5619.petsh.domain.User;
import usyd.elec5619.petsh.service.CommentService;
import usyd.elec5619.petsh.service.ForumService;
import usyd.elec5619.petsh.service.UserService;
import usyd.elec5619.petsh.utils.ChangeDate;

@Controller("loginforum")
@RequestMapping(value = "/forum")
public class LoginForumController {

	@Resource
	UserService userService;

	@Resource
	ForumService forumService;
	
	@Resource
	CommentService commentService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView signinForum(@PathVariable("id") Long id, Model uiModel) {
		Map<String, Object> profileMap = new HashMap<String, Object>();
		User user = this.userService.getUserById(id);
		List<Forum> forums = this.forumService.allForums();
		profileMap.put("user", user);
		profileMap.put("forums", forums);
		return new ModelAndView("loginforum", "profileMap", profileMap);
	}
	
	
	@RequestMapping(value = "/{id}/searchbytitle",method = RequestMethod.POST)
	public ModelAndView searchbytitle(HttpServletRequest httpServletRequest,@PathVariable("id") Long id) {
		String title =httpServletRequest.getParameter("searchtitle");
		
		List<Forum> forums=this.forumService.searchForumsByTitle(title);
		
		User user = this.userService.getUserById(id);
		Map<String, Object> profileMap =new HashMap<String, Object>();
		
		profileMap.put("forums", forums);
		profileMap.put("user", user);
		return new ModelAndView("loginforum","profileMap",profileMap);
	}
	
	@RequestMapping(value = "/{id}/view/{forumId}", method = RequestMethod.GET)
	public ModelAndView signinForumView(@PathVariable("id") Long id, @PathVariable("forumId") Long forumId,Model uiModel) {
		Map<String, Object> profileMap = new HashMap<String, Object>();
		User user = this.userService.getUserById(id);
		Forum forum = this.forumService.getForumById(forumId);
		List<Comment> comments = this.commentService.getCommentById(forumId);
		profileMap.put("user", user);
		profileMap.put("forum", forum);
		profileMap.put("comments",comments);
		return new ModelAndView("loginforumview", "profileMap", profileMap);
	}

	@RequestMapping(value = "/{id}/add", method = RequestMethod.GET)
	public ModelAndView signinAddForum(@PathVariable("id") Long id, Model uiModel) {
		Map<String, Object> profileMap = new HashMap<String, Object>();
		User user = this.userService.getUserById(id);
		profileMap.put("user", user);
		return new ModelAndView("loginnewforum", "profileMap", profileMap);
	}
	
	
	@RequestMapping(value = "/{id}/addforum", method = RequestMethod.POST)
	public String signinNewForumAdd(@PathVariable("id")Long id,HttpServletRequest httpServletRequest) {

		User user = this.userService.getUserById(id);
		Forum forum= new Forum();
		forum.setForumTitle(httpServletRequest.getParameter("forumTitle"));
		forum.setForumContent(httpServletRequest.getParameter("forumContent"));
		forum.setUserId(id);
		forum.setUserName(user.getLastName()+" "+user.getFirstName());
		forum.setCreateTime(new ChangeDate(new Date()).toString());
		this.forumService.addForum(forum);
		
		return "redirect:/forum/"+user.getUserId();
	}
	
	@RequestMapping(value = "/{id}/view/{forumId}/addComment", method = RequestMethod.POST)
	public String signinForumComment(@PathVariable("id")Long id, @PathVariable("forumId") Long forumId,HttpServletRequest httpServletRequest) {

		User user = this.userService.getUserById(id);
		Comment comment= new Comment();
		comment.setUserId(user.getUserId());
		comment.setUserName(user.getFirstName()+" "+user.getLastName());
		comment.setUserURL(user.getUserPhoto());
		comment.setForumId(forumId);
		comment.setCommentDate(new ChangeDate(new Date()).toString());
		comment.setContent(httpServletRequest.getParameter("CommentContent"));
		this.commentService.addCommnet(comment);
		
		return "redirect:/forum/"+user.getUserId()+"/view/"+forumId;
	}

}
