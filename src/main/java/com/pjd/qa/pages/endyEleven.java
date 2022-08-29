package com.pjd.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.pjd.qa.base.BasePage;
import com.pjd.qa.util.JavaScriptUtil;
import com.pjd.qa.util.elementUtil;

public class endyEleven extends BasePage {

	WebDriver driver;
	elementUtil ElementUtil;
	JavaScriptUtil jsUtil;

	By emailId = By.xpath("//div/input[@type = 'email']");
	By password = By.xpath("//div/input[@type = 'password']");
	By signInButton = By.xpath("//button[@type='submit']");
	By logo = By.cssSelector(".AuthFormContainer__StyledLogo-ogzzmn-1");
	By overview = By.xpath("//span[text()='Overview']");
	By addFilter = By.xpath("//button[@class='AudienceBar__AudienceBarButton-hfxdha-3 kfrEGB'][1]");
	By allFilters = By.xpath("(//button[@class='sc-AxgMl lbenUj'])[1]");
	By searchFilters = By.xpath("//input[@placeholder]");
	By emailFilter = By.xpath("(//div[@class = 'AddFilters__FilterName-sc-1s8tp9c-3 bARoTT'])[2]");
	By select = By.xpath("//div/button[@aria-label=\"Select users who have email data\"]");
	By exclude = By.xpath("//div/button[@aria-label=\"Exclude users who do not have email data\"]");
	By update = By.xpath("//div/button[@class = 'sc-AxgMl Filter__StyledButton-hckeff-11 cejBrA']");
	By editFilter = By.xpath("(//button[@class ='AudienceBar__AudienceBarButton-hfxdha-3 kfrEGB' ])[1]");
	By fanCount = By.xpath("(//div[@class = 'FanCount__FanCountAmount-sc-91h9yt-2 eOkJbU'])[2]");
	By postalCode = By.xpath("(//div[@class = 'AddFilters__FilterName-sc-1s8tp9c-3 bARoTT'])[1]");
	By countryFilter = By.xpath("(//div[@class = 'AddFilters__FilterName-sc-1s8tp9c-3 bARoTT'])[3]");
	By selectCountry = By.xpath("//div/button[@aria-label='Select users who have country data']");
	By excludeCountry = By.xpath("//div/button[@aria-label='Exclude users who do not have country data']");
	By updateCountryFilter = By.xpath("//button[@class = 'sc-AxgMl Filter__StyledButton-hckeff-11 cejBrA']");
	By Demographics = By.xpath("//span[text()='Demographics']");
	By demographyDiagram = By.xpath("(//div[@class = 'MavPieChart__ChartWrapper-zp5mw6-0 kKrjPp'])[1]");
	By web = By.xpath("(//li[@class='undefined-item svg_menu'])[3]");
	By webDiagram = By.xpath("(//div[@class = 'MavPieChart__ChartWrapper-zp5mw6-0 kKrjPp'])[2]");
	By fan = By.xpath("(//li[@class='undefined-item svg_menu'])[5]");
	By fanTable = By.xpath("//main[@class = 'userList']");
	By sources = By.xpath("(//li[@class='undefined-item svg_menu'])[6]");
	By sourcesTable = By.xpath("(//div[@class = 'Sources__TableContainer-hk5q41-3 dOnpiN custom_table'])[1]");
	By tickets = By.xpath("(//li[@class='undefined-item svg_menu'])[8]");
	By ticketsDiagram = By.xpath("(//div[@class = 'curvedLineGraph__GraphContainer-sc-155ztx1-6 gBxMzo'])[1]");
	By merchandise = By.xpath("(//li[@class='undefined-item svg_menu'])[9]");
	By merchandiseDiagram = By.xpath("//div[@class = 'curvedLineGraph__GraphContainer-sc-155ztx1-6 gBxMzo']");

	public endyEleven(WebDriver driver) {
		this.driver = driver;
		ElementUtil = new elementUtil(driver);
		jsUtil = new JavaScriptUtil(driver);
	}

	public String getTitle() throws InterruptedException {
		Thread.sleep(7000);
		String title = ElementUtil.doGetPageTitle();
		System.out.println("The report page title is:" + " " + title);
		return title;
	}

	public boolean validateLogoPresence() {
		return ElementUtil.isElementDisplayed(logo);
	}

	public void doLogin(String username, String pwd) {
		ElementUtil.doSendKeys(emailId, username);
		ElementUtil.doSendKeys(password, pwd);
		ElementUtil.doClick(signInButton);
	}

	public String validateOspreysPageTitle() throws InterruptedException {
		Thread.sleep(3000);
		String title = ElementUtil.doGetPageTitle();
		System.out.println("The report page title is:" + " " + title);
		return title;
	}

	public boolean validateOverviewBadgeIsPresent() {
		return ElementUtil.isElementDisplayed(overview);
	}

	public void clickingAddFiltersToValidateEmail() {
		ElementUtil.doClick(addFilter);

	}

	public void clickingAllFiltersTovalidateEmail() {
		ElementUtil.doClick(allFilters);
	}

	public void ClickingSearchBarToFetchEmail() {
		ElementUtil.doClick(searchFilters);
	}

	public void sendingFilterKey(String Email) {
		ElementUtil.doSendKeys(searchFilters, Email);
		ElementUtil.doClick(emailFilter);
	}

	public void clickingFilterKey() {
		ElementUtil.doClick(emailFilter);
	}

	public void clickingSelectFiltration() throws InterruptedException {
		Thread.sleep(3000);
		ElementUtil.doClick(select);
	}

	public void clickingExcludeFiltration() {
		ElementUtil.doClick(exclude);
	}

	public void clickingUpdateButton() {
		ElementUtil.doClick(update);
	}

	public boolean validateFanCountPresent() {
		return ElementUtil.waitForElementPresent(fanCount);
	}

	public void clickingEditFilterToStartNewFiltration() {
		ElementUtil.doClick(editFilter);
	}

	public void clickingAllFiltersToValidateCountry() {
		ElementUtil.doClick(allFilters);
	}

	public void ClickingSearchBarToFetchCountry() {
		ElementUtil.doClick(searchFilters);
	}

	public void sendingFilterKeyForCountryFilter(String countryFilter) {
		ElementUtil.doSendKeys(searchFilters, countryFilter);
	}

	public void clickingTheCountryFilterKey() throws InterruptedException {
		Thread.sleep(3000);
		ElementUtil.doClick(countryFilter);
	}

	public void clickingSelecCountrytFiltration() throws InterruptedException {
		Thread.sleep(3000);
		ElementUtil.doClick(selectCountry);
	}

	public void clickingExcludeCountryFiltration() throws InterruptedException {
		Thread.sleep(3000);
		ElementUtil.doClick(excludeCountry);
	}

	public void clickingUpdateToCountryFilter() throws InterruptedException {
		Thread.sleep(3000);
		ElementUtil.doClick(updateCountryFilter);
	}

	public void clickingDemographicsBadge() {
		ElementUtil.doClick(Demographics);
	}

	public void demographyDiagramIspresent() {
		ElementUtil.waitForElementPresent(demographyDiagram);
	}

	public void clickingWebBadge() throws InterruptedException {
		Thread.sleep(4000);
		ElementUtil.doClick(web);
	}

	public void webDiagramIspresent() {
		ElementUtil.waitForElementPresent(webDiagram);
	}

	public void clickingFanBadge() throws InterruptedException {
		Thread.sleep(4000);
		ElementUtil.doClick(fan);
	}

	public void fanTableIspresent() {
		ElementUtil.waitForElementPresent(fanTable);
	}

	public void clickingSourcesBadge() throws InterruptedException {
		Thread.sleep(4000);
		ElementUtil.doClick(sources);
	}

	public void sourcesTableIspresent() {
		ElementUtil.waitForElementPresent(sourcesTable);
	}

	public void clickingTicketsBadge() throws InterruptedException {
		Thread.sleep(4000);
		ElementUtil.doClick(tickets);
	}

	public void ticketsDiagramIspresent() {
		ElementUtil.waitForElementPresent(ticketsDiagram);
	}

	public void clickingMerchandiseBadge() throws InterruptedException {
		Thread.sleep(4000);
		ElementUtil.doClick(merchandise);
	}

	public void merchandiseDiagramIspresent() {
		ElementUtil.waitForElementPresent(merchandiseDiagram);
	}

}
