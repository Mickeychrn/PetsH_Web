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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;

import usyd.elec5619.petsh.domain.Comment;
import usyd.elec5619.petsh.domain.Forum;
import usyd.elec5619.petsh.domain.Pet;
import usyd.elec5619.petsh.domain.User;
import usyd.elec5619.petsh.service.CommentService;
import usyd.elec5619.petsh.service.ForumService;
import usyd.elec5619.petsh.service.PetService;
import usyd.elec5619.petsh.service.UserService;
import usyd.elec5619.petsh.utils.ChangeDate;
import usyd.elec5619.petsh.utils.UploadPhoto;

@Controller("admin")
@RequestMapping(value = "/admin/**")
public class AdminController {
	
	@Resource
	UserService userService;
	
	@Resource
	PetService petService;
	
	
	@Resource
	ForumService forumService;
	
	@Resource
	CommentService commentService;
	
	@RequestMapping(value = "/user",method = RequestMethod.GET)
	public ModelAndView adminUser() {
		Map<String, Object> profileMap = new HashMap<String, Object>();
		List<User> users=this.userService.getUsers();
		profileMap.put("users", users);
		return new ModelAndView("adminuser","profileMap",profileMap);
	}
	
	
	@RequestMapping(value = "/user/add",method = RequestMethod.POST)
	public String adminUseradd(HttpServletRequest httpServletRequest) {
		User user = new User();
		user.setFirstName(httpServletRequest.getParameter("firstName"));
		user.setLastName(httpServletRequest.getParameter("lastName"));
		user.seteMail(httpServletRequest.getParameter("eMail"));
		user.setPassword(httpServletRequest.getParameter("password"));
		String authority = httpServletRequest.getParameter("authority");
		user.setAuthority(Integer.parseInt(authority));
		user.setUserPhoto("https://raw.githubusercontent.com/Mickeychrn/image/master/063749.jpg");
		this.userService.addUser(user);
		
		
		
		return "redirect:/admin/user";
	}
	

	
	@RequestMapping(value = "/user/admin/{id}",method = RequestMethod.GET)
	public String adminUserAdmin(@PathVariable("id") Long id) {
		User user =this.userService.getUserById(id);
		user.setAuthority(1);
		this.userService.updateUser(user);
		return "redirect:/admin/user";
		
	}
	
	
	@RequestMapping(value = "/user/delete/{id}",method = RequestMethod.GET)
	public String adminUserdelete(@PathVariable("id") Long id) {
		
		this.userService.deleteUser(id);
		return "redirect:/admin/user";
		
	}
	
	
	@RequestMapping(value = "/user/update/{id}",method = RequestMethod.GET)
	public ModelAndView adminUserUpdate(@PathVariable("id") Long id) {
		User user =this.userService.getUserById(id);
		Map<String, Object> profileMap = new HashMap<String, Object>();
		
		profileMap.put("user", user);
		
		
		return new ModelAndView("adminuserupdate","profileMap",profileMap);
		
	}
	
	
	@RequestMapping(value = "/user/update/{id}/update",method = RequestMethod.POST)
	public ModelAndView adminUserUpdateinfo(@PathVariable("id") Long id,HttpServletRequest httpServletRequest) {
		
		String lastName = httpServletRequest.getParameter("lastName");
		String eMail = httpServletRequest.getParameter("eMail");
		String userBio = httpServletRequest.getParameter("userBio");
		String authority = httpServletRequest.getParameter("authority");
		String firstName = httpServletRequest.getParameter("firstName");
		
		User user = this.userService.getUserById(id);
		
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setAuthority(Integer.parseInt(authority));
		user.seteMail(eMail);
		user.setUserBio(userBio);
		
		this.userService.updateUser(user);
		
		Map<String, Object> profileMap = new HashMap<String, Object>();
		List<User> users=this.userService.getUsers();
		profileMap.put("users", users);
		return new ModelAndView("adminuser","profileMap",profileMap);
		
	}
	
	@RequestMapping(value = "/pet",method = RequestMethod.GET)
	public ModelAndView adminPet() {
		Map<String, Object> profileMap = new HashMap<String, Object>();
		List<Pet> pets = this.petService.allPets();
		profileMap.put("pets", pets);
		return new ModelAndView("adminpet","profileMap",profileMap);
	}
	
	
	@RequestMapping(value = "/pet/update/{id}",method = RequestMethod.GET)
	public ModelAndView adminPetUpdate(@PathVariable("id") Long id) {
		Map<String, Object> profileMap = new HashMap<String, Object>();
		Pet pet = this.petService.getPetById(id);
		profileMap.put("pet", pet);
		return new ModelAndView("adminpetupdate","profileMap",profileMap);
	}
	
	
	@RequestMapping(value = "/pet/update/{id}/update",method = RequestMethod.POST)
	public String adminPetUpdateinfo(@PathVariable("id") Long id,HttpServletRequest httpServletRequest) {
		Pet pet = this.petService.getPetById(id);
		String petName =httpServletRequest.getParameter("petName"); 
		String petColor =httpServletRequest.getParameter("petColor"); 
		String petCategory =httpServletRequest.getParameter("petCategory"); 
		String petDescription =httpServletRequest.getParameter("petDescription"); 
		String petGender =httpServletRequest.getParameter("petGender"); 
		pet.setPetName(petName);
		pet.setPetColor(petColor);
		pet.setPetCategory(petCategory);
		pet.setPetDescription(petDescription);
		pet.setPetGender(petGender);
		this.petService.updatePet(pet);
		
		
		Map<String, Object> profileMap = new HashMap<String, Object>();
		List<Pet> pets = this.petService.allPets();
		profileMap.put("pets", pets);
		return "redirect:/admin/pet";
	}
	
	
	@RequestMapping(value = "/pet/delete/{id}",method = RequestMethod.GET)
	public String adminPetDelete(@PathVariable("id") Long id) {
		this.petService.deletePet(id);
		return "redirect:/admin/pet";
	}
	
	
	@RequestMapping(value = "/post",method = RequestMethod.GET)
	public ModelAndView adminPost() {
		Map<String, Object> profileMap = new HashMap<String, Object>();
		List<Forum> forums = this.forumService.allForums();
		profileMap.put("forums", forums);
		return new ModelAndView("adminpost","profileMap",profileMap);
	}
	
	
	@RequestMapping(value = "/post/delete/{id}",method = RequestMethod.GET)
	public String adminPostDelete(@PathVariable("id") Long id) {
		this.forumService.deleteForum(id);
		return "redirect:/admin/post";
	}
	
	@RequestMapping(value = "/post/update/{id}",method = RequestMethod.GET)
	public ModelAndView adminPostUpdate(@PathVariable("id") Long id) {
		Forum forum=this.forumService.getForumById(id);
		Map<String, Object> profileMap = new HashMap<String, Object>();
		profileMap.put("forum", forum);
		return new ModelAndView("adminpostupdate","profileMap",profileMap);
		
	}
	
	
	@RequestMapping(value = "/post/update/{id}/update",method = RequestMethod.POST)
	public ModelAndView adminPostUpdateinfo(@PathVariable("id") Long id,HttpServletRequest httpServletRequest) {
		Forum forum=this.forumService.getForumById(id);
		forum.setForumTitle(httpServletRequest.getParameter("forumTitle"));
		forum.setForumContent(httpServletRequest.getParameter("forumContent"));
		this.forumService.updateFroum(forum);
		
		Map<String, Object> profileMap = new HashMap<String, Object>();
		List<Forum> forums = this.forumService.allForums();
		profileMap.put("forums", forums);
		return new ModelAndView("adminpost","profileMap",profileMap);
		
	}
	
	
	
	@RequestMapping(value = "/comment",method = RequestMethod.GET)
	public ModelAndView adminComment() {
		Map<String, Object> profileMap = new HashMap<String, Object>();
		List<Comment> comments = this.commentService.allComments();
		profileMap.put("comments", comments);
		return new ModelAndView("admincomment","profileMap",profileMap);
	}
	
	
	@RequestMapping(value = "/comment/delete/{id}",method = RequestMethod.GET)
	public String adminCommentDelete(@PathVariable("id") Long id) {
		
		this.commentService.deleteComment(id);
		return "redirect:/admin/comment";
	}
	
	
	@RequestMapping(value = "pet/addpet", method = RequestMethod.POST)
	public String signinNewPetAdd( HttpServletRequest httpServletRequest,
			HttpServletResponse response) {

		
		Pet pet = new Pet();
		

		String petName = httpServletRequest.getParameter("petName");
		String petColor = httpServletRequest.getParameter("petColor");
		String content = httpServletRequest.getParameter("content");
		String petCategory = httpServletRequest.getParameter("petCategory");
		String petGender = httpServletRequest.getParameter("petGender");
		String petDescription = httpServletRequest.getParameter("petDescription");

		
		String access_token = "076f3fbdc7d4ff4f8a656297de20aef242bed18d";

		JSONObject committer = new JSONObject();
		committer.put("name", "Mickeychrn");
		committer.put("email", "973511916@qq.com");

		JSONObject json = new JSONObject();
		json.put("message", "this is a test");

		json.put("content", content.split(",")[1].trim().replace("%", "").replace(",", "").replace(" ", "+"));
		json.put("committer", committer);

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String aString = simpleDateFormat.format(new Date());
		String filename = aString + ".jpg";
		String url = "https://api.github.com/repos/Mickeychrn/image/contents/" + filename + "?access_token="
				+ access_token;
		UploadPhoto uploadPhoto = new UploadPhoto(json, url);
		Thread t = new Thread(uploadPhoto);
		t.run();
		String petURL=uploadPhoto.getUrl();
		pet.setPetURL(petURL);
		pet.setPetName(petName);
		pet.setPetColor(petColor);
		pet.setIsAdopted(false);
		pet.setPetCategory(petCategory);
		pet.setPetGender(petGender);
		pet.setPetDescription(petDescription);
		this.petService.addPet(pet);
		return "redirect:/admin/pet";
	}
	
	@RequestMapping(value = "/addforum", method = RequestMethod.POST)
	public String signinNewForumAdd(HttpServletRequest httpServletRequest) {

//		User user = this.userService.getUserById(id);
		Forum forum= new Forum();
		forum.setForumTitle(httpServletRequest.getParameter("forumTitle"));
		forum.setForumContent(httpServletRequest.getParameter("forumContent"));
//		forum.setUserId(id);
//		forum.setUserName(user.getLastName()+" "+user.getFirstName());
		forum.setCreateTime(new ChangeDate(new Date()).toString());
		this.forumService.addForum(forum);
		
		return "redirect:/admin/post";
	}
	

}