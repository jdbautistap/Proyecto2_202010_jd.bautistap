package view;



public class View 
{
	/**
	 * Metodo constructor
	 */
	public View()
	{
	}

	public void printMenu()
	{
		System.out.println("1. Crear Lista");
		System.out.println("2. Metodo 1A");
		System.out.println("3. Metodo 2A");
		System.out.println("4. Metodo 3A");
		System.out.println("5. Metodo 1C");
		System.out.println("6. Metodo 2C");
		System.out.println("8. Exit");
		System.out.println("Dar el numero de opcion a resolver, luego oprimir tecla Return: (e.g., 1):");
	}

	public void printMessage(String mensaje)
	{

		System.out.println(mensaje);
	}		

}
