package in.nit.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.model.Part;

@Repository
public class PartDaoImpl implements IPartDAO {

	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Integer savePart(Part p) {
		return (Integer) ht.save(p);
	}

	@Override
	public List<Part> displayAllPart() {
		
		return ht.loadAll(Part.class);
	}

	@Override
	public void deletePartById(Integer id) {
		Part p = new Part();
		p.setParId(id);
		ht.delete(p);
	}

	@Override
	public Part getOnePart(Integer id) {
		
		return ht.get(Part.class, id);
	}

	@Override
	public void updateOnePart(Part p) {
	ht.update(p);
	}
}
