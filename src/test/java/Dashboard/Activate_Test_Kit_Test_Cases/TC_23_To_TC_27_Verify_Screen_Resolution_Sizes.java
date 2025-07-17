package Dashboard.Activate_Test_Kit_Test_Cases;

import java.io.IOException;
import org.testng.annotations.Test;
import Test.Dashboard.Actions_Class.Activate_Test_Kit_Actions;
import Test.Dashboard.Locators_Class.Activate_Test_Kit_Locators;
import initializer.BaseClass;


public class TC_23_To_TC_27_Verify_Screen_Resolution_Sizes extends BaseClass
{

	Activate_Test_Kit_Locators activate_test_kit_locators;
	Activate_Test_Kit_Actions activate_test_kit_Actions;
		
	@Test
	public void TC_23_Verify_screen_resolution_sizes_shows_all_webelements_properly_in_full_desktop() throws IOException, InterruptedException
	{
		activate_test_kit_Actions = new Activate_Test_Kit_Actions(getDriver());		
		activate_test_kit_Actions.screenResolutionSizesShowsAllWebelementsProperly(1920, 1080);
		
	}

	@Test
	public void TC_24_Verify_screen_resolution_sizes_shows_all_webelements_properly_in_laptop() throws IOException, InterruptedException
	{
		activate_test_kit_Actions = new Activate_Test_Kit_Actions(getDriver());		
		activate_test_kit_Actions.screenResolutionSizesShowsAllWebelementsProperly(1366, 768);
		
	}
	
	@Test
	public void TC_25_Verify_screen_resolution_sizes_shows_all_webelements_properly_in_tablet() throws IOException, InterruptedException
	{
		activate_test_kit_Actions = new Activate_Test_Kit_Actions(getDriver());		
		activate_test_kit_Actions.screenResolutionSizesShowsAllWebelementsProperly(768, 1024);
		
	}
	
	@Test
	public void TC_26_Verify_screen_resolution_sizes_shows_all_webelements_properly_in_iPhone8() throws IOException, InterruptedException
	{
		activate_test_kit_Actions = new Activate_Test_Kit_Actions(getDriver());		
		activate_test_kit_Actions.screenResolutionSizesShowsAllWebelementsProperly(375, 667);
		
	}

	@Test
	public void TC_27_Verify_screen_resolution_sizes_shows_all_webelements_properly_in_iPhoneXR() throws IOException, InterruptedException
	{
		activate_test_kit_Actions = new Activate_Test_Kit_Actions(getDriver());		
		activate_test_kit_Actions.screenResolutionSizesShowsAllWebelementsProperly(414, 896);
		
	}
}
