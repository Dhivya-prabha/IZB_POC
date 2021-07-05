package mobile.pages;

public class HomePage extends mobile.api.MobileHooks{
	
	public LoginPage clickGetStarted() {
		click("xpath", "//android.widget.TextView[@text=' Get Started ']","Get Started");
		return new LoginPage();
	}
}
