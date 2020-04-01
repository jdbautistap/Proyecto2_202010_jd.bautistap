package model.data_structures;

import java.util.Iterator;

public class LinearProbing <K extends Comparable <K>, V> 
{
	/**
	 * Numero de la llave
	 */
	private int n;           
	/**
	 * Tamaño de la tabla
	 */
	private int m;           
	/**
	 * Arreglo de llaves 
	 */
	private K[] keys;     
	/**
	 * Arreglo de valores 
	 */
	private V[] vals;    

	/**
	 * Inicializa la tabla con un valor predeterminado
	 */
	public LinearProbing(int capacidad) 
	{
		n = 0;
		m = capacidad;
		keys = (K[]) new Comparable[m];
		vals = (V[]) new Object[m];
	}
	/**
	 * Retorna numero de llaves
	 */
	public int darNumLlaves()
	{
		return n;
	}
	/**
	 * Retorna tamaño
	 */
	public int dartamanio()
	{
		return m;
	}
	/**
	 * Retorna valor un valor entre 0 y m-1
	 */
	private int hash(K pllave) 
	{
		return (pllave.hashCode() & 0x7fffffff) % m;
	}

	/**
	 * Acomoda la tabla
	 */
	private void resize(int capacidad) 
	{
		LinearProbing<K, V> temp = new LinearProbing<K, V>(capacidad);
		for (int i = 0; i < m; i++) 
		{
			if (keys[i] != null) 
			{
				temp.insertar(keys[i], vals[i]);
			}
		}
		keys = temp.keys;
		vals = temp.vals;
		m    = temp.m;
	}
	/**
	 * Se agrega un valor 
	 */
	public void insertar(K llave, V valor) 
	{
	
		if (llave == null) 
		{
			return;
		}

		if (valor == null) 
		{
			delete(llave);
			return;
		}
		if (n >=(double) 0.75*m)
		{
			resize(2*m);
		}

		int i;
		for (i = hash(llave); keys[i] != null; i = (i + 1) % m)
		{
			if (keys[i].equals(llave)) 
			{
				vals[i] = valor;
				return;
			}
		}
		keys[i] = llave;
		vals[i] = valor;
		n++;

	}
	/**
	 * Retornar valor
	 */
	public V get(K llave) 
	{
		V resp=null;

		if (llave == null) 
		{
			throw new IllegalArgumentException("la llave por valor es nula");
		}
		else
		{
			for (int i = hash(llave); keys[i] != null; i = (i + 1) % m)
				if (keys[i].equals(llave))
				{
					resp = vals[i];
				}
		}
		return resp;
	}
	/**
	 * Elimina una tupla de llave valor
	 */
	public void delete(K llave)
	{
		if (llave == null)
		{
			throw new IllegalArgumentException("argument to delete() is null");
		}
		else
		{
			int i = hash(llave);
			while (!llave.equals(keys[i])) 
			{
				i = (i + 1) % m;
			}


			keys[i] = null;
			vals[i] = null;


			i = (i + 1) % m;
			while (keys[i] != null) 
			{

				K   keyToRehash = keys[i];
				V valToRehash = vals[i];
				keys[i] = null;
				vals[i] = null;
				n--;
				insertar(keyToRehash, valToRehash);
				i = (i + 1) % m;
			}

			n--;

			if (n > 0 && n <= m/8) 
			{
				resize(m/2);
			}
		}
	}
	
	public Iterator<K> keys() 
	{
		  Cola<K> queue = new Cola<K>();
	        for (int i = 0; i < m; i++)
	            if (keys[i] != null) queue.enqueue(keys[i]);
	        return queue.iterator();
	}
}
