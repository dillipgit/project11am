package in.nit.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.nit.model.OrderMethod;
import in.nit.model.UOM;
import in.nit.service.IUmoService;
import in.nit.util.UOMUtil;
import in.nit.view.UOMExcelView;
import in.nit.view.UOMPdfView;
import in.nit.view.WhUserExcelView;
import in.nit.view.WhUserPdfView;

@Controller
@RequestMapping("/uom")
public class UomController {
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	private UOMUtil util;

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
		model.addAttribute("list", list);
		return "uomAllData";
	}

	@RequestMapping("/delete")
	public String deleteById(@RequestParam("id") Integer id, Model model) {
		service.deleteById(id);

		String message = "Delete id no " + id + " successfully";
		model.addAttribute("message", message);

		List<UOM> list = service.showAll();
		model.addAttribute("list", list);

		return "uomAllData";
	}

	@RequestMapping("/edit")
	public String getOneUom(@RequestParam("id") Integer id, Model model) {
		UOM uom = service.getOneUmo(id);
		model.addAttribute("unitOfMeasure", uom);
		return "editUmoAllData";

	}

	@RequestMapping(method = RequestMethod.POST, value = "/update")
	public String updateUom(@ModelAttribute UOM uo, Model model) {
		service.updateOneUom(uo);
		String msg = "UOM " + uo.getId() + " updated";
		model.addAttribute("list", msg);

		List<UOM> list = service.showAll();
		model.addAttribute("list", list);
		return "uomAllData";
	}

	@RequestMapping("/view")
	public String showOneUom(@RequestParam("id") Integer id, Model model) {
		UOM uom = service.getOneUmo(id);
		model.addAttribute("ob", uom);
		return "uomOneRowViewPage";
	}

	@RequestMapping("/excel")
	public ModelAndView showExcel() {
		ModelAndView m = new ModelAndView();
		m.setView(new UOMExcelView());

		// fetching data from database
		List<UOM> list = service.showAll();
		m.addObject("list", list);
		return m;

	}

	@RequestMapping("/pdf")
	public ModelAndView showPdf(@RequestParam(value = "id", required = false) Integer sid) {

		ModelAndView model = new ModelAndView();

		model.setView(new UOMPdfView());
		if (sid == null) {

			List<UOM> list = service.showAll();
			// send data to pdf file
			model.addObject("list", list);
		} else {
			// export one row by id
			UOM st = service.getOneUmo(sid);
			model.addObject("list", Arrays.asList(st));
		}

		return model;

	}
	@RequestMapping("/charts")
	public String showChart() {
		List<Object[]> list = service.getUOMtypes();
		String path = context.getRealPath("/");
		util.generatePie(path, list);
		util.generateBar(path, list);
		return "shipmentTypeCharts"; 
		
	}

}
