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
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import pageObjects.nopcommerce.User.UserCustomerInfoPageObject;
import pageObjects.nopcommerce.User.UserHomePageObject;
import pageObjects.nopcommerce.User.UserLoginPageObject;
import pageObjects.nopcommerce.User.UserProductDetailPageObject;
import pageObjects.nopcommerce.User.UserProductListPageObject;
import pageObjects.nopcommerce.User.UserRegisterPageObject;

public class Level_05_My_Account_Page_Factory extends BaseTest{
	WebDriver driver;
	UserHomePageObject homePage;
	UserRegisterPageObject registerPage;
	UserLoginPageObject loginPage;
	UserCustomerInfoPageObject customerInfoPage;
	UserProductListPageObject producList;
	UserProductDetailPageObject productDetail;

	String projectPath = System.getProperty("user.dir");
	String emailAddress = "automation" + fakeNumber() + "@mail.com";;
	String firstName = "automation";
	String newEmail = "Automation" + fakeNumber() + "@mail.com";
	String lastName = "fc";
	String password = "123456";
	String confirmPass = "123456";
	String newFirstName = "Automation";
	String newLastName = "FC";
	String newCompanyName = "Automation FC";
	String day = "1";
	String month = "February";
	String year = "1988";

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = new UserHomePageObject(driver);

		// Register
		System.out.println("Pre-Condition - Step 01: Click to register link ");
		homePage.clickToRegisterLink();
		registerPage = new UserRegisterPageObject(driver);

		System.out.println("Pre-Condition - Step 02: Input data to required fields ");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(confirmPass);

		System.out.println("Pre-Condition - Step 03: Click to register button ");
		registerPage.clickToRegisterButton();

		System.out.println("Pre-Condition - Step 04: Verify success register message ");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		// Login
		System.out.println("Pre-Condition - Step 05: Click to login link ");
		homePage.openLoginPage();
		loginPage = new UserLoginPageObject(driver);

		System.out.println("Pre-Condition - Step 06: Input data to required fields ");
		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox(password);

		System.out.println("Pre-Condition - Step 07: Click to login button ");
		loginPage.clickToLoginButton();

		System.out.println("Pre-Condition - Step 08: Verify successful login message ");
		homePage.isWelComePageDisplayed();
	}

	@Test
	public void Customer_Info_001_Update_Info() {

		System.out.println("Customer-Info - Step 01: Click to My Account Link");
		homePage.openMyAccountPage(driver);
		customerInfoPage = new UserCustomerInfoPageObject(driver);
		

		System.out.println("Customer-Info - Step 02: Click to Customer Info Link");
		customerInfoPage.clickToCustomerInfoLink();

		System.out.println("Customer-Info - Step 03: Input data to required fields");
		customerInfoPage.clickToGenderRadio();
		customerInfoPage.inputToFirstNameTextbox(newFirstName);
		customerInfoPage.inputToLastNameTextbox(newLastName);
		customerInfoPage.selectDayOfBirth(day);
		customerInfoPage.selectMonthOfBirth(month);
		customerInfoPage.selectYearOfBirth(year);
		customerInfoPage.inputToEmailTextbox(newEmail);
		customerInfoPage.inputToCompanyTextbox(newCompanyName);

		System.out.println("Customer-Info - Step 04: Click to Save Button");
		customerInfoPage.clickToSaveButton();

		System.out.println("Customer-Info - Step 05: Verify result");
		Assert.assertTrue(customerInfoPage.isGenderIsSelected());
		Assert.assertTrue(customerInfoPage.isFirstNameTextboxIsUpdated(newFirstName));
		Assert.assertTrue(customerInfoPage.isLastNameTextboxIsUpdated(newLastName));
		Assert.assertTrue(customerInfoPage.isDayOfBirthIsUpdated(day));
		Assert.assertTrue(customerInfoPage.isMonthOfBirthIsUpdated(month));
		Assert.assertTrue(customerInfoPage.isYearOfBirthIsUpdated(year));
		Assert.assertTrue(customerInfoPage.isEmailTextboxIsUpdated(newEmail));
		Assert.assertTrue(customerInfoPage.isCompanyTextboxIsUpdated(newCompanyName));

		System.out.println("Customer-Info - Step 06: Close popup");
		customerInfoPage.closePopup();

	}

	@Test
	public void Address_002_Add_Address() {
		String addFirstName = "automation";
		String addLastName = "FC" + fakeNumber();
		String addEmail = "FC" + fakeNumber() + "@mail.com";
		String addCountry = "Albania";
		String addCity = "HaNoi";
		String addAddress1 = "HoanKiem";
		String addPostalCode = "100000";
		String addPhoneNumber = "03588452134";

		homePage.openMyAccountPage(driver);
		customerInfoPage = new UserCustomerInfoPageObject(driver);
		customerInfoPage.clickToAddressLink();
		customerInfoPage.clickToAddNewButton();
		customerInfoPage.inputToAddFirstNameTextbox(addFirstName);
		customerInfoPage.inputToAddLastNameTextbox(addLastName);
		customerInfoPage.inputToAddEmailTextbox(addEmail);
		customerInfoPage.selectToAddCountryDropdownList(addCountry);
		customerInfoPage.inputToAddCityTextbox(addCity);
		customerInfoPage.inputToAddAdressOneTextbox(addAddress1);
		customerInfoPage.inputToAddAdressOneTextbox(addAddress1);
		customerInfoPage.inputToZipCodePortalTextbox(addPostalCode);
		customerInfoPage.inputToPhoneNumberTextbox(addPhoneNumber);
		customerInfoPage.clickToSaveAddressButton();

		// Verify
		Assert.assertTrue(customerInfoPage.isTitleIsDisplayed(addFirstName));
		Assert.assertTrue(customerInfoPage.isAddFirstNameTextboxIsUpdated(addFirstName));
		Assert.assertTrue(customerInfoPage.isAddLastNameTextboxIsUpdated(addLastName));
		Assert.assertTrue(customerInfoPage.isAddEmailTextboxIsUpdated(addEmail));
		Assert.assertTrue(customerInfoPage.isAddPhoneTextboxIsUpdated(addPhoneNumber));
		Assert.assertTrue(customerInfoPage.isAddAddress1TextboxIsUpdated(addAddress1));
		Assert.assertTrue(customerInfoPage.isAddCityStateZipTextboxIsUpdated(addCity));
		Assert.assertTrue(customerInfoPage.isAddCityStateZipTextboxIsUpdated(addPostalCode));
		Assert.assertTrue(customerInfoPage.isAddCountryDropdownListIsUpdated(addCountry));
		Assert.assertTrue(customerInfoPage.isSuccessNotiBarIsDisplayed("The new address has been added successfully."));
		customerInfoPage.clickToCloseNotiBar();
	}

	@Test
	public void Change_Password_003() {
		String newPassword = "123465";
		String confirmNewPassword = "123465";
		System.out.println("Change Password - Step 02: Click to change password link");
		customerInfoPage.clickToChangePasswordLink();
		
		System.out.println("Change Password - Step 03: Input to required fields");
		customerInfoPage.inputToOldPasswordTextbox(password);
		customerInfoPage.inputToNewPasswordTextbox(newPassword);
		customerInfoPage.inputToConfirmNewPasswordTextbox(confirmNewPassword);
		
		System.out.println("Change Password - Step 04: Click to Change Password button");
		customerInfoPage.clickToChangePasswordButton();
		
		System.out.println("Change Password - Step 05: Verify Successful Notification At Bar");
		Assert.assertEquals(customerInfoPage.getSuccessfulNotificationAtBar(),"Password was changed");
		
		System.out.println("Change Password - Step 06: Close the bar");
		customerInfoPage.clickToClosePopup();
		System.out.println("Change Password - Step 07: Click to logout link");
		customerInfoPage.clickToLogOutLink();
		
		System.out.println("Change Password - Step 08: Verify register link is displayed");
		homePage.isRegisterLinkIsDisplayed();

		System.out.println("Change Password - Step 09: Login with old password");
		System.out.println("Change Password - Step 09.1: Click to login link");
		homePage.openLoginPage();
		
		System.out.println("Change Password - Step 09.2: Input to required fields");
		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox(password);
		
		System.out.println("Change Password - Step 09.3: Click to Login button");
		loginPage.clickToLoginButton();
		
		System.out.println("Change Password - Step 09.4: Verify error messsage for incorrect input");
		loginPage.getErrorMessageForIncorrectInput();
		
		System.out.println("Change Password - Step 10: Login with new password");
		System.out.println("Change Password - Step 10.1: Click to Login link");
		homePage.openLoginPage();
		
		System.out.println("Change Password - Step 10.2: Input to required fields");
		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox(newPassword);
		
		System.out.println("Change Password - Step 10.3: Click to Login button");
		loginPage.clickToLoginButton();
		
		System.out.println("Change Password - Step 109.4: Verify successful messsage");
		homePage.isWelComePageDisplayed();
	}

	@Test
	public void My_Product_Views_004_Create_New_Review() {
		String reviewTitle = "First review" + fakeNumber();
		String reviewBody = "First review bacd" + fakeNumber();

		System.out.println("My Account - 01: Click to Computers Link");
		customerInfoPage.clickToComputerLink();
		producList = new UserProductListPageObject(driver);
		
		System.out.println("Product List - 02: Click to Desktop Link");
		producList.clickToDesktopLink();
		System.out.println("Product List - 03: Click to Product Link");
		producList.clickToAProduct();
		
		System.out.println("Product Detail - 04: Click to A Product");
		productDetail = new UserProductDetailPageObject(driver);
		
		System.out.println("Product Detail - 05: Click to Add Your Review");
		productDetail.clickToAddYourReview();
		
		System.out.println("Product Detail - 06: Input to required fields");
		productDetail.inputToReviewTitleTextbox(reviewTitle);
		productDetail.inputToReviewTextArea(reviewBody);
		productDetail.clickToRatingCheckbox();
		
		System.out.println("Product Detail - 07: Click to Add Your Button");
		productDetail.clickToAddReviewButton();
		
		// Verify
		System.out.println("Product Detail - 08: Verify Product review is successfully added");
		Assert.assertEquals(productDetail.getSuccessfulReviewMessage(), "Product review is successfully added.");
		
		System.out.println("HomePage - 09: Click to My Account Link");
		homePage.openMyAccountPage(driver);
		customerInfoPage = new UserCustomerInfoPageObject(driver);
		
		System.out.println("My Account - 10: Click to my product review link");
		customerInfoPage.clickToMyProductReview();
		
		System.out.println("My Account - 10: Veriry After Update Review");
		Assert.assertTrue(customerInfoPage.isReviewTitleIsUpdated(reviewTitle));
		Assert.assertTrue(customerInfoPage.isReviewBodyIsUpdated(reviewBody));

	}


	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int fakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

}
