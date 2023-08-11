package PageUIs.nopcommerce.admin;

public class AdminEditCustomerPageUI {

	public static final String CARD_TITLE_ON_DETAIL_CUSTOMER_BY_TEXT = "xpath=//div[@class='card-title' and contains(string(),'%s')]";
	public static final String ADDRESS_COLLAPSED_CARD = "xpath=//div[contains(@class,'collapsed-card') and @id='customer-address']";
	public static final String DYNAMIC_BUTTON_BY_TEXT = "xpath=//button[contains(text(),'%s')]";
	public static final String TOTAL_PAGE = "xpath=//li[@class='paginate_button page-item active']//a";
	public static final String DYNAMIC_PAGE_NUMBER = "xpath=//ul[@class='pagination']//a[text()='%s']";
	public static final String ALL_VALUE_IN_ADDRESS_COLUMN = "xpath=//table[@id='customer-addresses-grid']//tr/td[%s]";
	public static final String COLUMN_INDEX_BY_NAME = "xpath=//div[@class='dataTables_scrollHeadInner']//th[text()='%s']//preceding-sibling::th";
	public static final String ADDRESS_COLUMN = "xpath=//table[@id='customer-addresses-grid']//tr/td/div";
	public static final String BACK_TO_CUSTOMER_LIST_LINKTEXT = "xpath=//a[text()='back to customer list']";
	public static final String DYNAMIC_TEXTBOX_BY_ID = "xpath=//input[@id='%s']";
	public static final String DATE_OF_BIRTH_DATE_VIEW = "xpath=//input[@id='DateOfBirth']";
	public static final String DYNAMIC_TEXTAREA_BY_ID = "xpath=//textarea[@id='%s']";
	public static final String DYNAMIC_BUTTON_ON_EDIT_CUSTOMER_PAGE_BY_TEXT = "xpath=//button[@class='btn btn-primary' and contains(string(),'%s')]";
	public static final String DYNAMIC_BUTTON_ON_COLUMN_BY_TEXT = "xpath=//a[@class='btn btn-default' and contains(text(),'%s')]";
	public static final String NO_DATA_AVAILABLE_ON_TABLE_MESSAGE = "xpath=	//table[@id='customer-addresses-grid']//td[@class='dataTables_empty' and text()='No data available in table']";

}
