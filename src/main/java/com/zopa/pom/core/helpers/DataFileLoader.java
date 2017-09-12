package com.zopa.pom.core.helpers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.zopa.pom.core.constants.FrameworkParams;

/*
 * Purpose:
 * 1. Read Data Text file and sends each line of text file as Item in List of String.
 */
public class DataFileLoader {

	public static List<String> readData(Class<?> classObject, String dataFileName){
		List<String> linesList = new ArrayList<String>();
		
		ClassLoader classLoader = Setup.class.getClassLoader();
		File file = new File(classLoader.getResource(FrameworkParams.PAGE_DATA_PROPERTIES_DIR+"/"+classObject.getSimpleName()+"/"+dataFileName).getFile());
		System.out.println("DataFileName="+file.getAbsolutePath());
		
		try (Scanner scanner = new Scanner(file)) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				linesList.add(line);
			}
			scanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return linesList;
	}
}
