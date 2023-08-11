package commons;

import org.openqa.selenium.WebDriver;

import PageUIs.nopcommerce.admin.AdminDashboardPageUI;
import pageObjects.nopcommerce.User.UserProductDetailPageObject;
import pageObjects.nopcommerce.User.UserProductListPageObject;
import pageObjects.nopcommerce.User.UserRecentlyViewedProductsPageObject;
import pageObjects.nopcommerce.User.UserRegisterPageObject;
import pageObjects.nopcommerce.User.UserRewardPointsPageObject;
import pageObjects.nopcommerce.User.UserSearchKeywordPageObject;
import pageObjects.nopcommerce.User.UserShoppingCartPageObject;
import pageObjects.nopcommerce.User.UserWishListPageObject;
import pageObjects.Facebook.LoginPageObject;
import pageObjects.nopcommerce.Admin.AdminDashboardPageObject;
import pageObjects.nopcommerce.Admin.AdminLoginPageObject;
import pageObjects.nopcommerce.Admin.AdminProductPageObject;
import pageObjects.nopcommerce.User.UserAddressPageObject;
import pageObjects.nopcommerce.User.UserBackInStockSubscriptionsPageObject;
import pageObjects.nopcommerce.User.UserChangePasswordPageObject;
import pageObjects.nopcommerce.User.UserCheckoutPageObject;
import pageObjects.nopcommerce.User.UserCompareProductsPageObject;
import pageObjects.nopcommerce.User.UserComputerProductPageObject;
import pageObjects.nopcommerce.User.UserCustomerInfoPageObject;
import pageObjects.nopcommerce.User.UserDownloadableProductPageObject;
import pageObjects.nopcommerce.User.UserHomePageObject;
import pageObjects.nopcommerce.User.UserLoginPageObject;
import pageObjects.nopcommerce.User.UserMyAccountPageObject;
import pageObjects.nopcommerce.User.UserMyProductReviewsPageObject;
import pageObjects.nopcommerce.User.UserOrderPageObject;

public class PageGeneratorManager {
	public static UserHomePageObject getUserHomePage(WebDriver driver) {
		return new UserHomePageObject(driver);
	}

	public static UserLoginPageObject getUserLoginPage(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}

	public static UserRegisterPageObject getUserRegisterPage(WebDriver driver) {
		return new UserRegisterPageObject(driver);
	}

	public static UserCustomerInfoPageObject getUserCustomerInfoPage(WebDriver driver) {
		return new UserCustomerInfoPageObject(driver);
	}

	public static UserAddressPageObject getUserAddressPage(WebDriver driver) {
		return new UserAddressPageObject(driver);
	}

	public static UserOrderPageObject getUserOrderPage(WebDriver driver) {
		return new UserOrderPageObject(driver);
	}

	public static UserDownloadableProductPageObject getUserDownloadableProductPage(WebDriver driver) {
		return new UserDownloadableProductPageObject(driver);
	}

	public static UserBackInStockSubscriptionsPageObject getUserBackInStockSubscriptionsPage(WebDriver driver) {
		return new UserBackInStockSubscriptionsPageObject(driver);
	}

	public static UserRewardPointsPageObject getUserRewardPointsPage(WebDriver driver) {
		return new UserRewardPointsPageObject(driver);
	}

	public static UserChangePasswordPageObject getUserChangePasswordPage(WebDriver driver) {
		return new UserChangePasswordPageObject(driver);
	}

	public static UserMyProductReviewsPageObject getUserMyProductReviewsPage(WebDriver driver) {
		return new UserMyProductReviewsPageObject(driver);
	}

	public static UserProductListPageObject getUserProductListPageObject(WebDriver driver) {
		return new UserProductListPageObject(driver);
	}

	public static UserProductDetailPageObject getUserAProductInfoDetail(WebDriver driver) {
		return new UserProductDetailPageObject(driver);
	}

	public static UserMyAccountPageObject getUserMyAccountPage(WebDriver driver) {
		return new UserMyAccountPageObject(driver);
	}
	
	public static UserSearchKeywordPageObject getUserSearchKeywordPage(WebDriver driver) {
		return new UserSearchKeywordPageObject(driver);
	}
	
	public static UserComputerProductPageObject getUserComputerProductPage(WebDriver driver) {
		return new UserComputerProductPageObject(driver);
	}
	
	public static UserWishListPageObject getUserWishListPage(WebDriver driver) {
		return new UserWishListPageObject(driver);
	}
	
	public static UserShoppingCartPageObject getUserShoppingCartPage(WebDriver driver) {
		return new UserShoppingCartPageObject(driver);
	}
	
	public static UserCompareProductsPageObject getUserCompareProductsPage(WebDriver driver) {
		return new UserCompareProductsPageObject(driver);
	}
	
	public static UserRecentlyViewedProductsPageObject getUserRecentlyViewedProductsPage(WebDriver driver) {
		return new UserRecentlyViewedProductsPageObject(driver);
	}
	
	public static UserCheckoutPageObject getUserCheckoutPage(WebDriver driver) {
		return new UserCheckoutPageObject(driver);
	}
	
	public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}
	
	public static AdminDashboardPageObject getAdminDashboardpage(WebDriver driver) {
		return new AdminDashboardPageObject(driver);
	}

	public static AdminProductPageObject getAdminProductPage(WebDriver driver) {
		return new AdminProductPageObject(driver);
	}
	
	

}
