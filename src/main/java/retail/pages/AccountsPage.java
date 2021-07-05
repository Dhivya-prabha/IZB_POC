package retail.pages;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AccountsPage extends MenuPage {
		
	public AccountsPage verifyMenuOptionsDisplayed() {
		int menuListSize = locateElements("xpath", "//h2").size();
		if (menuListSize == 10) {
			reportStep("All the 11 menu Options are dispalyed.", "PASS");
		} else if (menuListSize < 10) {
			reportStep("Less than 11 menu options are displayed. Available options count is " + menuListSize, "FAIL");
		} 
		return this;
	}

	public AccountsPage isAccountDetailsDisplayed() {
		click(locateElement("class", "account-number"), "Account Details");
		verifyDisplayed(locateElement("class", "mb-4"), "Account Details Display");
		return this;
	}
	
	public AccountsPage isAccountNumberDisplayed() {
		verifyDisplayed(locateElement("class", "account-number"), "Account Number");
		return this;
	}
	
	public AccountsPage isAvailableBalanceDisplayed() throws InterruptedException {
		verifyDisplayed(locateElement("class","balance"), "Balance Amount");
		return this;
	}
	
	public StatementPage clickStatements() {
		click(locateElement("xpath", "//h2[text()='Statement']"),"Statements");
		return new StatementPage();
	}
	
	public MenuPage clickDashboard() {
		click(locateElement("class", "btn-dashboard"),"DashBoard");
		return new MenuPage();
		
	}
	
	public BeneficiaryPage clickBeneficiaryTransfer() {
		click(locateElement("xpath", "//h2[text()='Beneficiary Transfer']"),"Statements");
		return new BeneficiaryPage();
	}
	
	
	public QuickPayPage clickQuickPay() {
		click(locateElement("xpath", "//h2[text()='Quick Pay']"),"Quick Pay");
		return new QuickPayPage();
	}
	
	public AccountsPage getAccountInfo() {
		accountNumber = getText(locateElement("xpath", "//div[text()='Account Number']/following-sibling::div"), "Account Number");
		customerId = getText(locateElement("xpath", "//div[text()='Customer ID']/following-sibling::div"), "Customer ID");
		return this;
	}
	
	public AccountsPage clickAccount() {
		click(locateElement("xpath", "//span[@class='account-number']"),"Account");
		return this;
	}
	
}