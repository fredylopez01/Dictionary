package co.edu.uptc.persitence;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;

import co.edu.uptc.model.DictionaryTraduction;

public class PersistenceJSON implements IPersistence {
	private JsonParser jsonParser;
	private JsonGenerator jsonGenerator;
	
	public PersistenceJSON(String routeFile) throws JsonParseException, IOException {
		jsonParser = new JsonFactory().createParser(new File(routeFile));
		jsonGenerator = new JsonFactory().createGenerator(new FileOutputStream(routeFile));
	}
	
	public void readDates(DictionaryTraduction dictionary) {
		try {
			while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
				while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
					if (jsonParser.getCurrentName() != null) {
						switch (jsonParser.getCurrentName()) {
							case "key":
								jsonParser.nextToken();
								String key = jsonParser.getText();
								jsonParser.nextToken();
								String value = jsonParser.nextTextValue();
								dictionary.addWord(key, value);
								break; 
						}
					}
				}
			}
			jsonParser.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	public void writeDates(DictionaryTraduction dictionary) {
		try {
			jsonGenerator.setPrettyPrinter(new DefaultPrettyPrinter());
			jsonGenerator.writeStartArray();
			Set<Entry<String, String>> words = dictionary.getWords().entrySet();
			for (Entry<String, String> entry: words) {
				jsonGenerator.writeStartObject();
				jsonGenerator.writeStringField("key", entry.getKey());
				jsonGenerator.writeStringField("value", entry.getValue());
				jsonGenerator.writeEndObject();
			}
			jsonGenerator.writeEndArray();
			jsonGenerator.flush();
			jsonGenerator.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
