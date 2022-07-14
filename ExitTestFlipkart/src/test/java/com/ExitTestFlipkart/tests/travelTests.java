package com.ExitTestFlipkart.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ExitTestFlipkart.pages.travelPage;
import com.ExitTestFlipkart.utils.ExplicitWait;
import com.ExitTestFlipkart.utils.commonUtils;
import com.relevantcodes.extentreports.LogStatus;

public class travelTests extends BaseTest {
	// Worksheet Name used by all tests
	private String sheetName = prop.getProperty("travelTestsSheetName");

	@Test(priority = 19)
	public void enterValidFromAndToValue() throws InterruptedException {
		String testname = "enterValidFromAndToValue";

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testname);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String fromLocation = testData.get("fromLocation");
		String toLocation = testData.get("toLocation");

		String expectedTitle = testData.get("Expected Title");

		// log all data
		commonUtils.logTestData(sheetName, testname);

		// if execution required field is no
		commonUtils.toCheckExecutionRequired(executionRequired);
		travelPage travel = new travelPage(driver);
		travel.clickTravel();
		travel.onewaytripSearch(fromLocation, toLocation);
		ExplicitWait.checkClickableExplicitly(driver, expectedTitle, 5);

		String actualTitle = driver.getTitle().toLowerCase();
		logger.info("Actual Result : "+actualTitle);
		extentTest.log(LogStatus.INFO, "Actual Result : "+actualTitle);
		Assert.assertTrue(actualTitle.contains(expectedTitle.toLowerCase()),
				"Assertion on actual and expected title of search page.");
	}

	@Test(priority = 20)
	public void enterInValidFromOrToValue() throws InterruptedException {
		String testname = "enterInValidFromOrToValue";

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testname);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String fromLocation = testData.get("fromLocation");
		String toLocation = testData.get("toLocation");

		String expectedTitle = testData.get("Expected Title");

		// log all data
		commonUtils.logTestData(sheetName, testname);

		// if execution required field is no
		commonUtils.toCheckExecutionRequired(executionRequired);
		travelPage travel = new travelPage(driver);
		travel.clickTravel();
		logger.info("travel option was clicked");
		extentTest.log(LogStatus.INFO, "travel option was clicked");

		travel.onewaytripSearch(fromLocation, toLocation);
		logger.info(fromLocation + "is entered");
		logger.info(toLocation + "is entered");
		extentTest.log(LogStatus.INFO, "fromLocation : "+fromLocation);
		extentTest.log(LogStatus.INFO, "toLocation : "+toLocation);
		ExplicitWait.checkClickableExplicitly(driver, expectedTitle, 5);

		String actualTitle = driver.getTitle().toLowerCase();
		logger.info("Actual Result : "+actualTitle);
		extentTest.log(LogStatus.INFO, "Actual Result : "+actualTitle);
		Assert.assertTrue(actualTitle.contains(expectedTitle.toLowerCase()),
				"Assertion on actual and expected title of search page.");

		boolean b = travel.checktravelElement();
		Assert.assertTrue(b, "Assertion on elemnet displayed");
	}

}
