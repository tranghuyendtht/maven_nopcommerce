package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register_Cookie;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.User.UserCheckoutPageObject;
import pageObjects.nopcommerce.User.UserComputerProductPageObject;
import pageObjects.nopcommerce.User.UserHomePageObject;
import pageObjects.nopcommerce.User.UserLoginPageObject;
import pageObjects.nopcommerce.User.UserProductDetailPageObject;
import pageObjects.nopcommerce.User.UserSearchKeywordPageObject;
import pageObjects.nopcommerce.User.UserShoppingCartPageObject;
import utilities.DataHelper;

public class User_Order extends BaseTest {

	WebDriver driver;
	DataHelper fakeData;
	UserHomePageObject userHomePage;
	UserLoginPageObject userLoginPage;
	UserComputerProductPageObject userComputerProductPage;
	UserProductDetailPageObject userProductDetailPage;
	UserShoppingCartPageObject userShoppingCartPage;
	UserSearchKeywordPageObject userSearchKeywordPage;
	UserCheckoutPageObject userCheckoutPage;

	String productName, productSKU, productPrice;
	String shoppingCartUrl;
	String productQuantity;
	String shipping, tax, giftWrapping;
	String productNameLenovo, newQuantityLenovo, productPriceLenovo;
	String firstName, lastName, emailAddress, country, state, city, address1, zipCode, phoneNumber;
	String orderNumber;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		log.info("Pre-Condition: Go to page");
		driver = getBrowserDriver(browserName, appUrl);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		fakeData = DataHelper.getData();

		productName = "Apple MacBook Pro 13-inch";
		productNameLenovo = "Lenovo IdeaCentre 600 All-in-One PC";
		productQuantity = "2";
		newQuantityLenovo = "5";
		giftWrapping = "Yes [+$10.00]";
		shipping = "$0.00";
		tax = "$0.00";

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
		userLoginPage.setCookies(driver, Common_01_Register_Cookie.loggedCookies);
		userLoginPage.refreshPage(driver);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

	}

	@Test
	public void TC_01_Add_Product_To_Cart() {

		log.info("Add_Product_To_Cart - Step 01: Open a product");
		userComputerProductPage = userHomePage.clickToLinkTextOnHeaderMenuByText("Computers");
		userComputerProductPage.clickToSubMenuLinkTextOnHeaderMenuByText("Notebooks");

		log.info("Add_Product_To_Cart - Step 02: Click to see detail product");
		userProductDetailPage = userComputerProductPage.clickToProductByName(productName);

		log.info("Add_Product_To_Cart - Step 03: Get product info");
		productSKU = userProductDetailPage.getProductSKU();
		productPrice = userProductDetailPage.getProductPrice();

		log.info("Add_Product_To_Cart - Step 04: Click 'Add to cart' button");
		userProductDetailPage.clickToAddToCartButton();

		log.info(
				"Add_Product_To_Cart - Step 05: Verify message 'The product has been added to your shopping cart' displayed ");
		verifyTrue(userProductDetailPage.isAddedProductIntoCartMessageDisplayed());

		log.info("Add_Product_To_Cart - Step 06: Click icon to close bar notification");
		userProductDetailPage.clickToCloseIcon();

		log.info(
				"Add_Product_To_Cart - Step 07: Verify product on shopping cart when hover mouse on 'Shopping cart' linktext");
		verifyEquals(userProductDetailPage.isMessageProductNameAddedIntoCartDisplayed(),
				"There are 2 item(s) in your cart.");
		verifyEquals(userProductDetailPage.isProductNameAddedIntoCart(), productName);
		verifyEquals(userProductDetailPage.isProductPriceAddedIntoCart(), productPrice);
		verifyEquals(userProductDetailPage.isProductQuantityAddedIntoCart(), "2");
		verifyTrue(userProductDetailPage.isProductSubTotalDisplayed(productPrice, productQuantity));

	}

	@Test
	public void TC_02_Edit_Product_On_Shopping_Cart() {
		log.info("Edit_Product_On_Shopping_Cart - Step 01: Click to 'Shopping cart' linktext on header page");
		userShoppingCartPage = userProductDetailPage.clickToShoppingCartLinktext();

		log.info("Edit_Product_On_Shopping_Cart - Step 02: Get shopping cart url link");
		shoppingCartUrl = userShoppingCartPage.getCurrentUrl(driver);

		log.info("Edit_Product_On_Shopping_Cart - Step 02: Update quantity with value: " + productQuantity);
		userShoppingCartPage.inputProductQuantityToQtyTextbox(productQuantity);

		log.info("Edit_Product_On_Shopping_Cart - Step 03: Click to 'Update shopping cart' button " + productQuantity);
		userShoppingCartPage.clickToUpdateShoppingCartButton();

		log.info("Edit_Product_On_Shopping_Cart - Step 04: Verify quantity field updated");
		verifyEquals(userShoppingCartPage.isQuantityFieldUpdated(), productQuantity);

		log.info("Edit_Product_On_Shopping_Cart - Step 05: Verify sub-total and total field updated");
		verifyTrue(userShoppingCartPage.isSubTotalFieldUpdated(productPrice, productQuantity));
		verifyTrue(userShoppingCartPage.isTotalFieldUpdated(productPrice, productQuantity, shipping, tax));

	}

	@Test
	public void TC_03_Remove_From_Cart() {
		log.info("Remove_From_Cart - Step 01: Go to shopping cart url link");
		userShoppingCartPage.navigateToUrlByJS(driver, shoppingCartUrl);

		log.info("Remove_From_Cart - Step 02: Remove product on shopping cart");
		userShoppingCartPage.clickToRemoveButton();

		log.info("Remove_From_Cart - Step 03: Verify 'Your Shopping Cart is empty!' message displayed");
		verifyTrue(userShoppingCartPage.isEmptyShoppingCartMessageDisplayed());

	}

	@Test
	public void TC_04_Update_Shopping_Cart() {
		log.info("Update_Shopping_Cart - Step 01: Input product name to search textbox by value: " + productNameLenovo);
		userShoppingCartPage.inputKeywordToSearchTextbox(driver, productNameLenovo);
		userSearchKeywordPage = PageGeneratorManager.getUserSearchKeywordPage(driver);

		log.info("Update_Shopping_Cart - Step 02: Click to 'search' button ");
		userSearchKeywordPage.clickToSearchButton();

		log.info("Update_Shopping_Cart - Step 03: Click to 'Add to cart' button ");
		userSearchKeywordPage.clickAddToCartButton();

		log.info("Update_Shopping_Cart - Step 04: Go to Shopping Cart by click to Shopping cart linktext");
		userShoppingCartPage = userSearchKeywordPage.clickToShoppingCartLinktext();
		productPriceLenovo = userShoppingCartPage.getProductPriceOnShoppingCartTable();

		log.info("Update_Shopping_Cart - Step 05: Update quatity with value: " + newQuantityLenovo);
		userShoppingCartPage.inputProductQuantityToQtyTextbox(newQuantityLenovo);

		log.info("Update_Shopping_Cart - Step 06: Click to 'Update shopping cart' button");
		userShoppingCartPage.clickToUpdateShoppingCartButton();

		log.info("Update_Shopping_Cart - Step 07: Verify total is updated");
		userShoppingCartPage.isTotalFieldUpdated(productPriceLenovo, newQuantityLenovo);

	}

	@Test
	public void TC_05_Checkout_By_Cheque() {
		log.info("Checkout_By_Cheque - Step 01: Input product name to search textbox by value: " + productNameLenovo);
		userShoppingCartPage.inputKeywordToSearchTextbox(driver, productNameLenovo);
		userSearchKeywordPage = PageGeneratorManager.getUserSearchKeywordPage(driver);

		log.info("Checkout_By_Cheque - Step 02: Click to 'search' button ");
		userSearchKeywordPage.clickToSearchButton();

		log.info("Checkout_By_Cheque - Step 03: Click to 'Add to cart' button ");
		userSearchKeywordPage.clickAddToCartButton();

		log.info("Checkout_By_Cheque - Step 04: Go to Shopping Cart by click to Shopping cart linktext");
		userShoppingCartPage = userSearchKeywordPage.clickToShoppingCartLinktext();

		log.info("Checkout_By_Cheque - Step 05: Select 'Gift Wrapping' with value: " + giftWrapping);
		userShoppingCartPage.selectGiftWrapping(giftWrapping);
		

		log.info("Checkout_By_Cheque - Step 06: Verify updated info of gift wapping");
		userShoppingCartPage.isGiftWrappingDisplayed();

		log.info(
				"Checkout_By_Cheque - Step 07: Click to 'I agree with the terms of service and I adhere to them unconditionally' checkbox");
		userShoppingCartPage.clickToAgreeTermCheckbox();
		

		log.info("Checkout_By_Cheque - Step 08: Click to 'Checkout' button");
		userCheckoutPage = userShoppingCartPage.clickToCheckoutButton();
		
		
		log.info("Checkout_By_Cheque - Step 09: Input to first name textbox with value: " + firstName);
		userCheckoutPage.inputToTextboxById("BillingNewAddress_FirstName", firstName);
		
		log.info("Checkout_By_Cheque - Step 10: Input to last name textbox with value: " + lastName);
		userCheckoutPage.inputToTextboxById("BillingNewAddress_LastName", lastName);
		
		log.info("Checkout_By_Cheque - Step 11: Input to email textbox with value: " + emailAddress);
		userCheckoutPage.inputToTextboxById("BillingNewAddress_Email", emailAddress);
		
		log.info("Checkout_By_Cheque - Step 09: Select to country dropdownlist with value: " + country);
		userCheckoutPage.selectCountryOrStateByValue("BillingNewAddress_CountryId",country);
		
		log.info("Checkout_By_Cheque - Step 09: Select to state dropdownlist with value: " + state);
		userCheckoutPage.selectCountryOrStateByValue("BillingNewAddress_StateProvinceId",state);
		
		log.info("Checkout_By_Cheque - Step 09: Input to city textbox with value: " + city);
		userCheckoutPage.inputToTextboxById("BillingNewAddress_City", city);
		
		log.info("Checkout_By_Cheque - Step 09: Input to address1 textbox with value: " + address1);
		userCheckoutPage.inputToTextboxById("BillingNewAddress_Address1", address1);
		
		log.info("Checkout_By_Cheque - Step 09: Input to zipCode textbox with value: " + zipCode);
		userCheckoutPage.inputToTextboxById("BillingNewAddress_ZipPostalCode", zipCode);
		
		log.info("Checkout_By_Cheque - Step 09: Input to phonenumber textbox with value: " + phoneNumber);
		userCheckoutPage.inputToTextboxById("BillingNewAddress_PhoneNumber", phoneNumber);

		log.info("Checkout_By_Cheque - Step 09: Click to 'Continue' button");
		userCheckoutPage.clickToContinueButtonById("billing-buttons-container","Continue");
		
		log.info("Checkout_By_Cheque - Step 09: Click to 'Next day air' checkbox");
		
		userCheckoutPage.clickToNextDayAirCheckbox();
		
		log.info("Checkout_By_Cheque - Step 09: Click to 'Continue' button");
		userCheckoutPage.clickToContinueButtonById("shipping-method-buttons-container","Continue");
		
		log.info("Checkout_By_Cheque - Step 09: Click to 'Check/Money Order' checkbox");
		
		userCheckoutPage.clickToCheckMoneyOrderCheckbox();
		
		log.info("Checkout_By_Cheque - Step 09: Click to 'Continue' button");
		userCheckoutPage.clickToContinueButtonById("payment-method-buttons-container","Continue");
		
		log.info("Checkout_By_Cheque - Step 09: Verify payment information");
		verifyEquals(userCheckoutPage.isConfirmOrderDisplayed(),"your order may be held for up to 10 days after we receive your check");
		
		log.info("Checkout_By_Cheque - Step 09: Click to 'Continue' button");
		userCheckoutPage.clickToContinueButtonById("payment-info-buttons-container","Continue");
		
		log.info("Checkout_By_Cheque - Step 09: Verify Billing Address Info");
		verifyTrue(userCheckoutPage.isBillingAddressInfoDisplayByCategory("name", firstName));
		verifyTrue(userCheckoutPage.isBillingAddressInfoDisplayByCategory("name", lastName));
		verifyTrue(userCheckoutPage.isBillingAddressInfoDisplayByCategory("email", emailAddress));
		verifyTrue(userCheckoutPage.isBillingAddressInfoDisplayByCategory("phone", phoneNumber));
		verifyTrue(userCheckoutPage.isBillingAddressInfoDisplayByCategory("address1", address1));
		verifyTrue(userCheckoutPage.isBillingAddressInfoDisplayByCategory("city-state-zip", city));
		verifyTrue(userCheckoutPage.isBillingAddressInfoDisplayByCategory("city-state-zip", state));
		verifyTrue(userCheckoutPage.isBillingAddressInfoDisplayByCategory("country", country));
		
		log.info("Checkout_By_Cheque - Step 09: Verify Payment Info");
		verifyEquals(userCheckoutPage.isPaymentOrShippingMethodInfoDisplayed("payment-method"),"Money Order");
		
		log.info("Checkout_By_Cheque - Step 09: Verify Shipping Address Info");
		verifyTrue(userCheckoutPage.isPaymentInfoDisplayByCategory("name", firstName));
		verifyTrue(userCheckoutPage.isPaymentInfoDisplayByCategory("name", lastName));
		verifyTrue(userCheckoutPage.isPaymentInfoDisplayByCategory("email", emailAddress));
		verifyTrue(userCheckoutPage.isPaymentInfoDisplayByCategory("phone", phoneNumber));
		verifyTrue(userCheckoutPage.isPaymentInfoDisplayByCategory("address1", address1));
		verifyTrue(userCheckoutPage.isPaymentInfoDisplayByCategory("city-state-zip", city));
		verifyTrue(userCheckoutPage.isPaymentInfoDisplayByCategory("city-state-zip", state));
		verifyTrue(userCheckoutPage.isPaymentInfoDisplayByCategory("country", country));
		
		log.info("Checkout_By_Cheque - Step 09: Verify Shipping Method Info");
		verifyEquals(userCheckoutPage.isPaymentOrShippingMethodInfoDisplayed("shipping-method"),"Next Day Air");
		
		log.info("Checkout_By_Cheque - Step 09: Verify Product Info");
		verifyTrue(userCheckoutPage.isSKUProductAddedOnWishlistPage(productSKU));
		verifyTrue(userCheckoutPage.isImageDisplayed());
		verifyTrue(userCheckoutPage.isProductNameAddedOnWishlistPage(productName));
		verifyTrue(userCheckoutPage.isProductPriceAddedOnWishlistPage(productPrice));
		verifyTrue(userCheckoutPage.isProductQuantityAddedOnWishlistPage(productQuantity));
		verifyTrue(userCheckoutPage.isTotalFieldUpdated(productPrice, productQuantity));
		
		log.info("Checkout_By_Cheque - Step 09: Verify Cart Total Info");
		verifyTrue(userCheckoutPage.verifySubCartTotalIsDisplayed(productPrice, productQuantity, giftWrapping));
		verifyTrue(userCheckoutPage.verifyCartTotalIsDisplayedByClassName("shipping-cost", shipping));
		verifyTrue(userCheckoutPage.verifyCartTotalIsDisplayedByClassName("tax-value", tax));
		verifyTrue(userCheckoutPage.verifyCartTotalIsDisplayed(productPrice, productQuantity, giftWrapping, shipping, tax));
		verifyTrue(userCheckoutPage.verifyPointIsDisplayed(productPrice, productQuantity, giftWrapping, shipping, tax));
		
		log.info("Checkout_By_Cheque - Step 09: Click to 'Confirm' button");
		userCheckoutPage.clickToContinueButtonById("confirm-order-buttons-container","Confirm");
		
		log.info("Checkout_By_Cheque - Step 09: Verify succesfully order process");
		verifyTrue(userCheckoutPage.isSuccessfullyProcessMessageDisplayed());
		
		log.info("Checkout_By_Cheque - Step 09: Get order number");
		orderNumber = userCheckoutPage.getOrderNumber();
		
		log.info("Checkout_By_Cheque - Step 09: Click to 'Continue' button");
		
		
		
		log.info("Checkout_By_Cheque - Step 09: Click to 'My Account' linktext");
		log.info("Checkout_By_Cheque - Step 09: Click to 'Order' linktext");
		log.info("Checkout_By_Cheque - Step 09: Compare order number is display");
		//div[@class='section order-item']//strong
		
		log.info("Checkout_By_Cheque - Step 09: Click to 'detail' button");
		//button[@class='button-2 order-details-button']
		
		log.info("Checkout_By_Cheque - Step 09: Verify order number");
		//div[@class='order-number']//strong
		
		log.info("Checkout_By_Cheque - Step 09: Verify order date");
		//li[@class='order-date']
		
		log.info("Checkout_By_Cheque - Step 09: Verify order status");
		//li[@class='order-status']
		
		log.info("Checkout_By_Cheque - Step 09: Verify order total");
		//li[@class='order-total']//strong
		
		log.info("Checkout_By_Cheque - Step 09: Verify Billing Address Info");
		
		log.info("Checkout_By_Cheque - Step 09: Verify Payment Info");
		
		log.info("Checkout_By_Cheque - Step 09: Verify Shipping Address Info");
		
		log.info("Checkout_By_Cheque - Step 09: Verify Shipping Method Info");
		
		log.info("Checkout_By_Cheque - Step 09: Verify Product Info");
		log.info("Checkout_By_Cheque - Step 09: Verify Gift wrapping Info");
		log.info("Checkout_By_Cheque - Step 09: Verify Sub-Total Info");
		log.info("Checkout_By_Cheque - Step 09: Verify Shipping Info");
		log.info("Checkout_By_Cheque - Step 09: Verify Tax Info");
		log.info("Checkout_By_Cheque - Step 09: Verify Order Total Info");
	}

	@Test
	public void TC_06_Checkout_By_Cart() {

	}

	@Test
	public void TC_07_Re_Order() {

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

}
