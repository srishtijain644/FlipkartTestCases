package com.ExitTestFlipkart.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.log4testng.Logger;

import com.ExitTestFlipkart.pages.ProductPage;
import com.ExitTestFlipkart.utils.excelReadingFile;
import com.ReusableMethod.utilities.Screenshots;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseTest {
	public static WebDriver driver;
	Screenshots Screenshots = new Screenshots(); 
	static {
		String log4jConfigFile = System.getProperty("user.dir") + File.separator + "./Resources/log4j.properties";
		PropertyConfigurator.configure(log4jConfigFile);
	}
	// Log4j logger
	public final static Logger logger = Logger.getLogger(BaseTest.class);

	// Excel File Test Data Reader
	public static excelReadingFile reader = null;

	static {
		reader = new excelReadingFile("./TestDataSheet/TestData.xlsx");
	}

	public static File file;
	public static FileInputStream fis;
	public static Properties prop;
	public static ExtentReports extent;
	public static ExtentTest extentTest;
	public static String DriverName, DriverMode;

	static {
		file = new File("./Resources/config.properties");
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		prop = new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@BeforeSuite
	public void setExtent() {
		extent = new ExtentReports("./Reports/ExtentReports.html");
	}

	@AfterSuite
	public void endReport() {
		extent.flush();
		extent.close();
	}

	@SuppressWarnings("deprecation")
	@BeforeMethod
	public static void initializeDriver() {
		

		DriverName = prop.getProperty("BrowserName");
		DriverMode = prop.getProperty("DriverMode");

		// Code for Chrome Driver with or without Headless Mode

		if (DriverName.toLowerCase().equals("chrome")) {
			System.setProperty(prop.getProperty("chromeDriverProperty"), prop.getProperty("chromeDriverPath"));
			if (DriverMode.toLowerCase().equals("headless")) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("window-size= 1920, 1080");
				options.addArguments("--headless");
				driver = new ChromeDriver(options);
			} else {
				driver = new ChromeDriver();
			}
		}
		// Code for FireFox Driver with or without Headless Mode
		if (DriverName.toLowerCase().equals("firefox")) {
			System.setProperty(prop.getProperty("firefoxDriverProperty"), prop.getProperty("firefoxDriverPath"));
			if (DriverMode.toLowerCase().equals("headless")) {
				FirefoxOptions options = new FirefoxOptions();
				options.setHeadless(true);
				driver = new FirefoxDriver(options);
			} else {

				driver = new FirefoxDriver();
			}
		}
		// code for InternetExplorer driver without headless mode
		if (DriverName.toLowerCase().equals("internet explorer")) {
			System.setProperty(prop.getProperty("InternetExplorerDriverProperty"),
					prop.getProperty("InternetExplorerDriverPath"));
			driver = new InternetExplorerDriver();
		}

		// code for microsoft edge driver with or without headless mode
		if (DriverName.toLowerCase().equals("microsoftedge")) {
			System.setProperty(prop.getProperty("microsoftEdgeDriverProperty"),
					prop.getProperty("microsoftEdgeDriverPath"));
			if (DriverMode.toLowerCase().equals("headless")) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("window-size= 1920, 1080");
				options.addArguments("--headless");
				driver = new EdgeDriver(options);
			} else {
			
			
				driver = new EdgeDriver();
			}
			
		}

		driver.manage().window().maximize();

		String n = prop.getProperty("implicitWait");
		driver.manage().timeouts().implicitlyWait(Long.parseLong(n), TimeUnit.SECONDS);
	}

	@BeforeMethod
	public static void openUrl() {
		driver.get(prop.getProperty("URL"));
		ProductPage searchItem = new ProductPage(driver);
		searchItem.cancelButton();

	}

	@BeforeMethod
	public void startTest(Method name) {
		String testName = name.getName();
		extentTest = extent.startTest(testName);
	}

	@AfterMethod
	public void ResultTest(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			// take screenshot
			String imagePath = Screenshots.captureScreenshot(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(imagePath));
			extentTest.log(LogStatus.INFO, result.getThrowable());

		} else {
			if (result.getStatus() == ITestResult.SUCCESS) {
				extentTest.log(LogStatus.PASS, "Test case passed succefully");
			}

		}
		extent.endTest(extentTest);

	}

	@AfterMethod
	public static void testClose() {

		driver.quit();

	}

}
