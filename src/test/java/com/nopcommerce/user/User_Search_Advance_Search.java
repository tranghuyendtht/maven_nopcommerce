package com.nopcommerce.user;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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

import com.nopcommerce.common.Common_01_Register_Cookie;

import commons.BasePage;
import commons.BaseTest;
import pageObjects.nopcommerce.Admin.PageGeneratorManager;
import pageObjects.nopcommerce.User.UserHomePageObject;
import pageObjects.nopcommerce.User.UserLoginPageObject;
import pageObjects.nopcommerce.User.UserSearchKeywordPageObject;

public class User_Search_Advance_Search extends BaseTest {

	WebDriver driver;
	UserHomePageObject userHomePage;
	UserLoginPageObject userLoginPage;
	UserSearchKeywordPageObject userSearchKeywordPage;

	String keywordNoResult, keywordShort, keywordAbsolute, categoryText, manufacturerTextIncorrect,
			manufacturerTextCorrect;
	String emailAddress, firstName, newEmail, lastName, password, newFirstName, newLastName, newCompanyName, day, month,
			year;
	int fakeNumber;
	String searchUrl;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		fakeNumber = fakeNumber();
		lastName = "fc";
		password = "123456";
		keywordNoResult = "macbook pro 2025";
		keywordShort = "lenovo";
		keywordAbsolute = "apple macbook pro";
		categoryText = "Computers";
		manufacturerTextIncorrect = "HP";
		manufacturerTextCorrect = "Apple";
		emailAddress = "automation" + fakeNumber + "@mail.com";
		searchUrl = "https://demo.nopcommerce.com/search";

		log.info("Pre-Condition - Step 01: Go to Login page ");
		userLoginPage = userHomePage.openLoginPage();

		log.info("Pre-Condition - Step 02: Login page ");
		userLoginPage.setCookies(driver, Common_01_Register_Cookie.loggedCookies);

		log.info("Pre-Condition - Step 03: Refresh page ");
		userLoginPage.refreshPage(driver);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("Pre-Condition - Step 04: Verify login successfully ");
		verifyTrue(userHomePage.isMyAccountLinkIsDisplay());

		log.info("Pre-Condition - Step 05: Open 'Search' page on footer page ");
		userSearchKeywordPage = userHomePage.clickToLinkTextOnFooterByText("Search");
	}

	@Test
	public void TC_01_Search_Empty_Data() {

		log.info("Search_Empty_Data - Step 01: Click to 'Search' button");
		userSearchKeywordPage.clickToSearchButton();

		log.info("Search_Empty_Data - Step 02: Verify message 'Search term minimum length is 3 characters' displayed");
		verifyTrue(userSearchKeywordPage.isSearchLengthTermDisplayed());
	}

	@Test
	public void TC_02_Search_Data_Not_Exits() {
		log.info("Search_Data_Not_Exits - Step 01: Refresh page");
		userSearchKeywordPage.navigateToUrlByJS(driver, searchUrl);

		log.info("Search_Data_Not_Exits - Step 02: Input keyword to search textbox with value: " + keywordNoResult); // input[@id='q']
		userSearchKeywordPage.inputToTextboxByIdTextbox(driver, "q", keywordNoResult);

		log.info("Search_Data_Not_Exits - Step 03: Click to 'Search' button");
		userSearchKeywordPage.clickToSearchButton();

		log.info("Search_Data_Not_Exits - Step 04: Verify message 'No products were found' displayed");
		verifyTrue(userSearchKeywordPage.isMessageNoProductFound()); // and

	}

	@Test
	public void TC_03_Search_Product_Name_Relative() {

		log.info("Search_Product_Name_Relative - Step 01: Refresh page");
		userSearchKeywordPage.navigateToUrlByJS(driver, searchUrl);

		log.info("Search_Product_Name_Relative - Step 02: Input keyword to search textbox with value: " + keywordShort);
		userSearchKeywordPage.inputToTextboxByIdTextbox(driver, "q", keywordShort);

		log.info("Search_Product_Name_Relative - Step 03: Click to 'Search' button");
		userSearchKeywordPage.clickToSearchButton();

		log.info("Search_Product_Name_Relative - Step 04: Verify result");
		verifyTrue(userSearchKeywordPage.isResultMatched(keywordShort));
		verifyEquals(userSearchKeywordPage.isNumberOfResultTrue(), 2);

	}

	@Test
	public void TC_04_Search_Product_Name_Absolute() {

		log.info("Search_Product_Name_Absolute - Step 01: Refresh page");
		userSearchKeywordPage.navigateToUrlByJS(driver, searchUrl);

		log.info("Search_Product_Name_Absolute - Step 02: Input keyword to search textbox with value: "
				+ keywordAbsolute);
		userSearchKeywordPage.inputToTextboxByIdTextbox(driver, "q", keywordAbsolute);

		log.info("Search_Product_Name_Absolute - Step 03: Click to 'Search' button");
		userSearchKeywordPage.clickToSearchButton();

		log.info("Search_Product_Name_Absolute - Step 04: Verify result");
		verifyTrue(userSearchKeywordPage.isResultMatched(keywordAbsolute));
		verifyEquals(userSearchKeywordPage.isNumberOfResultTrue(), 1);

	}

	@Test
	public void TC_05_Advanced_Search_Parent_Categories() {

		log.info("Advanced_Search_Parent_Categories - Step 01: Refresh page");
		userSearchKeywordPage.navigateToUrlByJS(driver, searchUrl);

		log.info("Advanced_Search_Parent_Categories - Step 02: Input keyword to search textbox with value: "
				+ keywordAbsolute);
		userSearchKeywordPage.inputToTextboxByIdTextbox(driver, "q", keywordAbsolute);

		log.info("Advanced_Search_Parent_Categories - Step 03: Click to 'Advanced search' checkbox");
		userSearchKeywordPage.clickToAdvancedSearchCheckbox();

		log.info("Advanced_Search_Parent_Categories - Step 04: Select category with value: " + categoryText);
		userSearchKeywordPage.selectCategoryDropdownlistByValue(categoryText);

		log.info("Advanced_Search_Parent_Categories - Step 05: Click to 'Search' button");
		userSearchKeywordPage.clickToSearchButton();

		log.info("Advanced_Search_Parent_Categories - Step 06: Verify message 'No products were found' displayed");
		verifyTrue(userSearchKeywordPage.isMessageNoProductFound());

	}

	@Test
	public void TC_06_Advanced_Search_Sub_Categories() {

		log.info("Advanced_Search_Sub_Categories - Step 01: Refresh page");
		userSearchKeywordPage.navigateToUrlByJS(driver, searchUrl);

		log.info("Advanced_Search_Sub_Categories - Step 02: Input keyword to search textbox with value: "
				+ keywordAbsolute);
		userSearchKeywordPage.inputToTextboxByIdTextbox(driver, "q", keywordAbsolute);

		log.info("Advanced_Search_Sub_Categories - Step 03: Click to 'Advanced search' checkbox");
		userSearchKeywordPage.clickToAdvancedSearchCheckbox();

		log.info("Advanced_Search_Sub_Categories - Step 04: Select category with value: " + categoryText);
		userSearchKeywordPage.selectCategoryDropdownlistByValue(categoryText);

		log.info("Advanced_Search_Sub_Categories - Step 05: Click to sub category checkbox");
		userSearchKeywordPage.clickToSubCategoryCheckbox();

		log.info("Advanced_Search_Sub_Categories - Step 06: Click to 'Search' button");
		userSearchKeywordPage.clickToSearchButton();

		log.info("Advanced_Search_Sub_Categories - Step 07: Verify result");
		verifyTrue(userSearchKeywordPage.isResultMatched(keywordAbsolute));
		verifyEquals(userSearchKeywordPage.isNumberOfResultTrue(), 1);
	}

	@Test
	public void TC_07_Advanced_Search_Incorrect_Manufacturer() {

		log.info("Advanced_Search_Incorrect_Manufacturer - Step 01: Refresh page");
		userSearchKeywordPage.navigateToUrlByJS(driver, searchUrl);

		log.info("Advanced_Search_Incorrect_Manufacturer - Step 02: Input keyword to search textbox with value: "
				+ keywordAbsolute);
		userSearchKeywordPage.inputToTextboxByIdTextbox(driver, "q", keywordAbsolute);

		log.info("Advanced_Search_Incorrect_Manufacturer - Step 03: Click to 'Advanced search' checkbox");
		userSearchKeywordPage.clickToAdvancedSearchCheckbox();

		log.info("Advanced_Search_Incorrect_Manufacturer - Step 04: Select category with value: " + categoryText);
		userSearchKeywordPage.selectCategoryDropdownlistByValue(categoryText);

		log.info("Advanced_Search_Incorrect_Manufacturer - Step 05: Select manufacturer with value: "
				+ manufacturerTextIncorrect);
		userSearchKeywordPage.selectSubCategoryDropdownlistByValue(manufacturerTextIncorrect);

		log.info("Advanced_Search_Sub_Categories - Step 06: Click to 'Search' button");
		userSearchKeywordPage.clickToSearchButton();

		log.info("Advanced_Search_Sub_Categories - Step 07: Verify message 'No products were found' displayed");
		verifyTrue(userSearchKeywordPage.isMessageNoProductFound());

	}

	@Test
	public void TC_08_Advanced_Search_Correct_Manufacturer() {

		log.info("Advanced_Search_Correct_Manufacturer - Step 01: Refresh page");
		userSearchKeywordPage.navigateToUrlByJS(driver, searchUrl);
		
		log.info("Advanced_Search_Correct_Manufacturer - Step 02: Input keyword to search textbox with value: " + keywordAbsolute); 
		userSearchKeywordPage.inputToTextboxByIdTextbox(driver, "q", keywordAbsolute);
		
		log.info("Advanced_Search_Correct_Manufacturer - Step 03: Click to 'Advanced search' checkbox");
		userSearchKeywordPage.clickToAdvancedSearchCheckbox();
		
		log.info("Advanced_Search_Correct_Manufacturer - Step 04: Select category with value: " + categoryText);
		userSearchKeywordPage.selectCategoryDropdownlistByValue(categoryText);
		
		log.info("Advanced_Search_Correct_Manufacturer - Step 05: Select manufacturer with value: " + manufacturerTextCorrect);
		userSearchKeywordPage.selectSubCategoryDropdownlistByValue(manufacturerTextCorrect);
		
		log.info("Advanced_Search_Correct_Manufacturer - Step 06: Click to 'Search' button");
		userSearchKeywordPage.clickToSearchButton();
		
		log.info("Advanced_Search_Sub_Categories - Step 07: Verify message 'No products were found' displayed");
		verifyTrue(userSearchKeywordPage.isMessageNoProductFound());
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

}
