package com.ExitTestFlipkart.pages;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	WebDriver driver;

	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'✕')]")
	private WebElement cancel;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Search for products, brands and more']")
	private WebElement searchItem;

	@FindBy(how = How.CSS, using = "div[title='Hindi'] div[class='_3879cV']")
	private WebElement clickLanguage;

	@FindBy(how = How.XPATH, using = "//div[@title='4★ & above']//div[2]")
	private WebElement clickCustomerRating;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Availability')]")
	private WebElement clickAvailability;

	@FindBy(how = How.CSS, using = "div[title='Exclude Out of Stock'] div[class='_3879cV']")
	private WebElement clickExcludeOutOfStock;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'BS AMOR Glass Vase, Urli Bowl Terrarium Succulent ')]")
	private WebElement clickItem;

	@FindBy(how = How.XPATH, using = "//button[normalize-space()='ADD TO CART']")
	private WebElement AddItemToCart;

	public void cancelButton() {
		cancel.click();
	}

	public void search(String item) {
		searchItem.sendKeys(item);

		searchItem.submit();

	}

	public void AudioBook() throws InterruptedException {
		clickCustomerRating.click();
		Thread.sleep(2000);
		clickLanguage.click();
		Thread.sleep(2000);
		clickAvailability.click();
		clickExcludeOutOfStock.click();
	}

	public void AddToCart() {
		clickItem.click();
		Set<String> h = driver.getWindowHandles();
		System.out.println(h);
		for (String string : h) {
			driver.switchTo().window(string);
		}
		AddItemToCart.click();
	}

}
