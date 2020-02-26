package in.nit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import in.nit.model.WhUserTypeModel;
import in.nit.service.IWhUserTypeService;

@Controller
@RequestMapping("/user")
public class WhUserTypeController {

	@Autowired
	private IWhUserTypeService service;

	@RequestMapping("/show")
	public String showUsers(ModelMap model) {
		model.addAttribute("WhUserTypeModel", new WhUserTypeModel());
		// model.put("WhUserTypeModel",new WhUserTypeModel());
		return "whUserType";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveOrder(@ModelAttribute WhUserTypeModel mode, Model model) {
		Integer id = service.saveUser(mode);
		String message = "Order Data " + id + " save";
		model.addAttribute("msg", message);

		model.addAttribute("WhUserTypeModel", new WhUserTypeModel());

		return "whUserType";
	}

	@RequestMapping("/all")
	public String showAllData(Model model) {

		List<WhUserTypeModel> list = service.selectAllUser();
		model.addAttribute("list", list);
		return "whUserTypedata";

	}

	@RequestMapping("/delete")
	public String deleteDataById(@RequestParam("userId") Integer id, Model model) {
		service.deleteOneUserById(id);
		String msg = "deleteed data is" + id;
		model.addAttribute("msg", msg);

		List<WhUserTypeModel> list = service.selectAllUser();
		model.addAttribute("list", list);
		return "whUserTypedata";

	}

	
	@RequestMapping("/edit")
	public String showOneUser(@RequestParam Integer userId, Model model) {
		WhUserTypeModel user = service.getOneUserType(userId);
		model.addAttribute("whUserType", user);
		return "whUserTypeEdit";

	}
	
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public String updateShipment(@ModelAttribute WhUserTypeModel user,Model model) {
		service.updateWhUser(user);
		String message="WhUser "+user.getId()+" updated";
		model.addAttribute("message",message);
		List<WhUserTypeModel> list = service.selectAllUser();
		model.addAttribute("list", list);
		return "whUserTypedata";
		
	}
	
	@RequestMapping("/view")
	public String showOneShipment(@RequestParam Integer userId,Model model) {
		WhUserTypeModel user =service.getOneUserType(userId);
		model.addAttribute("ob",user);
		
		return "whUserTypedataView";
		
	}

}
