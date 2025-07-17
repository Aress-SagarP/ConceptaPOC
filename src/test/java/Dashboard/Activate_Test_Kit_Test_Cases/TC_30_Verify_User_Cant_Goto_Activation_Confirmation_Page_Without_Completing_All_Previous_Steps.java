package Dashboard.Activate_Test_Kit_Test_Cases;

import java.io.IOException;
import org.testng.annotations.Test;
import Test.Dashboard.Actions_Class.Activate_Test_Kit_Actions;
import Test.Dashboard.Locators_Class.Activate_Test_Kit_Locators;
import initializer.BaseClass;


public class TC_30_Verify_User_Cant_Goto_Activation_Confirmation_Page_Without_Completing_All_Previous_Steps extends BaseClass
{
	Activate_Test_Kit_Locators activate_test_kit_locators;
	Activate_Test_Kit_Actions activate_test_kit_Actions;		
	@Test
	public void TC_30_Verify_user_cant_goto_activation_confirmation_page_without_completing_all_previous_steps() throws IOException, InterruptedException
	{
		activate_test_kit_Actions = new Activate_Test_Kit_Actions(getDriver());	
		activate_test_kit_Actions.dashboardUrlOfTims();
		activate_test_kit_Actions.createSingleBarcodeFromTimsToUseInDashboardForEndToEndFlow();
		activate_test_kit_Actions.userCantGotoActivationConfirmationPageWithoutCompletingAllPreviousSteps();
	}
}
