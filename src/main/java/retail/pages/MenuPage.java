package retail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import services.WebDriverServiceImpl;

public class MenuPage extends WebDriverServiceImpl {

	public PaymentPage clickPayments() {
		click(locateElement("xpath", "//h2[text()='Payments']"),"Payments");
		return new PaymentPage();
	}
	
	/*public TransfersPage clickTransfers() {
		click(locateElement("xpath", "//h2[text()='Transfers']"),"Transfers");
		return new TransfersPage();
	}*/
	
	public void clickDeposits() {
		click(locateElement("xpath", "//h2[text()='Deposits']"),"Deposits");
	
	}
	
	public AccountsPage clickAccounts() {
		click(locateElement("xpath", "//h2[text()='Accounts']"),"Accounts");
		getWait().until(ExpectedConditions.visibilityOfElementLocated(By.className("account-number")));
		return new AccountsPage();
	}
	
	
}
