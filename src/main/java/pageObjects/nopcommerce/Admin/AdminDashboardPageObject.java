package pageObjects.nopcommerce.Admin;

import org.openqa.selenium.WebDriver;

import PageUIs.nopcommerce.admin.AdminDashboardPageUI;
import commons.BasePage;
import commons.PageGeneratorManager;

public class AdminDashboardPageObject extends BasePage {
	private WebDriver driver;

	public AdminDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isDashboardTextHeaderDisplayed() {
		waitForElementVisible(driver, AdminDashboardPageUI.DASHBOARD_HEADER_TEXT);
		return isElementDisplayed(driver, AdminDashboardPageUI.DASHBOARD_HEADER_TEXT);

	}

	

	

}
