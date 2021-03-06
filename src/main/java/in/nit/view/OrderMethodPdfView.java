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

import in.nit.model.OrderMethod;

public class OrderMethodPdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, 
			                                                    Document document, 
			                                                    PdfWriter writer,
			                                                    HttpServletRequest request, 
			                                                    HttpServletResponse response) throws Exception {
		
		//download file
		response.addHeader("Content-Disposition","attachement;filename=ordermethod.pdf");
		
		//create element
		Paragraph p = new Paragraph("Welcome To Order Method");
		
		
		//add element to document
		document.add(p);
		
		//read data from model
		List<OrderMethod> list = (List<OrderMethod>) model.get("list");
		
		//create table with no of colums
		PdfPTable t = new PdfPTable(6);
		t.addCell("ID");
		t.addCell("MODE");
		t.addCell("CODE");
		t.addCell("METHOD");
		t.addCell("ACCEPT");
		t.addCell("NOTE");
		
		//adding data to table
		for(OrderMethod st :list) {
			t.addCell(st.getId().toString());
			t.addCell(st.getMode());
			t.addCell(st.getCode());
			t.addCell(st.getOrderType());
			//t.addCell(st.getAccept());
			t.addCell(st.getDesc());
		}
		//add table to document
		document.add(t);
		//print data and time
		document.add(new Paragraph(new Date().toString()));
		
	}

}
