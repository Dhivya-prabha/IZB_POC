package retail.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import hooks.TestNgHooks;
import retail.pages.MenuPage;

public class InstantTransferVerification extends TestNgHooks {

	@BeforeTest
	void setReportDetails() {
		testCaseName = "Account - Instant Transaction";
		testDescription = "Verify available balance for Instant transaction";
		authors = "Hari";
		nodes = "Retail";
		category = "Accounts-Quick Pay";
	}

	@Test()
	public void selectCustomTransaction() throws InterruptedException {
		new MenuPage()
		.clickAccounts()
		.clickQuickPay()
		.clickInstantTransfer()
		//.getSourceAccount()
		.getAvailableBalBeforeTransaction()
		.selectAccountType("IAT")
		.enterAccountNumber("0013050000362")
		.enterConfirmAccountNumber("0013050000362")
		.enterAmount("10.00")
		.selectRemarks("Paying Bills")
		.clickSubmit()
		.clickConfirm()
		.enterOTP("1234")
        .clickSubmit()
        .clickDone()
        .clickAccount()
        .verifyAvailableBalAfterInstantPay("10.00");
	}
}



