package in.nit.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IPurchaseDAO;
import in.nit.model.PurchaseOrder;

//@Transactional(propagation = Propagation.REQUIRED)
@Service
public class PurchaseServiceImpl implements IPurchaseService{

	@Autowired
	private IPurchaseDAO dao;
	
	@Transactional
	@Override
	public Integer savePurchase(PurchaseOrder pur) {
		return dao.savePurchase(pur);
	}
	
	
	
	
	
	
	
	
	
	
	
	
//	@Override
//	public void deletePurchase(Integer id) {
//		dao.deletePurchase(id);
//		
//	}
//	@Override
//	public List<PurchaseOrder> getAllPurchase() {
//		
//		return dao.getAllPurchase();
//	}
//	@Override
//	public PurchaseOrder getOnePurchaseType(Integer id) {
//		
//		return dao.getOnePurchaseType(id);
//	}
//	@Override
//	public void updateOnePurchase(PurchaseOrder ob) {
//		dao.updateOnePurchase(ob);
//		
//	}
	
	
}
