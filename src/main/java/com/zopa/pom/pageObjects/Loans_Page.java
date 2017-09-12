package com.zopa.pom.pageObjects;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zopa.pom.core.helpers.PagePropertyFile;

/*
 * Purpose:
 * 1. Page Object Model Class of Loans Page.
 * 2. Static reference of properties object, make sure that Loans_Page.properties file gets loaded as soon as this class is loaded.
 * 3. Responsible for dispatching WebElements associated with this page.
 */
public class Loans_Page {
	public static final String URL = "https://www.zopa.com/loans";
	private static WebElement element = null;
	public static Properties properties = null;
	static {
		properties = PagePropertyFile.readProperties(Loans_Page.class);
	}

	public static WebElement txtbx_LoanAmount(WebDriver driver) {
		element = driver.findElement(By.xpath(properties.getProperty("loanAmount.txtbx.xpath")));
		return element;
	}
	
	public static WebElement btn_LoanAmountPlusButton(WebDriver driver) {
		element = driver.findElement(By.xpath(properties.getProperty("loanAmountPlusButton.btn.xpath")));
		return element;
	}
	
	public static WebElement btn_LoanAmountMinusButton(WebDriver driver) {
		element = driver.findElement(By.xpath(properties.getProperty("loanAmountMinusButton.btn.xpath")));
		return element;
	}
	
	public static WebElement radioBtn_OneYearLoanTerm(WebDriver driver) {
		element = driver.findElement(By.xpath(properties.getProperty("oneYearTerm.lbl.xpath")));
		return element;
	}
	
	public static WebElement radioBtn_TwoYearLoanTerm(WebDriver driver) {
		element = driver.findElement(By.xpath(properties.getProperty("twoYearTerm.lbl.xpath")));
		return element;
	}
	
	public static WebElement radioBtn_ThreeYearLoanTerm(WebDriver driver) {
		element = driver.findElement(By.xpath(properties.getProperty("threeYearTerm.lbl.xpath")));
		return element;
	}
	
	public static WebElement radioBtn_FourYearLoanTerm(WebDriver driver) {
		element = driver.findElement(By.xpath(properties.getProperty("fourYearTerm.lbl.xpath")));
		return element;
	}
	
	public static WebElement radioBtn_FiveYearLoanTerm(WebDriver driver) {
		element = driver.findElement(By.xpath(properties.getProperty("fiveYearTerm.lbl.xpath")));
		return element;
	}
	
	public static WebElement submitBtn_GetPersonalisedRates(WebDriver driver) {
		element = driver.findElement(By.xpath(properties.getProperty("getPersonalisedRatesSubmit.btn.xpath")));
		return element;
	}
	
	public static WebElement radioBtn_When1YearIsSelected(WebDriver driver) {
		element = driver.findElement(By.xpath(properties.getProperty("1YearTerm.selected.xpath")));
		return element;
	}
	
	public static WebElement radioBtn_When2YearIsSelected(WebDriver driver) {
		element = driver.findElement(By.xpath(properties.getProperty("2YearTerm.selected.xpath")));
		return element;
	}
	
	public static WebElement radioBtn_When3YearIsSelected(WebDriver driver) {
		element = driver.findElement(By.xpath(properties.getProperty("3YearTerm.selected.xpath")));
		return element;
	}
	
	public static WebElement radioBtn_When4YearIsSelected(WebDriver driver) {
		element = driver.findElement(By.xpath(properties.getProperty("4YearTerm.selected.xpath")));
		return element;
	}
	
	public static WebElement radioBtn_When5YearIsSelected(WebDriver driver) {
		element = driver.findElement(By.xpath(properties.getProperty("5YearTerm.selected.xpath")));
		return element;
	}
}
