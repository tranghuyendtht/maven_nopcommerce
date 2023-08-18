package PageUIs.nopcommerce.user;

public class UserShoppingCartPageUI {
	public static final String AGREE_TERM_CHECKBOX = "css=input#termsofservice";
	
	public static final String CHECKOUT_BUTTON = "css=button#checkout";
	
	public static final String EMPTY_SHOPPING_CART_MESSAGE = "xpath=//div[contains(text(),'Your Shopping Cart is empty!')]";
	
	public static final String GIFT_WRAPPING = "xpath=//select[@id='checkout_attribute_1']";
	public static final String GIFT_WRAPPING_STATUS = "xpath=// div[@class='selected-checkout-attributes' and contains(text(),'Gift wrapping: Yes [+$10.00]')]";
	
	public static final String PRODUCT_PRICE_SHOPPING_CART = "css=td.unit-price span";
	public static final String PRODUCT_IMAGE_ON_WISHLIST_PAGE = "xpath=//td[@class='product-picture']//a//img";
	public static final String PRODUCT_NAME_ON_WISHLIST_PAGE = "xpath=//td[@class='product']//a";
	public static final String PRODUCT_PRICE_ON_WISHLIST_PAGE = "xpath=//td[@class='unit-price']//span";
	public static final String PRODUCT_QUANTITY_ON_WISHLIST_PAGE = "xpath=//td[@class='quantity']//input";
	public static final String PRODUCT_QUANTITY_ON_WISHLIST_OF_PAGE = "xpath=//td[@class='quantity']//span";
	public static final String PRODUCT_TOTAL_PRICE_ON_WISHLIST_PAGE = "xpath=//td[@class='subtotal']//span";
	public static final String PRODUCT_QUANTITY_ON_SHOPPING_CART_PAGE = "css=input.qty-input";
	
	public static final String REMOVE_BUTTON = "css=button.remove-btn";
	
	public static final String SKU_PRODUCT_TEXT_ON_WISHLIST_PAGE = "xpath=//td[@class='sku']//span";
	public static final String SUB_TOTAL = "css=table.cart-total tr.order-subtotal td span.value-summary";
	public static final String SEARCH_BUTTON = "xpath=//button[contains(text(),'Search')]";
	
	public static final String TOTAL_SHOPPING_CART_TABLE = "css=td.subtotal span";
	public static final String TOTAL = "css=table.cart-total tr.order-total td span.value-summary strong";
	
	public static final String UPDATE_SHOPPING_CART_BUTTON = "css=button#updatecart";
	
	public static final String WISHLIST_LINKTEXT = "xpath=//a[text()='Wishlist']";
}
