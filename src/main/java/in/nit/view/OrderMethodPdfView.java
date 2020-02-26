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

public class OrderMethodPdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, 
			                                                    Document document, 
			                                                    PdfWriter writer,
			                                                    HttpServletRequest request, 
			                                                    HttpServletResponse response) throws Exception {
		
		//download file
		response.addHeader("Content-Disposition","attachement;filename=Shipment.pdf");
		
		//create element
		Paragraph p = new Paragraph("Welcome To ShipmentType");
		
		
		//add element to document
		document.add(p);
		
		//read data from model
		List<ShipmentType> list = (List<ShipmentType>) model.get("list");
		
		//create table with no of colums
		PdfPTable t = new PdfPTable(6);
		t.addCell("ID");
		t.addCell("MODE");
		t.addCell("CODE");
		t.addCell("ENABLE SHIPMENT");
		t.addCell("GRADE");
		t.addCell("NOTE");
		
		//adding data to table
		for(ShipmentType st :list) {
			t.addCell(st.getShipId().toString());
			t.addCell(st.getShipMode());
			t.addCell(st.getShipCode());
			t.addCell(st.getEnbShip());
			t.addCell(st.getShipGrade());
			t.addCell(st.getShipDesc());
		}
		//add table to document
		document.add(t);
		//print data and time
		document.add(new Paragraph(new Date().toString()));
		
	}

}
