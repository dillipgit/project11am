package in.nit.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import in.nit.model.ShipmentType;
import in.nit.model.UOM;

public class UOMExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// define filename
		response.addHeader("Content-Disposition", "attachment;filename=UOM.xlsx");
		Sheet s = (Sheet) workbook.createSheet("UOM");

		// construct-row-0
		setHeader(s);

		// read model data
		List<UOM> list = (List<UOM>) model.get("list");
		setBody(s, list);

	}

	private void setBody(Sheet s, List<UOM> list) {
		Integer count = 1;

		for (UOM st : list) {
			Row r = s.createRow(count++);
			r.createCell(0).setCellValue(st.getId());
			r.createCell(1).setCellValue(st.getUmoType());
			r.createCell(2).setCellValue(st.getUmoModel());
			r.createCell(3).setCellValue(st.getDesc());
			
		}

	}

	private void setHeader(Sheet s) {
		Row r = s.createRow(0);
		r.createCell(0).setCellValue("ID");
		r.createCell(1).setCellValue("TYPE");
		r.createCell(2).setCellValue("MODEL");
		r.createCell(3).setCellValue("NOTE");
	}

}
