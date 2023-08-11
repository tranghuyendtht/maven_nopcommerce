package pageObjects.liveguru99.Admin;

import org.openqa.selenium.WebDriver;

import PageUIs.liveGuru.admin.AdminLoginPageUI;
import commons.BasePage;
import pageObjects.liveguru99.User.PageGeneratorManager;

public class AdminLoginPageObject extends BasePage {
	private WebDriver driver;

	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToUserNameTextbox(String userName) {
		waitForElementVisible(driver, AdminLoginPageUI.USERNAME_TEXTBOX);
		sendkeyToElementByJS(driver, AdminLoginPageUI.USERNAME_TEXTBOX, userName);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElementByJS(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public AdminCustomerPageObject clickToLoginButton() {
		waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getAdminCustomerPage(driver);
	}

	public AdminCustomerPageObject loginAsAdmin(String userName, String password) {
		inputToUserNameTextbox(userName);
		inputToPasswordTextbox(password);
		return clickToLoginButton();
	}

}
