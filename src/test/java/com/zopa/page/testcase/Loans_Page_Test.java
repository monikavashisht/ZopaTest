package com.zopa.page.testcase;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.zopa.base.Base_Test;
import com.zopa.pom.pageObjects.Loans_Page;

import junit.framework.Assert;

/*
 * Purpose:
 * This is a test case file for Loans Page whose POM file is : Loans_Page.java.
 * At the moment its covering below test cases:
 * 1. Verification of Slider + button and its click action.
 * 2. Verification of Slider - button and its click action.
 * 3. Verification of Loan Term Radio Button and its click action.
 * 
 * There is lot of room to improve its test coverage, but due to time constraints only three major functionality has been automated.
 */
public class Loans_Page_Test extends Base_Test {
	
	@BeforeClass
	public static void setup() throws InterruptedException {
		setupBrowser();
		getDriver().navigate().to(Loans_Page.URL);
		Thread.sleep(3000);//Adding delay as Loans page is taking lot of time to load completely in browser, because of favicon not delivered by server.
	}
	
	@Test
	public void verifySliderPlusButton() {
		Assert.assertEquals("+", Loans_Page.btn_LoanAmountPlusButton(getDriver()).getText());
		String loanAmountInTextBoxBeforePlusButtonClick = Loans_Page.txtbx_LoanAmount(getDriver()).getAttribute("value");
		Double loanAmountBeforePlusButtonClick = Double.parseDouble(loanAmountInTextBoxBeforePlusButtonClick);
		
		Loans_Page.btn_LoanAmountPlusButton(getDriver()).click();
		
		String loanAmountInTextBoxAfterPlusButtonClick = Loans_Page.txtbx_LoanAmount(getDriver()).getAttribute("value");
		Double loanAmountAfterPlusButtonClick = Double.parseDouble(loanAmountInTextBoxAfterPlusButtonClick);
		if (loanAmountBeforePlusButtonClick.compareTo(loanAmountAfterPlusButtonClick)>0){
			Assert.fail("Slider Plus button is not increasing the loan amount.");
		}
		System.out.println("TEST CASE EXECUTED:: verifySliderPlusButton()");
	}
	
	@Test
	public void verifySliderMinusButton() {
		Assert.assertEquals("-", Loans_Page.btn_LoanAmountMinusButton(getDriver()).getText());
		String loanAmountInTextBoxBeforePlusButtonClick = Loans_Page.txtbx_LoanAmount(getDriver()).getAttribute("value");
		Double loanAmountBeforePlusButtonClick = Double.parseDouble(loanAmountInTextBoxBeforePlusButtonClick);
		
		Loans_Page.btn_LoanAmountMinusButton(getDriver()).click();
		
		String loanAmountInTextBoxAfterPlusButtonClick = Loans_Page.txtbx_LoanAmount(getDriver()).getAttribute("value");
		Double loanAmountAfterPlusButtonClick = Double.parseDouble(loanAmountInTextBoxAfterPlusButtonClick);
		if (loanAmountBeforePlusButtonClick.compareTo(loanAmountAfterPlusButtonClick)<0){
			Assert.fail("Slider Plus button is not decreasing the loan amount.");
		}
		System.out.println("TEST CASE EXECUTED:: verifySliderMinusButton()");
	}
	
	@Test
	public void verifyLoanTermSelection(){
		Assert.assertEquals("1 year", Loans_Page.radioBtn_OneYearLoanTerm(getDriver()).getText().trim());
		Assert.assertEquals("2 years", Loans_Page.radioBtn_TwoYearLoanTerm(getDriver()).getText().trim());
		Assert.assertEquals("3 years", Loans_Page.radioBtn_ThreeYearLoanTerm(getDriver()).getText().trim());
		Assert.assertEquals("4 years", Loans_Page.radioBtn_FourYearLoanTerm(getDriver()).getText().trim());
		Assert.assertEquals("5 years", Loans_Page.radioBtn_FiveYearLoanTerm(getDriver()).getText().trim());
		Loans_Page.radioBtn_FourYearLoanTerm(getDriver()).click();
		Assert.assertEquals("selected",Loans_Page.radioBtn_When4YearIsSelected(getDriver()).getAttribute("class"));
		Loans_Page.radioBtn_OneYearLoanTerm(getDriver()).click();
		Assert.assertEquals("selected",Loans_Page.radioBtn_When1YearIsSelected(getDriver()).getAttribute("class"));
		Loans_Page.radioBtn_TwoYearLoanTerm(getDriver()).click();
		Assert.assertEquals("selected",Loans_Page.radioBtn_When2YearIsSelected(getDriver()).getAttribute("class"));
		Loans_Page.radioBtn_ThreeYearLoanTerm(getDriver()).click();
		Assert.assertEquals("selected",Loans_Page.radioBtn_When3YearIsSelected(getDriver()).getAttribute("class"));
		Loans_Page.radioBtn_FiveYearLoanTerm(getDriver()).click();
		Assert.assertEquals("selected",Loans_Page.radioBtn_When5YearIsSelected(getDriver()).getAttribute("class"));
		System.out.println("TEST CASE EXECUTED:: verifyLoanTermSelection()");
	}
	
	@AfterClass
	public static void destroy(){
		closeBrowser();
	}
}
