package in.nit.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.model.WhUserTypeModel;

@Repository
public class WhUserTypeDAOImpl implements IWhUserTypeDAO{

	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Integer saveUser(WhUserTypeModel wtm) {
		
		return (Integer) ht.save(wtm);
	}

	@Override
	public List<WhUserTypeModel> selectAllUser() {
		return ht.loadAll(WhUserTypeModel.class);
	}

	@Override
	public void deleteOneUserById(Integer id) {
		WhUserTypeModel model = new WhUserTypeModel();
		model.setUserId(id);
		ht.delete(model);
		
		
	}

	@Override
	public WhUserTypeModel getOneUserType(Integer id) {
		
		return ht.get(WhUserTypeModel.class, id);
	}

	@Override
	public void updateWhUser(WhUserTypeModel model) {
		ht.update(model);
		
	}

}
