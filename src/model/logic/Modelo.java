package model.logic;
import model.data_structures.*
;


import java.io.File;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;



/**
 * Definicion del modelo del mundo
 * @param <K>
 *
 */
public class Modelo <T extends Comparable<T>>
{
	/**
	 * Atributos del modelo del mundo.
	 * Comparendos_DEI_2018_Bogotá_D.C_50000_
	 * comparendos_dei_2018
	 * comparendos_dei_2018_small
	 */
	public static final String RUTA = "./data/Comparendos_DEI_2018_Bogotá_D.C.geojson";
	/**
	 * Elemento Json
	 */
	private JsonObject config;
	/**
	 * Asocion a la lista
	 */
	private LinkedList<T> datos1;

	private LinkedList<Commparendo> datos2;

	private MaxColaPrioridad3C datos3;

	private LinkedList<Commparendo> datos4;
	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public Modelo()
	{
		config = openConfig(new File(RUTA));
		datos1 = new LinkedList<>();
		datos2 = new LinkedList<>();
		datos3 = new MaxColaPrioridad3C();
		datos4 = new LinkedList<>();
	}

	/**
	 * Retorna la lista
	 */
	public LinkedList<T> darlista()
	{
		return datos1;
	}
	/**
	 * Inicialización del Gson.
	 */
	private JsonObject openConfig(File pFile)
	{
		JsonObject config = null;
		try
		{
			Gson gson = new Gson();
			FileReader file = new FileReader(pFile);
			JsonReader jr = new JsonReader(file);
			config = gson.fromJson(jr, JsonObject.class);

		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

		return config;
	}


	/**
	 * Retorna el tamaño de la lista
	 */
	public int darTamlista()
	{
		return datos1.darTamano();
	}


	/**
	 * Requerimiento Crear una Lista
	 * @param dato
	 * @throws ParseException 
	 */
	@SuppressWarnings("unchecked")
	public void crearLista() throws ParseException
	{
		JsonArray nuevo = config.get("features").getAsJsonArray();
		for(int i = 0; i < nuevo.size(); i++)
		{
			JsonObject object = nuevo.get(i).getAsJsonObject();
			String objectId = object.get("properties").getAsJsonObject().get("OBJECTID").getAsString();
			String fechaHora1=object.get("properties").getAsJsonObject().get("FECHA_HORA").getAsString();
			String medioDeten=object.get("properties").getAsJsonObject().get("MEDIO_DETECCION").getAsString();
			String claseVehiculo=object.get("properties").getAsJsonObject().get("CLASE_VEHICULO").getAsString();
			String TipoServicio=object.get("properties").getAsJsonObject().get("TIPO_SERVICIO").getAsString();
			String infraccion=object.get("properties").getAsJsonObject().get("INFRACCION").getAsString();
			String descripcion=object.get("properties").getAsJsonObject().get("DES_INFRACCION").getAsString();
			String Localidad=object.get("properties").getAsJsonObject().get("LOCALIDAD").getAsString();
			JsonArray coords = object.get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray();
			double  longitud= coords.get(0).getAsDouble();
			double  latitud= coords.get(1).getAsDouble();

			SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
			Date fechaHora = parser.parse(fechaHora1);

			Commparendo x = new Commparendo(objectId, fechaHora, medioDeten, claseVehiculo, TipoServicio, infraccion, descripcion, Localidad, longitud, latitud);
			datos1.AgregarElemento(((T) x));
			//System.out.println(objectId + "\n" + fechaHora+"\n"+ medioDeten +"\n"+ claseVehiculo +"\n"+ TipoServicio+"\n"+ infraccion+"\n"+descripcion+"\n"+Localidad+"\n"+"Latitud: " + latitud + " Longitud: " + longitud+"\n");
		}
	}

	@SuppressWarnings({ "unchecked" })
	public String metodo2A(int mes,String dia) 
	{
		LinearProbing<String, Cola<Commparendo>> tabla= new LinearProbing<String, Cola<Commparendo>>(600011);
		Nodo<Commparendo> hola = new  Nodo<Commparendo> (null);
		hola=(Nodo<Commparendo>) datos1.darprimero();
		String resp="";

		while(hola!=null)
		{
			Commparendo aux=(Commparendo) hola.darElem();

			if(tabla.get(aux.llaveMetodo2A())==null)
			{
				Cola<Commparendo> col = new Cola<Commparendo>();
				col.enqueue(aux);
				tabla.insertar(aux.llaveMetodo2A(), col);
			}
			else
			{
				tabla.get(aux.llaveMetodo2A()).enqueue(aux);
			}
			hola=hola.darSiguiente();
		}

		int you=0;

		if(dia.equals("D"))
		{
			you=0;
		}
		else if (dia.equals("L"))
		{
			you=1;
		}
		else if (dia.equals("M"))
		{
			you=2;
		}
		else if (dia.equals("I"))
		{
			you=3;
		}
		else if (dia.equals("J"))
		{
			you=4;
		}
		else if (dia.equals("V"))
		{
			you=5;
		}
		else if (dia.equals("S"))
		{
			you=6;
		}

		String llave = "";

		llave="d"+you+"m"+mes;

		if(tabla.get(llave)!=null)
		{
			while(tabla.get(llave).isEmpty()==false)
			{
				resp=resp+tabla.get(llave).dequeue().InformacionA3();
			}
		}
		else
		{
			resp="No hay comparendos.";
		}
		return resp;

	}

	public Date cambiarStringaDateHora(String g) throws ParseException
	{
		SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		Date fechaHora = parser.parse(g);
		return fechaHora;
	}

	public Date cambiarStringaDate(String g) throws ParseException
	{
		SimpleDateFormat parser = new SimpleDateFormat("yyyy/MM/dd");
		Date fechaHora = parser.parse(g);
		return fechaHora;
	}


	@SuppressWarnings("unchecked")
	public String metodo3A(Date FechaInicio, Date FechaFinal, String localidad)
	{
		MaxColaPrioridadCommparendo2 ayuda= new MaxColaPrioridadCommparendo2();
		String res="";
		Nodo<Commparendo> hola = new  Nodo<Commparendo> (null);
		hola=(Nodo<Commparendo>) datos1.darprimero();

		while(hola!=null)
		{
			if(hola.darElem().darfechaHora().compareTo(FechaInicio)>=0 &&hola.darElem().darfechaHora().compareTo(FechaFinal)<=0&&hola.darElem().DarLocalidad().equals(localidad))
			{
				ayuda.agregar(hola.darElem());
			}
			hola=hola.darSiguiente();
		}
		while(ayuda.estaVacia()==false)
		{
			res=res+ayuda.delMax().InformacionA3();
		}
		return res;
	}

	@SuppressWarnings("deprecation")
	public String nextday(Date fecha) throws ParseException
	{
		int dia=fecha.getDate();
		int mes=fecha.getMonth()+1;
		String anio="2018/";
		String resp="";
		switch(mes)
		{

		case 12:
			if(dia==31)
			{
				dia=1;
				mes=1;
				anio="2019/";
			}
			else
			{
				dia=dia+1;
			}
			break;
		case 11:
			if(dia==30)
			{
				dia=1;
				mes=12;
			}
			else
			{
				dia=dia+1;
			}
			break;
		case 10:
			if(dia==31)
			{
				dia=1;
				mes=11;
			}
			else
			{
				dia=dia+1;
			}
			break;
		case 9:
			if(dia==30)
			{
				dia=1;
				mes=10;
			}
			else
			{
				dia=dia+1;
			}
			break;
		case 8:
			if(dia==31)
			{
				dia=1;
				mes=9;
			}
			else
			{
				dia=dia+1;
			}
			break;
		case 7:
			if(dia==31)
			{
				dia=1;
				mes=8;
			}
			else
			{
				dia=dia+1;
			}
			break;
		case 6:
			if(dia==30)
			{
				dia=1;
				mes=7;
			}
			else
			{
				dia=dia+1;
			}
			break;
		case 5:
			if(dia==31)
			{
				dia=1;
				mes=6;
			}
			else
			{
				dia=dia+1;
			}
			break;
		case 4:
			if(dia==30)
			{
				dia=1;
				mes=5;
			}
			else
			{
				dia=dia+1;
			}
			break;
		case 3:
			if(dia==31)
			{
				dia=1;
				mes=4;
			}
			else
			{
				dia=dia+1;
			}
			break;
		case 2:
			if(dia==28)
			{
				dia=1;
				mes=3;
			}
			else
			{
				dia=dia+1;
			}
			break;
		case 1:
			if(dia==31)
			{
				dia=1;
				mes=2;
			}
			else
			{
				dia=dia+1;
			}
			break;
		}

		if(mes<10)
		{
			resp=anio+"0"+mes+"/";
		}
		else
		{
			resp=anio+mes+"/";
		}


		if(dia<10)
		{
			resp=resp+"0"+dia;
		}
		else
		{
			resp=resp+dia;
		}
		return resp;
	}

	@SuppressWarnings("deprecation")
	public String dayBefore(Date fecha) throws ParseException
	{
		int dia=fecha.getDate();
		int mes=fecha.getMonth()+1;
		String anio="2018/";
		String resp="";
		switch(mes)
		{

		case 1:
			if(dia==1)
			{
				dia=31;
				mes=12;
				anio="2017/";
			}
			else
			{
				dia=dia-1;
			}
			break;
		case 2:
			if(dia==1)
			{
				dia=31;
				mes=1;
			}
			else
			{
				dia=dia-1;
			}
			break;
		case 3:
			if(dia==1)
			{
				dia=28;
				mes=2;
			}
			else
			{
				dia=dia-1;
			}
			break;
		case 4:
			if(dia==1)
			{
				dia=31;
				mes=3;
			}
			else
			{
				dia=dia-1;
			}
			break;
		case 5:
			if(dia==1)
			{
				dia=30;
				mes=4;
			}
			else
			{
				dia=dia-1;
			}
			break;
		case 6:
			if(dia==1)
			{
				dia=31;
				mes=5;
			}
			else
			{
				dia=dia-1;
			}
			break;
		case 7:
			if(dia==1)
			{
				dia=30;
				mes=6;
			}
			else
			{
				dia=dia-1;
			}
			break;
		case 8:
			if(dia==1)
			{
				dia=31;
				mes=7;
			}
			else
			{
				dia=dia-1;
			}
			break;
		case 9:
			if(dia==1)
			{
				dia=31;
				mes=8;
			}
			else
			{
				dia=dia-1;
			}
			break;
		case 10:
			if(dia==1)
			{
				dia=30;
				mes=9;
			}
			else
			{
				dia=dia-1;
			}
			break;
		case 11:
			if(dia==1)
			{
				dia=31;
				mes=10;
			}
			else
			{
				dia=dia-1;
			}
			break;
		case 12:
			if(dia==1)
			{
				dia=30;
				mes=11;
			}
			else
			{
				dia=dia-1;
			}
			break;
		}

		if(mes<10)
		{
			resp=anio+"0"+mes+"/";
		}
		else
		{
			resp=anio+mes+"/";
		}


		if(dia<10)
		{
			resp=resp+"0"+dia;
		}
		else
		{
			resp=resp+dia;
		}

		return resp;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public String metodo1c(int n) throws ParseException
	{
		LinearProbing<String, LinkedList<Commparendo>> tabla = new LinearProbing<String, LinkedList<Commparendo>>(600011);
		Nodo<Commparendo> hola = new  Nodo<Commparendo> (null);
		hola=(Nodo<Commparendo>) datos1.darprimero();
		Date fecha=cambiarStringaDate("2018/01/01");
		String resp="";
		int cc=0;

		while(hola!=null)
		{

			if (tabla.get(hola.darElem().llaveMetodo1C2C())==null)
			{
				LinkedList<Commparendo> x = new LinkedList<Commparendo>();
				x.AgregarElemento(hola.darElem());
				tabla.insertar(hola.darElem().llaveMetodo1C2C(), x);
			}
			else
			{
				tabla.get(hola.darElem().llaveMetodo1C2C()).AgregarElemento(hola.darElem());
			}
			hola=hola.darSiguiente();
		}


		int i=0;

		while ((i<n&&fecha.compareTo(cambiarStringaDate("2019/01/01"))<0))
		{
			int x=fecha.getDate();
			int y=fecha.getMonth()+1;
			String llave ="d"+x+"m"+y;

			if(tabla.get(llave)!=null)
			{
				cc=cc+tabla.get(llave).darTamano();
			}
			if(i==0)
			{
				resp=resp+"2018/";
				if(y<10)
				{
					resp=resp+"0"+y+"/";
				}
				else
				{
					resp=resp+y+"/";
				}

				if(x<10)
				{
					resp=resp+"0"+x+"-";
				}
				else
				{
					resp=resp+x+"-";
				}

			}
			if(i==n-1)
			{
				resp=resp+"2018/";
				if(y<10)
				{
					resp=resp+"0"+y+"/";
				}
				else
				{
					resp=resp+y+"/";
				}

				if(x<10)
				{
					resp=resp+"0"+x+" | ";
				}
				else
				{
					resp=resp+x+" | ";
				}

				int mozart = 0;

				if(cc%1000==0)
				{
					mozart = cc/1000;
				}
				else
				{
					mozart = (cc/1000)+1;
				}

				String asteriscos="";

				for(int j=1;j<mozart+1;j++)
				{
					asteriscos=asteriscos+"*";
				}
				resp=resp+asteriscos+"\n";
			}

			if(fecha.equals(cambiarStringaDate("2018/12/31")))
			{
				resp=resp+"2018/12/31"+" | ";
				int mozart = 0;

				if(cc%1000==0)
				{
					mozart = cc/1000;
				}
				else
				{
					mozart = (cc/1000)+1;
				}

				String asteriscos="";

				for(int j=1;j<mozart+1;j++)
				{
					asteriscos=asteriscos+"*";
				}
				resp=resp+asteriscos+"\n";
			}

			Date f = cambiarStringaDate(nextday(fecha));
			fecha=f;
			i++;

			if(i==n)
			{
				i=0;
				cc=0;
			}
		}
		return resp;
	}

	@SuppressWarnings("deprecation")
	public String generarLlave(Date x)
	{
		int j=x.getDate();
		int y=x.getMonth()+1;

		return "d"+j+"m"+y;

	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public String metodo2c() throws ParseException
	{
		LinearProbing<String, MaxColaPrioridadCommparendo2> tabla = new LinearProbing<String, MaxColaPrioridadCommparendo2>(600011);
		Nodo<Commparendo> hola = new  Nodo<Commparendo> (null);
		hola=(Nodo<Commparendo>) datos1.darprimero();
		String resp="";
		Date fechaActual = cambiarStringaDate("2018/01/01");
		Date fechaPasada = cambiarStringaDate("2018/01/01");
		Date fechaPasada2=null;


		while(hola!=null)
		{

			if (tabla.get(hola.darElem().llaveMetodo1C2C())==null)
			{
				MaxColaPrioridadCommparendo2 x = new MaxColaPrioridadCommparendo2();
				x.agregar(hola.darElem());
				tabla.insertar(hola.darElem().llaveMetodo1C2C(), x);
			}
			else
			{
				tabla.get(hola.darElem().llaveMetodo1C2C()).agregar(hola.darElem());
			}
			hola=hola.darSiguiente();
		}


		while(fechaActual.compareTo(cambiarStringaDate("2019/01/01"))<0)
		{
			int i=0;

			while(fechaPasada.compareTo(fechaActual)<=0 && i<1500)
			{

				Commparendo x;

				x=tabla.get(generarLlave(fechaPasada)).delMax();

				x.modificarDiasEspera(fechaActual);

				datos2.AgregarElemento(x);


				if(tabla.get(generarLlave(fechaPasada)).darNumElementos()==0)	
				{
					Date a = cambiarStringaDate(nextday(fechaPasada));
					fechaPasada = a;
				}
				i++;
			}

			fechaPasada2=fechaPasada;


			int falt=0;

			while(fechaPasada2.compareTo(fechaActual)<=0)
			{
				falt=falt+tabla.get(generarLlave(fechaPasada2)).darNumElementos();
				Date b = cambiarStringaDate(nextday(fechaPasada2));
				fechaPasada2=b;
			}


			int mes=fechaActual.getMonth()+1;
			int dia=fechaActual.getDate();
			resp=resp+"2018/";

			if(mes<10)
			{
				resp=resp+"0"+mes+"/";
			}
			else
			{
				resp=resp+mes+"/";
			}
			if(dia<10)
			{
				resp=resp+"0"+dia+" | ";
			}
			else
			{
				resp=resp+dia+" | ";
			}

			int chopin=0;

			if(i%15==0)
			{
				chopin = i/15;
			}
			else
			{
				chopin = (i/15)+1;
			}

			String asteriscos="";

			for(int j=1;j<chopin +1;j++)
			{
				asteriscos=asteriscos+"*";
			}
			resp=resp+asteriscos+"\n"+"           | ";

			int debussy=0;

			if(falt%200==0)
			{
				debussy = falt/200;
			}
			else
			{
				debussy = (falt/200)+1;
			}

			String numeral="";

			for(int j=1;j<debussy+1;j++)
			{
				numeral=numeral+"#";
			}
			resp=resp+numeral+"\n";

			fechaActual=cambiarStringaDate(nextday(fechaActual));
		}
		return resp;
	}

	public int perdidas2C()
	{
		Cola<Commparendo> ayuda = new Cola<Commparendo>();
		Nodo<Commparendo> hola = new  Nodo<Commparendo> (null);
		hola=(Nodo<Commparendo>) datos2.darprimero();
		int perdidas = 0;

		while(hola!=null)
		{
			if(hola.darElem().costoMetodo2C()!=0)
			{
				ayuda.enqueue(hola.darElem());
			}
			hola=hola.darSiguiente();
		}



		while(ayuda.isEmpty()==false)
		{
			perdidas = perdidas+ayuda.dequeue().costoMetodo2C();
		}

		return perdidas;
	}


	@SuppressWarnings({ "unchecked", "deprecation" })
	public String metodo3C() throws ParseException
	{
		LinearProbing<String, MaxColaPrioridadCommparendo2> tabla = new LinearProbing<String, MaxColaPrioridadCommparendo2>(600011);
		Nodo<Commparendo> hola = new  Nodo<Commparendo> (null);
		hola=(Nodo<Commparendo>) datos1.darprimero();
		String resp="";
		Date fechaActual = cambiarStringaDate("2018/01/01");

		while(hola!=null)
		{

			if (tabla.get(hola.darElem().llaveMetodo1C2C())==null)
			{
				MaxColaPrioridadCommparendo2 x = new MaxColaPrioridadCommparendo2();
				x.agregar(hola.darElem());
				tabla.insertar(hola.darElem().llaveMetodo1C2C(), x);
			}
			else
			{
				tabla.get(hola.darElem().llaveMetodo1C2C()).agregar(hola.darElem());
			}
			hola=hola.darSiguiente();
		}

		
		while(fechaActual.compareTo(cambiarStringaDate("2019/01/01"))<0)
		{


			while(tabla.get(generarLlave(fechaActual)).darNumElementos()!=0)
			{
				Commparendo x;
				x=tabla.get(generarLlave(fechaActual)).delMax();
				datos3.agregar(x);
			}
			
			int w=0;

			while(datos3.darNumElementos()!=0 && w<1500)
			{
				Commparendo x;
				x=datos3.delMax();
				x.modificarDiasEspera(fechaActual);
				datos4.AgregarElemento(x);
				w++;
			}

			int falt=datos3.darNumElementos();

			int mes=fechaActual.getMonth()+1;
			int dia=fechaActual.getDate();
			resp=resp+"2018/";

			if(mes<10)
			{
				resp=resp+"0"+mes+"/";
			}
			else
			{
				resp=resp+mes+"/";
			}
			if(dia<10)
			{
				resp=resp+"0"+dia+" | ";
			}
			else
			{
				resp=resp+dia+" | ";
			}

			int chopin=0;

			if(w%15==0)
			{
				chopin = w/15;
			}
			else
			{
				chopin = (w/15)+1;
			}

			String asteriscos="";

			for(int j=1;j<chopin +1;j++)
			{
				asteriscos=asteriscos+"*";
			}
			resp=resp+asteriscos+"\n"+"           | ";

			int debussy=0;

			if(falt%200==0)
			{
				debussy = falt/200;
			}
			else
			{
				debussy = (falt/200)+1;
			}

			String numeral="";

			for(int j=1;j<debussy+1;j++)
			{
				numeral=numeral+"#";
			}
			resp=resp+numeral+"\n";

			fechaActual=cambiarStringaDate(nextday(fechaActual));
		}
		return resp;
	}


	
	public int perdidas3C()
	{
		Cola<Commparendo> ayuda = new Cola<Commparendo>();
		Nodo<Commparendo> hola = new  Nodo<Commparendo> (null);
		hola=(Nodo<Commparendo>) datos4.darprimero();
		int perdidas = 0;

		while(hola!=null)
		{
			if(hola.darElem().costoMetodo2C()!=0)
			{
				ayuda.enqueue(hola.darElem());
			}
			hola=hola.darSiguiente();
		}



		while(ayuda.isEmpty()==false)
		{
			perdidas = perdidas+ayuda.dequeue().costoMetodo2C();
		}

		return perdidas;
	}
}





