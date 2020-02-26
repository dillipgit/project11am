package in.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IWhUserTypeDAO;
import in.nit.model.WhUserTypeModel;

@Service
public class WhUserTypeServiceImpl implements IWhUserTypeService{

	@Autowired
	private IWhUserTypeDAO dao;
	
	@Transactional
	@Override
	public Integer saveUser(WhUserTypeModel wtm) {
		
		return dao.saveUser(wtm);
	}

	@Transactional
	@Override
	public List<WhUserTypeModel> selectAllUser() {
		
		return dao.selectAllUser();
	}

	@Transactional
	@Override
	public void deleteOneUserById(Integer id) {
		dao.deleteOneUserById(id);
		
	}

	@Override
	public WhUserTypeModel getOneUserType(Integer id) {
		
		return dao.getOneUserType(id);
	}

	@Transactional
	@Override
	public void updateWhUser(WhUserTypeModel model) {
		dao.updateWhUser(model);
		
	}

}
