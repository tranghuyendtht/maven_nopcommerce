package pageObjects.nopcommerce.User;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageUIs.nopcommerce.user.UserShoppingCartPageUI;
import PageUIs.nopcommerce.user.UserWishListPageUI;
import commons.BasePage;
import commons.PageGeneratorManager;

public class UserShoppingCartPageObject extends BasePage{
	private WebDriver driver;
	
	public UserShoppingCartPageObject (WebDriver driver) {
		this.driver = driver;
	}

	public boolean isSKUProductAddedOnWishlistPage(String skuProduct) {
		boolean pass = true;
		List<String> allColumnValueAllPage = new ArrayList<String>();

		// Duyệt qua từng column để lấy các value và đưa vào arraylist
		List<WebElement> allColumnEachPage = getElements(driver, UserShoppingCartPageUI.SKU_PRODUCT_TEXT_ON_WISHLIST_PAGE);
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

	public boolean isImageDisplayed() {
		waitForElementVisible(driver, UserShoppingCartPageUI.PRODUCT_IMAGE_ON_WISHLIST_PAGE);
		return isImageUpLoaded(driver, UserShoppingCartPageUI.PRODUCT_IMAGE_ON_WISHLIST_PAGE);
	}

	public boolean isProductNameAddedOnWishlistPage(String keyword) {
		boolean pass = true;
		List<String> allColumnValueAllPage = new ArrayList<String>();

		// Duyệt qua từng column để lấy các value và đưa vào arraylist
		List<WebElement> allColumnEachPage = getElements(driver, UserShoppingCartPageUI.PRODUCT_NAME_ON_WISHLIST_PAGE);
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
		List<WebElement> allColumnEachPage = getElements(driver, UserShoppingCartPageUI.PRODUCT_PRICE_ON_WISHLIST_PAGE);
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
		List<WebElement> allColumnEachPage = getElements(driver, UserShoppingCartPageUI.PRODUCT_QUANTITY_ON_WISHLIST_PAGE);
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
				UserShoppingCartPageUI.PRODUCT_TOTAL_PRICE_ON_WISHLIST_PAGE);
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

	public UserWishListPageObject clickToWishlistLinktext() {
		waitForElementClickable(driver, UserShoppingCartPageUI.WISHLIST_LINKTEXT);
		clickToElement(driver, UserShoppingCartPageUI.WISHLIST_LINKTEXT);
		return PageGeneratorManager.getUserWishListPage(driver);
	}

	public void inputProductQuantityToQtyTextbox(String productQuantity) {
		waitForElementVisible(driver, UserShoppingCartPageUI.PRODUCT_QUANTITY_ON_SHOPPING_CART_PAGE);
		sendkeyToElement(driver, UserShoppingCartPageUI.PRODUCT_QUANTITY_ON_SHOPPING_CART_PAGE, productQuantity);
	}

	public void clickToUpdateShoppingCartButton() {
		waitForElementClickable(driver, UserShoppingCartPageUI.UPDATE_SHOPPING_CART_BUTTON);
		clickToElement(driver, UserShoppingCartPageUI.UPDATE_SHOPPING_CART_BUTTON);
	}

	public String isQuantityFieldUpdated() {
		waitForElementVisible(driver, UserShoppingCartPageUI.PRODUCT_QUANTITY_ON_SHOPPING_CART_PAGE);
		return getElementAtribute(driver, UserShoppingCartPageUI.PRODUCT_QUANTITY_ON_SHOPPING_CART_PAGE, "value");
	}

	public boolean isSubTotalFieldUpdated(String productPrice, String productQuantity) {
		boolean pass = true;
		waitForElementVisible(driver, UserShoppingCartPageUI.SUB_TOTAL);
		String subTotalS = getElementText(driver, UserShoppingCartPageUI.SUB_TOTAL);
		int subTotalF = Integer.valueOf(subTotalS.replaceAll("[^A-Za-z0-9]",""));
		int productPriceF = Integer.valueOf(productPrice.replaceAll("[^A-Za-z0-9]",""));
		int productQuantityI = Integer.valueOf(productQuantity);
		if(subTotalF == productPriceF*productQuantityI) {
			pass = true;
		} else {
			pass = false;
		}
		return pass;
	}
	public boolean isTotalFieldUpdated(String productPrice, String productQuantity) {
		boolean pass = true;
		waitForElementVisible(driver, UserShoppingCartPageUI.TOTAL_SHOPPING_CART_TABLE);
		String subTotalS = getElementText(driver, UserShoppingCartPageUI.TOTAL_SHOPPING_CART_TABLE);
		int subTotalF = Integer.valueOf(subTotalS.replaceAll("[^A-Za-z0-9]",""));
		int productPriceF = Integer.valueOf(productPrice.replaceAll("[^A-Za-z0-9]",""));
		int productQuantityI = Integer.valueOf(productQuantity);
		if(subTotalF == productPriceF*productQuantityI) {
			 pass = true;
		} else {
			 pass = false;
		}
		return pass;
	}

	public boolean isTotalFieldUpdated(String productPrice, String productQuantity, String shipping, String tax) {
		boolean pass = true;
		waitForElementVisible(driver, UserShoppingCartPageUI.SUB_TOTAL);
		String subTotalS = getElementText(driver, UserShoppingCartPageUI.SUB_TOTAL);
		int subTotalF = Integer.valueOf(subTotalS.replaceAll("[^A-Za-z0-9]",""));
		int productPriceF = Integer.valueOf(productPrice.replaceAll("[^A-Za-z0-9]",""));
		int shippingF = Integer.valueOf(shipping.replaceAll("[^A-Za-z0-9]",""));
		int taxF = Integer.valueOf(tax.replaceAll("[^A-Za-z0-9]",""));
		
		int productQuantityI = Integer.valueOf(productQuantity);
		if(subTotalF == productPriceF*productQuantityI + shippingF + taxF) {
			 pass = true;
		} else {
			 pass = false;
		}
		return pass;
	}

	public void clickToRemoveButton() {
		waitForElementClickable(driver, UserShoppingCartPageUI.REMOVE_BUTTON);
		clickToElement(driver, UserShoppingCartPageUI.REMOVE_BUTTON);
		
	}

	public boolean isEmptyShoppingCartMessageDisplayed() {
		waitForElementVisible(driver, UserShoppingCartPageUI.EMPTY_SHOPPING_CART_MESSAGE);
		return isElementDisplayed(driver, UserShoppingCartPageUI.EMPTY_SHOPPING_CART_MESSAGE);
	}
	

	public String getProductPriceOnShoppingCartTable() {
		waitForElementVisible(driver, UserShoppingCartPageUI.PRODUCT_PRICE_SHOPPING_CART);
		return getElementText(driver, UserShoppingCartPageUI.PRODUCT_PRICE_SHOPPING_CART);
	}

	public void selectGiftWrapping(String giftWrapping) {
		waitForElementClickable(driver, UserShoppingCartPageUI.GIFT_WRAPPING);
		clickToElement(driver, UserShoppingCartPageUI.GIFT_WRAPPING);
	}

	public boolean isGiftWrappingDisplayed() {
		waitForElementVisible(driver, UserShoppingCartPageUI.GIFT_WRAPPING_STATUS);
		return isElementDisplayed(driver, UserShoppingCartPageUI.GIFT_WRAPPING_STATUS);
		
	}

	public void clickToAgreeTermCheckbox() {
		waitForElementClickable(driver, UserShoppingCartPageUI.AGREE_TERM_CHECKBOX);
		clickToElement(driver, UserShoppingCartPageUI.AGREE_TERM_CHECKBOX);
		
	}

	public UserCheckoutPageObject clickToCheckoutButton() {
		waitForElementClickable(driver, UserShoppingCartPageUI.CHECKOUT_BUTTON);
		clickToElement(driver, UserShoppingCartPageUI.CHECKOUT_BUTTON);
		return PageGeneratorManager.getUserCheckoutPage(driver);
	}


}
