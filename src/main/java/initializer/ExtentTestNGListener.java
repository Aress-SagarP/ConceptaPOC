package initializer;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ExtentTestNGListener implements ITestListener {
	@Override
	public void onTestSkipped(ITestResult result) {
		// Only create the test if not already created (e.g., due to skipped
		// @BeforeMethod)
		ExtentTest test = BaseClass.report.createTest(result.getMethod().getMethodName()).assignAuthor("Concepta")
				.assignDevice("Windows");

		test.log(Status.SKIP, "Test Case Skipped: " + result.getName());

		if (result.getThrowable() != null) {
			test.log(Status.SKIP, "Reason: " + result.getThrowable().getMessage());
		}

		// Assign category if present
		Object category = result.getTestContext().getAttribute("category");
		if (category != null) {
			test.assignCategory(category.toString());
		}

		BaseClass.report.flush();
	}

}
