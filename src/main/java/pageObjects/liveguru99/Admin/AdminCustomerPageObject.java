package pageObjects.liveguru99.Admin;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageUIs.liveGuru.admin.AdminCustomerPageUI;
import commons.BasePage;

public class AdminCustomerPageObject extends BasePage {
	WebDriver driver;

	public AdminCustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isManageCustomerTextHeaderDisplayed() {
		waitForElementVisible(driver, AdminCustomerPageUI.WELCOME_MANAGE_CUSTOMER_PAGE);
		return isElementDisplayed(driver, AdminCustomerPageUI.WELCOME_MANAGE_CUSTOMER_PAGE);
	}

	public void inputToEmailTextbox(String emailAdd) {
		waitForElementVisible(driver, AdminCustomerPageUI.TEXTBOX_SEARCH_IN_COLUMN_EMAIL);
		sendkeyToElement(driver, AdminCustomerPageUI.TEXTBOX_SEARCH_IN_COLUMN_EMAIL, emailAdd);
		pressKeyToElement(driver, AdminCustomerPageUI.TEXTBOX_SEARCH_IN_COLUMN_EMAIL, Keys.ENTER, emailAdd);
		

	}

	public int getTotalRecordsFound() {
		waitForElementInvisible(driver, AdminCustomerPageUI.ICON_LOADING);
		int sizeTable = getElementSize(driver, AdminCustomerPageUI.TOTAL_RECORDS_FOUND);
		System.out.println("Số bản ghi" + sizeTable);
		return sizeTable;
	}

	public List<String> getSearchResult() {
		List<String> allRowValueAllPage = new ArrayList<String>();

		// Duyệt qua từng row để lấy các value và đưa vào arraylist
		List<WebElement> allRowEachPage = getElements(driver, AdminCustomerPageUI.CONTENT_RESULT);
		for (WebElement eachRow : allRowEachPage) {
			allRowValueAllPage.add(eachRow.getText());
			System.out.println("Text: " + eachRow.getText());
		}

		return allRowValueAllPage;
	}

	public void closePopupIncomeMessage() {
		waitForElementClickable(driver, AdminCustomerPageUI.ICON_CLOSE_INCOME_MESSAGE_POPUP);
		clickToElement(driver, AdminCustomerPageUI.ICON_CLOSE_INCOME_MESSAGE_POPUP);
	}

}
