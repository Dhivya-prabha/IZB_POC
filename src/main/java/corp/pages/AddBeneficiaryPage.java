package corp.pages;

import retail.pages.BeneficiaryPage;

public class AddBeneficiaryPage extends MenuPage {

	public AddBeneficiaryPage selectBenefitType(String benefitType) {
		click(locateElement("xpath", "//mat-select[@formcontrolname='beneType']"), "Beneficiary Type Drop Down");
		click(locateElement("xpath","//span[contains(text(),'"+benefitType+"')]"), "Beneficiary Option");
		return this;
	}
	
	public AddBeneficiaryPage selectBank(String bankName) {
		click(locateElement("xpath", "//mat-select[@formcontrolname='bankName']"), "Bank Name Drop Down");
		click(locateElement("xpath","//span[contains(text(),'"+bankName+"')]"), "Bank Name Option");
		return this;
	}
	
	public AddBeneficiaryPage selectBranch(String branchName) {
		click(locateElement("xpath", "//mat-select[@formcontrolname='branchName']"), "Branch Name Drop Down");
		click(locateElement("xpath","//span[contains(text(),'"+branchName+"')]"), "Branch Name Option");
		return this;
	}

	public AddBeneficiaryPage typeBeneficiaryName(String beneficiaryName) {
		type(locateElement("xpath", "//input[@formcontrolname='beneName']"), beneficiaryName, "Beneficiary Name");
		return this;
	}
	
	public AddBeneficiaryPage typeAccountNumber(String account) {
		type(locateElement("name", "beneAccNo"), account, "Account Number");
		return this;
	}
	
	public AddBeneficiaryPage typeConfirmAccountNumber(String account) {
		type(locateElement("name", "conBeneAccNo"), account, "Confirm Account Number");
		return this;
	}
	
	public AddBeneficiaryPage checkVisibleToGroup() {
		click(locateElement("xpath", "//mat-checkbox[@formcontrolname='isVisibleToGroup']"), "Visible To Group");
		return this;
	}	
	
	public AddBeneficiaryPage typeNickName(String name) {
		type(locateElement("xpath", "//input[@formcontrolname='shortName']"), name, "Nick Name");
		return this;
	}
	
	public AddBeneficiaryPage typeTransferLimit(String limit) {
		type(locateElement("xpath", "//input[@formcontrolname='maxTransferLimit']"), limit, "Limit");
		return this;
	}
	
	public AddBeneficiaryPage clickSubmit() {
		click(locateElement("xpath", "//span[text()='SUBMIT']"), "Sumbit");
		return this;
	}	
	
	public AddBeneficiaryPage typeOTP(String otp) {
		type(locateElement("xpath", "//input[@formcontrolname='otp']"), otp, "OTP");
		return this;
	}

	public AddBeneficiaryPage clickConfirm() {
		click(locateElement("xpath", "//span[text()='CONFIRM']"), "Confirm");
		return this;
	}	
	
}
