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

@Controller("signup")
@RequestMapping(value = "/signup/**")
public class SignUpController {

	@Resource
	UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView signup() {
		Map<String, Object> profileMap = new HashMap<String, Object>();
		profileMap.put("signupinfo", "signup");
		return new ModelAndView("signup","profileMap",profileMap);
		
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView register(HttpServletRequest httpServletRequest) {
		
		Map<String, Object> profileMap = new HashMap<String, Object>();
		
		User user = new User();
		String email= httpServletRequest.getParameter("eMail");
		user.setFirstName(httpServletRequest.getParameter("firstName"));
		user.setLastName(httpServletRequest.getParameter("lastName"));
		user.seteMail(email);
		user.setPassword(httpServletRequest.getParameter("password"));
		user.setAuthority(0);
		user.setUserPhoto("https://raw.githubusercontent.com/Mickeychrn/image/master/063749.jpg");
		
		List<User> users=this.userService.getUserByEmail(email);
		
		
		
		if (users.isEmpty()) {
			this.userService.addUser(user);
			return new ModelAndView("redirect:/signin");
			
		}
		
		profileMap.put("signupinfo", "existemail");
		return new ModelAndView("signup","profileMap",profileMap);
		
		
	}

}
