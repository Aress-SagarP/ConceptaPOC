package Dashboard.Customer_Landing_Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.Customer_Landing_Actions;
import initializer.BaseClass;

public class TC_08_TC_09_Verify_Timeline_For_DNA_Tests extends BaseClass{

	Customer_Landing_Actions customer_landing_actions;
	
	@Test
	public void TC_08_Verify_timeline_for_DNA_tests() throws IOException, InterruptedException {
		customer_landing_actions = new Customer_Landing_Actions(getDriver());
		customer_landing_actions.verifyTimelineForDnaTests();
	}
	
	@Test(dependsOnMethods = "TC_08_Verify_timeline_for_DNA_tests")
	public void TC_09_Verify_timeline_for_rejected_DNA_sample() throws IOException, InterruptedException {
		customer_landing_actions = new Customer_Landing_Actions(getDriver());
		customer_landing_actions.verifyTimelineForRejectedDNATest();
	}
}
