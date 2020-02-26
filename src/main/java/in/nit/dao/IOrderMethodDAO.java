package in.nit.dao;

import java.util.List;

import in.nit.model.OrderMethod;

public interface IOrderMethodDAO {
	public Integer saveOrderData(OrderMethod om);
	public List<OrderMethod> getAllOrderById();
	public void deleteOrderById(Integer id);
	
	public OrderMethod getOneOrderById(Integer id);
	public void updateOrderData(OrderMethod om);

}
