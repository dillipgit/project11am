package in.nit.service;

import java.util.List;

import in.nit.model.UOM;

public interface IUmoService {

	public Integer saveUmoData(UOM uom);
	public List<UOM> showAll();
	public void deleteById(Integer id);
	
	public UOM getOneUmo(Integer id);
	public void updateOneUom(UOM uom);
}
