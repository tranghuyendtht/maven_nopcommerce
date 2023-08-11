package com.nopcommerce.user;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register_Cookie;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.User.UserHomePageObject;
import pageObjects.nopcommerce.User.UserLoginPageObject;
import pageObjects.nopcommerce.User.UserRegisterPageObject;

public class Level_16_Share_Class_Data_C_Cookie extends BaseTest {

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

		// Login
		log.info("Pre-Condition - Step 01: Navigate to Login Page");
		loginPage = homePage.openLoginPage();

		log.info("Pre-Condition - Step 02: Set Cookie and reload page");
		loginPage.setCookies(driver, Common_01_Register_Cookie.loggedCookies);
		for (Cookie cookie : Common_01_Register_Cookie.loggedCookies) {
			System.out.println("Cookie at Common Class: " + cookie);
		} 
		loginPage.refreshPage(driver);

		log.info("Pre-Condition - Step 03: Verify success message displayed");
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
		//driver.quit();
	}

}
