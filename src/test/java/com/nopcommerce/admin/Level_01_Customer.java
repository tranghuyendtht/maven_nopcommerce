package com.nopcommerce.admin;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopcommerce.Admin.AdminAddNewCustomerPageObject;
import pageObjects.nopcommerce.Admin.AdminDashboardPageObject;
import pageObjects.nopcommerce.Admin.AdminEditCustomerPageObject;
import pageObjects.nopcommerce.Admin.AdminLoginPageObject;
import pageObjects.nopcommerce.Admin.AdminManageCustomerAddressPageObject;
import pageObjects.nopcommerce.Admin.AdminSearchCustomerPageObject;
import pageObjects.nopcommerce.Admin.PageGeneratorManager;

public class Level_01_Customer extends BaseTest {

	private WebDriver driver;
	AdminLoginPageObject adminLoginPage;
	AdminDashboardPageObject adminDashboardPage;
	AdminSearchCustomerPageObject adminSearchCustomerPage;
	AdminAddNewCustomerPageObject adminAddNewCustomerPage;
	AdminEditCustomerPageObject adminEditCustomerPage;
	AdminManageCustomerAddressPageObject adminManageCustomerAddressPage;

	String username, password;
	String email, customerPassword, firstName, lastName, gender, dateOfBirth, companyName, customerRole, adminComment;
	String editEmail, editOther, newDateOfBirth;
	String addFirstName, addLastName, addEmail, addCompany, addCountry, addState, addCounty, addCity, addAddress1,
			addAddress2, addZipPostalCode, addPhoneNumber, addFaxNumber;
	String newAddCountry, newAddState, newAddZipPostalCode, newAddPhoneNumber, newAddFaxNumber;
	int fakeNumber = fakeNumber();

	@Parameters({ "browser", "url" })
	@BeforeTest
	public void beforeTest(String browserName, String appUrl) {

		log.info("Pre-Condition - Step 01: Navigate to Login Admin Page");
		driver = getBrowserDriver(browserName, appUrl);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);

		username = "admin@yourstore.com";
		password = "admin";
		email = "automationFC" + fakeNumber + "@mail.com";
		customerPassword = "123456";
		firstName = "automation";
		lastName = "FC";
		dateOfBirth = "7/19/2001";
		companyName = "automationFC" + fakeNumber;
		customerRole = "Guests";
		adminComment = "automationFC" + fakeNumber;
		editEmail = "edit_";
		editOther = "Edit_";
		newDateOfBirth = "7/19/2003";
		addFirstName = "add_" + firstName;
		addLastName = "add_" + lastName;
		addEmail = "add_" + email;
		addCompany = "add_" + companyName;
		addCountry = "Viet Nam";
		addState = "Other";
		addCounty = "add_" + "County";
		addCity = "Hanoi";
		addAddress1 = "Hoan Kiem";
		addAddress2 = "Hai Ba Trung";
		addZipPostalCode = "650000";
		addPhoneNumber = "3512541245";
		addFaxNumber = "+84125124511";
		newAddCountry = "United States"; 
		newAddState = "Alabama";
		newAddZipPostalCode = "630000";
		newAddPhoneNumber = "8635842121";
		newAddFaxNumber = "+1234567892";

		log.info("Pre-Condition - Step 02: Login Account Admin");
		adminDashboardPage = adminLoginPage.loginAsAdmin(username, password);

		log.info("Pre-Condition - Step 03: Go to Customer Menu");
		adminDashboardPage.clickToMenuLinkTextByName(driver, "Customer");

		log.info("Pre-Condition - Step 04: Go to Sub Menu - Product");
		adminDashboardPage.clickToSubMenuLinkTextByName(driver, "Customers", "Customers");
		adminSearchCustomerPage = PageGeneratorManager.getAdminSearchCustomerPage(driver);

	}

	@Test(alwaysRun = true)
	public void Customer_01_Create_New_Customer() {
		log.info("Create_New_Customer - Step 01: Click to Add new Button");
		adminAddNewCustomerPage = adminSearchCustomerPage.clickToAddNewButton("Customers");

		log.info("Create_New_Customer - Step 02: Enter To Email Textbox with value: " + email);
		adminAddNewCustomerPage.setInfoToTextboxByID("Email", email);

		log.info("Create_New_Customer - Step 03: Enter To Password Textbox with value: " + customerPassword);
		adminAddNewCustomerPage.setInfoToTextboxByID("Password", customerPassword);

		log.info("Create_New_Customer - Step 04: Enter To FirstName Textbox with value: " + firstName);
		adminAddNewCustomerPage.setInfoToTextboxByID("FirstName", firstName);

		log.info("Create_New_Customer - Step 05: Enter To LastName Textbox with value: " + lastName);
		adminAddNewCustomerPage.setInfoToTextboxByID("LastName", lastName);

		log.info("Create_New_Customer - Step 06: Enter To Gender with value: " + gender);
		adminAddNewCustomerPage.setValueOnCheckboxOrRadioButtonByID("Gender_Male");

		log.info("Create_New_Customer - Step 07: Enter To Date of Birth with value: " + dateOfBirth);
		adminAddNewCustomerPage.chooseDateOfBirth(dateOfBirth);

		log.info("Create_New_Customer - Step 08: Enter To Company Name Textbox with value: " + companyName);
		adminAddNewCustomerPage.setInfoToTextboxByID("Company", companyName);

		log.info("Create_New_Customer - Step 09: Enter To Customer Role Textbox with value: " + customerRole);
		adminAddNewCustomerPage.chooseCustomerRole(customerRole);

		log.info("Create_New_Customer - Step 10: Enter To Admin Comment with value: " + adminComment);
		adminAddNewCustomerPage.setInfoToTextAreaByID("AdminComment", adminComment);

		log.info("Create_New_Customer - Step 11: Click to Save And Continue Edit");
		adminAddNewCustomerPage.clickToButtonSaveAndContinueEdit();

		log.info("Create_New_Customer - Step 12: Verify success message");
		verifyTrue(adminAddNewCustomerPage
				.isVerifySuccessMessageDisplayed("The new customer has been added successfully."));

		log.info("Create_New_Customer - Step 13: Verify Email Info");
		verifyTrue(adminAddNewCustomerPage.getInfoTextboxByID("Email").contains(email));

		log.info("Create_New_Customer - Step 14: Verify firstName Info");
		verifyTrue(adminAddNewCustomerPage.getInfoTextboxByID("FirstName").contains(firstName));

		log.info("Create_New_Customer - Step 15: Verify lastName Info");
		verifyTrue(adminAddNewCustomerPage.getInfoTextboxByID("LastName").contains(lastName));

		log.info("Create_New_Customer - Step 16: Verify Gender Info");
		verifyTrue(adminAddNewCustomerPage.isGenderChecked("Gender_Male"));

		log.info("Create_New_Customer - Step 17: Verify Date of Birth Info");
		verifyTrue(adminAddNewCustomerPage.getInfoDateOfBirth().contains(dateOfBirth));

		log.info("Create_New_Customer - Step 18: Verify Company Name Info");
		verifyTrue(adminAddNewCustomerPage.getInfoTextboxByID("Company").contains(companyName));

		log.info("Create_New_Customer - Step 19: Verify Customer Role Info");
		verifyTrue(adminAddNewCustomerPage.getInfoCustomerRole().contains(customerRole));

		log.info("Create_New_Customer - Step 20: Verify AdminComment Info");
		verifyTrue(adminAddNewCustomerPage.getInfoToTextAreaByID("AdminComment").contains(adminComment));

		log.info("Create_New_Customer - Step 22: Click to Back to Customer List LinkText");
		adminSearchCustomerPage = adminAddNewCustomerPage.clickBackToCustomerListButton();

		log.info("Create_New_Customer - Step 23: Search customer with company name value: " + companyName);
		adminSearchCustomerPage.setToTextboxSearchByID("SearchCompany", companyName);

		log.info("Create_New_Customer - Step 24: Search customer with customer role value: " + companyName);
		adminSearchCustomerPage.chooseCustomerRole(customerRole);

		log.info("Create_New_Customer - Step 25: Click to Search Button");
		adminSearchCustomerPage.clickToSearchButton();

		log.info("Create_New_Customer - Step 26: Verify Info");
		adminSearchCustomerPage.isExpectedResultContainedInActualResult("Company name", companyName);

	}

	//@Test
	public void Customer_02_Search_Customer_With_Email() {
		log.info("Search_Customer_With_Email - Step 01: Refresh page");
		adminSearchCustomerPage.refreshPage(driver);

		log.info("Search_Customer_With_Email - Step 02: Search customer with email value: " + email);
		adminSearchCustomerPage.setToTextboxSearchByID("SearchEmail", email);

		log.info("Search_Customer_With_Email - Step 03: Clear data on customer role field");
		adminSearchCustomerPage.clearValueOnCustomerRoleField();

		log.info("Search_Customer_With_Email - Step 04: Click to Search Button");
		adminSearchCustomerPage.clickToSearchButton();

		log.info("Search_Customer_With_Email - Step 05: Verify Info");
		verifyTrue(adminSearchCustomerPage.isExpectedResultContainedInActualResult("Email", email));

	}

	//@Test
	public void Customer_03_Search_Customer_With_FirstName_LastName() {
		log.info("Search_Customer_With_FirstName_LastName - Step 01: Refresh page");
		adminSearchCustomerPage.refreshPage(driver);

		log.info("Search_Customer_With_FirstName_LastName - Step 02: Search customer with firstName value: "
				+ firstName);
		adminSearchCustomerPage.setToTextboxSearchByID("SearchFirstName", firstName);

		log.info("Search_Customer_With_FirstName_LastName - Step 03: Search customer with lastName value: " + lastName);
		adminSearchCustomerPage.setToTextboxSearchByID("SearchLastName", lastName);

		log.info("Search_Customer_With_FirstName_LastName - Step 04: Clear data on customer role field");
		adminSearchCustomerPage.clearValueOnCustomerRoleField();

		log.info("Search_Customer_With_FirstName_LastName - Step 05: Click to Search Button");
		adminSearchCustomerPage.clickToSearchButton();

		log.info("Search_Customer_With_FirstName_LastName - Step 06: Verify Info");
		verifyTrue(adminSearchCustomerPage.isExpectedResultContainedInActualResult("Name", firstName));
		verifyTrue(adminSearchCustomerPage.isExpectedResultContainedInActualResult("Name", lastName));
	}

	//@Test
	public void Customer_04_Search_Customer_With_Company() {
		log.info("Search_Customer_With_Company - Step 01: Refresh page");
		adminSearchCustomerPage.refreshPage(driver);

		log.info("Search_Customer_With_Company - Step 02: Search customer with company Name value: " + companyName);
		adminSearchCustomerPage.setToTextboxSearchByID("SearchCompany", companyName);

		log.info("Search_Customer_With_Company - Step 03: Clear data on customer role field");
		adminSearchCustomerPage.clearValueOnCustomerRoleField();

		log.info("Search_Customer_With_Company - Step 04: Click to Search Button");
		adminSearchCustomerPage.clickToSearchButton();

		log.info("Search_Customer_With_Company - Step 05: Verify Info");
		verifyTrue(adminSearchCustomerPage.isExpectedResultContainedInActualResult("Company name", companyName));
	}

	//@Test
	public void Customer_04_Search_Customer_With_Full_Data() {
		log.info("Search_Customer_With_Full_Data - Step 01: Refresh page");
		adminSearchCustomerPage.refreshPage(driver);

		log.info("Search_Customer_With_Full_Data - Step 02: Search customer with email value: " + email);
		adminSearchCustomerPage.setToTextboxSearchByID("SearchEmail", email);

		log.info("Search_Customer_With_Full_Data - Step 03: Search customer with firstName value: " + firstName);
		adminSearchCustomerPage.setToTextboxSearchByID("SearchFirstName", firstName);

		log.info("Search_Customer_With_Full_Data - Step 04: Search customer with lastName value: " + lastName);
		adminSearchCustomerPage.setToTextboxSearchByID("SearchLastName", lastName);

		log.info("Search_Customer_With_Full_Data - Step 05: Search customer with date of birth value: " + dateOfBirth);
		adminSearchCustomerPage.selectValueDateOfBirthByID("SearchMonthOfBirth",
				getSubStringBeforeCharacter(dateOfBirth)[0]);
		adminSearchCustomerPage.selectValueDateOfBirthByID("SearchDayOfBirth",
				getSubStringBeforeCharacter(dateOfBirth)[1]);

		log.info("Search_Customer_With_Full_Data - Step 06: Search customer with company Name value: " + companyName);
		adminSearchCustomerPage.setToTextboxSearchByID("SearchCompany", companyName);

		log.info("Search_Customer_With_Full_Data - Step 07: Search customer with customer role value: " + customerRole);
		adminSearchCustomerPage.chooseCustomerRole(customerRole);

		log.info("Search_Customer_With_Full_Data - Step 08: Click to Search Button");
		adminSearchCustomerPage.clickToSearchButton();

		log.info("Search_Customer_With_Full_Data - Step 09: Verify Info");
		verifyTrue(adminSearchCustomerPage.isExpectedResultContainedInActualResult("Email", email));
		verifyTrue(adminSearchCustomerPage.isExpectedResultContainedInActualResult("Name", firstName));
		verifyTrue(adminSearchCustomerPage.isExpectedResultContainedInActualResult("Name", lastName));
		verifyTrue(adminSearchCustomerPage.isExpectedResultContainedInActualResult("Customer roles", customerRole));
		verifyTrue(adminSearchCustomerPage.isExpectedResultContainedInActualResult("Company name", companyName));
	}

	@Test
	public void Customer_05_Edit_Customer() {

		log.info("Edit_Customer - Step 01: Refresh page");
		adminSearchCustomerPage.refreshPage(driver);

		log.info("Edit_Customer - Step 02: Set value to search fields");
		adminSearchCustomerPage.setToTextboxSearchByID("SearchEmail", email);
		adminSearchCustomerPage.setToTextboxSearchByID("SearchFirstName", firstName);
		adminSearchCustomerPage.setToTextboxSearchByID("SearchLastName", lastName);
		adminSearchCustomerPage.selectValueDateOfBirthByID("SearchMonthOfBirth",
				getSubStringBeforeCharacter(dateOfBirth)[0]);
		adminSearchCustomerPage.selectValueDateOfBirthByID("SearchDayOfBirth",
				getSubStringBeforeCharacter(dateOfBirth)[1]);
		adminSearchCustomerPage.setToTextboxSearchByID("SearchCompany", companyName);
		adminSearchCustomerPage.chooseCustomerRole(customerRole);

		log.info("Edit_Customer - Step 03: Click to search button");
		adminSearchCustomerPage.clickToSearchButton();

		log.info("Edit_Customer - Step 04: Click to edit button");
		adminEditCustomerPage = adminSearchCustomerPage.clickToEditButton();

		log.info("Edit_Customer - Step 05: Edit customer with data - Email value: " + editEmail + email);
		adminEditCustomerPage.setInfoToTextboxByID("Email", editEmail + email);

		log.info("Edit_Customer - Step 06: Edit customer with data - Firstname value: ");
		adminEditCustomerPage.setInfoToTextboxByID("FirstName", editOther + firstName);

		log.info("Edit_Customer - Step 07: Edit customer with data - Lastname value: ");
		adminEditCustomerPage.setInfoToTextboxByID("LastName", editOther + lastName);

		log.info("Edit_Customer - Step 08: Edit customer with data - Date of birth value: ");
		adminEditCustomerPage.chooseDateOfBirth(newDateOfBirth);

		log.info("Edit_Customer - Step 09: Edit customer with data - Company name value: ");
		adminEditCustomerPage.setInfoToTextboxByID("Company", editOther + companyName);

		log.info("Edit_Customer - Step 10: Edit customer with data - Admin comment value: ");
		adminEditCustomerPage.setInfoToTextAreaByID("AdminComment", editOther + adminComment);

		log.info("Edit_Customer - Step 11: Click to Save button");
		adminSearchCustomerPage = adminEditCustomerPage.clickToSaveButton("Save");

		log.info("Edit_Customer - Step 12: Verify message displayed");
		verifyTrue(adminSearchCustomerPage.isVerifySuccessMessageDisplayed("The customer has been updated successfully."));

		log.info("Edit_Customer - Step 13: Set new value to search fields");
		adminSearchCustomerPage.setToTextboxSearchByID("SearchEmail", editEmail + email);
		adminSearchCustomerPage.setToTextboxSearchByID("SearchFirstName", editOther + firstName);
		adminSearchCustomerPage.setToTextboxSearchByID("SearchLastName", editOther + lastName);
		adminSearchCustomerPage.selectValueDateOfBirthByID("SearchMonthOfBirth",
				getSubStringBeforeCharacter(newDateOfBirth)[0]);
		adminSearchCustomerPage.selectValueDateOfBirthByID("SearchDayOfBirth",
				getSubStringBeforeCharacter(newDateOfBirth)[1]);
		adminSearchCustomerPage.setToTextboxSearchByID("SearchCompany", editOther + companyName);
		adminSearchCustomerPage.chooseCustomerRole(customerRole);

		log.info("Edit_Customer - Step 14: Click to search button");
		adminSearchCustomerPage.clickToSearchButton();

		log.info("Edit_Customer - Step 15: Verify new updated data");
		verifyTrue(adminSearchCustomerPage.isExpectedResultContainedInActualResult("Email", editEmail + email));
		verifyTrue(adminSearchCustomerPage.isExpectedResultContainedInActualResult("Name", editOther + firstName));
		verifyTrue(adminSearchCustomerPage.isExpectedResultContainedInActualResult("Name", editOther + lastName));
		verifyTrue(adminSearchCustomerPage.isExpectedResultContainedInActualResult("Customer roles", customerRole));
		verifyTrue(adminSearchCustomerPage.isExpectedResultContainedInActualResult("Company name",
				editOther + companyName));

	}

	@Test
	public void Customer_06_Add_New_Address() {

		log.info("Add_New_Address - Step 01: Refresh page");
		adminSearchCustomerPage.refreshPage(driver);

		log.info("Add_New_Address - Step 02: Set value to search fields");
		adminSearchCustomerPage.setToTextboxSearchByID("SearchEmail", editEmail + email);
		adminSearchCustomerPage.setToTextboxSearchByID("SearchFirstName", editOther + firstName);
		adminSearchCustomerPage.setToTextboxSearchByID("SearchLastName", editOther + lastName);
		adminSearchCustomerPage.selectValueDateOfBirthByID("SearchMonthOfBirth",
				getSubStringBeforeCharacter(newDateOfBirth)[0]);
		adminSearchCustomerPage.selectValueDateOfBirthByID("SearchDayOfBirth",
				getSubStringBeforeCharacter(newDateOfBirth)[1]);
		adminSearchCustomerPage.setToTextboxSearchByID("SearchCompany", editOther + companyName);
		adminSearchCustomerPage.chooseCustomerRole(customerRole);

		log.info("Add_New_Address - Step 03: Click to search button");
		adminSearchCustomerPage.clickToSearchButton();

		log.info("Add_New_Address - Step 04: Click to edit button");
		adminEditCustomerPage = adminSearchCustomerPage.clickToEditButton();

		log.info("Add_New_Address - Step 05: Click to address cart title");
		//adminEditCustomerPage.clickToCardTitleByText("Addresses");
		
		log.info("Add_New_Address - Step 06: Click to add new address button");
		adminEditCustomerPage.clickToAddAddressButton("Addresses", "Add new address");
		adminManageCustomerAddressPage = PageGeneratorManager.getAdminManageCustomerAddressPage(driver);

		log.info("Add_New_Address - Step 07: Set data on fields - Firstname textbox with value: " + addFirstName);
		adminManageCustomerAddressPage.setValueOnTextboxById("Address_FirstName", addFirstName);
		
		log.info("Add_New_Address - Step 08: Set data on fields - Lastname textbox with value: " + addLastName);
		adminManageCustomerAddressPage.setValueOnTextboxById("Address_LastName", addLastName);
		
		log.info("Add_New_Address - Step 09: Set data on fields - Email textbox with value: " + addEmail);
		adminManageCustomerAddressPage.setValueOnTextboxById("Address_Email", addEmail);
		
		log.info("Add_New_Address - Step 10: Set data on fields - Company textbox with value: " + addCompany);
		adminManageCustomerAddressPage.setValueOnTextboxById("Address_Company", addCompany);
		
		log.info("Add_New_Address - Step 11: Set data on fields - Country dropdownlist with value: " + addCountry);
		adminManageCustomerAddressPage.setValueOnDropDownListById("Address_CountryId", addCountry);
		
		log.info("Add_New_Address - Step 12: Set data on fields - State/Province dropdownlist with value: " + addState);
		adminManageCustomerAddressPage.setValueOnDropDownListById("Address_StateProvinceId", addState);
		
		log.info("Add_New_Address - Step 13: Set data on fields - County/Region textbox with value: " + addCounty);
		adminManageCustomerAddressPage.setValueOnTextboxById("Address_County", addCounty);
		
		log.info("Add_New_Address - Step 14: Set data on fields - City textbox with value: " + addCity);
		adminManageCustomerAddressPage.setValueOnTextboxById("Address_City", addCity);
		
		log.info("Add_New_Address - Step 15: Set data on fields - Address 1 textbox with value: " + addAddress1);
		adminManageCustomerAddressPage.setValueOnTextboxById("Address_Address1", addAddress1);
		
		log.info("Add_New_Address - Step 16: Set data on fields - Address 2 textbox with value: " + addAddress2);
		adminManageCustomerAddressPage.setValueOnTextboxById("Address_Address2", addAddress2);
		
		log.info("Add_New_Address - Step 17: Set data on fields - Zip/PostalCode textbox with value: "
				+ addZipPostalCode);
		adminManageCustomerAddressPage.setValueOnTextboxById("Address_ZipPostalCode", addZipPostalCode);
		
		log.info("Add_New_Address - Step 18: Set data on fields - PhoneNumber textbox with value: " + addPhoneNumber);
		adminManageCustomerAddressPage.setValueOnTextboxById("Address_PhoneNumber", addPhoneNumber);
		
		log.info("Add_New_Address - Step 19: Set data on fields - FaxNumber textbox with value: " + addFaxNumber);
		adminManageCustomerAddressPage.setValueOnTextboxById("Address_FaxNumber", addFaxNumber);
		
		log.info("Add_New_Address - Step 20: Click to save button");
		adminManageCustomerAddressPage.clickToDynamicButtonByText("Save");
		
		log.info("Add_New_Address - Step 21: Verify message displayed");
		verifyTrue(adminManageCustomerAddressPage.isVerifySuccessMessageDisplayed("The new address has been added successfully."));
		
		log.info("Add_New_Address - Step 22: Verify updated new value");
		verifyTrue(adminManageCustomerAddressPage.getInfoTextboxByID("Address_FirstName").equals(addFirstName));
		verifyTrue(adminManageCustomerAddressPage.getInfoTextboxByID("Address_LastName").equals(addLastName));
		verifyTrue(adminManageCustomerAddressPage.getInfoTextboxByID("Address_Email").equals(addEmail));
		verifyTrue(adminManageCustomerAddressPage.getInfoTextboxByID("Address_Company").equals(addCompany));
		verifyTrue(adminManageCustomerAddressPage.getSelectedValueOnDropdownListByID("Address_CountryId").equals(addCountry));
		verifyTrue(adminManageCustomerAddressPage.getSelectedValueOnDropdownListByID("Address_StateProvinceId").equals(addState));
		verifyTrue(adminManageCustomerAddressPage.getInfoTextboxByID("Address_County").equals(addCounty));
		verifyTrue(adminManageCustomerAddressPage.getInfoTextboxByID("Address_City").equals(addCity));
		verifyTrue(adminManageCustomerAddressPage.getInfoTextboxByID("Address_Address1").equals(addAddress1));
		verifyTrue(adminManageCustomerAddressPage.getInfoTextboxByID("Address_Address2").equals(addAddress2));
		verifyTrue(adminManageCustomerAddressPage.getInfoTextboxByID("Address_ZipPostalCode").equals(addZipPostalCode));
		verifyTrue(adminManageCustomerAddressPage.getInfoTextboxByID("Address_PhoneNumber").equals(addPhoneNumber));
		verifyTrue(adminManageCustomerAddressPage.getInfoTextboxByID("Address_FaxNumber").equals(addFaxNumber));
		
		log.info("Add_New_Address - Step 23: Click to 'back to customer details' linktext");
		adminEditCustomerPage = adminManageCustomerAddressPage.clickBackToCustomerDetail();
		
		log.info("Add_New_Address - Step 24: Verify updated new value in address table");
		verifyTrue(adminEditCustomerPage.isExpectedAddressContainedInActualResult("First name", addFirstName));
		verifyTrue(adminEditCustomerPage.isExpectedAddressContainedInActualResult("Last name", addLastName));
		verifyTrue(adminEditCustomerPage.isExpectedAddressContainedInActualResult("Email", addEmail));
		verifyTrue(adminEditCustomerPage.isExpectedAddressContainedInActualResult("Phone number", addPhoneNumber));
		verifyTrue(adminEditCustomerPage.isExpectedAddressContainedInActualResult("Fax number", addFaxNumber));
		verifyTrue(adminEditCustomerPage.isExpectedAddressInAddressColumn(addCompany));
		verifyTrue(adminEditCustomerPage.isExpectedAddressInAddressColumn(addAddress1));
		verifyTrue(adminEditCustomerPage.isExpectedAddressInAddressColumn(addAddress2));
		verifyTrue(adminEditCustomerPage.isExpectedAddressInAddressColumn(addCity));
		verifyTrue(adminEditCustomerPage.isExpectedAddressInAddressColumn(addZipPostalCode));
		verifyTrue(adminEditCustomerPage.isExpectedAddressInAddressColumn(addCountry));

		log.info("Add_New_Address - Step 25: Click back to customer linktext");
		adminSearchCustomerPage = adminEditCustomerPage.clickBackToCustomerListButton();
		
	}

	//@Test
	public void Customer_07_Edit_Address() {
		log.info("Edit_Address - Step 01: Refresh page");
		adminSearchCustomerPage.refreshPage(driver);

		log.info("Edit_Address - Step 02: Set value to search fields");
		adminSearchCustomerPage.setToTextboxSearchByID("SearchEmail", editEmail + email);
		adminSearchCustomerPage.setToTextboxSearchByID("SearchFirstName", editOther + firstName);
		adminSearchCustomerPage.setToTextboxSearchByID("SearchLastName", editOther + lastName);
		adminSearchCustomerPage.selectValueDateOfBirthByID("SearchMonthOfBirth",
				getSubStringBeforeCharacter(newDateOfBirth)[0]);
		adminSearchCustomerPage.selectValueDateOfBirthByID("SearchDayOfBirth",
				getSubStringBeforeCharacter(newDateOfBirth)[1]);
		adminSearchCustomerPage.setToTextboxSearchByID("SearchCompany", editOther + companyName);
		adminSearchCustomerPage.chooseCustomerRole(customerRole);

		log.info("Edit_Address - Step 03: Click to search button");
		adminSearchCustomerPage.clickToSearchButton();

		log.info("Edit_Address - Step 04: Click to edit button");
		adminEditCustomerPage = adminSearchCustomerPage.clickToEditButton();

		log.info("Edit_Address - Step 05: Click to Edit button on Address table");
		adminEditCustomerPage.clickToButtonOnAddressTableByText("Addresses", "Edit");
		adminManageCustomerAddressPage = PageGeneratorManager.getAdminManageCustomerAddressPage(driver);
		
		log.info("Edit_Address - Step 06: Set data on fields - Firstname textbox with value: " + editOther + addFirstName);
		adminManageCustomerAddressPage.setValueOnTextboxById("Address_FirstName", editOther + addFirstName);
		
		log.info("Edit_Address - Step 07: Set data on fields - Lastname textbox with value: " + editOther + addLastName);
		adminManageCustomerAddressPage.setValueOnTextboxById("Address_LastName", editOther + addLastName);
		
		log.info("Edit_Address - Step 08: Set data on fields - Email textbox with value: " + editEmail + addEmail);
		adminManageCustomerAddressPage.setValueOnTextboxById("Address_Email", editEmail + addEmail);
		
		log.info("Edit_Address - Step 09: Set data on fields - Company textbox with value: " + editOther + addCompany);
		adminManageCustomerAddressPage.setValueOnTextboxById("Address_Company", editOther + addCompany);
		
		log.info("Edit_Address - Step 10: Set data on fields - Country dropdownlist with value: " + addCountry);
		adminManageCustomerAddressPage.setValueOnDropDownListById("Address_CountryId", newAddCountry);
		
		log.info("Edit_Address - Step 11: Set data on fields - State/Province dropdownlist with value: " + addState);
		adminManageCustomerAddressPage.setValueOnDropDownListById("Address_StateProvinceId", newAddState);
		
		log.info("Edit_Address - Step 12: Set data on fields - County/Region textbox with value: " + editOther + addCounty);
		adminManageCustomerAddressPage.setValueOnTextboxById("Address_County", editOther + addCounty);
		
		log.info("Edit_Address - Step 13: Set data on fields - City textbox with value: " + editOther + addCity);
		adminManageCustomerAddressPage.setValueOnTextboxById("Address_City", editOther + addCity);
		
		log.info("Edit_Address - Step 14: Set data on fields - Address 1 textbox with value: " + editOther + addAddress1);
		adminManageCustomerAddressPage.setValueOnTextboxById("Address_Address1", editOther + addAddress1);
		
		log.info("Edit_Address - Step 15: Set data on fields - Address 2 textbox with value: " + editOther + addAddress2);
		adminManageCustomerAddressPage.setValueOnTextboxById("Address_Address2", editOther + addAddress2);
		
		log.info("Edit_Address - Step 16: Set data on fields - Zip/PostalCode textbox with value: "
				+ addZipPostalCode);
		adminManageCustomerAddressPage.setValueOnTextboxById("Address_ZipPostalCode", newAddZipPostalCode);
		
		log.info("Edit_Address - Step 17: Set data on fields - PhoneNumber textbox with value: " + addPhoneNumber);
		adminManageCustomerAddressPage.setValueOnTextboxById("Address_PhoneNumber", newAddPhoneNumber);
		
		log.info("Edit_Address - Step 18: Set data on fields - FaxNumber textbox with value: " + addFaxNumber);
		adminManageCustomerAddressPage.setValueOnTextboxById("Address_FaxNumber", newAddFaxNumber);
		
		log.info("Edit_Address - Step 19: Click to save button");
		adminManageCustomerAddressPage.clickToDynamicButtonByText("Save");
		
		log.info("Edit_Address - Step 20: Verify message displayed");
		adminManageCustomerAddressPage.isVerifySuccessMessageDisplayed("The address has been updated successfully.");
		
		log.info("Edit_Address - Step 21: Verify updated new value");
		verifyTrue(adminManageCustomerAddressPage.getInfoTextboxByID("Address_FirstName").equals(editOther + addFirstName));
		verifyTrue(adminManageCustomerAddressPage.getInfoTextboxByID("Address_LastName").equals(editOther + addLastName));
		verifyTrue(adminManageCustomerAddressPage.getInfoTextboxByID("Address_Email").equals(editEmail + addEmail));
		verifyTrue(adminManageCustomerAddressPage.getInfoTextboxByID("Address_Company").equals(editOther + addCompany));
		verifyTrue(adminManageCustomerAddressPage.getSelectedValueOnDropdownListByID("Address_CountryId").equals(newAddCountry));
		verifyTrue(adminManageCustomerAddressPage.getSelectedValueOnDropdownListByID("Address_StateProvinceId").equals(newAddState));
		verifyTrue(adminManageCustomerAddressPage.getInfoTextboxByID("Address_County").equals(editOther + addCounty));
		verifyTrue(adminManageCustomerAddressPage.getInfoTextboxByID("Address_City").equals(editOther + addCity));
		verifyTrue(adminManageCustomerAddressPage.getInfoTextboxByID("Address_Address1").equals(editOther + addAddress1));
		verifyTrue(adminManageCustomerAddressPage.getInfoTextboxByID("Address_Address2").equals(editOther + addAddress2));
		verifyTrue(adminManageCustomerAddressPage.getInfoTextboxByID("Address_ZipPostalCode").equals(newAddZipPostalCode));
		verifyTrue(adminManageCustomerAddressPage.getInfoTextboxByID("Address_PhoneNumber").equals(newAddPhoneNumber));
		verifyTrue(adminManageCustomerAddressPage.getInfoTextboxByID("Address_FaxNumber").equals(newAddFaxNumber));
		
		log.info("Edit_Address - Step 22: Click back to customer details link");
		adminEditCustomerPage =  adminManageCustomerAddressPage.clickBackToCustomerDetail();
		
		log.info("Edit_Address - Step 23: Verify updated new value on address table");
		verifyTrue(adminEditCustomerPage.isExpectedAddressContainedInActualResult("First name",editOther + addFirstName));
		verifyTrue(adminEditCustomerPage.isExpectedAddressContainedInActualResult("Last name", editOther + addLastName));
		verifyTrue(adminEditCustomerPage.isExpectedAddressContainedInActualResult("Email", editEmail + addEmail));
		verifyTrue(adminEditCustomerPage.isExpectedAddressContainedInActualResult("Phone number", newAddPhoneNumber));
		verifyTrue(adminEditCustomerPage.isExpectedAddressContainedInActualResult("Fax number", newAddFaxNumber));
		verifyTrue(adminEditCustomerPage.isExpectedAddressInAddressColumn(editOther + addCompany));
		verifyTrue(adminEditCustomerPage.isExpectedAddressInAddressColumn(editOther + addAddress1));
		verifyTrue(adminEditCustomerPage.isExpectedAddressInAddressColumn(editOther + addAddress2));
		verifyTrue(adminEditCustomerPage.isExpectedAddressInAddressColumn(editOther + addCity));
		verifyTrue(adminEditCustomerPage.isExpectedAddressInAddressColumn(newAddZipPostalCode));
		verifyTrue(adminEditCustomerPage.isExpectedAddressInAddressColumn(newAddCountry));
		
		log.info("Edit_Address - Step 24: Click back to customer linktext");
		adminSearchCustomerPage = adminEditCustomerPage.clickBackToCustomerListButton();
	}

	@Test
	public void Customer_08_Delete_Address() {
		log.info("Delete_Address - Step 01: Refresh page");
		adminSearchCustomerPage.refreshPage(driver);

		log.info("Delete_Address - Step 02: Set value to search fields");
		adminSearchCustomerPage.setToTextboxSearchByID("SearchEmail", editEmail + email);
		adminSearchCustomerPage.setToTextboxSearchByID("SearchFirstName", editOther + firstName);
		adminSearchCustomerPage.setToTextboxSearchByID("SearchLastName", editOther + lastName);
		adminSearchCustomerPage.selectValueDateOfBirthByID("SearchMonthOfBirth",
				getSubStringBeforeCharacter(newDateOfBirth)[0]);
		adminSearchCustomerPage.selectValueDateOfBirthByID("SearchDayOfBirth",
				getSubStringBeforeCharacter(newDateOfBirth)[1]);
		adminSearchCustomerPage.setToTextboxSearchByID("SearchCompany", editOther + companyName);
		adminSearchCustomerPage.chooseCustomerRole(customerRole);
		
		log.info("Delete_Address - Step 03: Click to search button");
		adminSearchCustomerPage.clickToSearchButton();

		log.info("Delete_Address - Step 04: Click to edit button");
		adminEditCustomerPage = adminSearchCustomerPage.clickToEditButton();

		log.info("Delete_Address - Step 05: Click to Delete button on Address table");
		adminEditCustomerPage.clickToButtonOnAddressTableByText("Addresses", "Delete");
		
		log.info("Delete_Address - Step 06: Confirm alert");
		adminEditCustomerPage.confirmDeleteAddressAlert();
		
		log.info("Delete_Address - Step 07: Verify text result");
		verifyTrue(adminEditCustomerPage.isNoDataAvailableInTableDisplayed());

	}

	@AfterTest(alwaysRun = true)
	public void afterTest() {
		closeBrowserDriver();
	}

}
