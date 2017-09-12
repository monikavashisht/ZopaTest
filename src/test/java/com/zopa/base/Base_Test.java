package com.zopa.base;

import org.apache.commons.lang3.StringUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

import com.zopa.pom.core.constants.FrameworkParams;
import com.zopa.pom.core.helpers.Browser;
import com.zopa.pom.core.helpers.Setup;

/*
 * Purpose:
 * 1. This file is responsible to setup browser based on operating system and type of browser.
 * 2. Operating system is detected by this program on runtime and associate all relevant libraries in System property via Setup.java
 * 3. Default Browser to trigger on runtime is Chrome for both windows and OSX platform.
 * 4. Default Browser can be override by supplying command line param -Dbrowser=firefox for Firfox Browser and so on for other browsers.
 */
public abstract class Base_Test {
	
	private static Browser browserInstance = null;
	private static String browser = null;
	private static String OS = null;
	
	public static void setupBrowser(){
		browserInstance = new Browser();
		OS = System.getProperty("os.name").toLowerCase();
		if (StringUtils.isNotBlank(OS)){
			if (OS.indexOf("mac")>=0){
				OS = FrameworkParams.OS_MACOSX_10_12_1;
			}
			if (OS.indexOf("win")>=0){
				OS = FrameworkParams.OS_WINDOWS_10;
			}
		} else {
			OS = FrameworkParams.OS_MACOSX_10_12_1;
		}
		
		browser = System.getProperty(FrameworkParams.SYS_PROP_BROWSER);
		if (StringUtils.isNotBlank(browser)){
			if (browser.equalsIgnoreCase(FrameworkParams.BROWSER_CHROME)){
				browser = FrameworkParams.BROWSER_CHROME;
			}
			if (browser.equalsIgnoreCase(FrameworkParams.BROWSER_FIREFOX)){
				browser = FrameworkParams.BROWSER_FIREFOX;
			}
			if (browser.equalsIgnoreCase(FrameworkParams.BROWSER_HEADLESS)){
				browser = FrameworkParams.BROWSER_HEADLESS;
			}
		} else {
			browser = FrameworkParams.BROWSER_CHROME;
		}
		Setup.getInstance().browserLibrary(browser, OS);
		
	}

	public static WebDriver getDriver() {
		if (browser.equalsIgnoreCase(FrameworkParams.BROWSER_CHROME)){
			return browserInstance.getChromeDriver();
		} else if (browser.equalsIgnoreCase(FrameworkParams.BROWSER_FIREFOX)){
			return browserInstance.getFireFoxDriver();
		} else if (browser.equalsIgnoreCase(FrameworkParams.BROWSER_HEADLESS)){
			return browserInstance.getPhantomJSDriver();
		} else {
			return browserInstance.getChromeDriver();
		}
	}
	
	public static void closeBrowser(){
		if (browser.equalsIgnoreCase(FrameworkParams.BROWSER_CHROME)){
			browserInstance.closeChromeBrowser();
		} else if (browser.equalsIgnoreCase(FrameworkParams.BROWSER_FIREFOX)){
			browserInstance.closeFirefoxBrowser();
		} else if (browser.equalsIgnoreCase(FrameworkParams.BROWSER_HEADLESS)){
			browserInstance.closePhantomJSBrowser();
		} else {
			browserInstance.closeChromeBrowser();
		}
	}
}
