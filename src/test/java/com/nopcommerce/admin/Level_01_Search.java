package com.nopcommerce.admin;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import pageObjects.nopcommerce.Admin.AdminDashboardPageObject;
import pageObjects.nopcommerce.Admin.AdminLoginPageObject;
import pageObjects.nopcommerce.Admin.AdminProductDetailPageObject;
import pageObjects.nopcommerce.Admin.AdminProductPageObject;
import pageObjects.nopcommerce.Admin.PageGeneratorManager;

public class Level_01_Search extends BaseTest {
	AdminLoginPageObject adminLoginPage;
	AdminDashboardPageObject adminDashboardPage;
	AdminProductPageObject adminProductPage;
	AdminProductDetailPageObject adminProductDetailPage;
	WebDriver driver;
	private String username, password, SKU;
	private String keyword;

	@Parameters({ "browser", "url" })
	@BeforeTest
	public void beforeTest(String browserName, String appUrl) {
		log.info("Pre-Condition - Step 01: Navigate to Login Admin Page");
		driver = getBrowserDriver(browserName, appUrl);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);

		username = "admin@yourstore.com";
		password = "admin";
		keyword = "Lenovo";
		SKU = "LE_IC_600";

		log.info("Pre-Condition - Step 02: Login Account Admin");
		adminDashboardPage = adminLoginPage.loginAsAdmin(username, password);

		log.info("Pre-Condition - Step 03: Go to Catalog Menu");
		adminDashboardPage.clickToMenuLinkTextByName(driver, "Catalog");

		log.info("Pre-Condition - Step 04: Go to Sub Menu - Product");
		adminDashboardPage.clickToSubMenuLinkTextByName(driver, "Catalog", "Products");
		adminProductPage = PageGeneratorManager.getAdminProductPage(driver);
	}

	//@Test
	public void Test_01_Search_With_Product_Name() {
		log.info("Test_01 - Step 01: Set keyword to product textbox");
		adminProductPage.setKeywordToProductTextbox(keyword);

		log.info("Test_01 - Step 02: Click to Search Button");
		adminProductPage.clickToButtonSearch();

		log.info("Test_01 - Step 03: Verify result");
		Assert.assertTrue(adminProductPage.isExpectedResultContainedInActualResult("Product name", keyword));
		Assert.assertEquals(adminProductPage.getNumberOfResult(), 2);

	}

	//@Test
	public void Test_02_Search_With_Product_Name_Parent_Category_Unchecked() {
		adminProductPage.refreshPage(driver);
		adminProductPage.sleepInSecond(3);
		
		log.info("Test_02 - Step 01: Set keyword to product textbox");
		adminProductPage.setKeywordToProductTextbox(keyword);

		log.info("Test_02 - Step 02: Select value on category dropdownlist");
		adminProductPage.selectValueOnDropListByID("SearchCategoryId", "Computers");

		log.info("Test_02 - Step 03: Click to Search Button");
		adminProductPage.clickToButtonSearch();

		log.info("Test_02 - Step 04: Verify result");
		Assert.assertEquals(adminProductPage.getNoMatchedResultMessage(), "No data available in table");

	}

	//@Test
	public void Test_03_Search_With_Product_Name_Parent_Category_Checked() {
		adminProductPage.refreshPage(driver);
		adminProductPage.sleepInSecond(3);
		
		log.info("Test_03 - Step 01: Set keyword to product textbox");
		adminProductPage.setKeywordToProductTextbox(keyword);

		log.info("Test_03 - Step 02: Select value on category dropdownlist");
		adminProductPage.selectValueOnDropListByID("SearchCategoryId", "Computers");

		log.info("Test_03 - Step 03: Check to Search SubCategories");
		adminProductPage.checkToSearchSubCategories();

		log.info("Test_03 - Step 04: Click to Search Button");
		adminProductPage.clickToButtonSearch();

		log.info("Test_03 - Step 05: Verify result");
		Assert.assertTrue(adminProductPage.isExpectedResultContainedInActualResult("Product name", keyword));
		Assert.assertEquals(adminProductPage.getNumberOfResult(), 2);
	}

	//@Test
	public void Test_04_Search_With_Product_Name_Child_Category() {
		adminProductPage.refreshPage(driver);
		adminProductPage.sleepInSecond(3);
		
		log.info("Test_04 - Step 01: Set keyword to product textbox");
		adminProductPage.setKeywordToProductTextbox(keyword);

		log.info("Test_03 - Step 02: Select value on category dropdownlist");
		adminProductPage.selectValueOnDropListByID("SearchCategoryId", "Computers >> Desktops");

		log.info("Test_03 - Step 04: Click to Search Button");
		adminProductPage.clickToButtonSearch();

		log.info("Test_03 - Step 05: Verify result");
		Assert.assertTrue(adminProductPage.isExpectedResultContainedInActualResult("Product name", keyword));
		Assert.assertEquals(adminProductPage.getNumberOfResult(), 1);
	}

	//@Test
	public void Test_05_Search_With_Product_Name_Manufacturer() {
		adminProductPage.refreshPage(driver);
		adminProductPage.sleepInSecond(3);
		
		log.info("Test_04 - Step 01: Set keyword to product textbox");
		adminProductPage.setKeywordToProductTextbox(keyword);

		log.info("Test_03 - Step 02: Select value on category dropdownlist");
		adminProductPage.selectValueOnDropListByID("SearchManufacturerId", "Apple");

		log.info("Test_03 - Step 04: Click to Search Button");
		adminProductPage.clickToButtonSearch();

		log.info("Test_02 - Step 04: Verify result");
		Assert.assertEquals(adminProductPage.getNoMatchedResultMessage(), "No data available in table");

	}

	@Test
	public void Test_06_Go_Directly_To_Product_SKU() {
		adminProductPage.refreshPage(driver);
		adminProductPage.sleepInSecond(3);
		
		adminProductPage.setProductSKU(SKU);
		adminProductDetailPage = adminProductPage.goDirectlyToProductSKU(SKU);
		adminProductDetailPage.sleepInSecond(3);
		
		Assert.assertTrue(adminProductDetailPage.getTile().contains("Edit product details - Lenovo IdeaCentre 600 All-in-One PC")); 
		Assert.assertEquals(adminProductDetailPage.getProductName(), "Lenovo IdeaCentre 600 All-in-One PC"); 
		//Assert.assertTrue(adminProductDetailPage.getFullDescription()); 
		Assert.assertEquals(adminProductDetailPage.getSKUInfo(), SKU); 
		//Assert.assertTrue(adminProductDetailPage.getCategories().contains("Computers")); 
		Assert.assertTrue(adminProductDetailPage.isCheckboxCheckedByName("Published"));
		Assert.assertTrue(adminProductDetailPage.isCheckboxCheckedByName("VisibleIndividually"));
		Assert.assertEquals(adminProductDetailPage.getPrice(), "500");
		Assert.assertEquals(adminProductDetailPage.getStockQuantity(), "10000");
		Assert.assertTrue(adminProductDetailPage.isImageDisplayed());
		
		
		
	}

	@AfterTest(alwaysRun = true)
	public void afterTest() {
		closeBrowserDriver();
	}
}
