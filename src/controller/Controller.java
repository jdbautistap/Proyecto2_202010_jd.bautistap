package controller;

import java.util.Scanner;

import model.data_structures.Commparendo;
import model.data_structures.LinearProbing;
import model.data_structures.LinkedList;
import model.data_structures.MaxColaPrioridad;
import model.data_structures.MaxHeapCP;
import model.data_structures.Nodo;
import model.data_structures.SeparateChaining;
import model.logic.Modelo;
import view.View;

public class Controller
{

	/* Instancia del Modelo*/
	private Modelo modelo;

	/* Instancia de la Vista*/
	private View view;
	/**
	 * Crear la vista y el modelo del proyecto
	 */
	public Controller ()
	{
		view = new View();
		modelo = new Modelo();
	}

	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		boolean cargado=false;

		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			switch(option)
			{
			case 1:
				if (cargado == false)
				{
					modelo=new Modelo();

					long inicio = System.currentTimeMillis();
					modelo.crearLista();
					long termino = System.currentTimeMillis();
					cargado=true;
					Commparendo ayuda1 = (Commparendo)modelo.darlista().darprimero().darElem();
					Commparendo ayuda2 = (Commparendo)modelo.darlista().darUltimo().darElem();


					view.printMessage("Se demoró: "+ ((termino-inicio))+" milisegundos");
					view.printMessage("El arreglo tiene: "+ modelo.darTamlista()+" Comparendos");
					view.printMessage("El primer dato es: "+ ayuda1.Informacion());
					view.printMessage("El útimo dato es: "+ ayuda2.Informacion());
				}

				else
				{
					view.printMessage("Ya se ha cargado.");
				}
				break;



			case 2:
				view.printMessage("--------- \n Hasta pronto !! \n---------"); 
				lector.close();
				fin = true;
				break;
				
			default: 
				view.printMessage("--------- \n Opcion Invalida !! \n---------");
				break;
			}
		}

	}	
}
