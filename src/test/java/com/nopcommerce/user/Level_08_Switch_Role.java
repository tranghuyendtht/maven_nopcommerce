package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.Admin.AdminDashboardPageObject;
import pageObjects.nopcommerce.Admin.AdminLoginPageObject;
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

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.concurrent.BackgroundInitializer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_08_Switch_Role extends BaseTest {

	WebDriver driver;
	UserHomePageObject userHomePage;
	UserLoginPageObject userLoginPage;
	AdminLoginPageObject adminLoginPage;
	AdminDashboardPageObject adminDashboardPage;

	String userEmailAddress;
	String userPassword;
	String adminEmailAddress;
	String adminPassword;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		userEmailAddress = "automation123@mail.com";
		userPassword = "automation123@mail.com";
		adminEmailAddress = "admin@yourstore.com";
		adminPassword = "admin";
	}

	@Test
	public void Role_01_User_To_Admin() {

		// Login with role user
		System.out.println("UserLogin - Step 01: Click to Login Link");
		userLoginPage = userHomePage.openLoginPage();

		System.out.println("UserLogin - Step 02: Input to required fields");
		userHomePage = userLoginPage.loginAsUser(userEmailAddress, userPassword);

		System.out.println("UserLogin - Step 04: Verify success message displayed");
		Assert.assertTrue(userHomePage.isMyAccountLinkIsDisplay());

		// Logout role user
		System.out.println("UserLogin - Step 05: Logout User Role");
		userHomePage = userHomePage.clickToLogoutLinkAtUserPage(driver);

		// Login with role admin

		System.out.println("Admin - Step 01: Navigate to admin page url");
		userHomePage.openPageUrl(driver, GlobalConstants.ADMIN_PAGE_URL);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);

		System.out.println("AdminLogin - Step 02: Input to required fields");
		adminDashboardPage = adminLoginPage.loginAsAdmin(adminEmailAddress, adminPassword);
		System.out.println("Admin Role - Step 04: Verify success message displayed");
		Assert.assertTrue(adminDashboardPage.isDashboardTextHeaderDisplayed());

		// Logout role admin
		System.out.println("Admin Role - Step 05: Logout Admin Role");
		adminLoginPage = adminDashboardPage.clickToLogoutLinkAtAdminPage(driver);

	}

	@Test
	public void Role_02_Admin_To_User() {
		// Login with role admin

//		System.out.println("Admin Role - Step 01: Navigate to admin page url");
//		adminLoginPage.openPageUrl(driver, GlobalConstants.ADMIN_PAGE_URL);

		System.out.println("Admin Role - Step 02: Login with admin Email Address and admin Password");
		adminDashboardPage = adminLoginPage.loginAsAdmin(adminEmailAddress, adminPassword);

		System.out.println("Admin Role - Step 03: Veriry Dashboard Header Text is displayed");
		Assert.assertTrue(adminDashboardPage.isDashboardTextHeaderDisplayed());

		System.out.println("Admin Role - Step 04: Logout Admin Role");
		adminLoginPage = adminDashboardPage.clickToLogoutLinkAtAdminPage(driver);

		// Navigate User Role
		System.out.println("User Role - Step 01: Navigate to user page url");
		adminLoginPage.openPageUrl(driver, GlobalConstants.USER_PAGE_URL);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		System.out.println("User Role - Step 02: Login Account as User Role");
		userLoginPage = userHomePage.openLoginPage();
		userHomePage = userLoginPage.loginAsUser(userEmailAddress, userPassword);

		System.out.println("User Role - Step 03: Verify My Account Link is displayed");
		Assert.assertTrue(userHomePage.isMyAccountLinkIsDisplay());

		System.out.println("User Role - Step 04: Logout User Role");
		userHomePage = userHomePage.clickToLogoutLink(driver);

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
