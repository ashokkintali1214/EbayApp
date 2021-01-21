package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import ebay.AppiumFramework.Log;
import ebay.AppiumFramework.Utilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductDetailPage {
	public ProductDetailPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	@AndroidFindBy(id = "add-to-cart-button")
	private WebElement addToCartCTA;
	
	@AndroidFindBy(xpath = "//*[@resource-id='title_feature_div'] /android.view.View")
	private WebElement deviceTitle;
	
	@AndroidFindBy(xpath = "//*[@resource-id='atfRedesign_priceblock_priceToPay'] /android.view.View")
	private WebElement devicePrice;
	
	@AndroidFindBy(xpath = "//*[@resource-id='hctp-attach-bottom-sheet'] //*[@content-desc='Cart']")
	private WebElement cartCTAOnPopup;
	
	@AndroidFindBy(xpath ="//*[@resource-id='com.amazon.mShop.android.shopping:id/loc_ux_update_current_pin_code']")
	public WebElement location;
	
	@AndroidFindBy(xpath ="//*[@resource-id='title_feature_div']")
	public static WebElement ProdcutName;
	
	@AndroidFindBy(xpath ="//*[@resource-id='atfRedesign_priceblock_priceToPay']")
	public static WebElement ProdcutPrice;
	
	Utilities utils = new Utilities();
	
	/*
	 * Verify Product detail Page loaded
	 */
	public void verifyPDPLoaded(AndroidDriver<AndroidElement> driver) {
		try {
			/*if(location.isDisplayed()) {
				driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
			}*/
		Assert.assertTrue(deviceTitle.isDisplayed(),"Product Detail page is not loaded");
		driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
		Reporter.log("Product Detail page is loaded");
		Log.info("Product Detail page is loaded");
		}catch(Exception e) {
			Assert.fail("Failed to verify Product Detail page"+ e.getMessage());
		}
	}
	
	/*
	 * Click Add to Cart CTA
	 */
	public void clickAddToCartCTA(AndroidDriver<AndroidElement> driver) {
		try {
		utils.scrollToText(driver, "Add to Cart");
		addToCartCTA.click();
		Reporter.log("Clicked on Add to Cart CTA");
		Log.info("Clicked on Add to Cart CTA");
		}catch(Exception e) {
			Assert.fail("Failed to click Add to cart CTA in Product detail page"+ e.getMessage());
		}
	}
	
	/*
	 * Click Cart CTA
	 */
	public void clickCartCTAOnPopup() {
		try {
		cartCTAOnPopup.click();
		Reporter.log("Clicked on Cart CTA at bottom pop up");
		Log.info("Clicked on Cart CTA at bottom pop up");
		}catch(Exception e) {
			Assert.fail("Failed to click cart CTA bottom pop up"+ e.getMessage());
		}
	}
	
	/*
	 * Get Product name in PDP page
	 */
	public String getDeviceNameOnPDPPage() {
		String deviceName = "";
		try {
		deviceName = ProdcutName.getText();
		Reporter.log("Got Device name in Product detail page");
		Log.info("Got Device name in Product detail page");
		}catch(Exception e) {
			Assert.fail("Failed to get device name in Product detail page "+ e.getMessage());
		}
		return deviceName;
	}
	
	/*
	 * Get Product price in Product detail page
	 */
	public String getDevicePriceOnPDPPage() {
		String deviceprice = "";
		try {
		deviceprice = devicePrice.getText();
		Reporter.log("Got Device price in Product detail page");
		Log.info("Got Device price in Product detail page");
		}catch(Exception e) {
			Assert.fail("Failed to get device price in Product detail page "+ e.getMessage());
		}
		return deviceprice;
	}
}