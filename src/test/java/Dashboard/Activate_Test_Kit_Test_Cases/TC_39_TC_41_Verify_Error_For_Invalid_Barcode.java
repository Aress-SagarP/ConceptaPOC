package Dashboard.Activate_Test_Kit_Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.Activate_Test_Kit_Actions;
import Test.Dashboard.Locators_Class.Activate_Test_Kit_Locators;
import initializer.BaseClass;

public class TC_39_TC_41_Verify_Error_For_Invalid_Barcode extends BaseClass
{

	Activate_Test_Kit_Locators activate_test_kit_locators;
	Activate_Test_Kit_Actions activate_test_kit_Actions;
		
	@Test
	public void TC_41_Verify_error_msg_for_invalid_barcode() throws IOException, InterruptedException
	{
		activate_test_kit_Actions = new Activate_Test_Kit_Actions(getDriver());		
		activate_test_kit_Actions.dashboardUrl();
		activate_test_kit_Actions.errorMsgForInvalidBarcode();
		
	}
	
	@Test(dependsOnMethods = "TC_41_Verify_error_msg_for_invalid_barcode" )
	public void TC_39_Verify_system_does_not_show_sensitive_information_in_error_message() throws IOException, InterruptedException {
		activate_test_kit_Actions = new Activate_Test_Kit_Actions(getDriver());		
		activate_test_kit_Actions.sensitiveInfoNotDisplayed();
	}


}
