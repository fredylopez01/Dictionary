package co.edu.uptc.model;

import java.util.HashMap;

public class DictionaryTraduction {
	private HashMap<String, String> words;

	public DictionaryTraduction() {
		words = new HashMap<String, String>();
	}
	
	public void addWord(String word, String traduction) {
		words.put(word, traduction);
	}
	
	public String searchTraduction(String word) {
		return words.get(word);
	}

	public HashMap<String, String> getWords() {
		return words;
	}

	public void setWords(HashMap<String, String> words) {
		this.words = words;
	}
	
}
