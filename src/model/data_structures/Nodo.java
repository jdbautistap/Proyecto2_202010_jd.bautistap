package model.data_structures;

public class Nodo<T extends Comparable<T>>
{
	/**
	 * Atributo al nodo siguiente
	 */
	private Nodo<T> next;
	/**
	 * Atributo al elemento del nodo
	 */
	private T elemento;
	/**
	 * Constructor
	 */
	public Nodo(T pElemento)
	{
		elemento = pElemento;
		next = null;
	}
	/**
	 * Cambiar el nodo siguiente
	 */
	public void cambiarSiguiente(Nodo<T> nuevo)
	{
		next = nuevo;
	}
	/**
	 * Dar elemento dentro del nodo
	 */
	public T darElem()
	{
		return elemento;
	}
	/**
	 * Da el nodo siguiente
	 */
	public Nodo<T> darSiguiente()
	{
		return next;
	}
	/**
	 * Cambia el elemnto contenido
	 */
	public void cambiarElemento(Comparable aux)
	{
		this.elemento = (T) aux;
	}
}