package co.edu.uptc.persitence;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import co.edu.uptc.model.SynonymsDictionary;
import co.edu.uptc.model.Word;

public class Persistence {
	private String route;
	
	public Persistence(String route) {
		this.route = route;
	}
	
	public void readDictionary(SynonymsDictionary dictionary) throws FileNotFoundException, IOException {
		FileReader file;
		file = new FileReader(route);
		BufferedReader buffer = new BufferedReader(file);
		String line;
		while((line = buffer.readLine()) != null) {
			readLine(line, dictionary);
		}
		file.close();
	}
	
	public void readLine(String line, SynonymsDictionary dictionary) {
		String[] synonyms = line.split(";");
		Word word = new Word(synonyms[0]);
		addSynonyms(word, synonyms[1]);
		dictionary.addWord(word);
	}
	
	public void addSynonyms(Word word, String synonymsComplete) {
		String[] synonyms = synonymsComplete.split(",");
		for(int i = 0; i < synonyms.length; i++) {
			word.addSynonym(synonyms[i]);
		}
	}
	
	public void saveWords(ArrayList<Word> words) throws FileNotFoundException, IOException {
		FileWriter file = new FileWriter(route);
		String dictionary = wordsString(words);
		file.write(dictionary);
		file.close();
	}
	
	public String wordsString(ArrayList<Word> words) {
		StringBuffer dictionary = new StringBuffer();
		for(Word i: words) {
			dictionary.append(i.getWord()+ ";");
			for(String j: i.getSynonyms()) {
				dictionary.append(j+ ",");
			}
			dictionary.append("\n");
		}
		return dictionary.toString();
	}
}
