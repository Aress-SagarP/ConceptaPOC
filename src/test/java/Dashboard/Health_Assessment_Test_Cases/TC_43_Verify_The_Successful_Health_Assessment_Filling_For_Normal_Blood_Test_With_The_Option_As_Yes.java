package Dashboard.Health_Assessment_Test_Cases;

import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.Health_Assessment_Actions;
import Test.Tims.Actions_Class.Login_Action;
import initializer.BaseClass;

public class TC_43_Verify_The_Successful_Health_Assessment_Filling_For_Normal_Blood_Test_With_The_Option_As_Yes extends BaseClass {

	Health_Assessment_Actions health_assessment_actions;
	Login_Action Login_action;
	
	@Test
	public void TC_43_Verify_the_successful_health_assessment_filling_for_normal_blood_test_with_the_option_as_Yes() throws InterruptedException {
		Login_action = new Login_Action(getDriver());
		Login_action.login_Dashboard2();
		health_assessment_actions = new Health_Assessment_Actions(getDriver());
		health_assessment_actions.submitConfirmDetailsForm();
		health_assessment_actions.submitAssessmentForm2();
		health_assessment_actions.submitAssessmentForm3();
		health_assessment_actions.submitAssessmentForm4();
		health_assessment_actions.submitAssessmentForm5();
	}
}
