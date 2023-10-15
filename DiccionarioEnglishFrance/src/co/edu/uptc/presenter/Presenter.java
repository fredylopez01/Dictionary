package co.edu.uptc.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import co.edu.uptc.model.DictionaryTraduction;
import co.edu.uptc.persitence.Persistence;
import co.edu.uptc.persitence.PersistenceXML;
import co.edu.uptc.view.View;

public class Presenter implements ActionListener {
	private View viewTest;
	private DictionaryTraduction dictEnglish;
	private DictionaryTraduction dictFrance;
	private Persistence persistenceEnglish;
	private Persistence persistenceFrench;
	private PersistenceXML persistenceXMLEnglish;
	private PersistenceXML persistenceXMLFrench;
	
	public Presenter() {
		viewTest = new View(this);
		dictEnglish = new DictionaryTraduction();
		dictFrance = new DictionaryTraduction();
		persistenceEnglish = new Persistence("data/dictionaryEnglish.txt");
		persistenceFrench = new Persistence("data/dictionaryFrance.txt");
		createPersistences();
		readDates();
		viewTest.updateNumberEnglish(dictEnglish.getWords().size());
		viewTest.updateNumberFrench(dictFrance.getWords().size());
	}
	
	public void createPersistences() {
		try {
			persistenceXMLEnglish = new PersistenceXML("data/dictionaryEnglish.xml");
			persistenceXMLFrench = new PersistenceXML("data/dictionaryFrance.xml");
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void readDates() {
		try {
			persistenceEnglish.readDictionary(dictEnglish);
			persistenceFrench.readDictionary(dictFrance);
		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado-" + e.getMessage());
		} catch (IOException e) {
			System.out.println("Archivo encontrado, pero no se puede utilizar-" + e.getMessage());
		}
	}

	public static void main(String[] args) {
		new Presenter();
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
		addWordXML("English");
		viewTest.updateAddNewWord();
		viewTest.updateNumberEnglish(dictEnglish.getWords().size());
		saveDictionaries();
	}
	
	public void addTFrance() {
		createWord(dictFrance);
		addWordXML("Frech");
		viewTest.updateAddNewWord();
		viewTest.updateNumberFrench(dictFrance.getWords().size());
		saveDictionaries();
	}
	
	public void createWord(DictionaryTraduction dictionary) {
		String txtNewWord = viewTest.txtNewWord();
		String newTraduction = viewTest.txtNewTraduction();
		if(!txtNewWord.equals("") && !newTraduction.equals("")) {
			dictionary.addWord(txtNewWord, newTraduction);
		}
	}
	
	public void addWordXML(String dictionary) {
		String word = viewTest.txtNewWord();
		String traduction = viewTest.txtNewTraduction();
		switch(dictionary) {
		case "English":
			persistenceXMLEnglish.writeDOM2(word, traduction);
			break;
		case "French":
			persistenceXMLFrench.writeDOM2(word, traduction);
		}
	}
	
	public void saveDictionaries() {
		try {
			persistenceEnglish.saveWords(dictEnglish);
			persistenceFrench.saveWords(dictFrance);
		}  catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado-" + e.getMessage());
		} catch (IOException e) {
			System.out.println("Archivo encontrado, pero no se puede utilizar-" + e.getMessage());
		}
	}
}
