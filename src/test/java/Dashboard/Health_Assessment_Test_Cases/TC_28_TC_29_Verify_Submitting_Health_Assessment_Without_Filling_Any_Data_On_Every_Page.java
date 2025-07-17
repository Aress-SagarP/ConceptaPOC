package Dashboard.Health_Assessment_Test_Cases;

import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.Health_Assessment_Actions;
import Test.Tims.Actions_Class.Login_Action;
import initializer.BaseClass;

public class TC_28_TC_29_Verify_Submitting_Health_Assessment_Without_Filling_Any_Data_On_Every_Page extends BaseClass{

	Health_Assessment_Actions health_assessment_actions;
	Login_Action Login_action;
	
	@Test
	public void TC_28_Verify_submitting_health_assessment_without_filling_any_data_on_every_page() throws InterruptedException {
		Login_action = new Login_Action(getDriver());
		Login_action.login_Dashboard2();
		health_assessment_actions = new Health_Assessment_Actions(getDriver());
		health_assessment_actions.verifySubmittingHealthAssessWithoutData();
	}
	
	@Test(dependsOnMethods = "TC_28_Verify_submitting_health_assessment_without_filling_any_data_on_every_page")
	public void TC_29_Verify_error_messages_appear_when_required_fields_are_left_empty() {
		health_assessment_actions = new Health_Assessment_Actions(getDriver());
		health_assessment_actions.verifyErrorMessageDisplayedforEmptyFields();
	}
}
