package corp.tests;


import hooks.TestNgHooks;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import corp.pages.AddBeneficiaryPage;
import corp.pages.MenuPage;



public class AddBeneficary extends TestNgHooks{

	@BeforeTest
	void setReportDetails() {
		testCaseName = "Add, View and Delete Beneficary (Happy Path)";
		testDescription = "Add a new beneficary and search it and delete to confirm it is deleted";
		authors = "Babu";
		nodes = "Corporate";
		category = "Smoke";
	}

	@Test()
	public void addBeneficary() {

		String benefitType = "Domestic";

		new MenuPage()
			.clickTransfers()
			.clickBeneficiaryTransfer()
			.clickAddBeneficiary()
			.selectBenefitType(benefitType);
		if(benefitType.equals("Domestic")) {
			new AddBeneficiaryPage()
			.selectBank("BANK OF ZAMBIA")
			.selectBranch("NDOLA")
			.typeBeneficiaryName("Automation");
		} else if(benefitType.equals("International")) {

		}
		new AddBeneficiaryPage()
			.typeAccountNumber("910000100101")
			.typeConfirmAccountNumber("910000100101")
			.checkVisibleToGroup()
			.typeNickName("Automation")
			.typeTransferLimit("1000")
			.clickSubmit()
			.typeOTP("1234")
			.clickConfirm();


	}

}
