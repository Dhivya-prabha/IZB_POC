package mobile.pages;

import mobile.api.MobileHooks;

public class LoginPage extends MobileHooks{
	
	public LoginPage enterUsername(String email) {
		enterValue(email, "xpath", "//android.widget.EditText[@text='Username']","User Name");
		return this;
	}
	
	public LoginPage enterPassword(String pwd) {
		enterValue(pwd, "xpath", "//android.widget.EditText[@text='Password']","Password");
		return this;
	}
	
	public MenuPage clickLogin() {
		click("xpath", "(//android.widget.TextView[@text=' Login '])[2]","Login");
		return new MenuPage();
	}
	
	
	

}
