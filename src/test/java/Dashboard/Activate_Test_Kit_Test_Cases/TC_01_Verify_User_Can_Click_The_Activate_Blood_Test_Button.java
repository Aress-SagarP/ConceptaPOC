package Dashboard.Activate_Test_Kit_Test_Cases;

import org.testng.annotations.Test;
import Test.Dashboard.Actions_Class.Activate_Test_Kit_Actions;
import Test.Dashboard.Locators_Class.Activate_Test_Kit_Locators;
import initializer.BaseClass;

public class TC_01_Verify_User_Can_Click_The_Activate_Blood_Test_Button extends BaseClass
{

	Activate_Test_Kit_Locators activate_test_kit_locators;
	Activate_Test_Kit_Actions activate_test_kit_Actions;
	
	
	@Test
	public void TC_01_Verify_user_can_click_the_activate_blood_test_button_and_redirect_to_next_page() throws Exception
	{				
		activate_test_kit_Actions = new Activate_Test_Kit_Actions(getDriver());		
		activate_test_kit_Actions.dashboardUrl();
		activate_test_kit_Actions.userCanClickTheActivateBloodTestButton();
		
    }
}