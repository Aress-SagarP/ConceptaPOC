package Dashboard.Customer_Landing_Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.Customer_Landing_Actions;
import initializer.BaseClass;

public class TC_41_TC_54_Verify_Timeline_Icon_Design extends BaseClass{
	
	Customer_Landing_Actions customer_landing_actions;
	
	@Test
	public void TC_41_Verify_timeline_icon_design() throws IOException, InterruptedException {
		customer_landing_actions = new Customer_Landing_Actions(getDriver());
		customer_landing_actions.timelineForRejectedKit();
	}
	
	@Test(dependsOnMethods = "TC_41_Verify_timeline_icon_design")
	public void TC_54_Verify_visual_consistency_of_timeline_steps_across_tests() {
		customer_landing_actions = new Customer_Landing_Actions(getDriver());
		customer_landing_actions.visualConsistencyOfTimelineSteps();
	}
}
