package com.ExitTestFlipkart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	WebDriver driver;

	public loginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//a[normalize-space()='Login']")
	private WebElement clickLogin;

	@FindBy(how = How.XPATH, using = "//input[@class='_2IX_2- VJZDxU']")
	private WebElement enterNumber;

	@FindBy(how = How.XPATH, using = "//input[@type='password']")
	private WebElement enterPassword;

	@FindBy(how = How.XPATH, using = "//button[@type='submit']//span[contains(text(),'Login')]")
	private WebElement submitLogin;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Srishti')]")
	private WebElement myName;

	@FindBy(how = How.XPATH, using = "//span[normalize-space()='Sign up with your mobile number to get started']")
	private WebElement checkElementForInvalidData;

	public void login(String number, String password) throws InterruptedException {
		clickLogin.click();
		enterNumber.sendKeys(number);
		enterPassword.sendKeys(password);
		Thread.sleep(1000);
		submitLogin.click();
		Thread.sleep(1000);
	}

	public boolean checklogin() {
		boolean b = myName.isDisplayed();
		return b;
	}

	public boolean checkElementForInvalid() {
		boolean b = checkElementForInvalidData.isDisplayed();
		return b;
	}

}
