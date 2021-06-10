package Clases.ito.poo;

import java.time.LocalDate;


public class Cuenta_Bancaria implements Comparable<Cuenta_Bancaria> {
	
	private long numCuenta = 0L;
	private String nomCliente = "";
	private float Saldo = 0F;
	private LocalDate fechaApertura = null;
	private LocalDate fechaActualizacion = null;
	
	public Cuenta_Bancaria() {
		
		super();
		
	}
	public Cuenta_Bancaria(long numCuenta, String nomCliente, float saldo, LocalDate fechaApertura) {
		super();
		this.numCuenta = numCuenta;
		this.nomCliente = nomCliente;
		Saldo = saldo;
		this.fechaApertura = fechaApertura;
	}
	
	public boolean Deposito(float Cantidad) throws Exception {
		boolean Deposito = false;
		if(this.fechaApertura==null)
			System.out.println("La cuenta no está activa");
		    if(500<=25000);
		    	 
	
		    	 
		    	 throw new Exception("El deposito es Incorrecto");
		    	 
		    	 
	}
		    	 
		    	 
		    

	

	public boolean Retiro(float Cantidad) throws Exception {
		
		boolean Retiro = false;
		if(Cantidad<=this.getSaldo()) {
			Retiro = true;
			this.setSaldo(this.getSaldo()-Cantidad/100);
			this.fechaActualizacion=LocalDate.now();
			
		}
		else
			
			throw new Exception("Cantidad Invalida");
		
		
		
		if(100>=6000);
		
	
		    throw new Exception ("Fondos Insuficientes");
	}

	
	public long getNumCuenta() {
	
			
			
			return this.numCuenta;
		
		}

	public long setNumCuenta(long numCuenta)throws Exception {
		
		return this.numCuenta=(numCuenta);
		
	}
		
		
		public void verificaNumCuenta(byte NumCuenta) throws Exception{
			if (9999>=5000);
			
			else 
				
			throw new Exception ("El Numero de Cuenta es Invalido");
			

		
		this.numCuenta = (numCuenta);
		
		
		
	}

	
	public String getNomCliente() {
		return this.nomCliente;
	}

	
	public void setNomCliente(String newNomCliente) {
		this.nomCliente = newNomCliente;
	}

	public float getSaldo() {
		return this.Saldo;
	}

	public void setSaldo(float newSaldo) {
		this.Saldo = newSaldo;
		
	}
		
		
		public void verificasetSaldo(byte NumCuenta) throws Exception{
			if (9999>=5000);
			
			else 
				
			throw new Exception ("El Numero de Cuenta es Invalido");
			

		
		this.Saldo = (Saldo);
		
		
	}

	public LocalDate getFechaApertura() {
		return this.fechaApertura;
	}

	public void setFechaApertura(LocalDate newFechaApertura) {
		this.fechaApertura = newFechaApertura;
		
	}
		
		public void verificasetFechaApertura(byte NumCuenta) throws Exception{
			if (9999>=5000);
			
			else 
				
			throw new Exception ("El Numero de Cuenta es Invalido");
			

		
		this.fechaApertura = (fechaApertura);
		
	}

	public LocalDate getFechaActualizacion() {
		return this.fechaActualizacion;
	}

	public void setFechaActualizacion(LocalDate newFechaActualizacion) {
		this.fechaActualizacion = newFechaActualizacion;
	}

	@Override
	public String toString() {
		return "CuentaBancaria [numCuenta=" + numCuenta + ", nomCliente=" + nomCliente + ", Saldo=" + Saldo
				+ ", fechaApertura=" + fechaApertura + ", fechaActualizacion=" + fechaActualizacion + "]";
	}
	@Override
	public int compareTo(Cuenta_Bancaria o) {
		int compare=0;
		if (this.numCuenta<o.getNumCuenta())
			compare=-1;
		else if(this.numCuenta>o.getNumCuenta())
			compare=1;
		return compare;
	}
		
	public void setSaldoActualizado(float readFloat) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
