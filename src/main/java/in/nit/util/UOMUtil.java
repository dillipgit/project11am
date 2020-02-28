package in.nit.util;

import java.io.File;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;

@Component
public class UOMUtil {

	public void generatePie(String path, List<Object[]> data) {
		// create dataset
		DefaultPieDataset dataset = new DefaultPieDataset();
		for (Object[] arr : data) {
			// key-shipMode,val-count
			dataset.setValue(arr[0].toString(), Double.valueOf(arr[1].toString()));
		}
		// create Jfreechart using chartfactory
		JFreeChart chart = ChartFactory.createPieChart3D("UOM", dataset, true, true, false);
		// save as image using chartUtil
		try {
			ChartUtils.saveChartAsJPEG(new File(path + "/resources/images/pie.png"), chart, 400, 400);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void generateBar(String path,List<Object[]> data) {
		//create dataset
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for(Object[] arr:data) {
			//key-shipMode,val-count
			dataset.setValue(Double.valueOf(arr[1].toString()),arr[0].toString(),"");
		}
		//create Jfreechart using chartfactory
		JFreeChart chart = ChartFactory.createBarChart("UOM","modes","count",dataset);
		//save as image using chartUtil
		try {
			ChartUtils.saveChartAsJPEG(new File(path+"/resources/images/barchat.png"),chart,400,400);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
	}

}
