package in.nit.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IPartDAO;
import in.nit.model.Part;

@Service
public class PartServiceImpl implements IPartService{

	@Autowired
	private IPartDAO dao;
	
	@Transactional
	@Override
	public Integer savePart(Part p) {
		
		return dao.savePart(p);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Part> displayAllPart() {
	
      List<Part> list = dao.displayAllPart();

		for(Object o:list) {
			System.out.println(o);
	}
		//Collections.sort(list,
				//  (o1,o2)->o1.getPId()-o2.getPId());
		return list;
	}

	@Transactional
	@Override
	public void deletePartById(Integer id) {
		dao.deletePartById(id);
		
	}

	@Transactional(readOnly = true)
	@Override
	public Part getOnePart(Integer id) {

		return dao.getOnePart(id);
	}


	@Transactional
	@Override
	public void updateOnePart(Part p) {
		dao.updateOnePart(p);
		
	}

}
