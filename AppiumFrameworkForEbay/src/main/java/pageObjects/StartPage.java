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

public class StartPage {
	

	public StartPage(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
		
	@AndroidFindBy(xpath="//*[@resource-id='com.amazon.mShop.android.shopping:id/sign_in_button']")
	private WebElement signInCTA;
	
	/*
	 * Clicking on Already a customer? Sign in CTA
	 */
	public void clickSingin() {
		try {
		signInCTA.click();
		Reporter.log("Clicked on Already a customer? Sign in CTA on launch page ");
		Log.info("Clicked on Already a customer? Sign in CTA on launch page ");
		}catch(Exception e) {
			Assert.fail("Failed to click Already a customer? Sign in CTA on launch page "+ e.getMessage());
		}
	}


}
