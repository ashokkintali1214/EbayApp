package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import ebay.AppiumFramework.Log;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage {
	public WebDriverWait wait;
	
	public LoginPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}


	@AndroidFindBy(xpath = "//*[@resource-id='ap_email_login']")
	private WebElement emailOrMobileNumberTextField;
	
	@AndroidFindBy(xpath = "//*[@text='Continue']")
	private WebElement continueCTA;
	
	@AndroidFindBy(xpath = "//*[@resource-id='ap_password']")
	private WebElement passwordField;
	
	@AndroidFindBy(xpath = "//*[@resource-id='signInSubmit']")
	private WebElement loginCTA;

	
	/*
	 * Performing login in login page
	 */
	public void performLogin(AndroidDriver<AndroidElement> driver, String mobileNumber, String pwd) {
		try {
		emailOrMobileNumberTextField.click();
		driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
	//	driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
		emailOrMobileNumberTextField.sendKeys(mobileNumber);
		
		Reporter.log("Entered Mobile number:"+mobileNumber+" in Mobile number or email field.");
		Log.info("Entered Mobile number:"+mobileNumber+" in Mobile number or email field.");
//		Thread.sleep(2000);
		continueCTA.click();
		Reporter.log("Clicked on Continue CTA");
		Log.info("Clicked on Continue CTA");
		passwordField.click();
		driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
	//	driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
		passwordField.sendKeys(pwd);
		
		Reporter.log("Entered Password :"+pwd+" in Password field.");
		Log.info("Entered Password :"+pwd+" in Password field.");
		loginCTA.click();
		Reporter.log("Clicked on login CTA");
		Log.info("Clicked on login CTA");
		
		}catch(Exception e) {
			Assert.fail("Faield to Performing login in login page"+e.getMessage());
		}
	}

}
