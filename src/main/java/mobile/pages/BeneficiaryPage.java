package mobile.pages;

import mobile.api.MobileHooks;

public class BeneficiaryPage extends MobileHooks{
	
	public BeneficiaryPage selectMerchant(String merchantName) {
		click("xpath", "//android.widget.TextView[contains(@text,'"+merchantName+"']","Merchant");
		return this;
	}
	
	public BeneficiaryPage enterShortName(String name) {
		enterValue(name, "xpath", "//android.widget.TextView[@text='Short name *']/following::android.widget.EditText","Short Name");
		return this;
	}
	
	public BeneficiaryPage enterServiceNumber(String number) {
		enterValue(number, "xpath", "//android.widget.TextView[@text='Service number *']/following::android.widget.EditText","Service Number");
		return this;
	}
	
	public BeneficiaryPage clickSubmit() {
		click("xpath", "//android.widget.TextView[contains(@text,'Submit')]","Submit");
		return this;

	}
	
	public BeneficiaryPage clickServiceNumber(String serNum) {
		click("xpath", "//android.widget.TextView[@text = 'Service Number :"+serNum+"']","Service Number");
		return this;

	}
	
	public BeneficiaryPage verifyServiceNumber(String serNum) {
		verifyText(serNum, "xpath", "//android.widget.TextView[@text = 'Service number']/following::android.widget.TextView", "ServiceNumber");
		return this;

	}
}
