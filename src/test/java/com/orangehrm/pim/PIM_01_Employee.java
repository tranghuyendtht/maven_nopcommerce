package com.orangehrm.pim;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import reportConfig.ExtentTestManager;

public class PIM_01_Employee extends BaseTest{
	
	private WebDriver driver;
	private String browserName;
	
	@Parameters({"url", "browser"})
	@BeforeClass
	public void beforeClass(String url, String browserName) {
		
		this.browserName = browserName;
		driver = getBrowserDriver(browserName, url);
	}
	
	@Test
	public void Employee_01_PersonalDetail(Method method) {
		ExtentTestManager.startTest(method.getName() + " - Run on " + browserName.toUpperCase(), "Employee_01_PersonalDetail");
		ExtentTestManager.getTest().log(Status.INFO, "Step 1");
	}
	
	@Test
	public void Employee_02_ContactDetails(Method method) {
		ExtentTestManager.startTest(method.getName() + " - Run on " + browserName.toUpperCase(), "");
		ExtentTestManager.getTest().log(Status.INFO, "Step 1");
		
	}
	
	@Test
	public void Employee_03_EmergencyContacts(Method method) {
		ExtentTestManager.startTest(method.getName() + " - Run on " + browserName.toUpperCase(), "");
		ExtentTestManager.getTest().log(Status.INFO, "Step 1");
		
	}
	
	@Test
	public void Employee_04_Dependents(Method method) {
		ExtentTestManager.startTest(method.getName() + " - Run on " + browserName.toUpperCase(), "");
		ExtentTestManager.getTest().log(Status.INFO, "Step 1");
		
	}
	@Test
	public void Employee_05_Immigration(Method method) {
		ExtentTestManager.startTest(method.getName() + " - Run on " + browserName.toUpperCase(), "");
		ExtentTestManager.getTest().log(Status.INFO, "Step 1");
		
	}
	@Test
	public void Employee_06_Job(Method method) {
		ExtentTestManager.startTest(method.getName() + " - Run on " + browserName.toUpperCase(), "");
		ExtentTestManager.getTest().log(Status.INFO, "Step 1");
		
	}
	@Test
	public void Employee_07_Salary(Method method) {
		ExtentTestManager.startTest(method.getName() + " - Run on " + browserName.toUpperCase(), "");
		ExtentTestManager.getTest().log(Status.INFO, "Step 1");
		
	}
	
	@Test
	public void Employee_08_Report(Method method) {
		ExtentTestManager.startTest(method.getName() + " - Run on " + browserName.toUpperCase(), "");
		ExtentTestManager.getTest().log(Status.INFO, "Step 1");
		
	}
	
	@Test
	public void Employee_09_Qualifications(Method method) {
		ExtentTestManager.startTest(method.getName() + " - Run on " + browserName.toUpperCase(), "");
		ExtentTestManager.getTest().log(Status.INFO, "Step 1");
		
	}
	
	@Test
	public void Employee_10_MemberShip(Method method) {
		ExtentTestManager.startTest(method.getName() + " - Run on " + browserName.toUpperCase(), "");
		ExtentTestManager.getTest().log(Status.INFO, "Step 1");
		
	}
	
	
	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}

}
