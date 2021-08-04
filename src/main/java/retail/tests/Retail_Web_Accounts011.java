package retail.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import hooks.TestNgHooks;
import retail.pages.MenuPage;

public class Retail_Web_Accounts011 extends TestNgHooks {

	@BeforeTest
	void setReportDetails() {
		testCaseName = "Statement - Custom Dates Transaction";
		testDescription = "Verify if the transaction is between the given dates";
		authors = "Dhivya";
		nodes = "Retail";
		category = "Accounts-Statements";
	}

	@Test()
	public void selectCustomTransaction() {
		new MenuPage()
		.clickAccounts()
		.clickStatements()
		.clickDetailedStatement()
		.selectStatementType("Custom Dates");
	}
}



