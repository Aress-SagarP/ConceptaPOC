package Dashboard.Customer_Landing_Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.Customer_Landing_Actions;
import initializer.BaseClass;

public class TC_26_Verify_That_The_Fill_Or_Edit_Assessment_Functionality_After_Result_Upload extends BaseClass{

	Customer_Landing_Actions customer_landing_actions;
	
	@Test
	public void TC_26_Verify_that_the_fill_or_edit_assessment_functionality_after_result_upload() throws InterruptedException, IOException {
		customer_landing_actions = new Customer_Landing_Actions(getDriver());
		customer_landing_actions.verifyFillEditAssessBtnAfterResultUpload();
	}
}
