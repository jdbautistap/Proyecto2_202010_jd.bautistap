package model.data_structures;

import java.util.NoSuchElementException;

public class Iterador<T extends Comparable<T>> 
{
	
	private Nodo<T> actual;


	public Iterador(Nodo<T> primerNodo) 
	{
		actual = primerNodo;
	}
	public boolean hasNext() 
	{
		return actual != null;
	}

	public T next() throws NoSuchElementException
	{
		if(actual == null)
			throw new NoSuchElementException("Se ha alcanzado el final de la lista");
		T valor = actual.darElem();
		actual = actual.darSiguiente();
		return valor;
	}

}
