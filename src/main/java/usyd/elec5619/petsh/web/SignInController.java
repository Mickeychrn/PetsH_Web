package usyd.elec5619.petsh.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import usyd.elec5619.petsh.domain.User;
import usyd.elec5619.petsh.service.UserService;

@Controller("signin")
@RequestMapping(value = "/signin/**")
public class SignInController {

	@Resource
	UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView homepage() {
		Map<String, Object> profileMap = new HashMap<String, Object>();
		profileMap.put("signininfo", "signin");
		return new ModelAndView("signin","profileMap",profileMap);
	}
	
	@RequestMapping(value="/sign", method=RequestMethod.POST)
	public ModelAndView addUser(HttpServletRequest httpServletRequest) {
		String password=httpServletRequest.getParameter("password");
		
		Map<String, Object> profileMap = new HashMap<String, Object>();

		List<User> list =this.userService.getUserByEmail(httpServletRequest.getParameter("email"));
		if (list.isEmpty()) {
			profileMap.put("signininfo", "notregister");
			return new ModelAndView("signin","profileMap",profileMap);
		}
		
		User user= list.get(0);
		if (user.getPassword().equals(password)) {
			profileMap.put("user", user);
			return new ModelAndView("loginhome","profileMap",profileMap);
			
			
//			return "redirect:/home/"+list.get(0).getUserId(); 
		}
		profileMap.put("signininfo", "wrongpassword");
		
		return new ModelAndView("signin","profileMap",profileMap);
	}
	
}
