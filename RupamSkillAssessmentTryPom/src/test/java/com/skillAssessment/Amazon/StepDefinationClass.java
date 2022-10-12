package com.skillAssessment.Amazon;

import java.util.ArrayList;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinationClass extends BaseClass {

	String firstprice;
	String secondprice;
	SearchMobilesAndValidate searchMobilePage;
	
	@Given("User is on home Page")
	public void user_is_on_home_Page() {
		searchMobilePage = new SearchMobilesAndValidate();
	}
	
	@When("User search for mobile")
	public void user_search_for_mobile() {
		searchMobilePage.searchMobile();
	}
	
	@When("Click on search icon")
	public void click_on_search_icon() throws InterruptedException {
	   searchMobilePage.clickSearch();
	}

	@Then("Collection of Mobile page is opened")
	public void collection_of_mobile_page_is_opened() {
	   Assert.assertTrue(searchMobilePage.getResultBarText().contains("1-16 of over 3,000 results for"));
	   Assert.assertTrue(searchMobilePage.getResultText().contains("mobiles"));
	}

	@Then("User click on Single mobile")
	public void user_click_on_single_mobile() throws InterruptedException {
		searchMobilePage.ScrollDown();
	 firstprice = searchMobilePage.getPriceOfMobile();
				//System.out.println(searchMobilePage.getPriceOfMobile());
				System.out.println(firstprice);
	    searchMobilePage.clickMobile();
	}

	@Then("That Mobile page is opened")
	public void that_mobile_page_is_opened() {

		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(1));
         secondprice = searchMobilePage.getPrice();
     //   System.out.println(searchMobilePage.getPrice());
        System.out.println(secondprice);
   Assert.assertTrue(secondprice.contains(firstprice)); 
        
      }

}
