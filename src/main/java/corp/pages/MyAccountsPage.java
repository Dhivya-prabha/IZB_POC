package corp.pages;

import services.WebDriverServiceImpl;

public class MyAccountsPage extends WebDriverServiceImpl {
	
	public void clickSavingsCurrentAccounts() {
		click(locateElement("xpath","//span[text()='Savings & Current Accounts']"), "Dashboard");
	}
	
	public void clickLoans() {
		click(locateElement("xpath","//span[text()='Loans']"), "Loans");
	}
	
	public void clickDeposits() {
		click(locateElement("xpath","//span[text()='Deposits']"), "Deposits");
	}

	public void clickStandingInstruction() {
		click(locateElement("xpath","//span[text()='Standing Instruction']"), "Standing Instruction");
	}
}
