package Dashboard.Customer_Landing_Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.Customer_Landing_Actions;
import initializer.BaseClass;

public class TC_20_TC_30_Verify_Report_View_Functionality extends BaseClass {

	Customer_Landing_Actions customer_landing_actions;
	
	@Test
	public void TC_20_Verify_report_view_functionality() throws IOException, InterruptedException {
		customer_landing_actions = new Customer_Landing_Actions(getDriver());
		customer_landing_actions.verifyReportViewFunctionality();
	}
	
	@Test(dependsOnMethods = "TC_20_Verify_report_view_functionality")
	public void TC_30_Verify_pictorial_scale_in_detailed_report() throws Exception {
		customer_landing_actions = new Customer_Landing_Actions(getDriver());
		customer_landing_actions.verifyBiomarkerDetailsSHTest();
	}
	
	
}
