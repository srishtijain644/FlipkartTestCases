package com.ExitTestFlipkart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class travelPage {
	WebDriver driver;

	public travelPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//img[@alt='Travel']")
	private WebElement travel;

	@FindBy(how = How.XPATH, using = "//input[@name='0-departcity']")
	private WebElement clickFrom;

	@FindBy(how = How.XPATH, using = "//input[@name='0-arrivalcity']")
	private WebElement clickTo;

	@FindBy(how = How.XPATH, using = "//span[normalize-space()='SEARCH']")
	private WebElement clickSearch;

	@FindBy(how = How.XPATH, using = "//body/div[@id='container']/div/div[@class='_2I_P4n _6t1WkM _3HqJxg']/div[@class='_1AtVbE col-12-12']/div[@class='_3-tSyS _36bm8T']/div[@class='_3XCEEm']/div[@class='_1dTDqB']/div[@class='_2ffI1H']/form[@class='_1DLh40']/div[@class='_2NKqZI']/div[@class='_3REAgv']/div[1]/div[1]")
	private WebElement checktravelforInvalid;

	public void clickTravel() {
		travel.click();
	}

	public void onewaytripSearch(String fromLocation, String toLocation) throws InterruptedException {
		clickFrom.sendKeys(fromLocation);
		clickTo.sendKeys(toLocation);
		Thread.sleep(2000);
		clickSearch.click();
		Thread.sleep(2000);
	}

	public boolean checktravelElement() {
		boolean b = checktravelforInvalid.isDisplayed();
		return b;
	}

}
