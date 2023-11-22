package co.edu.uptc.persitence;

import co.edu.uptc.model.DictionaryTraduction;

public interface IPersistence {

	public void readDates(DictionaryTraduction dictionary);
	public void writeDates(DictionaryTraduction dictionary);
	
}
