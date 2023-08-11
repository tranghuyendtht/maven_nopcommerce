package com.nopcommerce.user;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register_Cookie;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.User.UserCustomerInfoPageObject;
import pageObjects.nopcommerce.User.UserHomePageObject;
import pageObjects.nopcommerce.User.UserLoginPageObject;
import pageObjects.nopcommerce.User.UserMyAccountPageObject;
import pageObjects.nopcommerce.User.UserMyProductReviewsPageObject;
import pageObjects.nopcommerce.User.UserProductDetailPageObject;
import pageObjects.nopcommerce.User.UserProductListPageObject;
import pageObjects.nopcommerce.User.UserRegisterPageObject;

public class User_My_Account extends BaseTest {
	WebDriver driver;
	UserHomePageObject userHomePage;
	UserRegisterPageObject userRegisterPage;
	UserLoginPageObject userLoginPage;
	UserMyAccountPageObject userMyAccount;
	UserProductListPageObject userProductList;
	UserProductDetailPageObject userProductDetail;
	UserCustomerInfoPageObject userCustomerInfoPage;
	UserMyProductReviewsPageObject myProductReviews;

	String emailAddress, firstName, newEmail, lastName, password, newFirstName, newLastName, newCompanyName, day, month,
			year;
	String addFirstName, addLastName, addEmail, addCountry, addCity, addAddress1, addPostalCode, addPhoneNumber;
	String newPassword, confirmNewPassword;
	String reviewTitle, reviewBody; 
	int fakeNumber;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		fakeNumber = fakeNumber();
		emailAddress = "automation" + fakeNumber + "@mail.com";
		firstName = "automation";
		newEmail = "edit_automation" + fakeNumber + "@mail.com";
		lastName = "fc";
		password = "123456";
		newFirstName = "Automation";
		newLastName = "FC";
		newCompanyName = "Automation FC";
		day = "1";
		month = "February";
		year = "1988";

		addFirstName = "automation";
		addLastName = "FC" + fakeNumber;
		addEmail = "FC" + fakeNumber + "@mail.com";
		addCountry = "Albania";
		addCity = "HaNoi";
		addAddress1 = "HoanKiem";
		addPostalCode = "100000";
		addPhoneNumber = "03588452134";

		newPassword = "123465";
		confirmNewPassword = "123465";
		reviewTitle = "First review" + fakeNumber;
		reviewBody = "First review bacd" + fakeNumber;
//
//		log.info("Pre-Condition - Step 01: Go to Login page ");
//		userLoginPage = userHomePage.openLoginPage();
//
//		log.info("Pre-Condition - Step 02: Login page ");
//		userLoginPage.setCookies(driver, Common_01_Register_Cookie.loggedCookies);
//
//		log.info("Pre-Condition - Step 03: Refresh page ");
//		userLoginPage.refreshPage(driver);
//		//userHomePage = PageGeneratorManager.getUserHomePage(driver);
//		
//		log.info("Pre-Condition - Step 04: Verify login successfully ");
//		verifyTrue(userHomePage.isMyAccountLinkIsDisplay());
		
		// Register
				System.out.println("Pre-Condition - Step 01: Click to register link ");
				userRegisterPage = userHomePage.clickToRegisterLink();

				System.out.println("Pre-Condition - Step 02: Input data to required fields ");
				userRegisterPage.inputToFirstNameTextbox(firstName);
				userRegisterPage.inputToLastNameTextbox(lastName);
				userRegisterPage.inputToEmailTextbox(emailAddress);
				userRegisterPage.inputToPasswordTextbox(password);
				userRegisterPage.inputToConfirmPasswordTextbox(password);

				System.out.println("Pre-Condition - Step 03: Click to register button ");
				userRegisterPage.clickToRegisterButton();

				System.out.println("Pre-Condition - Step 04: Verify success register message ");
				Assert.assertEquals(userRegisterPage.getRegisterSuccessMessage(), "Your registration completed");

				// Login
				System.out.println("Pre-Condition - Step 05: Click to login link ");
				userLoginPage = userHomePage.openLoginPage();

				System.out.println("Pre-Condition - Step 06: Input data to required fields ");
				userLoginPage.inputToEmailTextbox(emailAddress);
				userLoginPage.inputToPasswordTextbox(password);

				System.out.println("Pre-Condition - Step 07: Click to login button ");
				userHomePage = userLoginPage.clickToLoginButton();

				System.out.println("Pre-Condition - Step 08: Verify successful login message ");
				verifyTrue(userHomePage.isMyAccountLinkIsDisplay());
	}

	@Test
	public void User_My_Account_001_Update_Info() {
		log.info("Update_Info - Step 01: Click to My Account Link");
		userMyAccount = userHomePage.openMyAccountPage(driver);

		log.info("Update_Info - Step 02: Click to Customer Info Link");
		userCustomerInfoPage = userMyAccount.clickToCustomerInfoLink();

		log.info("Update_Info - Step 03: Choose Gender");
		userCustomerInfoPage.clickToGenderRadio();
		
		log.info("Update_Info - Step 04: Input to firstname textbox with value: " + newFirstName);
		userCustomerInfoPage.inputToFirstNameTextbox(newFirstName);

		log.info("Update_Info - Step 05: Input to lastname textbox with value: " + newLastName);
		userCustomerInfoPage.inputToLastNameTextbox(newLastName);

		log.info("Update_Info - Step 06: Select day of birth with value: " + day);
		userCustomerInfoPage.selectDayOfBirth(day);

		log.info("Update_Info - Step 07: Select month of birth with value: " + month);
		userCustomerInfoPage.selectMonthOfBirth(month);

		log.info("Update_Info - Step 08: Select year of birth with value: " + year);
		userCustomerInfoPage.selectYearOfBirth(year);

		log.info("Update_Info - Step 09: Input to email textbox with value: " + newEmail);
		userCustomerInfoPage.inputToEmailTextbox(newEmail);

		log.info("Update_Info - Step 10: Input to company name textbox with value: " + newCompanyName);
		userCustomerInfoPage.inputToCompanyTextbox(newCompanyName);

		log.info("Update_Info - Step 11: Click to save button");
		userCustomerInfoPage.clickToSaveButton();

		log.info("Update_Info - Step 12: Verify result");
		verifyTrue(userCustomerInfoPage.isSuccessMessageDisplayed());
		verifyTrue(userCustomerInfoPage.isGenderIsSelected());
		verifyTrue(userCustomerInfoPage.isFirstNameTextboxIsUpdated(newFirstName));
		verifyTrue(userCustomerInfoPage.isLastNameTextboxIsUpdated(newLastName));
		verifyTrue(userCustomerInfoPage.isDayOfBirthIsUpdated(day));
		verifyTrue(userCustomerInfoPage.isMonthOfBirthIsUpdated(month));
		verifyTrue(userCustomerInfoPage.isYearOfBirthIsUpdated(year));
		verifyTrue(userCustomerInfoPage.isEmailTextboxIsUpdated(newEmail));
		verifyTrue(userCustomerInfoPage.isCompanyTextboxIsUpdated(newCompanyName));

		log.info("Update_Info - Step 13: Close popup");
		userCustomerInfoPage.closePopup();

	}

	@Test
	public void User_My_Account_002_Add_Address() {
		log.info("Update_Info - Step 01: Click to My Account Link");
		userMyAccount = userHomePage.openMyAccountPage(driver);

		log.info("Update_Info - Step 02: Click to Customer Info Link");
		userCustomerInfoPage = userMyAccount.clickToCustomerInfoLink();

		log.info("Add_Address - Step 01: Click to Address Linktext");
		userCustomerInfoPage.clickToAddressLink();
		
		log.info("Add_Address - Step 02: Click to Add new button");
		userCustomerInfoPage.clickToAddNewButton();

		log.info("Add_Address - Step 03: Input data to firstname textbox with value: " + addFirstName);
		userCustomerInfoPage.inputToAddFirstNameTextbox(addFirstName);

		log.info("Add_Address - Step 04: Input data to lastname textbox with value: " + addLastName);
		userCustomerInfoPage.inputToAddLastNameTextbox(addLastName);

		log.info("Add_Address - Step 05: Input data to email textbox with value: " + addEmail);
		userCustomerInfoPage.inputToAddEmailTextbox(addEmail);

		log.info("Add_Address - Step 06: Select Country with value: " + addCountry);
		userCustomerInfoPage.selectToAddCountryDropdownList(addCountry);

		log.info("Add_Address - Step 07: Input data to city textbox with value: " + addCity);
		userCustomerInfoPage.inputToAddCityTextbox(addCity);

		log.info("Add_Address - Step 08: Input data to address 1 textbox with value: " + addAddress1);
		userCustomerInfoPage.inputToAddAdressOneTextbox(addAddress1);

		log.info("Add_Address - Step 09: Input data to address 2 textbox with value: " + addAddress1);
		userCustomerInfoPage.inputToAddAdressOneTextbox(addAddress1);

		log.info("Add_Address - Step 10: Input data to postal code textbox with value: " + addPostalCode);
		userCustomerInfoPage.inputToZipCodePortalTextbox(addPostalCode);

		log.info("Add_Address - Step 11: Input data to phonenumber textbox with value: " + addPhoneNumber);
		userCustomerInfoPage.inputToPhoneNumberTextbox(addPhoneNumber);

		log.info("Add_Address - Step 12: Click to save button");
		userCustomerInfoPage.clickToSaveAddressButton();

		log.info("Add_Address - Step 13: Verify result");
		verifyTrue(userCustomerInfoPage.isTitleIsDisplayed(addFirstName));
		verifyTrue(userCustomerInfoPage.isAddFirstNameTextboxIsUpdated(addFirstName));
		verifyTrue(userCustomerInfoPage.isAddLastNameTextboxIsUpdated(addLastName));
		verifyTrue(userCustomerInfoPage.isAddEmailTextboxIsUpdated(addEmail));
		verifyTrue(userCustomerInfoPage.isAddPhoneTextboxIsUpdated(addPhoneNumber));
		verifyTrue(userCustomerInfoPage.isAddAddress1TextboxIsUpdated(addAddress1));
		verifyTrue(userCustomerInfoPage.isAddCityStateZipTextboxIsUpdated(addCity));
		verifyTrue(userCustomerInfoPage.isAddCityStateZipTextboxIsUpdated(addPostalCode));
		verifyTrue(userCustomerInfoPage.isAddCountryDropdownListIsUpdated(addCountry));
		verifyTrue(userCustomerInfoPage.isSuccessNotiBarIsDisplayed("The new address has been added successfully."));

		log.info("Add_Address - Step 14: Click to close noti bar");
		userCustomerInfoPage.clickToCloseNotiBar();

	}

	@Test
	public void User_My_Account_003_Change_Password() {

		log.info("Change_Password - Step 01: Click to change password link");
		userCustomerInfoPage.clickToChangePasswordLink();

		log.info("Change_Password - Step 02: Input to old password textbox with value: " + password);
		userCustomerInfoPage.inputToOldPasswordTextbox(password);
		
		log.info("Change_Password - Step 03: Input to new password textbox with value: " + newPassword);
		userCustomerInfoPage.inputToNewPasswordTextbox(newPassword);
		
		log.info("Change_Password - Step 04: Input to confirm password textbox with value: " + confirmNewPassword);
		userCustomerInfoPage.inputToConfirmNewPasswordTextbox(confirmNewPassword);

		log.info("Change_Password - Step 05: Click to Change Password button");
		userCustomerInfoPage.clickToChangePasswordButton();

		log.info("Change_Password - Step 06: Verify Successful Notification At Bar");
		verifyTrue(userCustomerInfoPage.getSuccessfulNotificationAtBar());

		log.info("Change_Password - Step 07: Close the bar");
		userCustomerInfoPage.clickToClosePopup();

		log.info("Change_Password - Step 08: Click to  logout link");
		userHomePage = userCustomerInfoPage.clickToLogOutLink();

		log.info("Change_Password - Step 09: Verify register link is displayed");
		verifyTrue(userHomePage.isRegisterLinkIsDisplayed());

		log.info("Change_Password - Step 10: Click to login link");
		userLoginPage = userHomePage.openLoginPage();

		log.info("Change_Password - Step 11: Input to email textbox with value: " + newEmail);
		userLoginPage.inputToEmailTextbox(newEmail);

		log.info("Change_Password - Step 12: Input to password textbox with old value: " + password);
		userLoginPage.inputToPasswordTextbox(password);

		log.info("Change_Password - Step 13: Click to Login button");
		userLoginPage.clickToLoginButton();

		log.info("Change_Password - Step 14: Verify error messsage for incorrect input");
		verifyTrue(userLoginPage.getErrorMessageForIncorrectInput().contains("Login was unsuccessful. Please correct the errors and try again."));

		log.info("Change_Password - Step 15: Refresh page");
		userLoginPage.navigateToUrlByJS(driver, "https://demo.nopcommerce.com/login");

		log.info("Change_Password - Step 16: Input to email textbox with value: " + newEmail);
		userLoginPage.inputToEmailTextbox(newEmail);

		log.info("Change_Password - Step 17: Input to password textbox with new value: " + newPassword);
		userLoginPage.inputToPasswordTextbox(newPassword);

		log.info("Change_Password - Step 18: Click to Login button");
		userHomePage = userLoginPage.clickToLoginButton();

		log.info("Change_Password - Step 19: Verify successful messsage");
		verifyTrue(userHomePage.isWelComePageDisplayed());

	}

	@Test
	public void User_My_Account_004_Create_New_Review() {
		log.info("Create_New_Review - Step 01: Click to My Account link");
		userMyAccount = userHomePage.openMyAccountPage(driver);
		
		log.info("Create_New_Review - Step 02: Click to Computers Link");
		userProductList = userMyAccount.clickToComputerLink();
		
		log.info("Create_New_Review - Step 03: Click to Desktop Link");
		userProductList.clickToDesktopLink();
		
		log.info("Create_New_Review - Step 04: Click to A Product");
		userProductDetail = userProductList.clickToAProduct();
		
		log.info("Create_New_Review - Step 05: Click to Add Your Review");
		userProductDetail.clickToAddYourReview();
		
		log.info("Create_New_Review - Step 06: Input to review title textbox with value: " + reviewTitle);
		userProductDetail.inputToReviewTitleTextbox(reviewTitle);
		
		log.info("Create_New_Review - Step 07: Input to review body textarea with value: " + reviewBody);
		userProductDetail.inputToReviewTextArea(reviewBody);
		
		log.info("Create_New_Review - Step 08: Click to rating checkbox");
		userProductDetail.clickToRatingCheckbox();
		
		log.info("Create_New_Review - Step 09: Click to Add Your Button");
		userProductDetail.clickToAddReviewButton();
		
		log.info("Create_New_Review - Step 10: Verify is Product review added successfully");
		verifyEquals(userProductDetail.getSuccessfulReviewMessage(), "Product review is successfully added.");
		
		log.info("Create_New_Review - Step 11: Click to My Account Link");
		userMyAccount = userProductDetail.openMyAccountPage(driver);
		
		log.info("Create_New_Review - Step 12: Click to my product review link");
		myProductReviews = userMyAccount.clickToMyProductReview();

		log.info("Create_New_Review - Step 13: Veriry After Update Review");
		verifyTrue(myProductReviews.isReviewTitleIsUpdated(reviewTitle));
		verifyTrue(myProductReviews.isReviewBodyIsUpdated(reviewBody));
		
	}

	@AfterClass (alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

}
