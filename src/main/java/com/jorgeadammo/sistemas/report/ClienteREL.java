package com.jorgeadammo.sistemas.report;

//import java.util.List;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
//import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
//import br.com.rdtecnologia.model.Cliente;
 
public class ClienteREL 
{
	private String path; //Caminho base
	
	private String pathToReportPackage; // Caminho para o package onde estão armazenados os relatorios Jarper
	
	//Recupera os caminhos para que a classe possa encontrar os relatórios
	public ClienteREL() {
		this.path = this.getClass().getClassLoader().getResource("").getPath();
		this.pathToReportPackage = this.path + "com/jorgeadammo/sistemas/report/";
		System.out.println(path);
	}
	
	
	//Imprime/gera uma lista de Clientes
	public void imprimir() throws Exception	
	{
		//JasperReport report = JasperCompileManager.compileReport(this.getPathToReportPackage() + "exemplojm.jrxml");
		JasperReport report = JasperCompileManager.compileReport(this.getPathToReportPackage() + "relatorioTeste.jrxml");
		JasperCompileManager.compileReportToFile(this.getPathToReportPackage() + "relatorioTeste.jrxml");

		
		System.out.println(">>>>>>>>" + report + "<<<<<<<<");
		//System.out.println(">>>>>>>>" + jasper + "<<<<<<<<");
		
		JasperPrint print = JasperFillManager.fillReport(report, null);
 
		JasperExportManager.exportReportToPdfFile(print, "JASPER_JORGE.pdf");		
	}
 
	public String getPathToReportPackage() {
		return this.pathToReportPackage;
	}
	
	public String getPath() {
		return this.path;
	}
}
