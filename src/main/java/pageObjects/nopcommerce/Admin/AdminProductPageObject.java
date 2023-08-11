package pageObjects.nopcommerce.Admin;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import PageUIs.jQuery.dataTable.HomePageUI;
import PageUIs.nopcommerce.admin.AdminProductPageUI;
import commons.BasePage;

public class AdminProductPageObject extends BasePage {
	private WebDriver driver;

	public AdminProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isExpectedResultContainedInActualResult(String columnName, String keyword) {
		boolean pass = true;
		sleepInSecond(5);
		int totalPage = getElementSize(driver, AdminProductPageUI.TOTAL_PAGE);
		List<String> allRowValueProductColumn = new ArrayList<String>();
		// Duyệt qua từng page
		for (int i = 1; i <= totalPage; i++) {
			waitForElementClickable(driver, AdminProductPageUI.DYNAMIC_PAGE_NUMBER, String.valueOf(i));
			clickToElement(driver, AdminProductPageUI.DYNAMIC_PAGE_NUMBER, String.valueOf(i));
			sleepInSecond(1);

			// Duyệt qua từng row để lấy các giá trị trong cột Product để đưa vào arraylist
			// và so sánh với từ khóa tìm kiếm
			List<WebElement> allValueInColumn = getElements(driver, AdminProductPageUI.ALL_VALUE_IN_A_COLUMN,
					String.valueOf(getColumnIndex(columnName)));
			for (WebElement eachRow : allValueInColumn) {
				allRowValueProductColumn.add(eachRow.getText());
			}
		}

		for (String value : allRowValueProductColumn) {
			if (value.contains(keyword)) {
				pass = true;
			} else {
				pass = false;
			}

		}
		return pass;

	}

	public int getNumberOfResult() {
		waitForElementVisible(driver, AdminProductPageUI.TOTAL_RESULT_RECORD);
		return getElementSize(driver, AdminProductPageUI.TOTAL_RESULT_RECORD);
	}


	private int getColumnIndex(String columnName) {
		int columnIndex;
		return columnIndex = getElementSize(driver, AdminProductPageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
	}

	public void setKeywordToProductTextbox(String keyword) {
		waitForElementVisible(driver, AdminProductPageUI.PRODUCT_NAME_TEXTBOX);
		sendkeyToElement(driver, AdminProductPageUI.PRODUCT_NAME_TEXTBOX, keyword);
		sleepInSecond(3);
	}

	public void clickToButtonSearch() {
		waitForElementClickable(driver, AdminProductPageUI.SEARCH_BUTTON);
		clickToElement(driver, AdminProductPageUI.SEARCH_BUTTON);
		sleepInSecond(3);
	}

	public void selectValueOnDropListByID(String dropdownListID, String textValue) {
		waitForElementVisible(driver, AdminProductPageUI.DYNAMIC_DROP_LIST_BY_ID, dropdownListID);
		selectItemInDefaultDropDown(driver, AdminProductPageUI.DYNAMIC_DROP_LIST_BY_ID, textValue, dropdownListID);
	}

	public String getNoMatchedResultMessage() {
		waitForElementVisible(driver, AdminProductPageUI.NO_MATCHED_RESULT_MESSAGE);

		return getElementText(driver, AdminProductPageUI.NO_MATCHED_RESULT_MESSAGE);
	}

	public void checkToSearchSubCategories() {

		waitForElementClickable(driver, AdminProductPageUI.SUB_CATEGORIES_CHECKBOX);
		checkToCheckboxORRadio(driver, AdminProductPageUI.SUB_CATEGORIES_CHECKBOX);
	}

	public void setProductSKU(String productSKUText) {
		waitForElementVisible(driver, AdminProductPageUI.PRODUCT_SKU_TEXTBOX);
		sendkeyToElement(driver, AdminProductPageUI.PRODUCT_SKU_TEXTBOX, productSKUText);
	}

	public AdminProductDetailPageObject goDirectlyToProductSKU(String productSKUText) {
		waitForElementClickable(driver, AdminProductPageUI.GO_TO_PRODUCT_SKU_BUTTON);
		clickToElementByJS(driver, AdminProductPageUI.GO_TO_PRODUCT_SKU_BUTTON);

		return PageGeneratorManager.getAdminProductDetailPage(driver);
	}

	
}
