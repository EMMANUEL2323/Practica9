package app.poo.ito;

import java.awt.HeadlessException;
import java.io.FileNotFoundException;

import Clases.ito.poo.EscritorArchivoTXT;
import Clases.ito.poo.LectorArchivoTXT;
import Clases.ito.poo.Cuenta_Bancaria;
import Clases.ito.poo.CuentasBancareas;

import java.util.ArrayList;

public class MyApp {
	
	static CuentasBancareas c=new CuentasBancareas();
	static EscritorArchivoTXT archivo;
	static LectorArchivoTXT archivo2;
	
	static void run() throws Exception {
		
		Aplicacion.menu();
		   
			
    }
	
	
	static void crearArchivo() throws FileNotFoundException {
		archivo = new EscritorArchivoTXT("cuentas.txt");
	}


	
	public static void main(String[] args) throws Exception{
	
			run();
			
			
	}
		
}
	