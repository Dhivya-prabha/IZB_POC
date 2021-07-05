package corp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import services.WebDriverServiceImpl;

public class CorporateLoginPage extends WebDriverServiceImpl{
	
	private CorporateLoginPage typeUserName(String username) {
		type(locateElement("name","username"), username, "Username");
		return this;
	}

	private CorporateLoginPage typePassword(String password) {
		type(locateElement("name","password"), password, "Password");
		return this;
	}
	
	private MenuPage clickLogin() {
		click(locateElement("xpath", "//span[text()='LOGIN']"), "Login");
		getWait().until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//p[text()='Loading...']")));
		return new MenuPage();
	}

	public MenuPage login(String username, String password) {
		return typeUserName(username).typePassword(password).clickLogin();
	}
}
