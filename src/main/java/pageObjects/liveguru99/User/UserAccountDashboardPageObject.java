package pageObjects.liveguru99.User;

import org.openqa.selenium.WebDriver;

import PageUIs.liveGuru.user.UserAccountDashboardPageUI;
import commons.BasePage;

public class UserAccountDashboardPageObject extends BasePage{
	WebDriver driver;
	
	public UserAccountDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean getSuccessMessage() {
		waitForElementVisible(driver, UserAccountDashboardPageUI.REGISTER_SUCCESS_MESSAGE);
		return isElementDisplayed(driver, UserAccountDashboardPageUI.REGISTER_SUCCESS_MESSAGE);
	}

	public boolean getWelcomeToDashboardPage() {
		waitForElementVisible(driver, UserAccountDashboardPageUI.WELCOME_DASHBOARD_PAGE);
		return isElementDisplayed(driver, UserAccountDashboardPageUI.WELCOME_DASHBOARD_PAGE);
	}

}
