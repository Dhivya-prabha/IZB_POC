package mobile.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import mobile.api.MobileHooks;
import mobile.pages.HomePage;
import mobile.pages.MenuPage;


public class ViewBeneficiary extends MobileHooks{
	
	@BeforeTest
	public void setData() {
		testCaseName = "Add Beneficiary";
		testDescription = "Add Beneficiary (Mobile App)";
		nodes = "Retail";
		authors = "Babu";
		category = "Smoke";
	}
	
	
	@Test()
	public void addBeneficiary() {
		new MenuPage()
			.clickPayments()
			.clickAccount("0011 0510 0025 9")
			.clickViewBillerBeneficiary()
			.clickServiceNumber("976314391")
			.verifyServiceNumber("976314391");
			
	}
	

}
