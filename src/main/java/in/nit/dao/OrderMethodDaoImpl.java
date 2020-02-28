package in.nit.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.model.OrderMethod;

@Repository
public class OrderMethodDaoImpl implements IOrderMethodDAO{

	@Autowired
	private HibernateTemplate ht;
	
	public Integer saveOrderData(OrderMethod om) {
	
		return (Integer) ht.save(om);
	}

	public List<OrderMethod> getAllOrderById() {
		List<OrderMethod> list = ht.loadAll(OrderMethod.class);
		return list;
	}

	public void deleteOrderById(Integer id) {
		OrderMethod om = new OrderMethod();
		om.setId(id);
		ht.delete(om);
		
	}

	@Override
	public OrderMethod getOneOrderById(Integer id) {
		
		return ht.get(OrderMethod.class, id);
	}

	@Override
	public void updateOrderData(OrderMethod om) {
		ht.update(om);
		
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<Object[]> getOrderTypeCount() {
		String GET_ORDER_TYPE_COUNT_QUERY="SELECT orderType,count(orderType) from "
				                                                                    + "  in.nit.model.OrderMethod "
				                                                                    + "  group by orderType";
		return (List<Object[]>) ht.find(GET_ORDER_TYPE_COUNT_QUERY);
	}

}
