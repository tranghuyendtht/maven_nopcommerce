package pageObjects.nopcommerce.Admin;

import org.openqa.selenium.WebDriver;

import PageUIs.nopcommerce.admin.AdminAddNewCustomerPageUI;
import commons.BasePage;

public class AdminAddNewCustomerPageObject extends BasePage {
	private WebDriver driver;

	public AdminAddNewCustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void setInfoToTextboxByID(String idTextbox, String textValue) {
		waitForElementVisible(driver, AdminAddNewCustomerPageUI.DYNAMIC_TEXTBOX_BY_ID, idTextbox);
		sendkeyToElement(driver, AdminAddNewCustomerPageUI.DYNAMIC_TEXTBOX_BY_ID, textValue, idTextbox);
	}
	public void setInfoToTextAreaByID(String idTextarea, String textValue) {
		waitForElementVisible(driver, AdminAddNewCustomerPageUI.DYNAMIC_TEXTAREA_BY_ID, idTextarea);
		sendkeyToElement(driver, AdminAddNewCustomerPageUI.DYNAMIC_TEXTAREA_BY_ID, textValue, idTextarea);
	}
	public String getInfoToTextAreaByID(String idTextarea) {
		waitForElementVisible(driver, AdminAddNewCustomerPageUI.DYNAMIC_TEXTAREA_BY_ID, idTextarea);
		return getElementText(driver, AdminAddNewCustomerPageUI.DYNAMIC_TEXTAREA_BY_ID,idTextarea);
	}

	public boolean isSuccessMessageDisplayed() {
		waitForElementVisible(driver, AdminAddNewCustomerPageUI.DYNAMIC_TEXTBOX_BY_ID);
		return isElementDisplayed(driver, AdminAddNewCustomerPageUI.DYNAMIC_TEXTBOX_BY_ID);
	}

	public void setValueOnCheckboxOrRadioButtonByID(String idCheckboxOrIdRadioButton) {
		waitForElementClickable(driver, AdminAddNewCustomerPageUI.DYNAMIC_CHECKBOX_OR_RADIO_BUTTON_BY_ID,
				idCheckboxOrIdRadioButton);
		checkToCheckboxORRadio(driver, AdminAddNewCustomerPageUI.DYNAMIC_CHECKBOX_OR_RADIO_BUTTON_BY_ID,
				idCheckboxOrIdRadioButton);
	}

	public void chooseDateOfBirth(String dateValue) {
		sleepInSecond(2);
		waitForElementVisible(driver, AdminAddNewCustomerPageUI.DATE_OF_BIRTH_DATE_VIEW);
		sendkeyToElement(driver, AdminAddNewCustomerPageUI.DATE_OF_BIRTH_DATE_VIEW, dateValue);
		sleepInSecond(3);
	}

	public void chooseCustomerRole(String customerRoleValue) {
		// Xóa hết giá trị mặc định đang có
		clickToElementByJS(driver, AdminAddNewCustomerPageUI.CLOSE_ICON_ON_CUSTOMER_ROLE_DROPDOWN_LIST);

		waitForElementVisible(driver, AdminAddNewCustomerPageUI.CUSTOMER_ROLES_DROPDOWN_LIST_PARENT);
		selectItemInCustomDropdown(driver, AdminAddNewCustomerPageUI.CUSTOMER_ROLES_DROPDOWN_LIST_PARENT,
				AdminAddNewCustomerPageUI.CUSTOMER_ROLES_DROPDOWN_LIST_CHILD, customerRoleValue);

		sleepInSecond(3);
	}

	public void clickToButtonSaveAndContinueEdit() {
		waitForElementClickable(driver, AdminAddNewCustomerPageUI.SAVE_AND_CONTINUE_EDIT_BUTTON);
		clickToElement(driver, AdminAddNewCustomerPageUI.SAVE_AND_CONTINUE_EDIT_BUTTON);
	}

	public boolean isVerifySuccessMessageDisplayed(String textMessage) {
		waitForElementVisible(driver, AdminAddNewCustomerPageUI.SUCCESS_MESSAGE_CREATE_NEW_CUSTOMER, textMessage);
		return isElementDisplayed(driver, AdminAddNewCustomerPageUI.SUCCESS_MESSAGE_CREATE_NEW_CUSTOMER, textMessage);
	}

	public boolean isTitlePageContainsCustomerName(String fullName) {
		waitForElementVisible(driver, AdminAddNewCustomerPageUI.TITLE_EDIT_CUSTOMER_DETAIL_PAGE);
		return getElementText(driver, AdminAddNewCustomerPageUI.TITLE_EDIT_CUSTOMER_DETAIL_PAGE)
				.contains(fullName);
	}

	public String getInfoTextboxByID(String textboxID) {
		waitForElementVisible(driver, AdminAddNewCustomerPageUI.DYNAMIC_TEXTBOX_BY_ID, textboxID);
		return getElementAtribute(driver, AdminAddNewCustomerPageUI.DYNAMIC_TEXTBOX_BY_ID, "value", textboxID);
	}

	public boolean isGenderChecked(String idCheckboxOrIdRadioButton) {
		waitForElementVisible(driver, AdminAddNewCustomerPageUI.RADIO_GENDER, idCheckboxOrIdRadioButton);
		return isElementIsSelected(driver, AdminAddNewCustomerPageUI.RADIO_GENDER, idCheckboxOrIdRadioButton);
	}

	public String getInfoDateOfBirth() {
		waitForElementVisible(driver, AdminAddNewCustomerPageUI.BIRTH_DAY_DROPDOWN_LIST);
		return getElementAtribute(driver, AdminAddNewCustomerPageUI.BIRTH_DAY_DROPDOWN_LIST, "value");
	}

	public String getInfoCustomerRole() {
		waitForElementVisible(driver, AdminAddNewCustomerPageUI.CUSTOMER_ROLES_SELECTED);
		return getElementText(driver, AdminAddNewCustomerPageUI.CUSTOMER_ROLES_SELECTED);
	}

	public AdminSearchCustomerPageObject clickBackToCustomerListButton() {
		waitForElementClickable(driver, AdminAddNewCustomerPageUI.BACK_TO_CUSTOMER_LIST_LINKTEXT);
		clickToElementByJS(driver, AdminAddNewCustomerPageUI.BACK_TO_CUSTOMER_LIST_LINKTEXT);
		sleepInSecond(3);
		return PageGeneratorManager.getAdminSearchCustomerPage(driver);
	}

	public AdminSearchCustomerPageObject clickToSaveButton() {
		waitForElementClickable(driver, AdminAddNewCustomerPageUI.SAVE_BUTTON_ON_EDIT_CUSTOMER_PAGE);
		clickToElementByJS(driver, AdminAddNewCustomerPageUI.SAVE_BUTTON_ON_EDIT_CUSTOMER_PAGE);
		sleepInSecond(3);
		return PageGeneratorManager.getAdminSearchCustomerPage(driver);
	}
}
