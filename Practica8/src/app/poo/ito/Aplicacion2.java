package app.poo.ito;
import javax.swing.JOptionPane;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import Clases.ito.poo.Cuenta_Bancaria;
import Clases.ito.poo.CuentasBancareas;
import Clases.ito.poo.EscritorArchivoTXT;
import Clases.ito.poo.LectorArchivoTXT;
import Clases.ito.poo.LectorObjetos;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.util.ArrayList;
public class Aplicacion2 {


	static CuentasBancareas c;
	static Cuenta_Bancaria e;
	static LectorObjetos inputFile=null;
	
	static void menu() throws Exception {
		inicializa();
		iniciaPrograma();
		final JPanel panel=new JPanel();
		boolean error=true;
		while(error) {
		try {
		boolean ciclo=true;
		int respuesta=0;
		while(ciclo) {
		String opciones="Elige la accion que desees realizar:\n 1)Agregar cuenta\n 2)Imprimir cuentas existentes\n 3)Hacer depósito a una cuenta\n "
				+ "4)Hacer retiro a una cuenta\n 5)Dar de baja una cuenta\n 6)Hacer una consulta\n 7)Salir";
		respuesta=Integer.parseInt(JOptionPane.showInputDialog(opciones));
		switch(respuesta) {
		case 1:agregarCuenta();break;
		case 2:mostrarCuentas();break;
		case 3:hacerDeposito();break;
		case 4:hacerRetiro();break;
		case 5:borrarCuenta();break;
		case 6:consulta();break;
		case 7:ciclo=false;error=false;break;
		default:JOptionPane.showMessageDialog(null,"Ingrese una de las acciones mencionadas de favor");
		}
		
		
	}
		}catch(HeadlessException e){
			JOptionPane.showMessageDialog(panel,e.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
		}catch(FileNotFoundException e) {
			JOptionPane.showMessageDialog(panel,e.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
}
	
	static Cuenta_Bancaria capturarCuenta() throws HeadlessException,FileNotFoundException {
		Cuenta_Bancaria n=new Cuenta_Bancaria();
		long l;String fecha,nombre;float saldo;
		l=Long.parseLong(JOptionPane.showInputDialog("Mencione el número de cuenta:"));
		nombre=JOptionPane.showInputDialog("Mencione el nombre del cliente:");
		saldo=Float.parseFloat(JOptionPane.showInputDialog("Mencione el saldo de la cuenta:"));
		fecha=JOptionPane.showInputDialog("Mencione la fecha de la apertura(aaaa-mm-dd):");
		try {
			n.setNumCuenta(l);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		n.setNomCliente(nombre);
		n.setSaldo(saldo);
		n.setFechaApertura(LocalDate.parse(fecha));
		return n;
	}
	
	static void inicializa() {
		c=new CuentasBancareas();
	}
	
	static void agregarCuenta() throws Exception {
		Cuenta_Bancaria nueva;
		nueva=capturarCuenta();
		c.exepcionCuentaExistente(nueva);
		c.addItem(nueva);
	    JOptionPane.showMessageDialog(null,"¡Se ah añadido la cuenta satisfactoriamente!");
			if(c.isFull())
				c.crecerArreglo();
		
		
	}
	
	static void mostrarCuentas() {
		if(c.isFree())
			JOptionPane.showMessageDialog(null,"Todavía no existe alguna cuenta");
		else {
		String cuentas="";
		for(int i=0;i<c.getSize();i++)
			cuentas=cuentas+"\n"+(c.getItem(i));
		JOptionPane.showMessageDialog(null,cuentas);
		}
	}
	
	static void hacerDeposito() throws HeadlessException,FileNotFoundException {
		int pos=0;
		float cantidad=0;
		if(c.isFree())
			JOptionPane.showMessageDialog(null,"Todavía no existe alguna cuenta");
		else {
			boolean bandera=true;
			while(bandera) {
		    String cuentas="";
		    for(int i=0;i<c.getSize();i++)
			    cuentas=cuentas+"\n"+(i+1)+")"+(c.getItem(i));
		    pos=Integer.parseInt(JOptionPane.showInputDialog("Mencione la cuenta a la cual desee hacer un deposito\n"+cuentas));
		    if((c.getSize())>=pos&&pos>0) {
		    cantidad=Float.parseFloat(JOptionPane.showInputDialog("Cuanta cantidad desea depositar?"));
		    c.exceptionDeposito(cantidad);
		    c.getItem(pos-1).setSaldoActualizado(c.getItem(pos-1).getSaldo()+cantidad);
		    c.getItem(pos-1).setFechaActualizacion(LocalDate.now());
		    JOptionPane.showMessageDialog(null,"¡Dinero depositado satisfactoriamente!");
		    bandera=false;
		    }
		    else
		    	JOptionPane.showMessageDialog(null,"¡Esa cuenta no es existente!");
			}
		}
	}
	
	static void hacerRetiro() throws HeadlessException,FileNotFoundException {
		int pos=0;
		float cantidad=0;
		if(c.isFree())
			JOptionPane.showMessageDialog(null,"Todavía no existe alguna cuenta");
		else {
			boolean bandera=true;
			while(bandera) {
		    String cuentas="";
		    for(int i=0;i<c.getSize();i++)
			    cuentas=cuentas+"\n"+(i+1)+")"+(c.getItem(i));
		    pos=Integer.parseInt(JOptionPane.showInputDialog("Mencione la cuenta a la cual desee hacer un retiro\n"+cuentas));
		    if((c.getSize())>=pos&&pos>0) {
		    cantidad=Float.parseFloat(JOptionPane.showInputDialog("Cuanta cantidad desea retirar?"));
		    c.exceptionDeposito(cantidad);
		    if(!(c.getItem(pos-1).getSaldo()<cantidad)) {
		    c.getItem(pos-1).setSaldoActualizado(c.getItem(pos-1).getSaldo()-cantidad);
		    c.getItem(pos-1).setFechaActualizacion(LocalDate.now());
		    JOptionPane.showMessageDialog(null,"¡Dinero retirado satisfactoriamente!");
		    bandera=false;
		    }
		    else {
		    	JOptionPane.showMessageDialog(null,"La cantidad sobrepasa saldo de la cuenta!");
		    }
		    }
		    else
		    	JOptionPane.showMessageDialog(null,"¡Esa cuenta no es existente!");
			}
		}
	}
	
	static void borrarCuenta() throws HeadlessException,FileNotFoundException {
		int pos=0;
		if(c.isFree())
			JOptionPane.showMessageDialog(null,"Todavía no existe alguna cuenta");
		else {
			boolean bandera=true;
			while(bandera) {
		    String cuentas="";
		    for(int i=0;i<c.getSize();i++)
			    cuentas=cuentas+"\n"+(i+1)+")"+(c.getItem(i));
		    pos=Integer.parseInt(JOptionPane.showInputDialog("Mencione la cuenta que desee dar de baja\n"+cuentas));
		    if((c.getSize())>=pos&&pos>0) {
		    	c.exepcionBorraCuenta(c.getItem(pos-1));
		    	c.clear(c.getItem(pos-1));
		    	JOptionPane.showMessageDialog(null,"¡Cuenta dada de baja satisfactoriamente!");
		    	bandera=false;
		    }	
		    else
		    	JOptionPane.showMessageDialog(null,"¡Esa cuenta no es existente!");
		  }
		}
	}
	
	static void consulta() {
		int respuesta=0;
		boolean ciclo=true;
		while(ciclo) {
		String opciones="Elige la accion de consulta que desees realizar:\n 1)Monto total de cuentas\n 2)Monto promedio de cuentas\n"
				+ " 3)Cuentas con saldo que sobrepasa de los $10,000\n "
				+ "4)Cuenta/s con saldo maximo\n 5)Cuenta/s con saldo mínimo\n 6)Salir";
		respuesta=Integer.parseInt(JOptionPane.showInputDialog(opciones));
		switch(respuesta) {
		case 1:montoTotal();ciclo=false;break;
		case 2:montoPromedio();ciclo=false;break;
		case 3:mayor10mil();ciclo=false;break;
		case 4:saldoMax();ciclo=false;break;
		case 5:saldoMin();ciclo=false;break;
		case 6:ciclo=false;break;
		default:JOptionPane.showMessageDialog(null,"Ingrese una de las acciones mostradas de favor");
		  }
		}
	}
	
	static void montoTotal() {
		if(c.isFree())
			JOptionPane.showMessageDialog(null,"Todavía no existe alguna cuenta");
		else {
		    float montoTotal=0;
		    for(int i=0;i<c.getSize();i++) 
			    montoTotal=montoTotal+c.getItem(i).getSaldo();
		    JOptionPane.showMessageDialog(null,"El monto totalitario es de: $"+montoTotal);
		}
	}
	
	static void montoPromedio() {
		float montoProm=0;
		if(c.isFree())
			JOptionPane.showMessageDialog(null,"Todavía no existe alguna cuenta");
		else {
		    float montoTotal=0;
		    for(int i=0;i<c.getSize();i++) 
		        montoTotal=montoTotal+c.getItem(i).getSaldo();
		    montoProm=montoTotal/c.getSize(); 
		    JOptionPane.showMessageDialog(null,"El monto promedial es de: $"+montoProm);
		}
	}
	
	static void mayor10mil() {
		if(c.isFree())
			JOptionPane.showMessageDialog(null,"Todavía no existe alguna cuenta");
		else {
			int vacio=0;
			Cuenta_Bancaria copia[]=new Cuenta_Bancaria[c.getSize()];
			for(int i=0;i<c.getSize();i++)
				if(c.getItem(i).getSaldo()>10000) 
					copia[i-vacio]=c.getItem(i);
				else
					vacio++;
			String cuentas="";
			for(int j=0;j<(c.getSize()-vacio);j++)
				cuentas=cuentas+"\n"+copia[j];
			JOptionPane.showMessageDialog(null,"Las cuentas que tienen saldo que sobrepasa a $10,000 son:\n"+cuentas);
		}
	}
	
	static void saldoMax() {
		if(c.isFree())
			JOptionPane.showMessageDialog(null,"Todavía no existe alguna cuenta");
		else {
			int vacio=0;
			float max=c.getItem(0).getSaldo();
			for(int i=0;i<c.getSize();i++)
				if(c.getItem(i).getSaldo()>max)
					max=c.getItem(i).getSaldo();
			Cuenta_Bancaria copia[]=new Cuenta_Bancaria[c.getSize()];
			for(int i=0;i<c.getSize();i++)
				if(c.getItem(i).getSaldo()==max) 
					copia[i-vacio]=c.getItem(i);
				else
					vacio++;
			String cuentas="";
			for(int j=0;j<(c.getSize()-vacio);j++)
				cuentas=cuentas+"\n"+copia[j];
			JOptionPane.showMessageDialog(null,"La/las cuenta/cuentas con maximo saldo es/son:\n"+cuentas);
		}
		
	}
	
	static void saldoMin() {
		if(c.isFree())
			JOptionPane.showMessageDialog(null,"Todavía no existe alguna cuenta");
		else {
			int vacio=0;
			float min=c.getItem(0).getSaldo();
			for(int i=0;i<c.getSize();i++)
				if(c.getItem(i).getSaldo()<min)
					min=c.getItem(i).getSaldo();
			Cuenta_Bancaria copia[]=new Cuenta_Bancaria[c.getSize()];
			for(int i=0;i<c.getSize();i++)
				if(c.getItem(i).getSaldo()==min) 
					copia[i-vacio]=c.getItem(i);
				else
					vacio++;
			String cuentas="";
			for(int j=0;j<(c.getSize()-vacio);j++)
				cuentas=cuentas+"\n"+copia[j];
			JOptionPane.showMessageDialog(null,"La/las cuenta/cuentas con minimo saldo es/son:\n"+cuentas);
		}
	}
	
	static void grabarCuentas() {
		if(c.isFree()) {
			
		}
		else {
			try {
				LectorObjetos outputFile = new LectorObjetos("cuentas.dat");
			    for(int i=0;i<c.getSize();i++)
			    	outputFile.writeObject(c.getItem(i));
			    outputFile.close();
			}catch(Exception e) {
				
			}
		}
	}
	
	static void iniciaPrograma() throws Exception{
		boolean existe=false;
		try {
			inputFile = new LectorObjetos("cuentas.dat");    
		    existe=true;  
		}catch(IOException e) {
			System.err.println("No hay antecedentes de registro, se hara la realizacion en proceso de uno nuevo");
		}
		if(existe)
			grabaRegistro();
	}
	
	static void grabaRegistro() throws Exception {
		try {
		      inputFile = new LectorObjetos("cuentas.dat");
		      while(true) {
			      c.addItem((Cuenta_Bancaria)inputFile.readObject());
		      }
		}catch(IOException e) {
			
			try {
				inputFile.close();
				System.out.println("¡Registro localizado!");
			} catch (IOException e1) {
				
			}
		}
		catch(ClassNotFoundException e) {
			
		}
	}
	
}

