package Dashboard.Activate_Test_Kit_Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.Activate_Test_Kit_Actions;
import Test.Dashboard.Locators_Class.Activate_Test_Kit_Locators;
import initializer.BaseClass;

public class TC_43_Additional_Verify_The_Postage_Tracking_Number_Auto_Population extends BaseClass{

	Activate_Test_Kit_Locators activate_test_kit_locators;
	Activate_Test_Kit_Actions activate_test_kit_Actions;
	
	@Test
	public void TC_43_Additional_Verify_the_postage_tracking_number_auto_population() throws InterruptedException, IOException {
		activate_test_kit_Actions = new Activate_Test_Kit_Actions(getDriver());
		activate_test_kit_Actions.dashboardUrlOfTims();
		activate_test_kit_Actions.verifyTrackingNumIsAutoPopulated();
	}
}
