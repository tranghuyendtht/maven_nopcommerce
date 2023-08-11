package pageObjects.nopcommerce.User;

import org.openqa.selenium.WebDriver;

import PageUIs.nopcommerce.user.UserCustomerInfoPageUI;
import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;

public class UserCustomerInfoPageObject extends BasePage {

	private WebDriver driver;

	public UserCustomerInfoPageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step ("Click to Gender Radio")
	public void clickToGenderRadio() {
		waitForElementClickable(driver, UserCustomerInfoPageUI.GENDER_RADIO);
		clickToElement(driver, UserCustomerInfoPageUI.GENDER_RADIO);

	}

	@Step ("Input data to firstname textbox with value: {0}")
	public void inputToFirstNameTextbox(String newFirstName) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, UserCustomerInfoPageUI.FIRST_NAME_TEXTBOX, newFirstName);

	}
	
	@Step ("Input data to lastname textbox with value: {0}")
	public void inputToLastNameTextbox(String newLastName) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, UserCustomerInfoPageUI.LAST_NAME_TEXTBOX, newLastName);

	}

	@Step ("Select day of birth")
	public void selectDayOfBirth(String day) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.DATE_OF_BIRTH_DAY_DROPDOWN_LIST);
		selectItemInDefaultDropDown(driver, UserCustomerInfoPageUI.DATE_OF_BIRTH_DAY_DROPDOWN_LIST, day);

	}

	@Step ("Select month of birth")
	public void selectMonthOfBirth(String month) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.DATE_OF_BIRTH_MONTH_DROPDOWN_LIST);
		selectItemInDefaultDropDown(driver, UserCustomerInfoPageUI.DATE_OF_BIRTH_MONTH_DROPDOWN_LIST, month);

	}


	@Step ("Select year of birth")
	public void selectYearOfBirth(String year) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.DATE_OF_BIRTH_YEAR_DROPDOWN_LIST);
		selectItemInDefaultDropDown(driver, UserCustomerInfoPageUI.DATE_OF_BIRTH_YEAR_DROPDOWN_LIST, year);

	}
	
	@Step ("Input data to email textbox with value: {0}")
	public void inputToEmailTextbox(String newEmail) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, UserCustomerInfoPageUI.EMAIL_TEXTBOX, newEmail);

	}
	
	public UserCustomerInfoPageObject clickToCustomerInfoLink() {
		waitForElementClickable(driver, UserCustomerInfoPageUI.CUSTOMER_INFO_LINK);
		clickToElement(driver, UserCustomerInfoPageUI.CUSTOMER_INFO_LINK);
		return PageGeneratorManager.getUserCustomerInfoPage(driver);
	}
	

	@Step ("Input data to company textbox with value: {0}")
	public void inputToCompanyTextbox(String newCompanyName) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.COMPANY_TEXTBOX);
		sendkeyToElement(driver, UserCustomerInfoPageUI.COMPANY_TEXTBOX, newCompanyName);

	}
	
	@Step ("Input data to save button")
	public void clickToSaveButton() {
		waitForElementClickable(driver, UserCustomerInfoPageUI.SAVE_BUTTON);
		clickToElement(driver, UserCustomerInfoPageUI.SAVE_BUTTON);
		sleepInSecond(1);
	}

	@Step ("Verify result")
	public boolean isGenderIsSelected() {
		return getElementAtribute(driver, UserCustomerInfoPageUI.GENDER_RADIO, "checked").equalsIgnoreCase("true");

	}
	
	@Step ("Verify result")
	public boolean isFirstNameTextboxIsUpdated(String newFirstName) {

		return getElementAtribute(driver, UserCustomerInfoPageUI.FIRST_NAME_TEXTBOX, "value").equals(newFirstName);
	}
	
	@Step ("Verify result")
	public boolean isLastNameTextboxIsUpdated(String newLastName) {

		return getElementAtribute(driver, UserCustomerInfoPageUI.LAST_NAME_TEXTBOX, "value").equals(newLastName);
	}

	@Step ("Verify result")
	public boolean isDayOfBirthIsUpdated(String day) {
		return getSelectedItemDefaultDropdown(driver, UserCustomerInfoPageUI.DATE_OF_BIRTH_DAY_DROPDOWN_LIST).equals(day);
	}

	@Step ("Verify result")
	public boolean isMonthOfBirthIsUpdated(String month) {
		return getSelectedItemDefaultDropdown(driver, UserCustomerInfoPageUI.DATE_OF_BIRTH_MONTH_DROPDOWN_LIST)
				.equals(month);
	}

	@Step ("Verify result")
	public boolean isYearOfBirthIsUpdated(String year) {

		return getSelectedItemDefaultDropdown(driver, UserCustomerInfoPageUI.DATE_OF_BIRTH_YEAR_DROPDOWN_LIST).equals(year);
	}

	@Step ("Verify result")
	public boolean isCompanyTextboxIsUpdated(String newCompany) {
		return getElementAtribute(driver, UserCustomerInfoPageUI.COMPANY_TEXTBOX, "value").equals(newCompany);
	}

	@Step ("Verify result")
	public boolean isEmailTextboxIsUpdated(String newEmail) {

		return getElementAtribute(driver, UserCustomerInfoPageUI.EMAIL_TEXTBOX, "value").equals(newEmail);
	}
	
	@Step ("Click to close popup")
	public void closePopup() {
		waitForElementClickable(driver, UserCustomerInfoPageUI.POPUP);
		clickToElement(driver, UserCustomerInfoPageUI.POPUP);
	}

	@Step ("Click to Add new button")
	public void clickToAddNewButton() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.ADD_NEW_BUTTON);
		clickToElement(driver, UserCustomerInfoPageUI.ADD_NEW_BUTTON);

	}

	public void inputToAddFirstNameTextbox(String addFirstName) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.ADD_FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, UserCustomerInfoPageUI.ADD_FIRST_NAME_TEXTBOX, addFirstName);
	}

	public void inputToAddLastNameTextbox(String addLastName) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.ADD_LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, UserCustomerInfoPageUI.ADD_LAST_NAME_TEXTBOX, addLastName);

	}

	public void inputToAddEmailTextbox(String addEmail) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.ADD_EMAIL_TEXTBOX);
		sendkeyToElement(driver, UserCustomerInfoPageUI.ADD_EMAIL_TEXTBOX, addEmail);

	}

	public void selectToAddCountryDropdownList(String addCountry) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.ADD_COUNTRY_DROPDOWN_LIST);
		selectItemInDefaultDropDown(driver, UserCustomerInfoPageUI.ADD_COUNTRY_DROPDOWN_LIST, addCountry);

	}

	public void inputToAddCityTextbox(String addCity) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.ADD_CITY_TEXTBOX);
		sendkeyToElement(driver, UserCustomerInfoPageUI.ADD_CITY_TEXTBOX, addCity);

	}

	public void inputToAddAdressOneTextbox(String addAddress1) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.ADD_ADDRESS_1_TEXTBOX);
		sendkeyToElement(driver, UserCustomerInfoPageUI.ADD_ADDRESS_1_TEXTBOX, addAddress1);

	}

	public boolean isAddFirstNameTextboxIsUpdated(String addFirstName) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.ADD_NAME_UPDATED);
		return getElementText(driver, UserCustomerInfoPageUI.ADD_NAME_UPDATED).contains(addFirstName);
	}

	public boolean isAddLastNameTextboxIsUpdated(String addLastName) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.ADD_NAME_UPDATED);
		return getElementText(driver, UserCustomerInfoPageUI.ADD_NAME_UPDATED).contains(addLastName);
	}

	public boolean isAddPhoneTextboxIsUpdated(String addPhoneNumber) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.ADD_PHONE_UPDATED);
		return getElementText(driver, UserCustomerInfoPageUI.ADD_PHONE_UPDATED).contains(addPhoneNumber);
	}

	public boolean isAddEmailTextboxIsUpdated(String addEmail) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.ADD_EMAIL_UPDATED);
		return getElementText(driver, UserCustomerInfoPageUI.ADD_EMAIL_UPDATED).contains(addEmail);
	}

	public boolean isAddAddress1TextboxIsUpdated(String addAddress1) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.ADD_ADDRESS1_UPDATED);
		return getElementText(driver, UserCustomerInfoPageUI.ADD_ADDRESS1_UPDATED).contains(addAddress1);
	}

	public boolean isAddCityStateZipTextboxIsUpdated(String addCity) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.ADD_CITY_STATE_ZIP_UPDATED);
		return getElementText(driver, UserCustomerInfoPageUI.ADD_CITY_STATE_ZIP_UPDATED).contains(addCity);
	}

	public boolean isAddCountryDropdownListIsUpdated(String addCountry) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.ADD_COUNTRY_UPDATED);
		return getElementText(driver, UserCustomerInfoPageUI.ADD_COUNTRY_UPDATED).contains(addCountry);

	}

	public boolean isTitleIsDisplayed(String firstName) {
		return getElementText(driver, UserCustomerInfoPageUI.TITLE_RESULT).contains(firstName);
	}

	public void clickToSaveAddressButton() {
		waitForElementClickable(driver, UserCustomerInfoPageUI.SAVE_ADDRESS_BUTTON);
		clickToElement(driver, UserCustomerInfoPageUI.SAVE_ADDRESS_BUTTON);

	}

	public void inputToZipCodePortalTextbox(String addPostalCode) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.ADD_ZIP_POSTAL_CODE_TEXTBOX);
		sendkeyToElement(driver, UserCustomerInfoPageUI.ADD_ZIP_POSTAL_CODE_TEXTBOX, addPostalCode);

	}

	public void clickToChangePasswordButton() {
		waitForElementClickable(driver, UserCustomerInfoPageUI.CHANGE_PASSWORD_BUTTON);
		clickToElement(driver, UserCustomerInfoPageUI.CHANGE_PASSWORD_BUTTON);
		sleepInSecond(1);
	}

	public void inputToPhoneNumberTextbox(String addPhoneNumber) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.ADD_PHONE_NUMBER_TEXTBOX);

		sendkeyToElement(driver, UserCustomerInfoPageUI.ADD_PHONE_NUMBER_TEXTBOX, addPhoneNumber);
	}

	public void clickToChangePasswordLink() {
		waitForElementClickable(driver, UserCustomerInfoPageUI.CHANGE_PASSWORD_LINK);
		clickToElement(driver, UserCustomerInfoPageUI.CHANGE_PASSWORD_LINK);
	}

	public void inputToOldPasswordTextbox(String password) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.OLD_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserCustomerInfoPageUI.OLD_PASSWORD_TEXTBOX, password);

	}

	public void inputToNewPasswordTextbox(String newPassword) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.NEW_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserCustomerInfoPageUI.NEW_PASSWORD_TEXTBOX, newPassword);

	}

	public void inputToConfirmNewPasswordTextbox(String confirmNewPassword) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.CONFIRM_NEW_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserCustomerInfoPageUI.CONFIRM_NEW_PASSWORD_TEXTBOX, confirmNewPassword);
	}

	public boolean getSuccessfulNotificationAtBar() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.SUCCESSFUL_NOTIFICATION_BAR);
		return isElementDisplayed(driver, UserCustomerInfoPageUI.SUCCESSFUL_NOTIFICATION_BAR);
	}

	public void clickToClosePopup() {
		waitForElementClickable(driver, UserCustomerInfoPageUI.SUCCESSFUL_NOTIFICATION_CLOSE_ICON);
		clickToElement(driver, UserCustomerInfoPageUI.SUCCESSFUL_NOTIFICATION_CLOSE_ICON);

	}

	public UserHomePageObject clickToLogOutLink() {
		waitForElementClickable(driver, UserCustomerInfoPageUI.LOGOUT_LINK);
		clickToElementByJS(driver, UserCustomerInfoPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getUserHomePage(driver);
	}

	public boolean isSuccessNotiBarIsDisplayed(String noti) {
		waitForAllElementVisible(driver, UserCustomerInfoPageUI.ADD_SUCCESSFUL_NOTI_BAR);
		return getElementText(driver, UserCustomerInfoPageUI.ADD_SUCCESSFUL_NOTI_BAR).equals(noti);
	}

	public void clickToCloseNotiBar() {
		waitForElementClickable(driver, UserCustomerInfoPageUI.ADD_SUCCESSFUL_NOTI_CLOSE_ICON);
		clickToElement(driver, UserCustomerInfoPageUI.ADD_SUCCESSFUL_NOTI_CLOSE_ICON);

	}

	
	public void clickToMyProductReview() {
		waitForElementClickable(driver, UserCustomerInfoPageUI.MY_PRODUCT_REVIEW_LINK);
		clickToElement(driver, UserCustomerInfoPageUI.MY_PRODUCT_REVIEW_LINK);
	}

	
	public void clickToAddressLink() {
		sleepInSecond(3);
		waitForElementClickable(driver, UserCustomerInfoPageUI.ADDRESS_LINK);
		clickToElement(driver, UserCustomerInfoPageUI.ADDRESS_LINK);
		
	}

	public UserProductListPageObject clickToComputerLink() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isReviewTitleIsUpdated(String reviewTitle) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isReviewBodyIsUpdated(String reviewBody) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isSuccessMessageDisplayed() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.SUCCESS_MESSAGE_UPDATE_CUSTOMER_INFO);
		return isElementDisplayed(driver, UserCustomerInfoPageUI.SUCCESS_MESSAGE_UPDATE_CUSTOMER_INFO);
	}
	

}
