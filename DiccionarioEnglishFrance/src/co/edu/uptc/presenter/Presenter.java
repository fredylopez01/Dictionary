package co.edu.uptc.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;

import co.edu.uptc.model.DictionaryTraduction;
import co.edu.uptc.model.Word;
import co.edu.uptc.persitence.Persistence;
import co.edu.uptc.view.View;

public class Presenter implements ActionListener {
	private View viewTest;
	private DictionaryTraduction dictEnglish;
	private DictionaryTraduction dictFrance;
	private Persistence persistenceTest;
	
	public Presenter() {
		viewTest = new View(this);
		dictEnglish = new DictionaryTraduction();
		dictFrance = new DictionaryTraduction();
		persistenceTest = new Persistence("data/dictionaryEnglish.txt", "data/dictionaryFrance.txt");
		readDates();
		viewTest.updateNumber(dictEnglish.getWords().size(), dictFrance.getWords().size());
	}
	
	public void readDates() {
		try {
			persistenceTest.readDictionary(dictEnglish, persistenceTest.getRouteEnglish());
			persistenceTest.readDictionary(dictFrance, persistenceTest.getRouteFrance());
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
			case "tEnglish"-> tEnglish();
			case "tFrance"-> tFrance();
			case "addTEnglish"-> addTEnglish();
			case "addTFrance"-> addTFrance();
		}
	}
	
	public void tEnglish() {
		String txtWord = viewTest.txtWord();
		Word wEnglish = dictEnglish.searchWord(txtWord);
		if(wEnglish != null) {
			viewTest.updateTEnGlish(wEnglish.getTraduction());
		} else {
			viewTest.updateTEnGlish("Sin traducir");
		}
	}
	
	public void tFrance() {
		String txtWord = viewTest.txtWord();
		Word wFrance = dictFrance.searchWord(txtWord);
		if(wFrance != null) {
			viewTest.updateTFrance(wFrance.getTraduction());
		} else {
			viewTest.updateTFrance("Sin traducir");
		}
	}
	
	public void addTEnglish() {
		dictEnglish.addWord(createWord());
		viewTest.updateAddNewWord();
		viewTest.updateNumber(dictEnglish.getWords().size(), dictFrance.getWords().size());
		saveDictionaries();
	}
	
	public void addTFrance() {
		dictFrance.addWord(createWord());
		viewTest.updateAddNewWord();
		viewTest.updateNumber(dictEnglish.getWords().size(), dictFrance.getWords().size());
		saveDictionaries();
	}
	
	public Word createWord() {
		Word newWord = null;
		String txtNewWord = viewTest.txtNewWord();
		String newTraduction = viewTest.txtNewTraduction();
		if(!txtNewWord.equals("") && !newTraduction.equals("")) {
			newWord = new Word(txtNewWord, newTraduction);
		}
		return newWord;
	}
	
	public void saveDictionaries() {
		try {
			persistenceTest.saveWords(dictEnglish.getWords(), persistenceTest.getRouteEnglish());
			persistenceTest.saveWords(dictFrance.getWords(), persistenceTest.getRouteFrance());
		}  catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado-" + e.getMessage());
		} catch (IOException e) {
			System.out.println("Archivo encontrado, pero no se puede utilizar-" + e.getMessage());
		}
	}
}
