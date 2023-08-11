package PageUIs.jQuery.dataTable;

public class HomePageUI {
	public static final String PAGINATION_PAGE_BY_PAGE_NUMBER = "xpath=//ul[@class ='qgrd-pagination-ul']// a[text()='%s']";
	public static final String TEXTBOX_SEARCH_BY_TITLE_HEADER = "xpath=//div[@class='qgrd-header-text' and text()='%s']//parent::div//following-sibling::input";
	public static final String PAGINATION_PAGE_ACTIVED_BY_PAGE_NUMBER = "xpath=//a[@class = 'qgrd-pagination-page-link active' and text()='%s']";
	public static final String TOTAL_PAGINATION = "xpath=//li[@class='qgrd-pagination-page']";
	public static final String PAGINATION_PAGE_INDEX = "xpath=//li[@class='qgrd-pagination-page'][%s]/a";
	public static final String ALL_ROW_EACH_PAGE = "xpath=//tbody/tr";
	public static final String COLUMN_BY_TITLENAME = "xpath=//tbody/tr/td[@data-key='%s']";
	
	public static final String COLUMN_INDEX_BY_TITLENAME = "xpath=//table[@id='tblAppendGrid']//th[text()='%s']/preceding-sibling::th";
	public static final String TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX = "xpath=//tbody/tr[%s]//td[%s]//input";
	public static final String SELECT_DROPDOWN_BY_TITLENAME = "xpath=//tbody/tr[%s]//td[%s]//div//select";
	public static final String CHECKBOX_BY_TITLENAME = "xpath=//tbody/tr[%s]//td[%s]//label//input[@type='checkbox']";
	public static final String DATE_PICKER_BY_TITLE = "xpath=//tbody/tr[%s]//td[%s]//input[@type='date']";
	public static final String ICON_ON_TABLE_BY_ROW_NUMBER_AND_BY_NAME = "xpath=//tbody/tr[%s]//td//button[@title='%s']";
}
