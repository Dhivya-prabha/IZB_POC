package mobile.pages;

import mobile.api.MobileHooks;

public class PaymentPage extends MobileHooks{
			
	public PaymentPage clickAccount(String accountNumber) {
		click("xpath", "//android.widget.TextView[contains(@text,'"+accountNumber+"')]","Account Number");
		return this;
	}
	
	public PaymentPage clickServiceType(String type) {
		click("xpath", "//android.widget.TextView[@text='"+type+"']", "Category");
		return this;
	}
	
	public BeneficiaryPage clickViewBillerBeneficiary() {
		click("xpath", "//android.widget.TextView[@text=' View Biller beneficiary ']","View Beneficiary");
		return new BeneficiaryPage();
	}
	
	public BeneficiaryPage clickAddBillerBeneficiary() {
		click("xpath", "//android.widget.TextView[@text=' Add Biller beneficiary ']","Add Beneficiary");
		return new BeneficiaryPage();
	}
	
}
