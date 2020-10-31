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

import usyd.elec5619.petsh.domain.Pet;
import usyd.elec5619.petsh.domain.User;
import usyd.elec5619.petsh.service.PetService;
import usyd.elec5619.petsh.service.UserService;
import usyd.elec5619.petsh.utils.ChangeDate;
import usyd.elec5619.petsh.utils.UploadPhoto;

@Controller("loginadopt")
@RequestMapping(value = "/adopt")
public class LoginAdoptController {

	@Resource
	UserService userService;

	@Resource
	PetService petService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView signinAdopt(@PathVariable("id") Long id, Model uiModel) {
		Map<String, Object> profileMap = new HashMap<String, Object>();
		User user = this.userService.getUserById(id);
		List<Pet> pets = this.petService.unAdoptedPets();
		profileMap.put("user", user);
		profileMap.put("pets", pets);
		return new ModelAndView("loginadopt", "profileMap", profileMap);
	}
	
	
	@RequestMapping(value = "/{id}/searchbycolor",method = RequestMethod.POST)
	public ModelAndView search(HttpServletRequest httpServletRequest,@PathVariable("id") Long id) {
		String color =httpServletRequest.getParameter("color");
		User user = this.userService.getUserById(id);
		List<Pet> pets=this.petService.searchByColor(color);
		Map<String, Object> profileMap =new HashMap<String, Object>();
		profileMap.put("user", user);
		profileMap.put("pets", pets);
		return new ModelAndView("loginadopt","profileMap",profileMap);
	}

	@RequestMapping(value = "/{id}/view/{petid}", method = RequestMethod.GET)
	public ModelAndView signinAdoptview(@PathVariable("id") Long id, @PathVariable("petid") Long petid, Model uiModel) {
		Map<String, Object> profileMap = new HashMap<String, Object>();
		User user = this.userService.getUserById(id);
		Pet pet = this.petService.getPetById(petid);
		profileMap.put("user", user);
		profileMap.put("pet", pet);
		return new ModelAndView("loginadoptview", "profileMap", profileMap);
	}
	
	
	@RequestMapping(value = "/{id}/view/{petid}/adopt", method = RequestMethod.GET)
	public String signinAdopt(@PathVariable("id") Long id, @PathVariable("petid") Long petid, Model uiModel) {
		User user = this.userService.getUserById(id);
		Pet pet = this.petService.getPetById(petid);
		pet.setAdoptPersonId(user.getUserId());
		pet.setAdoptTime(new ChangeDate(new Date()).toString());
		pet.setIsAdopted(true);
		this.petService.updatePet(pet);
		return "redirect:/adopt/" + user.getUserId();
	}

	@RequestMapping(value = "/{id}/add", method = RequestMethod.GET)
	public ModelAndView signinNewPet(@PathVariable("id") Long id, Model uiModel) {
		Map<String, Object> profileMap = new HashMap<String, Object>();
		User user = this.userService.getUserById(id);
		profileMap.put("user", user);
		return new ModelAndView("loginnewpet", "profileMap", profileMap);
	}
	
	
	


	@RequestMapping(value = "/{id}/addpet", method = RequestMethod.POST)
	public String signinNewPetAdd(@PathVariable("id") Long id, HttpServletRequest httpServletRequest,
			HttpServletResponse response) {

		User user = this.userService.getUserById(id);
		Pet pet = new Pet();
		

		String petName = httpServletRequest.getParameter("petName");
		String petColor = httpServletRequest.getParameter("petColor");
		String content = httpServletRequest.getParameter("content");
		String petCategory = httpServletRequest.getParameter("petCategory");
		String petGender = httpServletRequest.getParameter("petGender");
		String petDescription = httpServletRequest.getParameter("petDescription");
		
		System.out.println(petCategory+petGender+petDescription+"++++++++++++");
		
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
		return "redirect:/adopt/" + user.getUserId();


	}

}
