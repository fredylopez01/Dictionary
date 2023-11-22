package co.edu.uptc.persitence;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.Set;

import co.edu.uptc.model.DictionaryTraduction;

public class Persistence implements IPersistence {
	private String route;
	
	public Persistence(String route) {
		this.route = route;
	}
	
	public void readDates(DictionaryTraduction dictionary) {
		FileReader file;
		try {
			file = new FileReader(route);
			BufferedReader buffer = new BufferedReader(file);
			String line;
			while((line = buffer.readLine()) != null) {
				String[] synonyms = line.split(",");
				dictionary.addWord(synonyms[0], synonyms[1]);
			}
			file.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void writeDates(DictionaryTraduction dictionary) {
		FileWriter file;
		try {
			file = new FileWriter(route);
			Set<Entry<String, String>> words = dictionary.getWords().entrySet();
			StringBuilder txtDictionary = new StringBuilder();
			for (Entry<String, String> entry: words) {
				txtDictionary.append(entry.getKey() + "," + entry.getValue() + "\n");
			}
			file.write(txtDictionary.toString());
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getRoute() {
		return route;
	}

	public void setRouteEnglish(String route) {
		this.route = route;
	}
	
}
