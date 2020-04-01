package TestColaPrioridadyHeap;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import model.data_structures.MaxColaPrioridad;
import model.data_structures.MaxHeapCP;

public class Tests extends TestCase
{
	protected static final int[] ARREGLO = {350, 383, 105, 233, 140, 266, 356, 236, 80, 360, 221, 241, 130, 244, 352, 446, 18, 98, 97, 396};

	protected MaxColaPrioridad<Integer> queue;
	protected MaxHeapCP<Integer> heap;
	
	
	public void setUp()
	{
		queue= new MaxColaPrioridad<Integer>();
		heap=new MaxHeapCP<Integer>();
		for(int actual: ARREGLO)
		{
			queue.agregar(actual);
			heap.agregar(actual);
		}

	}
	@Test
	public void testSize()
	{
		assertEquals(queue.darNumElementos(), 20);
		assertEquals(heap.darNumElementos(), 20);

	}
	@Test
	public void testDarMax(){
		assertEquals(heap.max(), Integer.valueOf(446));
		assertEquals(queue.max(), Integer.valueOf(446));
		
	}
	@Test
	public void testDelMax(){
		assertEquals(queue.delMax(), Integer.valueOf(446));
		assertEquals(queue.darNumElementos(), 19);
		assertEquals(heap.delMax(), Integer.valueOf(446));
		assertEquals(heap.darNumElementos(), 19);
		
		
	}




}