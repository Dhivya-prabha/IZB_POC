package retail.pages;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.openqa.selenium.WebElement;

public class InstantTransferPage extends MenuPage {

	
	public InstantTransferPage getAvailableBalBeforeTransaction() {
		String text = getText(locateElement("xpath", "//p[text()='Available Balance:']/span[2]"), "Available Balance before transaction");
		avaBalBeforeTransaction = Float.parseFloat(text.replaceAll(",", ""));
		return this;
	}
	
	public InstantTransferPage getSourceAccount() {
		sourceAccount = getText(locateElement("xpath", "//label[text()='Source Account']/following-sibling::h3"), "Available Balance before transaction");
		return this;
	}
	
	public InstantTransferPage selectAccountType(String type) throws InterruptedException {
		selectDropDownUsingVisibleText(locateElement("name", "accountType"), type,"Account Type");
		return this;
	}
	
	public InstantTransferPage enterAccountNumber(String sourceAccount) {
		type(locateElement("name", "accountNumber"), sourceAccount, "Account Number");
		return this;
	}
	
	public InstantTransferPage enterConfirmAccountNumber(String sourceAccount) {
		type(locateElement("name", "confirmAccountNumber"), sourceAccount, "Confirm Account Number");
		return this;
	}
	
	public InstantTransferPage enterAmount(String amt) {
		type(locateElement("name", "amount"), amt, "Amount");
		return this;
	}
	
	public InstantTransferPage selectRemarks(String remarks) throws InterruptedException {
		selectDropDownUsingVisibleText(locateElement("name", "remarks"), remarks,"Remarks");
		return this;
	}
	
	public InstantTransferPage clickSubmit() {
		click(locateElement("xpath", "//p[text()='Submit']"),"Submit");
		return this;
	}
	
	public InstantTransferPage clickConfirm() {
		click(locateElement("xpath", "//p[text()='Confirm']"),"Confirm");
		return this;
	}
	
	public InstantTransferPage enterOTP(String otp) {
		type(locateElement("xpath", "//h4[text()='Enter OTP']/following::input[1]"), otp.charAt(0)+"", "Digit1");
		type(locateElement("xpath", "//h4[text()='Enter OTP']/following::input[2]"), otp.charAt(1)+"", "Digit2");
		type(locateElement("xpath", "//h4[text()='Enter OTP']/following::input[3]"), otp.charAt(2)+"", "Digit3");
		type(locateElement("xpath", "//h4[text()='Enter OTP']/following::input[4]"), otp.charAt(3)+"", "Digit4");
		return this;
	}
	
	public QuickPayPage clickDone() {
		click(locateElement("xpath", "//p[text()='Done']"),"Done");
		return new QuickPayPage();
	}
	
}
