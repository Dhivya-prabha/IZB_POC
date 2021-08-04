package retail.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import hooks.TestNgHooks;
import retail.pages.MenuPage;

public class Retail_Web_Accounts005 extends TestNgHooks {

	@BeforeTest
	void setReportDetails() {
		testCaseName = "Statement - Shortcuts displayed";
		testDescription = "Check if the shortcut menu buttons are available in the statement page also";
		authors = "Dhivya";
		nodes = "Retail";
		category = "Accounts-Statements";
	}

	@Test()
	public void isShortcutsDisplayed() {
		new MenuPage()
		.clickAccounts()
		.clickStatements()
		.isShortcutDisplayed();
	}
}

