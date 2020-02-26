package in.nit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import in.nit.model.OrderMethod;
import in.nit.service.IOrderService;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private IOrderService service;

	@RequestMapping("/show")
	public String show(Model model) {
		model.addAttribute("orderMethod", new OrderMethod());
		return "orderMethod";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveOrder(@ModelAttribute OrderMethod order, Model model) {
		Integer id = service.saveOrderData(order);
		String message = "Order Data " + id + " save";
		model.addAttribute("msg", message);
		model.addAttribute("orderMethod", new OrderMethod());
		return "orderMethod";
	}

	@RequestMapping("/all")
	public String showAllData(Model model) {

		List<OrderMethod> list = service.getAllDataById();
		model.addAttribute("list", list);
		return "orderData";

	}

	@RequestMapping("/delete")
	public String deleteDataById(@RequestParam("mid") Integer id, Model model) {
		service.deleteOrderById(id);
		String msg = "deleteed data is" + id;
		model.addAttribute("msg", msg);

		List<OrderMethod> list = service.getAllDataById();
		model.addAttribute("list", list);
		return "orderData";

	}
	
	@RequestMapping("/edit")
	public String showEditPage(@RequestParam("mid")Integer id,Model model) {
		OrderMethod om = service.getOneOrderById(id);
		model.addAttribute("orderMethod",om);
		return "orderMethodEdit";
	}
	
	@RequestMapping(method = RequestMethod.POST,value = "/update")
	public String updatedOrder(@ModelAttribute OrderMethod order,Model model) {
		service.updateOrderData(order);
		String msg = "updated order id"+order.getId();
		model.addAttribute("msg",msg);
		
		List<OrderMethod> list = service.getAllDataById();
		model.addAttribute("list",list);
		
		return "orderData";
	}
	@RequestMapping("/view")
	public String showOneOrder(@RequestParam("mid")Integer idd,Model model) {
		OrderMethod order = service.getOneOrderById(idd);
		model.addAttribute("ob",order);
		return "showOneOrder";
	}

}
