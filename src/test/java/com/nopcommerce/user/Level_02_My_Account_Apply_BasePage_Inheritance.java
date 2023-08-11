package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commons.BasePage;

public class Level_02_My_Account_Apply_BasePage_Inheritance extends BasePage {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String emailAddress = "automation" + fakeNumber() + "@mail.com";;
	String firstName = "automation";
	String newEmail = "Automation" + fakeNumber() + "@mail.com";
	String lastName = "fc";
	String password = "123456";
	String confirmPass = "123456";

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
	}

	@BeforeMethod
	public void beforeMethod() {
		
		// Register
		clickToElement(driver, "//a[@class = 'ico-register']");
		sendkeyToElement(driver, "//input[@id = 'FirstName']", firstName);
		sendkeyToElement(driver, "//input[@id = 'LastName']", lastName);
		sendkeyToElement(driver, "//input[@id = 'Email']", emailAddress);
		sendkeyToElement(driver, "//input[@id = 'Password']", password);
		sendkeyToElement(driver, "//input[@id = 'ConfirmPassword']", confirmPass);
		clickToElement(driver, "//button[@id = 'register-button']");

		Assert.assertEquals(getElementText(driver, "//div[@class = 'result']"), "Your registration completed");

		// Login
		clickToElement(driver, "//a[@class = 'ico-login']");
		waitForElementVisible(driver, "//input[@id='Email']");
		sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
		sendkeyToElement(driver, "//input[@id='Password']", password);
		clickToElement(driver, "//button[contains(@class,'login-button')]");

		waitForElementVisible(driver, "//div[@class ='topic-block-title']//h2");
		Assert.assertEquals(getElementText(driver, "//div[@class ='topic-block-title']//h2"), "Welcome to our store");
	}

	//@Test
	public void TC_01_Customer_Info() {
		String newFirstName = "Automation";
		String newLastName = "FC";
		
		String newCompanyName = "Automation FC";

		// Update customer info
		waitForElementVisible(driver, "//a[@class='ico-account']");
		clickToElement(driver, "//a[@class='ico-account']");

		waitForElementVisible(driver, "//div[@class='title']");
		clickToElement(driver, "//a[text()='Customer info']");
		clickToElement(driver, "//input[@id='gender-female']");
		sendkeyToElement(driver, "//input[@id='FirstName']", newFirstName);
		sendkeyToElement(driver, "//input[@id='LastName']", newLastName);

		selectItemInDefaultDropDown(driver, "//select[@name ='DateOfBirthDay']", "1");
		selectItemInDefaultDropDown(driver, "//select[@name ='DateOfBirthMonth']", "February");
		selectItemInDefaultDropDown(driver, "//select[@name ='DateOfBirthYear']", "1998");
		sendkeyToElement(driver, "//input[@id='Email']", newEmail);
		sendkeyToElement(driver, "//input[@id='Company']", newCompanyName);
		clickToElement(driver, "//button[@id='save-info-button']");

		// Verify info
		Assert.assertTrue(
				getElementAtribute(driver, "//input[@id='gender-female']", "checked").equalsIgnoreCase("true"));
		Assert.assertTrue(getElementAtribute(driver, "//input[@id='FirstName']", "value").equals(newFirstName));
		Assert.assertTrue(getElementAtribute(driver, "//input[@id='LastName']", "value").equals(newLastName));
		Assert.assertEquals(getSelectedItemDefaultDropdown(driver, "//select[@name ='DateOfBirthDay']"), "1");
		Assert.assertEquals(getSelectedItemDefaultDropdown(driver, "//select[@name ='DateOfBirthMonth']"), "February");
		Assert.assertEquals(getSelectedItemDefaultDropdown(driver, "//select[@name ='DateOfBirthYear']"), "1998");
		Assert.assertTrue(getElementAtribute(driver, "//input[@id='Email']", "value").equals(newEmail));
		Assert.assertTrue(getElementAtribute(driver, "//input[@id='Company']", "value").equals(newCompanyName));
		
		clickToElement(driver, "//span[@class ='close']");
	}

	//@Test
	public void TC_02_Add_Address() {
		String addFirstName = "automation";
		String addLastName = "FC" + fakeNumber();
		String addEmail = "FC" + fakeNumber() +"@mail.com";
		String addCountry = "Albania";
		String addCity = "HaNoi";
		String addAddress1 = "HoanKiem";
		String addPostalCode = "100000";
		String addPhoneNumber = "03588452134";
	
		waitForElementVisible(driver, "//a[@class='ico-account']");
		clickToElement(driver, "//a[@class='ico-account']");	
		
		waitForElementVisible(driver, "//div[@class ='master-wrapper-content']//a[text()='Addresses']");
		clickToElement(driver, "//div[@class ='master-wrapper-content']//a[text()='Addresses']");
		waitForElementVisible(driver, "//button[contains(@class,'add-address-button')]");
		clickToElement(driver, "//button[contains(@class,'add-address-button')]");
		
		sendkeyToElement(driver, "//input[@id='Address_FirstName']", addFirstName);
		sendkeyToElement(driver, "//input[@id='Address_LastName']", addLastName);
		sendkeyToElement(driver, "//input[@id='Address_Email']", addEmail);
		selectItemInDefaultDropDown(driver, "//select[@id ='Address_CountryId']", addCountry);
		sendkeyToElement(driver, "//input[@id='Address_City']", addCity);
		sendkeyToElement(driver, "//input[@id='Address_PhoneNumber']", addPhoneNumber);
		sendkeyToElement(driver, "//input[@id='Address_Address1']", addAddress1);
		sendkeyToElement(driver, "//input[@id='Address_ZipPostalCode']", addPostalCode);
		
		
		clickToElement(driver, "//button[contains(@class,'save-address-button')]");
		
		// Verify
		waitForElementVisible(driver, "//div[@class='title']");
		Assert.assertTrue(getElementText(driver, "//li[@class = 'name']").contains(addFirstName));
		Assert.assertTrue(getElementText(driver, "//li[@class = 'name']").contains(addLastName));
		Assert.assertTrue(getElementText(driver, "//li[@class = 'email']").contains(addEmail));
		Assert.assertTrue(getElementText(driver, "//li[@class = 'phone']").contains(addPhoneNumber));
		Assert.assertTrue(getElementText(driver, "//li[@class = 'address1']").contains(addAddress1));
		Assert.assertTrue(getElementText(driver, "//li[@class = 'city-state-zip']").contains(addPostalCode));
		Assert.assertTrue(getElementText(driver, "//li[@class = 'city-state-zip']").contains(addCity));
		Assert.assertTrue(getElementText(driver, "//li[@class = 'country']").contains(addCountry));
	}
	
	//@Test
	public void TC_03_Change_Password() {
		String newPassword = "123465";
		String confirmNewPassword = "123465";
		waitForElementVisible(driver, "//a[@class='ico-account']");
		clickToElement(driver, "//a[@class='ico-account']");	
		
		waitForElementVisible(driver, "//div[@class ='master-wrapper-content']//a[text()='Change password']");
		clickToElement(driver, "//div[@class ='master-wrapper-content']//a[text()='Change password']");
		
		sendkeyToElement(driver, "//input[@id='OldPassword']", password);
		sendkeyToElement(driver, "//input[@id='NewPassword']", newPassword);
		sendkeyToElement(driver, "//input[@id='ConfirmNewPassword']", confirmNewPassword);
		clickToElement(driver, "//button[contains(@class,'change-password-button')]");
		
		Assert.assertEquals(getElementText(driver, "//div[@class ='bar-notification success']//p"), "Password was changed");
		clickToElement(driver, "//div[@class ='bar-notification success']//span");
		
		// Logout
		clickToElementByJS(driver, "//a[@class='ico-logout']");
		waitForElementVisible(driver, "//div[@class ='topic-block-title']//h2");
		Assert.assertEquals(getElementText(driver, "//div[@class ='topic-block-title']//h2"), "Welcome to our store");
		
		//Login with old pass
		clickToElement(driver, "//a[@class = 'ico-login']");
		waitForElementVisible(driver, "//input[@id='Email']");
		sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
		sendkeyToElement(driver, "//input[@id='Password']", password);
		clickToElement(driver, "//button[contains(@class,'login-button')]");

		Assert.assertEquals(getElementText(driver, "//div[@class = 'message-error validation-summary-errors']"),
				"Login was unsuccessful. Please correct the errors and try again.\n"
				+ "The credentials provided are incorrect");
		
		// Login with new pass
		
		sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
		sendkeyToElement(driver, "//input[@id='Password']", newPassword);
		clickToElement(driver, "//button[contains(@class,'login-button')]");
		waitForElementVisible(driver, "//div[@class ='topic-block-title']//h2");
		Assert.assertEquals(getElementText(driver, "//div[@class ='topic-block-title']//h2"), "Welcome to our store");

	}
	
	@Test
	public void TC_04_My_Product_Views() {
		String reviewTitle = "First review" + fakeNumber();
		String reviewBody = "First review bacd" + fakeNumber();
		
		clickToElement(driver, "//ul[@class='top-menu notmobile']//a[text()='Computers ']");
		clickToElement(driver, "//h2[@class='title']//a[text()=' Desktops ']");
		clickToElement(driver, "//a[text()='Build your own computer']");
		clickToElement(driver, "//a[text()='Add your review']");
		sendkeyToElement(driver, "//input[@id='AddProductReview_Title']", reviewTitle);
		sendkeyToElement(driver, "//textarea[@id='AddProductReview_ReviewText']", reviewBody);
		checkToCheckboxORRadio(driver, "//input[@id='addproductrating_4']");
		clickToElement(driver, "//button[@name='add-review']");
		Assert.assertEquals(getElementText(driver, "//div[@class='result']"), "Product review is successfully added.");
		
		waitForElementVisible(driver, "//a[@class='ico-account']");
		clickToElement(driver, "//a[@class='ico-account']");	
		waitForElementVisible(driver, "//a[text()='My product reviews']");
		clickToElement(driver, "//a[text()='My product reviews']");	
		
		Assert.assertEquals(getElementText(driver, "//div[@class='review-title']//strong"), reviewTitle);
		Assert.assertEquals(getElementText(driver, "//div[@class='review-text']"), reviewBody);
		
		
		
	}
	

	
	
	@AfterMethod
	public void afterMethod() {

		waitForElementVisible(driver, "//a[@class='ico-logout']");
		clickToElementByJS(driver, "//a[@class='ico-logout']");
		waitForElementVisible(driver, "//div[@class ='topic-block-title']//h2");
		Assert.assertEquals(getElementText(driver, "//div[@class ='topic-block-title']//h2"), "Welcome to our store");

	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}

	public int fakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

}
