package in.nit.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IShipmentTypeDao;
import in.nit.model.ShipmentType;

@Service
public class ShipmentTypeServiceImpl implements IShipmentTypeService {

	@Autowired
	private IShipmentTypeDao dao;
	
	@Transactional
	@Override
	public Integer saveShipmentService(ShipmentType st) {
		return dao.saveShipmentType(st);
	}

	@Transactional(readOnly = true)
	@Override
	public List<ShipmentType> getAllShipmentType() {
		List<ShipmentType> list = dao.getAllShipmentType();
		Collections.sort(list,
				(o1,o2)->o1.getShipId()-o2.getShipId());
		return list;
	}

	@Transactional
	@Override
	public void deleteShipment(Integer id) {
		dao.deleteShipment(id);
		
	}

	
	@Transactional
	@Override
	public ShipmentType getOneShipmentType(Integer id) {
		
		return dao.getOneShipmentType(id);
	}
	
	

	@Override
	@Transactional
	public void updateOneShipment(ShipmentType ob) {
		dao.updateOneShipment(ob);
		
	}

}
