package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJSon {
	public static void readDataFromJsonFile() throws IOException, ParseException {
		JSONParser jsonp = new JSONParser();
		
		try {
			FileReader reader = new FileReader("data.json");
			Object obj = jsonp.parse(reader);
			JSONArray resultat = (JSONArray) obj;
			System.out.println(resultat);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
