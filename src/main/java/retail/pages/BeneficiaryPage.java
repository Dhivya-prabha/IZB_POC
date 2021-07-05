package retail.pages;

public class BeneficiaryPage extends MenuPage {
	public BeneficiaryPage addBeneficiary() {
		click(locateElement("xpath", "//div[text()='Add Beneficiary']"), "Click addBeneficiary");
		return this;
	}

	// Single Method to choose beneficiary option
	// Parameter value : Make Transfer, View Beneficiaries, Download Receipts 
	public BeneficiaryPage chooseBeneficiaryOptions(String option) {
		click(locateElement("xpath", "//h3[text()='"+option+"']"), "Click"+option+"");
		return this;
	}
	// Single Method to choose beneficiary option
	// Parameter value : Within Bank, Domestic, International
	public BeneficiaryPage chooseTransferType(String transferType) {
		click(locateElement("xpath", "//span[contains(text(),'"+transferType+"')]"), "Click"+transferType+"");
		return this;
	}
	

	// /*************/
	// Below are the codes we used for the old IZB
	// can use based on our requirement of the new IZB
	public BeneficiaryPage selectMerchant(String merchant) {
		selectDropDownUsingVisibleText(locateElement("name", "merchant"),merchant, "Merchant");
		return this;
	}
	
	public BeneficiaryPage typeAccountNumber(String account) {
		type(locateElement("name", "accountNumber"), account, "Account Number");
		return this;
	}
	
	public BeneficiaryPage typeShortName(String account) {
		type(locateElement("name", "shortName"), account, "Short Name");
		return this;
	}
	
	public BeneficiaryPage clickSubmit() {
		click(locateElement("xpath", "//p[text()='Submit']"), "Submit");
		return this;
	}	
	
	public PaymentPage confirmBeneficiarySuccess() {
		click(locateElement("xpath", "//h6[text()='Biller added Successfully']/following::p"), "Ok");
		return new PaymentPage();
	}

	public BeneficiaryPage verifyBeneficaryDisplayed(String name, String account) {
		verifyDisplayed(locateElement("xpath", "//p[text()='"+account+"']/preceding-sibling::h5[text()='"+name+"']"), "Beneficary");
		return this;
	}
	
	public BeneficiaryPage clickView(String account) {
		click(locateElement("xpath", "//p[text()='"+account+"']/following::button[@type='submit']"), "View");
		return this;
	}	
	
	public BeneficiaryPage verifyMerchant(String merchant) {
		verifyExactText(locateElement("xpath", "//h5[text()='Merchant :']/following-sibling::h5"), merchant, "Merchant");
		return this;
	}	
	
	public PaymentPage clickDelete() {
		click(locateElement("xpath", "//p[text()='Delete']"), "Delete");
		click(locateElement("xpath","//h6[text()='Are you Sure to Delete Beneficiary']/following::p[text()='Yes']"), "Delete Ok");
		click(locateElement("xpath", "//p[text()='Done']"), "Done");
		return new PaymentPage();
	}	
	
	public BeneficiaryPage verifyBeneficaryDeleted(String name, String account) {
		verifyDisappeared("xpath", "//p[text()='"+account+"']/preceding-sibling::h5[text()='"+name+"']", "Beneficary");
		return this;
	}
	
}
