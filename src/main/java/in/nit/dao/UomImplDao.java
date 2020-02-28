package in.nit.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.model.UOM;

@Repository
public class UomImplDao implements IUomDao{

	@Autowired
	private HibernateTemplate ht;
	
	public Integer saveUmoData(UOM uom) {
		return (Integer) ht.save(uom);
	}

	public List<UOM> showAll() {	
		return ht.loadAll(UOM.class);
	}

	public void deleteById(Integer id) {
		UOM un = new UOM();
		un.setId(id);
		ht.delete(un);	
	}

	@Override
	public UOM getOneUmo(Integer id) {
		
		return ht.get(UOM.class, id);
	}

	@Override
	public void updateOneUom(UOM uom) {
		ht.update(uom);
		
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<Object[]> getUOMtypes() {
		String GET_DATA_BY_TYPE="select umoType,count(umoType) "
				                                       + "  from in.nit.model.UOM group by umoType";
		return (List<Object[]>) ht.find(GET_DATA_BY_TYPE);
	}

}
