package pageObjects.nopcommerce.User;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageUIs.nopcommerce.user.UserRecentlyViewedProductsPageUI;
import commons.BasePage;

public class UserRecentlyViewedProductsPageObject extends BasePage {
	private WebDriver driver;

	public UserRecentlyViewedProductsPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean verifyIsThreeLastestProductsDisplayed() {
		boolean pass = true;
		int productTotal = getNumberOfProductOnPage();
		if (productTotal <= 3) {
			pass = true;
		} else {
			pass = false;
		}
		return pass;
	}

	public boolean verifyIsImageDisplayed(String infoProduct) {
		int productTotal = getNumberOfProductOnPage();
		boolean pass = false;
		
		for (int i = 1; i <= productTotal; i++) {
			waitForElementVisible(driver, UserRecentlyViewedProductsPageUI.PRODUCT_IMAGE, String.valueOf(i), infoProduct);
			if(isImageUpLoaded(driver, UserRecentlyViewedProductsPageUI.PRODUCT_IMAGE, String.valueOf(i), infoProduct)) {
				pass = true;
			} else {
				pass = false;
			}
		}
		return pass;
		
		
	}

	public int getNumberOfProductOnPage() {
		List<WebElement> productTotalWE = getElements(driver, UserRecentlyViewedProductsPageUI.PRODUCT_TOTAL);
		return productTotalWE.size();
	}
	public boolean verifyIsProductNameDisplayed() {
		int productTotal = getNumberOfProductOnPage();
		boolean pass = true;
		
		for (int i = 1; i <= productTotal; i++) {
			waitForElementVisible(driver, UserRecentlyViewedProductsPageUI.PRODUCT_NAME, String.valueOf(i));
			if(isElementDisplayed(driver, UserRecentlyViewedProductsPageUI.PRODUCT_NAME, String.valueOf(i))){
				pass = true;
			} else {
				pass = false;
			}
			
		}
		return pass;
		
	}

	public boolean verifyIsInfoProductDisplayedByClassName(String infoProduct) {
		int productTotal = getNumberOfProductOnPage();
		boolean pass = true;
		
		for (int i = 1; i <= productTotal; i++) {
			waitForElementVisible(driver, UserRecentlyViewedProductsPageUI.PRODUCT_INFO_BY_CLASS_NAME, String.valueOf(i), infoProduct);
			if(isElementDisplayed(driver, UserRecentlyViewedProductsPageUI.PRODUCT_INFO_BY_CLASS_NAME, String.valueOf(i), infoProduct)){
				pass = true;
			} else {
				pass = false;
			}
			
		}
		return pass;
		
	}

	

	public boolean verifyIsFeatureNameDisplayedByText(String featureName) {
		int productTotal = getNumberOfProductOnPage();
		boolean pass = true;
		
		for (int i = 1; i <= productTotal; i++) {
			waitForElementVisible(driver, UserRecentlyViewedProductsPageUI.FEATURE_NAME_BY_TEXT, String.valueOf(i), featureName);
			if(isElementDisplayed(driver, UserRecentlyViewedProductsPageUI.FEATURE_NAME_BY_TEXT, String.valueOf(i), featureName)){
				pass = true;
			} else {
				pass = false;
			}
			
		}
		return pass;
		
	}

}
