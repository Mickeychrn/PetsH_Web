package usyd.elec5619.petsh.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("logouthome")
public class LogOutHomeController {

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String homepage() {
		return "logouthome";
	}
}
