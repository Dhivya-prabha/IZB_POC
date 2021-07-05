package retail.tests;

	import hooks.TestNgHooks;
	import retail.pages.MenuPage;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

	public class Retail_Web_Accounts008 extends TestNgHooks {

		@BeforeTest
		void setReportDetails() {
			testCaseName = "Statement - CurrentMonth Transaction";
			testDescription = "Verify if the transactions of the current month is displayed";
			authors = "Sheriba";
			nodes = "Retail";
			category = "Accounts-Statements";
		}

		@Test()
		public void selectCurrentMonthTransaction() {
			new MenuPage()
			.clickAccounts()
			.clickStatements()
			.clickDetailedStatement()
			.selectStatementType("Current Month");
		}
	}

	

