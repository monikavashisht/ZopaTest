package com.zopa.pom.core.helpers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.PosixFilePermission;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.zopa.pom.core.constants.FrameworkParams;

/*
 * Purpose:
 * 1. Responsible of setting up Web Driver executable file path in System Property.
 * 2. For OSX, it make sures that web drive file has correct permissions.
 * 3. Responsible for managing Web Driver path for three browsers : Firefox, Chrome, and PhantomJS
 * 4. Responsible for managing Web Driver path for both Windows OS and Mac OSX.
 */
public class Setup {
	private static Setup setupInstance = null;
	
	private Setup(){
		System.out.println("Setup.class is a singleton class");
	}
	
	public void browserLibrary(String browserName, String OSName) {		
		System.out.println("Browser Name : " + browserName);
		System.out.println("Operating System : " + OSName);
		System.out.println("[Before exporting drivers] : System Property for "+FrameworkParams.PATH_CHROME_DRIVER+" : " + System.getProperty(FrameworkParams.PATH_CHROME_DRIVER));
		System.out.println("[Before exporting drivers] : System Property for "+FrameworkParams.PATH_FIREFOX_DRIVER+" : " + System.getProperty(FrameworkParams.PATH_FIREFOX_DRIVER));
		System.out.println("[Before exporting drivers] : System Property for "+FrameworkParams.PATH_PHANTOMJS_DRIVER+" : " + System.getProperty(FrameworkParams.PATH_PHANTOMJS_DRIVER));
		
		if (OSName.equals(FrameworkParams.OS_WINDOWS_7) || OSName.equals(FrameworkParams.OS_WINDOWS_10)){
			if (browserName.equals(FrameworkParams.BROWSER_CHROME) 
					&& StringUtils.isBlank(System.getProperty(FrameworkParams.PATH_CHROME_DRIVER))) {
				ClassLoader classLoader = getClass().getClassLoader();
				File file = new File(classLoader.getResource(FrameworkParams.DRIVERS_DIR+"/"+FrameworkParams.FILE_CHROME_DRIVER_OS_WINDOWS).getFile());
				
				System.out.println("CHROME DRIVER PATH : " + file.getAbsolutePath());
				System.setProperty(FrameworkParams.PATH_CHROME_DRIVER, file.getAbsolutePath());
				System.out.println("CHROME DRIVER PATH AFTER Setting PROPERTY : " + System.getProperty(FrameworkParams.PATH_CHROME_DRIVER));
			}
			if (browserName.equals(FrameworkParams.BROWSER_FIREFOX) 
					&& StringUtils.isBlank(System.getProperty(FrameworkParams.PATH_FIREFOX_DRIVER))) {
				ClassLoader classLoader = getClass().getClassLoader();
				File file = new File(classLoader.getResource(FrameworkParams.DRIVERS_DIR+"/"+FrameworkParams.FILE_FIREFOX_DRIVER_OS_WINDOWS).getFile());
				
				System.out.println("CHROME DRIVER PATH : " + file.getAbsolutePath());
				System.setProperty(FrameworkParams.PATH_FIREFOX_DRIVER, file.getAbsolutePath());
				System.out.println("CHROME DRIVER PATH AFTER Setting PROPERTY : " + System.getProperty(FrameworkParams.PATH_FIREFOX_DRIVER));
			}
			if (browserName.equals(FrameworkParams.BROWSER_HEADLESS) 
					&& StringUtils.isBlank(System.getProperty(FrameworkParams.PATH_PHANTOMJS_DRIVER))) {
				ClassLoader classLoader = getClass().getClassLoader();
				File file = new File(classLoader.getResource(FrameworkParams.DRIVERS_DIR+"/"+FrameworkParams.FILE_PHANTOMJS_DRIVER_OS_WINDOWS).getFile());
				
				System.out.println("PHANTOMJS DRIVER PATH : " + file.getAbsolutePath());
				System.setProperty(FrameworkParams.PATH_PHANTOMJS_DRIVER, file.getAbsolutePath());
				System.out.println("PHANTOMJS DRIVER PATH AFTER Setting PROPERTY : " + System.getProperty(FrameworkParams.PATH_PHANTOMJS_DRIVER));
			}
		}
		
		if (OSName.equals(FrameworkParams.OS_MACOSX_10_12_1)) {
			Set<PosixFilePermission> perms = new HashSet<>();
			perms.add(PosixFilePermission.OWNER_EXECUTE);
			perms.add(PosixFilePermission.OWNER_WRITE);
			perms.add(PosixFilePermission.OWNER_READ);
			
			if (browserName.equals(FrameworkParams.BROWSER_FIREFOX) 
					&& StringUtils.isBlank(System.getProperty(FrameworkParams.PATH_FIREFOX_DRIVER))) {
				ClassLoader classLoader = getClass().getClassLoader();
				File file = new File(classLoader.getResource(FrameworkParams.DRIVERS_DIR+"/"+FrameworkParams.FILE_FIREFOX_DRIVER_OS_MAC).getFile());
				try {
					Files.setPosixFilePermissions(file.toPath(), perms);
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println("FIREFOX DRIVER PATH ON MAC : " + file.getAbsolutePath());
				System.setProperty(FrameworkParams.PATH_FIREFOX_DRIVER, file.getAbsolutePath());
				System.out.println("FIREFOX DRIVER PATH ON MAC AFTER Setting PROPERTY : " + System.getProperty(FrameworkParams.PATH_FIREFOX_DRIVER));
			}
			if (browserName.equals(FrameworkParams.BROWSER_CHROME) 
					&& StringUtils.isBlank(System.getProperty(FrameworkParams.PATH_CHROME_DRIVER))) {
				ClassLoader classLoader = getClass().getClassLoader();
				File file = new File(classLoader.getResource(FrameworkParams.DRIVERS_DIR+"/"+FrameworkParams.FILE_CHROME_DRIVER_OS_MAC).getFile());
				try {
					Files.setPosixFilePermissions(file.toPath(), perms);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				System.out.println("CHROME DRIVER PATH ON MAC : " + file.getAbsolutePath());
				System.setProperty(FrameworkParams.PATH_CHROME_DRIVER, file.getAbsolutePath());
				System.out.println("CHROME DRIVER PATH ON MAC AFTER Setting PROPERTY : " + System.getProperty(FrameworkParams.PATH_CHROME_DRIVER));
			}
			if (browserName.equals(FrameworkParams.BROWSER_HEADLESS) 
					&& StringUtils.isBlank(System.getProperty(FrameworkParams.PATH_PHANTOMJS_DRIVER))) {
				ClassLoader classLoader = getClass().getClassLoader();
				File file = new File(classLoader.getResource(FrameworkParams.DRIVERS_DIR+"/"+FrameworkParams.FILE_PHANTOMJS_DRIVER_OS_MAC).getFile());
				try {
					Files.setPosixFilePermissions(file.toPath(), perms);
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println("PHANTOMJS DRIVER PATH : " + file.getAbsolutePath());
				System.setProperty(FrameworkParams.PATH_PHANTOMJS_DRIVER, file.getAbsolutePath());
				System.out.println("PHANTOMJS DRIVER PATH AFTER Setting PROPERTY : " + System.getProperty(FrameworkParams.PATH_PHANTOMJS_DRIVER));
			}
		}
		System.out.println("[After exporting drivers] : System Property for "+FrameworkParams.PATH_CHROME_DRIVER+" : " + System.getProperty(FrameworkParams.PATH_CHROME_DRIVER));
		System.out.println("[After exporting drivers] : System Property for "+FrameworkParams.PATH_FIREFOX_DRIVER+" : " + System.getProperty(FrameworkParams.PATH_FIREFOX_DRIVER));
		System.out.println("[After exporting drivers] : System Property for "+FrameworkParams.PATH_PHANTOMJS_DRIVER+" : " + System.getProperty(FrameworkParams.PATH_PHANTOMJS_DRIVER));
	}
	
	public static Setup getInstance(){
		if (setupInstance==null){
			setupInstance = new Setup();
		}
		return setupInstance;
	}

}
