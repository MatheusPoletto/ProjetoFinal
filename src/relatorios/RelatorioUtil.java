package relatorios;

// o de cima é melhor e mais rapido. 

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class RelatorioUtil {

	public void viewReport(String pathRelatorio, Connection con,
			Map<String, Object> parametros) {
		try {
			JasperPrint jasperPrint = JasperFillManager.fillReport(
					pathRelatorio, parametros, con);
			JasperViewer.viewReport(jasperPrint);
		} catch (JRException e) {
			e.printStackTrace();
		}
	}

	public void compileViewReport(String pathRelatorio, Connection con,
			Map<String, Object> parametros) {
		try {
			JasperDesign jasperDesign = JRXmlLoader.load(pathRelatorio); // Lê o
																			// arquivo
			JasperReport jr = JasperCompileManager.compileReport(jasperDesign); // Compila

			JasperPrint jasperPrint = JasperFillManager.fillReport(jr,
					parametros, con);
			JasperViewer.viewReport(jasperPrint);
		} catch (JRException e) {
			e.printStackTrace();
		}
	}
	
	// em caso de usar na web. Ou se a pessoa não tiver o jasper o pdf é melhor. 

	public void gerarPdf(String pathRelatorio, Connection con,
			Map<String, Object> parametros) {
		try {
			JasperPrint jasperPrint = JasperFillManager.fillReport(
					pathRelatorio, parametros, con);

			JasperExportManager.exportReportToPdfFile(jasperPrint,
					"relatorio.pdf");
		} catch (JRException e) {
			e.printStackTrace();
		}
	}
	
	
	//  professor falo que usa essa aqui. 
	public void compileViewReport(String pathRelatorio, List<?> dados,
			Map<String, Object> parametros) {
		try {
			JasperDesign jasperDesign = JRXmlLoader.load(pathRelatorio); // Lê o
			
			JRDataSource dataSource = new JRBeanCollectionDataSource(dados);															// arquivo
			
			JasperReport jr = JasperCompileManager.compileReport(jasperDesign); // Compila

			JasperPrint jasperPrint = JasperFillManager.fillReport(jr,
					parametros, dataSource);
			JasperViewer.viewReport(jasperPrint);
		} catch (JRException e) {
			e.printStackTrace();
		}
	}
}
