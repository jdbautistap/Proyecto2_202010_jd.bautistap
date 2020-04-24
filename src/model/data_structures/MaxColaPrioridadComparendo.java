package model.data_structures;

public class MaxColaPrioridadComparendo 
{
	/**
	 * ATRIBUTO CON NUMERO DE ELEMENTOS
	 */
	private int Contador;
	/**
	 * ATRIBUTO CON Nodo
	 */
	private Nodo<Commparendo> head;

	/**
	 * Constructor
	 */
	public MaxColaPrioridadComparendo()
	{
		head=null;
		Contador=0;
	}


	public Commparendo delMax() 
	{
		Commparendo max=head.darElem();
		head=head.darSiguiente();
		Contador--;
		return max;
	}


	public Commparendo max()
	{
		return head.darElem();
	}


	public boolean estaVacia() 
	{
		return Contador==0;
	}

	public void agregar(Commparendo elemento)
	{
		boolean add = false;
		if(elemento == null)
		{
			throw new NullPointerException();
		}
		else
		{

			Nodo<Commparendo> nuevo = new Nodo<Commparendo>(elemento);

			if(head == null)
			{
				head= nuevo;
				add =true;
			}
			else{
				if(head.darSiguiente() == null)
				{
					if(head.darElem().compareTo3A(elemento) > 0)
					{
						head.cambiarSiguiente(nuevo);
						add =true;
					}
					else
					{

						Nodo<Commparendo> siguiente = head;
						head = nuevo;
						nuevo.cambiarSiguiente(siguiente);
						add =true;
					}
				}
				else
				{
					Nodo<Commparendo> actual=head;
					Nodo<Commparendo> anterior = null;
					while(!add){
						if(actual.darElem().compareTo3A(elemento) > 0){
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
								Nodo<Commparendo>siguiente = head;
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
