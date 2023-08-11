package PageUIs.nopcommerce.user;

public class UserComputerProductPageUI {
	public static final String SORT_ORDER_DROPDOWN_LIST = "xpath=//select[@id='products-orderby']";
	public static final String PRODUCT_NAME_LIST = "xpath=//h2[@class='product-title']//a";
	public static final String PRODUCT_PRICE_LIST = "xpath=//div[@class='prices']//span";
	public static final String PRODUCT_PAGE_SIZE = "xpath=//select[@id='products-pagesize']";
	public static final String NUMBER_OF_PAGE = "xpath=//div[@class='pager']//li[%s]";
	public static final String NEXT_PAGE_ICON = "xpath=//li[@class='next-page']";
	public static final String PRIVIOUS_PAGE_ICON = "xpath=//li[@class='previous-page']";
	public static final String TOTAL_PAGE = "xpath=//div[@class='pager']//li";
	public static final String NUMBER_OF_PRODUCT_PER_PAGE = "xpath=//div[@class='item-grid']/div[@class='item-box']";
	public static final String PRODUCT_NAME_BY_NAME = "xpath=//div[@class='product-item']//a[text()='%s']";
	
}
