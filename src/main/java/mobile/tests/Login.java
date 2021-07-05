package mobile.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import mobile.api.MobileHooks;
import mobile.pages.HomePage;


public class Login extends MobileHooks{
	
	@BeforeTest
	public void setData() {
		testCaseName = "TC001_Login";
		testDescription = "Login to IZB App";
		nodes = "Retail";
		authors = "Babu";
		category = "Smoke";
	}
	
	
	@Test()
	public void login() {
		new HomePage()
		.clickGetStarted()
		.enterUsername("testuser")
		.enterPassword("Test@1234")
		.clickLogin();
	}
	

}
