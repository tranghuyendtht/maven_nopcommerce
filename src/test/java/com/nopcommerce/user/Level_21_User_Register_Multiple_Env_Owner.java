package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopcommerce.Admin.AdminDashboardPageObject;
import pageObjects.nopcommerce.Admin.AdminLoginPageObject;
import pageObjects.nopcommerce.Admin.AdminSearchCustomerPageObject;
import pageObjects.nopcommerce.Admin.PageGeneratorManager;
import pageObjects.nopcommerce.User.UserHomePageObject;
import pageObjects.nopcommerce.User.UserRegisterPageObject;
import utilities.Environment;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class Level_21_User_Register_Multiple_Env_Owner extends BaseTest {

	private UserHomePageObject userHomePage;
	private UserRegisterPageObject userRegisterPage;
	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashboardPage;
	private AdminSearchCustomerPageObject adminSearchCustomerPage;
	private WebDriver driver;
	private String errorEmail, emailAddress, firstName, lastName, password, dayOfBirth, monthOfBirth, yearOfBirth,
			companyName, errorPassword;
	private String adminUsername, adminPassword;
	private int fakeNumber;
	Environment env;

	@Parameters({"browser"})
	@BeforeClass
	public void beforeClass(String browserName) {
		log.info("Pre-Condition - Step 01: Go page");
		String environment = System.getProperty("ENV");
		System.out.println("Server name run by command line = " + environment);
		ConfigFactory.setProperty("envName", environment);
		env = ConfigFactory.create(Environment.class);
		
		driver = getBrowserDriver(browserName, env.appUrl());
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		fakeNumber = fakeNumber();
		errorEmail = "automation.com";
		emailAddress = "automation" + fakeNumber + "@mail.com";
		firstName = "automation";
		lastName = "FC";
		password = "123456";
		errorPassword = "123";
		dayOfBirth = "20";
		monthOfBirth = "January";
		yearOfBirth = "1999";
		companyName = "automationFC";

		adminUsername = "admin@yourstore.com";
		adminPassword = "admin";

	}

	@Test
	public void TC_01_Register_Empty_Data() {
		log.info("Register_Empty_Data - Step 01: Click to My Account Link");
		userRegisterPage = userHomePage.clickToRegisterLink();

		log.info("Register_Empty_Data - Step 02: Click to Register Button");
		userRegisterPage.clickToRegisterButton();

		log.info("Register_Empty_Data - Step 03: Verify error message on firstname textbox");
		verifyTrue(userRegisterPage.getErrorMessageAtFirstNameTextbox().equals("First name is required."));

		log.info("Register_Empty_Data - Step 04: Verify error message on lastname textbox");
		verifyTrue(userRegisterPage.getErrorMessageAtLastNameTextbox().equals("Last name is required."));

		log.info("Register_Empty_Data - Step 05: Verify error message on email textbox");
		verifyTrue(userRegisterPage.getErrorMessageAtEmailTextbox().equals("Email is required."));

		log.info("Register_Empty_Data - Step 06: Verify error message on password textbox");
		verifyTrue(userRegisterPage.getErrorMessageAtPasswordTextbox().equals("Password is required."));

		log.info("Register_Empty_Data - Step 07: Verify error message on confirmPassword textbox");
		verifyTrue(userRegisterPage.getErrorMessageAtConfirmPasswordTextbox().equals("Password is required."));

	}

	//@Test
	public void TC_02_Register_Invalid_Email() {
		log.info("Register_Invalid_Email - Step 01: Refresh Page");
		userRegisterPage.refreshPage(driver);

		log.info("Register_Invalid_Email - Step 02: Input to firstName textbox with value: " + firstName);
		userRegisterPage.inputToTextboxByIdTextbox(driver, "FirstName", firstName);

		log.info("Register_Invalid_Email - Step 03: Input to lastname textbox with value: " + lastName);
		userRegisterPage.inputToTextboxByIdTextbox(driver, "LastName", lastName);

		log.info("Register_Invalid_Email - Step 04: Select day of birth with value: " + dayOfBirth);
		userRegisterPage.selectDateOfBirthBySelectName("DateOfBirthDay", dayOfBirth);

		log.info("Register_Invalid_Email - Step 05: Select month of birth with value: " + monthOfBirth);
		userRegisterPage.selectDateOfBirthBySelectName("DateOfBirthMonth", monthOfBirth);

		log.info("Register_Invalid_Email - Step 06: Select year of birth with value: " + yearOfBirth);
		userRegisterPage.selectDateOfBirthBySelectName("DateOfBirthYear", yearOfBirth);

		log.info("Register_Invalid_Email - Step 07: Input wrong email to email textbox with value: " + errorEmail);
		userRegisterPage.inputToTextboxByIdTextbox(driver, "Email", errorEmail);

		log.info("Register_Invalid_Email - Step 08: Input to company name textbox with value: " + companyName);
		userRegisterPage.inputToTextboxByIdTextbox(driver, "Company", companyName);

		log.info("Register_Invalid_Email - Step 09: Input to password textbox with value: " + password);
		userRegisterPage.inputToTextboxByIdTextbox(driver, "Password", password);

		log.info("Register_Invalid_Email - Step 10: Input to confirmPassword textbox with value: " + password);
		userRegisterPage.inputToTextboxByIdTextbox(driver, "ConfirmPassword", password);

		log.info("Register_Invalid_Email - Step 11: Click to Register Button");
		userRegisterPage.clickToRegisterButton();

		log.info("Register_Invalid_Email - Step 12: Verify error message on email textbox");
		verifyTrue(userRegisterPage.isErrorMessageAtEmailTextboxDisplayed());
	}

	@Test
	public void TC_03_Register_Success() {
		log.info("Register_Success - Step 01: Refresh Page");
		userRegisterPage.refreshPage(driver);

		log.info("Register_Success - Step 02: Input to firstName textbox with value: " + firstName);
		userRegisterPage.inputToTextboxByIdTextbox(driver, "FirstName", firstName);

		log.info("Register_Success - Step 03: Input to lastname textbox with value: " + lastName);
		userRegisterPage.inputToTextboxByIdTextbox(driver, "LastName", lastName);

		log.info("Register_Success - Step 04: Select day of birth with value: " + dayOfBirth);
		userRegisterPage.selectDateOfBirthBySelectName("DateOfBirthDay", dayOfBirth);

		log.info("Register_Success - Step 05: Select month of birth with value: " + monthOfBirth);
		userRegisterPage.selectDateOfBirthBySelectName("DateOfBirthMonth", monthOfBirth);

		log.info("Register_Success - Step 06: Select year of birth with value: " + yearOfBirth);
		userRegisterPage.selectDateOfBirthBySelectName("DateOfBirthYear", yearOfBirth);

		log.info("Register_Success - Step 07: Input to email textbox with value: " + emailAddress);
		userRegisterPage.inputToTextboxByIdTextbox(driver, "Email", emailAddress);

		log.info("Register_Success - Step 08: Input to company name textbox with value: " + companyName);
		userRegisterPage.inputToTextboxByIdTextbox(driver, "Company", companyName);

		log.info("Register_Success - Step 09: Input to password textbox with value: " + password);
		userRegisterPage.inputToTextboxByIdTextbox(driver, "Password", password);

		log.info("Register_Success - Step 10: Input to confirmPassword textbox with value: " + password);
		userRegisterPage.inputToTextboxByIdTextbox(driver, "ConfirmPassword", password);

		log.info("Register_Success - Step 11: Click to Register Button");
		userRegisterPage.clickToRegisterButton();

		log.info("Register_Success - Step 12: Verify Success message display");
		verifyTrue(userRegisterPage.getRegisterSuccessMessage().equals("Your registration completed"));

		log.info("Register_Success - Step 13: Switch to admin role");
		userRegisterPage.navigateToUrlByJS(driver, "https://admin-demo.nopcommerce.com");
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);

		log.info("Register_Success - Step 14: Login as Admin Role");
		adminDashboardPage = adminLoginPage.loginAsAdmin(adminUsername, adminPassword);

		log.info("Register_Success - Step 17: Click to Customer Category");
		adminDashboardPage.clickToMenuLinkTextByName(driver, "Customer");
		adminDashboardPage.clickToSubMenuLinkTextByName(driver, "Customers", "Customers");
		adminSearchCustomerPage = PageGeneratorManager.getAdminSearchCustomerPage(driver);

		log.info("Register_Success - Step 20: Search customer with email value: " + emailAddress);
		adminSearchCustomerPage.setToTextboxSearchByID("SearchEmail", emailAddress);

		log.info("Register_Success - Step 21: Clear data on customer role field");
		adminSearchCustomerPage.clearValueOnCustomerRoleField();

		log.info("Register_Success - Step 22: Click to Search Button");
		adminSearchCustomerPage.clickToSearchButton();

		log.info("Register_Success - Step 23: Verify Info");
		verifyTrue(adminSearchCustomerPage.isCustomerCreatedSuccessfully(emailAddress));

		log.info("Register_Success - Step 24: Switch to user role");
		adminSearchCustomerPage.navigateToUrlByJS(driver, "https://demo.nopcommerce.com");
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
	}

	//@Test
	public void TC_04_Register_Existing_Email() {
		log.info("Register_Existing_Email - Step 01: Refresh page");
		userRegisterPage.navigateToUrlByJS(driver, "https://demo.nopcommerce.com/register");

		log.info("Register_Existing_Email - Step 02: Input to firstName textbox with value: " + firstName);
		userRegisterPage.inputToTextboxByIdTextbox(driver, "FirstName", firstName);

		log.info("Register_Existing_Email - Step 03: Input to lastname textbox with value: " + lastName);
		userRegisterPage.inputToTextboxByIdTextbox(driver, "LastName", lastName);

		log.info("Register_Existing_Email - Step 04: Select day of birth with value: " + dayOfBirth);
		userRegisterPage.selectDateOfBirthBySelectName("DateOfBirthDay", dayOfBirth);

		log.info("Register_Existing_Email - Step 05: Select month of birth with value: " + monthOfBirth);
		userRegisterPage.selectDateOfBirthBySelectName("DateOfBirthMonth", monthOfBirth);

		log.info("Register_Existing_Email - Step 06: Select year of birth with value: " + yearOfBirth);
		userRegisterPage.selectDateOfBirthBySelectName("DateOfBirthYear", yearOfBirth);

		log.info("Register_Existing_Email - Step 07: Input to email textbox with value: " + emailAddress);
		userRegisterPage.inputToTextboxByIdTextbox(driver, "Email", emailAddress);

		log.info("Register_Existing_Email - Step 08: Input to company name textbox with value: " + companyName);
		userRegisterPage.inputToTextboxByIdTextbox(driver, "Company", companyName);

		log.info("Register_Existing_Email - Step 09: Input to password textbox with value: " + password);
		userRegisterPage.inputToTextboxByIdTextbox(driver, "Password", password);

		log.info("Register_Existing_Email - Step 10: Input to confirmPassword textbox with value: " + password);
		userRegisterPage.inputToTextboxByIdTextbox(driver, "ConfirmPassword", password);

		log.info("Register_Existing_Email - Step 11: Click to Register Button");
		userRegisterPage.clickToRegisterButton();

		log.info("Register_Existing_Email - Step 12: Verify message 'The specified email already exists' is displayed");
		verifyTrue(userRegisterPage.getErrorExistingEmailMessage().equals("The specified email already exists"));

	}

	//@Test
	public void TC_05_Register_Password_Less_Than_6_Chars() {

		log.info("Register_Password_Less_Than_6_Chars - Step 01: Refresh page");
		userRegisterPage.navigateToUrlByJS(driver, "https://demo.nopcommerce.com/register");
		
		log.info("Register_Password_Less_Than_6_Chars - Step 02: Input to firstName textbox with value: " + firstName);
		userRegisterPage.inputToTextboxByIdTextbox(driver, "FirstName", firstName);

		log.info("Register_Password_Less_Than_6_Chars - Step 03: Input to lastname textbox with value: " + lastName);
		userRegisterPage.inputToTextboxByIdTextbox(driver, "LastName", lastName);

		log.info("Register_Password_Less_Than_6_Chars - Step 04: Select day of birth with value: " + dayOfBirth);
		userRegisterPage.selectDateOfBirthBySelectName("DateOfBirthDay", dayOfBirth);

		log.info("Register_Password_Less_Than_6_Chars - Step 05: Select month of birth with value: " + monthOfBirth);
		userRegisterPage.selectDateOfBirthBySelectName("DateOfBirthMonth", monthOfBirth);

		log.info("Register_Password_Less_Than_6_Chars - Step 06: Select year of birth with value: " + yearOfBirth);
		userRegisterPage.selectDateOfBirthBySelectName("DateOfBirthYear", yearOfBirth);

		log.info("Register_Password_Less_Than_6_Chars - Step 07: Input to email textbox with value: " + emailAddress);
		userRegisterPage.inputToTextboxByIdTextbox(driver, "Email", emailAddress);

		log.info("Register_Password_Less_Than_6_Chars - Step 08: Input to company name textbox with value: "
				+ companyName);
		userRegisterPage.inputToTextboxByIdTextbox(driver, "Company", companyName);

		log.info("Register_Password_Less_Than_6_Chars - Step 09: Input to password textbox with value: " + errorPassword);
		userRegisterPage.inputToTextboxByIdTextbox(driver, "Password", errorPassword);

		log.info("Register_Password_Less_Than_6_Chars - Step 10: Input to confirmPassword textbox with value: "
				+ errorPassword);
		userRegisterPage.inputToTextboxByIdTextbox(driver, "ConfirmPassword", errorPassword);

		log.info("Register_Password_Less_Than_6_Chars - Step 11: Click to Register Button");
		userRegisterPage.clickToRegisterButton();

		log.info(
				"Register_Password_Less_Than_6_Chars - Step 12: Verify message 'must have at least 6 characters' is displayed");
		verifyTrue(userRegisterPage.getErrorMessageAtPasswordTextbox()
				.equals("Password must meet the following rules:\nmust have at least 6 characters"));

	}

	//@Test
	public void TC_06_Register_Invalid_Confirm_Password() {

		log.info("Register_Invalid_Confirm_Password - Step 01: Refresh page");
		userRegisterPage.navigateToUrlByJS(driver, "https://demo.nopcommerce.com/register");

		log.info("Register_Invalid_Confirm_Password - Step 02: Input to firstName textbox with value: " + firstName);
		userRegisterPage.inputToTextboxByIdTextbox(driver, "FirstName", firstName);

		log.info("Register_Invalid_Confirm_Password - Step 03: Input to lastname textbox with value: " + lastName);
		userRegisterPage.inputToTextboxByIdTextbox(driver, "LastName", lastName);

		log.info("Register_Invalid_Confirm_Password - Step 04: Select day of birth with value: " + dayOfBirth);
		userRegisterPage.selectDateOfBirthBySelectName("DateOfBirthDay", dayOfBirth);

		log.info("Register_Invalid_Confirm_Password - Step 05: Select month of birth with value: " + monthOfBirth);
		userRegisterPage.selectDateOfBirthBySelectName("DateOfBirthMonth", monthOfBirth);

		log.info("Register_Invalid_Confirm_Password - Step 06: Select year of birth with value: " + yearOfBirth);
		userRegisterPage.selectDateOfBirthBySelectName("DateOfBirthYear", yearOfBirth);

		log.info("Register_Invalid_Confirm_Password - Step 07: Input to email textbox with value: " + emailAddress);
		userRegisterPage.inputToTextboxByIdTextbox(driver, "Email", emailAddress);

		log.info("Register_Invalid_Confirm_Password - Step 08: Input to company name textbox with value: "
				+ companyName);
		userRegisterPage.inputToTextboxByIdTextbox(driver, "Company", companyName);

		log.info("Register_Invalid_Confirm_Password - Step 09: Input to password textbox with value: " + password);
		userRegisterPage.inputToTextboxByIdTextbox(driver, "Password", password);

		log.info("Register_Invalid_Confirm_Password - Step 10: Input to confirmPassword textbox with value: "
				+ password);
		userRegisterPage.inputToTextboxByIdTextbox(driver, "ConfirmPassword", "123435");

		log.info("Register_Invalid_Confirm_Password - Step 11: Click to Register Button");
		userRegisterPage.clickToRegisterButton();

		log.info(
				"Register_Invalid_Confirm_Password - Step 12: Verify message 'The password and confirmation password do not match' is displayed");
		verifyTrue(userRegisterPage.getErrorMessageAtConfirmPasswordTextbox()
				.equals("The password and confirmation password do not match."));
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

}
