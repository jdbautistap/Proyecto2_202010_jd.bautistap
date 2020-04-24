package model.data_structures;

import java.util.Iterator;

public class Cola <T extends Comparable<T>> 
{
	private Nodo<T> primerNodo;


	private int numElementos;

	public Cola()
	{
		primerNodo=null;
		numElementos=0;
	}
	public Cola(T p)
	{
		primerNodo=new Nodo<T>(p);
		numElementos++;
	}

	@SuppressWarnings("unchecked")
	public Iterator<T> iterator()
	{

		return  (Iterator<T>) new Iterador<T>(primerNodo);
	}

	public boolean isEmpty() 
	{

		if(numElementos == 0){
			return true;
		}
		return false;
	}

	public int size() 
	{

		return numElementos;
	}

	public void enqueue(T t) 
	{
		// Done Auto-generated method stub
		if(numElementos==0)
		{
			primerNodo=new Nodo<T>(t);
		}
		else
		{
			Nodo<T> ultimo = new Nodo<T>(t);
			Nodo<T> actual=primerNodo;
			while(actual.darSiguiente()!=null)
			{
				actual=actual.darSiguiente();
			}
			actual.cambiarSiguiente(ultimo);
			ultimo.cambiarSiguiente(null);
		}
		numElementos++;
	}
	
	public T dequeue() 
	{
		T elem = primerNodo.darElem();
		primerNodo=primerNodo.darSiguiente();
		numElementos--;
		return elem;
	}
	
	public T get(int i)
	{
		
		T objeto = null;
		Iterator<T> it = this.iterator();
		int cont = 0;
		while(it.hasNext() && cont<i){
			objeto = it.next();
			cont++;
		}
		return objeto;
	}
}
