package retail.pages;

import org.openqa.selenium.By;

public class PaymentPage extends MenuPage {

	public BeneficiaryPage clickAddBeneficiary() {
		click(locateElement("xpath", "//p[text()='Add Beneficiary']"), "Add Beneficiary");
		return new BeneficiaryPage();
	}

	public BeneficiaryPage clickViewBeneficary() {
		click(locateElement("xpath", "//p[text()='View Beneficiaries']"), "View Beneficiary");
		return new BeneficiaryPage();
	} 

	public PaymentPage isBillPaymentDisplayed() {
		verifyDisplayed(locateElement("xpath", "//h4[text()='Bill Payment']"), "Bill Payment");
		return this;
	}

	public PaymentPage clickProductCategory(String categoryName) {
		click(locateElement("xpath", "//h5[text()='" + categoryName + "']"), "Click "+ categoryName);
		return this;
	}

	public PaymentPage selectField(String prodName, String prodValue, String selectedProduct) throws InterruptedException {
		selectDropDownUsingVisibleText(locateElement("name", prodName), prodValue,selectedProduct);
		if(prodName=="accountNumber")
			Thread.sleep(2000);
		return this;
	}
	
	public PaymentPage typeServiceNumber(String locValue, String serviceNumber) {
		//type(locateElement("xpath", "//input[@name='" + locValue + "']"), serviceNumber, selectedProduct);
		type(locateElement("name", locValue), serviceNumber, locValue);
		return this;
	}

	public PaymentPage selectShowBeneficiaries() throws InterruptedException {
		Thread.sleep(2000);
		clickUsingJs(locateElement("id","customSwitch1"), "Show Beneficiaries");
		return this;
	}

	public PaymentPage typeAmount(String locValue, String amount) {
		type(locateElement("name", locValue), amount, locValue);
		return this;
	}

	public PaymentPage commonSubmit(String locValue){
		click(locateElement("xpath", "//p[text()='"+locValue+"']"), locValue);
		return this;
	}

}

