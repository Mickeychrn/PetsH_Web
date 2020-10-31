package usyd.elec5619.petsh.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import usyd.elec5619.petsh.domain.User;
import usyd.elec5619.petsh.service.UserService;

@Controller("signin")
@RequestMapping(value = "/signin/**")
public class SignInController {

	@Resource
	UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String homepage() {
		return "signin";
	}
	
	@RequestMapping(value="/sign", method=RequestMethod.POST)
	public String addUser(HttpServletRequest httpServletRequest) {
		String password=httpServletRequest.getParameter("password");

		List<User> list =this.userService.getUserByEmail(httpServletRequest.getParameter("email"));
		User user= list.get(0);
		if (user.getPassword().equals(password)) {
			return "redirect:/home/"+list.get(0).getUserId(); 
		}
		return "redirect:/signin";
	}
	
}
