package com.skillAssessment.Amazon;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchMobilesAndValidate extends BaseClass {

	@FindBy(xpath= "//input[@id='twotabsearchtextbox']")
	WebElement searchBox;
	
	@FindBy(xpath= "//input[@id='nav-search-submit-button']")
	WebElement submitButton;
	
	@FindBy(xpath= "//span[normalize-space()='1-16 of over 3,000 results for']")
	WebElement resultBar;
	
	@FindBy(xpath= "//span[@class='a-color-state a-text-bold']")
	WebElement searchResult;
	
	@FindBy(xpath= "(//span[@class='a-price-whole'])[4]")
	WebElement productPrice;
	
	@FindBy(xpath= "//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[3]/div/div/div/div/div/div/div/div[2]/div/div/div[1]/h2/a/span")
	WebElement mobileType;
	
	@FindBy(xpath= "//*[@id=\"corePriceDisplay_desktop_feature_div\"]/div[1]/span[2]/span[2]/span[2]")
	////*[@id="corePrice_desktop"]/div/table/tbody/tr[2]/td[2]/span[1]/span[2]
	////*[@id="corePrice_desktop"]/div/table/tbody/tr[2]/td[2]/span[1]/span[2]
	////*[@id="corePriceDisplay_desktop_feature_div"]/div[1]/span[2]/span[2]/span[2]
	WebElement mobilePrice;
	
	public SearchMobilesAndValidate() {
		init();
		PageFactory.initElements(driver, this);
	}
	
	public void searchMobile() {
		searchBox.sendKeys("mobiles");
	}
	
	public void clickSearch() throws InterruptedException {
		submitButton.click();
		Thread.sleep(2000);
	}
	
	public String getResultBarText() {
		return resultBar.getText();
	}
	
	public String getResultText() {
		 return searchResult.getText();
	}
	
	public String getPriceOfMobile() {
		return productPrice.getText();
	}
	
	public void ScrollDown() {
		JavascriptExecutor executor= (JavascriptExecutor) driver;
        executor.executeScript("window.scrollBy(0,500)");
	}
	
	public void clickMobile() throws InterruptedException {
		mobileType.click();
//		Thread.sleep(5000);
//		switchToNewpage();
//		Thread.sleep(7000);
	}
	
	public String getPrice() {
		return mobilePrice.getText();
	}
}


