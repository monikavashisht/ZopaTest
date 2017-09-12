package com.zopa.pom.pageObjects;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zopa.pom.core.helpers.PagePropertyFile;

/*
 * Purpose:
 * 1. Page Object Model Class of Home Page.
 * 2. Static reference of properties object, make sure that Home_Page.properties file gets loaded as soon as this class is loaded.
 * 3. Responsible for dispatching WebElements associated with this page.
 */
public class Home_Page {
	public static final String URL = "http://www.zopa.com/";
	private static WebElement element = null;
	public static Properties properties = null;
	static {
		properties = PagePropertyFile.readProperties(Home_Page.class);
	}

	public static WebElement btn_GetZopaLoan(WebDriver driver) {
		element = driver.findElement(By.xpath(properties.getProperty("getAZopaLoan.btn.xpath")));
		return element;
	}

}
