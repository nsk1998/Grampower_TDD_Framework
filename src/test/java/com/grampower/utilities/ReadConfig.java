package com.grampower.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfig {

	
	
	//1. Create object of properties
	Properties properties;
	
	//2. Path of config.properties file
	String path = "C:/Users/Lenovo/Desktop/Grampower_DataDrivenFramework/Grampower_DataDrivenFramework.zip_expanded/Grampower_DataDrivenFramework/Configuration/config.properties";
	
	//3. Creating the constructor to load the config file
	public ReadConfig() {
		try {	 
			properties =new Properties();
			
			FileInputStream fis = new FileInputStream(path);
			
			properties.load(fis);							//loading config file
		}
		
		catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		
	}	
		
	//4. Creating relatives methods for each saved key in config.properties file :
		//these methods will return string values which can be used
	
	public String getBaseUrl(){
		String value = properties.getProperty("baseUrl");
		
		if(value!=null) {
			return value;
		}
		
		else {
			throw new RuntimeException("Base URL is not available in config file at Key 'baseUrl', Please Check");
		}
	}
	
	public String getBrowser(){
		String value = properties.getProperty("browser");
		
		if(value!=null) {
			return value;
		}
		
		else {
			throw new RuntimeException("Browser Name is not available in config file at Key 'browser', Please Check");
		}
	}
	
	

	
	
	
}
