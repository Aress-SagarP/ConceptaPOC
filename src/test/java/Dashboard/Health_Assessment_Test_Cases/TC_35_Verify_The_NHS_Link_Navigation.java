package Dashboard.Health_Assessment_Test_Cases;

import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.Health_Assessment_Actions;
import Test.Tims.Actions_Class.Login_Action;
import initializer.BaseClass;

public class TC_35_Verify_The_NHS_Link_Navigation extends BaseClass{

	Health_Assessment_Actions health_assessment_actions;
	Login_Action Login_action;
	
	@Test
	public void TC_35_Verify_the_NHS_link_navigation() throws InterruptedException {
		Login_action = new Login_Action(getDriver());
		Login_action.login_Dashboard2();
		health_assessment_actions = new Health_Assessment_Actions(getDriver());
		health_assessment_actions.verifyNHSLinkNav();
	}
}
