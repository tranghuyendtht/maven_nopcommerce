package pageObjects.nopcommerce.User;

import org.openqa.selenium.WebDriver;

import PageUIs.nopcommerce.user.UserProductListUI;
import commons.BasePage;
import commons.PageGeneratorManager;

public class UserProductListPageObject extends BasePage {

	private WebDriver driver;

	public UserProductListPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToDesktopLink() {
		waitForElementClickable(driver, UserProductListUI.DESKTOP_LINK);
		clickToElement(driver, UserProductListUI.DESKTOP_LINK);
	}

	public UserProductDetailPageObject clickToAProduct() {
		waitForElementClickable(driver, UserProductListUI.A_NAME_PRODUCT_LINK);
		clickToElement(driver, UserProductListUI.A_NAME_PRODUCT_LINK);
		return PageGeneratorManager.getUserAProductInfoDetail(driver);
	}
	
	


}
