package controller;

import java.text.ParseException;


import java.util.Date;
import java.util.Scanner;

import model.data_structures.Commparendo;


import model.data_structures.LinkedList;

import model.data_structures.MaxHeapCP;
import model.data_structures.Nodo;

import model.logic.Modelo;
import view.View;

public class Controller
{

	/* Instancia del Modelo*/
	@SuppressWarnings("rawtypes")
	private Modelo modelo;

	/* Instancia de la Vista*/
	private View view;
	/**
	 * Crear la vista y el modelo del proyecto
	 */
	@SuppressWarnings("rawtypes")
	public Controller ()
	{
		view = new View();
		modelo = new Modelo();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		boolean cargado=false;
		int n=0;
		String g;
		String h;
		String j;

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
					try {
						modelo.crearLista();
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
				if(cargado==true)
				{
					view.printMessage("Dar tamanio de la muestra: ");

					n = lector.nextInt();

					long inicio1 = System.currentTimeMillis();

					MaxHeapCP<Commparendo> heap = new MaxHeapCP<Commparendo>();
					LinkedList<Commparendo> lista;
					lista=modelo.darlista();
					Nodo hola = new  Nodo (null);
					hola=lista.darprimero();

					while(hola!=null)
					{
						heap.agregar((Commparendo) hola.darElem());
						hola=hola.darSiguiente();
					}
					long termino1 = System.currentTimeMillis();

					String respuesta="";

					long inicio2 = System.currentTimeMillis();
					while(n!=0 && n>0)
					{
						Commparendo ayuda1 = (Commparendo)heap.delMax();
						respuesta += ayuda1.InformacionA1();	
						n--;
					}
					long termino2 = System.currentTimeMillis();
					view.printMessage(respuesta);

					view.printMessage("Tiempo de carga: "+(termino1-inicio1)+"Milisegundos");

					view.printMessage("Tiempo de Eliminar: "+(termino2-inicio2)+"Milisegundos");
				}
				else
				{
					view.printMessage("Tiene que cargar la Lista primero");
				}

				break;
			case 3:
				if(cargado==true)
				{
					view.printMessage("Por favor ingrese el Dia de la semana (L,M,I,J,V,S,D): ");
					g = lector.next();
					view.printMessage("Por favor ingrese el mes de la fecha a consultar: ");
					n = lector.nextInt();


					String respt="";



					respt=modelo.metodo2A(n, g);


					view.printMessage("Los comparendos son: ");
					view.printMessage(respt);

				}
				else
				{
					view.printMessage("Tiene que cargar la Lista primero");
				}
				break;
			case 4:
				if(cargado==true)
				{
					view.printMessage("Por favor ingrese Fecha Inicio: ");
					g = lector.next();
					view.printMessage("Por Por favor ingrese Fecha Final: ");
					h = lector.next();
					view.printMessage("Por Por favor localidad: ");
					j = lector.next();


					try 
					{
						System.out.print("1");
						Date	ini=modelo.cambiarStringaDateHora(g);
						Date fina=modelo.cambiarStringaDateHora(h);
						view.printMessage("Los comparendos son: ");
						view.printMessage(modelo.metodo3A(ini, fina, j));
					} 
					catch (ParseException e) 
					{
						// TODO Auto-generated catch block
						view.printMessage("mierda");
						e.printStackTrace();
					}
					view.printMessage("mierda2");
				}
				else
				{
					view.printMessage("Tiene que cargar la Lista primero");
				}
				break;

			case 5:
				if(cargado==true)
				{
					view.printMessage("Por favor ingrese numero a dividir el año: ");
					n = lector.nextInt();
					view.printMessage("Rango de fechas       | Comparendos durante el año");
					view.printMessage("-----------------------------------------------------");


					try {
						String s= modelo.metodo1c(n);
						view.printMessage(s+"");
					} catch (ParseException e) {
						// TODO Auto-generated catch block

						e.printStackTrace();
					}
					view.printMessage("Cada * equivale a 1000 o fracción.");
				}
				else
				{
					view.printMessage("Tiene que cargar la Lista primero");
				}
				break;
			case 6:
				if(cargado==true)
				{
					view.printMessage("Fechas       | Comparendos procesados***");
					view.printMessage("             | Comparendos esperando###");
					view.printMessage("-----------------------------------------------------");

					try {
						view.printMessage(modelo.metodo2c());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					view.printMessage("Cada * equivale a 15 o fracción y # a 200 o fracción.\n");
					view.printMessage("Las perdidas son: "+modelo.perdidas2C()+"\n");

				}
				else
				{
					view.printMessage("Tiene que cargar la Lista primero");
				}
				break;
			case 7:

				if(cargado==true)
				{
					view.printMessage("Fechas       | Comparendos procesados***");
					view.printMessage("             | Comparendos esperando###");
					view.printMessage("-----------------------------------------------------");

					try {
						view.printMessage(modelo.metodo3C());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					view.printMessage("Cada * equivale a 15 o fracción y # a 200 o fracción.\n");
					view.printMessage("Las perdidas son: "+modelo.perdidas3C()+"\n");

				}
				
				else
				{
					view.printMessage("Tiene que cargar la Lista primero");
				}
				break;
			case 8:
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
