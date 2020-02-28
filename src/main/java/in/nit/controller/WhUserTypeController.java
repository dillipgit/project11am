package in.nit.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.nit.model.ShipmentType;
import in.nit.model.WhUserTypeModel;
import in.nit.service.IWhUserTypeService;
import in.nit.util.WhUserTypeUtil;
import in.nit.view.ShipmentTypePdfView;
import in.nit.view.WhUserExcelView;
import in.nit.view.WhUserPdfView;

@Controller
@RequestMapping("/user")
public class WhUserTypeController {
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	private WhUserTypeUtil util;
	

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
	
	@RequestMapping("/excel")
	public ModelAndView showExcel() {
		ModelAndView m = new ModelAndView();
		m.setView(new WhUserExcelView());
		
		//fetching data from database
		List<WhUserTypeModel> list = service.selectAllUser();
		m.addObject("list",list);
		return m;
		
	}
	
	@RequestMapping("/pdf")
	public ModelAndView showPdf(@RequestParam(value = "id", required = false) Integer sid) {

		ModelAndView model = new ModelAndView();

		model.setView(new WhUserPdfView());
		if (sid == null) {

			List<WhUserTypeModel> list = service.selectAllUser();
			// send data to pdf file
			model.addObject("list", list);
		} else {
			// export one row by id
			WhUserTypeModel st = service.getOneUserType(sid);
			model.addObject("list", Arrays.asList(st));
		}

		return model;

	}
	@RequestMapping("/charts")
	public String showChart() {
	List<Object[]> list =	service.getUserTypeCount();
	String path = context.getRealPath("/");
	util.generatePie(path,list);
	util.generateBar(path, list);

		return "shipmentTypeCharts";
		
	}


}
