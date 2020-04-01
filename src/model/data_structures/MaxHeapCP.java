package model.data_structures;

public class MaxHeapCP <T extends Comparable<T>>
{
	private int contador;
	private int max;
	private T[] heap;

	public MaxHeapCP()
	{
		max=2;
		heap = (T[])new Comparable[max+1];
		contador=0;
	}

	private boolean less(int i, int j)
	{  
		return heap[i].compareTo(heap[j]) < 0;  
	}

	private void exch(int i, int j)
	{ 
		T t = heap[i]; 
		heap[i] = heap[j]; 
		heap[j] = t; 
	}

	private void swim(int k)
	{
		while (k > 1 && less(k/2, k))
		{
			exch(k/2, k);
			k = k/2; 
		}
	}

	private void sink(int k)
	{
		while (2*k <= contador)
		{
			int j = 2*k;
			if (j < contador && less(j, j+1)){ 
				j++;
			}
			if (!less(k, j))
			{
				break;
			}
			exch(k, j);
			k = j;
		} 
	}

	public int darNumElementos()
	{
		return contador;
	}


	public T delMax() 
	{
		T temp=heap[1];
		exch(1, contador--);
		heap[contador+1] = null;
		sink(1);
		return temp;
	}


	public T max() 
	{
		return heap[1];
	}


	public boolean estaVacia() 
	{
		return contador==0;
	}


	public void agregar(T elemento) 
	{
		if ( contador == max )
		{  // caso de arreglo lleno (aumentar tamaNo)
			max*=2;
			T [ ] copia = heap;
			heap = (T[])new Comparable[max+1];
			for ( int i = 0; i <= contador; i++)
			{
				heap[i] = copia[i];
			} 
		}	
		heap[++contador] = elemento;
		swim(contador);
	}


}
