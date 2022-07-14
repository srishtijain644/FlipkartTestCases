package com.ExitTestFlipkart.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ExitTestFlipkart.pages.MoreOptionPage;
import com.ExitTestFlipkart.utils.ExplicitWait;
import com.ExitTestFlipkart.utils.commonUtils;
import com.relevantcodes.extentreports.LogStatus;

public class MoreOptionTest extends BaseTest {
	// Worksheet Name used by all tests
	private String sheetName = prop.getProperty("MoreOptionSheetName");

	@Test(priority = 14)
	public void NotificationPreference() {
		String testname = "NotificationPreference";

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testname);
		String executionRequired = testData.get("Execution Required").toLowerCase();

		String expectedTitle = testData.get("Expected Title");

		// log all data
		commonUtils.logTestData(sheetName, testname);

		// if execution required field is no
		commonUtils.toCheckExecutionRequired(executionRequired);
		MoreOptionPage more = new MoreOptionPage(driver);
		more.clickMoreOption();
		logger.info("more option was clicked");
		extentTest.log(LogStatus.INFO, "more option was clicked");
		more.clickNotificationPreference();
		logger.info("notification preference was clicked");
		extentTest.log(LogStatus.INFO, "notfication preference was clicked");
		ExplicitWait.checkClickableExplicitly(driver, expectedTitle, 5);
		String actualTitle = driver.getTitle().toLowerCase();
		logger.info("Actual Result : "+actualTitle);
		extentTest.log(LogStatus.INFO, "Actual Result : "+actualTitle);

		Assert.assertTrue(actualTitle.contains(expectedTitle.toLowerCase()),
				"Assertion on actual and expected title of search page.");

	}

	@Test(priority = 15)
	public void customerService() {
		String testname = "customerService";

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testname);
		String executionRequired = testData.get("Execution Required").toLowerCase();

		String expectedTitle = testData.get("Expected Title");

		// log all data
		commonUtils.logTestData(sheetName, testname);

		// if execution required field is no
		commonUtils.toCheckExecutionRequired(executionRequired);
		MoreOptionPage more = new MoreOptionPage(driver);
		more.clickMoreOption();
		logger.info("more option was clicked");
		extentTest.log(LogStatus.INFO, "more option was clicked");
		more.clickCustomerService();
		logger.info("customer service was clicked");
		extentTest.log(LogStatus.INFO, "customer service was clicked");
		ExplicitWait.checkClickableExplicitly(driver, expectedTitle, 5);
		String actualTitle = driver.getTitle().toLowerCase();
		logger.info("Actual Result : "+actualTitle);
		extentTest.log(LogStatus.INFO, "Actual Result : "+actualTitle);

		Assert.assertTrue(actualTitle.contains(expectedTitle.toLowerCase()),
				"Assertion on actual and expected title of search page.");
		boolean b = more.checkCustomerService();
		Assert.assertTrue(b, "Assertion on element locator");
	}

}
