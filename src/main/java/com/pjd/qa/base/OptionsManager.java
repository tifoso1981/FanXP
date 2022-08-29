package com.pjd.qa.base;

import java.util.Properties;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class OptionsManager {

	public ChromeOptions co;
	public FirefoxOptions fo;
	public InternetExplorerOptions io;
	public Properties prop;

	public OptionsManager(Properties prop) {
		this.prop = prop;
	}

	public ChromeOptions getChromeOptions() {
		co = new ChromeOptions();
		co.setPageLoadStrategy(PageLoadStrategy.NONE);
		if (prop.getProperty("headless").equals("yes"))
			co.addArguments("--headless");
		if (prop.getProperty("incognito").equals("yes"))
			co.addArguments("--incognito");
		return co;
	}

	public FirefoxOptions getFirefoxOptions() {
		fo = new FirefoxOptions();
		fo.setPageLoadStrategy(PageLoadStrategy.NONE);
		if (prop.getProperty("headless").equals("yes"))
			fo.addArguments("--headless");
		return fo;
	}

	public InternetExplorerOptions getInternetExplorerOptions() {
		io = new InternetExplorerOptions();
		io.setPageLoadStrategy(PageLoadStrategy.NONE);
		if (prop.getProperty("incognito").equals("yes"))
			io.addCommandSwitches("--incognito");
		return io;
	}
}
