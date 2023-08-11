package com.nopcommerce.user;

import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register_End_User;

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
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class Level_16_Share_Class_Data_B extends BaseTest {

	// Register and Login in before class to using data
	WebDriver driver;
	UserHomePageObject homePage;
	UserRegisterPageObject registerPage;
	UserLoginPageObject loginPage;

	String emailAddress;
	String firstName, lastName, password;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		// Register
		log.info("Pre-Condition - Step 01: Click to register link");
		registerPage = homePage.clickToRegisterLink();

		log.info("Pre-Condition - Step 02: Input data " + firstName + " to firstname textbox");
		registerPage.inputToFirstNameTextbox(firstName);

		log.info("Pre-Condition - Step 03: Input data " + lastName + " to lastName textbox");
		registerPage.inputToLastNameTextbox(lastName);

		log.info("Pre-Condition - Step 04: Input data " + emailAddress + " to emailAddress textbox");
		registerPage.inputToEmailTextbox(emailAddress);

		log.info("Pre-Condition - Step 05: Input data " + password + " to password textbox");
		registerPage.inputToPasswordTextbox(password);

		log.info("Pre-Condition - Step 06: Input data " + password + " to confirm password textbox");
		registerPage.inputToConfirmPasswordTextbox(password);

		log.info("Pre-Condition - Step 07: Click to Register Button");
		registerPage.clickToRegisterButton();

		log.info("Pre-Condition - Step 08: Verify result register successfully");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed..");

		// Login
		log.info("Pre-Condition - Step 01: Click to Login Link");
		loginPage = homePage.openLoginPage();

		log.info("Pre-Condition - Step 02: Input to required fields");
		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox(password);

		log.info("Pre-Condition - Step 03: Click to Login Button");
		homePage = loginPage.clickToLoginButton();

		log.info("Pre-Condition - Step 04: Verify success message displayed");
		verifyTrue(homePage.isMyAccountLinkIsDisplay());
	}

	@Test
	public void Search_01() {

	}

	@Test
	public void Search_02() {

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
