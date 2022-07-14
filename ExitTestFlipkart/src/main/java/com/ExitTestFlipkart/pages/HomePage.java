package com.ExitTestFlipkart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	Actions action;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		action = new Actions(driver);
	}

	@FindBy(how = How.XPATH, using = "//img[@alt='Top Offers']")
	private WebElement clickTopOffers;

	@FindBy(how = How.XPATH, using = "//img[@alt='Mobiles']")
	private WebElement clickMobiles;

	@FindBy(how = How.XPATH, using = "//a[@class='_21ljIi']")
	private WebElement clickFlipkartPlusZone;

	@FindBy(how = How.XPATH, using = "//a[normalize-space()='Flipkart Stories']")
	private WebElement clickFlipkartStories;

	@FindBy(how = How.XPATH, using = "//a[normalize-space()='Facebook']")
	private WebElement clickFacebook;

	@FindBy(how = How.XPATH, using = "//a[@class='_3-PJz-']//span[contains(text(),'Become a Seller')]")
	private WebElement clickBecomeASeller;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Electronics')]")
	private WebElement electronics;

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[5]/a[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/a[5]")
	private WebElement gaming;

	public void topOffers() throws InterruptedException {
		clickTopOffers.click();
		Thread.sleep(1000);
	}

	public void mobiles() throws InterruptedException {
		clickMobiles.click();
		Thread.sleep(1000);
	}

	public void plusZone() throws InterruptedException {
		clickFlipkartPlusZone.click();
		Thread.sleep(1000);
	}

	public void FlipkartStories() throws InterruptedException {
		clickFlipkartStories.click();
		Thread.sleep(1000);
	}

	public void Facebook() {
		clickFacebook.click();
	}

	public void becomeASeller() throws InterruptedException {
		clickBecomeASeller.click();
		Thread.sleep(1000);
	}

	public void clickGaming() {
		action.moveToElement(electronics).perform();
		action.moveToElement(gaming).perform();
		gaming.click();
	}

}
