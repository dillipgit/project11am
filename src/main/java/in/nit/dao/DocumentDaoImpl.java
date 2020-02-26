package in.nit.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.model.Document;

@Repository
public class DocumentDaoImpl implements IDocumentDao {

	@Autowired
	private HibernateTemplate ht;


	@Override
	public Integer saveDocument(Document doc) {

		return  (Integer) ht.save(doc);
	}


	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<Object[]> getFileIdAndNames() {
		String GET_FILEID_NAMES_QUERY="SELECT fileId,filename FROM "
				                                                                  + "in.nit.model.Document";
		
		return (List<Object[]>) ht.find(GET_FILEID_NAMES_QUERY);
	}


	@Override
	public Document getOneDocument(Integer id) {
		
		return ht.get(Document.class, id);
	}

}
