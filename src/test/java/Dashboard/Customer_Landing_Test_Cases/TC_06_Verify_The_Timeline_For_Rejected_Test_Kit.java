package Dashboard.Customer_Landing_Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.Customer_Landing_Actions;
import initializer.BaseClass;

public class TC_06_Verify_The_Timeline_For_Rejected_Test_Kit extends BaseClass{

	Customer_Landing_Actions customer_landing_actions;
	
	@Test
	public void TC_06_Verify_the_timeline_for_rejected_test_kit() throws InterruptedException, IOException {
		customer_landing_actions = new Customer_Landing_Actions(getDriver());
		customer_landing_actions.timelineForRejectedKit();
	}
}
