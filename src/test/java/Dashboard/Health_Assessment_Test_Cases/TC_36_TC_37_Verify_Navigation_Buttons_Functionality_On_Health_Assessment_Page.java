package Dashboard.Health_Assessment_Test_Cases;

import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.Health_Assessment_Actions;
import Test.Tims.Actions_Class.Login_Action;
import initializer.BaseClass;

public class TC_36_TC_37_Verify_Navigation_Buttons_Functionality_On_Health_Assessment_Page extends BaseClass {

	Health_Assessment_Actions health_assessment_actions;
	Login_Action Login_action;
	
	@Test
	public void TC_36_Verify_navigation_buttons_functionality_on_health_assessment_page() throws InterruptedException {
		Login_action = new Login_Action(getDriver());
		Login_action.login_Dashboard2();
		health_assessment_actions = new Health_Assessment_Actions(getDriver());
		health_assessment_actions.submitConfirmDetailsForm();
		health_assessment_actions.navigationFuncHealthAssessment();
	}
	
	@Test(dependsOnMethods = "TC_36_Verify_navigation_buttons_functionality_on_health_assessment_page")
	public void TC_37_Verify_a_progress_bar_is_displayed_if_the_health_assessment_is_multi_page() {
		health_assessment_actions.verifyProgressBarIsDisplayed();
	}
}
