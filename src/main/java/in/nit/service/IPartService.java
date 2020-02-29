package in.nit.service;

import java.util.List;

import in.nit.model.Part;

public interface IPartService {

	public Integer savePart(Part p);
	public List<Part> displayAllPart();
	public void deletePartById(Integer id);
	public Part getOnePart(Integer id);
	public void updateOnePart(Part p);
}
