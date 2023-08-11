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
import pageObjects.nopcommerce.User.UserComputerProductPageObject;
import pageObjects.nopcommerce.User.UserHomePageObject;
import pageObjects.nopcommerce.User.UserLoginPageObject;
import pageObjects.nopcommerce.User.UserSearchKeywordPageObject;

public class User_Sort_Display_Paging extends BaseTest {

	WebDriver driver;
	UserHomePageObject userHomePage;
	UserLoginPageObject userLoginPage;
	UserComputerProductPageObject userComputerProductPage;
	
	String productNotebooksUrl;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		productNotebooksUrl = "https://demo.nopcommerce.com/notebooks";

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
		userComputerProductPage = userHomePage.clickToLinkTextOnHeaderMenuByText("Computers");
		userComputerProductPage.clickToSubMenuLinkTextOnHeaderMenuByText("Notebooks");
		
		
	}

	//@Test
	public void TC_01_Sort_Name_AZ() {
		log.info("Sort_Name_AZ - Step 01: Select product sort order by name A-Z");
		userComputerProductPage.selectProductSortOrderByName("Name: A to Z");
		
		
		log.info("Sort_Name_AZ - Step 02: Verify product name is sorted");
		verifyTrue(userComputerProductPage.isProductNameSortedAToZ());
		
		
	}

	//@Test
	public void TC_02_Sort_Name_ZA() {
		log.info("Sort_Name_ZA - Step 01: Select product sort order by name A-Z");
		userComputerProductPage.selectProductSortOrderByName("Name: Z to A");
		
		
		log.info("Sort_Name_ZA - Step 02: Verify product name is sorted");
		verifyTrue(userComputerProductPage.isProductNameSortedZToA());

	}

	//@Test
	public void TC_03_Sort_Price_Low_To_High() {
		log.info("Sort_Price_Low_To_High - Step 01: Select product sort order by 'Price: Low to High'");
		userComputerProductPage.selectProductSortOrderByName("Price: Low to High");

		log.info("Sort_Price_Low_To_High - Step 02: Verify product price is sorted");
		verifyTrue(userComputerProductPage.isProductNameSortedLowToHighPrice());
	}

	//@Test
	public void TC_04_Sort_Price_High_To_Low() {
		log.info("Sort_Price_High_To_Low - Step 01: Select product sort order by 'Price: Low to High'");
		userComputerProductPage.selectProductSortOrderByName("Price: High to Low");

		log.info("Sort_Price_High_To_Low - Step 02: Verify product price is sorted");
		verifyTrue(userComputerProductPage.isProductNameSortedHighToLowPrice());

	}

	@Test
	public void TC_05_Display_3_Products() {
		log.info("Display_3_Products - Step 01: Refresh Page");
		userComputerProductPage.navigateToUrlByJS(driver, productNotebooksUrl);
		
		log.info("Display_3_Products - Step 02: Select product page size with 3 records/page");
		userComputerProductPage.selectProductPageSizeWithRecordNumber("3");

		log.info("Display_3_Products - Step 03: Verify product price is sorted");
		verifyTrue(userComputerProductPage.isNumberOfProductDisplayedMatch(3));
		verifyTrue(userComputerProductPage.isNextPageIconDisplayedWhenStayInFirstPage("1"));
		verifyTrue(userComputerProductPage.isPreviousPageIconDisplayedWhenStayInSecondPage("2"));

	}

	@Test
	public void TC_06_Display_6_Products() {

		log.info("Display_6_Products - Step 01: Refresh Page");
		userComputerProductPage.navigateToUrlByJS(driver, productNotebooksUrl);
		
		log.info("Display_6_Products - Step 02: Select product page size with 6 records/page");
		userComputerProductPage.selectProductPageSizeWithRecordNumber("6");

		log.info("Display_6_Products - Step 03: Verify product price is sorted");
		verifyTrue(userComputerProductPage.isNumberOfProductDisplayedMatch(6));
		verifyTrue(userComputerProductPage.isPreviousPagingUndisplayed());
		verifyTrue(userComputerProductPage.isNextPagingUndisplayed());
	}

	@Test
	public void TC_07_Display_9_Products() {
		log.info("Display_9_Products - Step 01: Refresh Page");
		userComputerProductPage.navigateToUrlByJS(driver, productNotebooksUrl);
		
		log.info("Display_9_Products - Step 02: Select product page size with 9 records/page");
		userComputerProductPage.selectProductPageSizeWithRecordNumber("9");

		log.info("Display_9_Products - Step 03: Verify product price is sorted");
		verifyTrue(userComputerProductPage.isNumberOfProductDisplayedMatch(9));
		verifyTrue(userComputerProductPage.isPreviousPagingUndisplayed());
		verifyTrue(userComputerProductPage.isNextPagingUndisplayed());
		
	}


	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

}
