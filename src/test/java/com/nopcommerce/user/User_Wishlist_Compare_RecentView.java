package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import pageObjects.nopcommerce.Admin.PageGeneratorManager;
import pageObjects.nopcommerce.User.UserCompareProductsPageObject;
import pageObjects.nopcommerce.User.UserComputerProductPageObject;
import pageObjects.nopcommerce.User.UserHomePageObject;
import pageObjects.nopcommerce.User.UserLoginPageObject;
import pageObjects.nopcommerce.User.UserProductDetailPageObject;
import pageObjects.nopcommerce.User.UserRecentlyViewedProductsPageObject;
import pageObjects.nopcommerce.User.UserSearchKeywordPageObject;
import pageObjects.nopcommerce.User.UserShoppingCartPageObject;
import pageObjects.nopcommerce.User.UserWishListPageObject;

public class User_Wishlist_Compare_RecentView extends BaseTest {

	WebDriver driver;
	UserHomePageObject userHomePage;
	UserLoginPageObject userLoginPage;
	UserComputerProductPageObject userComputerProductPage;
	UserSearchKeywordPageObject userSearchKeywordPage;
	UserProductDetailPageObject userProductDetailPage;
	UserWishListPageObject userWishListPage;
	UserShoppingCartPageObject userShoppingCartPage;
	UserCompareProductsPageObject userCompareProductsPage;
	UserRecentlyViewedProductsPageObject userRecentlyViewedProductsPage;

	String productNotebooksUrl;
	String productName1, productName2, skuProduct, priceProduct1, priceProduct2;
	int quantityProduct;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		productNotebooksUrl = "https://demo.nopcommerce.com/notebooks";
		productName1 = "Lenovo IdeaCentre 600 All-in-One PC";
		productName2 = "Build your own computer";
		quantityProduct = 1;

		log.info("Pre-Condition - Step 05: Search product on 'Search' textbox");
		userHomePage.inputKeywordToSearchTextbox(driver, productName1);

		log.info("Pre-Condition - Step 06: Click to 'Search' textbox");
		userSearchKeywordPage = userHomePage.clickToSearchButton(driver);

		log.info("Pre-Condition - Step 06: Click to product");
		userProductDetailPage = userSearchKeywordPage.clickToProductTitle(productName1);
		skuProduct = userProductDetailPage.getProductSKU();
		priceProduct1 = userProductDetailPage.getProductPrice();
	}

	@Test
	public void TC_01_Add_To_Wishlist() {

		log.info("Add_To_Wishlist - Step 01: Click to 'Add to Wishlist' button");

		userProductDetailPage.clickToAddToWishlistButton();

		log.info(
				"Add_To_Wishlist - Step 01: Verify success message 'The product has been added to your wishlist' is displayed");

		verifyEquals(userProductDetailPage.isSuccessMessageDisplayed(), "The product has been added to your wishlist");

		log.info("Add_To_Wishlist - Step 01: Click to 'Wishlist' linktext");
		userWishListPage = userProductDetailPage.clickToWishlistLinkText();

		log.info("Add_To_Wishlist - Step 01: Verify added product in wishlist page");
		verifyTrue(userWishListPage.isSKUProductAddedOnWishlistPage(skuProduct));
		verifyTrue(userWishListPage.isImageDisplayed());
		verifyTrue(userWishListPage.isProductNameAddedOnWishlistPage(productName1));
		verifyTrue(userWishListPage.isProductPriceAddedOnWishlistPage(priceProduct1));
		verifyTrue(userWishListPage.isProductQuantityAddedOnWishlistPage(quantityProduct));
		verifyTrue(userWishListPage.isProductTotalAddedOnWishlistPage(priceProduct1));

		log.info("Add_To_Wishlist - Step 01: View wishlist from URL sharing by click Url");
		userWishListPage.clickToUrlSharing();

		log.info("Add_To_Wishlist - Step 01: Verify added product in wishlist page");
		verifyTrue(userWishListPage.isSKUProductAddedOnWishlistPage(skuProduct));
		verifyTrue(userWishListPage.isImageDisplayed());
		verifyTrue(userWishListPage.isProductNameAddedOnWishlistPage(productName1));
		verifyTrue(userWishListPage.isProductPriceAddedOnWishlistPage(priceProduct1));
		verifyTrue(userWishListPage.isProductQuantityAddedOnWishlistOfPage(quantityProduct));
		verifyTrue(userWishListPage.isProductTotalAddedOnWishlistPage(priceProduct1));

	}

	@Test
	public void TC_02_Add_Product_To_Cart_From_Wishlist_Page() {
		log.info("Add_Product_To_Cart_From_Wishlist_Page - Step 01: Click to checkbox on product");

		userWishListPage.clickToAddToCartCheckbox();

		log.info("Add_Product_To_Cart_From_Wishlist_Page - Step 01: Click to 'Add to cart' button form wishlist page");

		userShoppingCartPage = userWishListPage.clickToAddToCartButton();

		log.info("Add_Product_To_Cart_From_Wishlist_Page - Step 01: Verify product in shopping cart");
		verifyTrue(userShoppingCartPage.isSKUProductAddedOnWishlistPage(skuProduct));
		verifyTrue(userShoppingCartPage.isImageDisplayed());
		verifyTrue(userShoppingCartPage.isProductNameAddedOnWishlistPage(productName1));
		verifyTrue(userShoppingCartPage.isProductPriceAddedOnWishlistPage(priceProduct1));
		verifyTrue(userShoppingCartPage.isProductQuantityAddedOnWishlistPage(quantityProduct));
		verifyTrue(userShoppingCartPage.isProductTotalAddedOnWishlistPage(priceProduct1));

		log.info("Add_Product_To_Cart_From_Wishlist_Page - Step 01: Click to 'Wishlist' linktext on footer");
		userWishListPage = userShoppingCartPage.clickToWishlistLinktext();

		log.info("Add_Product_To_Cart_From_Wishlist_Page - Step 01: Verify product is removed from wishlist page");
		verifyTrue(userWishListPage.isProductUndisplayed());

	}

	@Test
	public void TC_03_Remove_Product_In_Wishlist_Page() {
		log.info("Remove_Product_In_Wishlist_Page - Step 01: Search product on 'Search' textbox");
		userWishListPage.inputKeywordToSearchTextbox(driver, productName1);

		log.info("Remove_Product_In_Wishlist_Page - Step 02: Click to 'Search' textbox");
		userSearchKeywordPage = userWishListPage.clickToSearchButton(driver);
		
		log.info("Remove_Product_In_Wishlist_Page - Step 03: Click to product");
		userProductDetailPage = userSearchKeywordPage.clickToProductTitle(productName1);

		log.info("Remove_Product_In_Wishlist_Page - Step 04: Click to 'Add to Wishlist' button");

		userProductDetailPage.clickToAddToWishlistButton();

		log.info("Remove_Product_In_Wishlist_Page - Step 05: Verify success message 'The product has been added to your wishlist' is displayed");

		verifyEquals(userProductDetailPage.isSuccessMessageDisplayed(), "The product has been added to your wishlist");

		log.info("Remove_Product_In_Wishlist_Page - Step 06: Click to 'Wishlist' linktext");
		userWishListPage = userProductDetailPage.clickToWishlistLinkText();
		
		log.info("Remove_Product_In_Wishlist_Page - Step 07: Click to remove icon");
		userWishListPage.clickToRemoveIcon();
		
		log.info("Remove_Product_In_Wishlist_Page - Step 08: Verify product is removed from wishlist page");
		verifyTrue(userWishListPage.isProductUndisplayed());

	}

	@Test
	public void TC_04_Add_Product_To_Compare() {

		log.info("Add_Product_To_Compare - Step 01: Search product on 'Search' textbox");
		userWishListPage.inputKeywordToSearchTextbox(driver, productName1);

		log.info("Add_Product_To_Compare - Step 02: Click to 'Search' textbox");
		userSearchKeywordPage = userWishListPage.clickToSearchButton(driver);
		
		log.info("Add_Product_To_Compare - Step 03: Click to 'Add to compare list' icon");
		userSearchKeywordPage.clickToAddCompareListIconByProductName(productName1);
		
		log.info("Add_Product_To_Compare - Step 03: Verify success message 'The product has been added to your product comparison' displayed.");
	
		verifyEquals(userSearchKeywordPage.verifySuccessMessageDisplay(), "The product has been added to your product comparison");
		
		log.info("Add_Product_To_Compare - Step 04: Search product on 'Search' textbox");
		userSearchKeywordPage.inputKeywordToSearchTextbox(driver, productName2);

		log.info("Add_Product_To_Compare - Step 05: Click to 'Search' textbox");
		userSearchKeywordPage.clickToSearchButton(driver);
		priceProduct2 = userSearchKeywordPage.getPriceProduct();
		
		log.info("Add_Product_To_Compare - Step 06: Click to 'Add to compare list' icon");
		userSearchKeywordPage.clickToAddCompareListIconByProductName(productName2);
		
		log.info("Add_Product_To_Compare - Step 07: Verify success message 'The product has been added to your product comparison' displayed.");
		verifyEquals(userSearchKeywordPage.verifySuccessMessageDisplay(), "The product has been added to your product comparison");
				
		log.info("Add_Product_To_Compare - Step 08: Click to 'Product comparison' linktext");
		userCompareProductsPage = userSearchKeywordPage.clickToProductCompariSonLinkText();
				
		log.info("Add_Product_To_Compare - Step 09: Verify product info in Product Comparison Page");
		verifyTrue(userCompareProductsPage.isRemoveIconDisplayed());
		verifyTrue(userCompareProductsPage.isImageProductDisplayedByProductName(productName1));
		verifyTrue(userCompareProductsPage.isImageProductDisplayedByProductName(productName2));
		verifyTrue(userCompareProductsPage.isNameProductDisplayedByProductName(productName1));
		verifyTrue(userCompareProductsPage.isNameProductDisplayedByProductName(productName1));
		verifyTrue(userCompareProductsPage.isPriceProductDisplayedByProductName(priceProduct1));
		verifyTrue(userCompareProductsPage.isPriceProductDisplayedByProductName(priceProduct2));
		
		log.info("Add_Product_To_Compare - Step 10: Click to 'Clear list' button");
		userCompareProductsPage.clickToClearListButton();
		
		log.info("Add_Product_To_Compare - Step 11: Verify 'You have no items to compare.' message displayed");
		verifyTrue(userCompareProductsPage.verifyNoDataMessageDisplayed());
	}

	@Test
	public void TC_05_Recently_Viewed_Product() {
		log.info("Recently_Viewed_Product - Step 01: Click to 'Recently Viewed Products' linktext on footer page");
		userRecentlyViewedProductsPage = userCompareProductsPage.clickToRecentlyViewedProducts(driver, "Recently viewed products");
		
		log.info("Recently_Viewed_Product - Step 02: Verify 3 lastest products displayed");
		verifyTrue(userRecentlyViewedProductsPage.verifyIsThreeLastestProductsDisplayed());
		verifyTrue(userRecentlyViewedProductsPage.verifyIsImageDisplayed("picture"));
		verifyTrue(userRecentlyViewedProductsPage.verifyIsProductNameDisplayed());
		verifyTrue(userRecentlyViewedProductsPage.verifyIsInfoProductDisplayedByClassName("rating"));
		verifyTrue(userRecentlyViewedProductsPage.verifyIsInfoProductDisplayedByClassName("prices"));
		verifyTrue(userRecentlyViewedProductsPage.verifyIsFeatureNameDisplayedByText("Add to cart"));
		verifyTrue(userRecentlyViewedProductsPage.verifyIsFeatureNameDisplayedByText("Add to compare list"));
		verifyTrue(userRecentlyViewedProductsPage.verifyIsFeatureNameDisplayedByText("Add to wishlist"));
	}


	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

}
