package com.zopa.userjournies.testcase;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.zopa.base.Base_Test;
import com.zopa.pom.core.helpers.DataFileLoader;
import com.zopa.pom.pageObjects.Home_Page;
import com.zopa.pom.pageObjects.Loans_Page;
import com.zopa.pom.pageObjects.SignUpForm_Page;

import junit.framework.Assert;

/*
 * Purpose:
 * This test case file covers the user journey from Home Page to Signup form application page.
 * Home page events:
 * 1. Only presene of "Get a Zopa loan" button has been checked and same has been clicked.
 * 
 * Loans Page events:
 * 1. Loan amount has been setup using + slider button.
 * 2. Loan term has been setup to 4 years at the moment. But both of these settings can be controlled by a Data file. Because of time constraints I am not implementing those functionalities.
 * 3. Get Personalised rates button is clicked to render Signup form.
 * 
 * Signup Form Page:
 * 1. Firstly form data is loaded from a text file called as "full_form_data.txt".
 * 2. Each line of "full_form_data.txt" file contains a json string which has value for each and every field of form. This mechanism help up filling up form with lots of valid and invalid scenarios.
 * 3. JSON Form values are filled in Signup Form Page using Selenium Web Driver.
 * 
 * Due to time constraints I am not putting any assertion statements to validate form status after filling up field values from Data File.
 * 
 */
public class LoanApplication_Test extends Base_Test {
	
	@BeforeClass
	public static void setup() {
		setupBrowser();
	}
	
	@Test
	public void gotoFormPageWith4YearTerm() throws InterruptedException {
		getDriver().navigate().to(Home_Page.URL);
		Assert.assertEquals("Get a Zopa loan", Home_Page.btn_GetZopaLoan(getDriver()).getText());
		Thread.sleep(1000);
		Home_Page.btn_GetZopaLoan(getDriver()).click();
		Thread.sleep(1000);
		Loans_Page.btn_LoanAmountPlusButton(getDriver()).click();
		Thread.sleep(1000);
		Loans_Page.radioBtn_FourYearLoanTerm(getDriver()).click();
		Thread.sleep(1000);
		Assert.assertEquals("selected",Loans_Page.radioBtn_When4YearIsSelected(getDriver()).getAttribute("class"));
		Loans_Page.submitBtn_GetPersonalisedRates(getDriver()).click();
	}

	@Test
	public void fillFormWithData() throws JSONException{
		List<String> listOfFormData = DataFileLoader.readData(SignUpForm_Page.class, "full_form_data.txt");//Reading form Data from a text file.
		for (String formData: listOfFormData){
			JSONObject formObj = new JSONObject(formData);
			SignUpForm_Page.txtBx_Email(getDriver()).sendKeys(RandomStringUtils.randomAlphanumeric(5).toUpperCase()+formObj.getString("email"));
			if (formObj.getString("title").equalsIgnoreCase("Mr")){
				SignUpForm_Page.radioBtn_Mr(getDriver()).click();
			}
			if (formObj.getString("title").equalsIgnoreCase("Mrs")){
				SignUpForm_Page.radioBtn_Mrs(getDriver()).click();
			}
			if (formObj.getString("title").equalsIgnoreCase("Ms")){
				SignUpForm_Page.radioBtn_Ms(getDriver()).click();
			}
			if (formObj.getString("title").equalsIgnoreCase("Miss")){
				SignUpForm_Page.radioBtn_Miss(getDriver()).click();
			}
			SignUpForm_Page.txtbox_firstname(getDriver()).sendKeys(formObj.getString("firstname"));
			SignUpForm_Page.txtbox_lastname(getDriver()).sendKeys(formObj.getString("lastname"));
			SignUpForm_Page.txtbox_phoneNumber(getDriver()).sendKeys(formObj.getString("phonenumber"));
			SignUpForm_Page.txtbox_dateOfDOB(getDriver()).sendKeys(formObj.getString("dateOfDOB"));
			SignUpForm_Page.txtbox_monthOfDOB(getDriver()).sendKeys(formObj.getString("monthOfDOB"));
			SignUpForm_Page.txtbox_yearOfDOB(getDriver()).sendKeys(formObj.getString("yearOfDOB"));
			if (formObj.getString("loanReason").equalsIgnoreCase("Car")){
				SignUpForm_Page.radioBtn_loanReasonCar(getDriver()).click();
			}
			if (formObj.getString("loanReason").equalsIgnoreCase("Home improvements")){
				SignUpForm_Page.radioBtn_loanReasonHomeImprovements(getDriver()).click();
			}
			if (formObj.getString("loanReason").equalsIgnoreCase("Debt consolidation")){
				SignUpForm_Page.radioBtn_loanReasonDebtConsolidate(getDriver()).click();
			}
			SignUpForm_Page.txtbox_postcode(getDriver()).sendKeys(formObj.getString("postcode"));
			SignUpForm_Page.btn_lookupAddress(getDriver()).click();
			
			//And so on for all fields..... which can further be extended with lots of assert statements to finish validation.
			getDriver().navigate().to(SignUpForm_Page.URL);
		}
	}
	
	@AfterClass
	public static void destroy(){
		closeBrowser();
	}
}
