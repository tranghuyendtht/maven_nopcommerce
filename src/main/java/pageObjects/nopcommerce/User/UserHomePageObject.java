package pageObjects.nopcommerce.User;

import org.openqa.selenium.WebDriver;

import PageUIs.nopcommerce.user.BasePageUI;
import PageUIs.nopcommerce.user.UserHomePageUI;
import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;

public class UserHomePageObject extends BasePage {

	private WebDriver driver;

	public UserHomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Click to register link")
	public UserRegisterPageObject clickToRegisterLink() {
		waitForElementClickable(driver, UserHomePageUI.REGISTER_LINK);
		clickToElement(driver, UserHomePageUI.REGISTER_LINK);
		// Page Generator 2
		// return new RegisterPageObject(driver);
		// Page Generator 3
		return PageGeneratorManager.getUserRegisterPage(driver);
	}

	public UserLoginPageObject openLoginPage() {
		waitForElementClickable(driver, UserHomePageUI.LOGIN_LINK);
		clickToElement(driver, UserHomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getUserLoginPage(driver);
	}

	public UserMyAccountPageObject clickToMyAccountLink(WebDriver driver) {
		waitForElementClickable(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getUserMyAccountPage(driver);
	}

	public boolean isWelComePageDisplayed() {
		sleepInSecond(3);
		waitForElementVisible(driver, UserHomePageUI.LOGIN_SUCCESS_MESSAGE);
		return isElementDisplayed(driver, UserHomePageUI.LOGIN_SUCCESS_MESSAGE);
	}

	@Step("Verify success message displayed")
	public boolean isMyAccountLinkIsDisplay() {
		waitForElementVisible(driver, BasePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, BasePageUI.MY_ACCOUNT_LINK);

	}

	public boolean isRegisterLinkIsDisplayed() {
		waitForElementVisible(driver, UserHomePageUI.REGISTER_LINK);
		return isElementDisplayed(driver, UserHomePageUI.REGISTER_LINK);

	}

	public UserSearchKeywordPageObject clickToLinkTextOnFooterByText(String textValue) {
		waitForElementClickable(driver, UserHomePageUI.SEARCH_LINKTEXT_ON_FOOTER, textValue);
		clickToElement(driver, UserHomePageUI.SEARCH_LINKTEXT_ON_FOOTER, textValue);
		return PageGeneratorManager.getUserSearchKeywordPage(driver);
	}

	public UserComputerProductPageObject clickToLinkTextOnHeaderMenuByText(String parentTitleName) {
		waitForElementClickable(driver, UserHomePageUI.MENU_LINKTEXT, parentTitleName);
		clickToElement(driver, UserHomePageUI.MENU_LINKTEXT, parentTitleName);
		return PageGeneratorManager.getUserComputerProductPage(driver);
	}

	

}
