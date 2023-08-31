package commons;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.aeonbits.owner.Config;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

import com.github.javafaker.Options;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	// Chứa các hàm dùng chung cho testcase
	private WebDriver driver;
	// Init log
	protected final Log log;

	
	@BeforeSuite
	public void initBeforeSuit() {
		deleteAllOldFileAllureReport();
	}
	protected BaseTest() {
		log = LogFactory.getLog(getClass());
	}
	
	// Trả về driver của BaseTest để các hàm sử dụng
	public WebDriver getDriverInstance() {
		return this.driver;
	}
	
	protected WebDriver getBrowserDriver(String browserName) {
		browserName = browserName.toUpperCase();
		log.info("Run on " + browserName);
		switch (browserName) {
		case "FIREFOX":
			driver = WebDriverManager.firefoxdriver().create();
			break;
		case "CHROME":
			driver = WebDriverManager.chromedriver().create();
			break;
		case "EDGE":
			driver = WebDriverManager.edgedriver().create();
			break;
		case "COCCOC":
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\Program Files\\CocCoc\\Browser\\Application\\browser.exe");
			driver = WebDriverManager.chromedriver().driverVersion("111.0.5563.64").capabilities(options).create();
			break;
		case "OPERA":
			driver = WebDriverManager.operadriver().create();
			break;
		default:
			throw new RuntimeException("Please check your browser name!");

		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(GlobalConstants.USER_PAGE_URL);

		return driver;
	}

	protected WebDriver getBrowserDriver(String browserName, String appUrl) {
		browserName = browserName.toUpperCase();
		log.info("Run on " + browserName);
		switch (browserName) {
		case "FIREFOX":
			driver = WebDriverManager.firefoxdriver().create();
			break;
		case "CHROME":
			driver = WebDriverManager.chromedriver().create();
			break;
		case "EDGE":
			driver = WebDriverManager.edgedriver().create();
			break;
		case "IE": 
			driver = WebDriverManager.iedriver().arch32().create();
			break;
		case "COCCOC":
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\Program Files\\CocCoc\\Browser\\Application\\browser.exe");
			driver = WebDriverManager.chromedriver().driverVersion("111.0.5563.64").capabilities(options).create();
			break;
		case "OPERA":
			driver = WebDriverManager.operadriver().create();
			break;
		default:
			throw new RuntimeException("Please check your browser name!");

		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(appUrl);

		return driver;
	}
	
	protected WebDriver getBrowserSeleniumGrid(String browserName, String appUrl,  String osName, String ipAddress, String portNumber) {
		DesiredCapabilities capability = null;
		Platform platform = null;

		if (osName.contains("windows")) {
			platform = Platform.WINDOWS;
		} else {
			platform = Platform.MAC;
		}

		switch (browserName) {
			case "firefox" :
				FirefoxOptions fOptions = new FirefoxOptions();
				capability = DesiredCapabilities.firefox();
				capability.setBrowserName("firefox");
				capability.setPlatform(platform);
				fOptions.merge(capability);
				
				break;
			case "chrome" :
				capability = DesiredCapabilities.chrome();
				capability.setBrowserName("chrome");
				capability.setPlatform(platform);

				ChromeOptions cOptions = new ChromeOptions();
				cOptions.merge(capability);
				break;
			default :
				throw new RuntimeException("Browser is not valid!");
		}

		try {
			
			driver = new RemoteWebDriver(new URL(String.format("http://%s:%s/wd/hub", ipAddress, portNumber)), capability);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(appUrl);

		return driver;

	}

	protected boolean verifyTrue(boolean condition) {
		boolean pass = true;

		try {
			Assert.assertTrue(condition);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			
			pass = false;
			log.info(" -------------------------- FAILED -------------------------- ");
			// Add lỗi vào ReportNG
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		boolean pass = true;

		try {

			Assert.assertFalse(condition);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			
			pass = false;
			log.info(" -------------------------- FAILED -------------------------- ");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			pass = false;
			log.info(" -------------------------- FAILED -------------------------- ");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	public void deleteAllOldFileAllureReport() {
		try {
			String pathFolderDownload = GlobalConstants.PROJECT_PATH + "/allure-json";
			File file = new File (pathFolderDownload);
			File[] listOfFiles = file.listFiles();
			for (int i = 0; i < listOfFiles.length; i++) {
				if(listOfFiles[i].isFile()) {
					new File(listOfFiles[i].toString()).delete();
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	private String getEnvironmentUrl(String serverName) {
		String envUrl = null;
		EnvironmentList environment = EnvironmentList.valueOf(serverName.toUpperCase());
		if (environment == EnvironmentList.DEV) {
			envUrl = "https://demo.nopcommerce.com";
		} else if (environment == EnvironmentList.TESTING) {
			envUrl = "https://admin-demo.nopcommerce.com";
		} else if (environment == EnvironmentList.STAGING) {
			envUrl = "https://staging.orangehrmlive.com";
		} else if (environment == EnvironmentList.PRODUCTION) {
			envUrl = "https://production.orangehrmlive.com";
		}
		return envUrl;
	}

	public int fakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}
	
	public String[] getSubStringBeforeCharacter(String text) {
		String[] itext = text.split("/");
		for (int i = 0; i < itext.length; i++) {
			System.out.println(itext[i]);
			
		}
		return itext;
	}
	
	protected void closeBrowserDriver() {
		String cmd = null;
		try {
			String osName = System.getProperty("os.name").toLowerCase();
			log.info("OS name = " + osName);

			String driverInstanceName = driver.toString().toLowerCase();
			log.info("Driver instance name = " + driverInstanceName);

			String browserDriverName = null;

			if (driverInstanceName.contains("chrome")) {
				browserDriverName = "chromedriver";
			} else if (driverInstanceName.contains("internetexplorer")) {
				browserDriverName = "IEDriverServer";
			} else if (driverInstanceName.contains("firefox")) {
				browserDriverName = "geckodriver";
			} else if (driverInstanceName.contains("edge")) {
				browserDriverName = "msedgedriver";
			} else if (driverInstanceName.contains("opera")) {
				browserDriverName = "operadriver";
			} else {
				browserDriverName = "safaridriver";
			}

			if (osName.contains("window")) {
				cmd = "taskkill /F /FI \"IMAGENAME eq " + browserDriverName + "*\"";
			} else {
				cmd = "pkill " + browserDriverName;
			}

			if (driver != null) {
				driver.manage().deleteAllCookies();
				driver.quit();
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		} finally {
			try {
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	

}
