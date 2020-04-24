package model.data_structures;



public class SequentialSearch <K extends Comparable <K>, V>

{
	/**
	 * Numero de llaves
	 */
	private int n;   
	/**
	 * Numero de llaves
	 */
	private Node first;  
	
	
	
	/**
	 * Linked list de ayuda
	 */
	private class Node 
	{
		/**
		 * llave
		 */
		private K key;
		/**
		 * valor
		 */
		private V val;
		/**
		 * nodo siguiente
		 */
		private Node next;
		
		
		public Node(K key, V val, Node next)  
		{
			this.key  = key;
			this.val  = val;
			this.next = next;
		}
	}
	
	
	public int size() 
	{
		return n;
	}
	
	
	
	public boolean isEmpty() 
	{
		return size() == 0;
	}
	
	
	public V get(K key)
	{
		for (Node x = first; x != null; x = x.next) 
		{
			if (key.equals(x.key))
				return x.val;
		}
		return null;
	}
	
	
	public boolean contains(K key)
	{
		return get(key) != null;
	}
	
	public void put(K key, V val)
	{
		if (val == null)
			
		{
			delete(key);
			return;
		}

		for (Node x = first; x != null; x = x.next) {
			if (key.equals(x.key)) {
				x.val = val;
				return;
			}
		}
		first = new Node(key, val, first);
		n++;
	}
	
	public void delete(K key)
	{
		first = delete(first, key);
	}
	
	
	
	private Node delete(Node x, K key) 
	{
		if (x == null)
			return null;
		if (key.equals(x.key)) {
			n--;
			return x.next;
		}
		x.next = delete(x.next, key);
		return x;
	}
	
	@SuppressWarnings("unchecked")
	public Iterable<K> keys() 
	{
		Cola<K> queue = new Cola<K>();
		for (Node x = first; x != null; x = x.next)
			queue.enqueue(x.key);
		return (Iterable<K>) queue;
	}
}

