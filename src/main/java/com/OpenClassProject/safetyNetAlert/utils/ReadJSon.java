package com.OpenClassProject.safetyNetAlert.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJSon {
	@SuppressWarnings("unchecked")
	
	public static void extracted() throws FileNotFoundException, IOException, ParseException {
		
		final String source = "D:\\\\WorkspaceSpring\\\\safetyNetAlert\\\\src\\\\main\\\\resources\\\\data\\\\data.json";
		
		
		JSONParser jsonParse = new JSONParser();
		FileReader reader = new FileReader(source);
		
		Object obj = jsonParse.parse(reader);
		
		JSONObject jsonOb = (JSONObject)obj;
		
		ArrayList<String> persons = (ArrayList<String>) jsonOb.get("persons");
		ArrayList<String> firestations = (ArrayList<String>) jsonOb.get("firestations");
		ArrayList<String> medicalerecords = (ArrayList<String>) jsonOb.get("medicalrecords");
		
		System.out.println("Liste des personnes : " + persons);
		System.out.println("Liste des casernes : " + firestations);
		System.out.println("Liste des profils médicaux : " + medicalerecords);
		
	}
}
