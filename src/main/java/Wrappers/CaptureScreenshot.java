package Wrappers;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import initializer.BaseClass;
import initializer.ExtentManager;

public class CaptureScreenshot extends BaseClass{

	public static String captureAndAttachScreenshot(String screenshotName) {
	    WebDriver driverInstance = getDriver();
	    ExtentTest logger = ExtentManager.getTest();

	    try {
	        // Capture Base64 screenshot
	        String base64Screenshot = ((TakesScreenshot) driverInstance).getScreenshotAs(OutputType.BASE64);

	        // Attach screenshot to Extent Report with label
	        if (logger != null && !base64Screenshot.isEmpty()) {
	            logger.addScreenCaptureFromBase64String(base64Screenshot, screenshotName);
	            logger.log(Status.INFO, "Screenshot captured: " + screenshotName);
	        }

	        return base64Screenshot;
	    } catch (Exception e) {
	        if (logger != null) {
	            logger.log(Status.WARNING, "Failed to capture screenshot: " + e.getMessage());
	        }
	        return "";
	    }
	}
}
