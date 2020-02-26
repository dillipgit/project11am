package in.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IDocumentDao;
import in.nit.model.Document;

@Service
public class DocumentServiceImpl implements IDocumentService{

	@Autowired
	private IDocumentDao dao;
	
	@Transactional
	@Override
	public Integer saveDocument(Document doc) {
		
		return dao.saveDocument(doc);
	}

	@Override
	public List<Object[]> getFileIdAndNames() {
		
		return dao.getFileIdAndNames();
	}

	@Override
	public Document getOneDocument(Integer id) {
		
		return dao.getOneDocument(id);
	}

}
