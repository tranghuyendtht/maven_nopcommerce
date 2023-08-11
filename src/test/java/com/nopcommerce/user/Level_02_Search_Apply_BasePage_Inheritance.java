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
import org.testng.annotations.Test;

import commons.BasePage;

public class Level_02_Search_Apply_BasePage_Inheritance extends BasePage {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	String firstName = "automation";

	String lastName = "fc";
	String password = "123456";
	String confirmPass = "123456";
	String keywordAbsolute = "apple macbook pro";
	String categoryText = "Computers";
	// String keywordAbsolute = "Thinkpad X1 Carbon";
	String manufacturerTextIncorrect = "HP";
	String manufacturerTextCorrect = "Apple";

	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
	}

	// @BeforeMethod
	public void beforeMethod() {
		String emailAddress = "automation" + fakeNumber() + "@mail.com";

		// Register
		clickToElement(driver, "//a[@class = 'ico-register']");
		sendkeyToElement(driver, "//input[@id = 'FirstName']", firstName);
		sendkeyToElement(driver, "//input[@id = 'LastName']", lastName);
		sendkeyToElement(driver, "//input[@id = 'Email']", emailAddress);
		sendkeyToElement(driver, "//input[@id = 'Password']", password);
		sendkeyToElement(driver, "//input[@id = 'ConfirmPassword']", confirmPass);
		clickToElement(driver, "//button[@id = 'register-button']");

		Assert.assertEquals(getElementText(driver, "//div[@class = 'result']"), "Your registration completed");

		// Login
		waitForElementVisible(driver, "//a[@class = 'ico-login']");
		clickToElement(driver, "//a[@class = 'ico-login']");
		waitForElementVisible(driver, "//input[@id='Email']");
		sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
		sendkeyToElement(driver, "//input[@id='Password']", password);
		clickToElement(driver, "//button[contains(@class,'login-button')]");

		waitForElementVisible(driver, "//div[@class ='topic-block-title']//h2");
		Assert.assertEquals(getElementText(driver, "//div[@class ='topic-block-title']//h2"), "Welcome to our store");
	}

	@Test
	public void TC_01_Search_Empty_Data() {

		waitForElementVisible(driver, "//a[text()='Search']");
		clickToElement(driver, "//a[text()='Search']");

		waitForElementVisible(driver, "//input[@class='search-text']");
		clickToElement(driver, "//button[contains(@class,'search-button')]");

		Assert.assertEquals(getElementText(driver, "//div[@class='warning']"),
				"Search term minimum length is 3 characters");
	}

	@Test
	public void TC_02_Search_Data_Not_Exits() {
		waitForElementVisible(driver, "//a[text()='Search']");
		clickToElement(driver, "//a[text()='Search']");

		sendkeyToElement(driver, "//input[@class='search-text']", "macbook pro 2025");
		clickToElement(driver, "//button[contains(@class,'search-button')]");
		Assert.assertEquals(getElementText(driver, "//div[@class='no-result']"),
				"No products were found that matched your criteria.");

	}

	@Test
	public void TC_03_Search_Product_Name_Relative() {
		String keyword = "lenovo";

		waitForElementVisible(driver, "//a[text()='Search']");
		clickToElement(driver, "//a[text()='Search']");

		sendkeyToElement(driver, "//input[@class='search-text']", keyword);
		clickToElement(driver, "//button[contains(@class,'search-button')]");
		List<WebElement> listTitle = driver
				.findElements(By.xpath("//div[@class = 'product-item']//h2[@class ='product-title']//a"));

		Assert.assertEquals(listTitle.size(), 2);

		for (WebElement webElement : listTitle) {

			Assert.assertTrue(webElement.getText().toLowerCase().contains(keyword));
		}

	}

	@Test
	public void TC_04_Search_Product_Name_Absolute() {

		waitForElementVisible(driver, "//a[text()='Search']");
		clickToElement(driver, "//a[text()='Search']");

		sendkeyToElement(driver, "//input[@class='search-text']", keywordAbsolute);
		clickToElement(driver, "//button[contains(@class,'search-button')]");

		// Chỉ có 1 sp match
		List<WebElement> listTitle = driver
				.findElements(By.xpath("//div[@class = 'product-item']//h2[@class ='product-title']//a"));
		Assert.assertEquals(listTitle.size(), 1);

		// Độ chính xác về tên
		Assert.assertTrue(listTitle.get(0).getText().toLowerCase().contains(keywordAbsolute));
	}

	@Test
	public void TC_05_Advanced_Search_Parent_Categories() {

		waitForElementVisible(driver, "//a[text()='Search']");
		clickToElement(driver, "//a[text()='Search']");

		sendkeyToElement(driver, "//input[@class='search-text']", keywordAbsolute);
		clickToElement(driver, "//input[@id='advs']");
		selectItemInDefaultDropDown(driver, "//select[@id='cid']", categoryText);
		clickToElement(driver, "//button[contains(@class,'search-button')]");

		Assert.assertEquals(getElementText(driver, "//div[@class='no-result']"),
				"No products were found that matched your criteria.");
	}

	@Test
	public void TC_06_Advanced_Search_Sub_Categories() {

		waitForElementVisible(driver, "//a[text()='Search']");
		clickToElement(driver, "//a[text()='Search']");

		sendkeyToElement(driver, "//input[@class='search-text']", keywordAbsolute);
		clickToElement(driver, "//input[@id='advs']");
		selectItemInDefaultDropDown(driver, "//select[@id='cid']", categoryText);
		clickToElement(driver, "//input[@id='isc']");
		clickToElement(driver, "//button[contains(@class,'search-button')]");

		// Chỉ có 1 sp match
		List<WebElement> listTitle = driver
				.findElements(By.xpath("//div[@class = 'product-item']//h2[@class ='product-title']//a"));
		Assert.assertEquals(listTitle.size(), 1);

		// Độ chính xác về tên
		Assert.assertTrue(listTitle.get(0).getText().toLowerCase().contains(keywordAbsolute));
	}

	@Test
	public void TC_07_Advanced_Search_Incorrect_Manufacturer() {

		waitForElementVisible(driver, "//a[text()='Search']");
		clickToElement(driver, "//a[text()='Search']");

		sendkeyToElement(driver, "//input[@class='search-text']", keywordAbsolute);
		clickToElement(driver, "//input[@id='advs']");
		selectItemInDefaultDropDown(driver, "//select[@id='cid']", categoryText);
		clickToElement(driver, "//input[@id='isc']");
		selectItemInDefaultDropDown(driver, "//select[@id='mid']", manufacturerTextIncorrect);
		clickToElement(driver, "//button[contains(@class,'search-button')]");

		Assert.assertEquals(getElementText(driver, "//div[@class='no-result']"),
				"No products were found that matched your criteria.");
	}

	@Test
	public void TC_08_Advanced_Search_Correct_Manufacturer() {

		waitForElementVisible(driver, "//a[text()='Search']");
		clickToElement(driver, "//a[text()='Search']");

		sendkeyToElement(driver, "//input[@class='search-text']", keywordAbsolute);
		clickToElement(driver, "//input[@id='advs']");
		selectItemInDefaultDropDown(driver, "//select[@id='cid']", categoryText);
		clickToElement(driver, "//input[@id='isc']");
		selectItemInDefaultDropDown(driver, "//select[@id='mid']", manufacturerTextCorrect);
		clickToElement(driver, "//button[contains(@class,'search-button')]");

		// Chỉ có 1 sp match
		List<WebElement> listTitle = driver
				.findElements(By.xpath("//div[@class = 'product-item']//h2[@class ='product-title']//a"));
		Assert.assertEquals(listTitle.size(), 1);

		// Độ chính xác về tên
		Assert.assertTrue(listTitle.get(0).getText().toLowerCase().contains(keywordAbsolute));
	}

//	@AfterMethod
	public void afterMethod() {

		waitForElementVisible(driver, "//a[@class='ico-logout']");
		clickToElementByJS(driver, "//a[@class='ico-logout']");
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
