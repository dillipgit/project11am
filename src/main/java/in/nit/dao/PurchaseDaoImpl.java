package in.nit.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.model.PurchaseOrder;


@Repository
public class PurchaseDaoImpl implements IPurchaseDAO{
	
	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer savePurchase(PurchaseOrder pur) {
		
		return (Integer) ht.save(pur);
	}
	
		
}
