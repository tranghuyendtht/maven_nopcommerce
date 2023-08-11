package pageObjects.nopcommerce.Admin;

import org.openqa.selenium.WebDriver;

import PageUIs.nopcommerce.admin.AdminProductDetailPageUI;
import commons.BasePage;

public class AdminProductDetailPageObject extends BasePage {
	private WebDriver driver;

	public AdminProductDetailPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getTile() {
		waitForElementVisible(driver, AdminProductDetailPageUI.PRODUCT_DETAIL_PAGE_TITLE);
		return getElementText(driver, AdminProductDetailPageUI.PRODUCT_DETAIL_PAGE_TITLE);
	}

	public String getProductName() {
		waitForElementVisible(driver, AdminProductDetailPageUI.PRODUCT_NAME_TEXTBOX);
		return getElementAtribute(driver, AdminProductDetailPageUI.PRODUCT_NAME_TEXTBOX,"value");
	}

	public boolean getFullDescription() {
		waitForElementVisible(driver, AdminProductDetailPageUI.FULL_DESCRIPTION_TEXTAREA);
		return isElementDisplayed(driver, AdminProductDetailPageUI.FULL_DESCRIPTION_TEXTAREA);
	}

	public String getSKUInfo() {
		waitForElementVisible(driver, AdminProductDetailPageUI.PRODUCT_SKU_TEXTBOX);
		return getElementAtribute(driver, AdminProductDetailPageUI.PRODUCT_SKU_TEXTBOX,"value");
	}

	public String getCategories() {
		waitForElementVisible(driver, AdminProductDetailPageUI.CATEGORIES);
		return getElementText(driver, AdminProductDetailPageUI.CATEGORIES);
	}

	public boolean isCheckboxCheckedByName(String checkboxID) {
		waitForElementVisible(driver, AdminProductDetailPageUI.CHECKBOX_BY_ID, checkboxID);
		return isElementIsSelected(driver, AdminProductDetailPageUI.CHECKBOX_BY_ID, checkboxID);
	}

	public String getPrice() {
		waitForElementVisible(driver, AdminProductDetailPageUI.PRICE_DROPLIST);
		return getElementAtribute(driver, AdminProductDetailPageUI.PRICE_DROPLIST,"aria-valuenow");
	}
	
	public String getStockQuantity() {
		waitForElementVisible(driver, AdminProductDetailPageUI.STOCK_QUANTITY_DROPLIST);
		return getElementAtribute(driver, AdminProductDetailPageUI.STOCK_QUANTITY_DROPLIST,"aria-valuenow");
	}
	
	public boolean isImageDisplayed() {
		waitForElementVisible(driver, AdminProductDetailPageUI.PRODUCT_IMAGE);
		return isImageUpLoaded(driver, AdminProductDetailPageUI.PRODUCT_IMAGE);
	}

	

}
