package co.edu.uptc.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import co.edu.uptc.model.DictionaryTraduction;
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
		String traduction = dictEnglish.searchTraduction(txtWord);
		if(traduction != null) {
			viewTest.updateTEnGlish(traduction);
		} else {
			viewTest.updateTEnGlish("Sin traducir");
		}
	}
	
	public void tFrance() {
		String txtWord = viewTest.txtWord();
		String traduction = dictFrance.searchTraduction(txtWord);
		if(traduction != null) {
			viewTest.updateTFrance(traduction);
		} else {
			viewTest.updateTFrance("Sin traducir");
		}
	}
	
	public void addTEnglish() {
		createWord(dictEnglish);
		viewTest.updateAddNewWord();
		viewTest.updateNumber(dictEnglish.getWords().size(), dictFrance.getWords().size());
		saveDictionaries();
	}
	
	public void addTFrance() {
		createWord(dictFrance);
		viewTest.updateAddNewWord();
		viewTest.updateNumber(dictEnglish.getWords().size(), dictFrance.getWords().size());
		saveDictionaries();
	}
	
	public void createWord(DictionaryTraduction dictionary) {
		String txtNewWord = viewTest.txtNewWord();
		String newTraduction = viewTest.txtNewTraduction();
		if(!txtNewWord.equals("") && !newTraduction.equals("")) {
			dictionary.addWord(txtNewWord, newTraduction);
		}
	}
	
	public void saveDictionaries() {
		try {
			persistenceTest.saveWords(dictEnglish, persistenceTest.getRouteEnglish());
			persistenceTest.saveWords(dictFrance, persistenceTest.getRouteFrance());
		}  catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado-" + e.getMessage());
		} catch (IOException e) {
			System.out.println("Archivo encontrado, pero no se puede utilizar-" + e.getMessage());
		}
	}
}
