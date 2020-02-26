package in.nit.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import in.nit.model.WhUserTypeModel;

public class WhUserExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// define filename
		response.addHeader("Content-Disposition", "attachment;filename=WhUser.xlsx");
		Sheet s = (Sheet) workbook.createSheet("WhUser");

		// construct-row-0
		setHeader(s);

		// read model data
		List<WhUserTypeModel> list = (List<WhUserTypeModel>) model.get("list");
		setBody(s, list);

	}

	private void setBody(Sheet s, List<WhUserTypeModel> list) {
		Integer count = 1;

		for (WhUserTypeModel st : list) {
			Row r = s.createRow(count++);
			r.createCell(0).setCellValue(st.getUserId());
			r.createCell(1).setCellValue(st.getUserType());
			r.createCell(2).setCellValue(st.getUserCode());
			r.createCell(3).setCellValue(st.getUserFor());
			r.createCell(4).setCellValue(st.getEmail());
			r.createCell(5).setCellValue(st.getContact());
			r.createCell(6).setCellValue(st.getUserIdType());
			r.createCell(7).setCellValue(st.getOther());
			r.createCell(8).setCellValue(st.getId());

		}
	}
	private void setHeader(Sheet s) {
		Row r = s.createRow(0);
		r.createCell(0).setCellValue("ID");
		r.createCell(1).setCellValue("UTYPE");
		r.createCell(2).setCellValue("CODE");
		r.createCell(3).setCellValue("USER FOR");
		r.createCell(4).setCellValue("EMAIL");
		r.createCell(5).setCellValue("CONTACT");
		r.createCell(6).setCellValue("USERID TYPE");
		r.createCell(7).setCellValue("OTHER");
		r.createCell(8).setCellValue("ID NUMBER");
	}

}
