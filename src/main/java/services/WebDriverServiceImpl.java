package services;

import design.WebDriverService;
import events.WebDriverEvents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverServiceImpl extends WebDriverEvents implements WebDriverService{
	public static boolean noTransFound = true;
	public static String transactionAmount;
	public static String transDesc;
	public static String transType="Credit";
	public static String transRefNo;
    public static List<String> transactionMonthsList;
    public static List<String> prevMonthsList;
    public static float avaBalBeforeTransaction;
    public static float avaBalAfterTransaction;
    public static String sourceAccount;
    public static String accountNumber;
    public static String customerId;
    
	public WebElement locateElement(String locator, String locValue) {
		try {
			switch (locator) {
				case "id": return getDriver().findElement(By.id(locValue));
				case "name": return getDriver().findElement(By.name(locValue));
				case "class": return getDriver().findElement(By.className(locValue));
				case "link" : return getDriver().findElement(By.linkText(locValue));
				case "xpath": return getDriver().findElement(By.xpath(locValue));		
				default: break;
			}

		} catch (NoSuchElementException e) {
			reportStep("The element with locator "+locator+" not found.","FAIL");
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while finding "+locator+" with the value "+locValue, "FAIL");
		}
		return null;
	}
	
	public List<WebElement> locateElements(String locator, String locValue) {
		try {
			switch (locator) {
				case "id": return getDriver().findElements(By.id(locValue));
				case "name": return getDriver().findElements(By.name(locValue));
				case "class": return getDriver().findElements(By.className(locValue));
				case "link" : return getDriver().findElements(By.linkText(locValue));
				case "xpath": return getDriver().findElements(By.xpath(locValue));		
				default: break;
			}

		} catch (NoSuchElementException e) {
			reportStep("The elements with locator "+locator+" not found.","FAIL");
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while finding "+locator+" with the value "+locValue, "FAIL");
		}
		return null;
	}
	
	
	public boolean isElementExists(String locator, String locValue) {
		boolean isFound = false;
		try {
			getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			switch (locator) {
				case "id": {
					isFound = getDriver().findElement(By.id(locValue)).isDisplayed();
					break;
				}
				case "name": {
					isFound = getDriver().findElement(By.name(locValue)).isDisplayed();
					break;
				}
				case "class": {
					isFound = getDriver().findElement(By.className(locValue)).isDisplayed();
					break;
				}
				case "link" : {
					isFound = getDriver().findElement(By.linkText(locValue)).isDisplayed();
					break;
				}
				case "xpath": {
					isFound = getDriver().findElement(By.xpath(locValue)).isDisplayed();
					break;
				}
				default: isFound = false;
			}

		} catch (Exception e) {
		}
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return isFound;
	}

	public WebElement locateElement(String locValue) {
		return getDriver().findElement(By.id(locValue));
	}

	public void type(WebElement ele, String data, String elementName) {
		try {
			ele.clear();
			ele.sendKeys(data);
			reportStep("The data: "+data+" entered successfully in the "+elementName +" field", "PASS");
		} catch (InvalidElementStateException e) {
			reportStep("The data: "+data+" could not be entered in the "+elementName +" field","FAIL");
		} catch (WebDriverException e) {
			e.printStackTrace();
			reportStep("Unknown exception occured while entering "+data+" in the field :"+elementName, "FAIL");
		}
	}

	public void typeAndTab(WebElement ele, String data, String elementName) {
		try {
			ele.clear();
			ele.sendKeys(data, Keys.TAB);
			reportStep("The data: "+data+" entered & tabbed successfully in the "+elementName +" field", "PASS");
		} catch (InvalidElementStateException e) {
			reportStep("The data: "+data+" could not be entered & tabbed in the "+elementName+" field :"+ele,"FAIL");
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while entering & tabbing "+data+" in the field :"+elementName, "FAIL");
		}
	}
	
	public void typeAndChoose(WebElement ele, String data, String elementName) {
		try {
			ele.clear();
			ele.sendKeys(data);
			Thread.sleep(500);
			ele.sendKeys(Keys.DOWN, Keys.ENTER);
			reportStep("The data: "+data+" chosen successfully in the field :"+elementName, "PASS");
		} catch (InvalidElementStateException e) {
			reportStep("The data: "+data+" could not be chosen in the field :"+elementName,"FAIL");
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while chosen "+data+" in the field :"+elementName, "FAIL");
		} catch(Exception e) {
			
		}
	}

	public void typeAndEnter(WebElement ele, String data, String eleName) {
		try {
			ele.clear();
			ele.sendKeys(data, Keys.ENTER);
			reportStep("The data: "+data+" entered successfully in the field :"+eleName, "PASS");
		} catch (InvalidElementStateException e) {
			reportStep("The data: "+data+" could not be entered in the field :"+eleName,"FAIL");
		} catch (WebDriverException e) {
			e.printStackTrace();
			reportStep("Unknown exception occured while entering "+data+" in the field :"+eleName, "FAIL");
		}
	}

	public void click(WebElement ele, String eleName) {
		String text = "";
		try {
			getWait().until(ExpectedConditions.elementToBeClickable(ele));			
			text = ele.getText();
			ele.click();
			reportStep("The element "+eleName+" with "+text+" is clicked", "PASS");
		} catch (InvalidElementStateException e) {
			reportStep("The element "+eleName+" with : "+text+" could not be clicked", "FAIL");
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while clicking in the field :"+eleName, "FAIL");
		} 
	}
	
	public void clickUsingJs(WebElement ele, String eleName) {
		String text = "";
		try {
			getDriver().executeScript("arguments[0].click()", ele);
			reportStep("The element "+eleName+" with "+text+" is clicked", "PASS");
		} catch (InvalidElementStateException e) {
			reportStep("The element "+eleName+" with: "+text+" could not be clicked", "FAIL");
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while clicking in the field :"+eleName, "FAIL");
		} 
	}

	public void clickWithNoSnap(WebElement ele, String eleName) {
		String text = "";
		try {
			getWait().until(ExpectedConditions.elementToBeClickable(ele));	
			text = ele.getText();
			ele.click();			
			reportStep("The element "+eleName+" with :"+text+"  is clicked.", "PASS",false);
		} catch (InvalidElementStateException e) {
			reportStep("The element "+eleName+" with : "+text+" could not be clicked", "FAIL",false);
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while clicking in the field :"+eleName,"FAIL",false);
		} 
	}

	public String getText(WebElement ele, String eleName) {	
		String bReturn = "";
		try {
			bReturn = ele.getText();
		} catch (WebDriverException e) {
			reportStep("The element: "+eleName+" could not be found.", "FAIL");
		}
		return bReturn;
	}

	public String getTitle() {		
		String bReturn = "";
		try {
			bReturn =  getDriver().getTitle();
		} catch (WebDriverException e) {
			reportStep("Unknown Exception Occured While fetching Title", "FAIL");
		} 
		return bReturn;
	}

	public String getAttribute(WebElement ele, String attribute, String eleName) {		
		String bReturn = "";
		try {
			bReturn=  ele.getAttribute(attribute);
		} catch (WebDriverException e) {
			reportStep("The element: "+eleName+" could not be found.", "FAIL");
		} 
		return bReturn;
	}

	public void selectDropDownUsingVisibleText(WebElement ele, String value, String eleName) {
		try {
		    // Write a code to scroll down into view
			getDriver().executeScript("arguments[0].scrollIntoView(true);", ele);
			new Select(ele).selectByValue(value);
			reportStep("The dropdown "+eleName+" is selected with value "+value,"PASS");
		} catch (WebDriverException e) {
			e.printStackTrace();
			reportStep("The element: "+eleName+" could not be found.", "FAIL");
		}

	}

	public void selectDropDownUsingIndex(WebElement ele, int index, String eleName) {
		try {
			new Select(ele).selectByIndex(index);
			reportStep("The dropdown "+eleName+" is selected with index "+index,"PASS");
		} catch (WebDriverException e) {
			reportStep("The element: "+eleName+" could not be found.", "FAIL");
		} 

	}

	public boolean verifyExactTitle(String title) {
		boolean bReturn =false;
		try {
			if(getTitle().equals(title)) {
				reportStep("The title of the page matches with the value :"+title,"PASS");
				bReturn= true;
			}else {
				reportStep("The title of the page:"+getDriver().getTitle()+" did not match with the value :"+title, "FAIL");
			}
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		} 
		return bReturn;
	}
	
	public boolean verifyPartialTitle(String title) {
		boolean bReturn =false;
		
		try {
			getWait().until(ExpectedConditions.titleContains(title));
		}catch(Exception e) {
			// ignore the exception after timeout
		}
		
		try {
			
			if(getTitle().contains(title)) {
				reportStep("The title of the page matches with the value :"+title,"PASS");
				bReturn= true;
			}else {
				reportStep("The title of the page:"+getDriver().getTitle()+" did not match with the value :"+title, "FAIL");
			}
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		} 
		return bReturn;		
	}

	public void verifyExactText(WebElement ele, String expectedText, String eleName) {
		try {
			
			String text = getText(ele, eleName);
			if(text.equals(expectedText)) {
				reportStep("The text: "+getText(ele, eleName)+" matches with the value :"+expectedText,"PASS");
			}else {
				reportStep("The text "+text+" doesn't matches the actual "+expectedText,"FAIL");
			}
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while verifying the Text of element "+eleName, "FAIL");
		} 

	}

	public void verifyPartialText(WebElement ele, String expectedText, String eleName) {
		try {
			if(getText(ele, eleName).contains(expectedText)) {
				reportStep("The expected text contains the actual "+expectedText,"PASS");
			}else {
				reportStep("The expected text doesn't contain the actual "+expectedText,"FAIL");
			}
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while verifying the Text", "FAIL");
		} 
	}

	public void verifyExactAttribute(WebElement ele, String attribute, String value, String eleName) {
		try {
			if(getAttribute(ele, attribute, eleName).equals(value)) {
				reportStep("The expected attribute :"+attribute+" value matches the actual "+value,"PASS");
			}else {
				reportStep("The expected attribute :"+attribute+" value does not matches the actual "+value,"FAIL");
			}
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while verifying the Attribute Text", "FAIL");
		} 

	}

	public void verifyPartialAttribute(WebElement ele, String attribute, String value, String eleName) {
		try {
			if(getAttribute(ele, attribute, eleName).contains(value)) {
				reportStep("The expected attribute :"+attribute+" value contains the actual "+value,"PASS");
			}else {
				reportStep("The expected attribute :"+attribute+" value does not contains the actual "+value,"FAIL");
			}
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while verifying the Attribute Text", "FAIL");
		}
	}

	public void verifySelected(WebElement ele, String eleName) {
		try {
			if(ele.isSelected()) {
				reportStep("The element "+eleName+" is selected","PASS");
			} else {
				reportStep("The element "+eleName+" could not be selected","FAIL");
			}
		} catch (WebDriverException e) {
			reportStep("The element "+eleName+" could not be selected due to exception: "+e.getMessage(), "FAIL");
		}
	}

	public void verifyDisplayed(WebElement ele, String eleName) {
		try {
			if(ele.isDisplayed()) {
				reportStep("The element "+eleName+" is visible","PASS");
			} else {
				reportStep("The element "+eleName+" is not visible","FAIL");
			}
		} catch (WebDriverException e) {
			reportStep("The element "+eleName+" could not be verified due to exception: "+e.getMessage(), "FAIL");
		} 
	}
	
	public void verifyDisappeared(String locator, String locValue, String eleName) {
		try {
			if(!isElementExists(locator, locValue)) {
				reportStep("The element "+eleName+" disappeared.","PASS");
			} else {
				reportStep("The element "+eleName+" is visible","FAIL");
			}
		} catch (WebDriverException e) {
			reportStep("The element "+eleName+" could not be verified due to exception: "+e.getMessage(), "FAIL");
		} 
	}

	public void switchToWindow(int index) {
		try {
			Set<String> allWindowHandles = getDriver().getWindowHandles();
			List<String> allHandles = new ArrayList<>();
			allHandles.addAll(allWindowHandles);
			getDriver().switchTo().window(allHandles.get(index));
		} catch (NoSuchWindowException e) {
			reportStep("The driver could not move to the given window by index "+index,"PASS");
		} catch (WebDriverException e) {
			reportStep("WebDriverException : "+e.getMessage(), "FAIL");
		}
	}
	public void scrollDownInBrowser(WebElement ele, String eleName) {
		System.out.println(" scroll1");
		try {
			System.out.println(" Scroll");
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView(true);",ele);
		} catch (WebDriverException e) {
			reportStep("The element "+eleName+" could not be viewed due to exception: "+e.getMessage(), "FAIL");
		}  
	}
	
	public void switchToFrame(WebElement ele) {
		try {
			getDriver().switchTo().frame(ele);
			reportStep("switch In to the Frame "+ele,"PASS");
		} catch (NoSuchFrameException e) {
			reportStep("WebDriverException : "+e.getMessage(), "FAIL");
		} catch (WebDriverException e) {
			reportStep("WebDriverException : "+e.getMessage(), "FAIL");
		} 
	}

	public void acceptAlert() {
		String text = "";		
		try {
			Alert alert = getDriver().switchTo().alert();
			text = alert.getText();
			alert.accept();
			reportStep("The alert "+text+" is accepted.","PASS");
		} catch (NoAlertPresentException e) {
			reportStep("There is no alert present.","FAIL");
		} catch (WebDriverException e) {
			reportStep("WebDriverException : "+e.getMessage(), "FAIL");
		}  
	}

	public void dismissAlert() {
		String text = "";		
		try {
			Alert alert = getDriver().switchTo().alert();
			text = alert.getText();
			alert.dismiss();
			reportStep("The alert "+text+" is dismissed.","PASS");
		} catch (NoAlertPresentException e) {
			reportStep("There is no alert present.","FAIL");
		} catch (WebDriverException e) {
			reportStep("WebDriverException : "+e.getMessage(), "FAIL");
		} 

	}

	public String getAlertText() {
		String text = "";		
		try {
			Alert alert = getDriver().switchTo().alert();
			text = alert.getText();
		} catch (NoAlertPresentException e) {
			reportStep("There is no alert present.","FAIL");
		} catch (WebDriverException e) {
			reportStep("WebDriverException : "+e.getMessage(), "FAIL");
		} 
		return text;
	}


	public void closeActiveBrowser() {
		try {
			getDriver().close();
			reportStep("The browser is closed","PASS", false);
		} catch (Exception e) {
			reportStep("The browser could not be closed","FAIL", false);
		}
	}

	public void closeAllBrowsers() {
		try {
			getDriver().quit();
			reportStep("The opened browsers are closed","PASS", false);
		} catch (Exception e) {
			reportStep("Unexpected error occured in Browser","FAIL", false);
		}
	}


	public void selectDropDownUsingValue(WebElement ele, String value, String eleName) {
		try {
			new Select(ele).selectByValue(value);
			reportStep("The dropdown "+eleName+" is selected with text "+value,"PASS");
		} catch (WebDriverException e) {
			reportStep("The element: "+eleName+" could not be found.", "FAIL");
		}

	}

	@Override
	public void waitForLoaderToDisapper() {
		// TODO Auto-generated method stub
		
	}

	public void setLanguage(String lang) {
		try {
			synchronized (lang) {
				language.load(new FileInputStream(new File("./src/main/resources/"+lang+".properties")));
				tlProp.set(language);
			}			
		} catch (IOException e) {
		}
	}
	
	public static String calculateMonthEndDate(int month, int year) {
	    int[] daysInAMonth = { 29, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	    int day = daysInAMonth[month];
	    boolean isLeapYear = new GregorianCalendar().isLeapYear(year);

	    if (isLeapYear && month == 2) {
	        day++;
	    }
	    GregorianCalendar gc = new GregorianCalendar(year, month - 1, day);
	    java.util.Date monthEndDate = new java.util.Date(gc.getTime().getTime());
	    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	    String strDate = format.format(monthEndDate);
	    return strDate;
	}

}
