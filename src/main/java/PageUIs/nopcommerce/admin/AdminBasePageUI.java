package PageUIs.nopcommerce.admin;

public class AdminBasePageUI {
	public static final String DYNAMIC_MENU_LINKTEXT_BY_NAME = "xpath=//i[@class = 'right fas fa-angle-left ']//parent::p[contains(text(),'%s')]";
	public static final String DYNAMIC_CATEGORY_LINKTEXT_BY_NAME = "xpath=//i[@class = 'right fas fa-angle-left ']//parent::p[contains(text(),'%s')]//parent::a//following-sibling::ul//p[contains(text(),'%s')]";
	
	public static final String SEARCH_TEXTBOX ="xpath=//input[@id='small-searchterms']";
	public static final String SEARCH_BUTTON ="xpath=//button[text()='Search']";
	public static final String RECENTLY_VIEWED_PRODUCTS ="xpath=//a[text()='%s']";
}
