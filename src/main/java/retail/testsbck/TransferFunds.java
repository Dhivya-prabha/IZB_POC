package retail.testsbck;

import java.util.Map;
import hooks.TestNgHooks;
import retail.pages.MenuPage;
import retail.api.GetAccountBalances;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TransferFunds extends TestNgHooks{
/*	
	String accountNumber = "";
	String amount = "";
	
	@BeforeTest
	void setReportDetails() {
		testCaseName = "Transfer Fund to Other Accounts";
		testDescription = "Transfer and confirm the fund is transferred in different Currency";
		authors = "Babu";
		nodes = "Retail";
		category = "Smoke";
		
		Map<String, String> maxAccountBalances = GetAccountBalances.getMaxAccountBalances();
		Map.Entry<String,String> entry = maxAccountBalances.entrySet().iterator().next();
		accountNumber = entry.getKey();
		amount = entry.getValue();
		
		if(accountNumber.trim().equals("")) {
			reportStep("There is no account number found to proceed the test", "FAIL");
		}
		
	}

	@Test()
	public void transferFunds() {

		new MenuPage()
			.clickMoneyTransfers()
			.clickMyAccounts()
			.clickNext()
			.clickAccountNumber("0011050000526")
			.clickPayment()
			.typeTransferAmount("10")
			.chooseCurrency("ZMW")
			.chooseRemarks("Paying Bills")
			.clickSubmit()
			.verifyAmount("10 ZMW")
			.clickConfirm()
			.clickAccept()
			.typeOTP("1234")
			.clickSubmit()
			.clickDone();


	}
*/
}
