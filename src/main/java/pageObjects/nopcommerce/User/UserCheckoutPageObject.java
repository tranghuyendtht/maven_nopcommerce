package pageObjects.nopcommerce.User;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageUIs.nopcommerce.user.UserCheckoutPageUI;
import PageUIs.nopcommerce.user.UserShoppingCartPageUI;
import commons.BasePage;

public class UserCheckoutPageObject extends BasePage{

	private WebDriver driver;
	public UserCheckoutPageObject (WebDriver driver) {
		this.driver = driver;
	}
	public void inputToTextboxById(String idTextbox, String textValue) {
		sleepInSecond(1);
		waitForElementVisible(driver, UserCheckoutPageUI.TEXTBOX_BY_ID, idTextbox);
		sendkeyToElement(driver, UserCheckoutPageUI.TEXTBOX_BY_ID, textValue, idTextbox);
		
	}
	public void selectCountryOrStateByValue(String dropdownlistId, String textValue) {
		waitForElementVisible(driver, UserCheckoutPageUI.DROPDOWN_LIST_BY_ID, dropdownlistId);
		selectItemInDefaultDropDown(driver, UserCheckoutPageUI.DROPDOWN_LIST_BY_ID, textValue, dropdownlistId);
		sleepInSecond(1);
	}
	
	public void clickToContinueButtonById(String continueButtonId, String text) {
		waitForElementClickable(driver, UserCheckoutPageUI.CONTINUE_BUTTON_BY_ID_AND_TEXT,continueButtonId, text);
		clickToElement(driver, UserCheckoutPageUI.CONTINUE_BUTTON_BY_ID_AND_TEXT,continueButtonId, text);
	}
	
	public void clickToNextDayAirCheckbox() {
		waitForElementClickable(driver, UserCheckoutPageUI.NEXT_DAY_AIR_CHECKBOX);
		clickToElement(driver, UserCheckoutPageUI.NEXT_DAY_AIR_CHECKBOX);
		
	}
	
	public void clickToCheckMoneyOrderCheckbox() {
		waitForElementClickable(driver, UserCheckoutPageUI.CHECK_MONEY_ORDER_CHECKBOX);
		clickToElement(driver, UserCheckoutPageUI.CHECK_MONEY_ORDER_CHECKBOX);
		
	}
	public void clickToCreditCardCheckbox() {
		waitForElementClickable(driver, UserCheckoutPageUI.CREDIT_CARD_CHECKBOX);
		clickToElement(driver, UserCheckoutPageUI.CREDIT_CARD_CHECKBOX);
		
	}
	
	public String isConfirmOrderDisplayed() {
		waitForElementVisible(driver, UserCheckoutPageUI.CONFIRM_ORDER_INFORMATION);
		return getElementText(driver, UserCheckoutPageUI.CONFIRM_ORDER_INFORMATION);
	}
	
	public boolean isBillingAddressInfoDisplayByCategory(String categoryName, String textValue) {
		waitForElementVisible(driver, UserCheckoutPageUI.BILLING_ADDRESS_INFORMATION,categoryName);
		return  getElementText(driver, UserCheckoutPageUI.BILLING_ADDRESS_INFORMATION,categoryName).contains(textValue);
	}
	
	public String isPaymentOrShippingMethodInfoDisplayed(String methodType) {
		waitForElementVisible(driver, UserCheckoutPageUI.PAYMENT_OR_SHIPPING_METHOD_INFORMATION,methodType);
		return  getElementText(driver, UserCheckoutPageUI.PAYMENT_OR_SHIPPING_METHOD_INFORMATION,methodType);
	}
	
	public String isPaymentOrShippingMethodInfoOnCheckoutPageDisplayed(String methodType) {
		waitForElementVisible(driver, UserCheckoutPageUI.PAYMENT_OR_SHIPPING_METHOD_INFORMATION_ON_CHECKOUTPAGE,methodType);
		return  getElementText(driver, UserCheckoutPageUI.PAYMENT_OR_SHIPPING_METHOD_INFORMATION_ON_CHECKOUTPAGE,methodType);
	}
	
	public boolean isPaymentInfoDisplayByCategory(String categoryName, String textValue) {
		waitForElementVisible(driver, UserCheckoutPageUI.SHIPPING_ADDRESS_INFORMATION,categoryName);
		return  getElementText(driver, UserCheckoutPageUI.SHIPPING_ADDRESS_INFORMATION,categoryName).contains(textValue);
	}
	
	public boolean isSKUProductAddedOnWishlistPage(String skuProduct) {
		boolean pass = true;
		List<String> allColumnValueAllPage = new ArrayList<String>();

		// Duyệt qua từng column để lấy các value và đưa vào arraylist
		List<WebElement> allColumnEachPage = getElements(driver, UserCheckoutPageUI.SKU_PRODUCT_TEXT_ON_WISHLIST_PAGE);
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
		waitForElementVisible(driver, UserCheckoutPageUI.PRODUCT_IMAGE_ON_WISHLIST_PAGE);
		return isImageUpLoaded(driver, UserCheckoutPageUI.PRODUCT_IMAGE_ON_WISHLIST_PAGE);
	}
	public boolean isProductNameAddedOnWishlistPage(String keyword) {
		boolean pass = true;
		List<String> allColumnValueAllPage = new ArrayList<String>();

		// Duyệt qua từng column để lấy các value và đưa vào arraylist
		List<WebElement> allColumnEachPage = getElements(driver, UserCheckoutPageUI.PRODUCT_NAME_ON_WISHLIST_PAGE);
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
	public boolean isProductQuantityAddedOnWishlistPage(String quantityProduct) {
		boolean pass = true;
		List<String> allColumnValueAllPage = new ArrayList<String>();

		// Duyệt qua từng column để lấy các value và đưa vào arraylist
		List<WebElement> allColumnEachPage = getElements(driver, UserCheckoutPageUI.PRODUCT_QUANTITY_ON_WISHLIST_PAGE);
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
	public boolean isProductPriceAddedOnWishlistPage(String priceProduct) {
		boolean pass = true;
		List<String> allColumnValueAllPage = new ArrayList<String>();

		// Duyệt qua từng column để lấy các value và đưa vào arraylist
		List<WebElement> allColumnEachPage = getElements(driver, UserCheckoutPageUI.PRODUCT_PRICE_ON_WISHLIST_PAGE);
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
	
	public boolean isTotalFieldUpdated(String productPrice, String productQuantity) {
		boolean pass = true;
		waitForElementVisible(driver, UserCheckoutPageUI.TOTAL_SHOPPING_CART_TABLE);
		String subTotalS = getElementText(driver, UserCheckoutPageUI.TOTAL_SHOPPING_CART_TABLE);
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
	public boolean isSuccessfullyProcessMessageDisplayed() {
		waitForElementVisible(driver, UserCheckoutPageUI.SUCCESSFULLY_ORDER_PROCESS_MESSAGE);
		return isElementDisplayed(driver, UserCheckoutPageUI.SUCCESSFULLY_ORDER_PROCESS_MESSAGE);
	}
	public String getOrderNumber() {
		waitForElementVisible(driver, UserCheckoutPageUI.ORDER_NUMBER);
		return getElementText(driver, UserCheckoutPageUI.ORDER_NUMBER);
	}
	
	public boolean verifySubCartTotalIsDisplayed(String productPrice, String productQuantity, String giftWrapping) {
		boolean pass = true;
		waitForElementVisible(driver, UserCheckoutPageUI.SUB_CART_TOTAL);
		String subCartTotalS = getElementText(driver, UserCheckoutPageUI.SUB_CART_TOTAL);
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
		
		waitForElementVisible(driver, UserCheckoutPageUI.SHIPPING_OR_TAX_ON_CART_TOTAL_BY_CLASSNAME,className);
		String categoryValueS = getElementText(driver, UserCheckoutPageUI.SHIPPING_OR_TAX_ON_CART_TOTAL_BY_CLASSNAME,className);
		int categoryValueI = Integer.valueOf(categoryValueS.replaceAll("[^A-Za-z0-9]",""));
		int visibleValueI = Integer.valueOf(textValue.replaceAll("[^A-Za-z0-9]",""));
		if(visibleValueI == categoryValueI) {
			 pass = true;
		} else {
			 pass = false;
		}
		return pass;
	}
	public boolean verifyCartTotalIsDisplayed(String productPrice, String productQuantity, String giftWrapping,
			String shipping, String tax) {
		boolean pass = true;
		waitForElementVisible(driver, UserCheckoutPageUI.SUB_CART_TOTAL);
		String subCartTotalS = getElementText(driver, UserCheckoutPageUI.SUB_CART_TOTAL);
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
	public boolean verifyPointIsDisplayed(String productPrice, String productQuantity, String giftWrapping,
			String shipping, String tax) {
		boolean pass = true;
		int point = 0;
		waitForElementVisible(driver, UserCheckoutPageUI.SUB_CART_TOTAL);
		String subCartTotalS = getElementText(driver, UserCheckoutPageUI.SUB_CART_TOTAL);
		int subCartTotalI = Integer.valueOf(subCartTotalS.replaceAll("[^A-Za-z0-9]",""));
		int productPriceI = Integer.valueOf(productPrice.replaceAll("[^A-Za-z0-9]",""));
		giftWrapping = giftWrapping.split(" ")[1];
		int giftWrappingI = Integer.valueOf(giftWrapping.replaceAll("[^A-Za-z0-9]",""));
		int shippingI = Integer.valueOf(shipping.replaceAll("[^A-Za-z0-9]",""));
		int taxI = Integer.valueOf(tax.replaceAll("[^A-Za-z0-9]",""));
		int productQuantityI = Integer.valueOf(productQuantity);
		subCartTotalI = productPriceI*productQuantityI + giftWrappingI + shippingI + taxI;
		if(point == subCartTotalI/100) {
			 pass = true;
		} else {
			 pass = false;
		}
		return pass;
	}
	public void clickToContinueButton() {
		waitForElementClickable(driver, UserCheckoutPageUI.CONTINUE_BUTTON_COMPLETE);
		clickToElement(driver, UserCheckoutPageUI.CONTINUE_BUTTON_COMPLETE);
		
	}
	
	public void selectCreditCardDropdownList(String cardType) {
		waitForElementVisible(driver, UserCheckoutPageUI.CREDIT_CARD_DROPDOWN_LIST);
		selectItemInDefaultDropDown(driver, UserCheckoutPageUI.CREDIT_CARD_DROPDOWN_LIST, cardType);
	}
	public void inputCardHolderName(String cardHolderName) {
		waitForElementVisible(driver, UserCheckoutPageUI.CARD_HOLDER_NAME_TEXTBOX);
		sendkeyToElement(driver, UserCheckoutPageUI.CARD_HOLDER_NAME_TEXTBOX, cardHolderName);
	}
	
	public void inputCardNumber(String cardNumber) {
		waitForElementVisible(driver, UserCheckoutPageUI.CARD_NUMBER_TEXTBOX);
		sendkeyToElement(driver, UserCheckoutPageUI.CARD_NUMBER_TEXTBOX, cardNumber);
		
	}
	public void selectExpirationDateById(String id, String expirationMonth) {
		waitForElementVisible(driver, UserCheckoutPageUI.EXPIRATION_DATE_BY_ID, id);
		selectItemInDefaultDropDown(driver, UserCheckoutPageUI.EXPIRATION_DATE_BY_ID, expirationMonth, id);
		
	}
	public void inputCardCode(String cardCode) {
		waitForElementVisible(driver, UserCheckoutPageUI.CARD_CODE_TEXTBOX);
		sendkeyToElement(driver, UserCheckoutPageUI.CARD_CODE_TEXTBOX, cardCode);
		
	}


}
