package TestsTablaHash;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import model.data_structures.LinearProbing;

public class TestLinearProbing extends TestCase
{
	protected LinearProbing<String, Integer> linear;
	@Before
	public void setUp()
	{
		linear=new LinearProbing<>(101);
		System.out.println("TestLinearProbing");
		int contador=0;
		while(linear.keys().hasNext())
		{
			contador++;
		}
		assertEquals(contador, 0);
		System.out.println("Tamaño del arreglo inicial: "+contador);
		int inic=linear.dartamanio();
		int cambios=0;
		for(int i=0;i<10000;i++)
		{
			linear.insertar(Integer.toString(i), i);
			if(linear.dartamanio()!=inic)
			{
				inic=linear.dartamanio();
				cambios++;
			}
		}
		System.out.println("Cantidad de rehashes: "+cambios);
	}
	@Test
	public void testSize()
	{
		System.out.println("Tama�o final del arreglo: "+linear.darNumLlaves());
		System.out.println("Numero de duplas: "+linear.darNumLlaves());
		System.out.println("Factor de carga final: "+(double)linear.darNumLlaves()/linear.dartamanio());
		long startTime = System.currentTimeMillis();
		for(int i=0;i<10000;i++)
		{
			int v=linear.get(Integer.toString(i));
		}
		long endTime = System.currentTimeMillis();
		long duration = endTime - startTime;
		double l=(double)duration/10000;
		System.out.println("Tiempo promedio: "+l+" milisegundos");
	}

}
