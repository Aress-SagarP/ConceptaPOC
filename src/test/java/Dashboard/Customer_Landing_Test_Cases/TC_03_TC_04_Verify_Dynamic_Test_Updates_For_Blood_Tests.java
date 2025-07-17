package Dashboard.Customer_Landing_Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.Customer_Landing_Actions;
import initializer.BaseClass;


public class TC_03_TC_04_Verify_Dynamic_Test_Updates_For_Blood_Tests extends BaseClass {

	Customer_Landing_Actions customer_landing_actions;
	
	@Test
	public void TC_03_Verify_dynamic_test_updates_for_blood_tests() throws InterruptedException, IOException {
		customer_landing_actions = new Customer_Landing_Actions(getDriver());
		customer_landing_actions.verifyDynamicTimelineUpdate();
	}
	
	@Test(dependsOnMethods = "TC_03_Verify_dynamic_test_updates_for_blood_tests")
	public void TC_04_Verify_The_Timeline_For_Completed_Steps_Of_Test_Kit() {
		customer_landing_actions = new Customer_Landing_Actions(getDriver());
		customer_landing_actions.verifyTimelineForCompletedTestSteps();
	}
}
