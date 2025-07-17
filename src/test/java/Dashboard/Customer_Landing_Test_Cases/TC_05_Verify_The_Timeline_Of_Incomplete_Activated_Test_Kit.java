package Dashboard.Customer_Landing_Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.Customer_Landing_Actions;
import initializer.BaseClass;

public class TC_05_Verify_The_Timeline_Of_Incomplete_Activated_Test_Kit extends BaseClass{

	Customer_Landing_Actions customer_landing_actions;
	
	@Test
	public void TC_05_Verify_the_timeline_of_incomplete_activated_test_kit() throws InterruptedException, IOException {
		customer_landing_actions = new Customer_Landing_Actions(getDriver());
		customer_landing_actions.incompleteTestKitActivation();
	}
}
