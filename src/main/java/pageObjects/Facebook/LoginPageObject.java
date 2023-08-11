package pageObjects.Facebook;

import org.openqa.selenium.WebDriver;

import PageUIs.Facebook.LoginPageUI;
import commons.BasePage;

public class LoginPageObject extends BasePage {
	WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToCreateNewAccountButton() {
		waitForElementClickable(driver, LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
		clickToElement(driver, LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
	}

	public boolean isEmailAddressTextboxIsDisplayed() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
		return isElementDisplayed(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
	}

	public void inputToEmailAddressTextbox(String emailAdd) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX, emailAdd);
	}

	public boolean isConfirmEmailAddressTextboxIsUndisplayed() {
		waitForElementUndisplayed(driver, LoginPageUI.CONFIRM_EMAIL_ADDRESS_TEXTBOX);
		return isElementUndisplayed(driver, LoginPageUI.CONFIRM_EMAIL_ADDRESS_TEXTBOX);
	}

	public void clickToSignUpCloseIcon() {
		waitForElementClickable(driver, LoginPageUI.SIGN_UP_CLOSE_ICON);
		clickToElement(driver, LoginPageUI.SIGN_UP_CLOSE_ICON);
		
	}

}
