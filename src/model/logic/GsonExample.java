package model.logic;
import java.io.File;
import java.io.FileReader;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

public class GsonExample
{
	private final static String RUTA = "./data/comparendos_dei_2018_small.geojson";

	private JsonObject object;

	public GsonExample()
	{
		object = openConfig(new File(RUTA));
	}

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
	public void leerJson()
	{
		JsonArray nuevo = object.get("features").getAsJsonArray();
		for(int i = 0; i < nuevo.size(); i++)
		{
			JsonObject object = nuevo.get(i).getAsJsonObject();
			JsonArray coords = object.get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray();
			System.out.println("Latitud: " + coords.get(0) + " Longitud: " + coords.get(1));
		}
	}
	
	public void leerJson2()
	{
		JsonArray nuevo = object.get("features").getAsJsonArray();
		for(int i = 0; i < nuevo.size(); i++)
		{
			JsonObject object = nuevo.get(i).getAsJsonObject();
			String objectId = object.get("properties").getAsJsonObject().get("OBJECTID").getAsString();
			JsonArray coords = object.get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray();
			System.out.println("Latitud: " + coords.get(0) + " Longitud: " + coords.get(1) + "..." + objectId);
		}
	}


	public static void main(String[] args)
	{
		GsonExample gsonEx = new GsonExample();
		gsonEx.leerJson2();
	}
}
