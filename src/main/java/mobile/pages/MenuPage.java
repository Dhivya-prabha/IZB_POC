package mobile.pages;


import mobile.api.MobileHooks;

public class MenuPage extends MobileHooks{
	
	
	public MenuPage clickPortfolio() {
		click("xpath", "//android.widget.TextView[@text='Portfolio']", "Portfolio");
		return this;
	}
	
	public HomePage clickAccount() {
		click("xpath", "//android.widget.TextView[@text='Account']","Account");
		return new HomePage();
	}
	
	
	public HomePage clickMoneyTransfer() {
		click("xpath", "//android.widget.TextView[@text='Money Transfer']","Money Transfer");
		return new HomePage();
	}
	
	public PaymentPage clickPayments() {
		click("xpath", "//android.widget.TextView[@text='Payments']", "Payments");
		return new PaymentPage();
	}
	
	public HomePage clickAirtimeTopup() {
		click("xpath", "//android.widget.TextView[@text='Airtime Topup']","Airtime Popup");
		return new HomePage();
	}
	
	public HomePage clickDeposits() {
		click("xpath", "//android.widget.TextView[@text='Deposits']","Deposits");
		return new HomePage();
	}
	
	public HomePage clickExchangeRate() {
		click("xpath", "//android.widget.TextView[@text='Exchange Rate']","Exchange Rate");
		return new HomePage();
	}
	
	public HomePage clickSendToWallet() {
		click("xpath", "//android.widget.TextView[@text='Send to Wallet']","Send to Wallet");
		return new HomePage();
	}
	
	
}
