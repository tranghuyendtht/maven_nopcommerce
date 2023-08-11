package pageObjects.nopcommerce.User;

import org.openqa.selenium.WebDriver;

import PageUIs.nopcommerce.user.UserLoginPageUI;
import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;

public class UserLoginPageObject extends BasePage{
	private WebDriver driver;
	

	public UserLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step ("Input to Email Textbox")
	public UserHomePageObject clickToLoginButton() {
		waitForElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
		//return new HomePageObject(driver);
		return PageGeneratorManager.getUserHomePage(driver);
	}

	
	@Step ("Input to Email Textbox with value: {0}")
	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, UserLoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX,email);
		
	}
	@Step ("Input to Password Textbox with value: {0}")
	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX,password);
		
	}
	public UserHomePageObject loginAsUser(String email, String password) {
		inputToEmailTextbox(email);
		inputToPasswordTextbox(password);
		return clickToLoginButton();
	}

	public String getErrorMessageForIncorrectInput() {
		waitForElementVisible(driver, UserLoginPageUI.ERROR_INCORRECT_INPUT);
		return getElementText(driver, UserLoginPageUI.ERROR_INCORRECT_INPUT);
	}
	
	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, UserLoginPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, UserLoginPageUI.EMAIL_ERROR_MESSAGE);
	}

	public UserHomePageObject getUserHomePage(WebDriver driver) {
		return PageGeneratorManager.getUserHomePage(driver);
	}
	
	public void clickToCloseIcon() {
		waitForElementClickable(driver, UserLoginPageUI.CLOSE_ICON);
		clickToElement(driver, UserLoginPageUI.CLOSE_ICON);
	}



}
