package com.nopcommerce.user;

import org.testng.annotations.Test;
//import com.relevantcodes.extentreports.LogStatus;
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
import reportConfig.ExtentManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import java.lang.reflect.Method;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;


public class Level_15_ExtentReportV2_Screenshort extends BaseTest {

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
	public void User_01_Register_Login(Method method) {

//		ExtentManager.startTest(method.getName(), "User_01_Register_Login");
//		// Register
//		ExtentManager.getTest().log(LogStatus.INFO,"Register - Step 01: Click to register link");
//		registerPage = homePage.clickToRegisterLink();
//
//		ExtentManager.getTest().log(LogStatus.INFO,"Register - Step 02: Input data " + firstName + " to firstname textbox");
//		registerPage.inputToFirstNameTextbox(firstName);
//
//		ExtentManager.getTest().log(LogStatus.INFO,"Register - Step 03: Input data " + lastName + " to lastName textbox");
//		registerPage.inputToLastNameTextbox(lastName);
//
//		ExtentManager.getTest().log(LogStatus.INFO,"Register - Step 04: Input data " + emailAddress + " to emailAddress textbox");
//		registerPage.inputToEmailTextbox(emailAddress);
//
//		ExtentManager.getTest().log(LogStatus.INFO,"Register - Step 05: Input data " + password + " to password textbox");
//		registerPage.inputToPasswordTextbox(password);
//
//		ExtentManager.getTest().log(LogStatus.INFO,"Register - Step 06: Input data " + password + " to confirm password textbox");
//		registerPage.inputToConfirmPasswordTextbox(password);
//
//		ExtentManager.getTest().log(LogStatus.INFO,"Register - Step 07: Click to Register Button");
//		registerPage.clickToRegisterButton();
//
//		ExtentManager.getTest().log(LogStatus.INFO,"Register - Step 08: Verify result register successfully");
//		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
//		
//		ExtentManager.endTest();
	}

	@Test
	public void User_02_Login(Method method) {
		
//		ExtentManager.startTest(method.getName(), "User_02_Login");
//		// Login
//		ExtentManager.getTest().log(LogStatus.INFO,"Login - Step 01: Click to Login Link");
//		loginPage = registerPage.clickToLoginLink();
//
//		ExtentManager.getTest().log(LogStatus.INFO,"Login - Step 02: Input to required fields");
//		loginPage.inputToEmailTextbox(emailAddress);
//		loginPage.inputToPasswordTextbox("123456");
//
//		ExtentManager.getTest().log(LogStatus.INFO,"Login - Step 03: Click to Login Button");
//		homePage = loginPage.clickToLoginButton();
//		
//		ExtentManager.getTest().log(LogStatus.INFO,"Login - Step 04: Verify success message displayed");
//		verifyTrue(homePage.isMyAccountLinkIsDisplay());
//
//		// Customer Info Page
//		ExtentManager.getTest().log(LogStatus.INFO,"Customer-Info - Step 01: Click to My Account Link");
//		myAccountPage = homePage.openMyAccountPage(driver);
//
//		ExtentManager.getTest().log(LogStatus.INFO,"Customer-Info - Step 02: Click to Customer Info Link");
//		customerInfoPage = myAccountPage.openCustomerInfoPage(driver);
//
//		ExtentManager.getTest().log(LogStatus.INFO,"Customer-Info - Step 03: Input data to required fields");
//		customerInfoPage.clickToGenderRadio();
//		customerInfoPage.inputToFirstNameTextbox(newFirstName);
//		customerInfoPage.inputToLastNameTextbox(newLastName);
//		customerInfoPage.selectDayOfBirth(day);
//		customerInfoPage.selectMonthOfBirth(month);
//		customerInfoPage.selectYearOfBirth(year);
//		customerInfoPage.inputToEmailTextbox(newEmail);
//		customerInfoPage.inputToCompanyTextbox(newCompanyName);
//
//		ExtentManager.getTest().log(LogStatus.INFO,"Customer-Info - Step 04: Click to Save Button");
//		customerInfoPage.clickToSaveButton();
//
//		ExtentManager.getTest().log(LogStatus.INFO,"Customer-Info - Step 05: Verify result");
//		Assert.assertTrue(customerInfoPage.isGenderIsSelected());
//		Assert.assertTrue(customerInfoPage.isFirstNameTextboxIsUpdated(newFirstName));
//		Assert.assertTrue(customerInfoPage.isLastNameTextboxIsUpdated(newLastName));
//		Assert.assertTrue(customerInfoPage.isDayOfBirthIsUpdated(day));
//		Assert.assertTrue(customerInfoPage.isMonthOfBirthIsUpdated(month));
//		Assert.assertTrue(customerInfoPage.isYearOfBirthIsUpdated(year));
//		Assert.assertTrue(customerInfoPage.isEmailTextboxIsUpdated(newEmail));
//		Assert.assertTrue(customerInfoPage.isCompanyTextboxIsUpdated(newCompanyName));
//
//		ExtentManager.getTest().log(LogStatus.INFO,"Customer-Info - Step 06: Close popup");
//		customerInfoPage.closePopup();
//		
//		ExtentManager.endTest();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
