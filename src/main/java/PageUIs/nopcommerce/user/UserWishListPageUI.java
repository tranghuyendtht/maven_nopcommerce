package PageUIs.nopcommerce.user;

public class UserWishListPageUI {
	public static final String SKU_PRODUCT_TEXT_ON_WISHLIST_PAGE = "xpath=//td[@class='sku']//span";
	public static final String PRODUCT_IMAGE_ON_WISHLIST_PAGE = "xpath=//td[@class='product-picture']//a//img";
	public static final String PRODUCT_NAME_ON_WISHLIST_PAGE = "xpath=//td[@class='product']//a";
	public static final String PRODUCT_PRICE_ON_WISHLIST_PAGE = "xpath=//td[@class='unit-price']//span";
	public static final String PRODUCT_QUANTITY_ON_WISHLIST_PAGE = "xpath=//td[@class='quantity']//input";
	public static final String PRODUCT_QUANTITY_ON_WISHLIST_OF_PAGE = "xpath=//td[@class='quantity']//span";
	public static final String PRODUCT_TOTAL_PRICE_ON_WISHLIST_PAGE = "xpath=//td[@class='subtotal']//span";
	public static final String TOTAL_PRODUCT_ON_WISHLIST_PAGE = "xpath=//table[@class='cart']//tbody//tr";
	public static final String URL_SHARING = "xpath=//a[@class='share-link']";
	public static final String NO_DATA = "xpath=//div[@class='no-data' and contains(text(),'The wishlist is empty!')]";
	public static final String ADD_TO_CARD_CHECKBOX = "xpath=//input[@name='addtocart']";
	public static final String ADD_TO_CARD_BUTTON = "xpath=//button[@name='addtocartbutton']";
	public static final String REMOVE_ICON = "xpath=//button[@class='remove-btn']";
}
