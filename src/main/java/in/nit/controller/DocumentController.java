package in.nit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import in.nit.model.Document;
import in.nit.service.IDocumentService;

@Controller
@RequestMapping("/docs")
public class DocumentController {

	@Autowired
	private IDocumentService service;

	// show page
	@RequestMapping("/show")
	public String showUplodPage(Model model) {
		List<Object[]> list = service.getFileIdAndNames();
		model.addAttribute("list",list);
		return "documents";

	}

	// upload data into database
	@RequestMapping(value = "/upload",method = RequestMethod.POST)
	public String upload(@RequestParam  Integer fileId,
			                           @RequestParam CommonsMultipartFile fileOb,
			                           Model model) {
		
		System.out.println(fileId);
		if (fileOb != null) {
			Document doc = new Document();
			doc.setFileId(fileId);
			doc.setFilename(fileOb.getOriginalFilename());
			doc.setFileData(fileOb.getBytes());
			service.saveDocument(doc);
			
			String msg = fileId + " is Upload";
			model.addAttribute("message", msg);

		}
		return "redirect:show";

	}
	
	//for download one document
	@RequestMapping("/download")
	public void download(@RequestParam Integer fileId,
			                                 HttpServletResponse res) {
		
		//read one object based on the id
		Document doc = service.getOneDocument(fileId);
		res.addHeader("Content-Disposition","attachement;filename="+doc.getFilename());
		
		try {
			//copy data to os
			FileCopyUtils.copy(doc.getFileData(),res.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
