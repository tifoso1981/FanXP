package com.pjd.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	

	public Properties prop;
	public static boolean highlightElement;
	public OptionsManager optionsManager;

	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();

	public static synchronized WebDriver getDriver() {
		return tldriver.get();
	}
	
	/**
	 * This method is used to initialize the browser on the basis of given browser
	 * @param browser
	 * @return it returns webdriver driver
	 */

	public WebDriver init_driver(Properties prop) {
		String browserName = prop.getProperty("browser");
		highlightElement = prop.getProperty("highlight").equals("yes") ? true : false;
		System.out.println("Browser Launched:" + " " + browserName);
		optionsManager = new OptionsManager(prop);

// public WebDriver init_driver(String browserName) {
// highlightElement = prop.getProperty("highlight").equals("yes") ? true : false;
// System.out.println("Browser Launched:" + " " + browserName); 
// optionsManager = new OptionsManager(prop); 

		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tldriver.set(new ChromeDriver(optionsManager.getChromeOptions()));

		} else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tldriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));

		} else if (browserName.equals("internetexplorer")) {
			WebDriverManager.iedriver().setup();
			tldriver.set(new InternetExplorerDriver(optionsManager.io));
		} else {
			System.out.println("Browser name" + " " + browserName + "is not found");
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();

		return getDriver();
	}

	public Properties init_properties() {
		prop = new Properties();
		String path = null;
		String env = null;

		try {
			env = System.getProperty("env");

			if (env.equals("qa")) {
				path = "./src/main/java/com/pjd/qa/config/config.properties";
			} else if (env.equals("dev")) {
				path = "./src/main/java/com/pjd/qa/config/config.properties";
			} else if (env.equals("demo")) {
				path = "./src/main/java/com/pjd/qa/config/config.properties";
			}

		} catch (Exception e) {
			path = "./src/main/java/com/pjd/qa/config/config.properties";
		}
		try {
			FileInputStream ip = new FileInputStream(path);
			prop.load(ip);

		} catch (FileNotFoundException e) {
			System.out.println("Configuration Propoeries Issue... correct config.properties file");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

	public String getScreenshot() {
		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			System.out.println("screenshot captured failed...");
		}
		return path;
	}

}

