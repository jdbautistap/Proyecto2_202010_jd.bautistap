package model.data_structures;

public class ArregloDinamico<T>
{
	/**
	 * Capacidad maxima del arreglo
	 */
    private int tamanoMax;
	/**
	 * Numero de elementos presentes en el arreglo (de forma compacta desde la posicion 0)
	 */
    private int tamanoAct;
    /**
     * Arreglo de elementos de tamaNo maximo
     */
    private T elementos[];

    /**
     * Construir un arreglo con la capacidad maxima inicial.
     * @param max Capacidad maxima inicial
     */
	@SuppressWarnings("unchecked")
	public ArregloDinamico( int max )
    {
           elementos = (T[]) new Comparable[max];
           tamanoMax = max;
           tamanoAct = 0;
    }
	    
	@SuppressWarnings("unchecked")
	public void agregar( T aux )
    {
           if ( tamanoAct == tamanoMax )
           {  
        	   
                tamanoMax = 2 * tamanoMax;
                T [ ] copia = elementos;
                elementos = (T[]) new Comparable[tamanoMax];
                for ( int i = 0; i < tamanoAct; i++)
                {
                 	 elementos[i] = copia[i];
                } 
        	    System.out.println("Arreglo lleno: " + tamanoAct + " - Arreglo duplicado: " + tamanoMax);
           }	
           elementos[tamanoAct] = aux;
           tamanoAct++;
   }

	public int darCapacidad() {
		return tamanoMax;
	}

	public int darTamano() {
		return tamanoAct;
	}

	public T darElemento(int i){
					
		return elementos[i];
	}	
}