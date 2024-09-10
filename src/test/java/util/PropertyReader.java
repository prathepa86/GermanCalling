package util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReader {
	public static String readDataFromPropertyFile(String fileName,String propertyKey) {
		File filePath=new File("./data/"+fileName+".properties");
		String propertyValue="";
		FileInputStream oFis;
		try {
			oFis = new FileInputStream(filePath);
			Properties properties=new Properties();
			properties.load(oFis);
			propertyValue= properties.getProperty(propertyKey);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return propertyValue;
		
	}

}
