package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.User.UserHomePageObject;
import pageObjects.nopcommerce.User.UserLoginPageObject;
import pageObjects.nopcommerce.User.UserRegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_06_Login_Page_Generator_Manager_III extends BaseTest {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	UserHomePageObject homePage;
	UserRegisterPageObject registerPage;
	UserLoginPageObject loginPage;
	String emailAddress;
	String firstName, lastName, password, invalidEmail, notFoundEmail;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		// 1
		homePage = PageGeneratorManager.getUserHomePage(driver);

		emailAddress = "automation" + fakeNumber() + "@mail.com";
		firstName = "Automation";
		lastName = "FC";
		password = "123456";
		invalidEmail = "12345@123@";
		notFoundEmail = "123xjha@mail.com";

		// Pre-Condition
		System.out.println("Pre-Condition - Step 01: Click to register link");
		registerPage = homePage.clickToRegisterLink();
		System.out.println("Pre-Condition - Step 02: Input to required fields");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.println("Pre-Condition - Step 03: Click to Register Button");
		registerPage.clickToRegisterButton();

		System.out.println("Pre-Condition - Step 04: Verify result register successfully");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
	}

	@Test
	public void Login_001_Empty_Data() {

		System.out.println("HomePage - Step 01: Click to Login Link");
		loginPage = homePage.openLoginPage();
		System.out.println("LoginPage - Step 02: Click to Login Button");
		loginPage.clickToLoginButton();
		System.out.println("LoginPage - Step 03: Verify error message at email textbox");
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");

	}

	@Test
	public void Login_002_Invalid_Email() {
		System.out.println("HomePage - Step 01: Click to Login Link");
		loginPage = homePage.openLoginPage();

		System.out.println("LoginPage - Step 02: Input to required fields");
		loginPage.inputToEmailTextbox(invalidEmail);
		loginPage.inputToPasswordTextbox(password);

		System.out.println("LoginPage - Step 03: Click to Login Button");
		loginPage.clickToLoginButton();

		System.out.println("LoginPage - Step 04: Verify error message at email textbox");
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");
	}

	@Test
	public void Login_003_Not_Found_Email() {
		System.out.println("HomePage - Step 01: Click to Login Link");
		loginPage = homePage.openLoginPage();

		System.out.println("LoginPage - Step 02: Input to required fields");
		loginPage.inputToEmailTextbox(notFoundEmail);
		loginPage.inputToPasswordTextbox(password);

		System.out.println("LoginPage - Step 03: Click to Login Button");
		loginPage.clickToLoginButton();

		System.out.println("LoginPage - Step 04: Verify error message at email textbox");

		Assert.assertEquals(loginPage.getErrorMessageForIncorrectInput(),
				"Login was unsuccessful. Please correct the errors and try again.\n" + "No customer account found");
	}

	@Test
	public void Login_004_Empty_Password() {

		System.out.println("RegisterPage - Step 05: Click to Login Link");
		loginPage = registerPage.clickToLoginLink();

		System.out.println("LoginPage - Step 06: Input to required fields");
		loginPage.inputToEmailTextbox(emailAddress);

		System.out.println("LoginPage - Step 07: Click to Login Button");
		loginPage.clickToLoginButton();

		System.out.println("LoginPage - Step 08: Verify error message for incorrect data input");
		Assert.assertEquals(loginPage.getErrorMessageForIncorrectInput(),
				"Login was unsuccessful. Please correct the errors and try again.\n"
						+ "The credentials provided are incorrect");
	}

	@Test
	public void Login_005_Invalid_Password() {

		// Login

		System.out.println("RegisterPage - Step 05: Click to Login Link");
		loginPage = registerPage.clickToLoginLink();

		System.out.println("LoginPage - Step 06: Input to required fields");
		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox("123000");

		System.out.println("LoginPage - Step 07: Click to Login Button");
		loginPage.clickToLoginButton();

		System.out.println("LoginPage - Step 08: Verify error message for incorrect data input");
		Assert.assertEquals(loginPage.getErrorMessageForIncorrectInput(),
				"Login was unsuccessful. Please correct the errors and try again.\n"
						+ "The credentials provided are incorrect");

	}

	@Test
	public void Login_006_Login_Success() {

		// Login

		System.out.println("RegisterPage - Step 05: Click to Login Link");
		loginPage = registerPage.clickToLoginLink();

		System.out.println("LoginPage - Step 06: Input to required fields");
		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox("123456");

		System.out.println("LoginPage - Step 07: Click to Login Button");
		homePage = loginPage.clickToLoginButton();
		System.out.println("LoginPage - Step 08: Verify success message displayed");
		Assert.assertTrue(homePage.isMyAccountLinkIsDisplay());

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}



}
