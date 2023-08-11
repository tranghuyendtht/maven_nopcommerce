package PageUIs.nopcommerce.admin;

public class AdminProductDetailPageUI {

	public static final String PRODUCT_DETAIL_PAGE_TITLE = "xpath=//h1[contains(text(),'Edit product details - Lenovo IdeaCentre 600 All-in-One PC')]";
	public static final String PRODUCT_NAME_TEXTBOX = "xpath=//input[@id='Name']";
	public static final String PRODUCT_SKU_TEXTBOX = "xpath=//input[@id='Sku']";
	public static final String FULL_DESCRIPTION_TEXTAREA = "xpath=//body[@id='tinymce']//p[contains(text(),'The A600 features a 21.5in screen')]";
	public static final String CATEGORIES = "xpath=//ul[@id='SelectedCategoryIds_taglist']//span[@title='delete']//preceding-sibling::span";
	public static final String CHECKBOX_BY_ID = "xpath=//input[@id='%s']";
	public static final String PRICE_DROPLIST = "xpath=//input[@id='Price']//preceding-sibling::input";
	public static final String STOCK_QUANTITY_DROPLIST = "xpath=//input[@id='StockQuantity']//preceding-sibling::input";
	public static final String PRODUCT_IMAGE = "xpath=//td[@data-columnname='PictureUrl']//img";
}
