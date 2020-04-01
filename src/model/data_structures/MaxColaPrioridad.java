package model.data_structures;

public class MaxColaPrioridad <T extends Comparable<T>>

{
	/**
	 * ATRIBUTO CON NUMERO DE ELEMENTOS
	 */
	private int Contador;
	/**
	 * ATRIBUTO CON Nodo
	 */
	private Nodo<T> head;

	/**
	 * Constructor
	 */
	public MaxColaPrioridad()
	{
		head=null;
		Contador=0;
	}


	public T delMax() 
	{
		T max=head.darElem();
		head=head.darSiguiente();
		Contador--;
		return max;
	}


	public T max()
	{
		return head.darElem();
	}


	public boolean estaVacia() 
	{
		return Contador==0;
	}

	public void agregar(T elemento)
	{
		boolean add = false;
		if(elemento == null)
		{
			throw new NullPointerException();
		}
		else
		{

			Nodo<T> nuevo = new Nodo<T>(elemento);

			if(head == null)
			{
				head= nuevo;
				add =true;
			}
			else{
				if(head.darSiguiente() == null)
				{
					if(head.darElem().compareTo(elemento) > 0)
					{
						head.cambiarSiguiente(nuevo);
						add =true;
					}
					else
					{

						Nodo<T> siguiente = head;
						head = nuevo;
						nuevo.cambiarSiguiente(siguiente);
						add =true;
					}
				}
				else
				{
					Nodo<T> actual=head;
					Nodo<T> anterior = null;
					while(!add){
						if(actual.darElem().compareTo(elemento) > 0){
							if(actual.darSiguiente() == null){
								actual.cambiarSiguiente(nuevo);
								add = true;
							}
							else{
								anterior = actual;
								actual = actual.darSiguiente();
							}
						}
						else{
							if(anterior == null){
								Nodo<T>siguiente = head;
								head = nuevo;
								nuevo.cambiarSiguiente(siguiente);
								add = true;
							}
							else{
								anterior.cambiarSiguiente(nuevo);
								nuevo.cambiarSiguiente(actual);
								add = true;
							}
						}
					}
				}
			}
		}
		Contador++;
	}
	public int darNumElementos() 
	{
		return Contador;
	}
}
