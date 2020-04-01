package model.logic;
import model.data_structures.*;
import sun.awt.image.ImageWatched.Link;

import java.io.File;
import java.io.FileReader;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;


/**
 * Definicion del modelo del mundo
 * @param <K>
 *
 */
public class Modelo <T extends Comparable<T>>
{
	/**
	 * Atributos del modelo del mundo
	 */
	public static final String RUTA = "./data/comparendos_dei_2018_small.geojson";
	/**
	 * Elemento Json
	 */
	private JsonObject config;
	/**
	 * Asocion a la lista
	 */
	private LinkedList<T> datos1;
	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public Modelo()
	{
		config = openConfig(new File(RUTA));
		datos1 = new LinkedList<>();
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
	 */
	public void crearLista()
	{
		JsonArray nuevo = config.get("features").getAsJsonArray();
		for(int i = 0; i < nuevo.size(); i++)
		{
			JsonObject object = nuevo.get(i).getAsJsonObject();
			String objectId = object.get("properties").getAsJsonObject().get("OBJECTID").getAsString();
			String fechaHora=object.get("properties").getAsJsonObject().get("FECHA_HORA").getAsString();
			String medioDeten=object.get("properties").getAsJsonObject().get("MEDIO_DETE").getAsString();
			String claseVehiculo=object.get("properties").getAsJsonObject().get("CLASE_VEHI").getAsString();
			String TipoServicio=object.get("properties").getAsJsonObject().get("TIPO_SERVI").getAsString();
			String infraccion=object.get("properties").getAsJsonObject().get("INFRACCION").getAsString();
			String descripcion=object.get("properties").getAsJsonObject().get("DES_INFRAC").getAsString();
			String Localidad=object.get("properties").getAsJsonObject().get("LOCALIDAD").getAsString();
			JsonArray coords = object.get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray();
			double  longitud= coords.get(0).getAsDouble();
			double  latitud= coords.get(1).getAsDouble();
			
			Commparendo x = new Commparendo(objectId, fechaHora, medioDeten, claseVehiculo, TipoServicio, infraccion, descripcion, Localidad, longitud, latitud);
			datos1.AgregarElemento((T) x);
			//System.out.println(objectId + "\n" + fechaHora+"\n"+ medioDeten +"\n"+ claseVehiculo +"\n"+ TipoServicio+"\n"+ infraccion+"\n"+descripcion+"\n"+Localidad+"\n"+"Latitud: " + latitud + " Longitud: " + longitud+"\n");
		}
	}
}
