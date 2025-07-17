package Dashboard.Activate_Test_Kit_Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;
import Test.Dashboard.Actions_Class.Activate_Test_Kit_Actions;
import Test.Dashboard.Locators_Class.Activate_Test_Kit_Locators;
import initializer.BaseClass;


public class TC_03_Verify_Error_With_Empty_Fields_For_Barcode_And_Tracking_Number extends BaseClass
{

	Activate_Test_Kit_Locators activate_test_kit_locators;
	Activate_Test_Kit_Actions activate_test_kit_Actions;
	
	
	@Test
	public void TC_03_Verify_error_msg_with_empty_fields_for_barcode_and_tracking_number() throws IOException, InterruptedException
	{
		activate_test_kit_Actions = new Activate_Test_Kit_Actions(getDriver());		
		activate_test_kit_Actions.dashboardUrl();
		activate_test_kit_Actions.errorIfUserAttemptToProceedWithEmptyFieldsForBarcodeAndTrackingNumber();
		
	}

}
