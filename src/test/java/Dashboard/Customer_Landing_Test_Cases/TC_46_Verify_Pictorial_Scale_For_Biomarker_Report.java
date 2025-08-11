package Dashboard.Customer_Landing_Test_Cases;

import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.Customer_Landing_Actions;
import initializer.BaseClass;

public class TC_46_Verify_Pictorial_Scale_For_Biomarker_Report extends BaseClass{

	Customer_Landing_Actions customer_landing_actions;
	
	@Test
	public void TC_46_Verify_pictorial_scale_for_biomarker_report() throws Exception {
		customer_landing_actions = new Customer_Landing_Actions(getDriver());
		customer_landing_actions.verifyReportViewFunctionality();
		customer_landing_actions.verifyBiomarkerDetailsSHTest();
	}
}
