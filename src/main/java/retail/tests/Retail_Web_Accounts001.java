package retail.tests;

	import hooks.TestNgHooks;
	import retail.pages.MenuPage;
	import retail.pages.RetailLoginPage;

	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

	import corp.pages.CorporateLoginPage;

	public class Retail_Web_Accounts001 extends TestNgHooks {

		@BeforeTest
		void setReportDetails() {
			testCaseName = "Accounts - UI Validation";
			testDescription = "Click on accounts and validate the display of all options";
			authors = "Dhivya";
			nodes = "Retail";
			category = "Accounts";
		}

		@Test()
		public void validateUI() {
			new MenuPage()
			.clickAccounts()
			.verifyMenuOptionsDisplayed();
		}

	}

	

