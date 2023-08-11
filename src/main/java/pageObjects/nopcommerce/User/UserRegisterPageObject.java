package pageObjects.nopcommerce.User;

import org.openqa.selenium.WebDriver;

import PageUIs.nopcommerce.user.UserRegisterPageUI;
import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;

public class UserRegisterPageObject extends BasePage {
	private WebDriver driver;

	public UserRegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Input to Register Button")
	public void clickToRegisterButton() {
		waitForElementClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);

	}

	public String getErrorMessageAtFirstNameTextbox() {
		waitForElementVisible(driver, UserRegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
	}

	public String getErrorMessageAtLastNameTextbox() {
		waitForElementVisible(driver, UserRegisterPageUI.LAST_NAME_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.LAST_NAME_ERROR_MESSAGE);
	}

	public String getErrorMessageAtPasswordTextbox() {
		waitForElementVisible(driver, UserRegisterPageUI.PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.PASSWORD_ERROR_MESSAGE);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, UserRegisterPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.EMAIL_ERROR_MESSAGE);
	}

	public String getErrorMessageAtConfirmPasswordTextbox() {
		waitForElementVisible(driver, UserRegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
	}

	@Step("Input to FirstName Textbox with value: {0}")
	public void inputToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX, firstName);

	}

	@Step("Input to LastName Textbox with value: {0}")
	public void inputToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, UserRegisterPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.LAST_NAME_TEXTBOX, lastName);

	}

	@Step("Input to Email Textbox with value: {0}")
	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, UserRegisterPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.EMAIL_TEXTBOX, email);

	}

	@Step("Input to Password Textbox with value: {0}")
	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, UserRegisterPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.PASSWORD_TEXTBOX, password);

	}

	@Step("Input to Confirm Password Textbox with value: {0}")
	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);

	}

	@Step("Verify result register successfully")
	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
	}

	public String getErrorExistingEmailMessage() {
		waitForElementVisible(driver, UserRegisterPageUI.EMAIL_EXISTING_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.EMAIL_EXISTING_ERROR_MESSAGE);
	}

	@Step("Click to Logout Button")
	public void clickToLogoutLink() {
		waitForElementClickable(driver, UserRegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, UserRegisterPageUI.LOGOUT_LINK);

	}

	@Step("Click to Login Button")
	public UserLoginPageObject clickToLoginLink() {
		waitForElementClickable(driver, UserRegisterPageUI.LOGIN_LINK);
		clickToElement(driver, UserRegisterPageUI.LOGIN_LINK);
		return PageGeneratorManager.getUserLoginPage(driver);
	}

	public void selectDateOfBirthBySelectName(String selectName, String textValue) {
		waitForElementVisible(driver, UserRegisterPageUI.DYNAMIC_DATE_PICKER_BY_NAME, selectName);
		selectItemInDefaultDropDown(driver, UserRegisterPageUI.DYNAMIC_DATE_PICKER_BY_NAME, textValue, selectName);
		sleepInSecond(1);
	}

	public boolean isErrorMessageAtEmailTextboxDisplayed() {
		waitForElementVisible(driver, UserRegisterPageUI.WRONG_EMAIL_MESSAGE);
		return isElementDisplayed(driver, UserRegisterPageUI.WRONG_EMAIL_MESSAGE);

	}

}
