package com.ExitTestFlipkart.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ExitTestFlipkart.pages.FirstLoginThenOtherOpeationPage;
import com.ExitTestFlipkart.utils.ExplicitWait;
import com.ExitTestFlipkart.utils.commonUtils;
import com.relevantcodes.extentreports.LogStatus;

public class FirstLoginThenOtherOperation extends BaseTest {
	// Worksheet Name used by all tests
	private String sheetName = prop.getProperty("FirstLoginThenOtherOperationTest_SheetName");

	@Test(priority = 1)
	public void logout() throws InterruptedException {

		String testname = "logout";

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testname);
		String executionRequired = testData.get("Execution Required").toLowerCase();

		// log all data
		commonUtils.logTestData(sheetName, testname);

		// if execution required field is no
		commonUtils.toCheckExecutionRequired(executionRequired);
		loginTest login = new loginTest();
		login.loginWithValidNameAndPassword();
		logger.info("login is done");
		extentTest.log(LogStatus.INFO, "login is done");

		FirstLoginThenOtherOpeationPage FirstLogin = new FirstLoginThenOtherOpeationPage(driver);
		FirstLogin.clicklogout();
		logger.info("logout button was clicked");
		extentTest.log(LogStatus.INFO, "logout button was clicked");
		Thread.sleep(5000);
		boolean b = FirstLogin.checkelement();
		
		Assert.assertTrue(b, "Assertion on element displayed");

	}

	@Test(priority = 2)
	public void visitMyProfile() throws InterruptedException {
		String testname = "visitMyProfile";

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testname);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String expectedTitle = testData.get("Expected Title");

		// log all data
		commonUtils.logTestData(sheetName, testname);

		// if execution required field is no
		commonUtils.toCheckExecutionRequired(executionRequired);
		loginTest login = new loginTest();
		login.loginWithValidNameAndPassword();
		logger.info("login is done");
		extentTest.log(LogStatus.INFO, "login is done");

		FirstLoginThenOtherOpeationPage FirstLogin = new FirstLoginThenOtherOpeationPage(driver);
		FirstLogin.visitMyProfile();
		logger.info("myprofile was clicked");
		extentTest.log(LogStatus.INFO, "my profile was clicked");
		ExplicitWait.checkClickableExplicitly(driver, expectedTitle, 5);
		String actualTitle = driver.getTitle().toLowerCase();
		Assert.assertTrue(actualTitle.contains(expectedTitle.toLowerCase()),
				"Assertion on actual and expected title of search page.");

	}

	@Test(priority = 3)
	public void superCoinZone() throws InterruptedException {
		String testname = "superCoinZone";

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testname);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String expectedTitle = testData.get("Expected Title");

		// log all data
		commonUtils.logTestData(sheetName, testname);

		// if execution required field is no
		commonUtils.toCheckExecutionRequired(executionRequired);
		loginTest login = new loginTest();
		login.loginWithValidNameAndPassword();
		logger.info("login is done");
		extentTest.log(LogStatus.INFO, "login is done");
		FirstLoginThenOtherOpeationPage FirstLogin = new FirstLoginThenOtherOpeationPage(driver);
		FirstLogin.clickSuperCoinZone();
		logger.info("super coin zone was clicked");
		extentTest.log(LogStatus.INFO, "super coin zone was clicked");
		ExplicitWait.checkClickableExplicitly(driver, expectedTitle, 5);
		String actualTitle = driver.getTitle().toLowerCase();
		Assert.assertTrue(actualTitle.contains(expectedTitle.toLowerCase()),
				"Assertion on actual and expected title of search page.");

	}

	@Test(priority = 4)
	public void clickMyProfileThenMyCupons() throws InterruptedException {
		String testname = "clickMyProfileThenMyCupons";

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testname);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String expectedTitle = testData.get("Expected Title");

		// log all data
		commonUtils.logTestData(sheetName, testname);

		// if execution required field is no
		commonUtils.toCheckExecutionRequired(executionRequired);
		loginTest login = new loginTest();
		login.loginWithValidNameAndPassword();
		logger.info("login is done");
		extentTest.log(LogStatus.INFO, "login is done");

		FirstLoginThenOtherOpeationPage FirstLogin = new FirstLoginThenOtherOpeationPage(driver);
		FirstLogin.visitMyProfile();
		logger.info("myprofile was clicked");
		extentTest.log(LogStatus.INFO, "my profile was clicked");
		FirstLogin.clickMyCupons();
		logger.info("my cupons was clicked");
		extentTest.log(LogStatus.INFO, "my cupons was clicked");
		ExplicitWait.checkClickableExplicitly(driver, expectedTitle, 5);
		String actualTitle = driver.getTitle().toLowerCase();
		Assert.assertTrue(actualTitle.contains(expectedTitle.toLowerCase()),
				"Assertion on actual and expected title of search page.");

	}

}
