package com.ExitTestFlipkart.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ExitTestFlipkart.pages.ProductPage;
import com.ExitTestFlipkart.utils.ExplicitWait;
import com.ExitTestFlipkart.utils.commonUtils;
import com.relevantcodes.extentreports.LogStatus;

public class ProductPageTests extends BaseTest {
	// Worksheet Name used by all tests
	private String sheetName = prop.getProperty("ProductPageSheetName");

	@Test(priority = 16)
	public void search() throws InterruptedException {
		String testname = "search";

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testname);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String searchItemName = testData.get("searchItemName");

		String expectedTitle = testData.get("Expected Title");

		// log all data
		commonUtils.logTestData(sheetName, testname);

		// if execution required field is no
		commonUtils.toCheckExecutionRequired(executionRequired);

		ProductPage product = new ProductPage(driver);
		logger.info("in search method");
		product.search(searchItemName);
		logger.info(searchItemName + "is entered");
		ExplicitWait.checkClickableExplicitly(driver, expectedTitle, 5);

		String actualTitle = driver.getTitle().toLowerCase();
		logger.info("Actual Result : "+actualTitle);
		extentTest.log(LogStatus.INFO, "Actual Result : "+actualTitle);
		Assert.assertTrue(actualTitle.contains(expectedTitle.toLowerCase()),
				"Assertion on actual and expected title of search page.");

	}

	@Test(priority = 17)
	public void Applyfilter() throws InterruptedException {
		String testname = "Applyfilter";

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testname);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String searchItemName = testData.get("searchItemName");

		String expectedTitle = testData.get("Expected Title");

		// log all data
		commonUtils.logTestData(sheetName, testname);

		// if execution required field is no
		commonUtils.toCheckExecutionRequired(executionRequired);

		ProductPage product = new ProductPage(driver);
		product.search(searchItemName);
		logger.info(searchItemName + "is entered");

		product.AudioBook();
		ExplicitWait.checkClickableExplicitly(driver, expectedTitle, 5);
		String actualTitle = driver.getTitle().toLowerCase();
		logger.info("Actual Result : "+actualTitle);
		extentTest.log(LogStatus.INFO, "Actual Result : "+actualTitle);
		Assert.assertTrue(actualTitle.contains(expectedTitle.toLowerCase()),
				"Assertion on actual and expected title of search page.");

	}

	@Test(priority = 18)
	public void addToCart() {
		String testname = "addToCart";

		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testname);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String searchItemName = testData.get("searchItemName");

		String expectedTitle = testData.get("Expected Title");

		// log all data
		commonUtils.logTestData(sheetName, testname);

		// if execution required field is no
		commonUtils.toCheckExecutionRequired(executionRequired);

		ProductPage product = new ProductPage(driver);
		product.search(searchItemName);
		logger.info(searchItemName + "is entered");

		product.AddToCart();
		logger.info("product is added to cart");
		extentTest.log(LogStatus.INFO, "product is added to cart");

		ExplicitWait.checkClickableExplicitly(driver, expectedTitle, 5);
		String actualTitle = driver.getTitle().toLowerCase();
		logger.info("Actual Result : "+actualTitle);
		extentTest.log(LogStatus.INFO, "Actual Result : "+actualTitle);
		Assert.assertTrue(actualTitle.contains(expectedTitle.toLowerCase()),
				"Assertion on actual and expected title of search page.");

	}

}
