package in.nit.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import in.nit.model.Part;

public class PartExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// define filename
		response.addHeader("Content-Disposition", "attachment;filename=Part.xlsx");
		Sheet s = (Sheet) workbook.createSheet("PART");

		// construct-row-0
		setHeader(s);

		// read model data
		List<Part> list = (List<Part>) model.get("list");
		setBody(s, list);

	}

	private void setBody(Sheet s, List<Part> list) {
		Integer count = 1;

		for (Part st : list) {
			Row r = s.createRow(count++);
			r.createCell(0).setCellValue(st.getPrtCode());
			r.createCell(1).setCellValue(st.getPrtWidth());
			r.createCell(2).setCellValue(st.getPrtLength());
			r.createCell(3).setCellValue(st.getPrtHeight());
			r.createCell(4).setCellValue(st.getPrtCost());
			r.createCell(5).setCellValue(st.getPrtCurrency());
			r.createCell(6).setCellValue(st.getPrtDescription());

		}

	}

	private void setHeader(Sheet s) {
		Row r = s.createRow(0);
		r.createCell(0).setCellValue("CODE");
		r.createCell(1).setCellValue("WIDTH");
		r.createCell(2).setCellValue("LENGTH");
		r.createCell(3).setCellValue("HEIGHT");
		r.createCell(4).setCellValue("COST");
		r.createCell(5).setCellValue("CURRENCY");
		r.createCell(6).setCellValue("DESCRIPTION");
	}

}
