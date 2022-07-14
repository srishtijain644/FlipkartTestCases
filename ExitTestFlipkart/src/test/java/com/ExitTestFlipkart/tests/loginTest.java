package com.ExitTestFlipkart.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ExitTestFlipkart.pages.loginPage;
import com.ExitTestFlipkart.utils.ExplicitWait;
import com.ExitTestFlipkart.utils.commonUtils;
import com.relevantcodes.extentreports.LogStatus;

public class loginTest extends BaseTest {
	// Worksheet Name used by all tests
	private String sheetName = prop.getProperty("loginTestSheetName");

	@Test(priority = 12)
	public void loginWithValidNameAndPassword() throws InterruptedException {
		String testname = "loginWithValidNameAndPassword";

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testname);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String number = testData.get("Number");
		String password = testData.get("Password");
		String expectedTitle = testData.get("Expected Title");

		// log all data
		commonUtils.logTestData(sheetName, testname);

		// if execution required field is no
		commonUtils.toCheckExecutionRequired(executionRequired);

		loginPage login = new loginPage(driver);
		login.login(number, password);
		logger.info("login with valid name and password");
		extentTest.log(LogStatus.INFO, "login with valid name and password");
		ExplicitWait.checkClickableExplicitly(driver, expectedTitle, 5);

		String actualTitle = driver.getTitle().toLowerCase();
		logger.info("Actual Result : "+actualTitle);
		extentTest.log(LogStatus.INFO, "Actual Result : "+actualTitle);
		Assert.assertTrue(actualTitle.contains(expectedTitle.toLowerCase()),
				"Assertion on actual and expected title of search page.");

		boolean b = login.checklogin();
		Assert.assertTrue(b, "Assertion on element diplayed");

	}

	@Test(priority = 13)
	public void loginWithInvalidNumberOrPassword() throws InterruptedException {
		String testname = "loginWithInvalidNumberOrPassword";

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testname);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String number = testData.get("Number");
		String password = testData.get("Password");

		// log all data
		commonUtils.logTestData(sheetName, testname);

		// if execution required field is no
		commonUtils.toCheckExecutionRequired(executionRequired);

		loginPage login = new loginPage(driver);
		login.login(number, password);
		logger.info("login with invalid name or password");
		extentTest.log(LogStatus.INFO, "login with invalid name or password");
		boolean b = login.checkElementForInvalid();
		Assert.assertTrue(b);

	}

}
