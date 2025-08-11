package Dashboard.Customer_Landing_Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.Customer_Landing_Actions;
import initializer.BaseClass;

public class TC_45_TC_43_TC_48_TC_52_Verify_Calendar_UI_for_SH_Consultation extends BaseClass{

	Customer_Landing_Actions customer_landing_actions;
	
	@Test
	public void TC_45_Verify_calendar_ui_for_sh_consultation() throws InterruptedException, IOException {
		customer_landing_actions = new Customer_Landing_Actions(getDriver());
		customer_landing_actions.verifyCalendlyCalendarWithMsg();
	}
	
	@Test(dependsOnMethods = "TC_45_Verify_calendar_ui_for_sh_consultation")
	public void TC_43_Verify_font_consistency() {
		customer_landing_actions = new Customer_Landing_Actions(getDriver());
		customer_landing_actions.verifyFontConsistency();
	}
	
	@Test(dependsOnMethods = "TC_43_Verify_font_consistency")
	public void TC_52_Verify_proper_wrapping_of_long_text() {
		customer_landing_actions = new Customer_Landing_Actions(getDriver());
		customer_landing_actions.verifyWrappingOfLongText();
	}
	
	@Test(dependsOnMethods = "TC_52_Verify_proper_wrapping_of_long_text")
	public void TC_48_Verify_scroll_behavior_for_long_test_summaries() throws InterruptedException {
		customer_landing_actions = new Customer_Landing_Actions(getDriver());
		customer_landing_actions.verifyScrollingForLongTestSummaries();
	}
	
}
