package Dashboard.Customer_Landing_Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.Customer_Landing_Actions;
import initializer.BaseClass;

public class TC_24_Verify_The_Dashboard_Update_For_DNA_Test_With_Result_Published extends BaseClass{

	Customer_Landing_Actions customer_landing_actions;
	
	@Test
	public void TC_24_Verify_the_dashboard_update_for_DNA_test_with_result_published() throws IOException, InterruptedException {
		customer_landing_actions = new Customer_Landing_Actions(getDriver());
		customer_landing_actions.verifyDashboardUpdateForDnaTestResultsPublished();
	}
}
