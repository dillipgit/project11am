package in.nit.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import in.nit.model.PurchaseOrder;
import in.nit.service.IPurchaseService;
import in.nit.service.IShipmentTypeService;
import in.nit.service.IWhUserTypeService;
import in.nit.utill.CommonUtil;

@Controller
@RequestMapping("/po")
public class PurchaseController {

	@Autowired
	private IPurchaseService service;

	@Autowired
	private IShipmentTypeService shipService;

	@Autowired
	private IWhUserTypeService whUserService;

	public void commonUI(Model model) {

		List<Object[]> shipList = shipService.getShipmentIdAndCode();
		// convert List to map
		Map<Integer, String> shipMap = CommonUtil.convert(shipList);
		model.addAttribute("shipMap", shipMap);

		List<Object[]> whUserList = whUserService.getWhUserTypeIdAndCode("vendor");
		// convert List to map
		Map<Integer, String> whUserMap = CommonUtil.convert(whUserList);
		model.addAttribute("whUserMap",whUserMap);
	}

	// show page
	@RequestMapping("/show")
	public String showUplodPage(Model model) {

		PurchaseOrder po = new PurchaseOrder();
		po.setDStatus("OPEN");
		commonUI(model);
		model.addAttribute("purchaseOrder", po);
		return "purchaseOrderViewPage";

	}

	@RequestMapping(value = "/save", method = POST)
	public String savePurchase(@ModelAttribute PurchaseOrder purchaseOrder, Model model) {

		Integer id = service.savePurchase(purchaseOrder);
		// System.out.println(id);

		model.addAttribute("message", "Purchase Items " + id + " is Inserted");

		// for show empty form
		model.addAttribute("purchaseOrder", new PurchaseOrder());

		commonUI(model);

		// return "redirect:show";
		return "purchaseOrderViewPage";
	}
}
