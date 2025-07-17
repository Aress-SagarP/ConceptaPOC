package Dashboard.Activate_Test_Kit_Test_Cases;

import java.io.IOException;
import org.testng.annotations.Test;
import Test.Dashboard.Actions_Class.Activate_Test_Kit_Actions;
import Test.Dashboard.Locators_Class.Activate_Test_Kit_Locators;
import initializer.BaseClass;


public class TC_29_Verify_To_Edit_Date_After_Activation_Completed extends BaseClass
{

	Activate_Test_Kit_Locators activate_test_kit_locators;
	Activate_Test_Kit_Actions activate_test_kit_Actions;
		
	@Test
	public void TC_29_Verify_to_edit_date_after_activation_completed() throws IOException, InterruptedException
	{
		activate_test_kit_Actions = new Activate_Test_Kit_Actions(getDriver());	
		activate_test_kit_Actions.dashboardUrlOfTims();
		activate_test_kit_Actions.createSingleBarcodeFromTimsToUseInDashboardForEndToEndFlow();
		activate_test_kit_Actions.dashboardUrl();
		activate_test_kit_Actions.toEditDateAfterActivationCompleted();
		
	}


}
