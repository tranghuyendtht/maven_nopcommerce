package pageObjects.nopcommerce.User;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageUIs.nopcommerce.user.UserCheckoutPageUI;
import PageUIs.nopcommerce.user.UserOrderPageUI;
import PageUIs.nopcommerce.user.UserShoppingCartPageUI;
import commons.BasePage;
import commons.PageGeneratorManager;

public class UserOrderPageObject extends BasePage{
private WebDriver driver;
	

	public UserOrderPageObject(WebDriver driver) {
		this.driver = driver;
	}


	public String verifyOrderNumber() {
		waitForElementVisible(driver, UserOrderPageUI.ORDER_NUMBER);
		return getElementText(driver, UserOrderPageUI.ORDER_NUMBER);
	}


	public void clickToDetailButton() {
		waitForElementClickable(driver, UserOrderPageUI.DETAIL_BUTTON);
		clickToElement(driver,  UserOrderPageUI.DETAIL_BUTTON);
		
	}


	public String verifyOrderNumberOnOrderInformation() {
		waitForElementVisible(driver, UserOrderPageUI.ORDER_NUMBER_ON_ORDER_INFORMATION);
		return getElementText(driver, UserOrderPageUI.ORDER_NUMBER_ON_ORDER_INFORMATION);
	}


	public boolean verifyOrderDateOnOrderInformation() {
		String dateTimeOrder = getDatetime();
		waitForElementVisible(driver, UserOrderPageUI.ORDER_NUMBER_ON_ORDER_INFORMATION);
		return getElementText(driver, UserOrderPageUI.ORDER_NUMBER_ON_ORDER_INFORMATION).contains(dateTimeOrder);
	}
	
	public String getDatetime() {
		return new SimpleDateFormat("MM/dd/yyyy").format(Calendar.getInstance().getTime());
	}


	public String verifyOrderStatusOnOrderInformation() {
		waitForElementVisible(driver, UserOrderPageUI.ORDER_STATUS);
		return getElementText(driver, UserOrderPageUI.ORDER_STATUS);
	}


	public boolean verifyOrderTotalOnOrderInformation(String productPrice, String productQuantity, String giftWrapping,
			String shipping, String tax) {
		boolean pass = true;
		waitForElementVisible(driver, UserOrderPageUI.ORDER_TOTAL);
		String subCartTotalS = getElementText(driver, UserOrderPageUI.ORDER_TOTAL);
		int subCartTotalI = Integer.valueOf(subCartTotalS.replaceAll("[^A-Za-z0-9]",""));
		int productPriceI = Integer.valueOf(productPrice.replaceAll("[^A-Za-z0-9]",""));
		giftWrapping = giftWrapping.split(" ")[1];
		int giftWrappingI = Integer.valueOf(giftWrapping.replaceAll("[^A-Za-z0-9]",""));
		int shippingI = Integer.valueOf(shipping.replaceAll("[^A-Za-z0-9]",""));
		int taxI = Integer.valueOf(tax.replaceAll("[^A-Za-z0-9]",""));
		int productQuantityI = Integer.valueOf(productQuantity);
		if(subCartTotalI == productPriceI*productQuantityI + giftWrappingI + shippingI + taxI) {
			 pass = true;
		} else {
			 pass = false;
		}
		return pass;
	}


	public boolean verifyBillingAddInfoByClass(String className, String textValue) {
		waitForElementVisible(driver, UserOrderPageUI.BILLING_ADDRESS_INFO_BY_CLASS, className);
		return getElementText(driver, UserOrderPageUI.BILLING_ADDRESS_INFO_BY_CLASS, className).contains(textValue);
	}


	public boolean verifyPaymentMethodInfoByClass(String className, String textValue) {
		waitForElementVisible(driver, UserOrderPageUI.PAYMENT_INFO_BY_CLASS, className);
		return getElementText(driver, UserOrderPageUI.PAYMENT_INFO_BY_CLASS, className).contains(textValue);
	}


	public boolean verifyShippingAddInfoByClass(String className, String textValue) {
		waitForElementVisible(driver, UserOrderPageUI.SHIPPING_ADD_INFO_BY_CLASS, className);
		return getElementText(driver, UserOrderPageUI.SHIPPING_ADD_INFO_BY_CLASS, className).contains(textValue);
	}


	public boolean verifyShippingInfoByClass(String className, String textValue) {
		waitForElementVisible(driver, UserOrderPageUI.SHIPPING_METHOD_INFO, className);
		return getElementText(driver, UserOrderPageUI.SHIPPING_METHOD_INFO, className).contains(textValue);
	}


	public boolean isSKUProductAddedOnWishlistPage(String skuProduct) {
		boolean pass = true;
		List<String> allColumnValueAllPage = new ArrayList<String>();

		// Duyệt qua từng column để lấy các value và đưa vào arraylist
		List<WebElement> allColumnEachPage = getElements(driver, UserOrderPageUI.SKU_PRODUCT_TEXT_ON_WISHLIST_PAGE);
		for (WebElement eachColumn : allColumnEachPage) {
			allColumnValueAllPage.add(eachColumn.getText());
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
		waitForElementVisible(driver, UserOrderPageUI.PRODUCT_IMAGE_ON_ORDER_INFORMATION);
		return isImageUpLoaded(driver, UserOrderPageUI.PRODUCT_IMAGE_ON_ORDER_INFORMATION);
	}
	
	public boolean isProductNameAddedOnWishlistPage(String keyword) {
		boolean pass = true;
		List<String> allColumnValueAllPage = new ArrayList<String>();

		// Duyệt qua từng column để lấy các value và đưa vào arraylist
		List<WebElement> allColumnEachPage = getElements(driver, UserOrderPageUI.PRODUCT_NAME_ON_WISHLIST_PAGE);
		for (WebElement eachColumn : allColumnEachPage) {

			allColumnValueAllPage.add(eachColumn.getText());
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
		List<WebElement> allColumnEachPage = getElements(driver, UserOrderPageUI.PRODUCT_PRICE_ON_WISHLIST_PAGE);
		for (WebElement eachColumn : allColumnEachPage) {

			allColumnValueAllPage.add(eachColumn.getText());
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
	
	public boolean isProductQuantityAddedOnWishlistPage(String quantityProduct) {
		boolean pass = true;
		List<String> allColumnValueAllPage = new ArrayList<String>();

		// Duyệt qua từng column để lấy các value và đưa vào arraylist
		List<WebElement> allColumnEachPage = getElements(driver, UserOrderPageUI.PRODUCT_QUANTITY_ON_WISHLIST_PAGE);
		for (WebElement eachColumn : allColumnEachPage) {

			allColumnValueAllPage.add(eachColumn.getAttribute("value"));
		}

		// In các giá trị của các row tất cả page
		for (String value : allColumnValueAllPage) {
			if (value.equals(quantityProduct)) {
				pass = true;
			} else {
				pass = false;
			}
		}

		return pass;
	}
	
	public boolean isTotalFieldUpdated(String productPrice, String productQuantity) {
		boolean pass = true;
		waitForElementVisible(driver, UserOrderPageUI.TOTAL_SHOPPING_CART_ORDER_INFORMATION);
		String subTotalS = getElementText(driver, UserOrderPageUI.TOTAL_SHOPPING_CART_ORDER_INFORMATION);
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


	public boolean isGiftWrappingDisplayed() {
		waitForElementVisible(driver, UserOrderPageUI.WRAPPING_GIFT);
		return isElementDisplayed(driver, UserOrderPageUI.WRAPPING_GIFT);
	}
	
	public boolean verifySubCartTotalIsDisplayed(String title, String productPrice, String productQuantity, String giftWrapping) {
		boolean pass = true;
		waitForElementVisible(driver, UserOrderPageUI.ORDER_INFOR_ON_ORDER_INFORMATION_PAGE_BY_TITLE,title);
		String subCartTotalS = getElementText(driver, UserOrderPageUI.ORDER_INFOR_ON_ORDER_INFORMATION_PAGE_BY_TITLE,title);
		int subCartTotalI = Integer.valueOf(subCartTotalS.replaceAll("[^A-Za-z0-9]",""));
		int productPriceI = Integer.valueOf(productPrice.replaceAll("[^A-Za-z0-9]",""));
		giftWrapping = giftWrapping.split(" ")[1];
		int giftWrappingI = Integer.valueOf(giftWrapping.replaceAll("[^A-Za-z0-9]",""));
		int productQuantityI = Integer.valueOf(productQuantity);
		if(subCartTotalI == productPriceI*productQuantityI + giftWrappingI) {
			 pass = true;
		} else {
			 pass = false;
		}
		return pass;
	}
	
	public boolean verifyCartTotalIsDisplayedByClassName(String className, String textValue) {
		boolean pass = true;
		
		waitForElementVisible(driver, UserOrderPageUI.ORDER_INFOR_ON_ORDER_INFORMATION_PAGE_BY_TITLE,className);
		String categoryValueS = getElementText(driver, UserOrderPageUI.ORDER_INFOR_ON_ORDER_INFORMATION_PAGE_BY_TITLE,className);
		int categoryValueI = Integer.valueOf(categoryValueS.replaceAll("[^A-Za-z0-9]",""));
		int visibleValueI = Integer.valueOf(textValue.replaceAll("[^A-Za-z0-9]",""));
		if(visibleValueI == categoryValueI) {
			 pass = true;
		} else {
			 pass = false;
		}
		return pass;
	}
	
	public boolean verifyCartTotalIsDisplayed(String className, String productPrice, String productQuantity, String giftWrapping,
			String shipping, String tax) {
		boolean pass = true;
		waitForElementVisible(driver, UserOrderPageUI.ORDER_INFOR_ON_ORDER_INFORMATION_PAGE_BY_TITLE, className);
		String subCartTotalS = getElementText(driver, UserOrderPageUI.ORDER_INFOR_ON_ORDER_INFORMATION_PAGE_BY_TITLE, className);
		int subCartTotalI = Integer.valueOf(subCartTotalS.replaceAll("[^A-Za-z0-9]",""));
		int productPriceI = Integer.valueOf(productPrice.replaceAll("[^A-Za-z0-9]",""));
		giftWrapping = giftWrapping.split(" ")[1];
		int giftWrappingI = Integer.valueOf(giftWrapping.replaceAll("[^A-Za-z0-9]",""));
		int shippingI = Integer.valueOf(shipping.replaceAll("[^A-Za-z0-9]",""));
		int taxI = Integer.valueOf(tax.replaceAll("[^A-Za-z0-9]",""));
		int productQuantityI = Integer.valueOf(productQuantity);
		if(subCartTotalI == productPriceI*productQuantityI + giftWrappingI + shippingI + taxI) {
			 pass = true;
		} else {
			 pass = false;
		}
		return pass;
	}


	public UserSearchKeywordPageObject clickToSearchButton() {
		waitForElementClickable(driver, UserOrderPageUI.SEARCH_BUTTON);
		clickToElement(driver, UserOrderPageUI.SEARCH_BUTTON);
		return PageGeneratorManager.getUserSearchKeywordPage(driver);
	}


	public UserShoppingCartPageObject clickToReOderButton() {
		waitForElementClickable(driver, UserOrderPageUI.RE_ORDER_BUTTON);
		clickToElement(driver, UserOrderPageUI.RE_ORDER_BUTTON);
		return PageGeneratorManager.getUserShoppingCartPage(driver);
	}
}
