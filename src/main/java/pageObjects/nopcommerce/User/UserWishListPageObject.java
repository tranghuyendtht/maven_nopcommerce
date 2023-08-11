package pageObjects.nopcommerce.User;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageUIs.jQuery.dataTable.HomePageUI;
import PageUIs.nopcommerce.user.UserWishListPageUI;
import commons.BasePage;
import commons.PageGeneratorManager;

public class UserWishListPageObject extends BasePage {
	private WebDriver driver;

	public UserWishListPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isSKUProductAddedOnWishlistPage(String skuProduct) {
		boolean pass = true;
		List<String> allColumnValueAllPage = new ArrayList<String>();

		// Duyệt qua từng column để lấy các value và đưa vào arraylist
		List<WebElement> allColumnEachPage = getElements(driver, UserWishListPageUI.SKU_PRODUCT_TEXT_ON_WISHLIST_PAGE);
		for (WebElement eachColumn : allColumnEachPage) {

			allColumnValueAllPage.add(eachColumn.getText());
			System.out.println(eachColumn.getText());
		}

		// In các giá trị của các row tất cả page
		for (String value : allColumnValueAllPage) {
			if (value.equals(skuProduct)) {
				pass = true;
			} else {
				pass = false;
			}
		}

		return pass;

	}

	public void clickToUrlSharing() {
		waitForElementClickable(driver, UserWishListPageUI.URL_SHARING);
		clickToElement(driver, UserWishListPageUI.URL_SHARING);

	}

	public boolean isImageDisplayed() {

		waitForElementVisible(driver, UserWishListPageUI.PRODUCT_IMAGE_ON_WISHLIST_PAGE);
		return isImageUpLoaded(driver, UserWishListPageUI.PRODUCT_IMAGE_ON_WISHLIST_PAGE);

	}

	public boolean isProductNameAddedOnWishlistPage(String keyword) {
		boolean pass = true;
		List<String> allColumnValueAllPage = new ArrayList<String>();

		// Duyệt qua từng column để lấy các value và đưa vào arraylist
		List<WebElement> allColumnEachPage = getElements(driver, UserWishListPageUI.PRODUCT_NAME_ON_WISHLIST_PAGE);
		for (WebElement eachColumn : allColumnEachPage) {

			allColumnValueAllPage.add(eachColumn.getText());
			System.out.println(eachColumn.getText());
		}

		// In các giá trị của các row tất cả page
		for (String value : allColumnValueAllPage) {
			if (value.equals(keyword)) {
				pass = true;
			} else {
				pass = false;
			}
		}

		return pass;
	}

	public boolean isProductPriceAddedOnWishlistPage(String priceProduct) {
		boolean pass = true;
		List<String> allColumnValueAllPage = new ArrayList<String>();

		// Duyệt qua từng column để lấy các value và đưa vào arraylist
		List<WebElement> allColumnEachPage = getElements(driver, UserWishListPageUI.PRODUCT_PRICE_ON_WISHLIST_PAGE);
		for (WebElement eachColumn : allColumnEachPage) {

			allColumnValueAllPage.add(eachColumn.getText());
			System.out.println(eachColumn.getText());
		}

		// In các giá trị của các row tất cả page
		for (String value : allColumnValueAllPage) {
			if (value.equals(priceProduct)) {
				pass = true;
			} else {
				pass = false;
			}
		}

		return pass;
	}

	public boolean isProductQuantityAddedOnWishlistPage(int quantityProduct) {
		boolean pass = true;
		List<String> allColumnValueAllPage = new ArrayList<String>();

		// Duyệt qua từng column để lấy các value và đưa vào arraylist
		List<WebElement> allColumnEachPage = getElements(driver, UserWishListPageUI.PRODUCT_QUANTITY_ON_WISHLIST_PAGE);
		for (WebElement eachColumn : allColumnEachPage) {

			allColumnValueAllPage.add(eachColumn.getAttribute("value"));
			System.out.println(eachColumn.getAttribute("value"));
		}

		// In các giá trị của các row tất cả page
		for (String value : allColumnValueAllPage) {
			if (Integer.valueOf(value).equals(quantityProduct)) {
				pass = true;
			} else {
				pass = false;
			}
		}

		return pass;
	}


	public boolean isProductTotalAddedOnWishlistPage(String priceProduct) {
		boolean pass = true;
		List<String> allColumnValueAllPage = new ArrayList<String>();

		// Duyệt qua từng column để lấy các value và đưa vào arraylist
		List<WebElement> allColumnEachPage = getElements(driver,
				UserWishListPageUI.PRODUCT_TOTAL_PRICE_ON_WISHLIST_PAGE);
		for (WebElement eachColumn : allColumnEachPage) {

			allColumnValueAllPage.add(eachColumn.getText());
			System.out.println(eachColumn.getText());
		}

		// In các giá trị của các row tất cả page
		for (String value : allColumnValueAllPage) {
			if (value.equals(priceProduct)) {
				pass = true;
			} else {
				pass = false;
			}
		}

		return pass;
	}

	public boolean isProductQuantityAddedOnWishlistOfPage(int quantityProduct) {
		boolean pass = true;
		List<String> allColumnValueAllPage = new ArrayList<String>();

		// Duyệt qua từng column để lấy các value và đưa vào arraylist
		List<WebElement> allColumnEachPage = getElements(driver,
				UserWishListPageUI.PRODUCT_QUANTITY_ON_WISHLIST_OF_PAGE);
		for (WebElement eachColumn : allColumnEachPage) {

			allColumnValueAllPage.add(eachColumn.getText());
			System.out.println(eachColumn.getText());
		}

		// In các giá trị của các row tất cả page
		for (String value : allColumnValueAllPage) {
			if (Integer.valueOf(value).equals(quantityProduct)) {
				pass = true;
			} else {
				pass = false;
			}
		}

		return pass;
	}

	public void clickToAddToCartCheckbox() {
		waitForElementClickable(driver, UserWishListPageUI.ADD_TO_CARD_CHECKBOX);
		clickToElement(driver, UserWishListPageUI.ADD_TO_CARD_CHECKBOX);
		
	}

	public UserShoppingCartPageObject clickToAddToCartButton() {
		waitForElementClickable(driver, UserWishListPageUI.ADD_TO_CARD_BUTTON);
		clickToElement(driver, UserWishListPageUI.ADD_TO_CARD_BUTTON);
		return PageGeneratorManager.getUserShoppingCartPage(driver);
	}

	public boolean isProductUndisplayed() {
		waitForElementVisible(driver, UserWishListPageUI.NO_DATA);
		return isElementDisplayed(driver, UserWishListPageUI.NO_DATA);
		
	}

	public void clickToRemoveIcon() {
		waitForElementClickable(driver, UserWishListPageUI.REMOVE_ICON);
		clickToElement(driver, UserWishListPageUI.REMOVE_ICON);
	}

}
