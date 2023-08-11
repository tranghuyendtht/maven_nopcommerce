package pageObjects.nopcommerce.Admin;

import org.openqa.selenium.WebDriver;

import PageUIs.nopcommerce.admin.AdminAddNewCustomerPageUI;
import PageUIs.nopcommerce.admin.AdminCustomerPageUI;
import PageUIs.nopcommerce.admin.AdminManageCustomerAddressPageUI;
import commons.BasePage;

public class AdminManageCustomerAddressPageObject extends BasePage{
	private WebDriver driver;

	public AdminManageCustomerAddressPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void setValueOnTextboxById(String idTextbox, String textValue) {
		sleepInSecond(2);
		waitForElementVisible(driver, AdminManageCustomerAddressPageUI.DYNAMIC_TEXTBOX_BY_ID, idTextbox);
		sendkeyToElement(driver, AdminManageCustomerAddressPageUI.DYNAMIC_TEXTBOX_BY_ID, textValue, idTextbox);
	}

	public void setValueOnDropDownListById(String idDropdownList, String textValue) {
		waitForElementVisible(driver, AdminManageCustomerAddressPageUI.DYNAMIC_DROPDOWN_LIST_BY_ID,idDropdownList);
		selectItemInDefaultDropDown(driver, AdminManageCustomerAddressPageUI.DYNAMIC_DROPDOWN_LIST_BY_ID, textValue, idDropdownList);
		sleepInSecond(1);
	}

	public void clickToDynamicButtonByText(String textButton) {
		waitForElementClickable(driver, AdminManageCustomerAddressPageUI.DYNAMIC_BUTTON_BY_TEXT, textButton);
		clickToElementByJS(driver, AdminManageCustomerAddressPageUI.DYNAMIC_BUTTON_BY_TEXT, textButton);
		
	}

	public boolean isVerifySuccessMessageDisplayed(String textMessage) {
		waitForElementVisible(driver, AdminManageCustomerAddressPageUI.SUCCESS_MESSAGE_CREATE_NEW_CUSTOMER, textMessage);
		return isElementDisplayed(driver, AdminManageCustomerAddressPageUI.SUCCESS_MESSAGE_CREATE_NEW_CUSTOMER, textMessage);
		
	}

	public String getInfoTextboxByID(String textboxID) {
		waitForElementVisible(driver, AdminManageCustomerAddressPageUI.DYNAMIC_TEXTBOX_BY_ID, textboxID);
		return getElementAtribute(driver, AdminManageCustomerAddressPageUI.DYNAMIC_TEXTBOX_BY_ID, "value", textboxID);
	}

	public String getSelectedValueOnDropdownListByID(String dropdownlistID) {
		waitForElementVisible(driver, AdminManageCustomerAddressPageUI.DYNAMIC_DROPDOWN_LIST_BY_ID, dropdownlistID);
		return getSelectedItemDefaultDropdown(driver, AdminManageCustomerAddressPageUI.DYNAMIC_DROPDOWN_LIST_BY_ID, dropdownlistID);
	}

	public AdminEditCustomerPageObject clickBackToCustomerDetail() {
		waitForElementClickable(driver, AdminManageCustomerAddressPageUI.BACK_TO_CUSTOMER_DETAIL_LINKTEXT);
		clickToElementByJS(driver, AdminManageCustomerAddressPageUI.BACK_TO_CUSTOMER_DETAIL_LINKTEXT);
		sleepInSecond(1);
		return PageGeneratorManager.getAdminEditCustomerPage(driver);
	}
		

}
