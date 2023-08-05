package com.jorgeadammo.sistemas.report;



import net.sf.jasperreports.engine.JREmptyDataSource;
//import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.JasperReport;

public class JorgeREL 
{
	private String path; //Caminho base
	
	private String pathToReportPackage; // Caminho para o package onde estão armazenados os relatorios Jarper
	
	//Recupera os caminhos para que a classe possa encontrar os relatórios
	public JorgeREL() {
		this.path = this.getClass().getClassLoader().getResource("").getPath();
		this.pathToReportPackage = this.path + "com/jorgeadammo/sistemas/report/";
		System.out.println(path);
	}
	
	
	//Imprime/gera uma lista de Clientes
	public void imprimir() throws Exception	
	{
		//JasperReport report = JasperCompileManager.compileReport(this.getPathToReportPackage() + "relatorioTeste.jrxml");
		//JasperPrint print = JasperFillManager.fillReport(report, null);
		//JasperExportManager.exportReportToPdfFile(print, "REPORT_JORGE.pdf");	
		
		//Obtem o valor atual do sistema
		long inicioContagem = System.currentTimeMillis();
				
		//Compilacao no formato jasper para o jrprint
		JasperFillManager.fillReportToFile(this.getPathToReportPackage() + "relatorioTeste.jasper", null, new JREmptyDataSource(1));
		System.err.println("Tempo de compilacao jasper -> jrprint: " + (System.currentTimeMillis() - inicioContagem));
				
		//Reinicia o contador
		inicioContagem = System.currentTimeMillis();
				
		//Geracao do PDF
		JasperExportManager.exportReportToPdfFile(this.getPathToReportPackage() + "relatorioTeste.jrprint");
		System.err.println("Tempo de geracao do PDF: " + (System.currentTimeMillis() - inicioContagem));
	}

	public String getPathToReportPackage() {
		return this.pathToReportPackage;
	}
	
	public String getPath() {
		return this.path;
	}
}
