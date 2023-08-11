package PageUIs.nopcommerce.user;

public class UserRecentlyViewedProductsPageUI {
	public static final String PRODUCT_TOTAL = "xpath=//div[@class='product-grid']//div[@class='item-box']";
	public static final String PRODUCT_IMAGE = "xpath=//div[@class='product-grid']//div[@class='item-box'][%s]//div[@class='%s']/a/img";
	public static final String PRODUCT_INFO_BY_CLASS_NAME = "xpath=//div[@class='product-grid']//div[@class='item-box'][%s]//div[@class='%s']";
	public static final String PRODUCT_NAME = "xpath=//div[@class='product-grid']//div[@class='item-box'][%s]//h2[@class='product-title']";
	public static final String FEATURE_NAME_BY_TEXT = "xpath=//div[@class='product-grid']//div[@class='item-box'][%s]//div[@class='buttons']//button[text()='%s']";
}
