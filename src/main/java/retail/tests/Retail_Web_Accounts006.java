package retail.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import hooks.TestNgHooks;
import retail.pages.MenuPage;

public class Retail_Web_Accounts006 extends TestNgHooks {

	@BeforeTest
	void setReportDetails() {
		testCaseName = "Statement - Last 10 Transactions";
		testDescription = "Check for the display of the last 10 transactions";
		authors = "Sheriba";
		nodes = "Retail";
		category = "Accounts-Statements";
	}

	@Test()
	public void Last10Transactions() {
		new MenuPage()
		.clickAccounts()
		.clickStatements()
		.verifyLast10Transactions();
	}
}
