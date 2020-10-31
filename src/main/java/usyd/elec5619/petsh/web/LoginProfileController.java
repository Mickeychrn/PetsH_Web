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
	
	@RequestMapping(value = "/updateprofile",method = RequestMethod.POST)
	public void updateProfilesadsss(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		String content =httpServletRequest.getParameter("content");
		String lastName =httpServletRequest.getParameter("lastName");
		String firstName  =httpServletRequest.getParameter("firstName");
		String password  =httpServletRequest.getParameter("password");
		String email  =httpServletRequest.getParameter("email");
		String userBio  =httpServletRequest.getParameter("userbio");
		
		
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
		
		
		
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.seteMail(email);
		user.setPassword(password);
		user.setUserPhoto(userURL);
		user.setUserBio(userBio);
		
		this.UserService.updateUser(user);
		
		
	
		
		
	}

}
