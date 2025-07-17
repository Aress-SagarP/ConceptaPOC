package Dashboard.Health_Assessment_Test_Cases;

import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.Health_Assessment_Actions;
import Test.Tims.Actions_Class.Login_Action;
import initializer.BaseClass;

public class TC_41_Verify_That_All_Input_Fields_In_The_Health_Assessment_Form_Have_Appropriate_Placeholder_Text extends BaseClass {

	Health_Assessment_Actions health_assessment_actions;
	Login_Action Login_action;
	
	@Test
	public void TC_41_Verify_that_all_input_fields_in_the_health_assessment_form_have_appropriate_placeholder_text() throws InterruptedException {
		Login_action = new Login_Action(getDriver());
		Login_action.login_Dashboard2();
		health_assessment_actions = new Health_Assessment_Actions(getDriver());
		health_assessment_actions.submitConfirmDetailsForm();
		health_assessment_actions.verifyPlaceholderIsPresent();
	}
}
