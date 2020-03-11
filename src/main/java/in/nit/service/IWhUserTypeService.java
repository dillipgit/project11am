package in.nit.service;

import java.util.List;

import in.nit.model.WhUserTypeModel;

public interface IWhUserTypeService {

	public Integer saveUser(WhUserTypeModel wtm);
	public List<WhUserTypeModel> selectAllUser();
	public void deleteOneUserById(Integer id);
	public WhUserTypeModel getOneUserType(Integer id);
	public void updateWhUser(WhUserTypeModel model);
	
	public List<Object[]> getUserTypeCount();
	public List<Object[]> getWhUserTypeIdAndCode(String userType);
}
