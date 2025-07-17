package Dashboard.Customer_Landing_Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.Customer_Landing_Actions;
import initializer.BaseClass;

public class TC_22_TC_23_TC_25_Verify_Timeline_Update_For_DNA_Tests extends BaseClass{
	
	Customer_Landing_Actions customer_landing_actions;
	
	@Test
	public void TC_22_Verify_timeline_update_for_DNA_tests() throws IOException, InterruptedException {
		customer_landing_actions = new Customer_Landing_Actions(getDriver());
		customer_landing_actions.verifyTimelineForDnaTests();
		customer_landing_actions.verifyTimelineForRejectedDNATest();
	} 
	
	@Test(dependsOnMethods = "TC_22_Verify_timeline_update_for_DNA_tests")
	public void TC_23_Verify_test_summary_details_and_updates_for_DNA_test_with_result_not_published() {
		customer_landing_actions = new Customer_Landing_Actions(getDriver());
		customer_landing_actions.verifyTestSummaryForDNATest();
	}
	
	@Test(dependsOnMethods = "TC_23_Verify_test_summary_details_and_updates_for_DNA_test_with_result_not_published")
	public void TC_25_Verify_Dynamic_Test_Updates_For_DNA_Tests() {
		customer_landing_actions = new Customer_Landing_Actions(getDriver());
		customer_landing_actions.verifyDynamicTestUpdatesDNATests();
	}

}
