package Dashboard.Activate_Test_Kit_Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;
import Test.Dashboard.Actions_Class.Activate_Test_Kit_Actions;
import Test.Dashboard.Locators_Class.Activate_Test_Kit_Locators;
import initializer.BaseClass;

public class TC_06_Verify_Error_For_Already_Used_Barcode extends BaseClass
{

	Activate_Test_Kit_Locators activate_test_kit_locators;
	Activate_Test_Kit_Actions activate_test_kit_Actions;
	
	@Test
	public void TC_06_Verify_error_for_already_used_barcode() throws IOException, InterruptedException
	{
		activate_test_kit_Actions = new Activate_Test_Kit_Actions(getDriver());		
		activate_test_kit_Actions.dashboardUrl();		
		activate_test_kit_Actions.errorForAlreadyUsedBarcode();
		
	}

}
