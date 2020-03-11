package in.nit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.ISaleOrderDAO;
import in.nit.model.SaleOrder;

@Service
public class SaleOrderServiceImpl implements ISaleOrderService{

	@Autowired
	private ISaleOrderDAO dao;
	
	@Transactional
	@Override
	public Integer saveSaleOrder(SaleOrder order) {
		
		return dao.saveSaleOrder(order);
	}
}
