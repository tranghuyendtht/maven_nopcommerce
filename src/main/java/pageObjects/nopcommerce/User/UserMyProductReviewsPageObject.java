package pageObjects.nopcommerce.User;

import org.openqa.selenium.WebDriver;

import PageUIs.nopcommerce.user.UserMyProductReviewsPageUI;
import commons.BasePage;

public class UserMyProductReviewsPageObject extends BasePage {
	private WebDriver driver;

	public UserMyProductReviewsPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isReviewTitleIsUpdated(String reviewTitle) {
		waitForAllElementVisible(driver, UserMyProductReviewsPageUI.MY_PRODUCT_REVIEW_TITLE_TEXT);
		return getElementText(driver, UserMyProductReviewsPageUI.MY_PRODUCT_REVIEW_TITLE_TEXT).contains(reviewTitle);
	}

	public boolean isReviewBodyIsUpdated(String reviewBody) {
		waitForAllElementVisible(driver, UserMyProductReviewsPageUI.MY_PRODUCT_REVIEW_BODY_TEXT);
		return getElementText(driver, UserMyProductReviewsPageUI.MY_PRODUCT_REVIEW_BODY_TEXT).contains(reviewBody);
	}
}
