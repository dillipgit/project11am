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

import in.nit.model.UOM;

public class UOMPdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, 
			                                                    Document document, 
			                                                    PdfWriter writer,
			                                                    HttpServletRequest request, 
			                                                    HttpServletResponse response) throws Exception {
		
		//download file
		response.addHeader("Content-Disposition","attachement;filename=UOM.pdf");
		
		//create element
		Paragraph p = new Paragraph("Welcome To UOM");
		
		
		//add element to document
		document.add(p);
		
		//read data from model
		List<UOM> list = (List<UOM>) model.get("list");
		
		//create table with no of colums
		PdfPTable t = new PdfPTable(4);
		t.addCell("ID");
		t.addCell("TYPE");
		t.addCell("MODEL");
		t.addCell("NOTE");
		
		//adding data to table
		for(UOM st :list) {
			t.addCell(st.getId().toString());
			t.addCell(st.getUmoType());
			t.addCell(st.getUmoModel());
			t.addCell(st.getDesc());
					}
		//add table to document
		document.add(t);
		//print data and time
		document.add(new Paragraph(new Date().toString()));
		
	}

}
