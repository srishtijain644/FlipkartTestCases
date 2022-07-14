package com.ExitTestFlipkart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MoreOptionPage {
	WebDriver driver;
	Actions action;

	public MoreOptionPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		action = new Actions(driver);
	}

	@FindBy(how = How.XPATH, using = "//div[@class='exehdJ']")
	private WebElement moreOption;

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[5]/div[1]/div[1]/div[2]/div[2]/div[1]/ul[1]/li[1]/a[1]/div[1]")
	private WebElement notificationPreferences;

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[5]/div[1]/div[1]/div[2]/div[2]/div[1]/ul[1]/li[2]/a[1]/div[1]")
	private WebElement customerservice;

	@FindBy(how = How.XPATH, using = "//h1[normalize-space()='Flipkart Help Center | 24x7 Customer Care Support']")
	private WebElement checkCustomerService;

	public void clickMoreOption() {
		moreOption.click();
	}

	public void clickNotificationPreference() {
		action.moveToElement(moreOption).perform();
		action.moveToElement(notificationPreferences).perform();
		notificationPreferences.click();
	}

	public void clickCustomerService() {
		action.moveToElement(moreOption).perform();
		action.moveToElement(customerservice).perform();
		customerservice.click();
	}

	public boolean checkCustomerService() {
		boolean b = checkCustomerService.isDisplayed();
		return b;
	}

}
