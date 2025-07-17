package dataSources;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class PropertiesReader {

	static InputStream inputstream;
	
	public static String getPropertyValue(String file, String key ) throws IOException {
		Properties prop = new Properties();
		inputstream = new FileInputStream(file);
		prop.load(inputstream);
		return prop.getProperty(key);
	}

}
