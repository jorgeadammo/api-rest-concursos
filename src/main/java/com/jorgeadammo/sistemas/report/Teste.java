package com.jorgeadammo.sistemas.report;

public class Teste {
	public static void main(String[] args){
		ClienteREL cliente = new ClienteREL();
		//JorgeREL cliente = new JorgeREL();
		try {
			cliente.imprimir();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
