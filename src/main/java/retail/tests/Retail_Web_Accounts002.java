package retail.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import hooks.TestNgHooks;
import retail.pages.MenuPage;

public class Retail_Web_Accounts002 extends TestNgHooks {

	@BeforeTest
	void setReportDetails() {
		testCaseName = "Accounts - Available Balance";
		testDescription = "Check if the available balance of the account is dispalyed";
		authors = "Sheriba";
		nodes = "Retail";
		category = "Accounts-MainPage";
	}

	@Test()
	public void isAvailableBalanceDisplayed() throws InterruptedException {
		new MenuPage()
		.clickAccounts()
		.isAvailableBalanceDisplayed();
	}
}




