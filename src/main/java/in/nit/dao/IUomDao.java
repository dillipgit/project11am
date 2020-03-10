package in.nit.dao;

import java.util.List;

import in.nit.model.UOM;

public interface IUomDao {
	
	public Integer saveUmoData(UOM uom);
	public List<UOM> showAll();
	public void deleteById(Integer id);
	
	public UOM getOneUmo(Integer id);
	public void updateOneUom(UOM uom);
	
	public List<Object[]> getUOMtypes();
	
	public List<Object[]> getUomIdAndModel();

}
