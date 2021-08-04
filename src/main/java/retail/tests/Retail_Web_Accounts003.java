package retail.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import hooks.TestNgHooks;
import retail.pages.MenuPage;

public class Retail_Web_Accounts003 extends TestNgHooks {

	@BeforeTest
	void setReportDetails() {
		testCaseName = "Accounts - Account Number";
		testDescription = "Check if the account number is displayed";
		authors = "Dhivya";
		nodes = "Retail";
		category = "Accounts-MainPage";
	}

	@Test()
	public void isAccountNumberDisplayed() throws InterruptedException {
		new MenuPage()
		.clickAccounts()
		.isAccountNumberDisplayed();
	}
}




