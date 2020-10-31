package usyd.elec5619.petsh.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import usyd.elec5619.petsh.domain.User;
import usyd.elec5619.petsh.service.UserService;

@Controller("signup")
@RequestMapping(value = "/signup/**")
public class SignUpController {

	@Resource
	UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public String signin() {
		return "signup";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String register(HttpServletRequest httpServletRequest) {
		User user = new User();
		user.setFirstName(httpServletRequest.getParameter("firstName"));
		user.setLastName(httpServletRequest.getParameter("lastName"));
		user.seteMail(httpServletRequest.getParameter("eMail"));
		user.setPassword(httpServletRequest.getParameter("password"));
		user.setAuthority(0);
		user.setUserPhoto("https://raw.githubusercontent.com/Mickeychrn/image/master/063749.jpg");
		this.userService.addUser(user);
		return "redirect:/signin";
	}

}
