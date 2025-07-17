package Dashboard.Customer_Landing_Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.Customer_Landing_Actions;
import initializer.BaseClass;

public class TC_28_Verify_Fill_Assessment_Functionality_After_Result_Upload_For_Hormone_Test extends BaseClass {

	Customer_Landing_Actions customer_landing_actions;
	
	@Test
	public void TC_28_Verify_fill_assessment_functionality_after_result_upload_for_hormone_test() throws IOException, InterruptedException {
		customer_landing_actions = new Customer_Landing_Actions(getDriver());
		customer_landing_actions.verifyFillAssessmentAfterResultUploadBHT();
	}
}
