package commons;

import java.io.File;

public class GlobalConstants {
	public static final String USER_PAGE_URL = "https://demo.nopcommerce.com/";
	public static final String ADMIN_PAGE_URL = "https://admin-demo.nopcommerce.com/";
	public static final String USER_TESTING_URL = "";
	public static final String ADMIN_TESTING_URL = "";
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String OS_NAME = System.getProperty("os.name");
	public static final String UPLOAD_FILE_FOLDER = PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
	public static final String DOWNLOAD_FILE_FOLDER = PROJECT_PATH + File.separator + "downloadFiles";
	public static final String BROWSER_LOGS_FOLDER = PROJECT_PATH + File.separator + "browserLogs";
	public static final String REPORT_HTML = PROJECT_PATH + File.separator + "reportHTML";
	public static final String AUTO_IT_SCRIPT = PROJECT_PATH + File.separator + "autoITScript";
	public static final String REPORTING_SCREENSHORT = PROJECT_PATH + File.separator + "ReportNGScreenShots" + File.separator;
	public static final String JAVA_VERSION = System.getProperty("java.version");
	public static final String DB_DEV_URL = "32.18.152.185:9860";
	public static final String DB_DEV_USER = "automationFC";
	public static final String DB_DEV_PASSWORD = "PassWord@$12";
	public static final String DB_TEST_URL = "32.18.152.118:9860";
	public static final String DB_TEST_USER = "automationFC";
	public static final String DB_TEST_PASSWORD = "PassWord@$12";
	public static final long SHORT_TIMEOUT = 5;
	public static final long LONG_TIMEOUT = 20;
	public static final long RETRY_TEST_FAIl = 3;
	
	
	
	
	
	
	
}
