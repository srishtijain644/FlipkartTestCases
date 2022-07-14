package com.ExitTestFlipkart.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ExitTestFlipkart.pages.HomePage;
import com.ExitTestFlipkart.utils.ExplicitWait;
import com.ExitTestFlipkart.utils.commonUtils;
import com.relevantcodes.extentreports.LogStatus;

public class HomePageTests extends BaseTest {
	// Worksheet Name used by all tests
	private String sheetName = prop.getProperty("HomePageSheetName");

	@Test(priority = 5)
	public void topOffers() throws InterruptedException {

		String testname = "topOffers";

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testname);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String expectedTitle = testData.get("Expected Title");

		// log all data
		commonUtils.logTestData(sheetName, testname);

		// if execution required field is no
		commonUtils.toCheckExecutionRequired(executionRequired);

		HomePage home = new HomePage(driver);
		home.topOffers();
		logger.info("top offers was clicked");
		extentTest.log(LogStatus.INFO, "top offers was clicked");
		ExplicitWait.checkClickableExplicitly(driver, expectedTitle, 5);

		String actualTitle = driver.getTitle().toLowerCase();
		logger.info("Actual Result : "+actualTitle);
		extentTest.log(LogStatus.INFO, "Actual Result : "+actualTitle);
		Assert.assertTrue(actualTitle.contains(expectedTitle.toLowerCase()),
				"Assertion on actual and expected title of search page.");
	}

	@Test(priority = 6)
	public void Mobiles() throws InterruptedException {
		String testname = "Mobiles";

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testname);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String expectedTitle = testData.get("Expected Title");

		// log all data
		commonUtils.logTestData(sheetName, testname);

		// if execution required field is no
		commonUtils.toCheckExecutionRequired(executionRequired);

		HomePage home = new HomePage(driver);
		home.mobiles();
		logger.info("mobiles option was clicked");
		extentTest.log(LogStatus.INFO, "mobiles option was clicked");
		ExplicitWait.checkClickableExplicitly(driver, expectedTitle, 5);

		String actualTitle = driver.getTitle().toLowerCase();
		logger.info("Actual Result : "+actualTitle);
		extentTest.log(LogStatus.INFO, "Actual Result : "+actualTitle);
		Assert.assertTrue(actualTitle.contains(expectedTitle.toLowerCase()),
				"Assertion on actual and expected title of search page.");

	}

	@Test(priority = 7)
	public void FlipkartPlusZone() throws InterruptedException {
		String testname = "FlipkartPlusZone";

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testname);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String expectedTitle = testData.get("Expected Title");

		// log all data
		commonUtils.logTestData(sheetName, testname);

		// if execution required field is no
		commonUtils.toCheckExecutionRequired(executionRequired);

		HomePage home = new HomePage(driver);
		home.plusZone();
		logger.info("Flipkart plus zone was clicked");
		extentTest.log(LogStatus.INFO, "Flipkart plus zone was clicked");
		ExplicitWait.checkClickableExplicitly(driver, expectedTitle, 5);

		String actualTitle = driver.getTitle().toLowerCase();
		logger.info("Actual Result : "+actualTitle);
		extentTest.log(LogStatus.INFO, "Actual Result : "+actualTitle);
		Assert.assertTrue(actualTitle.contains(expectedTitle.toLowerCase()),
				"Assertion on actual and expected title of search page.");
	}

	@Test(priority = 8)
	public void FlipkartStories() throws InterruptedException {
		String testname = "FlipkartStories";

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testname);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String expectedTitle = testData.get("Expected Title");

		// log all data
		commonUtils.logTestData(sheetName, testname);

		// if execution required field is no
		commonUtils.toCheckExecutionRequired(executionRequired);

		HomePage home = new HomePage(driver);
		home.FlipkartStories();
		logger.info("flipkart stories was clicked");
		extentTest.log(LogStatus.INFO, "flipkart stories was clicked");
		ExplicitWait.checkClickableExplicitly(driver, expectedTitle, 10);

		String actualTitle = driver.getTitle().toLowerCase();
		logger.info("Actual Result : "+actualTitle);
		extentTest.log(LogStatus.INFO, "Actual Result : "+actualTitle);
		Assert.assertTrue(actualTitle.contains(expectedTitle.toLowerCase()),
				"Assertion on actual and expected title of search page.");
	}

	@Test(priority = 9)
	public void Facebook() {
		String testname = "Facebook";

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testname);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String expectedTitle = testData.get("Expected Title");

		// log all data
		commonUtils.logTestData(sheetName, testname);

		// if execution required field is no
		commonUtils.toCheckExecutionRequired(executionRequired);

		HomePage home = new HomePage(driver);
		home.Facebook();
		logger.info("facebook was clicked");
		extentTest.log(LogStatus.INFO, "facebook was clicked");
		ExplicitWait.checkClickableExplicitly(driver, expectedTitle, 5);

		String actualTitle = driver.getTitle().toLowerCase();
		logger.info("Actual Result : "+actualTitle);
		extentTest.log(LogStatus.INFO, "Actual Result : "+actualTitle);
		Assert.assertTrue(actualTitle.contains(expectedTitle.toLowerCase()),
				"Assertion on actual and expected title of search page.");
	}

	@Test(priority = 10)
	public void BecomeASeller() throws InterruptedException {
		String testname = "BecomeASeller";

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testname);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String expectedTitle = testData.get("Expected Title");

		// log all data
		commonUtils.logTestData(sheetName, testname);

		// if execution required field is no
		commonUtils.toCheckExecutionRequired(executionRequired);

		HomePage home = new HomePage(driver);
		home.becomeASeller();
		logger.info("become a seller was clicked");
		extentTest.log(LogStatus.INFO, "become a seller was clicked");
		ExplicitWait.checkClickableExplicitly(driver, expectedTitle, 5);

		String actualTitle = driver.getTitle().toLowerCase();
		logger.info("Actual Result : "+actualTitle);
		extentTest.log(LogStatus.INFO, "Actual Result : "+actualTitle);
		Assert.assertTrue(actualTitle.contains(expectedTitle.toLowerCase()),
				"Assertion on actual and expected title of search page.");

	}

	@Test(priority = 11)
	public void hoverToElectronicsAndClickGaming() {
		String testname = "hoverToElectronicsAndClickGaming";

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testname);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String expectedTitle = testData.get("Expected Title");

		// log all data
		commonUtils.logTestData(sheetName, testname);

		// if execution required field is no
		commonUtils.toCheckExecutionRequired(executionRequired);

		HomePage home = new HomePage(driver);
		home.clickGaming();
		logger.info("Gaming is clicked was clicked");
		extentTest.log(LogStatus.INFO, "Gaming was clicked");
		ExplicitWait.checkClickableExplicitly(driver, expectedTitle, 5);

		String actualTitle = driver.getTitle().toLowerCase();
		logger.info("Actual Result : "+actualTitle);
		extentTest.log(LogStatus.INFO, "Actual Result : "+actualTitle);
		Assert.assertTrue(actualTitle.contains(expectedTitle.toLowerCase()),
				"Assertion on actual and expected title of search page.");

	}

}
