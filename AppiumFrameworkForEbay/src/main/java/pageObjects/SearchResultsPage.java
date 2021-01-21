package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import ebay.AppiumFramework.Log;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SearchResultsPage {
	public SearchResultsPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath = "//*[@resource-id='com.amazon.mShop.android.shopping:id/rs_results_count_text']")
	private WebElement resultsCount;
	
	@AndroidFindBy(xpath = "//*[@resource-id='com.amazon.mShop.android.shopping:id/item_title']")
	private List<WebElement> deviceTitle;
	
	@AndroidFindBy(xpath = "//*[@resource-id='com.amazon.mShop.android.shopping:id/rs_results_price']")
	private List<WebElement> devicePrice;	
	
	
	/*
	 * Verify Home page is loaded
	 */
	public void verifySearchResultsPageLoaded() {
		try {
		Assert.assertTrue(resultsCount.isDisplayed(),"Search resutls Page is not loaded");
		Reporter.log("Search resutls page is launched successfully ");
		Log.info("Search resutls page is launched successfully");
		}catch(Exception e) {
			Assert.fail("Failed to verify Search resutls page is loaded "+ e.getMessage());
		}
	}
	
	/*
	 * Click on product in search result page
	 */
	public void clickProductInSearchResultsPage(int productNumber) {
		try {
			if(productNumber==0) {
				productNumber=1;
			}
		deviceTitle.get((productNumber-1)).click();
		Reporter.log("Clicked on product in search result page");
		Log.info("Clicked on product in search result page");
		}catch(Exception e) {
			Assert.fail("Failed to click on product in search result page "+ e.getMessage());
		}
	}
	
	/*
	 * Get Product name in search result page
	 */
	public String getDeviceNameOnSearchResultsPage(int productNumber) {
		String deviceName = "";
		try {
			if(productNumber==0) {
				productNumber=1;
			}
		deviceName = deviceTitle.get((productNumber-1)).getText();
		Reporter.log("Got Device name in search result page");
		Log.info("Got Device name in search result page");
		}catch(Exception e) {
			Assert.fail("Failed to get device name in search result page "+ e.getMessage());
		}
		return deviceName;
	}
	
	/*
	 * Get Product price in search result page
	 */
	public String getDevicePriceOnSearchResultsPage(int productNumber) {
		String deviceprice = "";
		try {
		if(productNumber==0) {
			productNumber=1;
		}
		deviceprice = devicePrice.get((productNumber-1)).getAttribute("content-desc");
		Reporter.log("Got Device price in search result page");
		Log.info("Got Device price in search result page");
		}catch(Exception e) {
			Assert.fail("Failed to get device price in search result page "+ e.getMessage());
		}
		return deviceprice;
	}
	
}