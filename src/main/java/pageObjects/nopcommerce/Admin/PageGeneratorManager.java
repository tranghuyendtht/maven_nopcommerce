package pageObjects.nopcommerce.Admin;

import org.openqa.selenium.WebDriver;

import pageObjects.nopcommerce.User.UserHomePageObject;

public class PageGeneratorManager {
	
	public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}
	
	public static AdminProductPageObject getAdminProductPage(WebDriver driver) {
		return new AdminProductPageObject(driver);
	}

	public static AdminProductDetailPageObject getAdminProductDetailPage(WebDriver driver) {
		return new AdminProductDetailPageObject(driver);
	}
	public static AdminAddNewCustomerPageObject getAdminAddNewCustomerPage(WebDriver driver) {
		return new AdminAddNewCustomerPageObject(driver);
	}

	public static AdminSearchCustomerPageObject getAdminSearchCustomerPage(WebDriver driver) {
		return new AdminSearchCustomerPageObject(driver);
	}

	public static AdminManageCustomerAddressPageObject getAdminManageCustomerAddressPage(WebDriver driver) {
		return new AdminManageCustomerAddressPageObject(driver);
	}

	public static AdminEditCustomerPageObject getAdminEditCustomerPage(WebDriver driver) {
		return new AdminEditCustomerPageObject(driver);
	}
	
	public static UserHomePageObject getUserHomePage(WebDriver driver) {
		return new UserHomePageObject(driver);
	}
	

}
