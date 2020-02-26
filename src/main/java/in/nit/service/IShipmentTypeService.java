package in.nit.service;

import java.util.List;

import in.nit.model.ShipmentType;

public interface IShipmentTypeService {

	public Integer saveShipmentService(ShipmentType st);
	public List<ShipmentType> getAllShipmentType();
	public void deleteShipment(Integer id);
	
	public ShipmentType getOneShipmentType(Integer id);
	public void updateOneShipment(ShipmentType ob);
	
}
