package usyd.elec5619.petsh.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import usyd.elec5619.petsh.domain.Forum;
import usyd.elec5619.petsh.domain.Pet;
import usyd.elec5619.petsh.domain.User;
import usyd.elec5619.petsh.service.ForumService;
import usyd.elec5619.petsh.service.PetService;
import usyd.elec5619.petsh.service.UserService;

@Controller("admin")
@RequestMapping(value = "/admin/**")
public class Admin {
	
	@Resource
	UserService userService;
	
	@Resource
	PetService petService;
	
	
	@Resource
	ForumService forumService;
	
	@RequestMapping(value = "/user",method = RequestMethod.GET)
	public ModelAndView adminUser() {
		Map<String, Object> profileMap = new HashMap<String, Object>();
		List<User> users=this.userService.getUsers();
		profileMap.put("users", users);
		return new ModelAndView("adminuser","profileMap",profileMap);
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
	
	@RequestMapping(value = "/pet",method = RequestMethod.GET)
	public ModelAndView adminPet() {
		Map<String, Object> profileMap = new HashMap<String, Object>();
		List<Pet> pets = this.petService.allPets();
		profileMap.put("pets", pets);
		return new ModelAndView("adminpet","profileMap",profileMap);
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
	

}