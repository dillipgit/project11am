package in.nit.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.nit.model.Part;
import in.nit.model.ShipmentType;
import in.nit.service.IPartService;
import in.nit.view.PartExcelView;
import in.nit.view.PartPdfView;
import in.nit.view.ShipmentTypeExcelView;
import in.nit.view.ShipmentTypePdfView;

@Controller
@RequestMapping("/part")
public class PartController {

	@Autowired
	private IPartService service;

	@RequestMapping("/show")
	public String showPart(Model model) {
		model.addAttribute("part", new Part());
		return "partViewPage";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String savePart(@ModelAttribute Part p, Model model) {
		Integer id = service.savePart(p);
		String msg = id + " saved data into database";
		model.addAttribute("msg", msg);
		model.addAttribute("part", new Part());
		//System.out.println("pId " + p.getParId());
		return "partViewPage";

	}

	@RequestMapping("/all")
	public String getAllPart(Model model) {
		List<Part> list = service.displayAllPart();
		model.addAttribute("list", list);
		return "partViewAll";

	}

	@RequestMapping("/delete")
	public String deletePart(@RequestParam("pId") Integer id, Model model) {
		service.deletePartById(id);
		String msg = id + " is deleted";
		model.addAttribute("msg", msg);
		
		List<Part> list = service.displayAllPart();
		model.addAttribute("list", list);
		return "partViewAll";

	}
	
	@RequestMapping("/edit")
	public String getOnePart(@RequestParam("pId")Integer id,Model model) {
	Part p = service.getOnePart(id);
		model.addAttribute("msg", p);
		return "partViewOne";
	}
	
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public String  updateOnePart(@ModelAttribute Part prt,Model model) {
		service.updateOnePart(prt);
		String msg = prt.getParId()+" is updated ";
		model.addAttribute("msg",msg);
		List<Part> list = service.displayAllPart();
		model.addAttribute("list", list);
		return "partViewAll";
	}
	
	@RequestMapping("/view")
	public String showOnePart(@RequestParam("pId") Integer id,Model model) {
		Part p = service.getOnePart(id);
		model.addAttribute("ob",p);
		return "partShowOne";
		
	}
	
	@RequestMapping("/excel")
	public ModelAndView showExcel(@RequestParam(value = "pId", required = false) Integer sid) {
		ModelAndView m = new ModelAndView();
		m.setView(new PartExcelView());

		if (sid == null) {
			// fetching data from db
			List<Part> list = service.displayAllPart();
			m.addObject("list", list);
		} else {
			Part st = service.getOnePart(sid);
			m.addObject("list", Arrays.asList(st));
		}
		return m;
	}

	@RequestMapping("/pdf")
	public ModelAndView showPdf(@RequestParam(value = "pId", required = false) Integer sid) {

		ModelAndView model = new ModelAndView();

		model.setView(new ShipmentTypePdfView());
		if (sid == null) {

			List<Part> list = service.displayAllPart();
			// send data to pdf file
			model.addObject("list", list);
		} else {
			// export one row by id
			Part st = service.getOnePart(sid);
			model.addObject("list", Arrays.asList(st));
		}

		return model;

	}

}
