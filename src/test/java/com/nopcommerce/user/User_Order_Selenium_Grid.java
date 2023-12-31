package com.nopcommerce.user;

import java.lang.reflect.Method;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.nopcommerce.common.Common_01_Register_Cookie;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.User.UserCheckoutPageObject;
import pageObjects.nopcommerce.User.UserComputerProductPageObject;
import pageObjects.nopcommerce.User.UserHomePageObject;
import pageObjects.nopcommerce.User.UserLoginPageObject;
import pageObjects.nopcommerce.User.UserMyAccountPageObject;
import pageObjects.nopcommerce.User.UserOrderPageObject;
import pageObjects.nopcommerce.User.UserProductDetailPageObject;
import pageObjects.nopcommerce.User.UserSearchKeywordPageObject;
import pageObjects.nopcommerce.User.UserShoppingCartPageObject;
import reportConfig.ExtentTestManager;
import utilities.DataHelper;
import utilities.Environment;

public class User_Order_Selenium_Grid extends BaseTest {

	WebDriver driver;
	DataHelper fakeData;
	UserHomePageObject userHomePage;
	UserLoginPageObject userLoginPage;
	UserComputerProductPageObject userComputerProductPage;
	UserProductDetailPageObject userProductDetailPage;
	UserShoppingCartPageObject userShoppingCartPage;
	UserSearchKeywordPageObject userSearchKeywordPage;
	UserCheckoutPageObject userCheckoutPage;
	UserMyAccountPageObject userMyAccountPage;
	UserOrderPageObject userOrderPage;
	Environment env;

	String productName, productSKU, productPrice;
	String shoppingCartUrl;
	String productQuantity;
	String shipping, tax, giftWrapping;
	String productNameLenovo, newQuantityLenovo, productPriceLenovo, updateNewReOrderQuantity;
	String firstName, lastName, emailAddress, country, state, city, address1, zipCode, phoneNumber;
	String orderNumber;
	String cardType, cardHolderName, cardNumber, expirationMonth, expirationYear, cardCode;

	@Parameters({"browser", "appUrl", "osName", "ipAddress", "port"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl, String osName, String ipAddress, String port) {
		log.info("Pre-Condition: Go to page");
		
		//String environment = System.getProperty("ENV");
		//ConfigFactory.setProperty("envName", environment);
		//env = ConfigFactory.create(Environment.class);
		
		//driver = getBrowserDriver(browserName, env.appUrl());
		driver = getBrowserSeleniumGrid(browserName, appUrl, osName, ipAddress, port);
		System.out.println("Get browser successfully");
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		fakeData = DataHelper.getData();

		productName = "Apple MacBook Pro 13-inch";
		productNameLenovo = "Lenovo IdeaCentre 600 All-in-One PC";
		productQuantity = "2";
		newQuantityLenovo = "5";
		updateNewReOrderQuantity = "10";
		giftWrapping = "Yes [+$10.00]";
		shipping = "$0.00";
		tax = "$0.00";
		
		cardType = "Visa";
		cardHolderName = "Trang Doan";
		cardNumber = "4111 1111 1111 1111";
		expirationMonth = "12";
		expirationYear = "2023";
		cardCode = "1243";

		firstName = fakeData.getFirstName();
		lastName = fakeData.getLastName();
		emailAddress = fakeData.getEmailAddress();
		country = "United States";
		state = "Alabama";
		city = fakeData.getCity();
		address1 = fakeData.getAddress1();
		zipCode = fakeData.getZipPotalCode();
		phoneNumber = fakeData.getPhoneNumber();

				log.info("Pre-Condition: Navigate to Login page");
		userLoginPage = userHomePage.openLoginPage();

		log.info("Pre-Condition: Set cookies and reload page");
		//userLoginPage.setCookies(driver, Common_01_Register_Cookie.loggedCookies);
		userLoginPage.refreshPage(driver);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

	}

	@Test
	public void TC_01_Add_Product_To_Cart(Method method) {

		ExtentTestManager.startTest(method.getName(), "Add_Product_To_Cart");
		ExtentTestManager.getTest().log(Status.INFO, "Add_Product_To_Cart - Step 01: Open a product");
		userComputerProductPage = userHomePage.clickToLinkTextOnHeaderMenuByText("Computers");
		userComputerProductPage.clickToSubMenuLinkTextOnHeaderMenuByText("Notebooks");

		ExtentTestManager.getTest().log(Status.INFO, "Add_Product_To_Cart - Step 02: Click to see detail product");
		userProductDetailPage = userComputerProductPage.clickToProductByName(productName);

		ExtentTestManager.getTest().log(Status.INFO, "Add_Product_To_Cart - Step 03: Get product info");
		productSKU = userProductDetailPage.getProductSKU();
		productPrice = userProductDetailPage.getProductPrice();

		ExtentTestManager.getTest().log(Status.INFO, "Add_Product_To_Cart - Step 04: Click 'Add to cart' button");
		userProductDetailPage.clickToAddToCartButton();

		ExtentTestManager.getTest().log(Status.INFO, 
				"Add_Product_To_Cart - Step 05: Verify message 'The product has been added to your shopping cart' displayed ");
		verifyTrue(userProductDetailPage.isAddedProductIntoCartMessageDisplayed());

		ExtentTestManager.getTest().log(Status.INFO, "Add_Product_To_Cart - Step 06: Click icon to close bar notification");
		userProductDetailPage.clickToCloseIcon();

		ExtentTestManager.getTest().log(Status.INFO, 
				"Add_Product_To_Cart - Step 07: Verify product on shopping cart when hover mouse on 'Shopping cart' linktext");
		verifyEquals(userProductDetailPage.isMessageProductNameAddedIntoCartDisplayed(),
				"There are 2 item(s) in your cart.");
		verifyEquals(userProductDetailPage.isProductNameAddedIntoCart(), productName);
		verifyEquals(userProductDetailPage.isProductPriceAddedIntoCart(), productPrice);
		verifyEquals(userProductDetailPage.isProductQuantityAddedIntoCart(), "2");
		verifyTrue(userProductDetailPage.isProductSubTotalDisplayed(productPrice, productQuantity));

	}

	@Test
	public void TC_02_Edit_Product_On_Shopping_Cart(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_02_Edit_Product_On_Shopping_Cart");
		ExtentTestManager.getTest().log(Status.INFO, "Edit_Product_On_Shopping_Cart - Step 01: Click to 'Shopping cart' linktext on header page");
		userShoppingCartPage = userProductDetailPage.clickToShoppingCartLinktext();

		ExtentTestManager.getTest().log(Status.INFO, "Edit_Product_On_Shopping_Cart - Step 02: Get shopping cart url link");
		shoppingCartUrl = userShoppingCartPage.getCurrentUrl(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Edit_Product_On_Shopping_Cart - Step 02: Update quantity with value: " + productQuantity);
		userShoppingCartPage.inputProductQuantityToQtyTextbox(productQuantity);

		ExtentTestManager.getTest().log(Status.INFO, "Edit_Product_On_Shopping_Cart - Step 03: Click to 'Update shopping cart' button " + productQuantity);
		userShoppingCartPage.clickToUpdateShoppingCartButton();

		ExtentTestManager.getTest().log(Status.INFO, "Edit_Product_On_Shopping_Cart - Step 04: Verify quantity field updated");
		verifyEquals(userShoppingCartPage.isQuantityFieldUpdated(), productQuantity);

		ExtentTestManager.getTest().log(Status.INFO, "Edit_Product_On_Shopping_Cart - Step 05: Verify sub-total and total field updated");
		verifyTrue(userShoppingCartPage.isSubTotalFieldUpdated(productPrice, productQuantity));
		verifyTrue(userShoppingCartPage.isTotalFieldUpdated(productPrice, productQuantity, shipping, tax));

	}

	@Test
	public void TC_03_Remove_From_Cart(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_03_Remove_From_Cart");
		ExtentTestManager.getTest().log(Status.INFO, "Remove_From_Cart - Step 01: Go to shopping cart url link");
		userShoppingCartPage.navigateToUrlByJS(driver, shoppingCartUrl);

		ExtentTestManager.getTest().log(Status.INFO, "Remove_From_Cart - Step 02: Remove product on shopping cart");
		userShoppingCartPage.clickToRemoveButton();

		ExtentTestManager.getTest().log(Status.INFO, "Remove_From_Cart - Step 03: Verify 'Your Shopping Cart is empty!' message displayed");
		verifyTrue(userShoppingCartPage.isEmptyShoppingCartMessageDisplayed());

	}

	@Test
	public void TC_04_Update_Shopping_Cart(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_04_Update_Shopping_Cart");
		ExtentTestManager.getTest().log(Status.INFO, "Update_Shopping_Cart - Step 01: Input product name to search textbox by value: " + productNameLenovo);
		userShoppingCartPage.inputKeywordToSearchTextbox(driver, productNameLenovo);
		
		ExtentTestManager.getTest().log(Status.INFO, "Update_Shopping_Cart - Step 02: Click to 'search' button ");
		userSearchKeywordPage = userShoppingCartPage.clickToSearchButton();

		ExtentTestManager.getTest().log(Status.INFO, "Update_Shopping_Cart - Step 03: Click to 'Add to cart' button ");
		userSearchKeywordPage.clickAddToCartButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Update_Shopping_Cart - Step 04: Click to close icon");
		userSearchKeywordPage.clickToCloseIcon();

		ExtentTestManager.getTest().log(Status.INFO, "Update_Shopping_Cart - Step 05: Go to Shopping Cart by click to Shopping cart linktext");
		userShoppingCartPage = userSearchKeywordPage.clickToShoppingCartLinktext();
		productPriceLenovo = userShoppingCartPage.getProductPriceOnShoppingCartTable();

		ExtentTestManager.getTest().log(Status.INFO, "Update_Shopping_Cart - Step 06: Update quatity with value: " + newQuantityLenovo);
		userShoppingCartPage.inputProductQuantityToQtyTextbox(newQuantityLenovo);

		ExtentTestManager.getTest().log(Status.INFO, "Update_Shopping_Cart - Step 07: Click to 'Update shopping cart' button");
		userShoppingCartPage.clickToUpdateShoppingCartButton();

		ExtentTestManager.getTest().log(Status.INFO, "Update_Shopping_Cart - Step 08: Verify total is updated");
		verifyTrue(userShoppingCartPage.isTotalFieldUpdated(productPriceLenovo, newQuantityLenovo));

	}

	@Test
	public void TC_05_Checkout_By_Cheque(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_05_Checkout_By_Cheque");

		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 01: Select 'Gift Wrapping' with value: " + giftWrapping);
		userShoppingCartPage.selectGiftWrapping(giftWrapping);
		

		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 02: Verify updated info of gift wapping");
		verifyTrue(userShoppingCartPage.isGiftWrappingDisplayed());

		ExtentTestManager.getTest().log(Status.INFO, 
				"Checkout_By_Cheque - Step 07: Click to 'I agree with the terms of service and I adhere to them unconditionally' checkbox");
		userShoppingCartPage.clickToAgreeTermCheckbox();
		

		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 03: Click to 'Checkout' button");
		userCheckoutPage = userShoppingCartPage.clickToCheckoutButton();
		
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 04: Input to first name textbox with value: " + firstName);
		userCheckoutPage.inputToTextboxById("BillingNewAddress_FirstName", firstName);
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 05: Input to last name textbox with value: " + lastName);
		userCheckoutPage.inputToTextboxById("BillingNewAddress_LastName", lastName);
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 06: Input to email textbox with value: " + emailAddress);
		userCheckoutPage.inputToTextboxById("BillingNewAddress_Email", emailAddress);
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 07: Select to country dropdownlist with value: " + country);
		userCheckoutPage.selectCountryOrStateByValue("BillingNewAddress_CountryId",country);
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 08: Select to state dropdownlist with value: " + state);
		userCheckoutPage.selectCountryOrStateByValue("BillingNewAddress_StateProvinceId",state);
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 09: Input to city textbox with value: " + city);
		userCheckoutPage.inputToTextboxById("BillingNewAddress_City", city);
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 10: Input to address1 textbox with value: " + address1);
		userCheckoutPage.inputToTextboxById("BillingNewAddress_Address1", address1);
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 11: Input to zipCode textbox with value: " + zipCode);
		userCheckoutPage.inputToTextboxById("BillingNewAddress_ZipPostalCode", zipCode);
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 12: Input to phonenumber textbox with value: " + phoneNumber);
		userCheckoutPage.inputToTextboxById("BillingNewAddress_PhoneNumber", phoneNumber);

		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 13: Click to 'Continue' button");
		userCheckoutPage.clickToContinueButtonById("billing-buttons-container","Continue");
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 14: Click to 'Next day air' checkbox");
		userCheckoutPage.clickToNextDayAirCheckbox();
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 15: Click to 'Continue' button");
		userCheckoutPage.clickToContinueButtonById("shipping-method-buttons-container","Continue");
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 16: Click to 'Check/Money Order' checkbox");
		
		userCheckoutPage.clickToCheckMoneyOrderCheckbox();
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 17: Click to 'Continue' button");
		userCheckoutPage.clickToContinueButtonById("payment-method-buttons-container","Continue");
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 18: Verify payment information");
		verifyEquals(userCheckoutPage.isConfirmOrderDisplayed(),"your order may be held for up to 10 days after we receive your check");
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 19: Click to 'Continue' button");
		userCheckoutPage.clickToContinueButtonById("payment-info-buttons-container","Continue");
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 20: Verify Billing Address Info");
		verifyTrue(userCheckoutPage.isBillingAddressInfoDisplayByCategory("name", firstName));
		verifyTrue(userCheckoutPage.isBillingAddressInfoDisplayByCategory("name", lastName));
		verifyTrue(userCheckoutPage.isBillingAddressInfoDisplayByCategory("email", emailAddress));
		verifyTrue(userCheckoutPage.isBillingAddressInfoDisplayByCategory("phone", phoneNumber));
		verifyTrue(userCheckoutPage.isBillingAddressInfoDisplayByCategory("address1", address1));
		verifyTrue(userCheckoutPage.isBillingAddressInfoDisplayByCategory("city-state-zip", city));
		verifyTrue(userCheckoutPage.isBillingAddressInfoDisplayByCategory("city-state-zip", state));
		verifyTrue(userCheckoutPage.isBillingAddressInfoDisplayByCategory("country", country));
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 21: Verify Payment Info");
		verifyTrue(userCheckoutPage.isPaymentOrShippingMethodInfoOnCheckoutPageDisplayed("payment-method").contains("Money Order"));
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 22: Verify Shipping Address Info");
		verifyTrue(userCheckoutPage.isPaymentInfoDisplayByCategory("name", firstName));
		verifyTrue(userCheckoutPage.isPaymentInfoDisplayByCategory("name", lastName));
		verifyTrue(userCheckoutPage.isPaymentInfoDisplayByCategory("email", emailAddress));
		verifyTrue(userCheckoutPage.isPaymentInfoDisplayByCategory("phone", phoneNumber));
		verifyTrue(userCheckoutPage.isPaymentInfoDisplayByCategory("address1", address1));
		verifyTrue(userCheckoutPage.isPaymentInfoDisplayByCategory("city-state-zip", city));
		verifyTrue(userCheckoutPage.isPaymentInfoDisplayByCategory("city-state-zip", state));
		verifyTrue(userCheckoutPage.isPaymentInfoDisplayByCategory("country", country));
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 23: Verify Shipping Method Info");
		verifyTrue(userCheckoutPage.isPaymentOrShippingMethodInfoOnCheckoutPageDisplayed("shipping-method").contains("Next Day Air"));
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 24: Verify Product Info");
		verifyTrue(userCheckoutPage.isImageDisplayed());
		verifyTrue(userCheckoutPage.isProductNameAddedOnWishlistPage(productNameLenovo));
		verifyTrue(userCheckoutPage.isProductPriceAddedOnWishlistPage(productPriceLenovo));
		verifyTrue(userCheckoutPage.isProductQuantityAddedOnWishlistPage(newQuantityLenovo));
		verifyTrue(userCheckoutPage.isTotalFieldUpdated(productPriceLenovo, newQuantityLenovo));
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 25: Verify Cart Total Info");
		verifyTrue(userCheckoutPage.verifySubCartTotalIsDisplayed(productPriceLenovo, newQuantityLenovo, giftWrapping));
		verifyTrue(userCheckoutPage.verifyCartTotalIsDisplayedByClassName("shipping-cost", shipping));
		verifyTrue(userCheckoutPage.verifyCartTotalIsDisplayedByClassName("tax-value", tax));
		verifyTrue(userCheckoutPage.verifyCartTotalIsDisplayed(productPriceLenovo, newQuantityLenovo, giftWrapping, shipping, tax));
		verifyTrue(userCheckoutPage.verifyPointIsDisplayed(productPriceLenovo, newQuantityLenovo, giftWrapping, shipping, tax));
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 26: Click to 'Confirm' button");
		userCheckoutPage.clickToContinueButtonById("confirm-order-buttons-container","Confirm");
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 27: Verify succesfully order process");
		verifyTrue(userCheckoutPage.isSuccessfullyProcessMessageDisplayed());
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 28: Get order number");
		orderNumber = userCheckoutPage.getOrderNumber();
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 29: Click to 'Continue' button");
		userCheckoutPage.clickToContinueButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 30: Click to 'My Account' linktext");
		userMyAccountPage = userCheckoutPage.openMyAccountPage(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 31: Click to 'Order' linktext");
		userOrderPage = userMyAccountPage.openOrderPage(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 32: Compare order number is display");
		verifyTrue(userOrderPage.verifyOrderNumber().contains(orderNumber));
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 33: Click to 'detail' button");
		userOrderPage.clickToDetailButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 34: Verify order number");
		verifyTrue(userOrderPage.verifyOrderNumberOnOrderInformation().contains(orderNumber));
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 35: Verify order date");
		verifyTrue(userOrderPage.verifyOrderDateOnOrderInformation());
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 36: Verify order status");
		verifyTrue(userOrderPage.verifyOrderStatusOnOrderInformation().contains("Pending"));
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 37: Verify order total");
		verifyTrue(userOrderPage.verifyOrderTotalOnOrderInformation(productPriceLenovo, newQuantityLenovo, giftWrapping, shipping, tax));
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 38: Verify Billing Address Info");
		verifyTrue(userOrderPage.verifyBillingAddInfoByClass("name", firstName));
		verifyTrue(userOrderPage.verifyBillingAddInfoByClass("name", lastName));
		verifyTrue(userOrderPage.verifyBillingAddInfoByClass("email", emailAddress));
		verifyTrue(userOrderPage.verifyBillingAddInfoByClass("phone", phoneNumber));
		verifyTrue(userOrderPage.verifyBillingAddInfoByClass("address1", address1));
		verifyTrue(userOrderPage.verifyBillingAddInfoByClass("city-state-zip", zipCode));
		verifyTrue(userOrderPage.verifyBillingAddInfoByClass("country", country));
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 39: Verify Payment Info");
		verifyTrue(userOrderPage.verifyPaymentMethodInfoByClass("payment-method", "Money Order"));
		verifyTrue(userOrderPage.verifyPaymentMethodInfoByClass("payment-method-status", "Pending"));
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 40: Verify Shipping Address Info");
		verifyTrue(userOrderPage.verifyShippingAddInfoByClass("name", firstName));
		verifyTrue(userOrderPage.verifyShippingAddInfoByClass("name", lastName));
		verifyTrue(userOrderPage.verifyShippingAddInfoByClass("email", emailAddress));
		verifyTrue(userOrderPage.verifyShippingAddInfoByClass("phone", phoneNumber));
		verifyTrue(userOrderPage.verifyShippingAddInfoByClass("address1", address1));
		verifyTrue(userOrderPage.verifyShippingAddInfoByClass("city-state-zip", zipCode));
		verifyTrue(userOrderPage.verifyShippingAddInfoByClass("country", country));
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 41: Verify Shipping Method Info");
		verifyTrue(userOrderPage.verifyShippingInfoByClass("shipping-method", "Next Day Air"));
		verifyTrue(userOrderPage.verifyShippingInfoByClass("shipping-status", "Not yet shipped"));
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 42: Verify Product Info");
		verifyTrue(userOrderPage.isImageDisplayed());
		verifyTrue(userOrderPage.isProductNameAddedOnWishlistPage(productNameLenovo));
		verifyTrue(userOrderPage.isProductPriceAddedOnWishlistPage(productPriceLenovo));
		verifyTrue(userOrderPage.isProductQuantityAddedOnWishlistPage(newQuantityLenovo));
		verifyTrue(userOrderPage.isTotalFieldUpdated(productPriceLenovo, newQuantityLenovo));
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 43: Verify Gift wrapping Info");
		verifyTrue(userOrderPage.isGiftWrappingDisplayed());
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 44: Verify Sub-Total Info");
		verifyTrue(userOrderPage.verifySubCartTotalIsDisplayed("Sub-Total",productPriceLenovo, newQuantityLenovo, giftWrapping));
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 45: Verify Shipping Info");
		verifyTrue(userOrderPage.verifyCartTotalIsDisplayedByClassName("Shipping", shipping));
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 46: Verify Tax Info");
		verifyTrue(userOrderPage.verifyCartTotalIsDisplayedByClassName("Tax", tax));
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 47: Verify Order Total Info");
		verifyTrue(userOrderPage.verifyCartTotalIsDisplayed("Order Total", productPriceLenovo, newQuantityLenovo, giftWrapping, shipping, tax));
	}

	@Test
	public void TC_06_Checkout_By_Cart(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_06_Checkout_By_Cart");
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cart - Step 01: Input product name to search textbox by value: " + productNameLenovo);
		userOrderPage.inputKeywordToSearchTextbox(driver, productNameLenovo);
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cart - Step 02: Click to 'search' button ");
		userSearchKeywordPage = userOrderPage.clickToSearchButton();

		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cart - Step 03: Click to 'Add to cart' button ");
		userSearchKeywordPage.clickAddToCartButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cart - Step 04: Click to close icon");
		userSearchKeywordPage.clickToCloseIcon();
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cart - Step 05: Go to Shopping Cart by click to Shopping cart linktext");
		userShoppingCartPage = userSearchKeywordPage.clickToShoppingCartLinktext();
		productPriceLenovo = userShoppingCartPage.getProductPriceOnShoppingCartTable();

		ExtentTestManager.getTest().log(Status.INFO, "Update_Shopping_Cart - Step 06: Update quatity with value: " + newQuantityLenovo);
		userShoppingCartPage.inputProductQuantityToQtyTextbox(newQuantityLenovo);

		ExtentTestManager.getTest().log(Status.INFO, "Update_Shopping_Cart - Step 07: Click to 'Update shopping cart' button");
		userShoppingCartPage.clickToUpdateShoppingCartButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 08: Select 'Gift Wrapping' with value: " + giftWrapping);
		userShoppingCartPage.selectGiftWrapping(giftWrapping);
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 09: Verify updated info of gift wapping");
		verifyTrue(userShoppingCartPage.isGiftWrappingDisplayed());

		ExtentTestManager.getTest().log(Status.INFO, 
				"Checkout_By_Cheque - Step 07: Click to 'I agree with the terms of service and I adhere to them unconditionally' checkbox");
		userShoppingCartPage.clickToAgreeTermCheckbox();
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 10: Click to 'Checkout' button");
		userCheckoutPage = userShoppingCartPage.clickToCheckoutButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 11: Click to 'Continue' button");
		userCheckoutPage.clickToContinueButtonById("billing-buttons-container","Continue");
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 12: Click to 'Next day air' checkbox");
		userCheckoutPage.clickToNextDayAirCheckbox();
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 13: Click to 'Continue' button");
		userCheckoutPage.clickToContinueButtonById("shipping-method-buttons-container","Continue");
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 14: Click to 'Check/Money Order' checkbox");
		
		userCheckoutPage.clickToCreditCardCheckbox();
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 15: Click to 'Continue' button");
		userCheckoutPage.clickToContinueButtonById("payment-method-buttons-container","Continue");
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 16: Select credit card dropdown list");
		userCheckoutPage.selectCreditCardDropdownList(cardType);
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 17: Input card holder name");
		userCheckoutPage.inputCardHolderName(cardHolderName);
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 18: Input card number");
		userCheckoutPage.inputCardNumber(cardNumber);
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 19: Select expiration date - month");
		userCheckoutPage.selectExpirationDateById("ExpireMonth", expirationMonth);
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 20: Select expiration date - year");
		userCheckoutPage.selectExpirationDateById("ExpireYear", expirationYear);
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 21: Input card code");
		userCheckoutPage.inputCardCode(cardCode);
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 22: Click to 'Continue' button");
		userCheckoutPage.clickToContinueButtonById("payment-info-buttons-container","Continue");
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 23: Verify Billing Address Info");
		verifyTrue(userCheckoutPage.isBillingAddressInfoDisplayByCategory("name", firstName));
		verifyTrue(userCheckoutPage.isBillingAddressInfoDisplayByCategory("name", lastName));
		verifyTrue(userCheckoutPage.isBillingAddressInfoDisplayByCategory("email", emailAddress));
		verifyTrue(userCheckoutPage.isBillingAddressInfoDisplayByCategory("phone", phoneNumber));
		verifyTrue(userCheckoutPage.isBillingAddressInfoDisplayByCategory("address1", address1));
		verifyTrue(userCheckoutPage.isBillingAddressInfoDisplayByCategory("city-state-zip", city));
		verifyTrue(userCheckoutPage.isBillingAddressInfoDisplayByCategory("city-state-zip", state));
		verifyTrue(userCheckoutPage.isBillingAddressInfoDisplayByCategory("country", country));
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 24: Verify Payment Info");
		verifyTrue(userCheckoutPage.isPaymentOrShippingMethodInfoOnCheckoutPageDisplayed("payment-method").contains("Credit Card"));
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 25: Verify Shipping Address Info");
		verifyTrue(userCheckoutPage.isPaymentInfoDisplayByCategory("name", firstName));
		verifyTrue(userCheckoutPage.isPaymentInfoDisplayByCategory("name", lastName));
		verifyTrue(userCheckoutPage.isPaymentInfoDisplayByCategory("email", emailAddress));
		verifyTrue(userCheckoutPage.isPaymentInfoDisplayByCategory("phone", phoneNumber));
		verifyTrue(userCheckoutPage.isPaymentInfoDisplayByCategory("address1", address1));
		verifyTrue(userCheckoutPage.isPaymentInfoDisplayByCategory("city-state-zip", city));
		verifyTrue(userCheckoutPage.isPaymentInfoDisplayByCategory("city-state-zip", state));
		verifyTrue(userCheckoutPage.isPaymentInfoDisplayByCategory("country", country));
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 26: Verify Shipping Method Info");
		verifyTrue(userCheckoutPage.isPaymentOrShippingMethodInfoOnCheckoutPageDisplayed("shipping-method").contains("Next Day Air"));
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 27: Verify Product Info");
		verifyTrue(userCheckoutPage.isImageDisplayed());
		verifyTrue(userCheckoutPage.isProductNameAddedOnWishlistPage(productNameLenovo));
		verifyTrue(userCheckoutPage.isProductPriceAddedOnWishlistPage(productPriceLenovo));
		verifyTrue(userCheckoutPage.isProductQuantityAddedOnWishlistPage(newQuantityLenovo));
		verifyTrue(userCheckoutPage.isTotalFieldUpdated(productPriceLenovo, newQuantityLenovo));
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 28: Verify Cart Total Info");
		verifyTrue(userCheckoutPage.verifySubCartTotalIsDisplayed(productPriceLenovo, newQuantityLenovo, giftWrapping));
		verifyTrue(userCheckoutPage.verifyCartTotalIsDisplayedByClassName("shipping-cost", shipping));
		verifyTrue(userCheckoutPage.verifyCartTotalIsDisplayedByClassName("tax-value", tax));
		verifyTrue(userCheckoutPage.verifyCartTotalIsDisplayed(productPriceLenovo, newQuantityLenovo, giftWrapping, shipping, tax));
		verifyTrue(userCheckoutPage.verifyPointIsDisplayed(productPriceLenovo, newQuantityLenovo, giftWrapping, shipping, tax));
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 29: Click to 'Confirm' button");
		userCheckoutPage.clickToContinueButtonById("confirm-order-buttons-container","Confirm");
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 30: Verify succesfully order process");
		verifyTrue(userCheckoutPage.isSuccessfullyProcessMessageDisplayed());
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 31: Get order number");
		orderNumber = userCheckoutPage.getOrderNumber();
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 32: Click to 'Continue' button");
		userCheckoutPage.clickToContinueButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 33: Click to 'My Account' linktext");
		userMyAccountPage = userCheckoutPage.openMyAccountPage(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 34: Click to 'Order' linktext");
		userOrderPage = userMyAccountPage.openOrderPage(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 35: Compare order number is display");
		verifyTrue(userOrderPage.verifyOrderNumber().contains(orderNumber));
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 36: Click to 'detail' button");
		userOrderPage.clickToDetailButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 37: Verify order number");
		verifyTrue(userOrderPage.verifyOrderNumberOnOrderInformation().contains(orderNumber));
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 38: Verify order date");
		verifyTrue(userOrderPage.verifyOrderDateOnOrderInformation());
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 39: Verify order status");
		verifyTrue(userOrderPage.verifyOrderStatusOnOrderInformation().contains("Pending"));
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 40: Verify order total");
		verifyTrue(userOrderPage.verifyOrderTotalOnOrderInformation(productPriceLenovo, newQuantityLenovo, giftWrapping, shipping, tax));
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 41: Verify Billing Address Info");
		verifyTrue(userOrderPage.verifyBillingAddInfoByClass("name", firstName));
		verifyTrue(userOrderPage.verifyBillingAddInfoByClass("name", lastName));
		verifyTrue(userOrderPage.verifyBillingAddInfoByClass("email", emailAddress));
		verifyTrue(userOrderPage.verifyBillingAddInfoByClass("phone", phoneNumber));
		verifyTrue(userOrderPage.verifyBillingAddInfoByClass("address1", address1));
		verifyTrue(userOrderPage.verifyBillingAddInfoByClass("city-state-zip", zipCode));
		verifyTrue(userOrderPage.verifyBillingAddInfoByClass("country", country));
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 42: Verify Payment Info");
		verifyTrue(userOrderPage.verifyPaymentMethodInfoByClass("payment-method", "Credit Card"));
		verifyTrue(userOrderPage.verifyPaymentMethodInfoByClass("payment-method-status", "Pending"));
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 42: Verify Shipping Address Info");
		verifyTrue(userOrderPage.verifyShippingAddInfoByClass("name", firstName));
		verifyTrue(userOrderPage.verifyShippingAddInfoByClass("name", lastName));
		verifyTrue(userOrderPage.verifyShippingAddInfoByClass("email", emailAddress));
		verifyTrue(userOrderPage.verifyShippingAddInfoByClass("phone", phoneNumber));
		verifyTrue(userOrderPage.verifyShippingAddInfoByClass("address1", address1));
		verifyTrue(userOrderPage.verifyShippingAddInfoByClass("city-state-zip", zipCode));
		verifyTrue(userOrderPage.verifyShippingAddInfoByClass("country", country));
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 44: Verify Shipping Method Info");
		verifyTrue(userOrderPage.verifyShippingInfoByClass("shipping-method", "Next Day Air"));
		verifyTrue(userOrderPage.verifyShippingInfoByClass("shipping-status", "Not yet shipped"));
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 45: Verify Product Info");
		verifyTrue(userOrderPage.isImageDisplayed());
		verifyTrue(userOrderPage.isProductNameAddedOnWishlistPage(productNameLenovo));
		verifyTrue(userOrderPage.isProductPriceAddedOnWishlistPage(productPriceLenovo));
		verifyTrue(userOrderPage.isProductQuantityAddedOnWishlistPage(newQuantityLenovo));
		verifyTrue(userOrderPage.isTotalFieldUpdated(productPriceLenovo, newQuantityLenovo));
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 46: Verify Gift wrapping Info");
		verifyTrue(userOrderPage.isGiftWrappingDisplayed());
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 47: Verify Sub-Total Info");
		verifyTrue(userOrderPage.verifySubCartTotalIsDisplayed("Sub-Total", productPriceLenovo, newQuantityLenovo, giftWrapping));
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 48: Verify Shipping Info");
		verifyTrue(userOrderPage.verifyCartTotalIsDisplayedByClassName("Shipping", shipping));
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 49: Verify Tax Info");
		verifyTrue(userOrderPage.verifyCartTotalIsDisplayedByClassName("Tax", tax));
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout_By_Cheque - Step 50: Verify Order Total Info");
		verifyTrue(userOrderPage.verifyCartTotalIsDisplayed("Order Total", productPriceLenovo, newQuantityLenovo, giftWrapping, shipping, tax));
	}

	@Test
	public void TC_07_Re_Order(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_07_Re_Order");
		ExtentTestManager.getTest().log(Status.INFO, "Re_Order - Step 01: Click to 'My Account' linktext");
		userMyAccountPage = userOrderPage.openMyAccountPage(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Re_Order - Step 02: Click to 'Order' linktext");
		userOrderPage = userMyAccountPage.openOrderPage(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Re_Order - Step 03: Click to 'detail' button");
		userOrderPage.clickToDetailButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Re_Order - Step 04: Click to 're-order' button");
		
		userShoppingCartPage = userOrderPage.clickToReOderButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Re_Order - Step 06: Update quatity with value: " + newQuantityLenovo);
		userShoppingCartPage.inputProductQuantityToQtyTextbox(updateNewReOrderQuantity);

		ExtentTestManager.getTest().log(Status.INFO, "Re_Order - Step 07: Click to 'Update shopping cart' button");
		userShoppingCartPage.clickToUpdateShoppingCartButton();

		ExtentTestManager.getTest().log(Status.INFO, "Re_Order - Step 08: Verify total is updated");
		verifyTrue(userShoppingCartPage.isTotalFieldUpdated(productPriceLenovo, updateNewReOrderQuantity));
		
		ExtentTestManager.getTest().log(Status.INFO, 
				"Re_Order - Step 09: Click to 'I agree with the terms of service and I adhere to them unconditionally' checkbox");
		userShoppingCartPage.clickToAgreeTermCheckbox();
		
		ExtentTestManager.getTest().log(Status.INFO, "Re_Order - Step 10: Click to 'Checkout' button");
		userCheckoutPage = userShoppingCartPage.clickToCheckoutButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Re_Order - Step 11: Click to 'Continue' button");
		userCheckoutPage.clickToContinueButtonById("billing-buttons-container","Continue");
		
		ExtentTestManager.getTest().log(Status.INFO, "Re_Order - Step 12: Click to 'Next day air' checkbox");
		userCheckoutPage.clickToNextDayAirCheckbox();
		
		ExtentTestManager.getTest().log(Status.INFO, "Re_Order - Step 13: Click to 'Continue' button");
		userCheckoutPage.clickToContinueButtonById("shipping-method-buttons-container","Continue");
		
		ExtentTestManager.getTest().log(Status.INFO, "Re_Order - Step 14: Click to 'Check/Money Order' checkbox");
		
		userCheckoutPage.clickToCreditCardCheckbox();
		
		ExtentTestManager.getTest().log(Status.INFO, "Re_Order - Step 15: Click to 'Continue' button");
		userCheckoutPage.clickToContinueButtonById("payment-method-buttons-container","Continue");
		
		ExtentTestManager.getTest().log(Status.INFO, "Re_Order - Step 16: Select credit card dropdown list");
		userCheckoutPage.selectCreditCardDropdownList(cardType);
		
		ExtentTestManager.getTest().log(Status.INFO, "Re_Order - Step 17: Input card holder name");
		userCheckoutPage.inputCardHolderName(cardHolderName);
		
		ExtentTestManager.getTest().log(Status.INFO, "Re_Order - Step 18: Input card number");
		userCheckoutPage.inputCardNumber(cardNumber);
		
		ExtentTestManager.getTest().log(Status.INFO, "Re_Order - Step 19: Select expiration date - month");
		userCheckoutPage.selectExpirationDateById("ExpireMonth", expirationMonth);
		
		ExtentTestManager.getTest().log(Status.INFO, "Re_Order - Step 20: Select expiration date - year");
		userCheckoutPage.selectExpirationDateById("ExpireYear", expirationYear);
		
		ExtentTestManager.getTest().log(Status.INFO, "Re_Order - Step 21: Input card code");
		userCheckoutPage.inputCardCode(cardCode);
		
		ExtentTestManager.getTest().log(Status.INFO, "Re_Order - Step 22: Click to 'Continue' button");
		userCheckoutPage.clickToContinueButtonById("payment-info-buttons-container","Continue");
		
		ExtentTestManager.getTest().log(Status.INFO, "Re_Order - Step 23: Verify Billing Address Info");
		verifyTrue(userCheckoutPage.isBillingAddressInfoDisplayByCategory("name", firstName));
		verifyTrue(userCheckoutPage.isBillingAddressInfoDisplayByCategory("name", lastName));
		verifyTrue(userCheckoutPage.isBillingAddressInfoDisplayByCategory("email", emailAddress));
		verifyTrue(userCheckoutPage.isBillingAddressInfoDisplayByCategory("phone", phoneNumber));
		verifyTrue(userCheckoutPage.isBillingAddressInfoDisplayByCategory("address1", address1));
		verifyTrue(userCheckoutPage.isBillingAddressInfoDisplayByCategory("city-state-zip", city));
		verifyTrue(userCheckoutPage.isBillingAddressInfoDisplayByCategory("city-state-zip", state));
		verifyTrue(userCheckoutPage.isBillingAddressInfoDisplayByCategory("country", country));
		
		ExtentTestManager.getTest().log(Status.INFO, "Re_Order - Step 24: Verify Payment Info");
		verifyTrue(userCheckoutPage.isPaymentOrShippingMethodInfoOnCheckoutPageDisplayed("payment-method").contains("Credit Card"));
		
		ExtentTestManager.getTest().log(Status.INFO, "Re_Order - Step 25: Verify Shipping Address Info");
		verifyTrue(userCheckoutPage.isPaymentInfoDisplayByCategory("name", firstName));
		verifyTrue(userCheckoutPage.isPaymentInfoDisplayByCategory("name", lastName));
		verifyTrue(userCheckoutPage.isPaymentInfoDisplayByCategory("email", emailAddress));
		verifyTrue(userCheckoutPage.isPaymentInfoDisplayByCategory("phone", phoneNumber));
		verifyTrue(userCheckoutPage.isPaymentInfoDisplayByCategory("address1", address1));
		verifyTrue(userCheckoutPage.isPaymentInfoDisplayByCategory("city-state-zip", city));
		verifyTrue(userCheckoutPage.isPaymentInfoDisplayByCategory("city-state-zip", state));
		verifyTrue(userCheckoutPage.isPaymentInfoDisplayByCategory("country", country));
		
		ExtentTestManager.getTest().log(Status.INFO, "Re_Order - Step 26: Verify Shipping Method Info");
		verifyTrue(userCheckoutPage.isPaymentOrShippingMethodInfoOnCheckoutPageDisplayed("shipping-method").contains("Next Day Air"));
		
		ExtentTestManager.getTest().log(Status.INFO, "Re_Order - Step 27: Verify Product Info");
		verifyTrue(userCheckoutPage.isImageDisplayed());
		verifyTrue(userCheckoutPage.isProductNameAddedOnWishlistPage(productNameLenovo));
		verifyTrue(userCheckoutPage.isProductPriceAddedOnWishlistPage(productPriceLenovo));
		verifyTrue(userCheckoutPage.isProductQuantityAddedOnWishlistPage(updateNewReOrderQuantity));
		verifyTrue(userCheckoutPage.isTotalFieldUpdated(productPriceLenovo, updateNewReOrderQuantity));
		
		ExtentTestManager.getTest().log(Status.INFO, "Re_Order - Step 28: Verify Cart Total Info");
		verifyTrue(userCheckoutPage.verifySubCartTotalIsDisplayed(productPriceLenovo, newQuantityLenovo, giftWrapping));
		verifyTrue(userCheckoutPage.verifyCartTotalIsDisplayedByClassName("shipping-cost", shipping));
		verifyTrue(userCheckoutPage.verifyCartTotalIsDisplayedByClassName("tax-value", tax));
		verifyTrue(userCheckoutPage.verifyCartTotalIsDisplayed(productPriceLenovo, updateNewReOrderQuantity, giftWrapping, shipping, tax));
		verifyTrue(userCheckoutPage.verifyPointIsDisplayed(productPriceLenovo, updateNewReOrderQuantity, giftWrapping, shipping, tax));
		
		ExtentTestManager.getTest().log(Status.INFO, "Re_Order - Step 29: Click to 'Confirm' button");
		userCheckoutPage.clickToContinueButtonById("confirm-order-buttons-container","Confirm");
		
		ExtentTestManager.getTest().log(Status.INFO, "Re_Order - Step 30: Verify succesfully order process");
		verifyTrue(userCheckoutPage.isSuccessfullyProcessMessageDisplayed());
		
		ExtentTestManager.getTest().log(Status.INFO, "Re_Order - Step 31: Get order number");
		orderNumber = userCheckoutPage.getOrderNumber();
		
		ExtentTestManager.getTest().log(Status.INFO, "Re_Order - Step 32: Click to 'Continue' button");
		userCheckoutPage.clickToContinueButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Re_Order - Step 33: Click to 'My Account' linktext");
		userMyAccountPage = userCheckoutPage.openMyAccountPage(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Re_Order - Step 34: Click to 'Order' linktext");
		userOrderPage = userMyAccountPage.openOrderPage(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Re_Order - Step 35: Compare order number is display");
		verifyTrue(userOrderPage.verifyOrderNumber().contains(orderNumber));
		
		ExtentTestManager.getTest().log(Status.INFO, "Re_Order - Step 36: Click to 'detail' button");
		userOrderPage.clickToDetailButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Re_Order - Step 37: Verify order number");
		verifyTrue(userOrderPage.verifyOrderNumberOnOrderInformation().contains(orderNumber));
		
		ExtentTestManager.getTest().log(Status.INFO, "Re_Order - Step 38: Verify order date");
		verifyTrue(userOrderPage.verifyOrderDateOnOrderInformation());
		
		ExtentTestManager.getTest().log(Status.INFO, "Re_Order - Step 39: Verify order status");
		verifyTrue(userOrderPage.verifyOrderStatusOnOrderInformation().contains("Pending"));
		
		ExtentTestManager.getTest().log(Status.INFO, "Re_Order - Step 40: Verify order total");
		verifyTrue(userOrderPage.verifyOrderTotalOnOrderInformation(productPriceLenovo, updateNewReOrderQuantity, giftWrapping, shipping, tax));
		
		ExtentTestManager.getTest().log(Status.INFO, "Re_Order - Step 41: Verify Billing Address Info");
		verifyTrue(userOrderPage.verifyBillingAddInfoByClass("name", firstName));
		verifyTrue(userOrderPage.verifyBillingAddInfoByClass("name", lastName));
		verifyTrue(userOrderPage.verifyBillingAddInfoByClass("email", emailAddress));
		verifyTrue(userOrderPage.verifyBillingAddInfoByClass("phone", phoneNumber));
		verifyTrue(userOrderPage.verifyBillingAddInfoByClass("address1", address1));
		verifyTrue(userOrderPage.verifyBillingAddInfoByClass("city-state-zip", zipCode));
		verifyTrue(userOrderPage.verifyBillingAddInfoByClass("country", country));
		
		ExtentTestManager.getTest().log(Status.INFO, "Re_Order - Step 42: Verify Payment Info");
		verifyTrue(userOrderPage.verifyPaymentMethodInfoByClass("payment-method", "Credit Card"));
		verifyTrue(userOrderPage.verifyPaymentMethodInfoByClass("payment-method-status", "Pending"));
		
		ExtentTestManager.getTest().log(Status.INFO, "Re_Order - Step 43: Verify Shipping Address Info");
		verifyTrue(userOrderPage.verifyShippingAddInfoByClass("name", firstName));
		verifyTrue(userOrderPage.verifyShippingAddInfoByClass("name", lastName));
		verifyTrue(userOrderPage.verifyShippingAddInfoByClass("email", emailAddress));
		verifyTrue(userOrderPage.verifyShippingAddInfoByClass("phone", phoneNumber));
		verifyTrue(userOrderPage.verifyShippingAddInfoByClass("address1", address1));
		verifyTrue(userOrderPage.verifyShippingAddInfoByClass("city-state-zip", zipCode));
		verifyTrue(userOrderPage.verifyShippingAddInfoByClass("country", country));
		
		ExtentTestManager.getTest().log(Status.INFO, "Re_Order - Step 44: Verify Shipping Method Info");
		verifyTrue(userOrderPage.verifyShippingInfoByClass("shipping-method", "Next Day Air"));
		verifyTrue(userOrderPage.verifyShippingInfoByClass("shipping-status", "Not yet shipped"));
		
		ExtentTestManager.getTest().log(Status.INFO, "Re_Order - Step 45: Verify Product Info");
		verifyTrue(userOrderPage.isImageDisplayed());
		verifyTrue(userOrderPage.isProductNameAddedOnWishlistPage(productNameLenovo));
		verifyTrue(userOrderPage.isProductPriceAddedOnWishlistPage(productPriceLenovo));
		verifyTrue(userOrderPage.isProductQuantityAddedOnWishlistPage(updateNewReOrderQuantity));
		verifyTrue(userOrderPage.isTotalFieldUpdated(productPriceLenovo, updateNewReOrderQuantity));
		
		ExtentTestManager.getTest().log(Status.INFO, "Re_Order - Step 46: Verify Gift wrapping Info");
		verifyTrue(userOrderPage.isGiftWrappingDisplayed());
		
		ExtentTestManager.getTest().log(Status.INFO, "Re_Order - Step 47: Verify Sub-Total Info");
		verifyTrue(userOrderPage.verifySubCartTotalIsDisplayed("Sub-Total", productPriceLenovo, updateNewReOrderQuantity, giftWrapping));
		
		ExtentTestManager.getTest().log(Status.INFO, "Re_Order - Step 48: Verify Shipping Info");
		verifyTrue(userOrderPage.verifyCartTotalIsDisplayedByClassName("Shipping", shipping));
		
		ExtentTestManager.getTest().log(Status.INFO, "Re_Order - Step 49: Verify Tax Info");
		verifyTrue(userOrderPage.verifyCartTotalIsDisplayedByClassName("Tax", tax));
		
		ExtentTestManager.getTest().log(Status.INFO, "Re_Order - Step 50: Verify Order Total Info");
		verifyTrue(userOrderPage.verifyCartTotalIsDisplayed("Order Total", productPriceLenovo, updateNewReOrderQuantity, giftWrapping, shipping, tax));
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

}
