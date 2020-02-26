package in.nit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import in.nit.model.UOM;
import in.nit.service.IUmoService;

@Controller
@RequestMapping("/uom")
public class UomController {

	@Autowired
	private IUmoService service;

	@RequestMapping("/show")
	public String showUOM(Model model) {
		model.addAttribute("unitOfMeasure", new UOM());
		return "uom";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveUomData(@ModelAttribute UOM unit, Model model) {
		Integer in = service.saveUmoData(unit);
		String message = "UnitOfMeasure Data " + in + " is saved in database";
		model.addAttribute("msg", message);
		model.addAttribute("unitOfMeasure", new UOM());
		return "uom";
	}
	
	@RequestMapping("/all")
	public String showData(Model model) {
		List<UOM> list = service.showAll();
		model.addAttribute("list",list);
		return "uomAllData";
	}
	
	@RequestMapping("/delete")
	public String deleteById(@RequestParam ("id")Integer id,Model model) {
	 service.deleteById(id);
	 
	 String message="Delete id no "+id+" successfully";
	 model.addAttribute("message",message);
	 
	 List<UOM> list = service.showAll();
		model.addAttribute("list",list);
		
		return "uomAllData";
	}
	@RequestMapping("/edit")
	public String getOneUom(@RequestParam("id")Integer id,Model model) {
		UOM uom = service.getOneUmo(id);
		model.addAttribute("unitOfMeasure",uom);
		return "editUmoAllData";
		
	}
	@RequestMapping(method =RequestMethod.POST,value = "/update")
	public String updateUom(@ModelAttribute UOM uo,Model model) {
		 service.updateOneUom(uo);
		 String msg = "UOM "+uo.getId()+" updated";
		model.addAttribute("list",msg);
		
	List<UOM> list = service.showAll();
		model.addAttribute("list",list);
		return "uomAllData";
	}
	
	@RequestMapping("/view")
	public String showOneUom(@RequestParam("id")Integer id,Model model) {
	UOM uom =	service.getOneUmo(id);
	model.addAttribute("ob",uom);
		return "uomOneRowViewPage";
	}

}
