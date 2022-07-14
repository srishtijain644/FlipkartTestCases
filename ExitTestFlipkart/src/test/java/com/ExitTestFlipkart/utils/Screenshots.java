package com.ExitTestFlipkart.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshots {
	public static String captureScreenshot(WebDriver driver, String testName) throws IOException {
		String imagePath = System.getProperty("user.dir") + "./FailedScreenshots/" + testName + ".jpg";
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File(imagePath));
		return imagePath;
	}

}
