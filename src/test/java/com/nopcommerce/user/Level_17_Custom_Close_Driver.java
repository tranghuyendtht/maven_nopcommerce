package com.nopcommerce.user;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;
import com.nopcommerce.common.Common_01_Register_Cookie;

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
import org.testng.annotations.Parameters;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class Level_17_Custom_Close_Driver extends BaseTest {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	UserHomePageObject homePage;
	UserMyAccountPageObject myAccountPage;
	UserRegisterPageObject registerPage;
	UserLoginPageObject loginPage;
	UserCustomerInfoPageObject customerInfoPage;

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

		// Login
		log.info("Pre-Condition - Step 01: Navigate to Login Page");
		loginPage = homePage.openLoginPage();

		log.info("Pre-Condition - Step 02: Set Cookie and reload page");
		loginPage.setCookies(driver, Common_01_Register_Cookie.loggedCookies);
		for (Cookie cookie : Common_01_Register_Cookie.loggedCookies) {
			System.out.println("Cookie at Common Class: " + cookie);
		}
		loginPage.refreshPage(driver);
		homePage = loginPage.getUserHomePage(driver);
		
		log.info("Pre-Condition - Step 03: Verify success message displayed");
		verifyTrue(homePage.isMyAccountLinkIsDisplay());
		System.out.println("Homepage is here---------------------");
	}

	@Test
	public void TC_Create_Account_Info() {

		// Customer Info Page
		log.info("Customer-Info - Step 01: Click to My Account Link");
		myAccountPage = homePage.openMyAccountPage(driver);

		log.info("Customer-Info - Step 02: Click to Customer Info Link");
		customerInfoPage = myAccountPage.openCustomerInfoPage(driver);

		log.info("Customer-Info - Step 03: Input data to required fields");
		customerInfoPage.clickToGenderRadio();
		customerInfoPage.inputToFirstNameTextbox(newFirstName);
		customerInfoPage.inputToLastNameTextbox(newLastName);
		driver = null;
		customerInfoPage.selectDayOfBirth(day);
		customerInfoPage.selectMonthOfBirth(month);
		customerInfoPage.selectYearOfBirth(year);
		customerInfoPage.inputToEmailTextbox(newEmail);
		customerInfoPage.inputToCompanyTextbox(newCompanyName);
	
		log.info("Customer-Info - Step 04: Click to Save Button");
		customerInfoPage.clickToSaveButton();

		log.info("Customer-Info - Step 05: Verify result");
		verifyTrue(customerInfoPage.isGenderIsSelected());
		verifyTrue(customerInfoPage.isFirstNameTextboxIsUpdated(newFirstName));
		verifyTrue(customerInfoPage.isLastNameTextboxIsUpdated(newLastName));
		verifyTrue(customerInfoPage.isDayOfBirthIsUpdated(day));
		verifyTrue(customerInfoPage.isMonthOfBirthIsUpdated(month));
		verifyTrue(customerInfoPage.isYearOfBirthIsUpdated(year));
		verifyTrue(customerInfoPage.isEmailTextboxIsUpdated(newEmail));
		verifyTrue(customerInfoPage.isCompanyTextboxIsUpdated(newCompanyName));

		log.info("Customer-Info - Step 06: Close popup");
		customerInfoPage.closePopup();
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

}
