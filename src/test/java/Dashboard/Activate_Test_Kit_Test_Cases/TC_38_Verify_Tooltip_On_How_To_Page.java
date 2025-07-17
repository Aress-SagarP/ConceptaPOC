package Dashboard.Activate_Test_Kit_Test_Cases;

import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.Activate_Test_Kit_Actions;
import Test.Dashboard.Locators_Class.Activate_Test_Kit_Locators;
import initializer.BaseClass;

public class TC_38_Verify_Tooltip_On_How_To_Page extends BaseClass
{
	Activate_Test_Kit_Locators activate_test_kit_locators;
	Activate_Test_Kit_Actions activate_test_kit_Actions;		
		
	@Test
	public void TC_38_Verify_tooltip_on_how_to_page() throws Exception
	{
		activate_test_kit_Actions = new Activate_Test_Kit_Actions(getDriver());	
		activate_test_kit_Actions.dashboardUrlOfTims();
		activate_test_kit_Actions.createSingleBarcodeFromTimsToUseInDashboardForEndToEndFlow();
		activate_test_kit_Actions.dashboardUrl();
		activate_test_kit_Actions.tooltipOnHowToPage();
	}

}
