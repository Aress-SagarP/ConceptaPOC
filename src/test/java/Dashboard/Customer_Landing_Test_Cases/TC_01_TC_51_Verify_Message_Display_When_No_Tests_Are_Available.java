package Dashboard.Customer_Landing_Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.Customer_Landing_Actions;
import Test.Dashboard.Actions_Class.Login_Boot_Actions;
import initializer.BaseClass;

public class TC_01_TC_51_Verify_Message_Display_When_No_Tests_Are_Available extends BaseClass {
	
	Customer_Landing_Actions customer_landing_actions;
	Login_Boot_Actions login_boot_actions;
	
	@Test
	public void TC_01_Verify_message_display_when_no_tests_are_available() throws IOException {
		login_boot_actions = new Login_Boot_Actions(getDriver());
		login_boot_actions.bootUrl();
		customer_landing_actions = new Customer_Landing_Actions(getDriver());
		customer_landing_actions.verifyMessageDisplayedWhenNoTestAvailable();
	}
	
	@Test(dependsOnMethods = "TC_01_Verify_message_display_when_no_tests_are_available")
	public void TC_51_Verify_dashboards_empty_state() {
		customer_landing_actions = new Customer_Landing_Actions(getDriver());
		customer_landing_actions.verifyDashboardEmptyState();
	}

}
