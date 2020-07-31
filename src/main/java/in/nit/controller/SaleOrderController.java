package in.nit.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import in.nit.model.SaleOrder;
import in.nit.service.ISaleOrderService;
import in.nit.service.IShipmentTypeService;
import in.nit.utill.CommonUtil;

@Controller
@RequestMapping("/sale")
public class SaleOrderController {
	
	@Autowired
	private ISaleOrderService service;
	
	@Autowired
	private IShipmentTypeService shipService;
	
	public void commonUI(Model model) {
		List<Object[]> shipList = shipService.getShipmentIdAndCode();
		Map<Integer,String> shipMap = CommonUtil.convert(shipList);
		model.addAttribute("shipMap", shipMap);
	}

	@RequestMapping("/show")
	public String showSaleOrder(Model model) {
		SaleOrder so = new SaleOrder();
		so.setStatus("SALE-OPEN");
		model.addAttribute("saleOrder", so);
		commonUI(model);
		return "saleOrderViewPage";
		
	}
	
	@RequestMapping(method =POST,path = "/save")
	public String saveSaleOrder(@ModelAttribute SaleOrder order,Model model) {
		Integer id = service.saveSaleOrder(order);
		model.addAttribute("message", "Sale Order "+id+" is SAVE");
		return "saleOrderViewPage";
		
	}
	
}
