package Dashboard.Activate_Test_Kit_Test_Cases;

import java.io.IOException;
import org.testng.annotations.Test;
import Test.Dashboard.Actions_Class.Activate_Test_Kit_Actions;
import Test.Dashboard.Locators_Class.Activate_Test_Kit_Locators;
import initializer.BaseClass;

public class TC_31_Verify_No_Data_Remians_On_Screen_If_Browser_Back_Is_Used_After_Logout extends BaseClass
{

	Activate_Test_Kit_Locators activate_test_kit_locators;
	Activate_Test_Kit_Actions activate_test_kit_Actions;
		
	@Test
	public void TC_30_Verify_user_cant_goto_activation_confirmation_page_without_completing_all_previous_steps() throws IOException, InterruptedException
	{
		activate_test_kit_Actions = new Activate_Test_Kit_Actions(getDriver());	
		activate_test_kit_Actions.dashboardUrl();
		activate_test_kit_Actions.noDataRemiansOnScreenIfBrowserBackIsUsedAfterLogout();
		
	}
}
