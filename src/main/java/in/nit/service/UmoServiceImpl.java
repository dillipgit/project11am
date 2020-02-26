package in.nit.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IUomDao;
import in.nit.model.UOM;

@Service
public class UmoServiceImpl implements IUmoService{

	@Autowired
	private IUomDao dao;
	
	@Transactional
	public Integer saveUmoData(UOM uom) {		
		return dao.saveUmoData(uom);
	}

	@Transactional
	public List<UOM> showAll() {
		List<UOM> list = dao.showAll();
		
//		Collections.sort(list,
//				(o1,o2) ->o1.getId()-o2.getId();
//		);
		Collections.sort(list, 
				new Comparator<UOM>() {
					public int compare(UOM o1, UOM o2) {
						return o1.getId()-o2.getId();
					}
				});
		return list;
	}

	@Transactional
	public void deleteById(Integer id) {
		dao.deleteById(id);
		
	}

	@Transactional
	@Override
	public UOM getOneUmo(Integer id) {
		
		return dao.getOneUmo(id);
	}

	@Transactional
	@Override
	public void updateOneUom(UOM uom) {
		dao.updateOneUom(uom);
		
	}

}
