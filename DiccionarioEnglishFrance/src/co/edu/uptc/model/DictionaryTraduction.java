package co.edu.uptc.model;

import java.util.ArrayList;

public class DictionaryTraduction {
	private ArrayList<Word> words;

	public DictionaryTraduction() {
		words = new ArrayList<Word>();
	}
	
	public void addWord(Word word) {
		boolean add = false;
		for (Word i : words) {
			if(i.getWord().equals(word.getWord())) {
				add = true;
			}
		}
		if(!add) {
			words.add(word);
			add = true;
		}
	}
	
	public Word searchWord(String txtWord) {
		Word word = null;
		for (Word i : words) {
			if(i.getWord().equals(txtWord)) {
				word = i;
			}
		}
		return word;
	}
	
	@Override
	public String toString() {
		return words.toString();
	}
	
	public ArrayList<Word> getWords() {
		return words;
	}

	public void setWords(ArrayList<Word> words) {
		this.words = words;
	}
	
}
