package Dashboard.Customer_Landing_Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.Customer_Landing_Actions;
import Test.Dashboard.Actions_Class.Health_Assessment_Actions;
import Test.Tims.Actions_Class.Login_Action;
import initializer.BaseClass;

public class TC_53_TC_44_Verify_Highlighting_Of_Error_Messages_In_Dashboard extends BaseClass{

	Customer_Landing_Actions customer_landing_actions;
	Health_Assessment_Actions health_assessment_actions;
	Login_Action Login_action;
	
	@Test
	public void TC_53_Verify_highlighting_of_error_messages_in_dashboard() throws IOException, InterruptedException {
		Login_action = new Login_Action(getDriver());
		Login_action.login_Dashboard2();
		health_assessment_actions = new Health_Assessment_Actions(getDriver());
		health_assessment_actions.verifySubmittingHealthAssessWithoutData();
		
	}
	
	@Test(dependsOnMethods = "TC_53_Verify_highlighting_of_error_messages_in_dashboard")
	public void TC_44_Verify_Error_Message_UI() {
		customer_landing_actions = new Customer_Landing_Actions(getDriver());
		customer_landing_actions.verifyErrorMessageUI();
	}
}
