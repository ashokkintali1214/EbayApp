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

public class CartPage {
	public CartPage(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	@AndroidFindBy(xpath = "//*[@resource-id='sc-mini-buy-box']")
	private WebElement cartPage;
	
	@AndroidFindBy(xpath = "//*[@resource-id='title_feature_div']")
	private WebElement deviceTitle;
	
	@AndroidFindBy(xpath = "//*[@resource-id='sc-proceed-to-checkout-params-form'] /android.widget.TextView")
	private List<WebElement> devicePrice;

	
	/*
	 * Verify Cart Page loaded
	 */
	public void verifyCartPageLoaded() {
		try {
		Assert.assertTrue(cartPage.isDisplayed(),"Cart page is not loaded");
		Reporter.log("Cart page is loaded");
		Log.info("Cart page is loaded");
		}catch(Exception e) {
			Assert.fail("Failed to verify Cart page"+ e.getMessage());
		}
	}
	
	/*
	 * Get Product name in Cart page
	 */
	public String getDeviceNameOnCartPage() {
		String deviceName = "";
		try {
		deviceName = deviceTitle.getText();
		Reporter.log("Got Device name in cart page");
		Log.info("Got Device name in cart page");
		}catch(Exception e) {
			Assert.fail("Failed to get device name in cart page "+ e.getMessage());
		}
		return deviceName;
	}
	
	/*
	 * Get Product price in Cart page
	 */
	public String getDevicePriceOnCartPage() {
		String deviceprice = "";
		try {
		deviceprice = devicePrice.get(2).getText();
		Reporter.log("Got Device price in Cart page");
		Log.info("Got Device price in Cart page");
		}catch(Exception e) {
			Assert.fail("Failed to get device price in Cart page "+ e.getMessage());
		}
		return deviceprice;
	}

}
