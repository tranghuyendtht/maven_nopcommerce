package PageUIs.nopcommerce.user;

public class UserSearchKeywordPageUI {
	public static final String SEARCH_BUTTON = "xpath=//button[contains(@class,'search-button')]";
	public static final String SEARCH_TERM_LENGTH_MESSAGE = "xpath=//div[@class='warning' and text()='Search term minimum length is 3 characters']";
	public static final String MESSAGE_NO_PRODUCT_FOUND = "xpath=// div[@class='no-result' and text()='No products were found that matched your criteria.']";
	public static final String LIST_PRODUCT_TITLE = "xpath=//div[@class = 'product-item']//h2[@class ='product-title']//a";
	public static final String ADVANCED_SEARCH_CHECKBOX = "xpath=//input[@id='advs']";
	public static final String CATEGORY_DROPDOWN_LIST = "xpath=//select[@id='cid']";
	public static final String SUB_CATEGORY_DROPDOWN_LIST = "xpath=//select[@id='mid']";
	public static final String SUB_CATEGORY_CHECKBOX = "xpath=//input[@id='isc']";
	public static final String PRODUCT_TITLE = "xpath=//h2[@class='product-title']//a[text()='%s']";
	public static final String PRICE_PRODUCT = "xpath=//span[@class='price actual-price']";
	public static final String ADD_TO_COMPARE_LIST_ICON_BY_PRODUCT_NAME = "xpath=//a[text()='%s']//parent::h2//following-sibling::div[@class='add-info']//button[@class='button-2 add-to-compare-list-button']";
	public static final String ADDED_SUCCESS_MESSAGE = "xpath=//div[@class='bar-notification success']//p";
	public static final String COMPARISON_PRODUCT_LINKTEXT = "xpath=//a[text()='product comparison']";
	public static final String ADD_TO_CART_BUTTON = "xpath=//div[@class='add-to-cart-panel']//button[text()='Add to cart']";
	public static final String SHOPPING_CART_LINKTEXT = "xpath=//span[text()='Shopping cart']";
}
