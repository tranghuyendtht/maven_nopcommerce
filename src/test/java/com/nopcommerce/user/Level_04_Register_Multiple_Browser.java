package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import pageObjects.nopcommerce.User.UserHomePageObject;
import pageObjects.nopcommerce.User.UserRegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_04_Register_Multiple_Browser extends BaseTest {

	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private WebDriver driver;
	
	private String emailAddress, firstName, lastName, password;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		emailAddress = "automation" + fakeNumber() + "@mail.com";
		firstName = "automation";
		lastName = "FC";
		password = "123456";
		homePage = new UserHomePageObject(driver);
	}

	@Test
	public void TC_01_Register_Empty_Data() {

		System.out.println("HomePage - Step 1: Click to register link");
		homePage.clickToRegisterLink();

		// Sau khi click vào registerlink thì sẽ chuyển tới trang register ==> Khởi tạo
		// trang register
		registerPage = new UserRegisterPageObject(driver);

		System.out.println("RegisterPage - Step 2: Click to register button");
		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getErrorMessageAtFirstNameTextbox(), "First name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtLastNameTextbox(), "Last name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Email is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "Password is required.");

	}

	@Test
	public void TC_02_Register_Invalid_Email() {

		System.out.println("HomePage - Step 1: Click to register link");
		homePage.clickToRegisterLink();
		// Sau khi click vào registerlink thì sẽ chuyển tới trang register ==> Khởi tạo
		// trang register
		registerPage = new UserRegisterPageObject(driver);

		System.out.println("RegisterPage - Step 2: Input to required fields");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox("123@fdsf#@@#$");
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.println("RegisterPage - Step 3: Click to register button");
		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Wrong email");

	}

	@Test
	public void TC_03_Register_Success() {
		System.out.println("HomePage - Step 1: Click to register link");
		homePage.clickToRegisterLink();
		// Sau khi click vào registerlink thì sẽ chuyển tới trang register ==> Khởi tạo
		// trang register
		registerPage = new UserRegisterPageObject(driver);

		System.out.println("RegisterPage - Step 2: Input to required fields");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.println("RegisterPage - Step 3: Click to register button");
		registerPage.clickToRegisterButton();

		System.out.println("RegisterPage - Step 4: Verify success message displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

	}

	@Test
	public void TC_04_Register_Existing_Email() {

		System.out.println("HomePage - Step 1: Click to register link");
		homePage.clickToRegisterLink();
		// Sau khi click vào registerlink thì sẽ chuyển tới trang register ==> Khởi tạo
		// trang register
		registerPage = new UserRegisterPageObject(driver);

		System.out.println("RegisterPage - Step 2: Input to required fields");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.println("RegisterPage - Step 3: Click to register button");
		registerPage.clickToRegisterButton();

		System.out.println("RegisterPage - Step 4: Verify success message displayed");
		Assert.assertEquals(registerPage.getErrorExistingEmailMessage(), "The specified email already exists");

	}

	@Test
	public void TC_05_Register_Password_Less_Than_6_Chars() {

		System.out.println("HomePage - Step 1: Click to register link");
		homePage.clickToRegisterLink();
		// Sau khi click vào registerlink thì sẽ chuyển tới trang register ==> Khởi tạo
		// trang register
		registerPage = new UserRegisterPageObject(driver);

		System.out.println("RegisterPage - Step 2: Input to required fields");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox("123");
		registerPage.inputToConfirmPasswordTextbox("123");

		System.out.println("RegisterPage - Step 3: Click to register button");
		registerPage.clickToRegisterButton();

		System.out.println("RegisterPage - Step 4: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(),
				"Password must meet the following rules:\nmust have at least 6 characters");

	}

	@Test
	public void TC_06_Register_Invalid_Confirm_Password() {

		System.out.println("HomePage - Step 1: Click to register link");
		homePage.clickToRegisterLink();
		// Sau khi click vào registerlink thì sẽ chuyển tới trang register ==> Khởi tạo
		// trang register
		registerPage = new UserRegisterPageObject(driver);

		System.out.println("RegisterPage - Step 2: Input to required fields");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox("123333");

		System.out.println("RegisterPage - Step 3: Click to register button");
		registerPage.clickToRegisterButton();

		System.out.println("RegisterPage - Step 4: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(),
				"The password and confirmation password do not match.");

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
