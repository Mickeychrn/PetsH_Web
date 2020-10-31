package usyd.elec5619.petsh.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import usyd.elec5619.petsh.domain.Pet;
import usyd.elec5619.petsh.service.PetService;

@Controller("logoutadopt")
@RequestMapping(value = "/adopt")
public class LogOutAdoptController {
	
	@Resource
	private PetService petService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView AdoptPage() {
		List<Pet> petList=this.petService.unAdoptedPets();
		Map<String, Object> uiModel =new HashMap<String, Object>();
		uiModel.put("petList", petList);
		return new ModelAndView("logoutadopt","uiModel",uiModel);
	}
	
	
	
	@RequestMapping(value = "/view/{id}",method = RequestMethod.GET)
	public ModelAndView showProduct(@PathVariable("id")Long id, Model uiModel) {
		
		Pet pet  = this.petService.getPetById(id);
		Map<String, Object> petModel =new HashMap<String, Object>();
		petModel.put("petList", pet);
		return new ModelAndView("logoutadoptview","uiModel",petModel);
	}
	
	
	
	@RequestMapping(value = "/searchbycolor",method = RequestMethod.POST)
	public ModelAndView search(HttpServletRequest httpServletRequest) {
		String color =httpServletRequest.getParameter("color");
		List<Pet> petList=this.petService.searchByColor(color);
		Map<String, Object> uiModel =new HashMap<String, Object>();
		uiModel.put("petList", petList);
		return new ModelAndView("logoutadopt","uiModel",uiModel);
	}
}
