package retail.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import hooks.TestNgHooks;
import retail.pages.MenuPage;

public class Retail_Web_Accounts004 extends TestNgHooks {

	@BeforeTest
	void setReportDetails() {
		testCaseName = "Accounts - Account Number";
		testDescription = "Check if the account holders details are displayed";
		authors = "Sheriba";
		nodes = "Retail";
		category = "Accounts-MainPage";
	}

	@Test()
	public void isAccountDetailsDisplayed() throws InterruptedException {
		new MenuPage()
		.clickAccounts()
		.isAccountDetailsDisplayed();
	}
}


