package initializer;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;


import Wrappers.BrowserFactory;
import Wrappers.ExtractHTMLTable;
import Wrappers.WebCommonPath;
import dataSources.PropertiesReader;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BaseClass {

	public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
	private static ThreadLocal<String> username = new ThreadLocal<>();
	public static ExtentReports report;
	protected static String environment;

	@BeforeSuite(alwaysRun = true)
	public void beforeSuite(ITestContext context) {
		List<ViewName> viewOrder = Arrays.asList(ViewName.DASHBOARD, ViewName.TEST, ViewName.CATEGORY,
				ViewName.EXCEPTION, ViewName.AUTHOR, ViewName.DEVICE);
		
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(WebCommonPath.extentReportPath);
		sparkReporter.viewConfigurer().viewOrder().as(viewOrder).apply();
		sparkReporter.config().setTheme(Theme.STANDARD);
		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setReportName("Test Report");

		report = new ExtentReports();
		report.attachReporter(sparkReporter);
		report.setSystemInfo("User Name", "Aress");
		report.setSystemInfo("Environment", "Staging");

		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			if (report != null) {
				report.flush();
			}
		}));
	}

	@BeforeClass(alwaysRun = true)
	public void beforeClass(ITestContext context) throws IOException {
		String headlessParam = context.getSuite().getParameter("headless");
		boolean isHeadless = headlessParam != null && Boolean.parseBoolean(headlessParam);

		String browser = context.getCurrentXmlTest().getParameter("browser");
		if (browser == null) {
			browser = PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "browser");
		}

		driver.set(BrowserFactory.setBrowser(browser, isHeadless));

		if (!isHeadless) {
			getDriver().manage().window().maximize();
		}
		
		getDriver().manage().deleteAllCookies();
		
		String category = (String) context.getAttribute("category");
		if (category != null) {
			assignTestCategory(category);
		}
	}

	@BeforeMethod(alwaysRun = true)
	public void beforeEachMethod(Method testMethod) {
		ExtentTest test = report.createTest(testMethod.getName())
				.assignAuthor("Concepta")
				.assignDevice("Windows");

		extentTest.set(test);
		ExtentManager.setTest(test);
		ExtentManager.getTest().log(Status.INFO, "Test started: " + testMethod.getName());
		System.out.println();
		System.out.println("Test started: " + testMethod.getName());
	}

	@AfterMethod(alwaysRun = true)
	public void afterEachMethod(ITestResult result) {
		WebDriver driverInstance = getDriver();
		ExtentTest logger = ExtentManager.getTest();

		try {
			String screenshot = captureScreenshot(driverInstance);

			if (result.getStatus() == ITestResult.FAILURE) {
				logger.log(Status.FAIL, "Test Case Failed: " + result.getName());
				logger.log(Status.FAIL, "Error: " + result.getThrowable());
				if (!screenshot.isEmpty()) {
					logger.addScreenCaptureFromBase64String(screenshot, "Failure Screenshot");
				}
			} else if (result.getStatus() == ITestResult.SUCCESS) {
				logger.log(Status.PASS, "Test Case Passed: " + result.getName());
				if (!screenshot.isEmpty()) {
					logger.addScreenCaptureFromBase64String(screenshot, "Success Screenshot");
				}
			} else if (result.getStatus() == ITestResult.SKIP) {
				logger.log(Status.SKIP, "Test Case Skipped: " + result.getName());
			}
		} catch (Exception e) {
			if (logger != null) {
				logger.log(Status.WARNING, "Exception while capturing screenshot: " + e.getMessage());
			}
		} finally {
			extentTest.remove();
			//report.flush();
		}
	}
	

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		WebDriver driverInstance = getDriver();
		if (driverInstance != null) {
			//driverInstance.quit();
		}
		driver.remove();
	}

	@AfterSuite(alwaysRun = true)
	public void afterSuite() {
		if (report != null) {
			report.flush();
			ExtractHTMLTable.extractTestResultsTable(ExtractHTMLTable.GetReportPath(), WebCommonPath.HTMLOUTPUT_PATH);
	    }
			
	}

	protected void assignTestCategory(String category) {
		ExtentManager.getTest().assignCategory(category);
	}

	private String captureScreenshot(WebDriver driver) {
		try {
			return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		} catch (Exception e) {
			ExtentManager.getTest().log(Status.WARNING, "Failed to capture screenshot: " + e.getMessage());
			return "";
		}
	}

	public String determineUrlKey(String environment) throws IOException {
		switch (environment) {
			case "dashboard_staging":
				return PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "dashboard_staging_url");
			case "HCP":
				return PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "HCP_url");
			case "HCP_staging":
				return PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "HCP_staging_url_");
			case "tims_URL_For_SH":
				return PropertiesReader.getPropertyValue(WebCommonPath.testDatafileTims, "tims_URL_For_SH");
			case "tims_URL_For_Dashboard":
				return PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "tims_URL_For_Dashboard");
			case "dashboard_dev":
				return PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "dashboard_dev_url");
			case "dashboard_automation_resetpassword_staging":
				return PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "dashboard_automation_resetpassword_staging");	
			case "Tims_dev":
				return PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Tims_url_dev");
			default:
				throw new IllegalArgumentException("Invalid environment specified: " + environment);
		}
	}

	public static WebDriver getDriver() {
		return driver.get();
	}
}

