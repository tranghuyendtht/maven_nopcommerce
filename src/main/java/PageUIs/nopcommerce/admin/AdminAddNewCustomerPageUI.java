package PageUIs.nopcommerce.admin;

public class AdminAddNewCustomerPageUI {
	public static final String DYNAMIC_TEXTBOX_BY_ID = "xpath=//input[@id='%s']";
	public static final String DYNAMIC_TEXTAREA_BY_ID = "xpath=//textarea[@id='%s']";
	public static final String RADIO_GENDER = "xpath=//input[@id='%s' and @checked]";
	public static final String DYNAMIC_CHECKBOX_OR_RADIO_BUTTON_BY_ID = "xpath=//input[@id='%s']";
	public static final String DATE_OF_BIRTH_DATE_VIEW = "xpath=//input[@id='DateOfBirth']";
	public static final String CLOSE_ICON_ON_CUSTOMER_ROLE_DROPDOWN_LIST = "xpath=//ul[@id='SelectedCustomerRoleIds_taglist']//following-sibling::span[@title='clear']";
	public static final String CUSTOMER_ROLES_DROPDOWN_LIST_PARENT = "xpath=//ul[@id='SelectedCustomerRoleIds_taglist']//parent::div";
	public static final String CUSTOMER_ROLES_DROPDOWN_LIST_CHILD = "xpath=//ul[@id='SelectedCustomerRoleIds_listbox']//li";
	public static final String SAVE_AND_CONTINUE_EDIT_BUTTON = "xpath=//button[@name='save-continue']";
	public static final String SUCCESS_MESSAGE_CREATE_NEW_CUSTOMER = "xpath=//div[@class='content-wrapper']//div[contains(string(),'%s')]";
	public static final String BIRTH_DAY_DROPDOWN_LIST = "xpath=//input[@id='DateOfBirth']";
	public static final String TITLE_EDIT_CUSTOMER_DETAIL_PAGE = "xpath=//h1[contains(text(),'Edit customer details')]";
	public static final String CUSTOMER_ROLES_DROPDOWN_LIST = "xpath=//select[@id='SelectedCustomerRoleIds']";
	public static final String CUSTOMER_ROLES_SELECTED = "xpath=//ul[@id='SelectedCustomerRoleIds_taglist']//span";
	public static final String BACK_TO_CUSTOMER_LIST_LINKTEXT = "xpath=//a[text()='back to customer list']";
	
	public static final String SAVE_BUTTON_ON_EDIT_CUSTOMER_PAGE = "xpath=//button[@class='btn btn-primary' and contains(string(),'Save')]";
	

}
