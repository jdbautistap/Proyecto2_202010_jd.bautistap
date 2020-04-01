package model.data_structures;

import com.google.gson.JsonElement;

import com.sun.tracing.dtrace.ArgsAttributes;


public  class Commparendo implements Comparable<Commparendo>
{
	/**
	 * Atributo Identificación de comparendo
	 */
	private String objectID;
	/**
	 * Atributo de la fecha y hora del comparendo
	 */	
	private String Fecha_Hora;
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
	 * Metodo constructor
	 */
	public Commparendo( String pObjectID, String pFecha_Hora,String pMedio_Dete, String pClase_Vehiculo, String pTipo_Servicio, String pInfraccion, String pDescripcion, String pLocalidad, double pLongitud, double pLatitud) 
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
	public String darfechaHora()
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
		String x="Codigo ObjectID: "+DarObjectID()+"\n"+"Fecha-Hora: "+darfechaHora()+"\n"+"Medio Dtencion: "+DarMedioDete()+"\n"+"Clase Vehiculo: "+darClasevehi()+"\n"+"Tipo Servicio: "+DartipoServi()+"\n"+"Infracción: "+darinfraccion()+"\n"+"Descripcion Infracción: "+dardescripcion()+"\n"+"Localidad"+DarLocalidad()+"\n"+"Latitud: "+DarLatitud()+"\n"+"Longitud: "+DarLongitud();
		return x;
	}
	/**
	 * Retorna Infromacion del comparendo para Taller4.
	 */
	public String Informacion2()
	{
		String x="El comparendo de Codigo ObjectID: "+ DarObjectID()+"Es un: "+darClasevehi()+" TieneLatitud: "+DarLatitud()+"\n";
		return x;
	}
	
	@Override
	public int compareTo(Commparendo arg0) 
	{
		// TODO Auto-generated method stub
		int resp=0;
		if(this.DarLatitud()<arg0.DarLatitud())
		{
			resp =-1;
		}
		else if (this.DarLatitud()>arg0.DarLatitud())
		{
			resp = 1;
		}
		else if (this.DarLatitud()==arg0.DarLatitud())
		{
			resp = 0;
		}
		return resp;
	}
}
