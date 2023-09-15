package co.edu.uptc.model;

import java.util.ArrayList;
import java.util.Comparator;

public class Word implements Comparable<Word> {
	private String word;
	private ArrayList<String> synonyms;
	
	public Word(String word) {
		this.word = word;
		synonyms = new ArrayList<String>();
	}
	
	public void addSynonym(String Synomyn) {
		boolean add = false;
		for(String i: synonyms) {
			if(i.equals(Synomyn)) {
				add = true;
			}
		}
		if(!add) {
			synonyms.add(Synomyn);
		}
	}
	
	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public ArrayList<String> getSynonyms() {
		return synonyms;
	}

	public void setSynonyms(ArrayList<String> synonyms) {
		this.synonyms = synonyms;
	}

	@Override
	public int compareTo(Word o) {
		return this.getWord().compareTo(o.getWord());
	}
	
}
