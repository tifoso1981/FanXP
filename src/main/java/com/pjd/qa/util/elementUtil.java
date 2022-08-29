package com.pjd.qa.util;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.pjd.qa.base.BasePage;

public class elementUtil extends BasePage {

	WebDriver driver;
	WebDriverWait wait;
	JavaScriptUtil jsUtil;
	Properties prop;

	public elementUtil(WebDriver driver) {
		prop = super.prop;
		this.driver = driver;
		wait = new WebDriverWait(driver, AppConstants.DEFAULT_TIME_OUT);
		jsUtil = new JavaScriptUtil(driver);
	}
	
	
//	public void downloadFile() throws InterruptedException, IOException {
//		String path = "./FILES";
//		folder = new File(path);
//		folder.mkdir();
//		Map<String, Object> prefs = new HashMap<String, Object>();
//		prefs.put("download.default_directory",
//				System.getProperty("user.dir") + File.separator + "externalFiles" + File.separator + "downloadFiles");
//		ChromeOptions options = new ChromeOptions();
//		options.setExperimentalOption("prefs", prefs);
//		driver = new ChromeDriver(options);
//		driver.get("https://rad.dev.gao.gov");
//	}

	// Method for dynamically changing web tables.(tbody)
	public List<WebElement> getValueOptions(By locator) {
		WebElement htmltable = driver.findElement(locator);
		List<WebElement> rows = htmltable.findElements(By.tagName("tr"));

		for (int rnum = 0; rnum < rows.size(); rnum++) {
			List<WebElement> columns = rows.get(rnum).findElements(By.tagName("td"));
			// System.out.println("Number of columns:" + columns.size());

			for (int cnum = 0; cnum < columns.size(); cnum++) {
				System.out.println(columns.get(cnum).getText());
			}
		}
		return rows;
	}

	public List<WebElement> getUsersList(By locator) {
		List<WebElement> sidenav = driver.findElements(locator);
		for (int k = 0; k < sidenav.size(); k++) {
			String sidenavtext = sidenav.get(k).getText();
			System.out.println(sidenavtext);
		}
		return sidenav;
	}

	public void ElementTime() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public void switchToAlert() throws InterruptedException {
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		Thread.sleep(3000);
		alert.accept();
	}

	public static String PasswordFieldSetup() {
		Date curDate = new Date();
		SimpleDateFormat format = new SimpleDateFormat("MMdd");
		String DateToString = format.format(curDate);
		return DateToString;
	}

	public String enterTodaysDate_plus(int amount) {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Calendar now = Calendar.getInstance();
		now.add(Calendar.DATE, amount);
		String firstDate = dateFormat.format(now.getTime());
		return firstDate;
	}

	public boolean waitForFrameToBeAvailable(int index) {
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
		return true;
	}

	public boolean waitForElementVisible(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return true;
	}

	public void switchToFrame(int index) {
		driver.switchTo().frame(index);
	}

	public void toFrame(String frameName) {
		driver.switchTo().frame(frameName);
	}

	public void SwitchToFrame(int index) {
		try {
			driver.switchTo().frame(index);
		} catch (Exception e) {
			System.out.println("Exception occured.....");
		}
	}

	public List<WebElement> getTableText(By locator) {

		List<WebElement> allrows = driver.findElements(locator);
		for (WebElement row : allrows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			for (WebElement cell : cells) {
				System.out.println(cell.getText());
			}
		}
		return allrows;
	}

	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}

	public boolean isElementSelected(By locator) {
		try {
			return getElement(locator).isSelected();

		} catch (Exception e) {
			System.out.println("Exception occured....");
			System.out.println(e.getMessage());
		}
		return false;
	}

	public boolean isEnabled(By locator) {
		try {
			return getElement(locator).isEnabled();

		} catch (Exception e) {
			System.out.println("Exception occured....");
			System.out.println(e.getMessage());
		}
		return false;
	}

	public void doSendKeys(By locator, String value) {
		try {
			WebElement ele = getElement(locator);
			ele.clear();
			ele.sendKeys(value);
		} catch (Exception e) {
			System.out.println("Exception error...");
			System.out.println(e.getMessage());
		}
	}

	public String getValuesInTextFields(By locator) {
		WebElement element = getElement(locator);
		String ele = element.getAttribute("value");
		return ele;
	}

	public String getValuesResult(By locator) {
		WebElement element = getElement(locator);
		String ele = element.getText();
		return ele;
	}

	public boolean validateValueIsEmpty(By locator) {
		WebElement element = getElement(locator);
		element.getText().isEmpty();
		return true;
	}

	public void doClear(By locator) {
		try {
			WebElement ele = getElement(locator);
			ele.clear();
		} catch (Exception e) {
			System.out.println("Exception error...");
		}
	}

	public String[] getAwardListAvailable(By locator) {
		List<WebElement> AwardList = driver.findElements(locator);
		String[] AvailableList = new String[AwardList.size()];
		int j = 7;
		for (WebElement list : AwardList) {
			AvailableList[j] = list.getText();
			j++;
		}
		return AvailableList;
	}

	public List<WebElement> getList(By locator) {
		List<WebElement> sidenav = driver.findElements(locator);
		for (int k = 0; k < sidenav.size(); k++) {
			String text = sidenav.get(k).getText();
			System.out.println(text);
		}
		return sidenav;
	}

	public void getAmountOf_Notes_2000(By locator, String value) {
		String expected = value;
		WebElement elem = driver.findElement(locator);
		elem.sendKeys(expected);
		int size = expected.length();
		if (size == 2000) {
			System.out.println("______Maximum count of 2000 reached, special charactes are acceptable.");
		} else {
			System.out.println("no limit");
		}
	}

	public void getResultsMatch(String[] value, By locator) {
		String[] expected = value;
		List<WebElement> allOptions = driver.findElements(locator);
		if (expected.length != allOptions.size()) {
		}
		for (int i = 0; i < expected.length; i++) {
			String optionValue = allOptions.get(i).getText();
			if (optionValue.equals(expected[i])) {
				// System.out.println(optionValue);
			} else {
				System.out.println("FAILED: Results don't match expected vs actual");
			}
		}
	}
	

	public void getNominationList_CG_UserIndividual(By locator, String[] value) {
		String[] expected = value;
		List<WebElement> allOptions = driver.findElements(locator);
		if (expected.length != allOptions.size()) {
			System.out.println("______PASS: List of actual Award Categories listed as expected");
		}
		for (int i = 0; i < expected.length; i++) {
			String optionValue = allOptions.get(i).getText();
			if (optionValue.equals(expected[i])) {
				System.out.println(optionValue);
			} else {
				System.out.println("FAIL");
			}
		}
	}


	public void clickOnTheElementUsingActions(By locator) throws InterruptedException {
		WebElement ele = driver.findElement(locator);
		Actions action = new Actions(driver);
		Thread.sleep(3000);
		action.moveToElement(ele).click().build().perform();
	}

	public void doubleClickOnTheElementUsingActions(By locator) throws InterruptedException {
		WebElement ele = driver.findElement(locator);
		Actions action = new Actions(driver);
		Thread.sleep(3000);
		action.doubleClick(ele).build().perform();
	}

	public boolean waitForElementPresent(By locator) {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return true;
	}

	public boolean waitForElementClickable(By locator) {
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		return true;
	}

	public boolean waitForElementIfSelected(By locator) {
		wait.until(ExpectedConditions.elementToBeClickable(locator)).isSelected();
		return true;
	}

	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			element = driver.findElement(locator);
			if (highlightElement) {
				jsUtil.flash(element);
			}
		} catch (Exception e) {
			System.out.println("Exception occured while creating the web element.......");
			System.out.println(e.getMessage());

		}
		return element;
	}

	public static String getCurrentMonthFirstDate() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, 1);
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		return df.format(c.getTime());
	}

	public static String getCurrentMonthSecondDate() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, 2);
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		return df.format(c.getTime());
	}

	public static String getCurrentMonthThirdDate() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, 3);
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		return df.format(c.getTime());
	}

	public static String getCurrentMonthForthDate() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, 4);
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		return df.format(c.getTime());
	}

	public static String getCurrentMonthFifthDate() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, 5);
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		return df.format(c.getTime());
	}

	public static String getCurrentMonthSixDate() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, 6);
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		return df.format(c.getTime());
	}

	public static String getCurrentMonthSeventhDate() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, 7);
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		return df.format(c.getTime());
	}

	public static String getCurrentMonthEightDate() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, 8);
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		return df.format(c.getTime());
	}

	public static String getTodayDate() {
		Date curDate = new Date();
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyy");
		String DateToString = format.format(curDate);
		return DateToString;
	}

	public void doClick(By locator) {
		try {
			getElement(locator).click();
		} catch (Exception e) {
			System.out.println("Exception occured while clicking on the web element.......");
			System.out.println(e.getMessage());
		}

	}

	public boolean isAlertPresent() {
		try {
			Alert a = new WebDriverWait(driver, 10).until(ExpectedConditions.alertIsPresent());
			if (a != null) {
				System.out.println("Alert is present");
				driver.switchTo().alert().dismiss();
				return true;
			} else {
				throw new Throwable();
			}
		} catch (Throwable e) {
			System.err.println("Alert isn't present!!");
			return false;
		}
	}

	public String doGetText(By locator) {
		try {
			return getElement(locator).getText();
		} catch (Exception e) {
			System.out.println("Exception occured.....Not able to locate an element/retrieve text");
			System.out.println(e.getMessage());
		}
		return null;
	}

	public boolean isElementDisplayed(By locator) {
		try {
			return getElement(locator).isDisplayed();
		} catch (Exception e) {
			System.out.println("Exception occured....Element is not displayed");
			System.out.println(e.getMessage());
		}
		return false;
	}

	public boolean isElementNOT_Displayed(By locator) {
		try {
			return driver.findElement(locator).isDisplayed();
		} catch (Exception e) {
			System.out.println("....Element is not displayed");
		}
		return true;
	}

	public void clickOnCheckBox(By locator) {
		WebElement checkbox = driver.findElement(locator);
		if (checkbox.isSelected()) {
			checkbox.click();
		} else {
			System.out.println("Checkbox is still selected");
		}
	}

	public void buttonsNOT_Displayed(By locator) {
		List<WebElement> buttons = driver.findElements(locator);
		if (buttons.size() != 0) {
			System.out.println("_______PASSED: BUTTONS ARE NOT PRESENT ON THE FORM");
		} else {
			System.out.println("FAILED: BUTTONS ARE PRESENT");
		}
	}

	public String doGetPageTitle() {
		try {
			return driver.getTitle();
		} catch (Exception e) {
			System.out.println("Exception occured.....");
			System.out.println(e.getMessage());
		}
		return null;
	}

	public String getMainWindowHandle() {
		return driver.getWindowHandle();
	}

	public String getCurrentWindowTitle() {
		String windowTitle = driver.getTitle();
		return windowTitle;
	}

	public void waitForNewWindowAndSwitchToIt(WebDriver driver) {
		String cHandle = driver.getWindowHandle();
		String newWindowHandle = null;
		Set<String> allWindowHandles = driver.getWindowHandles();
		// Wait for 20 seconds for the new window and throw exception if not found
		for (int i = 0; i < 20; i++) {
			if (allWindowHandles.size() > 1) {
				for (String allHandlers : allWindowHandles) {
					if (!allHandlers.equals(cHandle))
						newWindowHandle = allHandlers;
				}
				driver.switchTo().window(newWindowHandle);
				break;
			} else {

			}
		}
		if (cHandle == newWindowHandle) {
			throw new RuntimeException("Time out - No window found");
		}
	}

	public boolean closeAllOtherWindows(WebDriver driver, String openWindowHandle) {
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String currentWindowHandle : allWindowHandles) {
			if (!currentWindowHandle.equals(openWindowHandle)) {
				driver.switchTo().window(currentWindowHandle);
				driver.close();
			}
		}
		driver.switchTo().window(openWindowHandle);
		if (driver.getWindowHandles().size() == 1)
			return true;
		else
			return false;
	}

	public void deleteFolder(String value) {
		File folderName = new File(System.getProperty("user.dir") + File.separator + value);
		folderName.delete();
	}

	public void deleteFolderSettings() {
		File folderSettings = new File(System.getProperty("user.dir"));
		folderSettings.delete();
	}

	public void deleteFile(String value) {
		try {
			File file = new File(System.getProperty("user.dir") + File.separator + ("FILES") + File.separator + value);
			if (file.exists()) {
				System.out.println("File is present");
				file.delete();
				System.out.println("_____***__" + file.getName() + " File was deleted");
			} else {
				System.out.println("Delete operation is failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
