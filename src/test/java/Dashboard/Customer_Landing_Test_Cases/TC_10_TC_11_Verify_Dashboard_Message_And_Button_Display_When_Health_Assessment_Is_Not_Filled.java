package Dashboard.Customer_Landing_Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.Customer_Landing_Actions;
import initializer.BaseClass;

public class TC_10_TC_11_Verify_Dashboard_Message_And_Button_Display_When_Health_Assessment_Is_Not_Filled extends BaseClass {

	Customer_Landing_Actions customer_landing_actions;
	
	@Test
	public void TC_10_Verify_dashboard_message_and_button_display_when_health_Assessment_is_not_filled() throws InterruptedException, IOException {
		customer_landing_actions = new Customer_Landing_Actions(getDriver());
		customer_landing_actions.verifyFillAssemetBtnIsDisplayed();
	}
	
	@Test
	public void TC_11_Verify_dashboard_message_and_button_display_when_health_assessment_is_filled() throws InterruptedException {
		customer_landing_actions = new Customer_Landing_Actions(getDriver());
		customer_landing_actions.verifyEditAssessBtnWhenHAFilled();
	}
}
