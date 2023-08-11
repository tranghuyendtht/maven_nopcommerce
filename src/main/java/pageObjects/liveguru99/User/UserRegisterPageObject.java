package pageObjects.liveguru99.User;

import org.openqa.selenium.WebDriver;

import PageUIs.liveGuru.user.UserRegisterPageUI;
import commons.BasePage;

public class UserRegisterPageObject extends BasePage {
	WebDriver driver;

	public UserRegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, UserRegisterPageUI.INPUT_FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.INPUT_FIRST_NAME_TEXTBOX, firstName);
	}

	public void inputToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, UserRegisterPageUI.INPUT_LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.INPUT_LAST_NAME_TEXTBOX, lastName);
	}

	public void inputToEmailAddressTextbox(String emailAdd) {
		waitForElementVisible(driver, UserRegisterPageUI.INPUT_EMAIL_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.INPUT_EMAIL_ADDRESS_TEXTBOX, emailAdd);
	}

	public void inputToPasswordTextbox(String password) {

		waitForElementVisible(driver, UserRegisterPageUI.INPUT_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.INPUT_PASSWORD_TEXTBOX, password);
	}

	public void inputToConfirmPasswordTextbox(String password) {

		waitForElementVisible(driver, UserRegisterPageUI.INPUT_CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.INPUT_CONFIRM_PASSWORD_TEXTBOX, password);
	}

	public UserAccountDashboardPageObject clickToLoginButton() {

		waitForElementClickable(driver, UserRegisterPageUI.BUTTON_REGISTER);
		clickToElement(driver, UserRegisterPageUI.BUTTON_REGISTER);

		return PageGeneratorManager.getUserAccountDashboardPage(driver);
	}

	public UserAccountDashboardPageObject enterDataToRegister(String firstName, String lastName, String emailAdd,
			String password) {
		inputToFirstNameTextbox(firstName);
		inputToLastNameTextbox(lastName);
		inputToEmailAddressTextbox(emailAdd);
		inputToPasswordTextbox(password);
		inputToConfirmPasswordTextbox(password);
		return clickToLoginButton();
	}
}
