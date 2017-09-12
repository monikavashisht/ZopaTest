package com.zopa;

import org.junit.Test;

import com.zopa.pom.core.constants.FrameworkParams;
import com.zopa.pom.core.helpers.Browser;
import com.zopa.pom.core.helpers.Setup;

import junit.framework.Assert;

/*
 * Purpose:
 * This file has been created to test whether all three browsers (Firefox, Chrome and PhantomJS) are working fine on a system or not.
 */
public class FrameworkHealthCheckup {
	
	private static final String homePageTitle = "Simple loans & smart investments | Zopa.com";

	@Test
	public void testChromeBrowserStatus() {
		Setup.getInstance().browserLibrary(FrameworkParams.BROWSER_CHROME, FrameworkParams.OS_MACOSX_10_12_1);
		Browser browser = new Browser();
		browser.getChromeDriver().navigate().to("http://www.zopa.com/");
		Assert.assertEquals(homePageTitle, browser.getChromeDriver().getTitle());
		browser.closeChromeBrowser();
	}
	
	@Test
	public void testPhantomJSBrowserStatus() {
		Setup.getInstance().browserLibrary(FrameworkParams.BROWSER_HEADLESS, FrameworkParams.OS_MACOSX_10_12_1);
		Browser browser = new Browser();
		browser.getPhantomJSDriver().navigate().to("http://www.zopa.com/");
		Assert.assertEquals(homePageTitle, browser.getChromeDriver().getTitle());
		browser.closePhantomJSBrowser();
	}
	
	@Test
	public void testFirefoxBrowserStatus() {
		Setup.getInstance().browserLibrary(FrameworkParams.BROWSER_FIREFOX, FrameworkParams.OS_MACOSX_10_12_1);
		Browser browser = new Browser();
		browser.getFireFoxDriver().navigate().to("http://www.zopa.com/");
		Assert.assertEquals(homePageTitle, browser.getChromeDriver().getTitle());
		browser.closeFirefoxBrowser();
	}

}
