package com.zopa.pom.core.helpers;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.Proxy.ProxyType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.zopa.pom.core.constants.FrameworkParams;

/*
 * Purpose : 
 * 1. Create browser object and dispatch WebDriver associated with it.
 * 2. Close WebDriver gracefully.
 * 3. Manage three browsers : Firefox, Chrome and PhantomJS
 * 
 */
public class Browser {

	public WebDriver wbdv = null;
	public EventFiringWebDriver driver = null;

	private EventFiringWebDriver getDriver(String browserName, String proxyUrl) {
		if (wbdv == null) {
			if (browserName.equals(FrameworkParams.BROWSER_FIREFOX)) {
				FirefoxProfile profile = new FirefoxProfile();
				DesiredCapabilities capabilities = DesiredCapabilities.firefox();
				if (StringUtils.isNotBlank(proxyUrl)) {
					setProxyServerInBrowserCapabilities(capabilities, proxyUrl);
				}
				capabilities.setCapability(FirefoxDriver.PROFILE, profile);
				wbdv = new FirefoxDriver(capabilities);
				driver = new EventFiringWebDriver(wbdv);
				driver.manage().window();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			}
			if (browserName.equals(FrameworkParams.BROWSER_CHROME)) {
				if (StringUtils.isNotBlank(proxyUrl)) {
					DesiredCapabilities capabilities = DesiredCapabilities.chrome();
					setProxyServerInBrowserCapabilities(capabilities, proxyUrl);
					wbdv = new ChromeDriver(capabilities);
				} else {
					wbdv = new ChromeDriver();
				}
				
				driver = new EventFiringWebDriver(wbdv);
				driver.manage().window();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			}
			if (browserName.equals(FrameworkParams.BROWSER_HEADLESS)) {
				DesiredCapabilities capabilities = DesiredCapabilities.phantomjs();
				if (StringUtils.isNotBlank(proxyUrl)) {
					setProxyServerInBrowserCapabilities(capabilities, proxyUrl);
				}
				capabilities.setCapability("phantomjs.binary.path", System.getProperty(FrameworkParams.PATH_PHANTOMJS_DRIVER));
				capabilities.setJavascriptEnabled(true);
				wbdv = new PhantomJSDriver(capabilities);
				driver = new EventFiringWebDriver(wbdv);
				driver.manage().window();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			}
		}

		return driver;
	}

	private void setProxyServerInBrowserCapabilities(DesiredCapabilities capabilities, String proxyUrl) {
		Proxy proxy = new Proxy();
		proxy.setProxyType(ProxyType.MANUAL);
		proxy.setHttpProxy(proxyUrl);
		proxy.setSslProxy(proxyUrl);
		capabilities.setCapability(CapabilityType.PROXY, proxy);
	}

	public WebDriver getWebDriver() {
		return wbdv;
	}

	public void resetWebDriver() {
		if (wbdv != null && driver != null) {
			this.close(FrameworkParams.BROWSER_FIREFOX);
			this.close(FrameworkParams.BROWSER_CHROME);
			this.close(FrameworkParams.BROWSER_HEADLESS);
		}
		driver = null;
		wbdv = null;
	}

	private void close(String browserName) {
		if (browserName.equals(FrameworkParams.BROWSER_FIREFOX)) {
			driver.quit();
		}
		if (browserName.equals(FrameworkParams.BROWSER_CHROME)) {
			driver.close();
			wbdv.quit();
		}
		if (browserName.equals(FrameworkParams.BROWSER_HEADLESS)){
			driver.close();
			wbdv.quit();
		}
	}
	
	public void closeChromeBrowser(){
		this.close(FrameworkParams.BROWSER_CHROME);
	}
	
	public void closeFirefoxBrowser(){
		this.close(FrameworkParams.BROWSER_FIREFOX);
	}
	
	public void closePhantomJSBrowser(){
		this.close(FrameworkParams.BROWSER_HEADLESS);
	}
	
	public EventFiringWebDriver getChromeDriver(){
		return this.getDriver(FrameworkParams.BROWSER_CHROME, null);
	}
	public EventFiringWebDriver getFireFoxDriver(){
		return this.getDriver(FrameworkParams.BROWSER_FIREFOX, null);
	}
	public EventFiringWebDriver getPhantomJSDriver(){
		return this.getDriver(FrameworkParams.BROWSER_HEADLESS, null);
	}

}
