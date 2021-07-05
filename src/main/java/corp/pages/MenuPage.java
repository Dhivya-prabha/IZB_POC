package corp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import services.WebDriverServiceImpl;

public class MenuPage extends WebDriverServiceImpl {
	
	public void clickDashboard() {
		click(locateElement("xpath","//a[contains(text(),'Dashboard')]"), "Dashboard");
	}
	
	public TransfersPage clickTransfers() {
		click(locateElement("xpath","//a[contains(text(),'Transfers')]"), "Transfers");
		getWait().until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//p[text()='Loading...']")));
		return new TransfersPage();
	}
	
	public MyAccountsPage clickMyAccounts() {
		click(locateElement("xpath","//a[contains(text(),'My Accounts')]"), "My Accounts");
		return new MyAccountsPage();
	}
	
	public void clickBillPayments() {
		click(locateElement("xpath","//a[contains(text(),'Bill Payments')]"), "Bill Payments");
	}

	public void clickRequests() {
		click(locateElement("xpath","//a[contains(text(),'Requests')]"), "Requests");
	}
	
	public void clickInstantFundTransfers() {
		click(locateElement("xpath","//a[contains(text(),'Instant Funds Transfer')]"), "Instant Funds Transfer");
	}
}
