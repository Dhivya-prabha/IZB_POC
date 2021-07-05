package retail.pages;

public class QuickPayPage extends MenuPage {

	public InstantTransferPage clickInstantTransfer() {
		click(locateElement("xpath", "//h2[text()='Instant Transfer']"),"Instant Transfer");
		return new InstantTransferPage();
	}
	
	
	public QuickPayPage clickAccount() {
		click(locateElement("xpath", "//span[@class='account-number']"),"Account");
		return this;
	}
	
	public QuickPayPage verifyAvailableBalAfterInstantPay(String detectedAmt) {
		String text = getText(locateElement("xpath", "//div[text()='Available Balance']/following-sibling::div"), "Available Balance after transaction");
		avaBalAfterTransaction = Float.parseFloat(text);
		float amountDetected = Float.parseFloat(detectedAmt);
		if(avaBalBeforeTransaction-amountDetected == avaBalAfterTransaction) {
			reportStep("Account details have correct value for available balanace after transaction", "pass");
		}
		else {
			reportStep("Account details have incorrect value for available balanace after transaction", "fail");
		}
		return this;
	}
	
}
