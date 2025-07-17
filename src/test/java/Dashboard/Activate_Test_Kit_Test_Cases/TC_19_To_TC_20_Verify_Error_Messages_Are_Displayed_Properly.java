package Dashboard.Activate_Test_Kit_Test_Cases;

import java.io.IOException;
import org.testng.annotations.Test;
import Test.Dashboard.Actions_Class.Activate_Test_Kit_Actions;
import Test.Dashboard.Locators_Class.Activate_Test_Kit_Locators;
import initializer.BaseClass;

public class TC_19_To_TC_20_Verify_Error_Messages_Are_Displayed_Properly extends BaseClass
{

	Activate_Test_Kit_Locators activate_test_kit_locators;
	Activate_Test_Kit_Actions activate_test_kit_Actions;
		
	@Test
	public void TC_19_Verify_error_msg_displayed_properly() throws IOException, InterruptedException
	{
		activate_test_kit_Actions = new Activate_Test_Kit_Actions(getDriver());		
		activate_test_kit_Actions.dashboardUrlOfTims();
		activate_test_kit_Actions.createSingleBarcodeFromTimsToUseInDashboardForEndToEndFlow();
		activate_test_kit_Actions.dashboardUrl();
		activate_test_kit_Actions.errorMsgDisplayedProperly();
		
	}

	@Test(dependsOnMethods = "TC_19_Verify_error_msg_displayed_properly")
	public void TC_20_Verify_error_msg_displayed_when_entered_long_characters_for_personal_details() throws IOException, InterruptedException
	{
		activate_test_kit_Actions = new Activate_Test_Kit_Actions(getDriver());		
		activate_test_kit_Actions.errorMsgDisplayedWhenEnteredLongCharactersForPersonalDetails();
		
	}
}
