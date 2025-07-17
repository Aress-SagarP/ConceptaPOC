package Dashboard.Customer_Landing_Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.Customer_Landing_Actions;
import initializer.BaseClass;

public class TC_21_TC_29_TC_31_Verify_Test_Summary_For_Blood_Test extends BaseClass{
	
	Customer_Landing_Actions customer_landing_actions;
	
	@Test
	public void TC_21_Verify_test_summary_for_blood_test() throws InterruptedException, IOException {
		customer_landing_actions = new Customer_Landing_Actions(getDriver());
		customer_landing_actions.verifyTestSummaryBloodTest();
	}
	
	@Test(dependsOnMethods = "TC_21_Verify_test_summary_for_blood_test")
	public void TC_31_Verify_dashboard_data_persistence_on_reload() throws InterruptedException {
		customer_landing_actions = new Customer_Landing_Actions(getDriver());
		customer_landing_actions.verifyDataPersistsOnPageRefresh();
	}
	
	@Test(dependsOnMethods = "TC_31_Verify_dashboard_data_persistence_on_reload")
	public void TC_29_Verify_correct_display_of_gender_at_birth_in_blood_test_summary() {
		customer_landing_actions = new Customer_Landing_Actions(getDriver());
		customer_landing_actions.verifyGenderAtBirthOnTestSummary();
	}

}
