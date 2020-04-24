package model.data_structures;



public class LinkedList <T extends Comparable<T>>

	{

		/**
		 * Atributo Al nodo cabeza
		 */
		private Nodo<T> head;
		/**
		 * Atributo Al tamaño de la lista
		 */
		private int size;
		/**
		 * Atributo Al ultimo nodo de la lista
		 */
		private Nodo<T> ultimoNodo;

		/**
		 * Metodo constructor
		 */
		public LinkedList()
		{
			head=null;
			size=0;
			ultimoNodo=null;
		}

		/**
		 * Retorna Tamaño de la lista
		 */
		public int darTamano()
		{
			return size;
		}
		/**
		 * Retorna el nodo cabeza
		 */
		public Nodo<T> darprimero()
		{
			return head;
		}
		/**
		 * Retorna el ultimo nodo de la lista
		 */
		public Nodo<T>darUltimo()
		{
			return ultimoNodo;
		}
		/**
		 * Agrega un elemento nuevo a la lista 
		 */
		public void AgregarElemento(T pElemento)
		{
			
			Nodo<T> ayuda = new Nodo<T>(pElemento);
			if (head==null )
			{
				head=ayuda;
				ultimoNodo=ayuda;
			}
			else
			{
				ultimoNodo.cambiarSiguiente(ayuda);	
				ultimoNodo=ayuda;
			}
			size++;
		}

	}

