package Clases.ito.poo;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class LectorArchivoTXT {
	
	private Scanner io=null;
	
	public LectorArchivoTXT(String archivo) throws FileNotFoundException {
		io= new Scanner(new File(archivo));
	}
	
	public byte readByte() {
		byte salida=0;
		if(io.hasNextByte())
			salida=io.nextByte();
		return salida;
	}
	
	public short readShort() {
		short salida=0;
		if(io.hasNextShort())
			salida=io.nextShort();
		return salida;
	}
	
	public int readInt() {
		int salida=0;
		if(io.hasNextInt())
			salida=io.nextInt();
		return salida;
	}
	
	public long readLong() {
		long salida=0;
		if(io.hasNextLong())
			salida=io.nextLong();
		return salida;
	}

	public float readFloat() {
		float salida=0;
		if(io.hasNextFloat())
			salida=io.nextFloat();
		return salida;
	}
	
	public double readDouble() {
		double salida=0;
		if(io.hasNextDouble())
			salida=io.nextDouble();
		return salida;
	}
	
	public String readString() {
		String salida="";
		if(io.hasNext())
			salida=io.next();
		return salida;
	}
	
	public boolean readBoolean() {
		boolean salida=false;
		if(io.hasNextBoolean())
			salida=io.nextBoolean();
		return salida;
	}
	
	public boolean isFinLinea() {
		boolean salida=false;
		if(io.hasNext("\n")) {
			salida=true;
			io.nextLine();
		}
		return salida;
	}
	
	public boolean isEOF() {
		boolean salida=false;
		if(!io.hasNext())
			salida=true;
		return salida;
	}
	
	public void close() {
		io.close();
	}
	
}