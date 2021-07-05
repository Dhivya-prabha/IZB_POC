package hooks;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import corp.pages.CorporateLoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import retail.pages.RetailLoginPage;
import services.WebDriverServiceImpl;
import utils.DataInputProvider;

public class TestNgHooks extends WebDriverServiceImpl{

	@BeforeSuite
	public void beforeSuite() {
		startReport();
	}

	@BeforeClass
	public void beforeClass() {
		startTestCase(testCaseName, testDescription);		
	}

	@BeforeMethod
	public void beforeMethod() throws FileNotFoundException, IOException {

		startTestNode(nodes);

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", System.getProperty("user.dir") + File.separator + "download");
		ChromeOptions options = new ChromeOptions();

		properties.load(new FileInputStream(new File("./src/main/resources/environment.properties")));

		if (properties.getProperty("Headless").equalsIgnoreCase("true"))
			options.setHeadless(true);

		options.addExtensions(new File("./data/extension_0_4_7_0.crx"));

		options.setExperimentalOption("prefs", prefs);
		WebDriverManager.chromedriver().setup();
		webdriver = new ChromeDriver(options);
		driver = new EventFiringWebDriver(webdriver);
		driver.register(this);

		tlDriver.set(driver);
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);

		tlWait.set(wait);
		setLanguage(properties.getProperty("Language"));
		getDriver().manage().window().maximize();

		String URL = "chrome-extension://digfbfaphojjndkpccljibejjbppifbc/popup.html";
		driver.get(URL);
		driver.findElement(By.tagName("input")).click();

		if (nodes.toLowerCase().contains("retail"))
			getDriver().get(properties.getProperty("Retail_URL"));
		else if (nodes.toLowerCase().contains("corporate"))
			getDriver().get(properties.getProperty("Corp_URL"));

		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Parameters({"username","password"})
	@BeforeMethod()
	public void startLogin(String username,String password) {
		if(nodes.toLowerCase().contains("retail"))
			new RetailLoginPage().login(username, password);
		else if(nodes.toLowerCase().contains("corporate"))
			new CorporateLoginPage().login(properties.getProperty("Corp_UserName"), properties.getProperty("Corp_Password"));
	}
	

	@AfterMethod
	public void afterMethod() {
		closeActiveBrowser();
	}

	@AfterSuite
	public void afterSuite() {
		endResult();
	}

	@DataProvider(name="fetchData")
	public  Object[][] getData(){
		return DataInputProvider.readSheet(dataSheetName);		
	}	
	
}
