package Dashboard.Customer_Landing_Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.Customer_Landing_Actions;
import initializer.BaseClass;

public class TC_07_TC_13_TC_15_Verify_The_Timeline_For_SH_Test_With_Unconfirmed_Results extends BaseClass {

	Customer_Landing_Actions customer_landing_actions;
	
	@Test
	public void TC_13_Verify_the_display_of_calendly_calendar_with_message_for_SH_tests() throws InterruptedException, IOException {
		customer_landing_actions = new Customer_Landing_Actions(getDriver());
		customer_landing_actions.verifyCalendlyCalendarWithMsg();
	}
	
	@Test(dependsOnMethods = "TC_13_Verify_the_display_of_calendly_calendar_with_message_for_SH_tests")
	public void TC_07_Verify_the_timeline_for_SH_test_with_unconfirmed_results() throws InterruptedException, IOException {
		customer_landing_actions = new Customer_Landing_Actions(getDriver());
		customer_landing_actions.verifyTimelineForBloodSHTest();
	}
	
	@Test(dependsOnMethods = "TC_07_Verify_the_timeline_for_SH_test_with_unconfirmed_results")
	public void TC_15_Verify_the_dashboard_update_after_the_booked_appointment() throws InterruptedException, IOException {
		customer_landing_actions = new Customer_Landing_Actions(getDriver());
		customer_landing_actions.verifySuccsessfulAppointmentBooking();
	}
}
