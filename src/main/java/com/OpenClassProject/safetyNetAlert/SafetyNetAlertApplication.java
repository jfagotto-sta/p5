package com.OpenClassProject.safetyNetAlert;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SafetyNetAlertApplication {

	public static void main(String[] args) throws IOException, ParseException {
		SpringApplication.run(SafetyNetAlertApplication.class, args);
		
		extracted();
	}

	public static void extracted() throws FileNotFoundException, IOException, ParseException {
		JSONParser jsonParse = new JSONParser();
		
		FileReader reader = new FileReader("D:\\WorkspaceSpring\\safetyNetAlert\\src\\main\\resources\\data\\data.json");
		
		Object obj = jsonParse.parse(reader);
		
		JSONObject jsonOb = (JSONObject)obj;
		
		JSONArray persons = (JSONArray) jsonOb.get("persons");
		JSONArray firestations = (JSONArray) jsonOb.get("firestations");
		JSONArray medicalerecords = (JSONArray) jsonOb.get("medicalrecords");
		
		System.out.println("Liste des personnes : " + persons);
		System.out.println("Liste des casernes : " + firestations);
		System.out.println("Liste des profils médicaux : " + medicalerecords);
	}
}
