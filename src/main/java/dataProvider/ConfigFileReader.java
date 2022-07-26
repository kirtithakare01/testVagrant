package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

	private Properties properties;
	private final String propertyFilePath = "config//config.properties";

	public ConfigFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}

	public String getMovieTitle() {
		String movieTitle = properties.getProperty("movie_title");
		if (movieTitle != null) {
			return movieTitle;
		} else {
			throw new RuntimeException("movieTitle not specified in the Configuration.properties file.");
		}
	}
	
	public String getSourceOne() {
		String source_one = properties.getProperty("source_one");
		if (source_one != null) {
			return source_one;
		} else {
			throw new RuntimeException("source_one not specified in the Configuration.properties file.");
		}
	}
	
	public String getSourceTwo() {
		String source_two = properties.getProperty("source_two");
		if (source_two != null) {
			return source_two;
		} else {
			throw new RuntimeException("source_two not specified in the Configuration.properties file.");
		}
	}
}
