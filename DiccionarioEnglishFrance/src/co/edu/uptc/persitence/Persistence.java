package co.edu.uptc.persitence;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import co.edu.uptc.model.DictionaryTraduction;
import co.edu.uptc.model.Word;

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
			readLine(line, dictionary);
		}
		file.close();
	}
	
	public void readLine(String line, DictionaryTraduction dictionary) {
		String[] synonyms = line.split(",");
		Word word = new Word(synonyms[0], synonyms[1]);
		dictionary.addWord(word);
	}
	
	public void saveWords(ArrayList<Word> words, String route) throws FileNotFoundException, IOException {
		FileWriter file = new FileWriter(route);
		String dictionary = wordsString(words);
		file.write(dictionary);
		file.close();
	}
	
	public String wordsString(ArrayList<Word> words) {
		StringBuffer dictionary = new StringBuffer();
		for(Word i: words) {
			dictionary.append(i.getWord()+"," + i.getTraduction() + "\n");
		}
		return dictionary.toString();
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
