package com.pjd.qa.testcases;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.pjd.qa.base.BasePage;
import com.pjd.qa.pages.ospreys;
import com.pjd.qa.util.AppConstants;

public class ospreysTest {

	WebDriver driver;
	BasePage basePage;
	Properties prop;
	ospreys Ospreys;

	@BeforeTest
	public void setup() {
		basePage = new BasePage();
		prop = basePage.init_properties();
		driver = basePage.init_driver(prop);
		driver.get(prop.getProperty("url"));
		Ospreys = new ospreys(driver);
	}

	@Test(priority = 1)
	public void verify_MainPageTitle_test() throws InterruptedException {
		Assert.assertEquals(Ospreys.getTitle(), AppConstants.OSPREYS_LOGIN_PAGE_TITLE);
	}

	@Test(priority = 2)
	public void verify_validateLogoPresence_test() throws InterruptedException {
		Assert.assertTrue(Ospreys.validateLogoPresence());
	}

	@Test(priority = 3)
	public void verify_doLogin_test() {
		Ospreys.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 4)
	public void verify_validateOspreysPageTitle_test() throws InterruptedException {
		Assert.assertEquals(Ospreys.validateOspreysPageTitle(), AppConstants.OSPREYS_PAGE_TITLE);
	}

	@Test(priority = 5)

	public void verify_validateOverviewBadgeIsPresent_test() {
		Assert.assertTrue(Ospreys.validateOverviewBadgeIsPresent());
	}

	@Test(priority = 6)
	public void verify_clickingAddFiltersToValidateEmail_test() {
		Ospreys.clickingAddFiltersToValidateEmail();
	}

	@Test(priority = 7)
	public void verify_clickingAllFiltersTovalidateEmail_test() {
		Ospreys.clickingAllFiltersTovalidateEmail();
	}

	@Test(priority = 8)
	public void verify_ClickingSearchBarToFetchEmail_test() {
		Ospreys.ClickingSearchBarToFetchEmail();
	}

	@Test(priority = 9)
	public void verify_sendingFilterKey_test() {
		Ospreys.sendingFilterKey("Email");
	}

	@Test(priority = 10)
	public void verify_clickingFilterKey_test() {
		Ospreys.clickingFilterKey();
	}

	@Test(priority = 11)
	public void verify_clickingSelectFiltration_test() throws InterruptedException {
		Ospreys.clickingSelectFiltration();
	}

	@Test(priority = 12)
	public void verify_clickingExcludeFiltration_test() {
		Ospreys.clickingExcludeFiltration();
	}

	@Test(priority = 13)
	public void verify_clickingUpdateButton_test() {
		Ospreys.clickingUpdateButton();
	}

	@Test(priority = 14)
	public void verify_validateFanCountPresent_test() {
		Assert.assertTrue(Ospreys.validateFanCountPresent());
	}

	@Test(priority = 15)
	public void verify_clickingEditFilterToStartNewFiltration_test() {
		Ospreys.clickingEditFilterToStartNewFiltration();
	}

	@Test(priority = 16)
	public void verify_clickingAllFiltersToValidateCountry_test() {
		Ospreys.clickingAllFiltersToValidateCountry();
	}

	@Test(priority = 17)
	public void verify_ClickingSearchBarToFetchCountry_test() {
		Ospreys.ClickingSearchBarToFetchCountry();
	}

	@Test(priority = 18)
	public void verify_sendingFilterKeyForCountryFilter_test() {
		Ospreys.sendingFilterKey("country");
	}

	@Test(priority = 19)

	public void verify_clickingTheCountryFilterKey_test() throws InterruptedException {
		Ospreys.clickingTheCountryFilterKey();
	}

	@Test(priority = 20)
	public void verify_clickingSelecCountrytFiltration_test() throws InterruptedException {
		Ospreys.clickingSelecCountrytFiltration();
	}

	@Test(priority = 21)
	public void verify_clickingExcludeCountryFiltration_test() throws InterruptedException {
		Ospreys.clickingExcludeCountryFiltration();
	}

	@Test(priority = 22)
	public void verify_clickingUpdateToCountryFilter_test() throws InterruptedException {
		Ospreys.clickingUpdateToCountryFilter();
	}

	@Test(priority = 23)
	public void verify_clickingDemographicsBadge_test() {
		Ospreys.clickingDemographicsBadge();
	}
	
	@Test(priority = 24)
	public void verify_demographyDiagramIspresent_test() {
		Ospreys.demographyDiagramIspresent();
	}

	@Test(priority = 25)
	public void verify_clickingWebBadge_test() throws InterruptedException {
		Ospreys.clickingWebBadge();
	}
	
	@Test(priority = 26)
	public void verify_webDiagramIspresent_test() {
		Ospreys.webDiagramIspresent();
	}

	@Test(priority = 27)
	public void verify_clickingFanBadge_test() throws InterruptedException {
		Ospreys.clickingFanBadge();
	}
	
	@Test(priority = 28)
	public void verify_fanTableIspresent_test() {
		Ospreys.fanTableIspresent();
	}
	

	@Test(priority = 29)
	public void verify_clickingSourcesBadge_test() throws InterruptedException {
		Ospreys.clickingSourcesBadge();
	}
	
	@Test(priority = 30)
	public void verify_sourcesTableIspresent_test() {
		Ospreys.sourcesTableIspresent();
	}

	@Test(priority = 31)
	public void verify_clickingTicketsBadge_test() throws InterruptedException {
		Ospreys.clickingTicketsBadge();
	}
	
	@Test(priority = 32)
	public void verify_ticketsDiagramIspresent_test() {
		Ospreys.ticketsDiagramIspresent();
	}

	@Test(priority = 33)
	public void verify_clickingMerchandiseBadge_test() throws InterruptedException {
		Ospreys.clickingMerchandiseBadge();
	}
	
	@Test(priority = 34)
	public void verify_merchandiseDiagramIspresent_test() {
		Ospreys.merchandiseDiagramIspresent();
	}

	@AfterTest
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		// driver.quit();
	}

}
