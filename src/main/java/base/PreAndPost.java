package base;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.DataInputProvider;

public class PreAndPost extends AbstractTestNGCucumberTests{

	public static ExtentReports extent;
	public static ExtentHtmlReporter html;
	public String fileName, testCaseName, testDes, category, author, module;  
	public ExtentTest test;

	private static final ThreadLocal<ChromeDriver> driver = new ThreadLocal<ChromeDriver>();
	private static final ThreadLocal<ExtentTest> node = new ThreadLocal<ExtentTest>();

	@BeforeSuite
	public void name() {
		html = new ExtentHtmlReporter("./reports/result.html");
		html.setAppendExisting(true);
		extent = new ExtentReports();
		extent.attachReporter(html);
	}

	protected ChromeDriver getDriver() {
		return driver.get();
	}

	protected ExtentTest getNode() {
		return node.get();
	}

	@BeforeClass
	public void preScript() {
		test = extent.createTest(testCaseName, testDes);
		test.assignCategory(category);
		test.assignAuthor(author);
	}

	public long takeSnap() {
		long number = 10000000L;
		try {
			number = (long)Math.floor((Math.random() * 90000000L) + 10000000L);
			File src = getDriver().getScreenshotAs(OutputType.FILE);
			File des = new File("./reports/snaps/img"+number+".png");
			FileUtils.copyFile(src, des);
			return number;
		} catch (IOException e) {
		}
		return number;
	}


	public void reportStep(String desc, String status) {
		try {
			if (status.equalsIgnoreCase("pass")) {
				getNode().pass(desc, MediaEntityBuilder.createScreenCaptureFromPath("./../reports/snaps/img"+takeSnap()+".png").build());
			} else {
				getNode().fail(desc, MediaEntityBuilder.createScreenCaptureFromPath("./../reports/snaps/img"+takeSnap()+".png").build());
			}
		} catch (IOException e) {
		}
	}



	@AfterSuite
	public void postScript() {
		extent.flush();
	}


	@BeforeMethod
	public void startApp () {
		node.set(test.createNode(module));
		WebDriverManager.chromedriver().setup();
		driver.set(new ChromeDriver());
		getDriver().get("http://leaftaps.com/opentaps/control/main");
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void closeApp() {
		getDriver().close();
	}

	@DataProvider(parallel=true) // @Factory !!
	public Object[][] getData() throws IOException {
		return DataInputProvider.readSheet(fileName);
	}

	



}
