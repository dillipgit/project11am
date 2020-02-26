package in.nit.dao;

import java.util.List;

import in.nit.model.WhUserTypeModel;

public interface IWhUserTypeDAO {

	public Integer saveUser(WhUserTypeModel wtm);
	public List<WhUserTypeModel> selectAllUser();
	public void deleteOneUserById(Integer id);
	public WhUserTypeModel getOneUserType(Integer id);
	public void updateWhUser(WhUserTypeModel model);
}
