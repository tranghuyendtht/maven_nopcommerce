package pageObjects.nopcommerce.Admin;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageUIs.nopcommerce.admin.AdminAddNewCustomerPageUI;
import PageUIs.nopcommerce.admin.AdminCustomerPageUI;
import PageUIs.nopcommerce.admin.AdminProductPageUI;
import commons.BasePage;

public class AdminSearchCustomerPageObject extends BasePage {
	private WebDriver driver;

	public AdminSearchCustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public AdminAddNewCustomerPageObject clickToAddNewButton(String subMenuName) {
		waitForElementClickable(driver, AdminCustomerPageUI.DYNAMIC_ADD_NEW_BUTTON, subMenuName);
		clickToElementByJS(driver, AdminCustomerPageUI.DYNAMIC_ADD_NEW_BUTTON, subMenuName);
		return PageGeneratorManager.getAdminAddNewCustomerPage(driver);
	}

	public void setToTextboxSearchByID(String idTextbox, String textValue) {
		waitForElementVisible(driver, AdminCustomerPageUI.DYNAMIC_TEXTBOX_BY_ID, idTextbox);
		sendkeyToElement(driver, AdminCustomerPageUI.DYNAMIC_TEXTBOX_BY_ID, textValue, idTextbox);
		sleepInSecond(1);
	}

	public void clickToSearchButton() {
		waitForElementClickable(driver, AdminCustomerPageUI.SEARCH_BUTTON);
		clickToElementByJS(driver, AdminCustomerPageUI.SEARCH_BUTTON);
		sleepInSecond(2);

	}

	public boolean isExpectedResultContainedInActualResult(String columnName, String keyword) {
		boolean pass = true;
		int totalPage = getElementSize(driver, AdminCustomerPageUI.TOTAL_PAGE);
		List<String> allRowValueProductColumn = new ArrayList<String>();
		// Duyệt qua từng page
		for (int i = 1; i <= totalPage; i++) {
			waitForElementClickable(driver, AdminCustomerPageUI.DYNAMIC_PAGE_NUMBER, String.valueOf(i));
			clickToElement(driver, AdminCustomerPageUI.DYNAMIC_PAGE_NUMBER, String.valueOf(i));
			sleepInSecond(1);

			// Duyệt qua từng row để lấy các giá trị trong cột Product để đưa vào arraylist
			// và so sánh với từ khóa tìm kiếm
			List<WebElement> allValueInColumn = getElements(driver, AdminCustomerPageUI.ALL_VALUE_IN_CUSTOMER_COLUMN,
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

	private int getColumnIndex(String columnName) {
		int columnIndex;
		return columnIndex = getElementSize(driver, AdminCustomerPageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
	}

	public void chooseCustomerRole(String customerRoleValue) {
		clearValueOnCustomerRoleField();

		waitForElementVisible(driver, AdminCustomerPageUI.CUSTOMER_ROLES_DROPDOWN_LIST_PARENT);
		selectItemInCustomDropdown(driver, AdminCustomerPageUI.CUSTOMER_ROLES_DROPDOWN_LIST_PARENT,
				AdminCustomerPageUI.CUSTOMER_ROLES_DROPDOWN_LIST_CHILD, customerRoleValue);
		sleepInSecond(1);

	}

	public int getNumberOfResult() {
		waitForElementVisible(driver, AdminCustomerPageUI.TOTAL_RESULT_RECORD);
		return getElementSize(driver, AdminCustomerPageUI.TOTAL_RESULT_RECORD);
	}

	public void selectValueDateOfBirthByID(String idDropdownList, String value) {
		waitForElementVisible(driver, AdminCustomerPageUI.DATE_OF_BIRTH_DROPDOWN_LIST_BY_ID, idDropdownList);
		selectItemInDefaultDropDown(driver, AdminCustomerPageUI.DATE_OF_BIRTH_DROPDOWN_LIST_BY_ID, value,
				idDropdownList);
	}

	public boolean isVerifySuccessMessageDisplayed(String textMessage) {
		waitForElementVisible(driver, AdminCustomerPageUI.SUCCESS_MESSAGE_CREATE_NEW_CUSTOMER, textMessage);
		return isElementDisplayed(driver, AdminCustomerPageUI.SUCCESS_MESSAGE_CREATE_NEW_CUSTOMER, textMessage);
	}

	public AdminEditCustomerPageObject clickToEditButton() {
		waitForElementClickable(driver, AdminCustomerPageUI.EDIT_BUTTON_ON_COLUMN);
		clickToElementByJS(driver, AdminCustomerPageUI.EDIT_BUTTON_ON_COLUMN);
		sleepInSecond(2);
		return PageGeneratorManager.getAdminEditCustomerPage(driver);
	}

	public void clickToCardTitleByText(String titleText) {
		scrollToElement(driver, AdminCustomerPageUI.CARD_TITLE_ON_DETAIL_CUSTOMER_BY_TEXT, titleText);
		sleepInSecond(1);
		waitForElementClickable(driver, AdminCustomerPageUI.CARD_TITLE_ON_DETAIL_CUSTOMER_BY_TEXT, titleText);
		clickToElementByJS(driver, AdminCustomerPageUI.CARD_TITLE_ON_DETAIL_CUSTOMER_BY_TEXT, titleText);
		sleepInSecond(1);

	}

	public AdminManageCustomerAddressPageObject clickToDynamicButtonByText(String textButton) {
		scrollToElement(driver, AdminCustomerPageUI.DYNAMIC_BUTTON_BY_TEXT, textButton);
		sleepInSecond(1);
		waitForElementClickable(driver, AdminCustomerPageUI.DYNAMIC_BUTTON_BY_TEXT, textButton);
		clickToElementByJS(driver, AdminCustomerPageUI.DYNAMIC_BUTTON_BY_TEXT, textButton);
		return PageGeneratorManager.getAdminManageCustomerAddressPage(driver);

	}

	public void clearValueOnCustomerRoleField() {
		// Xóa hết giá trị mặc định đang có
	//	waitForElementClickable(driver, AdminCustomerPageUI.CLOSE_ICON_ON_CUSTOMER_ROLE_DROPDOWN_LIST);
		clickToElementByJS(driver, AdminCustomerPageUI.CLOSE_ICON_ON_CUSTOMER_ROLE_DROPDOWN_LIST);
		sleepInSecond(1);

	}

	public boolean isCustomerCreatedSuccessfully(String emailAddress) {
		waitForElementVisible(driver, AdminCustomerPageUI.TEXT_EMAIL_ON_CUSTOMER_TABLE, emailAddress);
		return isElementDisplayed(driver, AdminCustomerPageUI.TEXT_EMAIL_ON_CUSTOMER_TABLE, emailAddress);
	}

}
