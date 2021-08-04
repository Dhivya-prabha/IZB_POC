package retail.tests;

import java.text.ParseException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import hooks.TestNgHooks;
import retail.pages.MenuPage;

public class Retail_Web_Accounts010 extends TestNgHooks {

	@BeforeTest
	void setReportDetails() {
		testCaseName = "Statement - Last 3 Months Transaction";
		testDescription = "Verify if the transactions of the last 3 months is displayed";
		authors = "Dhivya";
		nodes = "Retail";
		category = "Accounts-Statements";
	}

	@Test()
	public void selectTransaction() throws InterruptedException, ParseException {
		new MenuPage()
		.clickAccounts()
		.clickAccount()
		.getAccountInfo();
		
		new MenuPage()
		.clickAccounts()
		.clickStatements()
		.clickDetailedStatement()
		.selectStatementType("Last 2 Months")
		.verifyTransactionsMonth(3);
	}
}




