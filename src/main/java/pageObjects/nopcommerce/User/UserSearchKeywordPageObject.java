package pageObjects.nopcommerce.User;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import PageUIs.nopcommerce.user.UserProductDetailUI;
import PageUIs.nopcommerce.user.UserSearchKeywordPageUI;
import commons.BasePage;
import commons.PageGeneratorManager;

public class UserSearchKeywordPageObject extends BasePage {

	private WebDriver driver;

	public UserSearchKeywordPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToSearchButton() {
		waitForElementClickable(driver, UserSearchKeywordPageUI.SEARCH_BUTTON);
		clickToElement(driver, UserSearchKeywordPageUI.SEARCH_BUTTON);
	}

	public boolean isSearchLengthTermDisplayed() {
		waitForElementVisible(driver, UserSearchKeywordPageUI.SEARCH_TERM_LENGTH_MESSAGE);
		return isElementDisplayed(driver, UserSearchKeywordPageUI.SEARCH_TERM_LENGTH_MESSAGE);
	}

	public boolean isMessageNoProductFound() {
		waitForElementVisible(driver, UserSearchKeywordPageUI.MESSAGE_NO_PRODUCT_FOUND);
		return isElementDisplayed(driver, UserSearchKeywordPageUI.MESSAGE_NO_PRODUCT_FOUND);
	}

	public boolean isResultMatched(String keyword) {
		boolean pass = true;
		List<WebElement> listTitle = getElements(driver, UserSearchKeywordPageUI.LIST_PRODUCT_TITLE);

		for (WebElement webElement : listTitle) {

			if (webElement.getText().toLowerCase().contains(keyword)) {
				pass = true;
			} else {
				pass = false;
			}
		}
		return pass;

	}

	public int isNumberOfResultTrue() {
		List<WebElement> listTitle = getElements(driver, UserSearchKeywordPageUI.LIST_PRODUCT_TITLE);
		return listTitle.size();

	}

	public void clickToAdvancedSearchCheckbox() {
		waitForElementClickable(driver, UserSearchKeywordPageUI.ADVANCED_SEARCH_CHECKBOX);
		clickToElementByJS(driver, UserSearchKeywordPageUI.ADVANCED_SEARCH_CHECKBOX);
		sleepInSecond(1);
	}

	public void selectCategoryDropdownlistByValue(String textValue) {
		waitForElementVisible(driver, UserSearchKeywordPageUI.CATEGORY_DROPDOWN_LIST);
		selectItemInDefaultDropDown(driver, UserSearchKeywordPageUI.CATEGORY_DROPDOWN_LIST, textValue);
		sleepInSecond(1);
	}

	public void clickToSubCategoryCheckbox() {
		waitForElementClickable(driver, UserSearchKeywordPageUI.SUB_CATEGORY_CHECKBOX);
		clickToElement(driver, UserSearchKeywordPageUI.SUB_CATEGORY_CHECKBOX);

	}

	public void selectSubCategoryDropdownlistByValue(String textValue) {
		waitForElementVisible(driver, UserSearchKeywordPageUI.SUB_CATEGORY_DROPDOWN_LIST);
		selectItemInDefaultDropDown(driver, UserSearchKeywordPageUI.SUB_CATEGORY_DROPDOWN_LIST, textValue);
		sleepInSecond(1);
	}

	public UserProductDetailPageObject clickToProductTitle(String productTitle) {
		waitForElementClickable(driver, UserSearchKeywordPageUI.PRODUCT_TITLE, productTitle);
		clickToElement(driver, UserSearchKeywordPageUI.PRODUCT_TITLE, productTitle);
		return PageGeneratorManager.getUserAProductInfoDetail(driver);
	}

	public String getPriceProduct() {
		waitForElementVisible(driver, UserSearchKeywordPageUI.PRICE_PRODUCT);
		return getElementText(driver, UserSearchKeywordPageUI.PRICE_PRODUCT);
	}

	public void clickToAddCompareListIconByProductName(String productName) {
		waitForElementClickable(driver, UserSearchKeywordPageUI.ADD_TO_COMPARE_LIST_ICON_BY_PRODUCT_NAME, productName);
		clickToElement(driver, UserSearchKeywordPageUI.ADD_TO_COMPARE_LIST_ICON_BY_PRODUCT_NAME, productName);
		sleepInSecond(2);
	}

	public String verifySuccessMessageDisplay() {
		waitForElementVisible(driver, UserSearchKeywordPageUI.ADDED_SUCCESS_MESSAGE);
		return getElementText(driver, UserSearchKeywordPageUI.ADDED_SUCCESS_MESSAGE);
	}

	public UserCompareProductsPageObject clickToProductCompariSonLinkText() {
		waitForElementClickable(driver, UserSearchKeywordPageUI.COMPARISON_PRODUCT_LINKTEXT);
		clickToElement(driver, UserSearchKeywordPageUI.COMPARISON_PRODUCT_LINKTEXT);
		sleepInSecond(2);
		return PageGeneratorManager.getUserCompareProductsPage(driver);
	}

	public void clickAddToCartButton() {
		sleepInSecond(1);
		waitForElementClickable(driver, UserSearchKeywordPageUI.ADD_TO_CART_BUTTON_2);
		clickToElement(driver, UserSearchKeywordPageUI.ADD_TO_CART_BUTTON_2);

	}

	public UserShoppingCartPageObject clickToShoppingCartLinktext() {
		sleepInSecond(2);
		waitForElementClickable(driver, UserSearchKeywordPageUI.SHOPPING_CART_LINKTEXT);
		clickToElement(driver, UserSearchKeywordPageUI.SHOPPING_CART_LINKTEXT);
		return PageGeneratorManager.getUserShoppingCartPage(driver);
	}

	public void clickToCloseIcon() {
		waitForElementClickable(driver, UserSearchKeywordPageUI.CLOSE_ICON);
		clickToElement(driver, UserSearchKeywordPageUI.CLOSE_ICON);
		sleepInSecond(1);
	}

}
