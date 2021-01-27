package usyd.elec5619.petsh.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;

import usyd.elec5619.petsh.domain.Forum;
import usyd.elec5619.petsh.domain.Pet;
import usyd.elec5619.petsh.domain.User;
import usyd.elec5619.petsh.service.ForumService;
import usyd.elec5619.petsh.service.PetService;
import usyd.elec5619.petsh.service.UserService;
import usyd.elec5619.petsh.utils.UploadPhoto;

@Controller("loginprofile")
@RequestMapping(value = "/profile")
public class LoginProfileController {
	
	@Resource
	UserService UserService;
	
	@Resource
	ForumService forumService;
	
	@Resource
	PetService PetService;
	
	User user;
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public ModelAndView loginProfile(@PathVariable("id")Long id, Model uiModel) {
		Map<String, Object> profileMap = new HashMap<String, Object>();
		user=this.UserService.getUserById(id);
		List<Forum> myforums = this.forumService.forumCreateByUserId(user.getUserId());
		List<Pet> mypets=PetService.getPetsByUserId(user.getUserId());
		
		profileMap.put("myforums", myforums);
		profileMap.put("mypets",mypets);
		profileMap.put("user", user);
		return new ModelAndView("loginprofile","profileMap",profileMap);
	}
	
	
	@RequestMapping(value = "/{id}/myPostdetail/{postId}",method = RequestMethod.GET)
	public ModelAndView myPostdetail(@PathVariable("id")Long id,@PathVariable("postId")Long postId, Model uiModel) {
		Map<String, Object> profileMap = new HashMap<String, Object>();
		Forum myforums =this.forumService.getForumById(postId);
		user=this.UserService.getUserById(id);
		profileMap.put("myforums", myforums);
		profileMap.put("user", user);
		return new ModelAndView("loginprofileupdate","profileMap",profileMap);
	}
	
	@RequestMapping(value = "/{id}/mypostsearch",method = RequestMethod.POST)
	public ModelAndView myPostSearch(@PathVariable("id")Long id, Model uiModel,HttpServletRequest httpServletRequest) {
		String searchvalue =httpServletRequest.getParameter("searchvalue");
		user=this.UserService.getUserById(id);
		Map<String, Object> profileMap = new HashMap<String, Object>();
		List<Forum> myforums =this.forumService.searchMyForumsByTitle(searchvalue, id);
		
		profileMap.put("myforums", myforums);
		profileMap.put("user", user);
		return new ModelAndView("loginprofilesearch","profileMap",profileMap);
	}
	
	@RequestMapping(value = "/{id}/myPostUpdate/{postId}",method = RequestMethod.POST)
	public ModelAndView myPostUpdate(@PathVariable("id")Long id,@PathVariable("postId")Long postId, Model uiModel,HttpServletRequest httpServletRequest) {
		String forumTitle =httpServletRequest.getParameter("forumTitle");
		String forumContent  =httpServletRequest.getParameter("forumContent");
		
		Forum forum =this.forumService.getForumById(postId);
		forum.setForumTitle(forumTitle);
		forum.setForumContent(forumContent);
		this.forumService.updateFroum(forum);
		
		
		user=this.UserService.getUserById(id);
		return new ModelAndView("redirect:/profile/"+user.getUserId());
	}
	
	
	@RequestMapping(value = "/{id}/deletemypost/{postId}",method = RequestMethod.GET)
	public ModelAndView deleteMyPost(@PathVariable("id")Long id,@PathVariable("postId")Long postId, Model uiModel) {
		
		this.forumService.deleteForum(postId);
		user=this.UserService.getUserById(id);
		return new ModelAndView("redirect:/profile/"+user.getUserId());
	}
	
	
	@RequestMapping(value = "/{id}/deletemypet/{petId}",method = RequestMethod.GET)
	public ModelAndView deleteMyPet(@PathVariable("id")Long id,@PathVariable("petId")Long petId, Model uiModel) {
		
		this.PetService.deletePet(petId);
		user=this.UserService.getUserById(id);
		return new ModelAndView("redirect:/profile/"+user.getUserId());
	}
	
	
	
	
	@RequestMapping(value = "/{id}/updateprofileinfo",method = RequestMethod.POST)
	 public String updateProfileInfo(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,@PathVariable("id")Long id) {
	  
	  String lastName =httpServletRequest.getParameter("lastName");
	  String firstName  =httpServletRequest.getParameter("firstName");
	  String password  =httpServletRequest.getParameter("password");
	  String email  =httpServletRequest.getParameter("email");
	  String userBio  =httpServletRequest.getParameter("userbio");
	  user=this.UserService.getUserById(id);
	  
	  
	 
	  user.setFirstName(firstName);
	  user.setLastName(lastName);
	  user.seteMail(email);
	  user.setPassword(password);
	  user.setUserBio(userBio);

	  
	  this.UserService.updateUser(user);
	  
	  return   "redirect:/profile/"+user.getUserId();
	  
	 }
	
	
	@RequestMapping(value = "/updateprofile",method = RequestMethod.POST)
	public void updateProfilesadsss(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		String content =httpServletRequest.getParameter("content");
		
		String access_token = "076f3fbdc7d4ff4f8a656297de20aef242bed18d";
		JSONObject committer = new JSONObject();
		committer.put("name", "Mickeychrn");
		committer.put("email", "973511916@qq.com");
		JSONObject json = new JSONObject();
		json.put("message", "this is a test");
		json.put("content", content.split(",")[1].trim().replace("%", "").replace(",", "").replace(" ", "+"));
		json.put("committer", committer);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HHmmss");
		String aString = simpleDateFormat.format(new Date());
		String filename = aString + ".jpg";
		String url = "https://api.github.com/repos/Mickeychrn/image/contents/" + filename + "?access_token="
				+ access_token;
		UploadPhoto uploadPhoto = new UploadPhoto(json, url);
		Thread t = new Thread(uploadPhoto);
		t.run();
		String userURL=uploadPhoto.getUrl();
		
	
		user.setUserPhoto(userURL);

		
		this.UserService.updateUser(user);
		
	}

}
