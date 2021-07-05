package design;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.InvalidElementStateException;

public class RemoteWebDriverService implements WebDriverService{
	
	public static RemoteWebDriver driver;

	@Override
	public WebElement locateElement(String locator, String locValue) {		
		try {
			switch (locator) {
			case "id":
				return driver.findElementById(locValue);
			case "name":
				return driver.findElementByName(locValue);
			case "xpath":
				return driver.findElementByXPath(locValue);
			default:
				return driver.findElementByXPath(locValue);
			}
		} catch (NoSuchElementException e) {
			System.err.println("The element could not be found for the locator "+locator+" for the value "+locValue);
		}
		return null;
	}

	@Override
	public void type(WebElement ele, String data, String eleName) {
		try {
			if(!driver.getCapabilities().getBrowserName().equals("safari"))
				ele.click(); // should i know all the possible conditions upfront? No !! You can add conditions later
			ele.clear();
			ele.sendKeys(data);
			System.out.println("The element "+eleName+" is cleared and typed with value "+data);
		} catch (InvalidElementStateException e2) {
			System.err.println("The element "+eleName+" is not in valid state to interact with it");
		}
	}

	@Override
	public void click(WebElement ele, String eleName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getText(WebElement ele, String eleName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void selectDropDownUsingVisibleText(WebElement ele, String value, String eleName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectDropDownUsingValue(WebElement ele, String value, String eleName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectDropDownUsingIndex(WebElement ele, int index, String eleName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean verifyExactTitle(String expectedTitle) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean verifyPartialTitle(String expectedTitle) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void verifyExactText(WebElement ele, String expectedText, String eleName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void verifyPartialText(WebElement ele, String expectedText, String eleName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void verifyExactAttribute(WebElement ele, String attribute, String value, String eleName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void verifyPartialAttribute(WebElement ele, String attribute, String value, String eleName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void verifySelected(WebElement el, String eleNamee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void verifyDisplayed(WebElement ele, String eleName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void switchToWindow(int index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void switchToFrame(WebElement ele) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void acceptAlert() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dismissAlert() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getAlertText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void closeActiveBrowser() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeAllBrowsers() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void waitForLoaderToDisapper() {
		// TODO Auto-generated method stub
		
	}

	
}
