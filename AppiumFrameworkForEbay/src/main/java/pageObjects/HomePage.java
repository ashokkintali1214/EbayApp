package pageObjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import ebay.AppiumFramework.Log;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage {
	public HomePage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath = "//*[@resource-id='com.amazon.mShop.android.shopping:id/action_bar_home_logo']")
	private WebElement homePageLogo;
	
	@AndroidFindBy(xpath = "//*[@resource-id='com.amazon.mShop.android.shopping:id/rs_search_src_text']")
	private WebElement searchTextfiled;
	
	@AndroidFindBy(xpath ="//*[@resource-id='com.amazon.mShop.android.shopping:id/iss_search_dropdown_item_text']")
	public static WebElement searchDropDown;
	
/*
	@AndroidFindBy(xpath ="//*[@resource-id='com.amazon.mShop.android.shopping:id/loc_ux_update_current_pin_code']")
	private WebElement location;*/
	

	
	/*
	 * Verify Home page is loaded
	 */
	public void verifyHomePageLoaded() {
		try {
		Assert.assertTrue(homePageLogo.isDisplayed(),"HomePage is not loaded");
		Reporter.log("Home page is launched successfully ");
		Log.info("Home page is launched successfully ");
		}catch(Exception e) {
			Assert.fail("Failed to verify home page is loaded "+ e.getMessage());
		}
	}
	
	/*
	 * Perform search on home page
	 */
	public void performSearch(AndroidDriver<AndroidElement> driver, String searchStr) {
		try {
		searchTextfiled.click();
		driver.findElementById("com.amazon.mShop.android.shopping:id/rs_search_src_text").sendKeys(searchStr);
		//searchTextfiled.sendKeys(searchStr);
		Reporter.log("Entered Search text:"+searchStr+" in search filed.");
		Log.info("Entered Search text:"+searchStr+" in search filed.");
		searchDropDown.click();
		Reporter.log("Clicked search results dropdown.");
		Log.info("Clicked search results dropdown.");
		}catch(Exception e) {
			Assert.fail("Failed to Perform search on home page "+ e.getMessage());
		}
	}

	
	
	
}
