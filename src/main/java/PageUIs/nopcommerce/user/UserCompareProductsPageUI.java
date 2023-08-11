package PageUIs.nopcommerce.user;

public class UserCompareProductsPageUI {
	public static final String REMOVE_ICON = "xpath=//table[@class='compare-products-table']//tbody//tr[@class='remove-product']//button[text()='Remove']";
	public static final String PRODUCT_TOTAL = "xpath=//table[@class='compare-products-table']//tbody//tr[@class='product-picture']";
	public static final String PRODUCT_IMAGE = "xpath=//table[@class='compare-products-table']//img[contains(@alt,'%s')]";
	public static final String PRODUCT_NAME = "xpath=//table[@class='compare-products-table']//tbody//tr[@class='product-name']//a[text()='%s']";
	public static final String PRODUCT_PRICE = "xpath=//table[@class='compare-products-table']//tbody//tr[@class='product-price']//td[text()='%s']";
	public static final String CLEAR_LIST_BUTTON  = "xpath=//a[@class='clear-list']";
	public static final String NO_PRODUCT_COMPARISON_MESSAGE  = "xpath=//div[@class='no-data' and text()='You have no items to compare.']";
}
