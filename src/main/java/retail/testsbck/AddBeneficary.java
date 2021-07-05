package retail.testsbck;

import hooks.TestNgHooks;
import retail.data.AccountData;
import retail.data.Merchant;
import retail.pages.MenuPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddBeneficary extends TestNgHooks{
	
	@BeforeTest
	void setReportDetails() {
		testCaseName = "Add, View and Delete Beneficary (Happy Path)";
		testDescription = "Add a new beneficary and search it and delete to confirm it is deleted";
		authors = "Babu";
		nodes = "Retail";
		category = "Smoke";
	}
	
	@Test()
	public void addViewDeleteBeneficary() {
		String merchant = Merchant.values()[(int)(Math.random()*Merchant.values().length)].name();
		String account = AccountData.getRandomAccount(merchant);
		String name = "Babu";
		
		// ** Add Beneficary **// 
		new MenuPage()
			.clickPayments()
			.clickAddBeneficiary()
			.selectMerchant(merchant)
			.typeAccountNumber(account)
			.typeShortName(name)
			.clickSubmit()
			.confirmBeneficiarySuccess()
			
		// ** View Beneficary ** //
			.clickViewBeneficary()
			.verifyBeneficaryDisplayed(name, account)
			
		// ** Delete Beneficary ** //
			.clickView(account)
			.clickDelete()
			
		// ** Confirm Deleted ** //
			.clickViewBeneficary()
			.verifyBeneficaryDeleted(name, account);
	}

}
