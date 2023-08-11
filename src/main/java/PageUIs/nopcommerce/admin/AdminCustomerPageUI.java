package PageUIs.nopcommerce.admin;

public class AdminCustomerPageUI {

	public static final String DYNAMIC_ADD_NEW_BUTTON = "xpath=//h1[contains(text(),'%s')]//following-sibling::div//a";
	public static final String DYNAMIC_TEXTBOX_BY_ID = "xpath=//input[@id='%s']";
	public static final String SEARCH_BUTTON = "xpath=//button[@id='search-customers']";
	public static final String CLOSE_ICON_ON_CUSTOMER_ROLE_DROPDOWN_LIST = "xpath=//ul[@id='SelectedCustomerRoleIds_taglist']//following-sibling::span[@title='clear']";
	public static final String CUSTOMER_ROLES_DROPDOWN_LIST_CHILD = "xpath=//ul[@id='SelectedCustomerRoleIds_listbox']//li";
	public static final String CUSTOMER_ROLES_DROPDOWN_LIST_PARENT = "xpath=//ul[@id='SelectedCustomerRoleIds_taglist']//parent::div";
	public static final String TOTAL_PAGE = "xpath=//li[@class='paginate_button page-item active']//a";
	public static final String DYNAMIC_PAGE_NUMBER = "xpath=//ul[@class='pagination']//a[text()='%s']";
	public static final String ALL_VALUE_IN_CUSTOMER_COLUMN = "xpath=//tbody//tr//td[%s]";
	public static final String ALL_VALUE_IN_ADDRESS_COLUMN = "xpath=//table[@id='customer-addresses-grid']//tr/td[%s]";
	public static final String ADDRESS_COLUMN = "xpath=//table[@id='customer-addresses-grid']//tr/td/div";
	public static final String TOTAL_RESULT_RECORD = "xpath=//table[@id='customers-grid']//tbody//tr";
	public static final String DATE_OF_BIRTH_DROPDOWN_LIST_BY_ID = "xpath=//select[@id='%s']";
	public static final String EDIT_BUTTON_ON_COLUMN = "xpath=//a[@class='btn btn-default' and contains(string(),'Edit')]";
	public static final String SUCCESS_MESSAGE_CREATE_NEW_CUSTOMER = "xpath=//div[@class='content-wrapper']//div[contains(string(),'%s')]";
	public static final String TEXT_EMAIL_ON_CUSTOMER_TABLE = "xpath=//table[@id='customers-grid']//tbody//td[text()='%s']";
	
	public static final String CARD_TITLE_ON_DETAIL_CUSTOMER_BY_TEXT = "xpath=//div[@class='card-title' and contains(string(),'%s')]";
	public static final String DYNAMIC_BUTTON_BY_TEXT = "xpath=//button[contains(text(),'%s')]";
	public static final String COLUMN_INDEX_BY_NAME = "xpath=//div[@class='dataTables_scrollHeadInner']//th[text()='%s']//preceding-sibling::th";

}
