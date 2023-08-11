package PageUIs.nopcommerce.user;

public class BasePageUI {
	// Sinh ra để giải quyết các vấn đề bị lặp lại chứ không có trong nghiệp vụ
	
	public static final String CUSTOMER_INFO_LINK = "xpath=//a[text()='Customer info']";
	public static final String ADDRESS_LINK = "xpath=//div[@class ='master-wrapper-content']//a[text()='Addresses']";
	public static final String ORDER_LINK = "xpath=//div[@class ='master-wrapper-content']//a[text()='Orders']";
	public static final String DOWNLOADABLE_PRODUCT_LINK = "xpath=//div[@class ='master-wrapper-content']//a[text()='Downloadable products']";
	public static final String BACK_IN_STOCK_SUBSCRIPTION_LINK = "xpath=//div[@class ='master-wrapper-content']//a[text()='Back in stock subscriptions']";
	public static final String REWARD_POINT_LINK = "xpath=//div[@class ='master-wrapper-content']//a[text()='Reward points']";
	public static final String CHANGE_PASSWORD_LINK = "xpath=//div[@class ='master-wrapper-content']//a[text()='Change password']";
	public static final String MY_PRODUCT_REVIEW_LINK = "xpath=//div[@class ='master-wrapper-content']//a[text()='My product reviews']";
	
	public static final String DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA= "xpath=//div[@class ='master-wrapper-content']//a[text()='%s']";
	public static final String MY_ACCOUNT_LINK ="class=ico-account";
	public static final String LOG_OUT_LINK_AT_USER_PAGE ="class=ico-logout";
	public static final String LOG_OUT_LINK_AT_ADMIN_PAGE = "xpath=//a[text()='Logout']";
	public static final String UPLOAD_FILE_TYPE = "xpath=//input[@type='file']";
	
	
	public static final String DYNAMIC_TEXTBOX_BY_ID = "xpath=//input[@id='%s']";
	public static final String DYNAMIC_BUTTON_BY_TEXT = "xpath=//button[text()='%s']";
	public static final String DYNAMIC_DROPDOWN_LIST_BY_TITLE = "xpath=//select[@name ='%s']";
	
	
	
	
}
