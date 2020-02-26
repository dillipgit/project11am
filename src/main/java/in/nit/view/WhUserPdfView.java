package in.nit.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import in.nit.model.ShipmentType;
import in.nit.model.WhUserTypeModel;

public class WhUserPdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, 
			                                                    Document document, 
			                                                    PdfWriter writer,
			                                                    HttpServletRequest request, 
			                                                    HttpServletResponse response) throws Exception {
		
		//download file
		response.addHeader("Content-Disposition","attachement;filename=WhUser.pdf");
		
		//create element
		Paragraph p = new Paragraph("Welcome To Whuser");
		
		
		//add element to document
		document.add(p);
		
		//read data from model
		List<WhUserTypeModel> list = (List<WhUserTypeModel>) model.get("list");
		
		//create table with no of colums
		PdfPTable t = new PdfPTable(9);
		t.addCell("ID");
		t.addCell("UTYPE");
		t.addCell("CODE");
		t.addCell("USER FOR");
		t.addCell("EMAIL");
		t.addCell("CONTACT");
		t.addCell("USERID TYPE");
		t.addCell("OTHER");
		t.addCell("ID NUMBER");
		
		//adding data to table
		for(WhUserTypeModel st :list) {
			t.addCell(st.getUserId().toString());
			t.addCell(st.getUserType());
			t.addCell(st.getUserCode());
			t.addCell(st.getUserFor());
			t.addCell(st.getEmail());
			t.addCell(st.getContact());
			t.addCell(st.getUserIdType());
			t.addCell(st.getOther());
			t.addCell(st.getId());
		}
		//add table to document
		document.add(t);
		//print data and time
		document.add(new Paragraph(new Date().toString()));
		
	}

}
