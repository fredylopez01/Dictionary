package co.edu.uptc.persitence;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.Set;

import co.edu.uptc.model.DictionaryTraduction;

public class Persistence {
	private String routeEnglish;
	private String routeFrance;
	
	public Persistence(String routeEnglish, String routeFrance) {
		this.routeEnglish = routeEnglish;
		this.routeFrance = routeFrance;
	}
	
	public void readDictionary(DictionaryTraduction dictionary, String route) throws FileNotFoundException, IOException {
		FileReader file;
		file = new FileReader(route);
		BufferedReader buffer = new BufferedReader(file);
		String line;
		while((line = buffer.readLine()) != null) {
			String[] synonyms = line.split(",");
			dictionary.addWord(synonyms[0], synonyms[1]);
		}
		file.close();
	}
	
	public void saveWords(DictionaryTraduction dictionary, String route) throws FileNotFoundException, IOException {
		FileWriter file = new FileWriter(route);
		Set<Entry<String, String>> words = dictionary.getWords().entrySet();
		StringBuilder txtDictionary = new StringBuilder();
		for (Entry<String, String> entry: words) {
			txtDictionary.append(entry.getKey() + "," + entry.getValue() + "\n");
		}
		file.write(txtDictionary.toString());
		file.close();
	}

	public String getRouteEnglish() {
		return routeEnglish;
	}

	public void setRouteEnglish(String routeEnglish) {
		this.routeEnglish = routeEnglish;
	}

	public String getRouteFrance() {
		return routeFrance;
	}

	public void setRouteFrance(String routeFrance) {
		this.routeFrance = routeFrance;
	}
	
}
