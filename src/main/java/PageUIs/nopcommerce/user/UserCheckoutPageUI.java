package PageUIs.nopcommerce.user;

public class UserCheckoutPageUI {
	public static final String TEXTBOX_BY_ID = "xpath=//input[@id='%s']";
	public static final String DROPDOWN_LIST_BY_ID = "xpath=//select[@id='%s']";
	public static final String CONTINUE_BUTTON_BY_ID_AND_TEXT = "xpath=//div[@id='%s']//button[text()='%s']";
	public static final String NEXT_DAY_AIR_CHECKBOX = "css=div.method-name input#shippingoption_1";
	public static final String CHECK_MONEY_ORDER_CHECKBOX = "css=div.payment-details input#paymentmethod_0";
	public static final String CONFIRM_ORDER_INFORMATION = "xpath=//div[@class ='section payment-info']//td";
	public static final String BILLING_ADDRESS_INFORMATION = "xpath=//div[@id='checkout-confirm-order-load']//div[@class='billing-info']//ul//li[@class='%s']";
	public static final String PAYMENT_OR_SHIPPING_METHOD_INFORMATION = "xpath=//div[@class='%s']//li//span[@class='value']";
	public static final String PAYMENT_OR_SHIPPING_METHOD_INFORMATION_ON_CHECKOUTPAGE = "xpath=//li[@class='%s']//span[@class='value']";
	public static final String SHIPPING_ADDRESS_INFORMATION = "xpath=//div[@class='shipping-info-wrap']//ul/li[@class='%s']";
	public static final String SUCCESSFULLY_ORDER_PROCESS_MESSAGE = "xpath=//div[@class='section order-completed']//strong[text()='Your order has been successfully processed!']";
	public static final String ORDER_NUMBER = "xpath=//div[@class='order-number']//strong";
	public static final String CONTINUE_BUTTON_COMPLETE = "xpath=//button[@class='button-1 order-completed-continue-button']";
	public static final String MY_ACCOUNT_LINKTEXT = "xpath=//a[@class='ico-account']";
	
	public static final String SKU_PRODUCT_TEXT_ON_WISHLIST_PAGE = "xpath=//td[@class='sku']//span";
	public static final String PRODUCT_IMAGE_ON_WISHLIST_PAGE = "xpath=//td[@class='product-picture']//a//img";
	public static final String PRODUCT_NAME_ON_WISHLIST_PAGE = "xpath=//td[@class='product']//a";
	public static final String PRODUCT_QUANTITY_ON_WISHLIST_PAGE = "xpath=//td[@class='quantity']//input";
	public static final String PRODUCT_PRICE_ON_WISHLIST_PAGE = "xpath=//td[@class='unit-price']//span";
	public static final String TOTAL_SHOPPING_CART_TABLE = "css=td.subtotal span";
	
	public static final String SUB_CART_TOTAL = "xpath=//table[@class='cart-total']//tr[@class='order-subtotal']//td[@class='cart-total-right']//span";
	public static final String SHIPPING_OR_TAX_ON_CART_TOTAL_BY_CLASSNAME = "xpath=//table[@class='cart-total']//tr[@class='%s']//td[@class='cart-total-right']//span";
}
