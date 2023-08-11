package pageObjects.nopcommerce.User;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageUIs.nopcommerce.user.UserCompareProductsPageUI;
import commons.BasePage;

public class UserCompareProductsPageObject extends BasePage {
	private WebDriver driver;

	public UserCompareProductsPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isRemoveIconDisplayed() {
		boolean pass = true;
		List<WebElement> listRemoveIcon = getElements(driver, UserCompareProductsPageUI.REMOVE_ICON);
		if (listRemoveIcon.size() == 2 && isElementDisplayed(driver, UserCompareProductsPageUI.REMOVE_ICON)) {
			pass = true;
		} else {
			pass = false;
		}
		return pass;

	}

	public boolean isImageProductDisplayedByProductName(String productName) {
		waitForElementVisible(driver, UserCompareProductsPageUI.PRODUCT_IMAGE, productName);
		return isImageUpLoaded(driver, UserCompareProductsPageUI.PRODUCT_IMAGE, productName);

	}
	public int getNumberOfProduct() {
		List<WebElement> listRemoveIcon = getElements(driver, UserCompareProductsPageUI.PRODUCT_TOTAL);
		return listRemoveIcon.size();
	}

	public boolean isNameProductDisplayedByProductName(String productName) {
		waitForElementVisible(driver, UserCompareProductsPageUI.PRODUCT_NAME, productName);
		return isElementDisplayed(driver, UserCompareProductsPageUI.PRODUCT_NAME, productName);
	}

	public boolean isPriceProductDisplayedByProductName(String priceProduct) {
		waitForElementVisible(driver, UserCompareProductsPageUI.PRODUCT_PRICE, priceProduct);
		return isElementDisplayed(driver, UserCompareProductsPageUI.PRODUCT_PRICE, priceProduct);

	}

	public void clickToClearListButton() {
		waitForElementClickable(driver, UserCompareProductsPageUI.CLEAR_LIST_BUTTON);
		clickToElement(driver, UserCompareProductsPageUI.CLEAR_LIST_BUTTON);
	}

	public boolean verifyNoDataMessageDisplayed() {
		waitForElementVisible(driver, UserCompareProductsPageUI.NO_PRODUCT_COMPARISON_MESSAGE);
		return isElementDisplayed(driver, UserCompareProductsPageUI.NO_PRODUCT_COMPARISON_MESSAGE);

	}

	
}
