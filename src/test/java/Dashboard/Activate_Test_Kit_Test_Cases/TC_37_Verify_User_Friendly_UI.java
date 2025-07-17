package Dashboard.Activate_Test_Kit_Test_Cases;

import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.Activate_Test_Kit_Actions;
import Test.Dashboard.Locators_Class.Activate_Test_Kit_Locators;
import initializer.BaseClass;

public class TC_37_Verify_User_Friendly_UI extends BaseClass
{
	Activate_Test_Kit_Locators activate_test_kit_locators;
	Activate_Test_Kit_Actions activate_test_kit_Actions;		
		
	@Test
	public void TC_37_Verify_user_friendly_UI() throws Exception
	{
		activate_test_kit_Actions = new Activate_Test_Kit_Actions(getDriver());	
		activate_test_kit_Actions.dashboardUrl();
		activate_test_kit_Actions.userFriendlyUI();
	}

}
