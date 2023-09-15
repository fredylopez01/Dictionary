package co.edu.uptc.model;

public class Word implements Comparable<Word> {
	private String word;
	private String traduction;
	
	public String getTraduction() {
		return traduction;
	}

	public void setTraduction(String traduction) {
		this.traduction = traduction;
	}

	public Word(String word, String traduction) {
		this.word = word;
		this.traduction = traduction ;
	}
	
	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	@Override
	public int compareTo(Word o) {
		return this.getWord().compareTo(o.getWord());
	}
	
}
