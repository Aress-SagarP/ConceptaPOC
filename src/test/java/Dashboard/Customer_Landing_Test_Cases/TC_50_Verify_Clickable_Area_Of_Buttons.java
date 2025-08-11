package Dashboard.Customer_Landing_Test_Cases;

import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.Customer_Landing_Actions;
import Test.Tims.Actions_Class.Login_Action;
import initializer.BaseClass;

public class TC_50_Verify_Clickable_Area_Of_Buttons extends BaseClass {

	Customer_Landing_Actions customer_landing_actions;
	Login_Action Login_action;
	
	@Test
	public void TC_50_Verify_clickable_area_of_buttons() throws InterruptedException {
		Login_action = new Login_Action(getDriver());
		Login_action.login_Dashboard2();
		customer_landing_actions = new Customer_Landing_Actions(getDriver());
		customer_landing_actions.verifyClickableAreaOfButton();
	}
}
