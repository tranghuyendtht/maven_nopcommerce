package pageObjects.nopcommerce.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.google.common.collect.Ordering;

import PageUIs.nopcommerce.admin.AdminCustomerPageUI;
import PageUIs.nopcommerce.user.UserComputerProductPageUI;
import PageUIs.nopcommerce.user.UserHomePageUI;
import commons.BasePage;
import commons.PageGeneratorManager;

public class UserComputerProductPageObject extends BasePage{
	private WebDriver driver;
	
	public UserComputerProductPageObject (WebDriver driver) {
		this.driver = driver;
	}

	public void selectProductSortOrderByName(String textValue) {
		waitForElementVisible(driver, UserComputerProductPageUI.SORT_ORDER_DROPDOWN_LIST);
		selectItemInDefaultDropDown(driver, UserComputerProductPageUI.SORT_ORDER_DROPDOWN_LIST, textValue);
		sleepInSecond(5);
		
	}

	public boolean isProductNameSortedAToZ() {
		List<WebElement> listAllProductName = getElements(driver, UserComputerProductPageUI.PRODUCT_NAME_LIST);
		List<String> productNameTitle = new ArrayList<String>();
		
		for (WebElement eachProductName : listAllProductName) {
			productNameTitle.add(eachProductName.getText());
		}
		boolean sorted = Ordering.natural().isOrdered(productNameTitle);
		return sorted;
	}
	
	public boolean isProductNameSortedZToA() {
		List<WebElement> listAllProductName = getElements(driver, UserComputerProductPageUI.PRODUCT_NAME_LIST);
		List<String> productNameTitle = new ArrayList<String>();
		
		for (WebElement eachProductName : listAllProductName) {
			productNameTitle.add(eachProductName.getText());
		}
		boolean sorted = Ordering.natural().reverse().isOrdered(productNameTitle);
		return sorted;
	}

	public void clickToSubMenuLinkTextOnHeaderMenuByText(String childTitleName) {
		waitForElementClickable(driver, UserHomePageUI.SUB_MENU_LINKTEXT,childTitleName);
		clickToElement(driver, UserHomePageUI.SUB_MENU_LINKTEXT,childTitleName);
		sleepInSecond(3);
	}

	public boolean isProductNameSortedLowToHighPrice() {
		List<WebElement> listAllProductPrice = getElements(driver, UserComputerProductPageUI.PRODUCT_PRICE_LIST);
		List<Integer> productPrice = new ArrayList<Integer>();
		
		for (WebElement eachProductPrice : listAllProductPrice) {
			int price = Integer.valueOf(eachProductPrice.getText().replaceAll("[^A-Za-z0-9]","")) ;
			productPrice.add(price);
		}
		boolean sorted = Ordering.natural().isOrdered(productPrice);
		return sorted;
		
	}

	public boolean isProductNameSortedHighToLowPrice() {
		List<WebElement> listAllProductPrice = getElements(driver, UserComputerProductPageUI.PRODUCT_PRICE_LIST);
		List<Integer> productPrice = new ArrayList<Integer>();
		
		for (WebElement eachProductPrice : listAllProductPrice) {
			int price = Integer.valueOf(eachProductPrice.getText().replaceAll("[^A-Za-z0-9]","")) ;
			productPrice.add(price);
		}
		boolean sorted = Ordering.natural().reverse().isOrdered(productPrice);
		return sorted;
		
	}

	public void selectProductPageSizeWithRecordNumber(String numberOfRecord) {
		waitForElementVisible(driver, UserComputerProductPageUI.PRODUCT_PAGE_SIZE);
		selectItemInDefaultDropDown(driver, UserComputerProductPageUI.PRODUCT_PAGE_SIZE, numberOfRecord);
		sleepInSecond(5);
		
	}

	public boolean isNumberOfProductDisplayedMatch(int maxSize) {
		int numberOfProduct = 0;
		boolean pass = true;
		int numberOfPage = getNumberofPage();
		
		for (int i = 1; i <= numberOfPage; i++) {
			waitForElementClickable(driver, UserComputerProductPageUI.NUMBER_OF_PAGE, String.valueOf(i));
			clickToElement(driver, UserComputerProductPageUI.NUMBER_OF_PAGE, String.valueOf(i));
			sleepInSecond(3);
			
			List<WebElement> numberOfProductPerPage = getElements(driver, UserComputerProductPageUI.NUMBER_OF_PRODUCT_PER_PAGE);
			numberOfProduct = numberOfProductPerPage.size();
			
			if(numberOfProduct <= maxSize) {
				pass = true;
			} else {
				pass = false;
			}
		}
		return pass;
		
	}
	
	public int getNumberofPage() {
		int numberOfPage = 0;
		List<WebElement> listAllPage = getElements(driver, UserComputerProductPageUI.TOTAL_PAGE);
		if (listAllPage.size()== 3) {
			numberOfPage = 2;
		} else if (listAllPage.size()>3) {
			numberOfPage = listAllPage.size() - 2;
		}
		return numberOfPage;
	}

	public boolean isNextPageIconDisplayedWhenStayInFirstPage(String numberOfPage) {
		waitForElementClickable(driver, UserComputerProductPageUI.NUMBER_OF_PAGE, numberOfPage);
		clickToElement(driver, UserComputerProductPageUI.NUMBER_OF_PAGE, numberOfPage);
		sleepInSecond(1);
		return isElementDisplayed(driver, UserComputerProductPageUI.NEXT_PAGE_ICON);
		
	}

	public boolean isPreviousPageIconDisplayedWhenStayInSecondPage(String numberOfPage) {
		waitForElementClickable(driver, UserComputerProductPageUI.NUMBER_OF_PAGE, numberOfPage);
		clickToElement(driver, UserComputerProductPageUI.NUMBER_OF_PAGE, numberOfPage);
		sleepInSecond(1);
		return isElementDisplayed(driver, UserComputerProductPageUI.PRIVIOUS_PAGE_ICON);
		
		
	}

	public boolean isPreviousPagingUndisplayed() {
		return isElementUndisplayed(driver, UserComputerProductPageUI.PRIVIOUS_PAGE_ICON);
	}
	
	public boolean isNextPagingUndisplayed() {
		return isElementUndisplayed(driver, UserComputerProductPageUI.NEXT_PAGE_ICON);
	}

	public UserProductDetailPageObject clickToProductByName(String productName) {
		waitForElementClickable(driver, UserComputerProductPageUI.PRODUCT_NAME_BY_NAME, productName);
		clickToElement(driver, UserComputerProductPageUI.PRODUCT_NAME_BY_NAME, productName);
		return PageGeneratorManager.getUserAProductInfoDetail(driver);
	}
}
