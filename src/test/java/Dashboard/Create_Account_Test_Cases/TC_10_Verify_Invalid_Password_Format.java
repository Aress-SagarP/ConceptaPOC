package Dashboard.Create_Account_Test_Cases;

import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.Create_Account_Actions;
import Test.Dashboard.Locators_Class.Create_Account_Locators;
import initializer.BaseClass;

public class TC_10_Verify_Invalid_Password_Format extends BaseClass
{

	Create_Account_Locators create_account_locators;
	Create_Account_Actions create_account_actions;
	
	@Test
	public void TC_10_Verify_error_for_invalid_password() throws Exception
	{				
		create_account_actions = new Create_Account_Actions(getDriver());		
		create_account_actions.dashboardUrl();
		create_account_actions.invalidPasswordCheck();
    }

}
