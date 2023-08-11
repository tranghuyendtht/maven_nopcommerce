package pageObjects.nopcommerce.User;

import org.openqa.selenium.WebDriver;

import PageUIs.nopcommerce.user.UserCustomerInfoPageUI;
import commons.BasePage;
import commons.PageGeneratorManager;

public class UserMyAccountPageObject extends BasePage{
	private WebDriver driver;

	public UserMyAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public UserCustomerInfoPageObject clickToCustomerInfoLink() {
		waitForElementClickable(driver, UserCustomerInfoPageUI.CUSTOMER_INFO_LINK);
		clickToElement(driver, UserCustomerInfoPageUI.CUSTOMER_INFO_LINK);
		return PageGeneratorManager.getUserCustomerInfoPage(driver);
	}

	public UserMyProductReviewsPageObject clickToMyProductReview() {
		waitForElementClickable(driver, UserCustomerInfoPageUI.MY_PRODUCT_REVIEW_LINK);
		clickToElement(driver, UserCustomerInfoPageUI.MY_PRODUCT_REVIEW_LINK);
		return PageGeneratorManager.getUserMyProductReviewsPage(driver);
	}

	public UserProductListPageObject clickToComputerLink() {
		waitForElementClickable(driver, UserCustomerInfoPageUI.PRODUCT_LIST_COMPUTERS_LINK);
		clickToElement(driver, UserCustomerInfoPageUI.PRODUCT_LIST_COMPUTERS_LINK);
		return PageGeneratorManager.getUserProductListPageObject(driver);
	}

}
