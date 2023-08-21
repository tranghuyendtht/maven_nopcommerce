package PageUIs.nopcommerce.user;

public class UserOrderPageUI {
	public static final String BILLING_ADDRESS_INFO_BY_CLASS = "xpath=//div[@class='billing-info']//li[@class='%s']";
	
	public static final String DETAIL_BUTTON = "xpath=//button[@class='button-2 order-details-button']";
	
	public static final String RE_ORDER_BUTTON = "xpath=//button[text()='Re-order']";
	
	public static final String SHIPPING_ADD_INFO_BY_CLASS = "xpath=//div[@class='shipping-info-wrap']//li[@class='%s']";
	public static final String SHIPPING_METHOD_INFO = "xpath=//div[@class='shipping-method-info']//li[@class='%s']//span[@class='value']";
	public static final String SKU_PRODUCT_TEXT_ON_WISHLIST_PAGE = "xpath=//td[@class='sku']//span";
	public static final String SUB_CART_TOTAL = "xpath=//table[@class='cart-total']//tr[@class='order-subtotal']//td[@class='cart-total-right']//span";
	public static final String SHIPPING_OR_TAX_ON_CART_TOTAL_BY_CLASSNAME = "xpath=//table[@class='cart-total']//tr[@class='%s']//td[@class='cart-total-right']//span";
	public static final String SEARCH_BUTTON = "xpath=//button[contains(text(),'Search')]";
	
	public static final String TOTAL_SHOPPING_CART_TABLE = "css=td.subtotal span";
	public static final String TOTAL_SHOPPING_CART_ORDER_INFORMATION = "css=td.total span";
	
	public static final String ORDER_DATE = "xpath=//li[@class='order-date']";
	public static final String ORDER_NUMBER = "xpath=//div[@class='section order-item']//strong";
	public static final String ORDER_NUMBER_ON_ORDER_INFORMATION = "xpath=//div[@class='order-number']//strong";
	public static final String ORDER_STATUS = "xpath=//li[@class='order-status']";
	public static final String ORDER_TOTAL = "xpath=//li[@class='order-total']//strong";
	public static final String ORDER_INFOR_ON_ORDER_INFORMATION_PAGE_BY_TITLE = "xpath=//label[contains(text(),'%s')]//parent::td//following-sibling::td/span";
	
	public static final String PAYMENT_INFO_BY_CLASS = "xpath=//div[@class='payment-method-info']//li[@class='%s']//span[@class='value']";
	public static final String PRODUCT_IMAGE_ON_WISHLIST_PAGE = "xpath=//td[@class='product-picture']//a//img";
	public static final String PRODUCT_IMAGE_ON_ORDER_INFORMATION= "xpath=//td[@class='picture']//a//img";
	public static final String PRODUCT_NAME_ON_WISHLIST_PAGE = "xpath=//td[@class='product']//a";
	public static final String PRODUCT_PRICE_ON_WISHLIST_PAGE = "xpath=//td[@class='unit-price']//span";
	public static final String PRODUCT_QUANTITY_ON_WISHLIST_PAGE = "xpath=//td[@class='quantity']//input";
	
	public static final String WRAPPING_GIFT = "xpath=//div[@class='selected-checkout-attributes']";
}
