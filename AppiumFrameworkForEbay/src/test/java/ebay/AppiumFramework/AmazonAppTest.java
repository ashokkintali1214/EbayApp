package ebay.AppiumFramework;

import java.io.IOException;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import ebay.AppiumFramework.Log;
import ebay.AppiumFramework.TestData;
import ebay.AppiumFramework.base;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.CartPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductDetailPage;
import pageObjects.SearchResultsPage;
import pageObjects.StartPage;

public class AmazonAppTest extends base {
	
	TestData testData = new TestData();

	@Test
	public void testAmazonAPK() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		 service=startServer();
		Log.info("started");
		AndroidDriver<AndroidElement> driver = capabilities("apiDemo");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		StartPage startPage = new StartPage(driver);
		startPage.clickSingin();

		LoginPage loginPage = new LoginPage(driver);
		loginPage.performLogin(driver, testData.mobileNumber,testData.password);

		HomePage homePage = new HomePage(driver);
		homePage.verifyHomePageLoaded();
		homePage.performSearch(driver, testData.searchText);

		SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
		searchResultsPage.verifySearchResultsPageLoaded();
		String deviceName = searchResultsPage.getDeviceNameOnSearchResultsPage(2);
		String devicePrice = searchResultsPage.getDevicePriceOnSearchResultsPage(2);
		searchResultsPage.clickProductInSearchResultsPage(2);

		System.out.print(deviceName + " and " + devicePrice);

		ProductDetailPage pdp = new ProductDetailPage(driver);
		pdp.verifyPDPLoaded(driver);
		String deviceNameInPDP = pdp.getDeviceNameOnPDPPage();
		String devicePriceInPDP = pdp.getDevicePriceOnPDPPage();
		System.out.print(deviceNameInPDP + " and " + devicePriceInPDP);
		pdp.clickAddToCartCTA(driver);

		CartPage cartPage = new CartPage(driver);
		cartPage.verifyCartPageLoaded();

		String deviceNameInCart = cartPage.getDeviceNameOnCartPage();
		String devicePriceInCart = cartPage.getDevicePriceOnCartPage();

		Assert.assertEquals(deviceName, deviceNameInPDP,
				"Device names are not same in Search results page and Product detail page");
		Reporter.log("Device names are same in Search results page and Product detail page");
		Assert.assertEquals(devicePrice, devicePriceInPDP,
				"Device Prices are not same in Search results page and Product detail page");
		Reporter.log("Device Prices are same in Search results page and Product detail page");
		Assert.assertEquals(deviceNameInPDP, deviceNameInCart,
				"Device names are not same in Product detail page and Cart Page");
		Reporter.log("Device names are same in Product detail page and Cart Page");
		Assert.assertEquals(devicePriceInPDP, devicePriceInCart,
				"Device Prices are not same in Product detail page and Cart Page");
		Reporter.log("Device Prices are same in Product detail page and Cart Page");

		driver.closeApp();
		service.stop();
	}

}
