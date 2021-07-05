package retail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import services.WebDriverServiceImpl;

public class RetailLoginPage extends WebDriverServiceImpl{
	
	public RetailLoginPage typeUserName(String username) {
		type(locateElement("name","username"), username, "User Name");
		return this;
	}

	public RetailLoginPage typePassword(String password) {
		type(locateElement("name","password"), password , "Password");
		return this;
	}
	
	public MenuPage clickLogin() {
		click(locateElement("xpath", "//p[text()='Login']"), "Login");
		getWait().until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@attributeName='transform']")));
		return new MenuPage();
	}

	public MenuPage login(String username, String password) {
		return typeUserName(username).typePassword(password).clickLogin();
	}
}
