package commons;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageUIs.nopcommerce.user.BasePageUI;
import PageUIs.nopcommerce.admin.AdminBasePageUI;
import PageUIs.nopcommerce.user.UserCustomerInfoPageUI;
import PageUIs.nopcommerce.user.UserHomePageUI;
import PageUIs.nopcommerce.user.UserLoginPageUI;
import PageUIs.nopcommerce.user.UserRegisterPageUI;
import io.qameta.allure.Step;
import pageObjects.nopcommerce.Admin.AdminLoginPageObject;
import pageObjects.nopcommerce.Admin.AdminProductPageObject;
import pageObjects.nopcommerce.User.UserAddressPageObject;
import pageObjects.nopcommerce.User.UserBackInStockSubscriptionsPageObject;
import pageObjects.nopcommerce.User.UserChangePasswordPageObject;
import pageObjects.nopcommerce.User.UserCustomerInfoPageObject;
import pageObjects.nopcommerce.User.UserDownloadableProductPageObject;
import pageObjects.nopcommerce.User.UserHomePageObject;
import pageObjects.nopcommerce.User.UserMyAccountPageObject;
import pageObjects.nopcommerce.User.UserMyProductReviewsPageObject;
import pageObjects.nopcommerce.User.UserOrderPageObject;
import pageObjects.nopcommerce.User.UserRecentlyViewedProductsPageObject;
import pageObjects.nopcommerce.User.UserRewardPointsPageObject;
import pageObjects.nopcommerce.User.UserSearchKeywordPageObject;

public class BasePage {


	// Hàm khởi tạo
	public static BasePage getBasePageObject() {
		return new BasePage();
	}

	// Chứa các hàm dùng chung cho Page Object
	public void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}

	public String getTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshPage(WebDriver driver) {
		driver.navigate().refresh();
		sleepInSecond(2);
	}

	public void setCookies(WebDriver driver, Set<Cookie> cookies) {
		for (Cookie cookie : cookies) {
			driver.manage().addCookie(cookie);
		}
		sleepInSecond(2);
	}
	
	public Set<Cookie> getAllCookies (WebDriver driver) {
		return driver.manage().getCookies();
	}
	
	public Alert waitForAlertPresence(WebDriver driver) {
		WebDriverWait explictitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		return explictitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert(WebDriver driver) {
		waitForAlertPresence(driver).accept();
	}

	public void cancelAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();
	}

	public String getTextAlert(WebDriver driver) {
		return waitForAlertPresence(driver).getText();
	}

	public void sendkeyToAlert(WebDriver driver, String textAlert) {
		waitForAlertPresence(driver).sendKeys(textAlert);
	}

	public String getWindowHandle(WebDriver driver) {
		return driver.getWindowHandle();
	}

	public void switchWindowById(WebDriver driver, String windowId) {
		Set<String> allWindowIds = driver.getWindowHandles();
		for (String id : allWindowIds) {
			if (!id.equals(allWindowIds)) {
				driver.switchTo().window(id);
				break;
			}
		}
	}

	public void switchWindowByTitle(WebDriver driver, String tabTile) {
		Set<String> allWindowIds = driver.getWindowHandles();
		for (String id : allWindowIds) {
			driver.switchTo().window(id);
			String actualTitle = driver.getTitle();
			if (actualTitle.equals(tabTile)) {
				break;
			}
		}
	}

	public void closeAllTabsWithoutParent(WebDriver driver, String parentID) {
		Set<String> allWindowIds = driver.getWindowHandles();
		for (String id : allWindowIds) {

			if (!id.equals(parentID)) {
				driver.switchTo().window(id);
				driver.close();
			}
			driver.switchTo().window(parentID);
		}
	}

	private WebElement getElement(WebDriver driver, String locator) {
		return driver.findElement(getByLocator(locator));
	}
	
	public List<WebElement> getElements(WebDriver driver, String locatorType) {
		return driver.findElements(getByLocator(locatorType));
	}

	public List<WebElement> getElements(WebDriver driver, String locatorType, String...dynamicParams) {
		return driver.findElements(getByLocator(getDynamicXpath(locatorType, dynamicParams)));
	}

	private By getByXpath(String locator) {
		return By.xpath(locator);
	}

	// locatorType: id= | css= | xpath= | name= | class=
	// locatorType: Id= | Css= | XPath= | Name= | Class=
	// locatorType: id= | CSS= | XPATH= | NAME= | CLASS=
	private By getByLocator(String locatorType) {
		By by = null;
		if (locatorType.startsWith("id=") || locatorType.startsWith("Id=") || locatorType.startsWith("ID=")) {
			locatorType = locatorType.substring(3);
			by = by.id(locatorType);
		} else if (locatorType.startsWith("css=") || locatorType.startsWith("Css=") || locatorType.startsWith("CSS=")) {
			locatorType = locatorType.substring(4);
			by = by.cssSelector(locatorType);
		} else if (locatorType.startsWith("xpath=") || locatorType.startsWith("XPath=")
				|| locatorType.startsWith("XPATH=")) {
			locatorType = locatorType.substring(6);
			by = by.xpath(locatorType);
		} else if (locatorType.startsWith("name=") || locatorType.startsWith("Name=")
				|| locatorType.startsWith("NAME=")) {
			locatorType = locatorType.substring(5);
			by = by.name(locatorType);
		} else if (locatorType.startsWith("class=") || locatorType.startsWith("Class=")
				|| locatorType.startsWith("CLASS=")) {
			locatorType = locatorType.substring(6);
			by = by.className(locatorType);
		} else {
			throw new RuntimeException("Locator type is not supported");
		}
		return by;
	}
	
	// Hàm chuẩn hóa cho các locator có tham số động - locator dạng xpath
	private String getDynamicXpath (String locatorType, String...values) {
		if(locatorType.startsWith("xpath=") || locatorType.startsWith("XPath=")
				|| locatorType.startsWith("XPATH=")) {
			locatorType = String.format(locatorType, values);
		}
		return locatorType;
	}

	public void clickToElement(WebDriver driver, String locatorType) {
		getElement(driver, locatorType).click();
	}

	public void clickToElement(WebDriver driver, String locatorType, String... dynamicParams) {
		getElement(driver, getDynamicXpath(locatorType,dynamicParams)).click();
	}

	public void clickToElementByJS(WebDriver driver, String locatorType) {
		WebElement element = getElement(driver, locatorType);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", element);
	}
	
	public void clickToElementByJS(WebDriver driver, String locatorType, String... dynamicParams) {
		WebElement element = getElement(driver, getDynamicXpath(locatorType, dynamicParams));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", element);
	}

	public void sendkeyToElement(WebDriver driver, String locatorType, String textValue) {
		WebElement element = getElement(driver, locatorType);
		element.clear();
		element.sendKeys(textValue);
	}
	public void sendkeyToElement(WebDriver driver, String locatorType, String textValue, String... dynamicParams) {
		WebElement element = getElement(driver, getDynamicXpath(locatorType, dynamicParams));
		element.clear();
		element.sendKeys(textValue);
	}

	public String getElementText(WebDriver driver, String locatorType) {
		return getElement(driver, locatorType).getText();
	}
	
	public String getElementText(WebDriver driver, String locatorType, String... dynamicParams) {
		return getElement(driver, getDynamicXpath(locatorType, dynamicParams)).getText();
	}

	public void selectItemInDefaultDropDown(WebDriver driver, String locatorType, String textItem) {
		Select select = new Select(getElement(driver, locatorType));
		select.selectByVisibleText(textItem);
	}
	public void selectItemInDefaultDropDown(WebDriver driver, String locatorType, String textItem, String... dynamicParams) {
		Select select = new Select(getElement(driver, getDynamicXpath(locatorType, dynamicParams)));
		select.selectByVisibleText(textItem);
	}

	public boolean isDropdownMultiple(WebDriver driver, String locatorType, String... dynamicParams) {
		Select select = new Select(getElement(driver, getDynamicXpath(locatorType, dynamicParams)));
		return select.isMultiple();
	}

	public String getSelectedItemDefaultDropdown(WebDriver driver, String locatorType, String...dynamicParams) {
		Select select = new Select(getElement(driver, getDynamicXpath(locatorType, dynamicParams)));
		return select.getFirstSelectedOption().getText();
	}

	public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator,
			String expectedItem) {
		getElement(driver, parentLocator).click();
		sleepInSecond(2);

		WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		List<WebElement> allItems = explicitWait
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childItemLocator)));

		for (WebElement item : allItems) {
			if (item.getText().trim().equals(expectedItem)) {
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				//sleepInSecond(3);

				item.click();
				sleepInSecond(1);
				break;
			}
		}
	}

	public void sleepInSecond(long time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String getElementAtribute(WebDriver driver, String locatorType, String attributeName) {
		return getElement(driver, locatorType).getAttribute(attributeName);
	}

	public String getElementAtribute(WebDriver driver, String locatorType, String attributeName, String... dynamicParams) {
		return getElement(driver, getDynamicXpath(locatorType, dynamicParams)).getAttribute(attributeName);
	}
	public String getElementCssValue(WebDriver driver, String locatorType) {
		return getElement(driver, locatorType).getCssValue(locatorType);
	}
	public String getElementCssValue(WebDriver driver, String locatorType, String... dynamicParams) {
		return getElement(driver, getDynamicXpath(locatorType, dynamicParams)).getCssValue(locatorType);
	}

	public String getHexaColorFromRGBA(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}

	public int getElementSize(WebDriver driver, String locatorType) {
		return getElements(driver, locatorType).size();
	}
	public int getElementSize(WebDriver driver, String locatorType, String...dynamicParams) {
		return getElements(driver, getDynamicXpath(locatorType, dynamicParams)).size();
	}

	public void checkToCheckboxORRadio(WebDriver driver, String locatorType) {
		WebElement element = getElement(driver,locatorType);
		if (!element.isSelected()) {
			element.click();
		}
	}
	public void checkToCheckboxORRadio(WebDriver driver, String locatorType, String...dynamicParams) {
		WebElement element = getElement(driver, getDynamicXpath(locatorType, dynamicParams));
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void uncheckToCheckbox(WebDriver driver, String locatorType) {
		WebElement element = getElement(driver, locatorType);
		if (element.isSelected()) {
			element.click();
		}
	}
	public void uncheckToCheckbox(WebDriver driver, String locatorType, String...dynamicParams) {
		WebElement element = getElement(driver, getDynamicXpath(locatorType, dynamicParams));
		if (element.isSelected()) {
			element.click();
		}
	}

	public boolean isElementDisplayed(WebDriver driver, String locatorType) {
		return getElement(driver, locatorType).isDisplayed();
	}
	public boolean isElementDisplayed(WebDriver driver, String locatorType, String...dynamicParams) {
		return getElement(driver, getDynamicXpath(locatorType, dynamicParams)).isDisplayed();
	}
	
	// Element không hiển thị có trong DOM hoặc không có trong DOM
	public boolean isElementUndisplayed(WebDriver driver, String locatorType) {
		overrideGlobalTimeout(driver, GlobalConstants.SHORT_TIMEOUT);
		List<WebElement> listElements = getElements(driver, locatorType);
		overrideGlobalTimeout(driver, GlobalConstants.LONG_TIMEOUT);
		if(listElements.size()==0) {
			System.out.println("Element NOT IN DOM");
			return true;
		} else if (listElements.size()>0 && !listElements.get(0).isDisplayed()) {
			System.out.println("Element IN DOM and Invisible/Undisplayed");
			return true;
		} else {
			System.out.println("Element visible");
			return false;
		}
	}

	public boolean isElementUndisplayed(WebDriver driver, String locatorType, String...dynamicParams) {
		overrideGlobalTimeout(driver, GlobalConstants.SHORT_TIMEOUT);
		List<WebElement> listElements = getElements(driver, getDynamicXpath(locatorType, dynamicParams));
		overrideGlobalTimeout(driver, GlobalConstants.LONG_TIMEOUT);
		if(listElements.size()==0) {
			System.out.println("Element NOT IN DOM");
			return true;
		} else if (listElements.size()>0 && !listElements.get(0).isDisplayed()) {
			System.out.println("Element IN DOM and Invisible/Undisplayed");
			return true;
		} else {
			System.out.println("Element visible");
			return false;
		}
	}
	public boolean isElementIsEnable(WebDriver driver, String locatorType) {
		return getElement(driver, locatorType).isEnabled();
	}
	public boolean isElementIsEnable(WebDriver driver, String locatorType, String...dynamicParams) {
		return getElement(driver, getDynamicXpath(locatorType, dynamicParams)).isEnabled();
	}

	public boolean isElementIsSelected(WebDriver driver, String locatorType) {
		return getElement(driver, locatorType).isSelected();
	}
	public boolean isElementIsSelected(WebDriver driver, String locatorType, String...dynamicParams) {
		return getElement(driver, getDynamicXpath(locatorType, dynamicParams)).isSelected();
	}

	public void switchToFrameIframe(WebDriver driver, String locatorType) {
		driver.switchTo().frame(getElement(driver, locatorType));
	}
	public void switchToFrameIframe(WebDriver driver, String locatorType, String...dynamicParams) {
		driver.switchTo().frame(getElement(driver, getDynamicXpath(locatorType, dynamicParams)));
	}

	public void switchToDefaultContent(WebDriver driver, String locatorType) {
		driver.switchTo().defaultContent();
	}
	public void switchToDefaultContent(WebDriver driver, String locatorType, String...dynamicParams) {
		driver.switchTo().defaultContent();
	}

	public void hoverMouseToElement(WebDriver driver, String locatorType) {
		Actions action = new Actions(driver);
		action.moveToElement(getElement(driver, locatorType)).perform();
	}
	public void hoverMouseToElement(WebDriver driver, String locatorType, String...dynamicParams) {
		Actions action = new Actions(driver);
		action.moveToElement(getElement(driver, getDynamicXpath(locatorType, dynamicParams))).perform();
	}

	public void pressKeyToElement (WebDriver driver, String locatorType, Keys key) {
		Actions action = new Actions(driver);
		action.sendKeys(getElement(driver, locatorType),key).perform();
	}
	
	public void pressKeyToElement (WebDriver driver, String locatorType, Keys key, String...dynamicParams) {
		Actions action = new Actions(driver);
		action.sendKeys(getElement(driver, getDynamicXpath(locatorType, dynamicParams)),key).perform();
	}
	
	public void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(WebDriver driver, String url) {
		
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.location = '" + url + "'");
		sleepInSecond(2);
	}

	public void highlightElement(WebDriver driver, String locatorType, String...dynamicParams) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getElement(driver, getDynamicXpath(locatorType, dynamicParams));
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				"border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				originalStyle);
	}

	public void scrollToElement(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(driver, locator));
	}
	
	public void scrollToElement(WebDriver driver, String locator, String...dynamicParams) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(driver, (getDynamicXpath(locator, dynamicParams))));
	}

	public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(driver, locator));
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');",
				getElement(driver, locator));
	}

	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public String getElementValidationMessage(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(driver, locator));
	}

	public void uploadFiles(WebDriver driver, String...fileNames) {
		String filePath = GlobalConstants.UPLOAD_FILE_FOLDER;
		
		String fullFileName = "";
		for (String fileName : fileNames) {
			fullFileName = fullFileName + filePath + fileName + "\n";
		}
		fullFileName = fullFileName.trim();
		getElement(driver, BasePageUI.UPLOAD_FILE_TYPE).sendKeys(fullFileName);
	}
	
	public boolean isImageUpLoaded(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				getElement(driver, locator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}
	public boolean isImageUpLoaded(WebDriver driver, String locatorType, String...dynamicParams ) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				getElement(driver, (getDynamicXpath(locatorType, dynamicParams))));
		if (status) {
			return true;
		} else {
			return false;
		}
	}

	public void waitForElementVisible(WebDriver driver, String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));
		
	}
	public void waitForElementVisible(WebDriver driver, String locatorType, String...dynamicParams) {
		WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(getDynamicXpath(locatorType, dynamicParams))));

	}

	public void waitForAllElementVisible(WebDriver driver, String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locator)));
		
	}
	public void waitForAllElementVisible(WebDriver driver, String locatorType, String...dynamicParams) {
		WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(getDynamicXpath(locatorType, dynamicParams))));

	}

	public void waitForElementInvisible(WebDriver driver, String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
		
	}
	public void waitForElementInvisible(WebDriver driver, String locatorType, String...dynamicParams) {
		WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(getDynamicXpath(locatorType, dynamicParams))));

	}
	
	/*
	 * Wait for element undisplayed in DOM or Not in DOM and override implicit timeout
	 * */
	public void waitForElementUndisplayed(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstants.SHORT_TIMEOUT);
		overrideGlobalTimeout(driver, GlobalConstants.SHORT_TIMEOUT);
		
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locatorType)));
		overrideGlobalTimeout(driver, GlobalConstants.LONG_TIMEOUT);

	}

	public void waitForAllElementInvisible(WebDriver driver, String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getElements(driver, locator)));
		
	}
	public void waitForAllElementInvisible(WebDriver driver, String locatorType, String...dynamicParams) {
		WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getElements(driver, getDynamicXpath(locatorType, dynamicParams))));

	}

	public void waitForElementClickable(WebDriver driver, String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(locator)));
	}
	public void waitForElementClickable(WebDriver driver, String locatorType, String...dynamicParams) {
		WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(getDynamicXpath(locatorType, dynamicParams))));
	}
	
	

// Level 07_ Switch Page
	@Step ("Click to Customer Info Link")
	public UserCustomerInfoPageObject openCustomerInfoPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.CUSTOMER_INFO_LINK);
		clickToElement(driver, BasePageUI.CUSTOMER_INFO_LINK);
		return PageGeneratorManager.getUserCustomerInfoPage(driver);
	}

	public UserHomePageObject clickToLogoutLink(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.LOG_OUT_LINK_AT_USER_PAGE);
		clickToElement(driver, BasePageUI.LOG_OUT_LINK_AT_USER_PAGE);
		return PageGeneratorManager.getUserHomePage(driver);
	}

	public UserAddressPageObject openAddressPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.ADDRESS_LINK);
		clickToElement(driver, BasePageUI.ADDRESS_LINK);
		return PageGeneratorManager.getUserAddressPage(driver);
	}

	public UserOrderPageObject openOrderPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.ORDER_LINK);
		clickToElement(driver, BasePageUI.ORDER_LINK);
		return PageGeneratorManager.getUserOrderPage(driver);
	}

	public UserDownloadableProductPageObject openDownloadProductPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.DOWNLOADABLE_PRODUCT_LINK);
		clickToElement(driver, BasePageUI.DOWNLOADABLE_PRODUCT_LINK);
		return PageGeneratorManager.getUserDownloadableProductPage(driver);
	}

	public UserBackInStockSubscriptionsPageObject openBackInStockSubscriptionPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.BACK_IN_STOCK_SUBSCRIPTION_LINK);
		clickToElement(driver, BasePageUI.BACK_IN_STOCK_SUBSCRIPTION_LINK);
		return PageGeneratorManager.getUserBackInStockSubscriptionsPage(driver);
	}

	public UserRewardPointsPageObject openRewardPointPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.REWARD_POINT_LINK);
		clickToElement(driver, BasePageUI.REWARD_POINT_LINK);
		return PageGeneratorManager.getUserRewardPointsPage(driver);
	}

	public UserChangePasswordPageObject openChangePasswordPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.CHANGE_PASSWORD_LINK);
		clickToElement(driver, BasePageUI.CHANGE_PASSWORD_LINK);
		return PageGeneratorManager.getUserChangePasswordPage(driver);
	}

	public UserMyProductReviewsPageObject openMyProductReviewsPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.MY_PRODUCT_REVIEW_LINK);
		clickToElement(driver, BasePageUI.MY_PRODUCT_REVIEW_LINK);
		return PageGeneratorManager.getUserMyProductReviewsPage(driver);
	}

	@Step ("Click to My Account Link")
	public UserMyAccountPageObject openMyAccountPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.MY_ACCOUNT_LINK);
		clickToElementByJS(driver, BasePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getUserMyAccountPage(driver);

	}
	
	// Level 09 Dynamic Locator
	// switch page_cách 01
	public BasePage openPageAtMyAccountByName (WebDriver driver, String pageName) {
		waitForElementClickable(driver, BasePageUI.DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA, pageName);
		clickToElement(driver, BasePageUI.DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA, pageName);
		switch (pageName) {
		case "Customer info":
			return PageGeneratorManager.getUserCustomerInfoPage(driver);
		case "Addresses":
			return PageGeneratorManager.getUserAddressPage(driver);
		case "Orders":
			return PageGeneratorManager.getUserOrderPage(driver);
		case "Downloadable products":
			return PageGeneratorManager.getUserDownloadableProductPage(driver);
		case "Back in stock subscriptions":
			return PageGeneratorManager.getUserBackInStockSubscriptionsPage(driver);
		case "Reward points":
			return PageGeneratorManager.getUserRewardPointsPage(driver);
		case "Change password":
			return PageGeneratorManager.getUserChangePasswordPage(driver);
		case "My product reviews":
			return PageGeneratorManager.getUserMyProductReviewsPage(driver);
		default:
			throw new RuntimeException("Page Name is not valid");
		}
	}
	
	// switch page_cách 02
	public void openPageAtMyAccountByPageName(WebDriver driver, String pageName) {
		waitForElementClickable(driver, BasePageUI.DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA, pageName);
		clickToElement(driver, BasePageUI.DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA, pageName);
	}

	// Level 08 Switch Role
	public UserHomePageObject clickToLogoutLinkAtUserPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.LOG_OUT_LINK_AT_USER_PAGE);
		clickToElement(driver, BasePageUI.LOG_OUT_LINK_AT_USER_PAGE);
		return PageGeneratorManager.getUserHomePage(driver);
	}

	public AdminLoginPageObject clickToLogoutLinkAtAdminPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.LOG_OUT_LINK_AT_ADMIN_PAGE);
		clickToElementByJS(driver, BasePageUI.LOG_OUT_LINK_AT_ADMIN_PAGE);
		return PageGeneratorManager.getAdminLoginPage(driver);
	}
	
	public void overrideGlobalTimeout(WebDriver driver, long timeOut) {
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
	}
	
	/**
	 *  Enter to dynamic Textbox by ID
	 * @author TrangDTH
	 * @param driver
	 * @param idTextbox
	 * @param textValue
	 */
	public void inputToTextboxByIdTextbox(WebDriver driver, String idTextbox, String textValue) {
		waitForElementVisible(driver, BasePageUI.DYNAMIC_TEXTBOX_BY_ID, idTextbox);
		sendkeyToElement(driver, BasePageUI.DYNAMIC_TEXTBOX_BY_ID, textValue, idTextbox);
	}
	
	/**
	 * Click to Button by Text
	 * @param driver
	 * @param textButton
	 * @author TrangDTH
	 */
	public void clickToButtonByText(WebDriver driver, String textButton) {
		waitForElementClickable(driver, BasePageUI.DYNAMIC_BUTTON_BY_TEXT, textButton);
		clickToElement(driver, BasePageUI.DYNAMIC_BUTTON_BY_TEXT, textButton);
	}
	/** 
	 * Select item in dropdown by Name Attribute
	 * @param driver
	 * @param itemvalue
	 * @param dropdownAttributeName
	 * @author TrangDTH
	 */
	public void selectDropDownByTitle(WebDriver driver, String itemvalue, String dropdownAttributeName) {
		waitForElementVisible(driver, BasePageUI.DYNAMIC_DROPDOWN_LIST_BY_TITLE, dropdownAttributeName);
		selectItemInDefaultDropDown(driver, BasePageUI.DYNAMIC_DROPDOWN_LIST_BY_TITLE, itemvalue, dropdownAttributeName);

	}

	public void clickToMenuLinkTextByName(WebDriver driver, String menuChild) {
		waitForElementClickable(driver, AdminBasePageUI.DYNAMIC_MENU_LINKTEXT_BY_NAME, menuChild);
		clickToElementByJS(driver,AdminBasePageUI.DYNAMIC_MENU_LINKTEXT_BY_NAME, menuChild);
	}
	public void clickToSubMenuLinkTextByName(WebDriver driver, String parentMenuName, String subMenuName) {
		waitForElementClickable(driver, AdminBasePageUI.DYNAMIC_CATEGORY_LINKTEXT_BY_NAME, parentMenuName, subMenuName);
		clickToElementByJS(driver,AdminBasePageUI.DYNAMIC_CATEGORY_LINKTEXT_BY_NAME, parentMenuName, subMenuName);
		sleepInSecond(3);
	}
	
	// Nopcommerce User - Search textbox
	public void inputKeywordToSearchTextbox(WebDriver driver, String keyword) {
		waitForElementVisible(driver, AdminBasePageUI.SEARCH_TEXTBOX);
		sendkeyToElement(driver, AdminBasePageUI.SEARCH_TEXTBOX, keyword);
	}

	public UserSearchKeywordPageObject clickToSearchButton(WebDriver driver) {
		waitForElementClickable(driver, AdminBasePageUI.SEARCH_BUTTON);
		clickToElement(driver, AdminBasePageUI.SEARCH_BUTTON);
		return PageGeneratorManager.getUserSearchKeywordPage(driver);
	}
	
	// Nopcommerce User - Click to menu on footer page
	public UserRecentlyViewedProductsPageObject clickToRecentlyViewedProducts(WebDriver driver, String textValue) {
		waitForElementClickable(driver, AdminBasePageUI.RECENTLY_VIEWED_PRODUCTS,textValue);
		clickToElement(driver, AdminBasePageUI.RECENTLY_VIEWED_PRODUCTS, textValue);
		sleepInSecond(2);
		return PageGeneratorManager.getUserRecentlyViewedProductsPage(driver);
	}
	
	
}
