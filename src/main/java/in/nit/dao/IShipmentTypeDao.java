package in.nit.dao;

import java.util.List;

import in.nit.model.ShipmentType;

public interface IShipmentTypeDao {

	public Integer saveShipmentType(ShipmentType st);
	public List<ShipmentType> getAllShipmentType();
	public void deleteShipment(Integer id);
	
	public ShipmentType getOneShipmentType(Integer id);
	public void updateOneShipment(ShipmentType ob);
}
