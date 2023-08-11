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

public class Level_16_Share_Class_Data_A extends BaseTest {

	// Using data of Common class
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
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

		emailAddress = Common_01_Register_End_User.emailAddress;
		password = Common_01_Register_End_User.password;
		
		// Login
		log.info("Login - Step 01: Click to Login Link");
		loginPage = homePage.openLoginPage();

		log.info("Login - Step 02: Input to required fields");
		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox(password);

		log.info("Login - Step 03: Click to Login Button");
		homePage = loginPage.clickToLoginButton();

		log.info("Login - Step 04: Verify success message displayed");
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
