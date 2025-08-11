package Dashboard.Customer_Landing_Test_Cases;

import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.Customer_Landing_Actions;
import Test.Tims.Actions_Class.Login_Action;
import initializer.BaseClass;

public class TC_42_Verify_Button_Styles_And_Visibility extends BaseClass {
	
	Customer_Landing_Actions customer_landing_actions;
	Login_Action Login_action;
	
	@Test
	public void TC_42_Verify_button_styles_and_visibility() throws InterruptedException {
		Login_action = new Login_Action(getDriver());
		Login_action.login_Dashboard2();
		customer_landing_actions = new Customer_Landing_Actions(getDriver());
		customer_landing_actions.verifyVisibilityOfButtons();
	}
}
