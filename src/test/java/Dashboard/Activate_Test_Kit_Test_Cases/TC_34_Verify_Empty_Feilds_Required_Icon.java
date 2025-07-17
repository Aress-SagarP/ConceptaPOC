package Dashboard.Activate_Test_Kit_Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.Activate_Test_Kit_Actions;
import Test.Dashboard.Locators_Class.Activate_Test_Kit_Locators;
import initializer.BaseClass;

public class TC_34_Verify_Empty_Feilds_Required_Icon extends BaseClass
{

	Activate_Test_Kit_Locators activate_test_kit_locators;
	Activate_Test_Kit_Actions activate_test_kit_Actions;
		
	@Test
	public void TC_34_Verify_empty_feilds_required_icon() throws IOException, InterruptedException
	{
		activate_test_kit_Actions = new Activate_Test_Kit_Actions(getDriver());	
		activate_test_kit_Actions.dashboardUrl();
		activate_test_kit_Actions.emptyFeildsRequiredIcon();		
	}

}
