package Dashboard.Customer_Landing_Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.Customer_Landing_Actions;
import initializer.BaseClass;

public class TC_02_Verify_The_Display_Correct_Timeline_Statuses_Icons_For_Test_Kits extends BaseClass {

	Customer_Landing_Actions customer_landing_actions;
	
	@Test
	public void TC_02_Verify_the_display_correct_timeline_statuses_icons_for_test_kits() throws InterruptedException, IOException {
		customer_landing_actions = new Customer_Landing_Actions(getDriver());
		customer_landing_actions.verifyTimelineStatuses();
	}
}
