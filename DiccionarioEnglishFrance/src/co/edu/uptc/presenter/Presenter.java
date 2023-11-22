package co.edu.uptc.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import co.edu.uptc.model.DictionaryTraduction;
import co.edu.uptc.persitence.IPersistence;
import co.edu.uptc.persitence.Persistence;
import co.edu.uptc.persitence.PersistenceJSON;
import co.edu.uptc.persitence.PersistenceXML;
import co.edu.uptc.view.View;

public class Presenter implements ActionListener, WindowListener {
	private View viewTest;
	private DictionaryTraduction dictEnglish;
	private DictionaryTraduction dictFrance;
	private IPersistence persistenceEnglish;
	private IPersistence persistenceFrench;
	
	public Presenter() {
		viewTest = new View(this, this);
		dictEnglish = new DictionaryTraduction();
		dictFrance = new DictionaryTraduction();
		viewTest.selectFile();
		viewTest.updateNumberEnglish(dictEnglish.getWords().size());
		viewTest.updateNumberFrench(dictFrance.getWords().size());
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getActionCommand();
		String comand = source.toString();
		switch(comand) {
			case "chooseFile" -> chooseFile();
			case "tEnglish"-> tEnglish();
			case "tFrance"-> tFrance();
			case "addTEnglish"-> addTEnglish();
			case "addTFrance"-> addTFrance();
		}
	}
	
	public void chooseFile() {
		boolean isTxt = viewTest.getChooserFile().getOptiontxt().isSelected();
		boolean isXml = viewTest.getChooserFile().getOptionxml().isSelected();
		String typeFile = null;
		if(isTxt) {
			typeFile = "txt";
		} else if(isXml) {
			typeFile = "xml";
		} else {
			typeFile = "json";
		}
		viewTest.closeSelecFile();
		createPersistence(typeFile);
		readDates();
	}
	
	public void createPersistence(String type) {
		switch (type) {
		case "txt" -> createPersistenceTXT();
		case "xml" -> createPersistencesXML();
		case "json" -> createPersistencesJSON();
		}
	}
	
	public void createPersistenceTXT() {
		persistenceEnglish = new Persistence("data/dictionaryEnglish.txt");
		persistenceFrench = new Persistence("data/dictionaryFrance.txt");
	}
	
	public void createPersistencesXML() {
		try {
			persistenceEnglish = new PersistenceXML("data/dictionaryEnglish.xml");
			persistenceFrench = new PersistenceXML("data/dictionaryFrance.xml");
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public void createPersistencesJSON() {
		try {
			persistenceEnglish = new PersistenceJSON("data/dictionaryEnglish.json");
			persistenceFrench = new PersistenceJSON("data/dictionaryFrench.json");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void readDates() {
		persistenceEnglish.readDates(dictEnglish);
		persistenceFrench.readDates(dictFrance);
	}

	public static void main(String[] args) {
		new Presenter();
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
		viewTest.updateNumberEnglish(dictEnglish.getWords().size());
	}
	
	public void addTFrance() {
		createWord(dictFrance);
		viewTest.updateAddNewWord();
		viewTest.updateNumberFrench(dictFrance.getWords().size());
	}
	
	public void createWord(DictionaryTraduction dictionary) {
		String txtNewWord = viewTest.txtNewWord();
		String newTraduction = viewTest.txtNewTraduction();
		if(!txtNewWord.equals("") && !newTraduction.equals("")) {
			dictionary.addWord(txtNewWord, newTraduction);
		}
	}

	@Override
	public void windowOpened(WindowEvent e) {
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		saveDictionaries();
//		createPersistencesJSON();
//		saveDictionaries();
	}
	
	public void saveDictionaries() {
		persistenceEnglish.writeDates(dictEnglish);
		persistenceFrench.writeDates(dictFrance);
	}
	
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
