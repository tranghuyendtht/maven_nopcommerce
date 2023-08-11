package com.nopcommerce.user;

import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register_Cookie;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.User.UserHomePageObject;
import pageObjects.nopcommerce.User.UserLoginPageObject;
import pageObjects.nopcommerce.User.UserRegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class User_Login extends BaseTest {

	WebDriver driver;
	UserHomePageObject userHomePage;
	UserRegisterPageObject userRegisterPage;
	UserLoginPageObject userLoginPage;
	String emailAddress;
	String firstName, lastName, password, invalidEmail, notFoundEmail;
	String appUrl;

	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		this.appUrl = appUrl;

		emailAddress = "automation" + fakeNumber() + "@mail.com";
		firstName = "Automation";
		lastName = "FC";
		password = "123456";
		invalidEmail = "12345@123@";
		notFoundEmail = "123xjha@mail.com";

	}

	@Test
	public void Login_001_Empty_Data() {

		log.info("Empty_Data - Step 01: Click to Login link");
		userLoginPage = userHomePage.openLoginPage();

		log.info("Empty_Data - Step 02: Click to Login button");
		userLoginPage.clickToLoginButton();

		log.info("Empty_Data - Step 03: Verify error message at email textbox");
		verifyTrue(userLoginPage.getErrorMessageAtEmailTextbox().equals("Please enter your email"));

	}

	@Test
	public void Login_002_Invalid_Email() {

		log.info("Invalid_Email - Step 01: Refresh page");
		userLoginPage = userHomePage.openLoginPage();

		log.info("Invalid_Email - Step 02: Input to email textbox with value: " + emailAddress);
		userLoginPage.inputToEmailTextbox(invalidEmail);

		log.info("Invalid_Email - Step 03: Input to password textbox with value: " + password);
		userLoginPage.inputToPasswordTextbox(password);

		log.info("Invalid_Email - Step 04: Click to Login Button");
		userLoginPage.clickToLoginButton();

		log.info("Invalid_Email - Step 05: Verify error message at email textbox");
		verifyTrue(userLoginPage.getErrorMessageAtEmailTextbox().equals("Wrong email"));

	}

	@Test
	public void Login_003_Not_Found_Email() {

		log.info("Not_Found_Email - Step 01: Refresh page");
		userLoginPage = userHomePage.openLoginPage();

		log.info("Not_Found_Email - Step 02: Input to email textbox with value: " + notFoundEmail);
		userLoginPage.inputToEmailTextbox(notFoundEmail);

		log.info("Not_Found_Email - Step 03: Input to password textbox with value: " + password);
		userLoginPage.inputToPasswordTextbox(password);

		log.info("Not_Found_Email - Step 04: Click to Login Button");
		userLoginPage.clickToLoginButton();

		log.info("Not_Found_Email - Step 05: Verify error message at email textbox");
		verifyTrue(userLoginPage.getErrorMessageForIncorrectInput().equals(
				"Login was unsuccessful. Please correct the errors and try again.\n" + "No customer account found"));

	}

	@Test
	public void Login_004_Empty_Password() {

		log.info("Empty_Password - Step 01: Refresh page");
		userLoginPage = userHomePage.openLoginPage();

		log.info("Empty_Password - Step 02: Input to email textbox with value: " + emailAddress);
		userLoginPage.inputToEmailTextbox(emailAddress);

		log.info("Empty_Password - Step 03: Click to Login Button");
		userLoginPage.clickToLoginButton();

		log.info("Empty_Password - Step 04: Verify error message at email textbox");
		verifyTrue(userLoginPage.getErrorMessageForIncorrectInput()
				.contains("Login was unsuccessful. Please correct the errors and try again."));

	}

	@Test
	public void Login_005_Invalid_Password() {

		log.info("Invalid_Password - Step 01: Refresh page");
		userLoginPage = userHomePage.openLoginPage();

		log.info("Invalid_Password - Step 02: Input to email textbox with value: " + emailAddress);
		userLoginPage.inputToEmailTextbox(emailAddress);

		log.info("Invalid_Password - Step 03: Input to password textbox with value: " + password);
		userLoginPage.inputToPasswordTextbox("1234555");

		log.info("Invalid_Password - Step 04: Click to Login Button");
		userLoginPage.clickToLoginButton();

		log.info("Invalid_Password - Step 05: Verify error message at email textbox");
		verifyTrue(userLoginPage.getErrorMessageForIncorrectInput()
				.contains("Login was unsuccessful. Please correct the errors and try again."));
		
	}

	@Test
	public void Login_006_Login_Success() {

		log.info("Login_Success - Step 01: Refresh page");
		userLoginPage = userHomePage.openLoginPage();

		log.info("Login_Success - Step 02: Set Cookie and reload page");
		userLoginPage.setCookies(driver, Common_01_Register_Cookie.loggedCookies);

		log.info("Login_Success - Step 03: Refresh page");
		userLoginPage.refreshPage(driver);

		log.info("Login_Success - Step 04: Verify success message displayed");
		verifyTrue(userHomePage.isMyAccountLinkIsDisplay());

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

}
