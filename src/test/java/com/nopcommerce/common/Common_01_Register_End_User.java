package com.nopcommerce.common;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.User.UserHomePageObject;
import pageObjects.nopcommerce.User.UserRegisterPageObject;

public class Common_01_Register_End_User extends BaseTest {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	UserHomePageObject homePage;
	UserRegisterPageObject registerPage;

	// Init varibale to share connect permission from other class 
	public static String emailAddress,  password;
	private String firstName, lastName;

	@Parameters("browser")
	@BeforeTest (description = "Create new Account for all Classes test")
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		emailAddress = "automation" + fakeNumber() + "@mail.com";
		firstName = "Automation";
		lastName = "FC";
		password = "123456";
		
		// Register
		log.info("Register - Step 01: Click to register link");
		registerPage = homePage.clickToRegisterLink();

		log.info("Register - Step 02: Input data " + firstName + " to firstname textbox");
		registerPage.inputToFirstNameTextbox(firstName);

		log.info("Register - Step 03: Input data " + lastName + " to lastName textbox");
		registerPage.inputToLastNameTextbox(lastName);

		log.info("Register - Step 04: Input data " + emailAddress + " to emailAddress textbox");
		registerPage.inputToEmailTextbox(emailAddress);

		log.info("Register - Step 05: Input data " + password + " to password textbox");
		registerPage.inputToPasswordTextbox(password);

		log.info("Register - Step 06: Input data " + password + " to confirm password textbox");
		registerPage.inputToConfirmPasswordTextbox(password);

		log.info("Register - Step 07: Click to Register Button");
		registerPage.clickToRegisterButton();

		log.info("Register - Step 08: Verify result register successfully");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
		driver.quit();
	}


}
