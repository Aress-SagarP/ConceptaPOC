package Dashboard.Create_Account_Test_Cases;

import org.testng.annotations.Test;
import Test.Dashboard.Actions_Class.Create_Account_Actions;
import Test.Dashboard.Actions_Class.Reset_Password_Actions;
import Test.Dashboard.Locators_Class.Create_Account_Locators;
import initializer.BaseClass;

public class TC_01_Verify_That_The_Create_Account_Page_Loads_Correctly extends BaseClass
{

	Create_Account_Locators create_account_locators;
	Create_Account_Actions create_account_actions;
	
	@Test
	public void TC_01_Verify_that_the_create_account_page_loads_correctly() throws Exception
	{				
		create_account_actions = new Create_Account_Actions(getDriver());		
		create_account_actions.dashboardUrl();
		create_account_actions.verifyAllFieldsDisplayed();
    }

}