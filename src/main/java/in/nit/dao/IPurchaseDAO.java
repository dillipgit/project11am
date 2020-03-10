package in.nit.dao;

import java.util.List;

import in.nit.model.PurchaseOrder;

public interface IPurchaseDAO {

	public Integer savePurchase(PurchaseOrder pur);
	public List<PurchaseOrder> getAllPurchase();
	public void deletePurchase(Integer id);
	
	public PurchaseOrder getOnePurchaseType(Integer id);
	public void updateOnePurchase(PurchaseOrder ob);
}
