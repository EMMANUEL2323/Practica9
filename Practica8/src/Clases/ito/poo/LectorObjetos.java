package Clases.ito.poo;

import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LectorObjetos {
	
	private ObjectInputStream archivo;
	
	public LectorObjetos(String archivo) throws FileNotFoundException, IOException {
		this.archivo= new ObjectInputStream(new FileInputStream(archivo));
	}
	
	public Object readObject() throws ClassNotFoundException, IOException {
		Object aux=null;
		aux= archivo.readObject();
		return aux;
	}
	
	public void close() throws IOException {
		archivo.close();
	}

	public void writeObject(Cuenta_Bancaria item) {
		// TODO Auto-generated method stub
		
	}

}
