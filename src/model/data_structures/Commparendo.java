package model.data_structures;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public  class Commparendo implements Comparable<Commparendo>
{
	/**
	 * Atributo Identificación de comparendo
	 */
	private String objectID;
	/**
	 * Atributo de la fecha y hora del comparendo
	 */	
	private Date Fecha_Hora;
	/**
	 * Atributo del medio de detencion
	 */	
	private String Medio_Dete;
	/**
	 * Atributo clase de vehiculo 
	 */	
	private String Clase_Vehiculo;
	/**
	 * Atributo Tipo de servicio del vehiculo
	 */	
	private String Tipo_Servicio;
	/**
	 * Atributo de la infracción
	 */	
	private String Infraccion;
	/**
	 * Atributo de la descripcion del comparendo
	 */	
	private String Descripcion;
	/**
	 * Atributos de la localidad donde se ubicó el comparendo
	 */	
	private String Localidad;
	/**
	 * Atributo latitud de la ubicaión del comparendo
	 */	
	private double Latitud;
	/**
	 * Atributos longitud de la ubicación del comparendo
	 */	
	private double Longitud;
	/**
	 * Atributos Dias de espera.
	 */	

	private int diasEspera;

	/**
	 * Metodo constructor
	 */
	public Commparendo( String pObjectID, Date pFecha_Hora,String pMedio_Dete, String pClase_Vehiculo, String pTipo_Servicio, String pInfraccion, String pDescripcion, String pLocalidad, double pLongitud, double pLatitud) 
	{
		objectID=pObjectID;
		Fecha_Hora=pFecha_Hora;
		Medio_Dete=pMedio_Dete;
		Clase_Vehiculo=pClase_Vehiculo;
		Tipo_Servicio=pTipo_Servicio;
		Infraccion=pInfraccion;
		Descripcion=pDescripcion;
		Localidad=pLocalidad;
		Longitud=pLongitud;
		Latitud=pLatitud;
		diasEspera=0;
	}
	/**
	 * Retorna el Id del comparendo 
	 */
	public String DarObjectID()
	{
		return objectID;
	}
	/**
	 * Retorna fecha y hora del comparendo
	 */
	public Date darfechaHora()
	{
		return Fecha_Hora;
	}
	/**
	 * Retorna medio de detencion
	 */
	public String DarMedioDete()
	{
		return Medio_Dete;
	}
	/**
	 * Retorna clase del vehiculo
	 */
	public String darClasevehi()
	{
		return Clase_Vehiculo;
	}
	/**
	 * Retorna tipo de servicio del vehiculo
	 */
	public String DartipoServi()
	{
		return Tipo_Servicio;
	}
	/**
	 * Retorna el tipo de infracción
	 */
	public String darinfraccion()
	{
		return Infraccion;
	}
	/**
	 * Retorna la descripción del comparendo
	 */
	public String dardescripcion()
	{
		return Descripcion;
	}
	/**
	 * Retorna la localidad donde fue cometido el comparendo
	 */
	public String DarLocalidad()
	{
		return Localidad;
	}
	/**
	 * Retorna la latitud de la ubicacion del comparendo
	 */
	public double DarLatitud()
	{
		return Latitud;
	}
	/**
	 * Retorna la longitud de la ubicacion del comparendo
	 */
	public double DarLongitud()
	{
		return Longitud;
	}
	/**
	 * Retorna Infromacion del comparendo.
	 */
	public String Informacion()
	{
		String x="Codigo ObjectID: "+DarObjectID()+"\n"+"Fecha-Hora: "+darfechaHora()+"\n"+"Medio Dtencion: "+DarMedioDete()+"\n"+"Clase Vehiculo: "+darClasevehi()+"\n"+"Tipo Servicio: "+DartipoServi()+"\n"+"Infracción: "+darinfraccion()+"\n"+"Descripcion Infracción: "+dardescripcion()+"\n"+"Localidad"+DarLocalidad()+"\n"+"Latitud: "+DarLatitud()+"\n"+"Longitud: "+DarLongitud()+"         "+darprecio();
		return x;
	}
	/**
	 * Retorna Infromacion del comparendo para Taller4.
	 */
	public String InformacionA1()
	{
		String x="Comparendo de Codigo ObjectID: "+ DarObjectID()+" Tipo de servicio: "+DartipoServi()+" Tiene Infracción: "+darinfraccion()+" Fecha-hora:"+darfechaHora()+" La clase del vehiculo es:"+darClasevehi()+"\n";
		return x;
	}

	public String InformacionA2()
	{
		String x="Fecha-hora:"+darfechaHora()+" Comparendo de Codigo ObjectID: "+DarObjectID()+" La Localidad es:"+DarLocalidad()+"\n";
		return x;
	}

	public String InformacionA3()
	{
		String x="Comparendo de Codigo ObjectID: "+DarObjectID()+" Fecha-hora:"+darfechaHora()+" La Localidad es:"+DarLocalidad()+"   "+darprecio()+"\n";
		return x;
	}

	@Override
	public int compareTo(Commparendo arg0) 
	{
		// Done Auto-generated method stub
		int resp=0;
		if(this.DartipoServi().equals("PÃºblico")&&(arg0.DartipoServi().equals("Particular")||(arg0.DartipoServi().equals("Oficial"))))
		{
			resp = 1;
		}
		else if (this.DartipoServi().equals("Oficial")&&(arg0.DartipoServi().equals("Particular")))
		{
			resp = 1;
		}
		else if (this.DartipoServi().equals("Particular")&&(arg0.DartipoServi().equals("Oficial")||(arg0.DartipoServi().equals("PÃºblico"))))
		{
			resp = -1;
		}
		else if (this.DartipoServi().equals(arg0.DartipoServi()))
		{
			resp=this.darinfraccion().compareTo(arg0.darinfraccion());
		}
		return resp;
	}

	public int compareTo3A(Commparendo arg0) 
	{
		int x=0;
		x=this.darfechaHora().compareTo(arg0.darfechaHora());
		return x;

	}

	public int compareTo2C(Commparendo arg0) 
	{
		int x=0;

		if(this.darfechaHora().compareTo(arg0.darfechaHora())<0)
		{
			x=1;
		}
		else if (this.darfechaHora().compareTo(arg0.darfechaHora())>0)
		{
			x=-1;
		}
		else if (this.darfechaHora().compareTo(arg0.darfechaHora())==0)
		{
			x=0;
		}

		return x;

	}

	@SuppressWarnings("deprecation")
	public String llaveMetodo1C2C()
	{
		int x=darfechaHora().getDate();
		int y=darfechaHora().getMonth()+1;

		return "d"+x+"m"+y;
	}

	@SuppressWarnings("deprecation")
	public String llaveMetodo2A()
	{
		int x=darfechaHora().getDay();
		int y=darfechaHora().getMonth()+1;

		return"d"+x+"m"+y;
	}

	public int darprecio()
	{
		int precio=4;

		if(dardescripcion().contains("SERA INMOVILIZADO")||dardescripcion().contains("SERÁ INMOVILIZADO"))
		{
			precio=400;
		}
		else if (dardescripcion().contains("LICENCIA DE CONDUCCIÓN")||dardescripcion().contains("LICENCIA DE CONDUCCION"));
		{
			precio=40;
		}

		return precio;

	}
	public Date cambiarStringaDate(String g) throws ParseException
	{
		SimpleDateFormat parser = new SimpleDateFormat("yyyy/MM/dd");
		Date fechaHora = parser.parse(g);
		return fechaHora;
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
	public void modificarDiasEspera(Date x) throws ParseException
	{
		int j=this.darfechaHora().getDate();
		int i=this.darfechaHora().getMonth()+1;
		int contador=0;
		Date aux = cambiarStringaDate("2018/"+i+"/"+j);;
		if(x.equals(this.darfechaHora()))
		{

			while(x.compareTo(aux)<=0 && aux.compareTo(cambiarStringaDate("2019/01/01"))<0)
			{
				Date aux2=cambiarStringaDate(nextday(aux));
				aux=aux2;
				contador++;
			}
		}

		diasEspera=contador;
	}


	public int compareto3C(Commparendo arg)

	{
		int bizet= 0;

		if (this.darprecio()>arg.darprecio())
		{
			bizet=1;
		}
		else if(this.darprecio()<arg.darprecio())
		{
			bizet=-1;
		}
		else if(this.darprecio()==arg.darprecio())
		{
			bizet=0;
		}
		return bizet;
	}




	public int costoMetodo2C()
	{
		int x=darprecio()*diasEspera;
		return x;
	}
}
