package in.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IOrderMethodDAO;
import in.nit.model.OrderMethod;

@Service
public class OrderServiceImpl implements IOrderService{

	@Autowired
	private IOrderMethodDAO dao;
	
	@Transactional
	public Integer saveOrderData(OrderMethod om) {
		return dao.saveOrderData(om);
	}

	@Transactional
	public List<OrderMethod> getAllDataById() {
		return dao.getAllOrderById();
	}

	@Transactional
	public void deleteOrderById(Integer id) {
		dao.deleteOrderById(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public OrderMethod getOneOrderById(Integer id) {
		
		return dao.getOneOrderById(id);
	}

	@Override
	@Transactional
	public void updateOrderData(OrderMethod om) {
		dao.updateOrderData(om);
		
	}

	@Override
	public List<Object[]> getOrderTypeCount() {
		
		return dao.getOrderTypeCount();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Object[]> getOrderIdAndCode(String mode) {
		List<Object[]> list = dao.getOrderIdAndCode(mode);
		return list;
	}

}
