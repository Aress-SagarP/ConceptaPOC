package Dashboard.Reset_Password_Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.Activate_Test_Kit_Actions;
import Test.Dashboard.Actions_Class.Reset_Password_Actions;
import Test.Dashboard.Locators_Class.Reset_Password_Locators;
import initializer.BaseClass;

public class TC_13_Verify_Screen_Resolution_Size extends BaseClass{
	Reset_Password_Locators reset_password_locators;
	Reset_Password_Actions reset_password_actions;
	
	@Test
	public void TC_13_Verify_screen_resolution_sizes_shows_all_webelements_properly_in_full_desktop() throws IOException, InterruptedException
	{
		reset_password_actions = new Reset_Password_Actions(getDriver());		
		reset_password_actions.screenResolutionSizesShowsAllWebelementsProperly(1920, 1080);
		reset_password_actions.screenResolutionSizesShowsAllWebelementsProperly(1366, 768);
		reset_password_actions.screenResolutionSizesShowsAllWebelementsProperly(768, 1024);
		reset_password_actions.screenResolutionSizesShowsAllWebelementsProperly(375, 667);
		reset_password_actions.screenResolutionSizesShowsAllWebelementsProperly(414, 896);
		
	}

	
}
