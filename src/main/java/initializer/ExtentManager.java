package initializer;

import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {
    private static ThreadLocal<ExtentTest> testThreadLocal = new ThreadLocal<>();

    public static void setTest(ExtentTest test) {
        testThreadLocal.set(test);
    }

    public static ExtentTest getTest() {
        return testThreadLocal.get();
    }
}
