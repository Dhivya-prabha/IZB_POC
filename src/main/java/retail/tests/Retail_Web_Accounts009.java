package retail.tests;

import java.text.ParseException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import hooks.TestNgHooks;
import retail.pages.MenuPage;

public class Retail_Web_Accounts009 extends TestNgHooks {

	@BeforeTest
	void setReportDetails() {
		testCaseName = "Statement - Last 2 Months Transaction";
		testDescription = "Verify if the transactions of the last 2 months is displayed";
		authors = "Dhivya";
		nodes = "Retail";
		category = "Accounts-Statements";
	}

	@Test()
	public void selectTransaction() throws InterruptedException, ParseException {
		
		new MenuPage()
		.clickAccounts()
		.clickAccount()
		.getAccountInfo()
		.clickStatements()
		.clickDetailedStatement()
		.selectStatementType("Last 2 Months")
		.verifyTransactionsMonth(2);
	}
} 



