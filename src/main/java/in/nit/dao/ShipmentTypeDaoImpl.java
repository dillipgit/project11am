package in.nit.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.model.ShipmentType;

@Repository
public class ShipmentTypeDaoImpl implements IShipmentTypeDao{

	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Integer saveShipmentType(ShipmentType st) {
		return (Integer) ht.save(st);
	}

	@Override
	public List<ShipmentType> getAllShipmentType() {
		return  ht.loadAll(ShipmentType.class);
	
	}

	@Override
	public void deleteShipment(Integer id) {
//		ShipmentType st= new ShipmentType();
//		st.setShipId(id);
//		ht.delete(st);
		
		ht.delete(new ShipmentType(id));
		
	}

	@Override
	public ShipmentType getOneShipmentType(Integer id) {
		
		return ht.get(ShipmentType.class, id);
	}

	@Override
	public void updateOneShipment(ShipmentType ob) {
		ht.update(ob);
		
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<Object[]> getShipmentModeCount() {
		String COUNT_SHIPMODE_QUERY="select shipMode,count(shipMode) "
				                                                    + " from in.nit.model.ShipmentType  "
				                                                    + " group by shipMode";
		return (List<Object[]>) ht.find(COUNT_SHIPMODE_QUERY);
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Object[]> getShipmentIdAndCode() {
		String HQL=" select shipId,shipCode from  "
	                          +ShipmentType.class.getName()+
	                                                 "  where enbShip = 'yes' ";
		return (List<Object[]>) ht.find(HQL);
	}
	
	

}
