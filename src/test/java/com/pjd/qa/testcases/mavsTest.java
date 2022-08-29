package com.pjd.qa.testcases;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.pjd.qa.base.BasePage;
import com.pjd.qa.pages.mavs;
import com.pjd.qa.util.AppConstants;

public class mavsTest {

	WebDriver driver;
	BasePage basePage;
	Properties prop;
	mavs Mavs;

	@BeforeTest
	public void setup() {
		basePage = new BasePage();
		prop = basePage.init_properties();
		driver = basePage.init_driver(prop);
		driver.get(prop.getProperty("url"));
		Mavs = new mavs(driver);
	}

	@Test(priority = 1)
	public void verify_MainPageTitle_test() throws InterruptedException {
		Assert.assertEquals(Mavs.getTitle(), AppConstants.MAVS_LOGIN_PAGE_TITLE);
	}

	@Test(priority = 2)
	public void verify_validateLogoPresence_test() throws InterruptedException {
		Assert.assertTrue(Mavs.validateLogoPresence());
	}

	@Test(priority = 3)
	public void verify_doLogin_test() throws InterruptedException {
		Mavs.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 4)
	public void verify_validateOspreysPageTitle_test() throws InterruptedException {
		Assert.assertEquals(Mavs.validateOspreysPageTitle(), AppConstants.MAVS_PAGE_TITLE);
	}

	@Test(priority = 5)

	public void verify_validateOverviewBadgeIsPresent_test() {
		Assert.assertTrue(Mavs.validateOverviewBadgeIsPresent());
	}

	@Test(priority = 6)
	public void verify_clickingAddFiltersToValidateEmail_test() {
		Mavs.clickingAddFiltersToValidateEmail();
	}

	@Test(priority = 7)
	public void verify_clickingAllFiltersTovalidateEmail_test() {
		Mavs.clickingAllFiltersTovalidateEmail();
	}

	@Test(priority = 8)
	public void verify_ClickingSearchBarToFetchEmail_test() {
		Mavs.ClickingSearchBarToFetchEmail();
	}

	@Test(priority = 9)
	public void verify_sendingFilterKey_test() {
		Mavs.sendingFilterKey("Email");
	}

	@Test(priority = 10)
	public void verify_clickingFilterKey_test() {
		Mavs.clickingFilterKey();
	}

	@Test(priority = 11)
	public void verify_clickingSelectFiltration_test() throws InterruptedException {
		Mavs.clickingSelectFiltration();
	}

	@Test(priority = 12)
	public void verify_clickingExcludeFiltration_test() {
		Mavs.clickingExcludeFiltration();
	}

	@Test(priority = 13)
	public void verify_clickingUpdateButton_test() throws InterruptedException {
		Mavs.clickingUpdateButton();
	}

	@Test(priority = 14)
	public void verify_validateFanCountPresent_test() {
		Assert.assertTrue(Mavs.validateFanCountPresent());
	}

	@Test(priority = 15)
	public void verify_clickingEditFilterToStartNewFiltration_test() {
		Mavs.clickingEditFilterToStartNewFiltration();
	}

	@Test(priority = 16)
	public void verify_clickingAllFiltersToValidateCountry_test() throws InterruptedException {
		Mavs.clickingAllFiltersToValidateCountry();
	}

	@Test(priority = 17)
	public void verify_ClickingSearchBarToFetchCountry_test() {
		Mavs.ClickingSearchBarToFetchCountry();
	}

	@Test(priority = 18)
	public void verify_sendingFilterKeyForCountryFilter_test() {
		Mavs.sendingFilterKey("country");
	}

	@Test(priority = 19)

	public void verify_clickingTheCountryFilterKey_test() throws InterruptedException {
		Mavs.clickingTheCountryFilterKey();
	}

	@Test(priority = 20)
	public void verify_clickingSelecCountrytFiltration_test() throws InterruptedException {
		Mavs.clickingSelecCountrytFiltration();
	}

	@Test(priority = 21)
	public void verify_clickingExcludeCountryFiltration_test() throws InterruptedException {
		Mavs.clickingExcludeCountryFiltration();
	}

	@Test(priority = 22)
	public void verify_clickingUpdateToCountryFilter_test() throws InterruptedException {
		Mavs.clickingUpdateToCountryFilter();
	}

	@Test(priority = 23)
	public void verify_clickingDemographicsBadge_test() {
		Mavs.clickingDemographicsBadge();
	}
	
	@Test(priority = 24)
	public void verify_demographyDiagramIspresent_test() {
		Mavs.demographyDiagramIspresent();
	}

	@Test(priority = 25)
	public void verify_clickingWebBadge_test() throws InterruptedException {
		Mavs.clickingWebBadge();
	}
	
	@Test(priority = 26)
	public void verify_webDiagramIspresent_test() {
		Mavs.webDiagramIspresent();
	}

	@Test(priority = 27)
	public void verify_clickingFanBadge_test() throws InterruptedException {
		Mavs.clickingFanBadge();
	}
	
	@Test(priority = 28)
	public void verify_fanTableIspresent_test() {
		Mavs.fanTableIspresent();
	}
	

	@Test(priority = 29)
	public void verify_clickingSourcesBadge_test() throws InterruptedException {
		Mavs.clickingSourcesBadge();
	}
	
	@Test(priority = 30)
	public void verify_sourcesTableIspresent_test() {
		Mavs.sourcesTableIspresent();
	}

	@Test(priority = 31)
	public void verify_clickingTicketsBadge_test() throws InterruptedException {
		Mavs.clickingTicketsBadge();
	}
	
	@Test(priority = 32)
	public void verify_ticketsDiagramIspresent_test() {
		Mavs.ticketsDiagramIspresent();
	}

	@Test(priority = 33)
	public void verify_clickingMerchandiseBadge_test() throws InterruptedException {
		Mavs.clickingMerchandiseBadge();
	}
	
	@Test(priority = 34)
	public void verify_merchandiseDiagramIspresent_test() {
		Mavs.merchandiseDiagramIspresent();
	}

	@AfterTest
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		// driver.quit();
	}

}
