package co.edu.uptc.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;

import co.edu.uptc.model.SynonymsDictionary;
import co.edu.uptc.model.Word;
import co.edu.uptc.persitence.Persistence;
import co.edu.uptc.view.View;

public class Presenter implements ActionListener {
	private View viewTest;
	private SynonymsDictionary dictionaryTest;
	private Persistence persistenceTest;
	
	public Presenter() {
		viewTest = new View(this);
		dictionaryTest = new SynonymsDictionary();
		persistenceTest = new Persistence("data/dictionary.txt");
		readDates();
	}
	
	public void readDates() {
		try {
			persistenceTest.readDictionary(dictionaryTest);
		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado-" + e.getMessage());
		} catch (IOException e) {
			System.out.println("Archivo encontrado, pero no se puede utilizar-" + e.getMessage());
		}
	}

	public static void main(String[] args) {
		Presenter presenterTest = new Presenter();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getActionCommand();
		String comand = source.toString();
		switch(comand) {
			case "find"-> findSynonym();
			case "back"-> back();
			case "next"-> next();
			case "addWord"-> openAddWord();
			case "addWordDefinitive"-> addWord();
			case "addSynonym"-> openAddSynonym();
			case "addSynonymDefinitive"-> addSynonym();
		}
	}
	
	public void findSynonym() {
		Word word = dictionaryTest.searchWord(viewTest.txtWord());
		if(word != null) {
			dictionaryTest.setWordNow(word);
			if(word.getSynonyms().size() != 0) {
				dictionaryTest.setSynonymIndex(0);
				changeSynonym(0);
			} else {
				viewTest.updateSynonyms(0, "Palabra sin Sinonimos agregados");
			}
		} else {
			viewTest.updateSynonyms(0, "Palabra No encontrada");
		}
	}
	
	public void changeSynonym(int synonym) {
		int numSynonyms = dictionaryTest.getWordNow().getSynonyms().size();
		String txtSynonym = dictionaryTest.getWordNow().getSynonyms().get(synonym);
		viewTest.updateSynonyms(numSynonyms, txtSynonym);
	}
	
	public void back() {
		int back = dictionaryTest.getSynonym()-1;
		if(back < 0) {
			back = dictionaryTest.getWordNow().getSynonyms().size()-1;
		}

		dictionaryTest.setSynonymIndex(back);
		changeSynonym(back);
	}
	
	public void next() {
		int next = dictionaryTest.getSynonym()+1;
		if(next == dictionaryTest.getWordNow().getSynonyms().size()) {
			next = 0;
		}
		dictionaryTest.setSynonymIndex(next);
		changeSynonym(next);
	}
	
	public void openAddWord() {
		viewTest.openAddWord();
	}
	
	public void addWord() {
		Word word = new Word(viewTest.newWord());
		dictionaryTest.addWord(word);
		saveDictionary();
		viewTest.closeAddWord();
	}
	
	public void saveDictionary() {
		try {
			Collections.sort(dictionaryTest.getWords());
			persistenceTest.saveWords(dictionaryTest.getWords());
		} catch (FileNotFoundException e) {
			System.out.println("Archivo No encontrado");
		} catch (IOException e) {
			System.out.println("Archivo encontrado, pero no se puede utilizar");
		}
	}
	
	public void openAddSynonym() {
		String[] words = new String[dictionaryTest.getWords().size()];
		for(int i = 0; i < words.length; i++) {
			words[i] = dictionaryTest.getWords().get(i).getWord();
		}
		viewTest.openAddSynonym(words);
	}
	
	public void addSynonym() {
		String txtWord = viewTest.wordNewSynonym();
		Word word = dictionaryTest.searchWord(txtWord);
		String newSynonym = viewTest.newSynonym();
		word.addSynonym(newSynonym);
		saveDictionary();
		viewTest.closeAddSynonym();
	}
}
