package usyd.elec5619.petsh.web;

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
import usyd.elec5619.petsh.service.CommentService;
import usyd.elec5619.petsh.service.ForumService;

@Controller("logoutforum")
@RequestMapping(value = "/forum")
public class LogOutForumController {
	
	@Resource
	private ForumService forumService;
	
	@Resource
	private CommentService commentService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView AdoptPage() {
		List<Forum> forumList=this.forumService.allForums();
		Map<String, Object> uiModel =new HashMap<String, Object>();
		uiModel.put("forumList", forumList);
		return new ModelAndView("logoutforum","uiModel",uiModel);
	}
	
	
	@RequestMapping(value = "/view/{id}",method = RequestMethod.GET)
	public ModelAndView showforum(@PathVariable("id")Long id, Model uiModel) {
		
		Forum forum  = this.forumService.getForumById(id);
		Map<String, Object> forumModel =new HashMap<String, Object>();
		List<Comment> comments = this.commentService.getCommentById(id);
		forumModel.put("forum", forum);
		forumModel.put("comments", comments);
		return new ModelAndView("logoutforumview","forumModel",forumModel);
	}
	
	
	
	@RequestMapping(value = "/searchbytitle",method = RequestMethod.POST)
	public ModelAndView searchbytitle(HttpServletRequest httpServletRequest) {
		String title =httpServletRequest.getParameter("title");
		List<Forum> forumList=this.forumService.searchForumsByTitle(title);
		for (Forum forum : forumList) {
			System.out.println(forum.toString());
		}
		Map<String, Object> uiModel =new HashMap<String, Object>();
		uiModel.put("forumList", forumList);
		return new ModelAndView("logoutforum","uiModel",uiModel);
	}

}
