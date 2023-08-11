package pageObjects.liveguru99.User;

import org.openqa.selenium.WebDriver;

import PageUIs.jQuery.dataTable.HomePageUI;
import PageUIs.liveGuru.user.UserHomePageUI;
import commons.BasePage;

public class UserHomePageObject extends BasePage {
	WebDriver driver;

	public UserHomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToAccountLink() {
		waitForElementClickable(driver, UserHomePageUI.ACCOUNT_LINK);
		clickToElement(driver, UserHomePageUI.ACCOUNT_LINK);
	}

	public UserRegisterPageObject clickToRegisterLink() {
		waitForElementClickable(driver, UserHomePageUI.REGISTER_LINK);
		clickToElement(driver, UserHomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getUserRegisterPage(driver);
		
	}
	public UserHomePageObject clickToLogOutLink() {
		waitForElementClickable(driver, UserHomePageUI.LOGOUT_LINK);
		clickToElement(driver, UserHomePageUI.LOGOUT_LINK);
		return PageGeneratorManager.getUserHomePage(driver);

	}

	public UserLoginPageObject clickToLoginLink() {
		
		waitForElementClickable(driver, UserHomePageUI.LOGIN_LINK);
		clickToElement(driver, UserHomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getUserLoginPage(driver);
	}

	public UserAccountDashboardPageObject enterToLoginForm(String emailAdd, String password) {
		waitForElementVisible(driver, UserHomePageUI.EMAIL_TEXTBOX_IN_LOGIN_FORM);
		sendkeyToElement(driver, UserHomePageUI.EMAIL_TEXTBOX_IN_LOGIN_FORM, emailAdd);
	
		waitForElementVisible(driver, UserHomePageUI.PASSWORD_TEXTBOX_IN_LOGIN_FORM);
		sendkeyToElement(driver, UserHomePageUI.PASSWORD_TEXTBOX_IN_LOGIN_FORM, password);
		
		waitForElementClickable(driver, UserHomePageUI.LOGIN_BUTTON);
		clickToElement(driver, UserHomePageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getUserAccountDashboardPage(driver);
		
	}

}
