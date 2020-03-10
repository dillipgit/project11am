package in.nit.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import in.nit.model.PurchaseOrder;
import in.nit.service.IPurchaseService;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {
	
	@Autowired
	private IPurchaseService service;
	
	// show page
		@RequestMapping("/show")
		public String showUplodPage(Model model) {
			model.addAttribute("purchaseOrder", new PurchaseOrder());
			return "purchaseOrderViewPage";

		}
		
		@RequestMapping(value = "/save", method = RequestMethod.POST)
		public String savePurchase(@ModelAttribute PurchaseOrder purchaseOrder, Model model) {
			Integer id = service.savePurchase(purchaseOrder);

			String message = "Purchase Items " + id + " is Inserted";
			model.addAttribute("message", message);

//			// for show empty form
//			model.addAttribute("shipmentType", new ShipmentType());

			//return "redirect:show";
			return "purchaseOrderViewPage";
		}

//		@RequestMapping("/all")
//		public String getAllShipmentType(Model model) {
//			List<ShipmentType> list = service.getAllShipmentType();
//			model.addAttribute("list", list);
//
//			return "shipmentTypeData";
//		}
//
//		@RequestMapping("/delete")
//		public String deleteShipment(@RequestParam("shipId") Integer id, Model model) {
//			service.deleteShipment(id);
//			String message = "id no " + id + " Delete Successfully";
//			model.addAttribute("message", message);
//
//			List<ShipmentType> list = service.getAllShipmentType();
//			model.addAttribute("list", list);
//
//			return "shipmentTypeData";
//		}
//
//		@RequestMapping("/edit")
//		public String showEditPage(@RequestParam("shipId") Integer id, Model model) {
//			ShipmentType st = service.getOneShipmentType(id);
//			model.addAttribute("shipmentType", st);
//
//			return "shipmentTypeEdit";
//		}
//
//		@RequestMapping(value = "/update", method = RequestMethod.POST)
//		public String saveEditObject(@ModelAttribute ShipmentType shipment, Model model) {
//
//			// call service class update method
//			service.updateOneShipment(shipment);
//
//			// send confirmation msg to gui
//			String message = "ShipmentType " + shipment.getShipId() + " updated";
//			model.addAttribute("shipmentType", message);
//
//			// show updated table
//			List<ShipmentType> list = service.getAllShipmentType();
//			model.addAttribute("list", list);
//
//			return "shipmentTypeData";
//		}
//
//		@RequestMapping("/view")
//		public String viewSingleRow(@RequestParam("shipId") Integer sid, Model model) {
//
//			ShipmentType sh = service.getOneShipmentType(sid);
//			model.addAttribute("ob", sh);
//			return "shipmentTypeView";
//		}
//

}
