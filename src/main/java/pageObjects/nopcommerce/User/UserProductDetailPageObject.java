package pageObjects.nopcommerce.User;

import org.openqa.selenium.WebDriver;

import PageUIs.nopcommerce.user.UserProductDetailUI;
import PageUIs.nopcommerce.user.UserShoppingCartPageUI;
import commons.BasePage;
import commons.PageGeneratorManager;

public class UserProductDetailPageObject extends BasePage{
	private WebDriver driver;
	
	public UserProductDetailPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToAddYourReview() {
		waitForElementClickable(driver, UserProductDetailUI.ADD_YOUR_REVIEW_LINK);
		clickToElement(driver, UserProductDetailUI.ADD_YOUR_REVIEW_LINK);
	}

	public void inputToReviewTitleTextbox(String reviewTitle) {
		waitForElementVisible(driver, UserProductDetailUI.REVIEW_TITLE_TEXTBOX);
		sendkeyToElement(driver, UserProductDetailUI.REVIEW_TITLE_TEXTBOX, reviewTitle);
	}

	public void inputToReviewTextArea(String reviewBody) {
		waitForElementVisible(driver, UserProductDetailUI.REVIEW_BODY_TEXTAREA);
		sendkeyToElement(driver, UserProductDetailUI.REVIEW_BODY_TEXTAREA, reviewBody);
		
	}

	public void clickToRatingCheckbox() {
		waitForElementClickable(driver, UserProductDetailUI.PRODUCT_RATING_CHECKBOX);
		clickToElement(driver, UserProductDetailUI.PRODUCT_RATING_CHECKBOX);
		
	}

	public void clickToAddReviewButton() {
		waitForElementClickable(driver, UserProductDetailUI.ADD_REVIEW_BUTTON);
		clickToElement(driver, UserProductDetailUI.ADD_REVIEW_BUTTON);
		
	}

	public String getSuccessfulReviewMessage() {
		waitForElementVisible(driver, UserProductDetailUI.REVIEW_SUCCESS_MESSAGE);
		return getElementText(driver, UserProductDetailUI.REVIEW_SUCCESS_MESSAGE);
	}

	public void clickToAddToWishlistButton() {
		waitForElementClickable(driver, UserProductDetailUI.ADD_TO_WISHLISH_BUTTON);
		clickToElement(driver, UserProductDetailUI.ADD_TO_WISHLISH_BUTTON);
		
	}

	public String isSuccessMessageDisplayed() {
		waitForElementVisible(driver, UserProductDetailUI.ADDED_SUCCESS_MESSAGE);
		return getElementText(driver, UserProductDetailUI.ADDED_SUCCESS_MESSAGE);
	}

	public UserWishListPageObject clickToWishlistLinkText() {
		waitForElementClickable(driver, UserProductDetailUI.WISHLIST_LINKTEXT);
		clickToElement(driver, UserProductDetailUI.WISHLIST_LINKTEXT);
		return PageGeneratorManager.getUserWishListPage(driver);
	}

	public String getProductSKU() {
		waitForElementVisible(driver, UserProductDetailUI.SKU_PRODUCT);
		return getElementText(driver, UserProductDetailUI.SKU_PRODUCT);
	}

	public String getProductPrice() {
		waitForElementVisible(driver, UserProductDetailUI.PRICE_PRODUCT);
		return getElementText(driver, UserProductDetailUI.PRICE_PRODUCT);
	}

	public void clickToAddToCartButton() {
		waitForElementClickable(driver, UserProductDetailUI.ADD_TO_CART_BUTTON);
		clickToElement(driver, UserProductDetailUI.ADD_TO_CART_BUTTON);
		
	}

	public boolean isAddedProductIntoCartMessageDisplayed() {
		waitForElementVisible(driver, UserProductDetailUI.ADDED_SUCCESS_MESSAGE);
		return isElementDisplayed(driver, UserProductDetailUI.ADDED_SUCCESS_MESSAGE);
	}

	public void clickToCloseIcon() {
		waitForElementClickable(driver, UserProductDetailUI.CLOSE_ICON);
		clickToElement(driver, UserProductDetailUI.CLOSE_ICON);
		sleepInSecond(1);
	}

	public String isMessageProductNameAddedIntoCartDisplayed() {
		hoverMouseToElement(driver, UserProductDetailUI.SHOPPING_CART_LINKTEXT);
		waitForElementVisible(driver, UserProductDetailUI.ADDED_MESSAGE_ON_TOOLTIPS);
		return getElementText(driver, UserProductDetailUI.ADDED_MESSAGE_ON_TOOLTIPS);
	}

	public String isProductNameAddedIntoCart() {
		hoverMouseToElement(driver, UserProductDetailUI.SHOPPING_CART_LINKTEXT);
		waitForElementVisible(driver, UserProductDetailUI.PRODUCT_NAME_ON_TOOLTIPS);
		return getElementText(driver, UserProductDetailUI.PRODUCT_NAME_ON_TOOLTIPS);
	}

	public String isProductPriceAddedIntoCart() {
		hoverMouseToElement(driver, UserProductDetailUI.SHOPPING_CART_LINKTEXT);
		waitForElementVisible(driver, UserProductDetailUI.PRODUCT_PRICE_ON_TOOLTIPS);
		return getElementText(driver, UserProductDetailUI.PRODUCT_PRICE_ON_TOOLTIPS);
	}

	public String isProductQuantityAddedIntoCart() {
		hoverMouseToElement(driver, UserProductDetailUI.SHOPPING_CART_LINKTEXT);
		waitForElementVisible(driver, UserProductDetailUI.PRODUCT_QUANTITY_ON_TOOLTIPS);
		return getElementText(driver, UserProductDetailUI.PRODUCT_QUANTITY_ON_TOOLTIPS);
	}

	public boolean isProductSubTotalDisplayed(String productPrice, String productQuantity ) {
		boolean pass = true;
		hoverMouseToElement(driver, UserProductDetailUI.SHOPPING_CART_LINKTEXT);
		waitForElementVisible(driver, UserProductDetailUI.PRODUCT_TOTAL_ON_TOOLTIPS);
		String subTotal = getElementText(driver, UserProductDetailUI.PRODUCT_TOTAL_ON_TOOLTIPS);
		
		int subTotalF = Integer.valueOf(subTotal.replaceAll("[^A-Za-z0-9]",""));
		int productPriceF = Integer.valueOf(productPrice.replaceAll("[^A-Za-z0-9]",""));
		int productQuantityI = Integer.valueOf(productQuantity);
		if(subTotalF == productPriceF*productQuantityI) {
			 pass = true;
		} else {
			 pass = false;
		}
		return pass;
		
	}

	public UserShoppingCartPageObject clickToShoppingCartLinktext() {
		waitForElementClickable(driver, UserProductDetailUI.SHOPPING_CART_LINKTEXT);
		clickToElement(driver, UserProductDetailUI.SHOPPING_CART_LINKTEXT);
		return PageGeneratorManager.getUserShoppingCartPage(driver);
	}


}
