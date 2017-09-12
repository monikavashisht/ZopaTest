package com.zopa.page.testcase;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.zopa.base.Base_Test;
import com.zopa.pom.pageObjects.Home_Page;

import junit.framework.Assert;

/*
 * Purpose:
 * This is a test case file for Home Page whose POM file is : Home_Page.java.
 * At the moment its only covering the presence of "Get a Zopa Loan" button and just clicks on it.
 * This file at the moment is not covering all the test cases asscociated with this page.
 */
public class Home_Page_Test extends Base_Test{
	
	@BeforeClass
	public static void setup() {
		setupBrowser();
		getDriver().navigate().to(Home_Page.URL);
	}
	
	@Test
	public void clickAndVerifyGetZopLoanButton() {
		Assert.assertEquals("Get a Zopa loan", Home_Page.btn_GetZopaLoan(getDriver()).getText());
		Home_Page.btn_GetZopaLoan(getDriver()).click();
		System.out.println("TEST CASE EXECUTED:: clickAndVerifyGetZopLoanButton()");
	}
	
	@AfterClass
	public static void destroy(){
		closeBrowser();
	}

}
