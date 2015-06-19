package meme.com.memecode;

import java.io.*;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * MEMEReadWrite
 *
 */
public class MEMEReadWrite 
{
	
	static String filePath = "C:/Users/username/Documents/test.json";
	public static void main( String[] args ){

		JSONObject obj = new JSONObject();
		JSONArray list = new JSONArray();
		
		list.add("omg");
		list.add("GM");
		list.add("VGM");
		list.add("ASAP");
		list.add("FOAF");
		list.add("IOW");
		list.add("EOD");
		list.add("COB");
		list.add("LOL");
		
		obj.put("meme", list);

		try {

			FileWriter file = new FileWriter(filePath);
			file.write(obj.toJSONString());
			file.flush();
			file.close();

		}catch (IOException e) {
			
			e.printStackTrace();
		}

		System.out.println("Object Written in the Written in the file before reading & editing  : " + obj);
		
		readUpdateMeme(); // Method call for Read and Update the value 


	}
	
	static void  readUpdateMeme()
	{


		JSONParser parser = new JSONParser();

		try {

			Object obj1 = parser.parse(new FileReader(filePath));

			JSONObject jsonObject = (JSONObject) obj1;

			JSONObject obj = new JSONObject();
			
			
			FileWriter file = new FileWriter(filePath);
			
			
			
			// loop array
			JSONArray msg = (JSONArray) jsonObject.get("meme");
			Iterator<String> iterator = msg.iterator();
			
			int i = 0 ;
			while (iterator.hasNext()) {
				
				obj.put("Meme: " +iterator.next(),"Scores: "+ ++i);
			
			}
			file.write(obj.toJSONString());
			file.flush();
			file.close();

		}catch (FileNotFoundException fe) {
			
			fe.printStackTrace();
			
		} catch (IOException ioe) {
			
			ioe.printStackTrace();
			
		} catch (ParseException pe) {
			
			pe.printStackTrace();
		}

	}

}
