package Dashboard.Activate_Test_Kit_Test_Cases;

import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.Activate_Test_Kit_Actions;
import Test.Dashboard.Locators_Class.Activate_Test_Kit_Locators;
import initializer.BaseClass;

public class TC_36_Verify_Personal_Details_Does_Not_Erase_If_Go_Back_Page extends BaseClass
{
	Activate_Test_Kit_Locators activate_test_kit_locators;
	Activate_Test_Kit_Actions activate_test_kit_Actions;		
		
	@Test
	public void TC_36_Verify_personal_details_does_not_erase_if_go_back_page() throws Exception
	{
		activate_test_kit_Actions = new Activate_Test_Kit_Actions(getDriver());	
		activate_test_kit_Actions.dashboardUrlOfTims();
		activate_test_kit_Actions.createSingleBarcodeFromTimsToUseInDashboardForEndToEndFlow();
		activate_test_kit_Actions.dashboardUrl();
		activate_test_kit_Actions.personalDetailsDoesNotEraseIfGoBackPage();
	}

}
