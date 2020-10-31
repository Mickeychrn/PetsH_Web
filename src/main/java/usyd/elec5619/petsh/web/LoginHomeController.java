package usyd.elec5619.petsh.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import usyd.elec5619.petsh.domain.User;
import usyd.elec5619.petsh.service.UserService;

@Controller("loginhome")
@RequestMapping(value = "/home")
public class LoginHomeController {
	
	@Resource
	UserService UserService;
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public ModelAndView signinhome(@PathVariable("id")Long id, Model uiModel) {
		Map<String, Object> profileMap = new HashMap<String, Object>();
		User user=this.UserService.getUserById(id);
		profileMap.put("user", user);
		return new ModelAndView("loginhome","profileMap",profileMap);
	}

}
