package Clases.ito.poo;

public interface Arreglo<T> {
	
	public boolean addItem(T item) throws Exception;
	public boolean existeItem(T item);
	public T getItem(int pos);
	public int getSize(); //Retorna cantidad de elementos
	public boolean clear(T item);
	public boolean isFree();
	public boolean isFull();
	boolean addItem1(Cuenta_Bancaria item) throws Exception;
}