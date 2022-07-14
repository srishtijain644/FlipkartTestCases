package com.ExitTestFlipkart.utils;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {
	// To wait for some seconds explicitly
			public static void checkClickableExplicitly(WebDriver driver, String title, int timeout) {
				
				new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class).
				until(ExpectedConditions.titleContains(title));
				
			}

}
