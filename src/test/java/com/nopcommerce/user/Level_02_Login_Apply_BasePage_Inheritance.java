package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BasePage;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_02_Login_Apply_BasePage_Inheritance extends BasePage {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
	}

	@Test
	public void TC_01_Login_Empty_Data() {

		waitForElementVisible(driver, "//a[@class = 'ico-login']");
		clickToElement(driver, "//a[@class = 'ico-login']");
		waitForElementVisible(driver, "//button[contains(@class,'login-button')]");
		clickToElement(driver, "//button[contains(@class,'login-button')]");

		Assert.assertEquals(getElementText(driver, "//span[@id = 'Email-error']"), "Please enter your email");

	}

	@Test
	public void TC_02_Login_Invalid_Email() {
		clickToElement(driver, "//a[@class = 'ico-login']");

		waitForElementVisible(driver, "//input[@id='Email']");
		sendkeyToElement(driver, "//input[@id='Email']", "12345@123@");
		waitForElementVisible(driver, "//input[@id='Password']");
		sendkeyToElement(driver, "//input[@id='Password']", "123456");
		clickToElement(driver, "//button[contains(@class,'login-button')]");

		Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"), "Wrong email");
	}

	@Test
	public void TC_03_Login_New_Email() {
		clickToElement(driver, "//a[@class = 'ico-login']");

		waitForElementVisible(driver, "//input[@id='Email']");
		sendkeyToElement(driver, "//input[@id='Email']", "123xjha@mail.com");
		waitForElementVisible(driver, "//input[@id='Password']");
		sendkeyToElement(driver, "//input[@id='Password']", "123456");
		clickToElement(driver, "//button[contains(@class,'login-button')]");

		waitForElementVisible(driver, "//div[@class='message-error validation-summary-errors']");
		Assert.assertEquals(getElementText(driver, "//div[@class='message-error validation-summary-errors']"),
				"Login was unsuccessful. Please correct the errors and try again.\n" + "No customer account found");
	}

	@Test
	public void TC_04_Empty_Password() {
		String emailAddress = "automation" + fakeNumber() + "@mail.com";
		// Pre-condition: Register
		clickToElement(driver, "//a[@class = 'ico-register']");
		sendkeyToElement(driver, "//input[@id = 'FirstName']", "automation");
		sendkeyToElement(driver, "//input[@id = 'LastName']", "fc");
		sendkeyToElement(driver, "//input[@id = 'Email']", emailAddress);
		sendkeyToElement(driver, "//input[@id = 'Password']", "123456");
		sendkeyToElement(driver, "//input[@id = 'ConfirmPassword']", "123456");
		clickToElement(driver, "//button[@id = 'register-button']");

		Assert.assertEquals(getElementText(driver, "//div[@class = 'result']"), "Your registration completed");

		// Login
		waitForElementVisible(driver, "//a[@class = 'ico-login']");
		clickToElement(driver, "//a[@class = 'ico-login']");
		waitForElementVisible(driver, "//input[@id='Email']");
		sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
		clickToElement(driver, "//button[contains(@class,'login-button')]");

		Assert.assertEquals(getElementText(driver, "//div[@class = 'message-error validation-summary-errors']"),
				"Login was unsuccessful. Please correct the errors and try again.\n"
						+ "The credentials provided are incorrect");

	}

	@Test
	public void TC_05_Login_Invalid_Password() {
		String emailAdd05 = "automation" + fakeNumber() + "@mail.com";
		// Pre-condition: Register
		clickToElement(driver, "//a[@class = 'ico-register']");
		sendkeyToElement(driver, "//input[@id = 'FirstName']", "automation");
		sendkeyToElement(driver, "//input[@id = 'LastName']", "fc");
		sendkeyToElement(driver, "//input[@id = 'Email']", emailAdd05);
		sendkeyToElement(driver, "//input[@id = 'Password']", "123456");
		sendkeyToElement(driver, "//input[@id = 'ConfirmPassword']", "123456");
		clickToElement(driver, "//button[@id = 'register-button']");
		waitForElementVisible(driver, "//div[@class = 'result']");
		Assert.assertEquals(getElementText(driver, "//div[@class = 'result']"), "Your registration completed");

		// Login

		clickToElement(driver, "//a[@class = 'ico-login']");
		waitForElementVisible(driver, "//input[@id='Email']");
		sendkeyToElement(driver, "//input[@id='Email']", emailAdd05);
		sendkeyToElement(driver, "//input[@id='Password']", "123000");
		clickToElement(driver, "//button[contains(@class,'login-button')]");

		Assert.assertEquals(getElementText(driver, "//div[@class = 'message-error validation-summary-errors']"),
				"Login was unsuccessful. Please correct the errors and try again.\n"
						+ "The credentials provided are incorrect");
	}

	@Test
	public void TC_06_Login_Success() {

		String emailAdd06 = "automation" + fakeNumber() + "@mail.com";
		// Pre-condition: Register
		clickToElement(driver, "//a[@class = 'ico-register']");
		sendkeyToElement(driver, "//input[@id = 'FirstName']", "automation");
		sendkeyToElement(driver, "//input[@id = 'LastName']", "fc");
		sendkeyToElement(driver, "//input[@id = 'Email']", emailAdd06);
		sendkeyToElement(driver, "//input[@id = 'Password']", "123456");
		sendkeyToElement(driver, "//input[@id = 'ConfirmPassword']", "123456");
		clickToElement(driver, "//button[@id = 'register-button']");

		Assert.assertEquals(getElementText(driver, "//div[@class = 'result']"), "Your registration completed");

		// Login

		clickToElement(driver, "//a[@class = 'ico-login']");
		waitForElementVisible(driver, "//input[@id='Email']");
		sendkeyToElement(driver, "//input[@id='Email']", emailAdd06);
		sendkeyToElement(driver, "//input[@id='Password']", "123456");
		clickToElement(driver, "//button[contains(@class,'login-button')]");

		waitForElementVisible(driver, "//div[@class ='topic-block-title']//h2");
		Assert.assertEquals(getElementText(driver, "//div[@class ='topic-block-title']//h2"), "Welcome to our store");
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
