package pageObjects.nopcommerce.Admin;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageUIs.nopcommerce.admin.AdminAddNewCustomerPageUI;
import PageUIs.nopcommerce.admin.AdminCustomerPageUI;
import PageUIs.nopcommerce.admin.AdminEditCustomerPageUI;
import PageUIs.nopcommerce.admin.AdminProductPageUI;
import commons.BasePage;

public class AdminEditCustomerPageObject extends BasePage {
	WebDriver driver;

	public AdminEditCustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToCardTitleByText(String titleText) {
		scrollToElement(driver, AdminEditCustomerPageUI.CARD_TITLE_ON_DETAIL_CUSTOMER_BY_TEXT, titleText);
		sleepInSecond(1);
		System.out.println("1");
		
		waitForElementClickable(driver, AdminEditCustomerPageUI.CARD_TITLE_ON_DETAIL_CUSTOMER_BY_TEXT, titleText);
		if (isElementDisplayed(driver, AdminEditCustomerPageUI.ADDRESS_COLLAPSED_CARD)) {
			clickToElementByJS(driver, AdminEditCustomerPageUI.CARD_TITLE_ON_DETAIL_CUSTOMER_BY_TEXT, titleText);
			System.out.println("2");
		} else if (isElementUndisplayed(driver, AdminEditCustomerPageUI.ADDRESS_COLLAPSED_CARD)) {
			System.out.println("3");
			return;
		}

	}

	public AdminManageCustomerAddressPageObject clickToDynamicButtonByText(String textButton) {
		scrollToElement(driver, AdminEditCustomerPageUI.DYNAMIC_BUTTON_BY_TEXT, textButton);
		waitForElementClickable(driver, AdminEditCustomerPageUI.DYNAMIC_BUTTON_BY_TEXT, textButton);
		clickToElementByJS(driver, AdminEditCustomerPageUI.DYNAMIC_BUTTON_BY_TEXT, textButton);
		return PageGeneratorManager.getAdminManageCustomerAddressPage(driver);

	}

	public boolean isExpectedAddressContainedInActualResult(String columnName, String keyword) {
		boolean pass = true;
		int totalPage = getElementSize(driver, AdminEditCustomerPageUI.TOTAL_PAGE);
		List<String> allRowValueProductColumn = new ArrayList<String>();
		// Duyệt qua từng page
		for (int i = 1; i <= totalPage; i++) {
			waitForElementClickable(driver, AdminEditCustomerPageUI.DYNAMIC_PAGE_NUMBER, String.valueOf(i));
			clickToElement(driver, AdminEditCustomerPageUI.DYNAMIC_PAGE_NUMBER, String.valueOf(i));
			sleepInSecond(1);

			// Duyệt qua từng row để lấy các giá trị trong cột Product để đưa vào arraylist
			// và so sánh với từ khóa tìm kiếm
			List<WebElement> allValueInColumn = getElements(driver, AdminEditCustomerPageUI.ALL_VALUE_IN_ADDRESS_COLUMN,
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
		return columnIndex = getElementSize(driver, AdminEditCustomerPageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
	}

	public boolean isExpectedAddressInAddressColumn(String keyword) {
		boolean pass = true;
		int totalPage = getElementSize(driver, AdminEditCustomerPageUI.TOTAL_PAGE);
		List<String> allRowValueProductColumn = new ArrayList<String>();
		// Duyệt qua từng page
		for (int i = 1; i <= totalPage; i++) {
			waitForElementClickable(driver, AdminEditCustomerPageUI.DYNAMIC_PAGE_NUMBER, String.valueOf(i));
			clickToElement(driver, AdminEditCustomerPageUI.DYNAMIC_PAGE_NUMBER, String.valueOf(i));
			sleepInSecond(1);

			// Duyệt qua từng row để lấy các giá trị trong cột Product để đưa vào arraylist
			// và so sánh với từ khóa tìm kiếm
			List<WebElement> allValueInColumn = getElements(driver, AdminEditCustomerPageUI.ADDRESS_COLUMN);
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

	public AdminSearchCustomerPageObject clickBackToCustomerListButton() {
		scrollToElement(driver, AdminEditCustomerPageUI.BACK_TO_CUSTOMER_LIST_LINKTEXT);
		waitForElementClickable(driver, AdminEditCustomerPageUI.BACK_TO_CUSTOMER_LIST_LINKTEXT);
		clickToElementByJS(driver, AdminEditCustomerPageUI.BACK_TO_CUSTOMER_LIST_LINKTEXT);
		sleepInSecond(1);
		return PageGeneratorManager.getAdminSearchCustomerPage(driver);
	}

	public void setInfoToTextboxByID(String idTextbox, String textValue) {
		waitForElementVisible(driver, AdminEditCustomerPageUI.DYNAMIC_TEXTBOX_BY_ID, idTextbox);
		sendkeyToElement(driver, AdminEditCustomerPageUI.DYNAMIC_TEXTBOX_BY_ID, textValue, idTextbox);
	}

	public void chooseDateOfBirth(String dateValue) {
		waitForElementVisible(driver, AdminEditCustomerPageUI.DATE_OF_BIRTH_DATE_VIEW);
		sendkeyToElement(driver, AdminEditCustomerPageUI.DATE_OF_BIRTH_DATE_VIEW, dateValue);
		sleepInSecond(1);
	}

	public void setInfoToTextAreaByID(String idTextarea, String textValue) {
		waitForElementVisible(driver, AdminEditCustomerPageUI.DYNAMIC_TEXTAREA_BY_ID, idTextarea);
		sendkeyToElement(driver, AdminEditCustomerPageUI.DYNAMIC_TEXTAREA_BY_ID, textValue, idTextarea);
	}

	public AdminSearchCustomerPageObject clickToSaveButton(String textButton) {
		waitForElementClickable(driver, AdminEditCustomerPageUI.DYNAMIC_BUTTON_ON_EDIT_CUSTOMER_PAGE_BY_TEXT, textButton);
		clickToElementByJS(driver, AdminEditCustomerPageUI.DYNAMIC_BUTTON_ON_EDIT_CUSTOMER_PAGE_BY_TEXT, textButton);
		sleepInSecond(1);
		return PageGeneratorManager.getAdminSearchCustomerPage(driver);
	}

	public void clickToButtonOnAddressTableByText(String cartTitleName, String textButton) {
		scrollToElement(driver, AdminEditCustomerPageUI.CARD_TITLE_ON_DETAIL_CUSTOMER_BY_TEXT, cartTitleName);
		sleepInSecond(1);
		waitForElementClickable(driver, AdminEditCustomerPageUI.DYNAMIC_BUTTON_ON_COLUMN_BY_TEXT, textButton);
		clickToElementByJS(driver, AdminEditCustomerPageUI.DYNAMIC_BUTTON_ON_COLUMN_BY_TEXT, textButton);
	}

	public void clickToDeleteAddressButton() {
		scrollToElement(driver, AdminEditCustomerPageUI.DYNAMIC_BUTTON_ON_COLUMN_BY_TEXT);
		waitForElementClickable(driver, AdminEditCustomerPageUI.DYNAMIC_BUTTON_ON_COLUMN_BY_TEXT);
		clickToElementByJS(driver, AdminEditCustomerPageUI.DYNAMIC_BUTTON_ON_COLUMN_BY_TEXT);

	}

	public void confirmDeleteAddressAlert() {
		acceptAlert(driver);
		sleepInSecond(2);
	}

	public boolean isNoDataAvailableInTableDisplayed() {
		waitForElementVisible(driver, AdminEditCustomerPageUI.NO_DATA_AVAILABLE_ON_TABLE_MESSAGE);
		return isElementDisplayed(driver, AdminEditCustomerPageUI.NO_DATA_AVAILABLE_ON_TABLE_MESSAGE);
	}

	public void clickToAddAddressButton(String cartTitleName, String buttonName) {
		//scrollToElement(driver, AdminEditCustomerPageUI.CARD_TITLE_ON_DETAIL_CUSTOMER_BY_TEXT, cartTitleName);
		
		waitForElementClickable(driver, AdminEditCustomerPageUI.DYNAMIC_BUTTON_ON_EDIT_CUSTOMER_PAGE_BY_TEXT, buttonName);
		clickToElementByJS(driver, AdminEditCustomerPageUI.DYNAMIC_BUTTON_ON_EDIT_CUSTOMER_PAGE_BY_TEXT, buttonName);
		System.out.println("2");
		sleepInSecond(1);
	}
}
