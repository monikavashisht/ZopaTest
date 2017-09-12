package com.zopa.page.testcase;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.zopa.base.Base_Test;
import com.zopa.pom.core.helpers.DataFileLoader;
import com.zopa.pom.pageObjects.SignUpForm_Page;

import junit.framework.Assert;

/*
 * Purpose:
 * This is a test case file for Signup Forms Page whose POM file is : SignUpForm_Page.java.
 * At the moment its covering below test cases:
 * 1. Check the presence of all form fields on the page.
 * 2. Validation associated with email text field. At the moment, using the random string generator has been used to test its javascript error status. But there is lot of room to improve its validation which will include server side validation as well. But due to time constraints, only this much I am implementing.
 * 3. Validation of postcode lookup field. At the moment, I have created two files which contains valid and invalid list of postcodes inside them. Test simply loads all postcodes one by one and validate whether its valid or not.
 * 
 * There is lot of room to improve its test coverage, but due to time constraints only three major functionality has been automated.
 */
public class SignUpForm_Page_Test extends Base_Test {

	@BeforeClass
	public static void setup() {
		setupBrowser();
		getDriver().navigate().to(SignUpForm_Page.URL);
	}
	
	@Test
	public void checkFormFieldPresence(){
		Assert.assertEquals("ZA.email",SignUpForm_Page.txtBx_Email(getDriver()).getAttribute("data-automation"));
		Assert.assertEquals("Mr",SignUpForm_Page.radioBtn_Mr(getDriver()).getText());
		Assert.assertEquals("Ms",SignUpForm_Page.radioBtn_Ms(getDriver()).getText());
		Assert.assertEquals("Miss",SignUpForm_Page.radioBtn_Miss(getDriver()).getText());
		Assert.assertEquals("Mrs",SignUpForm_Page.radioBtn_Mrs(getDriver()).getText());
		Assert.assertEquals("ZA.first_name",SignUpForm_Page.txtbox_firstname(getDriver()).getAttribute("data-automation"));
		Assert.assertEquals("ZA.last_name",SignUpForm_Page.txtbox_lastname(getDriver()).getAttribute("data-automation"));
		Assert.assertEquals("ZA.home_phone",SignUpForm_Page.txtbox_phoneNumber(getDriver()).getAttribute("data-automation"));
		Assert.assertEquals("ZA.date_of_birth_day",SignUpForm_Page.txtbox_dateOfDOB(getDriver()).getAttribute("data-automation"));
		Assert.assertEquals("ZA.date_of_birth_year",SignUpForm_Page.txtbox_yearOfDOB(getDriver()).getAttribute("data-automation"));
		Assert.assertEquals("ZA.date_of_birth_month",SignUpForm_Page.txtbox_monthOfDOB(getDriver()).getAttribute("data-automation"));
		Assert.assertEquals("Car",SignUpForm_Page.radioBtn_loanReasonCar(getDriver()).getText());
		Assert.assertEquals("Home improvements",SignUpForm_Page.radioBtn_loanReasonHomeImprovements(getDriver()).getText());
		Assert.assertEquals("Debt consolidation",SignUpForm_Page.radioBtn_loanReasonDebtConsolidate(getDriver()).getText());
		Assert.assertEquals("ZA.postcode",SignUpForm_Page.txtbox_postcode(getDriver()).getAttribute("data-automation"));
		Assert.assertEquals("Look up address",SignUpForm_Page.btn_lookupAddress(getDriver()).getAttribute("value"));
		Assert.assertEquals("Employed full-time",SignUpForm_Page.radioBtn_employmentStatusFullTime(getDriver()).getText());
		Assert.assertEquals("Self employed",SignUpForm_Page.radioBtn_employmentStatusSelfEmployed(getDriver()).getText());
		Assert.assertEquals("Director of a limited company",SignUpForm_Page.radioBtn_employmentStatusDirector(getDriver()).getText());
		Assert.assertEquals("Employed part-time",SignUpForm_Page.radioBtn_employmentStatusPartTime(getDriver()).getText());
		Assert.assertEquals("Currently unemployed",SignUpForm_Page.radioBtn_employmentStatusUnEmployed(getDriver()).getText());
		Assert.assertEquals("Retired, not working",SignUpForm_Page.radioBtn_employmentStatusRetired(getDriver()).getText());
		Assert.assertEquals("Housewife, househusband or homemaker",SignUpForm_Page.radioBtn_employmentStatusHomeMaker(getDriver()).getText());
		Assert.assertEquals("ZA.salary",SignUpForm_Page.txtbox_AnnualIncomeBeforeTax(getDriver()).getAttribute("data-automation"));
		Assert.assertEquals("Yes, outright owner",SignUpForm_Page.radioBtn_HomeOwnershipOutrightOwner(getDriver()).getText());
		Assert.assertEquals("Yes, with a mortgage",SignUpForm_Page.radioBtn_HomeOwnershipMortgage(getDriver()).getText());
		Assert.assertEquals("No",SignUpForm_Page.radioBtn_HomeOwnershipNo(getDriver()).getText());
		Assert.assertEquals("ZA.rent",SignUpForm_Page.txtbox_MonthlyContributionRentOrMortgage(getDriver()).getAttribute("data-automation"));
		Assert.assertEquals("ZA.password",SignUpForm_Page.txtbox_Password(getDriver()).getAttribute("data-automation"));
		Assert.assertEquals("Show password",SignUpForm_Page.chkbox_ShowPassword(getDriver()).getText());
		System.out.println("TEST CASE EXECUTED:: checkFormFieldPresence()");
	}
	
	@Test
	public void validationOnEmailTextField() throws InterruptedException{
		String invalidEmailAddress = RandomStringUtils.randomAlphanumeric(17).toUpperCase();
		System.out.println("invalidEmailAddress="+invalidEmailAddress);
		SignUpForm_Page.txtBx_Email(getDriver()).sendKeys(invalidEmailAddress);
		Thread.sleep(1000);//wait has been added as Javascript is taking time to reflect error class on parent paragraph tag.
		Assert.assertEquals("error",SignUpForm_Page.txtBx_EmailErrorCheckElement(getDriver()).getAttribute("class"));
		
		String invalidEmailAddress2 = invalidEmailAddress+"@"+RandomStringUtils.randomAlphanumeric(17).toUpperCase();
		System.out.println("invalidEmailAddress2="+invalidEmailAddress2);
		SignUpForm_Page.txtBx_Email(getDriver()).clear();
		SignUpForm_Page.txtBx_Email(getDriver()).sendKeys(invalidEmailAddress2);
		Thread.sleep(1000);//wait has been added as Javascript is taking time to reflect error class on parent paragraph tag.
		Assert.assertEquals("error",SignUpForm_Page.txtBx_EmailErrorCheckElement(getDriver()).getAttribute("class"));
		
		String validEmailAddress = invalidEmailAddress+"@"+RandomStringUtils.randomAlphanumeric(17).toUpperCase()+".COM";
		System.out.println("validEmailAddress="+validEmailAddress);
		SignUpForm_Page.txtBx_Email(getDriver()).clear();
		SignUpForm_Page.txtBx_Email(getDriver()).sendKeys(validEmailAddress);
		Thread.sleep(1000);//wait has been added as Javascript is taking time to reflect error class on parent paragraph tag.
		Assert.assertEquals("",SignUpForm_Page.txtBx_EmailErrorCheckElement(getDriver()).getAttribute("class"));
		System.out.println("TEST CASE EXECUTED:: validationOnEmailTextField()");
	}
	
	@Test
	public void validationOnPostcodeLookupField() throws InterruptedException{
		List<String> invalidPostcodesList = DataFileLoader.readData(SignUpForm_Page.class, "invalid_postcodes.txt");//Reading Invalid postcodes from a text file.
		for(String invalidPostcode : invalidPostcodesList){
			getDriver().navigate().to(SignUpForm_Page.URL);
			SignUpForm_Page.txtbox_postcode(getDriver()).sendKeys(invalidPostcode);
			SignUpForm_Page.btn_lookupAddress(getDriver()).click();
			Assert.assertEquals("We can't find this address, please try again", SignUpForm_Page.lbl_errorPostcodeElement(getDriver()).getText());
		}
		getDriver().navigate().to(SignUpForm_Page.URL);
		Thread.sleep(1000);
		List<String> validPostcodesList = DataFileLoader.readData(SignUpForm_Page.class, "valid_postcodes.txt");//Reading valid postcodes from a text file.
		for(String validPostcode : validPostcodesList){
			getDriver().navigate().to(SignUpForm_Page.URL);
			SignUpForm_Page.txtbox_postcode(getDriver()).sendKeys(validPostcode);
			SignUpForm_Page.btn_lookupAddress(getDriver()).click();
			String sizePossibleAddress = SignUpForm_Page.lbl_validPostcodeElement(getDriver()).getAttribute("size");
			int totalAddresses = Integer.parseInt(sizePossibleAddress);
			if (totalAddresses<=0){
				Assert.fail("validationOnPostcodeLookupField():: Valid Postcode failed in automation testing in Address Loopup functionality.");
			}
		}
		System.out.println("TEST CASE EXECUTED:: validationOnPostcodeLookupField()");
	}
	
	@AfterClass
	public static void destroy(){
		closeBrowser();
	}
	
}
