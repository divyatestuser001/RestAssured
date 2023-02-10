package com.RestAssured.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class ReadDataFromPropFile {

	Properties properties;
	String key;
	public ReadDataFromPropFile() throws IOException {
		FileInputStream fis = new FileInputStream(".\\Config\\confg.properties");
		properties = new Properties();
		properties.load(fis);
		
//		System.out.println(properties.getProperty("Content-Type"));
//		System.out.println(properties.getProperty("Transfer-Encoding"));
//		System.out.println(properties.getProperty("X-Powered-By"));
//		System.out.println(properties.getProperty("Server"));
		
		Enumeration e = properties.keys();

		while (e.hasMoreElements()) {

			String key = (String) e.nextElement();
//			System.out.println(key + "---" + properties.get(key)); 
			System.out.println(properties.get(key));
		}
	}
	
	public String getAll4Data() {
		Enumeration e = properties.keys();

		while (e.hasMoreElements()) {

			key = (String) e.nextElement();
//			return key;
//			System.out.println(key + "---" + properties.get(key)); 
		}
		return (String) properties.get(key);
//		return (key + "---" + properties.get(key));

	}
	
}
