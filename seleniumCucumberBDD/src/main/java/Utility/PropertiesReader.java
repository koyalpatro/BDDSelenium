package Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
	
	public Properties getProperty() throws IOException
	{
		
		FileInputStream inputStream=null;
        Properties properties = new Properties();
        try {        	 
            properties.load(new FileInputStream("src/test/resources/browser.config.properties"));
           // properties.load(new FileInputStream("resources/testdata-config.properties"));
        } catch (Exception e) {
            System.out.println("Exception: " + e);
       } 
         return properties;	
	}
}
