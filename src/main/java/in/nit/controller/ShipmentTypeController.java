package in.nit.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.nit.model.ShipmentType;
import in.nit.service.IShipmentTypeService;
import in.nit.view.ShipmentTypeExcelView;
import in.nit.view.ShipmentTypePdfView;

@Controller
@RequestMapping("/shipment")
public class ShipmentTypeController {

	@Autowired
	private IShipmentTypeService service;

	@RequestMapping("/show")
	public String showRegPage(Model model) {
		model.addAttribute("shipmentType", new ShipmentType());
		return "shipmentType";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveShipmentype(@ModelAttribute ShipmentType shipmenttype, Model model) {
		Integer id = service.saveShipmentService(shipmenttype);

		String message = "ShipmentType Data " + id + " is Inserted";
		model.addAttribute("message", message);

		// for show empty form
		model.addAttribute("shipmentType", new ShipmentType());

		//return "redirect:show";
		return "shipmentType";
	}

	@RequestMapping("/all")
	public String getAllShipmentType(Model model) {
		List<ShipmentType> list = service.getAllShipmentType();
		model.addAttribute("list", list);

		return "shipmentTypeData";
	}

	@RequestMapping("/delete")
	public String deleteShipment(@RequestParam("shipId") Integer id, Model model) {
		service.deleteShipment(id);
		String message = "id no " + id + " Delete Successfully";
		model.addAttribute("message", message);

		List<ShipmentType> list = service.getAllShipmentType();
		model.addAttribute("list", list);

		return "shipmentTypeData";
	}

	@RequestMapping("/edit")
	public String showEditPage(@RequestParam("shipId") Integer id, Model model) {
		ShipmentType st = service.getOneShipmentType(id);
		model.addAttribute("shipmentType", st);

		return "shipmentTypeEdit";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String saveEditObject(@ModelAttribute ShipmentType shipment, Model model) {

		// call service class update method
		service.updateOneShipment(shipment);

		// send confirmation msg to gui
		String message = "ShipmentType " + shipment.getShipId() + " updated";
		model.addAttribute("shipmentType", message);

		// show updated table
		List<ShipmentType> list = service.getAllShipmentType();
		model.addAttribute("list", list);

		return "shipmentTypeData";
	}

	@RequestMapping("/view")
	public String viewSingleRow(@RequestParam("shipId") Integer sid, Model model) {

		ShipmentType sh = service.getOneShipmentType(sid);
		model.addAttribute("ob", sh);
		return "shipmentTypeView";
	}

//	@RequestMapping("/excel")
//	public ModelAndView showExcel(@RequestParam(value = "id",required = false)Integer sid) {
//		ModelAndView m = new ModelAndView();
//		m.setView(new ShipmentTypeExcelView());
//		
//		//fetching data from db
//		List<ShipmentType> list = service.getAllShipmentType();
//		
//		m.addObject("list",list);
//		
//		return m;
//	}

	@RequestMapping("/excel")
	public ModelAndView showExcel(@RequestParam(value = "id", required = false) Integer sid) {
		ModelAndView m = new ModelAndView();
		m.setView(new ShipmentTypeExcelView());

		if (sid == null) {
			// fetching data from db
			List<ShipmentType> list = service.getAllShipmentType();
			m.addObject("list", list);
		} else {
			ShipmentType st = service.getOneShipmentType(sid);
			m.addObject("list", Arrays.asList(st));
		}
		return m;
	}

//	@RequestMapping("/pdf")
//	public ModelAndView showPdf(@RequestParam("id")Integer sid) {
//		ModelAndView model = new ModelAndView();
//		model.setView(new ShipmentTypePdfView());
//		List<ShipmentType> list = service.getAllShipmentType();
//		//send data to pdf file
//		model.addObject("list",list);
//		return model;
//		
//	}

	@RequestMapping("/pdf")
	public ModelAndView showPdf(@RequestParam(value = "id", required = false) Integer sid) {

		ModelAndView model = new ModelAndView();

		model.setView(new ShipmentTypePdfView());
		if (sid == null) {

			List<ShipmentType> list = service.getAllShipmentType();
			// send data to pdf file
			model.addObject("list", list);
		} else {
			// export one row by id
			ShipmentType st = service.getOneShipmentType(sid);
			model.addObject("list", Arrays.asList(st));
		}

		return model;

	}

}
