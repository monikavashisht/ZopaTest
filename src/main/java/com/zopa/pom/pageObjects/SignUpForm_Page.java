package com.zopa.pom.pageObjects;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zopa.pom.core.helpers.PagePropertyFile;

/*
 * Purpose:
 * 1. Page Object Model Class of Signup Forms Page.
 * 2. Static reference of properties object, make sure that SignUpForm_Page.properties file gets loaded as soon as this class is loaded.
 * 3. Responsible for dispatching WebElements associated with this page.
 */
public class SignUpForm_Page {
	public static final String URL = "https://secure2.zopa.com/members/sign_up/borrower?amount=10000&term=60&zp_source=referrer-organic";
	private static WebElement element = null;
	public static Properties properties = null;
	static {
		properties = PagePropertyFile.readProperties(SignUpForm_Page.class);
	}
	
	public static WebElement txtBx_Email(WebDriver driver) {
		element = driver.findElement(By.xpath(properties.getProperty("email.textbox.xpath")));
		return element;
	}
	
	public static WebElement txtBx_EmailErrorCheckElement(WebDriver driver) {
		element = driver.findElement(By.xpath(properties.getProperty("email.errorcheckelement.xpath")));
		return element;
	}
	
	public static WebElement radioBtn_Mr(WebDriver driver) {
		element = driver.findElement(By.xpath(properties.getProperty("mr.radioBtn.xpath")));
		return element;
	}
	
	public static WebElement radioBtn_Ms(WebDriver driver) {
		element = driver.findElement(By.xpath(properties.getProperty("ms.radioBtn.xpath")));
		return element;
	}
	
	public static WebElement radioBtn_Miss(WebDriver driver) {
		element = driver.findElement(By.xpath(properties.getProperty("miss.radioBtn.xpath")));
		return element;
	}
	
	public static WebElement radioBtn_Mrs(WebDriver driver) {
		element = driver.findElement(By.xpath(properties.getProperty("mrs.radioBtn.xpath")));
		return element;
	}
	
	public static WebElement txtbox_firstname(WebDriver driver) {
		element = driver.findElement(By.xpath(properties.getProperty("firstname.textbox.xpath")));
		return element;
	}
	public static WebElement txtbox_lastname(WebDriver driver) {
		element = driver.findElement(By.xpath(properties.getProperty("lastname.textbox.xpath")));
		return element;
	}
	public static WebElement txtbox_phoneNumber(WebDriver driver) {
		element = driver.findElement(By.xpath(properties.getProperty("phonenumber.textbox.xpath")));
		return element;
	}
	public static WebElement txtbox_dateOfDOB(WebDriver driver) {
		element = driver.findElement(By.xpath(properties.getProperty("date.dateofbirth.textbox.xpath")));
		return element;
	}
	public static WebElement txtbox_monthOfDOB(WebDriver driver) {
		element = driver.findElement(By.xpath(properties.getProperty("month.dateofbirth.textbox.xpath")));
		return element;
	}
	public static WebElement txtbox_yearOfDOB(WebDriver driver) {
		element = driver.findElement(By.xpath(properties.getProperty("year.dateofbirth.textbox.xpath")));
		return element;
	}
	
	public static WebElement radioBtn_loanReasonCar(WebDriver driver) {
		element = driver.findElement(By.xpath(properties.getProperty("loanreason.car.radioBtn.xpath")));
		return element;
	}
	public static WebElement radioBtn_loanReasonHomeImprovements(WebDriver driver) {
		element = driver.findElement(By.xpath(properties.getProperty("loanreason.homeImprovements.radioBtn.xpath")));
		return element;
	}
	public static WebElement radioBtn_loanReasonDebtConsolidate(WebDriver driver) {
		element = driver.findElement(By.xpath(properties.getProperty("loanreason.debtConsolidation.radioBtn.xpath")));
		return element;
	}
	
	public static WebElement txtbox_postcode(WebDriver driver) {
		element = driver.findElement(By.xpath(properties.getProperty("postcode.textbox.xpath")));
		return element;
	}
	public static WebElement btn_lookupAddress(WebDriver driver) {
		element = driver.findElement(By.xpath(properties.getProperty("lookupAddress.btn.xpath")));
		return element;
	}
	public static WebElement lbl_errorPostcodeElement(WebDriver driver) {
		element = driver.findElement(By.xpath(properties.getProperty("errorPostcode.lbl.xpath")));
		return element;
	}
	public static WebElement lbl_validPostcodeElement(WebDriver driver) {
		element = driver.findElement(By.xpath(properties.getProperty("validPostcode.lbl.xpath")));
		return element;
	}
	
	public static WebElement radioBtn_employmentStatusFullTime(WebDriver driver) {
		element = driver.findElement(By.xpath(properties.getProperty("employmentStatus.fulltime.radioBtn.xpath")));
		return element;
	}
	public static WebElement radioBtn_employmentStatusSelfEmployed(WebDriver driver) {
		element = driver.findElement(By.xpath(properties.getProperty("employmentStatus.selfemployed.radioBtn.xpath")));
		return element;
	}
	public static WebElement radioBtn_employmentStatusDirector(WebDriver driver) {
		element = driver.findElement(By.xpath(properties.getProperty("employmentStatus.director.radioBtn.xpath")));
		return element;
	}
	public static WebElement radioBtn_employmentStatusPartTime(WebDriver driver) {
		element = driver.findElement(By.xpath(properties.getProperty("employmentStatus.parttime.radioBtn.xpath")));
		return element;
	}
	public static WebElement radioBtn_employmentStatusUnEmployed(WebDriver driver) {
		element = driver.findElement(By.xpath(properties.getProperty("employmentStatus.unemployed.radioBtn.xpath")));
		return element;
	}
	public static WebElement radioBtn_employmentStatusRetired(WebDriver driver) {
		element = driver.findElement(By.xpath(properties.getProperty("employmentStatus.retired.radioBtn.xpath")));
		return element;
	}
	public static WebElement radioBtn_employmentStatusHomeMaker(WebDriver driver) {
		element = driver.findElement(By.xpath(properties.getProperty("employmentStatus.homemaker.radioBtn.xpath")));
		return element;
	}
	
	public static WebElement txtbox_AnnualIncomeBeforeTax(WebDriver driver) {
		element = driver.findElement(By.xpath(properties.getProperty("annualIncomeBeforeTax.textbox.xpath")));
		return element;
	}
	
	public static WebElement radioBtn_HomeOwnershipOutrightOwner(WebDriver driver) {
		element = driver.findElement(By.xpath(properties.getProperty("homeOwnership.outrightowner.radioBtn.xpath")));
		return element;
	}
	public static WebElement radioBtn_HomeOwnershipMortgage(WebDriver driver) {
		element = driver.findElement(By.xpath(properties.getProperty("homeOwnership.mortgage.radioBtn.xpath")));
		return element;
	}
	public static WebElement radioBtn_HomeOwnershipNo(WebDriver driver) {
		element = driver.findElement(By.xpath(properties.getProperty("homeOwnership.no.radioBtn.xpath")));
		return element;
	}
	
	public static WebElement txtbox_MonthlyContributionRentOrMortgage(WebDriver driver) {
		element = driver.findElement(By.xpath(properties.getProperty("monthlyContribution.mortgageOrRent.textbox.xpath")));
		return element;
	}
	
	public static WebElement txtbox_Password(WebDriver driver) {
		element = driver.findElement(By.xpath(properties.getProperty("password.textbox.xpath")));
		return element;
	}
	
	public static WebElement chkbox_ShowPassword(WebDriver driver) {
		element = driver.findElement(By.xpath(properties.getProperty("showPassword.chkbox.xpath")));
		return element;
	}
	
	public static WebElement btnSubmit_CalculateMyRates(WebDriver driver) {
		element = driver.findElement(By.xpath(properties.getProperty("calculateMyRates.btnSubmit.xpath")));
		return element;
	}
}
