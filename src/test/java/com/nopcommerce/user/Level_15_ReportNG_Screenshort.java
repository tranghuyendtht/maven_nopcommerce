package com.nopcommerce.user;

import org.testng.annotations.Test;


import commons.BasePage;
import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.User.UserAddressPageObject;
import pageObjects.nopcommerce.User.UserBackInStockSubscriptionsPageObject;
import pageObjects.nopcommerce.User.UserChangePasswordPageObject;
import pageObjects.nopcommerce.User.UserCustomerInfoPageObject;
import pageObjects.nopcommerce.User.UserDownloadableProductPageObject;
import pageObjects.nopcommerce.User.UserHomePageObject;
import pageObjects.nopcommerce.User.UserLoginPageObject;
import pageObjects.nopcommerce.User.UserMyAccountPageObject;
import pageObjects.nopcommerce.User.UserMyProductReviewsPageObject;
import pageObjects.nopcommerce.User.UserOrderPageObject;
import pageObjects.nopcommerce.User.UserRegisterPageObject;
import pageObjects.nopcommerce.User.UserRewardPointsPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import static org.testng.Assert.assertTrue;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.concurrent.BackgroundInitializer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;


public class Level_15_ReportNG_Screenshort extends BaseTest {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	UserHomePageObject homePage;
	UserMyAccountPageObject myAccountPage;
	UserRegisterPageObject registerPage;
	UserLoginPageObject loginPage;
	UserCustomerInfoPageObject customerInfoPage;
	UserAddressPageObject addressPage;
	UserOrderPageObject orderPage;
	UserDownloadableProductPageObject downloadProductPage;
	UserBackInStockSubscriptionsPageObject backInStockSubscriptionPage;
	UserRewardPointsPageObject rewardPointsPage;
	UserChangePasswordPageObject changePasspage;
	UserMyProductReviewsPageObject myProductReviewPage;

	String newFirstName = "Automation";
	String newLastName = "FC";
	String newCompanyName = "Automation FC";
	String newEmail = "Automation" + fakeNumber() + "@mail.com";
	String day = "1";
	String month = "February";
	String year = "1988";
	String emailAddress;
	String firstName, lastName, password, invalidEmail, notFoundEmail;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		emailAddress = "automation" + fakeNumber() + "@mail.com";
		firstName = "Automation";
		lastName = "FC";
		password = "123456";
		invalidEmail = "12345@123@";
		notFoundEmail = "123xjha@mail.com";
	}

	@Test
	public void User_01_Register_Login() {

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
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed..");

	}

	@Test
	public void User_02_Login() {
		// Login
		log.info("Login - Step 01: Click to Login Link");
		loginPage = registerPage.clickToLoginLink();

		log.info("Login - Step 02: Input to required fields");
		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox("123456");

		log.info("Login - Step 03: Click to Login Button");
		homePage = loginPage.clickToLoginButton();
		
		log.info("Login - Step 04: Verify success message displayed");
		verifyTrue(homePage.isMyAccountLinkIsDisplay());

		// Customer Info Page
		log.info("Customer-Info - Step 01: Click to My Account Link");
		myAccountPage = homePage.openMyAccountPage(driver);

		log.info("Customer-Info - Step 02: Click to Customer Info Link");
		customerInfoPage = myAccountPage.openCustomerInfoPage(driver);

		log.info("Customer-Info - Step 03: Input data to required fields");
		customerInfoPage.clickToGenderRadio();
		customerInfoPage.inputToFirstNameTextbox(newFirstName);
		customerInfoPage.inputToLastNameTextbox(newLastName);
		customerInfoPage.selectDayOfBirth(day);
		customerInfoPage.selectMonthOfBirth(month);
		customerInfoPage.selectYearOfBirth(year);
		customerInfoPage.inputToEmailTextbox(newEmail);
		customerInfoPage.inputToCompanyTextbox(newCompanyName);

		log.info("Customer-Info - Step 04: Click to Save Button");
		customerInfoPage.clickToSaveButton();

		log.info("Customer-Info - Step 05: Verify result");
		Assert.assertTrue(customerInfoPage.isGenderIsSelected());
		Assert.assertTrue(customerInfoPage.isFirstNameTextboxIsUpdated(newFirstName));
		Assert.assertTrue(customerInfoPage.isLastNameTextboxIsUpdated(newLastName));
		Assert.assertTrue(customerInfoPage.isDayOfBirthIsUpdated(day));
		Assert.assertTrue(customerInfoPage.isMonthOfBirthIsUpdated(month));
		Assert.assertTrue(customerInfoPage.isYearOfBirthIsUpdated(year));
		Assert.assertTrue(customerInfoPage.isEmailTextboxIsUpdated(newEmail));
		Assert.assertTrue(customerInfoPage.isCompanyTextboxIsUpdated(newCompanyName));

		log.info("Customer-Info - Step 06: Close popup");
		customerInfoPage.closePopup();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
