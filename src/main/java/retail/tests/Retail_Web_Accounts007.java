package retail.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import hooks.TestNgHooks;
import retail.pages.MenuPage;

public class Retail_Web_Accounts007 extends TestNgHooks {

	@BeforeTest
	void setReportDetails() {
		testCaseName = "Statement - Transaction details";
		testDescription = "Check if the transaction detail is displayed for individual transactions";
		authors = "Sheriba";
		nodes = "Retail";
		category = "Accounts-Statements";
	}

	@Test()
	public void TransactionDetails() {
		new MenuPage()
		.clickAccounts()
		.clickStatements()
		.isTransactionDetailAvailable();
	}
}
