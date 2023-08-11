package PageUIs.nopcommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class AdminProductPageUI{
	
	public static final String TOTAL_PAGE = "xpath=//li[@class='paginate_button page-item active']//a";
	public static final String INFO_PAGE_NUMBER = "xpath=//div[@id='products-grid_info']";
	public static final String COLUMN_INDEX_BY_NAME = "xpath=//div[@class='dataTables_scrollHeadInner']//th[text()='%s']//preceding-sibling::th";
	public static final String DYNAMIC_PAGE_NUMBER = "xpath=//ul[@class='pagination']//a[text()='%s']";
	public static final String ALL_VALUE_IN_A_COLUMN = "xpath=//tbody//tr//td[%s]";
	public static final String PRODUCT_NAME_TEXTBOX = "xpath=//input[@id ='SearchProductName']"; 
	public static final String FIRSTNAME_TEXTBOX = "xpath=//input[@id ='SearchFirstName']"; 
	public static final String DYNAMIC_DROP_LIST_BY_ID = "xpath=//select[@id='%s']";
	public static final String SEARCH_BUTTON = "xpath=//button[@id='search-products']";
	public static final String NO_MATCHED_RESULT_MESSAGE = "xpath=//td[@class ='dataTables_empty']";
	public static final String SUB_CATEGORIES_CHECKBOX = "xpath=//input[@id = 'SearchIncludeSubCategories']";
	public static final String TOTAL_RESULT_RECORD = "xpath=//table[@id='products-grid']//tbody//tr";
	public static final String PRODUCT_SKU_TEXTBOX = "xpath=//input[@id='GoDirectlyToSku']";
	public static final String GO_TO_PRODUCT_SKU_BUTTON = "xpath=//button[@id='go-to-product-by-sku']";
	
	public static final String DYNAMIC_ADD_NEW_BUTTON = "xpath=//h1[contains(text(),'%s')]//following-sibling::div//a";
	
	
}
