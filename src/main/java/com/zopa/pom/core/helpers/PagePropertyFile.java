package com.zopa.pom.core.helpers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.zopa.pom.core.constants.FrameworkParams;

/*
 * Purpose:
 * 1. Reads property file of a page object model class.
 * 2. Returns the properties object of the Page Object Model Web Page which contains xpath, css or id selector of web elements.
 */
public class PagePropertyFile {

	public static Properties readProperties(Class<?> classObject){
		Properties properties = new Properties();
		
		ClassLoader classLoader = Setup.class.getClassLoader();
		InputStream inputStream = classLoader.getResourceAsStream(FrameworkParams.PAGE_WEB_ELEMENTS_PROPERTIES_DIR+"/"+classObject.getSimpleName()+".properties");
		
		if (inputStream!=null){
			try {
				properties.load(inputStream);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}		
		return properties;
	}

}
