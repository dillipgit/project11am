package in.nit.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.model.PurchaseOrder;
import in.nit.model.ShipmentType;

@Repository
public class PurchaseDaoImpl implements IPurchaseDAO{
	
	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer savePurchase(PurchaseOrder pur) {
		
		return (Integer) ht.save(pur);
	}
	@Override
	public void deletePurchase(Integer id) {
		ht.delete(new PurchaseOrder(id));
		
	}
	@Override
	public List<PurchaseOrder> getAllPurchase() {
		return  ht.loadAll(PurchaseOrder.class);
	}
	@Override
	public PurchaseOrder getOnePurchaseType(Integer id) {
		return ht.get(PurchaseOrder.class, id);
	}
	@Override
	public void updateOnePurchase(PurchaseOrder ob) {
		ht.update(ob);
		
	}
		
}
