package com.ExitTestFlipkart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class FirstLoginThenOtherOpeationPage {
	WebDriver driver;
	Actions action;

	public FirstLoginThenOtherOpeationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		action = new Actions(driver);
	}

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Srishti')]")
	private WebElement myName;

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[2]/div[1]/ul[1]/li[10]/a[1]/div[1]")
	private WebElement logout;

	@FindBy(how = How.XPATH, using = "//a[normalize-space()='Login']")
	private WebElement checkLoginelement;

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[2]/div[1]/ul[1]/li[1]/a[1]")
	private WebElement MyProfile;

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[2]/div[1]/ul[1]/li[2]/a[1]/div[1]")
	private WebElement supercoinZone;

	@FindBy(how = How.XPATH, using = "//div[normalize-space()='My Coupons']")
	private WebElement myCupons;

	public void clicklogout() {
		action.moveToElement(myName).perform();
		action.moveToElement(logout).perform();
		logout.click();
	}

	public boolean checkelement() {
		boolean b = checkLoginelement.isDisplayed();
		return b;
	}

	public void visitMyProfile() {
		action.moveToElement(myName).perform();
		action.moveToElement(MyProfile).perform();
		MyProfile.click();
	}

	public void clickSuperCoinZone() {
		action.moveToElement(myName).perform();
		action.moveToElement(supercoinZone).perform();
		supercoinZone.click();
	}

	public void clickMyCupons() {
		myCupons.click();
	}

}
