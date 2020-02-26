package in.nit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import in.nit.model.OrderMethod;

@Service
public interface IOrderService {

	public Integer saveOrderData(OrderMethod om);
	public List<OrderMethod> getAllDataById();
	public void deleteOrderById(Integer id);
	
	public OrderMethod getOneOrderById(Integer id);
	public void updateOrderData(OrderMethod om);


	
}
